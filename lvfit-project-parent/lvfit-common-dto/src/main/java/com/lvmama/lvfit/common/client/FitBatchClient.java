package com.lvmama.lvfit.common.client;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvfit.common.client.path.BatchClientPath;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.request.FitOrderPassengerRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

/**
 * 批处理远程调用类
 * @author leizhengwei
 *
 */
@Component
public class FitBatchClient {

	/** 远程地址 */
	@Value("lvfit.batch.baseurl")
	private String baseUrl;

	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(FitBatchClient.class);


	/**
	 * 同步自主打包产品基本信息
	 * @param productId
	 * @return
	 */
	public ResultStatus syncSdpProductBasicInfo(Long productId) {
		BatchClientPath command = BatchClientPath.SYNC_SDP_PRODUCT_BASIC_INFO;
		String url = command.url(baseUrl, productId);
		try{
			return restClient.get(url, ResultStatus.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 同步自主打包产品单条索引
	 * @param productId
	 * @return
	 */
	public ResultStatus syncSdpProductSearchIndex(Long productId) {
		BatchClientPath command = BatchClientPath.SYNC_SDP_PRODUCT_SEARCH_INDEX;
		String url = command.url(baseUrl, productId);
		try{
			return restClient.get(url, ResultStatus.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 批量存储自主打包产品索引
	 * @return
	 */
	public ResultStatus syncAllUsefulSdpProductSearchIndex() {
		BatchClientPath command = BatchClientPath.SYNC_ALL_USEFUL_SDP_PRODUCT_SEARCH_INDEX;
		String url = command.url(baseUrl);
		try{
			return restClient.get(url, ResultStatus.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 存储同步时间信息到数据库
	 * @return
	 */
	public ResultStatus saveSynTimeInfo(FitSdpProductSyncMsgDto request){
		BatchClientPath command = BatchClientPath.SAVE_SYN_TIME_INFO;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, request);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
}



