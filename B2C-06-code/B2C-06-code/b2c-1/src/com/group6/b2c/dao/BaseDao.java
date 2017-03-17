package com.group6.b2c.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 * 完成向dbms传递sql，并且返回结果
 * @author ttc
 *
 */
public class BaseDao {
	private final static String URL = "jdbc:oracle:thin:@10.10.34.133:1521:orcl";
	private final static String SID = "g6";
	private final static String PWD = "123456";
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static{
		// 被调用一次并且仅一次
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			System.err.println("加载数据库失败"+DRIVER);
		}
		
	}
	
	public Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, SID, PWD);
		} catch (SQLException e) {
			System.err.println("建立连接失败"+e.getMessage());
		}
		return connection;
	}
	/**
	 * 执行SQL，返回影响记录的行数
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql, String[] args) {
		int i = -1;
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			if (connection == null) {
				return i;
			}
			ps = connection.prepareStatement(sql);
			if (args == null || args.length == 0) {

			} else {
				for (int j = 0; j < args.length; j++) {
					ps.setString(j + 1, args[j]);
				}
			}
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("执行Update 失败：" + sql);
			System.err.println("执行Update 失败：" + e.getMessage());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {

			}

		}
		return i;
	}

	public Result query(String sql, String[] args) {
		Result result = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			if (connection == null) {
				return result;
			}
			ps = connection.prepareStatement(sql);
			if (args == null || args.length == 0) {
			} else {
				for (int j = 0; j < args.length; j++) {
					ps.setString(j + 1, args[j]);
				}
			}
			rs = ps.executeQuery();
			result = ResultSupport.toResult(rs);
		} catch (SQLException e) {
			 System.err.println( "查询失败：" + sql );
			 System.err.println( "查询失败：" + e.getMessage() );
		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
}