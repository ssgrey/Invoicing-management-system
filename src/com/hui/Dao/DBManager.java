package com.hui.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.*;

public class DBManager {
	private BasicDataSource dataSource = null ;	
	
	private static DBManager dbManager = new DBManager() ;
	private DBManager(){
		InputStream is = DBManager.class.getClassLoader().getResourceAsStream(
				"com/hui/Dao/jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBManager getDBManager(){
		return dbManager;
	}
	
	/*
	 * 获取连接
	 */
	public Connection getConnection(){
		Connection conn = null ;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn ;
	}
	/**
	 *关闭资源
	 * @param conn
	 * @param stm
	 * @param rs
	 */
	public void closeResource(Connection conn , Statement stm , ResultSet rs){
		
		try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();	
			}finally{	
					try {
						if(stm!=null){
							stm.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();					
				   }finally{
					   try{
						   if(conn!=null){
							   conn.close();
						   }
					   }catch(SQLException e){
						   e.printStackTrace();
					   }
				   }
			}
	}
}
