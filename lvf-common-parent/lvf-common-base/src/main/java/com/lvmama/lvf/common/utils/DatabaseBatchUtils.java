package com.lvmama.lvf.common.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseBatchUtils {

	private final static Logger log = LoggerFactory
			.getLogger(DatabaseBatchUtils.class);

	public static void batchInsert(SqlSession session, String insertSql,
			Object[][] parameters) {
		Connection conn = null;
		PreparedStatement prep = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Boolean ac = null;
		try {
			conn = session.getConnection();
			ac = conn.getAutoCommit();
			conn.setAutoCommit(false);
			prep = conn.prepareStatement(insertSql);
			int batchSize = 0;
			for (Object[] obj : parameters) {
				batchSize++;
				for (int j = 0; j < obj.length; j++) {
					prep.setObject(j + 1, obj[j]);
				}
				// 事务整体添加
				prep.addBatch();
				if (batchSize == 2000) {
					batchSize = 0;
					prep.executeBatch();
					prep.clearBatch();
				}
			}
			prep.executeBatch();
			conn.commit();
		} catch (Exception ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
			log.error(ex.getMessage(), ex);
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != call) {
					call.close();
				}
				if (null != prep) {
					prep.close();
				}
				if (null != conn
						&& null!=ac) {
					conn.setAutoCommit(ac);
				}
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		}
	}
}
