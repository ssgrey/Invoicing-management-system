package com.hui.iFrame.GysGuanli;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import com.hui.Dao.Dao;
import com.hui.javaBean.TbGysInfo;

import KeyListener.InputKeyListener;

public class GysTianJiaPanel extends JPanel {
	private JTextField EMailF;
	private JTextField yinHangF;
	private JTextField lianXiRenDianHuaF;
	private JTextField lianXiRenF;
	private JTextField chuanZhenF;
	private JTextField dianHuaF;
	private JTextField diZhiF;
	private JTextField bianMaF;
	private JTextField jianChengF;
	private JTextField quanChengF;
	private JButton resetButton;
	public GysTianJiaPanel() {
		setLayout(new GridBagLayout());
		setBounds(10, 10, 510, 302);

		setupComponet(new JLabel("供应商全称"), 0, 0, 1, 1, false);

		quanChengF = new JTextField();
		setupComponet(quanChengF, 1, 0, 3, 400, true);

		setupComponet(new JLabel("简称"), 0, 1, 1, 1, false);

		jianChengF = new JTextField();
		setupComponet(jianChengF, 1, 1, 1, 160, true);

		setupComponet(new JLabel("编码"), 2, 1, 1, 1, false);
		bianMaF = new JTextField();
		bianMaF.addKeyListener(new InputKeyListener());
		setupComponet(bianMaF, 3, 1, 1, 0, true);

		setupComponet(new JLabel("地址"), 0, 2, 1, 1,false);
		diZhiF = new JTextField();
		setupComponet(diZhiF, 1, 2, 3, 0, true);

		setupComponet(new JLabel("电话"), 0, 3, 1, 1, false);
		dianHuaF = new JTextField();
		dianHuaF.addKeyListener(new InputKeyListener());
		setupComponet(dianHuaF, 1, 3, 1, 0, true);

		setupComponet(new JLabel("传真"), 2, 3, 1, 1, false);
		chuanZhenF = new JTextField();
		chuanZhenF.addKeyListener(new InputKeyListener());
		setupComponet(chuanZhenF, 3, 3, 1, 0, true);
		
		setupComponet(new JLabel("联系人"), 0, 4, 1, 1, false);
		lianXiRenF = new JTextField();
		setupComponet(lianXiRenF, 1, 4, 1, 0, true);

		setupComponet(new JLabel("联系人电话"), 2, 4, 1, 1, false);
		lianXiRenDianHuaF = new JTextField();
		lianXiRenDianHuaF.addKeyListener(new InputKeyListener());
		setupComponet(lianXiRenDianHuaF, 3, 4, 1, 0, true);

		setupComponet(new JLabel("银行"), 0, 5, 1, 1, false);
		yinHangF = new JTextField();
		setupComponet(yinHangF, 1, 5, 1, 0, true);

		setupComponet(new JLabel("邮件"), 2, 5, 1, 1, false);
		EMailF = new JTextField();
		setupComponet(EMailF, 3, 5, 1, 0, true);

		final JButton tjButton = new JButton();
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (diZhiF.getText().equals("")
						|| quanChengF.getText().equals("")
						|| chuanZhenF.getText().equals("")
						|| jianChengF.getText().equals("")
						|| yinHangF.getText().equals("")
						|| bianMaF.getText().equals("")
						|| diZhiF.getText().equals("")
						|| lianXiRenF.getText().equals("")
						|| lianXiRenDianHuaF.getText().equals("")
						|| EMailF.getText().equals("")
						|| dianHuaF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "����дȫ����Ϣ");
					return;
				}
				ResultSet haveUser = Dao
				.query("select * from tb_gysinfo where name='"
						+ quanChengF.getText().trim() + "'");
		try {
			if (haveUser.next()){
				System.out.println("error");
				JOptionPane.showMessageDialog(GysTianJiaPanel.this,
						"供应商已存在！", "信息提示",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		} catch (Exception er) {
			er.printStackTrace();
		}
		ResultSet set = Dao.query("select max(id) from tb_gysinfo");
		String id = null;
		try {
			if (set != null && set.next()) {
				String sid = set.getString(1).trim();
				if (sid == null)
					id = "gys1001";
				else {
					String str = sid.substring(3);
					id = "gys" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		TbGysInfo gysInfo = new TbGysInfo();
		gysInfo.setId(id);
		gysInfo.setAddress(diZhiF.getText().trim());
		gysInfo.setBianma(bianMaF.getText().trim());
		gysInfo.setFax(chuanZhenF.getText().trim());
		gysInfo.setYh(yinHangF.getText().trim());
		gysInfo.setJc(jianChengF.getText().trim());
		gysInfo.setName(quanChengF.getText().trim());
		gysInfo.setLian(lianXiRenF.getText().trim());
		gysInfo.setLtel(lianXiRenDianHuaF.getText().trim());
		gysInfo.setMail(EMailF.getText().trim());
		gysInfo.setTel(dianHuaF.getText().trim());
		Dao.addGys(gysInfo);
		JOptionPane.showMessageDialog(GysTianJiaPanel.this, "添加成功",
				"信息提示", JOptionPane.INFORMATION_MESSAGE);
		resetButton.doClick();
			}
		});
		tjButton.setText("添加");
		setupComponet(tjButton, 2, 6, 1, 0, false);

		resetButton = new JButton();
		setupComponet(resetButton, 3, 6, 1, 0, false);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				diZhiF.setText("");
				bianMaF.setText("");
				chuanZhenF.setText("");
				jianChengF.setText("");
				lianXiRenF.setText("");
				lianXiRenDianHuaF.setText("");
				EMailF.setText("");
				quanChengF.setText("");
				dianHuaF.setText("");
				yinHangF.setText("");
			}
		});
		resetButton.setText("重置");
	}
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		add(component, gridBagConstrains);
	}
}