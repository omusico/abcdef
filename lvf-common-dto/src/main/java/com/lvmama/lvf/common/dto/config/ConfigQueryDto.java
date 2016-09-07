package com.lvmama.lvf.common.dto.config;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfigQueryDto {

	private ConfigCode code;

	private ConfigModule module;

	private ConfigGroup configGroup;

	private ConfigKey configKey;

	public ConfigCode getCode() {
		return code;
	}

	public void setCode(ConfigCode code) {
		this.code = code;
	}

	public ConfigModule getModule() {
		return module;
	}

	public void setModule(ConfigModule module) {
		this.module = module;
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

}
