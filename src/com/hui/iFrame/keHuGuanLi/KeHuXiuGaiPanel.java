package com.hui.iFrame.keHuGuanLi;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.hui.Dao.Dao;
import com.hui.javaBean.Item;
import com.hui.javaBean.TbKhInfo;


public class KeHuXiuGaiPanel extends JPanel {
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
	private JButton modifyButton;
	private JButton delButton;
	private JComboBox kehu;
	public KeHuXiuGaiPanel() {
		setBounds(10, 10, 460, 300);
		setLayout(new GridBagLayout());
		setVisible(true);

		final JLabel khName = new JLabel();
		khName.setText("客户修改");
		setupComponet(khName, 0, 0, 1, 0, false);

		keHuQuanCheng = new JTextField();
		keHuQuanCheng.setEditable(false);

		setupComponet(keHuQuanCheng, 1, 0, 3, 350, true);

		final JLabel addressLabel = new JLabel("地址");
		setupComponet(addressLabel, 0, 1, 1, 0, false);

		diZhi = new JTextField();

		setupComponet(diZhi, 1, 1, 3, 0, true);

		setupComponet(new JLabel("客户简称"), 0, 2, 1, 0, false);
		keHuJianCheng = new JTextField();

		setupComponet(keHuJianCheng, 1, 2, 1, 130, true);

		setupComponet(new JLabel("邮政编码"), 2, 2, 1, 0, false);

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

		setupComponet(new JLabel("客户"), 0, 7, 1, 0, false);
		kehu = new JComboBox();
		kehu.setPreferredSize(new Dimension(230, 21));
		initComboBox();
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKeHuSelectAction();
			}
		});
		setupComponet(kehu, 1, 7, 2, 0, true);
		modifyButton = new JButton("修改");
		delButton = new JButton("删除");
		JPanel panel = new JPanel();
		panel.add(modifyButton);
		panel.add(delButton);
		setupComponet(panel, 3, 7, 1, 0, false);
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();
				if (item == null || !(item instanceof Item))
					return;
				int confirm = JOptionPane.showConfirmDialog(
						KeHuXiuGaiPanel.this, "确认删除？");
				if (confirm == JOptionPane.YES_OPTION) {
					int rs = Dao.delete("delete from tb_khinfo where id='"
							+ item.getId() + "'");
					if (rs > 0) {
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this,
								"客户" + item.getName() + "删除成功");
						kehu.removeItem(item);
					}
				}
			}
		});

		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();
				TbKhInfo khinfo = new TbKhInfo();
				khinfo.setId(item.getId());
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
				if (Dao.updateKeHu(khinfo) == 1)
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "更新成功！");
				else
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "更新失败！");
			}
		});
	}

	public void initComboBox() {
		List khInfo = Dao.getKhInfos();
		List<Item> items = new ArrayList<Item>();
		kehu.removeAllItems();
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))
				continue;
			items.add(item);
			kehu.addItem(item);
		}
		doKeHuSelectAction();
	}

	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		add(component, gridBagConstrains);
	}
	private void doKeHuSelectAction() {
		Item selectedItem;
		if (!(kehu.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item) kehu.getSelectedItem();
		TbKhInfo khInfo = Dao.getKhInfo(selectedItem);
		keHuQuanCheng.setText(khInfo.getKhname());
		diZhi.setText(khInfo.getAddress());
		keHuJianCheng.setText(khInfo.getJian());
		youZhengBianMa.setText(khInfo.getBianma());
		dianHua.setText(khInfo.getTel());
		chuanZhen.setText(khInfo.getFax());
		lianXiRen.setText(khInfo.getLian());
		lianXiDianHua.setText(khInfo.getLtel());
		EMail.setText(khInfo.getMail());
		kaiHuYinHang.setText(khInfo.getXinhang());
		yinHangZhangHao.setText(khInfo.getHao());
	}
	public class InputKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String key="-0123456789"+(char)8;
			if(key.indexOf(e.getKeyChar())<0){
				e.consume();
			}
		}
	}
}
