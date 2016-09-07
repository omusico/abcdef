package com.lvmama.lvf.common.utils;

import java.util.Map;

import com.lvmama.lvf.common.dto.enums.SmsKey;
import com.lvmama.lvf.common.dto.enums.SmsType;

public interface GeneratorSmsContext {
	
	public String generatorSmsContext(SmsType type,Map<String,String> values) throws Exception;

}
