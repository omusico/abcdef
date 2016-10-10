package com.lvmama.lvfit.mq.sdpproduct;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.lvmama.comm.jms.Message;
import com.lvmama.comm.jms.MessageProcesser;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.common.client.FitBatchClient;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;

public class FitSdpProductMessageRrocesser implements MessageProcesser{
	
	private static final Logger logger = LoggerFactory.getLogger(FitSdpProductMessageRrocesser.class);
	
	@Autowired
	private FitBatchClient  fitBatchClient;

	@Autowired
	private FitSearchClient fitSearchClient;

	@Value("sync.startProductId")
	private String startProductId;

	@Value("sync.endProductId")
	private String endProductId;

	@Override
	public void process(Message message) {
		
		String gid = UUID.randomUUID().toString();
		long beg =System.currentTimeMillis();
		Long productId = message.getObjectId();
        Long startId = this.getStartProductId();
		Long endId = this.getEndProductId();
		if(productId.intValue()< startId.intValue() || productId.intValue() > endId.intValue()){
			logger.error("产品【"+productId+"】消息处理产品基本信息结束，不符合产品处理范围");
			return;
		}

		try {
			JudgeType isAutoPackageProduct = fitSearchClient.searchProductProp(productId);
			if (isAutoPackageProduct==JudgeType.N){
				return;
			}
		}catch (Exception e){
			logger.error("查询产品是否为自主打包产品出错：",e);
		}

		//自主打包产品处理逻辑
		try {
			logger.error("产品【"+productId+"】【"+JSONMapper.getInstance().writeValueAsString(message)+"】处理开始,gid【"+gid+"】");
		} catch (Exception e) {
			logger.error("序列化产品出错：",e);
		}
		//判断缓存中是否存在
		
		String isFitProduct = MemcachedUtil.getInstance().get("fit_"+productId);
		if(StringUtils.isNotBlank(isFitProduct)&&isFitProduct.equals(JudgeType.N.name())){
			long end1 =System.currentTimeMillis();
		    logger.error("产品【"+productId+"】消息处理产品基本信息结束，耗时【"+(end1-beg)+"】状态无需处理gid【"+gid+"】");
		}else{
			//同步时间信息存到数据库
			FitSdpProductSyncMsgDto syncMsgDto = new FitSdpProductSyncMsgDto();
			syncMsgDto.setProductId(productId);
			ResultStatus syncSdpProductResultStatus = fitBatchClient.syncSdpProductBasicInfo(productId);
			long end1 =System.currentTimeMillis();
		    logger.error("产品【"+productId+"】消息处理产品基本信息结束，耗时【"+(end1-beg)+"】状态【"+syncSdpProductResultStatus.name()+"】gid【"+gid+"】");
		    syncMsgDto.setProductSyncTime(end1-beg);
		    syncMsgDto.setProductSyncStatus(syncSdpProductResultStatus);
		    if(syncSdpProductResultStatus==ResultStatus.SUCCESS){
		    	long beg2 =System.currentTimeMillis();
		    	ResultStatus syncSdpProductIndexResultStatus = 	fitBatchClient.syncSdpProductSearchIndex(productId);
				long end2 =System.currentTimeMillis();
				syncMsgDto.setIndexSyncTime(end2-beg2);
			    logger.error("产品【"+productId+"】消息处理产品索引结束，耗时【"+(end2-beg)+"】状态【"+syncSdpProductIndexResultStatus.name()+"】gid【"+gid+"】");
			    syncMsgDto.setIndexSyncStatus(syncSdpProductIndexResultStatus);
		    }
		    fitBatchClient.saveSynTimeInfo(syncMsgDto);
		}
		
	}


	public Long getStartProductId() {
		return Long.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(startProductId)+"");
	}

	public Long getEndProductId() {
		return Long.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(endProductId)+"");
	}

}
