package com.hui.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import com.hui.Dao.Dao;

import mainFrame.MainFrame;


public class LoginDialog extends JFrame {
	
	private LoginPanel loginPanel = null ;
	private JLabel userLabel = null ;
	private JLabel pswLabel = null ;
	private JTextField userField = null ;
	private JPasswordField passwordField = null;
	private JButton loginButton = null ;
	private JButton exitButton = null ;
	private String username = null ;
	private MainFrame main = null ;
	
	
	
	public static void main(String[] args){
		
		LoginDialog login = new LoginDialog();
		login.setVisible(true);

	}
	

	
	public LoginDialog(){
		//设置主题与系统一致
		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		main = new MainFrame() ;
		initialize();
	}

	private void initialize() {
		Dimension size = this.getToolkit().getScreenSize();
		this.setBounds((size.width-300)/2,(size.height-200)/2, 300,200);
		this.setResizable(false);
		this.setTitle("登录");
		this.setContentPane(getLoginPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private LoginPanel getLoginPanel() {
		if(loginPanel == null){
			loginPanel = new LoginPanel();
			loginPanel.setBackground(new Color(0xD8DDC7));
			userLabel = new JLabel("用户名:");
			pswLabel = new JLabel("密码:");
			userLabel.setBounds(80, 40, 50, 20);
			pswLabel.setBounds(80, 70, 50, 20);
			loginPanel.setLayout(null);
			loginPanel.add(userLabel);
			loginPanel.add(pswLabel);
			loginPanel.add(getUserField());
			loginPanel.add(getPswField());
			loginPanel.add(getLoginButton());
			loginPanel.add(getExitButton());
		}
		return loginPanel;
	}

	private JButton getExitButton() {
		if(exitButton == null){
			exitButton = new JButton("退出");
			exitButton.setBounds(180, 110, 60, 20);
			exitButton.addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitButton;
	}

	private JButton getLoginButton() {
		if(loginButton == null){
			loginButton = new JButton("登录");
			loginButton.setBounds(80, 110, 60, 20);
			loginButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {					
					username = userField.getText();
					String psw = new String(passwordField.getPassword());	
					if (!Dao.checkLogin(username, psw)) {
						JOptionPane.showMessageDialog(LoginDialog.this,
								"账户或密码错误", "登陆信息！",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				
				main.setDefaultCloseOperation(EXIT_ON_CLOSE);
				main.setVisible(true);
				MainFrame.getCzyStateLabel().setText(username);
				setVisible(false);
					
				}
			});
		}
		return loginButton;
	}

	private JPasswordField getPswField() {
		if(passwordField == null){
			passwordField = new JPasswordField();
			passwordField.setText("123456");
			passwordField.setBounds(new Rectangle(150, 70, 100, 20));
			passwordField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					if(e.getKeyChar() == '\n'){
						loginButton.doClick();
					}
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return passwordField;
	}

	private JTextField getUserField() {
		if(userField == null){
			userField = new JTextField();
			userField.setText("hui");
			userField.setBounds(new Rectangle(150, 40, 100, 20));
		}
		return userField;
	}
}
