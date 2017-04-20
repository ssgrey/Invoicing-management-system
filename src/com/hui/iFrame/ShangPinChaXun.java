package com.hui.iFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.hui.Dao.Dao;
import com.hui.javaBean.Item;
import com.hui.javaBean.TbSpinfo;

public class ShangPinChaXun extends JInternalFrame {
	private JTable table;
	private JTextField conditionContent;
	private JComboBox conditionOperation;
	private JComboBox conditionName;
	public ShangPinChaXun() {
		super();
		setIconifiable(true);
		setClosable(true);
		setTitle("商品查询");
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 650, 375);

		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[]{"id", "商品名称", "简称", "产地", "单位",
				"规格", "包装", "电话", "批准文号", "文号", "供应商",};
		dftm.setColumnIdentifiers(tableHeads);

		final JScrollPane scrollPane = new JScrollPane(table);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 0, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);

		setupComponet(new JLabel("条件"), 0, 0, 1, 1, false);
		conditionName = new JComboBox();
		conditionName.setModel(new DefaultComboBoxModel(new String[]{"商品名称",
				"产地", "规格", "供应商"}));
		setupComponet(conditionName, 1, 0, 1, 30, true);

		conditionOperation = new JComboBox();
		conditionOperation.setModel(new DefaultComboBoxModel(new String[]{"等于",
				"包含"}));
		setupComponet(conditionOperation, 2, 0, 1, 30, true);

		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);

		final JButton queryButton = new JButton();
		queryButton.addActionListener(new QueryAction(dftm));
		setupComponet(queryButton, 4, 0, 1, 1, false);
		queryButton.setText("查询");

		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				conditionContent.setText("");
				List list = Dao.getSpInfos();
				updateTable(list, dftm);
			}
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("显示全部");
	}

	private void updateTable(List list, final DefaultTableModel dftm) {
		int num = dftm.getRowCount();
		for (int i = 0; i < num; i++)
			dftm.removeRow(0);
		Iterator iterator = list.iterator();
		TbSpinfo spInfo;
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			spInfo = Dao.getSpInfo(item);//再次查询
			Vector rowData = new Vector();
			rowData.add(spInfo.getId().trim());
			rowData.add(spInfo.getSpname().trim());
			rowData.add(spInfo.getJc());
			rowData.add(spInfo.getCd());
			rowData.add(spInfo.getDw());
			rowData.add(spInfo.getGg());
			rowData.add(spInfo.getBz());
			rowData.add(spInfo.getPh());
			rowData.add(spInfo.getPzwh());
			rowData.add(spInfo.getGysname());
			rowData.add(spInfo.getMemo());
			dftm.addRow(rowData);
		}
	}
	// �������λ�ò���ӵ�������
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
		getContentPane().add(component, gridBagConstrains);
	}
	private final class QueryAction implements ActionListener {
		private final DefaultTableModel dftm;
		private QueryAction(DefaultTableModel dftm) {
			this.dftm = dftm;
		}
		public void actionPerformed(final ActionEvent e) {
			String conName, conOperation, content;
			conName = conditionName.getSelectedItem().toString().trim();
			conOperation = conditionOperation.getSelectedItem().toString();
			content = conditionContent.getText().trim();
			List list = null;
			list = searchInfo(conName, conOperation, content, list);
			updateTable(list, dftm);
		}
		private List searchInfo(String conName, String conOperation,
				String content, List list) {
			String sql = "select * from Tb_Spinfo where ";
			if (conOperation.equals("等于")) {
				if (conName.equals("商品名称"))
					list = Dao.findForList(sql + "spname='" + content + "'");
				if (conName.equals("供应商"))
					list = Dao.findForList(sql + "gysname='" + content + "'");
				if (conName.equals("产地"))
					list = Dao.findForList(sql + "cd='" + content + "'");
				if (conName.equals("规格"))
					list = Dao.findForList(sql + "gg='" + content + "'");
			} else {
				if (conName.equals("商品名称"))
					list = Dao.findForList(sql + "spname like '%" + content
							+ "%'");
				if (conName.equals("供应商"))
					list = Dao.findForList(sql + "gysname like '%" + content
							+ "%'");
				if (conName.equals("产地"))
					list = Dao.findForList(sql + "cd like '%" + content + "%'");
				if (conName.equals("规格"))
					list = Dao.findForList(sql + "gg like '%" + content + "%'");
			}
			return list;
		}
	}
}
