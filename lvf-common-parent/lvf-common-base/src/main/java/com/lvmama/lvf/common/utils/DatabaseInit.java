package com.lvmama.lvf.common.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseInit {

    private String location;
    @Autowired
    private DataSource dataSource;

    public DatabaseInit(String location, boolean shouldInit) {
        super();
        this.location = location;
    }

    @PostConstruct
    public void init() throws IOException {
    	
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String[] sqlLines = sqlContent().split(";");
        for (int i = 0; i < sqlLines.length; i++) {
            String sql = sqlLines[i].trim();
            if (sql.isEmpty() || sql.startsWith("--")) {
                continue;
            }
            try {
                template.update(sql);
            } catch (DataAccessException e) {
                throw new RuntimeException("Error executing sql: " + sql, e);
            }
        }
    }

    private String sqlContent() throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(location);
        return IOUtils.toString(stream, "UTF-8");
    }
}
