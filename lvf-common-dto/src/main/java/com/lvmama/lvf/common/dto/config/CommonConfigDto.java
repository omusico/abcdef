package com.lvmama.lvf.common.dto.config;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;

@XmlRootElement
public class CommonConfigDto extends AEEntity implements Serializable {

	/**用于哪类业务**/
	private ConfigModule configModule;

	/**用于哪组产品**/
	private ConfigGroup configGroup;
	
	/**
	 * 配置项具体编码
	 */
	private ConfigCode code;
	
	/**
	 * 键
	 */
	private ConfigKey configKey;

	private String val;

	private String clob;

	public ConfigCode getCode() {
		return code;
	}

	public void setCode(ConfigCode code) {
		this.code = code;
	}

	public ConfigGroup getConfigGroup() {
		return configGroup;
	}

	public void setConfigGroup(ConfigGroup configGroup) {
		this.configGroup = configGroup;
	}

	public ConfigKey getConfigKey() {
		return configKey;
	}

	public void setConfigKey(ConfigKey configKey) {
		this.configKey = configKey;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getClob() {
		return clob;
	}

	public void setClob(String clob) {
		this.clob = clob;
	}

	public ConfigModule getConfigModule() {
		return configModule;
	}

	public void setConfigModule(ConfigModule configModule) {
		this.configModule = configModule;
	}

	

}