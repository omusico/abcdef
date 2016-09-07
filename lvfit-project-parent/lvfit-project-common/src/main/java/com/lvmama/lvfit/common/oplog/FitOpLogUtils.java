package com.lvmama.lvfit.common.oplog;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;
import com.lvmama.lvfit.common.dto.FitOpLog;
import com.lvmama.lvfit.common.dto.request.FitOpLogQueryRequest;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOpLogMapper;

@Component
public class FitOpLogUtils {
    private static Logger logger = LoggerFactory.getLogger(FitOpLogUtils.class);
    
    @Autowired
    private FitOpLogMapper fitOpMapper;

    public Boolean save(FitOpLog fitOpLog) {
        try {
            String remark = fitOpLog.getRemark();
            if (StringUtils.isNotEmpty(remark)) {
                remark = ZipUnZipUtils.getInstance().zipString2Base64(remark);
            }
            fitOpLog.setRemark(remark);
            
            String detail = fitOpLog.getDetail();
            if (StringUtils.isNotEmpty(detail)) {
                detail = ZipUnZipUtils.getInstance().zipString2Base64(detail);
            }
            fitOpLog.setDetail(detail);
            
            String requestStr = fitOpLog.getRequestStr();
            if (StringUtils.isNotEmpty(requestStr)) {
                requestStr = ZipUnZipUtils.getInstance().zipString2Base64(requestStr);
            }
            fitOpLog.setRequestStr(requestStr);
            int result = fitOpMapper.insert(fitOpLog);
            if (result > 0) {
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("插入操作日志失败：" + e);
        }
        return false;
    }

    public List<FitOpLog> query(BaseQueryDto<FitOpLogQueryRequest> q) {
        
        try {
            List<FitOpLog> list = fitOpMapper.query(q);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count(BaseQueryDto<FitOpLogQueryRequest> q) {
        return fitOpMapper.count(q);
    }

}
