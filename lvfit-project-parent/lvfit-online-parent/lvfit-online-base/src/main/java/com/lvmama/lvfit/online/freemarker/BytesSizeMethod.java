package com.lvmama.lvfit.online.freemarker;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.CharUtils;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * Created by luoweiyi on 2015/6/16.
 */
public class BytesSizeMethod implements TemplateMethodModel {
    @Override
    public Object exec(List arg) throws TemplateModelException {
        if(CollectionUtils.isEmpty(arg))
            return 0;
        Object obj = arg.get(0);
        if(null == obj)
            return 0;

        Long num = 0L;
        String str = obj.toString();
        for(int i = 0; i < str.length() ; i++){
            if(CharUtils.isAscii(str.charAt(i)))
                num++;
            else
                num+=2;
        }
        return num;
    }
}
