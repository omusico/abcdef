package com.lvmama.lvf.common.utils;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.PersistenceType;

/**
 * 主键生成器
 * @date   2015-3-11
 */
@Component
public class PkIdGenerator 
{
	@Autowired(required=false)
    private DataSource dataSource;
	
	public <T extends Entity> Long getPkId(T T) 
	{
		String sequence = T.getSequence();
		if(StringUtils.isEmpty(sequence))
			throw new IllegalArgumentException("请覆盖getSequence()方法，设置实体对应表的序列！");
		
		T.setPtype(PersistenceType.INSERT);
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "SELECT " + T.getSequence() + ".NEXTVAL FROM DUAL";
		return template.queryForLong(sql);
	}

}
