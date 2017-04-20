package com.hui.login;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.*;

import org.junit.Ignore;
import org.junit.Test;

import com.hui.Dao.DBManager;

import mainFrame.MainFrame;

public class TestLogin {

	public static void main(String[] args){
		//LoginDialog login = new LoginDialog();
		//login.setVisible(true);
		//MainFrame main = new MainFrame() ;
		//main.setVisible(true);
	
	}
	 
	/*@Test  public void testLogin(){
		LoginDialog login = new LoginDialog();
		login.setVisible(true);
	}*/
	
	
	@Test @Ignore public void connect(){
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		Connection conn = DBManager.getDBManager().getConnection();
		try {
			 pst = conn.prepareStatement("select count(*) from tb_sell_detail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			 rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
