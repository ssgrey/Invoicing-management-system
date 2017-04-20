package com.hui.iFrame.keHuGuanLi;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import com.hui.Dao.Dao;
import com.hui.javaBean.TbKhInfo;

import KeyListener.InputKeyListener;


public class KeHuTianJiaPanel extends JPanel {
	private JTextField keHuQuanCheng;
	private JTextField yinHangZhangHao;
	private JTextField kaiHuYinHang;
	private JTextField EMail;
	private JTextField lianXiDianHua;
	private JTextField lianXiRen;
	private JTextField chuanZhen;
	private JTextField dianHua;
	private JTextField youZhengBianMa;
	private JTextField diZhi;
	private JTextField keHuJianCheng;
	private JButton resetButton;
	public KeHuTianJiaPanel() {
		super();
		setBounds(10, 10, 460, 300);
		setLayout(new GridBagLayout());
		setVisible(true);
		final JLabel khName = new JLabel();
		khName.setText("客户名");
		setupComponet(khName, 0, 0, 1, 0, false);
		keHuQuanCheng = new JTextField();
		setupComponet(keHuQuanCheng, 1, 0, 3, 350, true);
		final JLabel addressLabel = new JLabel("地址");
		setupComponet(addressLabel, 0, 1, 1, 0, false);
		diZhi = new JTextField();
		setupComponet(diZhi, 1, 1, 3, 0, true);
		final JLabel jc = new JLabel();
		jc.setText("简称");
		setupComponet(jc, 0, 2, 1, 0, false);
		keHuJianCheng = new JTextField();
		setupComponet(keHuJianCheng, 1, 2, 1, 100, true);
		setupComponet(new JLabel("邮编"), 2, 2, 1, 0, false);
		youZhengBianMa = new JTextField();
		setupComponet(youZhengBianMa, 3, 2, 1, 100, true);
		youZhengBianMa.addKeyListener(new InputKeyListener());
		setupComponet(new JLabel("电话"), 0, 3, 1, 0, false);
		dianHua = new JTextField();

		setupComponet(dianHua, 1, 3, 1, 100, true);
		dianHua.addKeyListener(new InputKeyListener());
		setupComponet(new JLabel("传真"), 2, 3, 1, 0, false);
		chuanZhen = new JTextField();

		chuanZhen.addKeyListener(new InputKeyListener());
		setupComponet(chuanZhen, 3, 3, 1, 100, true);
		setupComponet(new JLabel("联系人"), 0, 4, 1, 0, false);
		lianXiRen = new JTextField();
		setupComponet(lianXiRen, 1, 4, 1, 100, true);
		setupComponet(new JLabel("联系电话"), 2, 4, 1, 0, false);
		lianXiDianHua = new JTextField();
		setupComponet(lianXiDianHua, 3, 4, 1, 100, true);
		lianXiDianHua.addKeyListener(new InputKeyListener());
		setupComponet(new JLabel("E-Mail"), 0, 5, 1, 0, false);
		EMail = new JTextField();
		setupComponet(EMail, 1, 5, 3, 350, true);
		setupComponet(new JLabel("开户银行"), 0, 6, 1, 0, false);
		kaiHuYinHang = new JTextField();

		setupComponet(kaiHuYinHang, 1, 6, 1, 100, true);
		setupComponet(new JLabel("银行账号"), 2, 6, 1, 0, false);
		yinHangZhangHao = new JTextField();

		setupComponet(yinHangZhangHao, 3, 6, 1, 100, true);
		final JButton saveButton = new JButton("保存");

		setupComponet(saveButton, 1, 7, 1, 0, false);
		saveButton.addActionListener(new SaveButtonActionListener());
		resetButton = new JButton("重置");

		setupComponet(resetButton, 3, 7, 1, 0, false);
		resetButton.addActionListener(new ChongZheButtonActionListener());
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

	private final class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			if (diZhi.getText().equals("")
					|| youZhengBianMa.getText().equals("")
					|| chuanZhen.getText().equals("")
					|| yinHangZhangHao.getText().equals("")
					|| keHuJianCheng.getText().equals("")
					|| keHuQuanCheng.getText().equals("")
					|| lianXiRen.getText().equals("")
					|| lianXiDianHua.getText().equals("")
					|| EMail.getText().equals("")
					|| dianHua.getText().equals("")
					|| kaiHuYinHang.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "有信息为空，请补全信息！");
				return;
			}
			ResultSet haveUser = Dao
					.query("select * from tb_khinfo where khname='"
							+ keHuQuanCheng.getText().trim() + "'");
			try {
				if (haveUser.next()){
					System.out.println("error");
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this,
							"客户信息已存在", "错误信息",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = Dao.query("select max(id) from tb_khinfo");
			String id = null;
			try {
				if (set != null && set.next()) {
					String sid = set.getString(1);
					if (sid == null)
						id = "kh1001";
					else {
						String str = sid.substring(2);
						id = "kh" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			TbKhInfo khinfo = new TbKhInfo();
			khinfo.setId(id);
			khinfo.setAddress(diZhi.getText().trim());
			khinfo.setBianma(youZhengBianMa.getText().trim());
			khinfo.setFax(chuanZhen.getText().trim());
			khinfo.setHao(yinHangZhangHao.getText().trim());
			khinfo.setJian(keHuJianCheng.getText().trim());
			khinfo.setKhname(keHuQuanCheng.getText().trim());
			khinfo.setLian(lianXiRen.getText().trim());
			khinfo.setLtel(lianXiDianHua.getText().trim());
			khinfo.setMail(EMail.getText().trim());
			khinfo.setTel(dianHua.getText().trim());
			khinfo.setXinhang(kaiHuYinHang.getText());
			Dao.addKeHu(khinfo);
			JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "添加成功",
					"信息提示", JOptionPane.INFORMATION_MESSAGE);
			resetButton.doClick();
		}
	}

	private class ChongZheButtonActionListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			keHuQuanCheng.setText("");
			yinHangZhangHao.setText("");
			kaiHuYinHang.setText("");
			EMail.setText("");
			lianXiDianHua.setText("");
			lianXiRen.setText("");
			chuanZhen.setText("");
			dianHua.setText("");
			youZhengBianMa.setText("");
			diZhi.setText("");
			keHuJianCheng.setText("");
		}
	}
	

}