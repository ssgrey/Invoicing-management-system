package com.hui.iFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import com.hui.Dao.Dao;
import com.hui.javaBean.TbJsr;

public class XiaoShouChaXun extends JInternalFrame{
	private JButton queryButton;
	private JTextField endDate;
	private JTextField startDate;
	private JTable table;
	private JTextField content;
	private JComboBox operation;
	private JComboBox condition;
	private TbJsr user;
	private DefaultTableModel dftm;
	private JCheckBox selectDate;
	public XiaoShouChaXun() {
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameActivated(final InternalFrameEvent e) {
				java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
				endDate.setText(date.toString());
				date.setMonth(0);
				date.setDate(1);
				startDate.setText(date.toString());
			}
		});
		setIconifiable(true);
		setClosable(true);
		setTitle("销售查询");
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 680, 375);

		setupComponet(new JLabel("查询条件"), 0, 0, 1, 1, false);
		condition = new JComboBox();
		condition.setModel(new DefaultComboBoxModel(new String[] {"客户全称", "销售票号"}));
		setupComponet(condition, 1, 0, 1, 30, true);

		operation = new JComboBox();
		operation.setModel(new DefaultComboBoxModel(new String[]{"等于", "包含"}));
		setupComponet(operation, 4, 0, 1, 30, true);

		content = new JTextField();
		content.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				if(e.getKeyCode()==10) {
					queryButton.doClick();
				}
			}
		});
		setupComponet(content, 5, 0, 2, 240, true);

		queryButton = new JButton();
		queryButton.addActionListener(new QueryAction());
		setupComponet(queryButton, 7, 0, 1, 1, false);
		queryButton.setText("查询");

		selectDate = new JCheckBox();
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.anchor = GridBagConstraints.EAST;
		gridBagConstraints_7.insets = new Insets(0, 10, 0, 0);
		gridBagConstraints_7.gridy = 1;
		gridBagConstraints_7.gridx = 0;
		getContentPane().add(selectDate, gridBagConstraints_7);

		final JLabel label_1 = new JLabel();
		label_1.setText("开始时间");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 1;
		gridBagConstraints_8.gridx = 1;
		getContentPane().add(label_1, gridBagConstraints_8);

		startDate = new JTextField();
		startDate.setPreferredSize(new Dimension(100,21));
		setupComponet(startDate, 2, 1, 3, 1, true);

		setupComponet(new JLabel("结束时间"), 5, 1, 1, 1, false);

		endDate = new JTextField();
		endDate.addKeyListener(content.getKeyListeners()[0]);
		endDate.setPreferredSize(new Dimension(100,21));
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.ipadx = 90;
		gridBagConstraints_11.anchor = GridBagConstraints.WEST;
		gridBagConstraints_11.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_11.gridy = 1;
		gridBagConstraints_11.gridx = 6;
		getContentPane().add(endDate, gridBagConstraints_11);

		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				content.setText("");
				List list=Dao.findForList("select * from v_sellView");//销售视图
				Iterator iterator=list.iterator();
				updateTable(iterator);
			}
		});
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_5.gridy = 1;
		gridBagConstraints_5.gridx = 7;
		getContentPane().add(showAllButton, gridBagConstraints_5);
		showAllButton.setFont(new Font("", Font.PLAIN, 12));
		showAllButton.setText("显示");

		final JScrollPane scrollPane = new JScrollPane();
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 5, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 9;
		gridBagConstraints_6.gridy = 2;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);

		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dftm = (DefaultTableModel)table.getModel();
		String[] tableHeads = new String[]{"sellID", "产品名称", "产品id", "规格", "单价",
				"数量", "金额", "客户", "时间", "操作员", "经手人", "支付方式ʽ"};
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);
	}

	private void updateTable(Iterator iterator) {
		int rowCount=dftm.getRowCount();
		for(int i=0;i<rowCount;i++) {
			dftm.removeRow(0);
		}
		while(iterator.hasNext()) {
			Vector vector=new Vector();
			List view=(List) iterator.next();
			vector.addAll(view);
			dftm.addRow(vector);
		}
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
		getContentPane().add(component, gridBagConstrains);
	}
	private final class QueryAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			boolean selDate = selectDate.isSelected();
			if(content.getText().equals("")) {
				JOptionPane.showMessageDialog(getContentPane(), "内容为空");
				return;
			}
			if(selDate) {
				if(startDate.getText()==null||startDate.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "请填写起始时间");
					return;
				}
				if(endDate.getText()==null||endDate.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "请选择结束时间");
					return;
				}
			}
			List list=null;
			String con = condition.getSelectedIndex() == 0
					? "khname "
					: "sellId ";
			int oper = operation.getSelectedIndex();
			String opstr = oper == 0 ? "= " : "like ";
			String cont = content.getText();
			list = Dao.findForList("select * from v_sellView where "
					+ con
					+ opstr
					+ (oper == 0 ? "'"+cont+"'" : "'%" + cont + "%'")
					+ (selDate ? " and xsdate>'" + startDate.getText()
							+ "' and xsdate<='" + endDate.getText()+" 23:59:59'" : ""));
			Iterator iterator = list.iterator();
			updateTable(iterator);
		}
	}
}
