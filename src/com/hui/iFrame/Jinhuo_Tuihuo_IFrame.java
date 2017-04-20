package com.hui.iFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.table.*;
import javax.swing.JComboBox;

public class Jinhuo_Tuihuo_IFrame extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel topPanel = null;

	private JPanel bottomPanel = null;

	private JScrollPane tablePane = null;

	private JTable table = null;

	private JLabel idLabel = null;

	private JTextField idField = null;

	private JLabel gysLabel = null;

	private JTextField gysField = null;

	private JLabel lxrLabel = null;

	private JTextField lxrField = null;

	private JLabel jsfsLabel = null;

	private JComboBox jsfsComboBox = null;

	private JLabel thsjLabel = null;

	private JTextField thsjField = null;

	private JLabel jsrLabel = null;

	private JTextField jsrField = null;

	private JLabel pzslLabel = null;

	private JTextField pzslField = null;

	private JLabel hpzsLabel = null;

	private JTextField hpzsField = null;

	private JLabel hjjeLabel = null;

	private JTextField hjjeField = null;

	private JLabel ysjlLabel = null;

	private JTextField ysjlField = null;

	private JLabel czyLabel = null;

	private JTextField czyField = null;

	private JButton tjButton = null;

	private JButton thButton = null;

	private JComboBox spComboBox = null;  //  @jve:decl-index=0:visual-constraint="612,10"

	/**
	 * This is the xxx default constructor
	 */
	public Jinhuo_Tuihuo_IFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 320);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setTitle("进货退货");
		this.setClosable(true);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getTopPanel(), BorderLayout.NORTH);
			jContentPane.add(getBottomPanel(), BorderLayout.SOUTH);
			jContentPane.add(getTablePane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes topPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getTopPanel() {
		if (topPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 9;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridy = 1;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.gridx = 8;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 5;
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridy = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridy = 1;
			gridBagConstraints8.gridx = 4;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.gridy = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.gridx = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 9;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.fill = GridBagConstraints.NONE;
			gridBagConstraints4.gridx = 8;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 5;
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.gridx = 4;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(0, 0, 0, 1);
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridy = 0;
			gridBagConstraints.gridx = 0;
			jsrLabel = new JLabel();
			jsrLabel.setText("经手人");
			thsjLabel = new JLabel();
			thsjLabel.setText("退货数量");
			jsfsLabel = new JLabel();
			jsfsLabel.setText("结算方式");
			lxrLabel = new JLabel();
			lxrLabel.setText("联系人");
			gysLabel = new JLabel();
			gysLabel.setText("供应商");
			idLabel = new JLabel();
			idLabel.setText("退货票号");
			topPanel = new JPanel();
			topPanel.setLayout(new GridBagLayout());
			topPanel.add(idLabel, gridBagConstraints);
			topPanel.add(getIdField(), gridBagConstraints1);
			topPanel.add(gysLabel, gridBagConstraints2);
			topPanel.add(getGysField(), gridBagConstraints3);
			topPanel.add(lxrLabel, gridBagConstraints4);
			topPanel.add(getLxrField(), gridBagConstraints5);
			topPanel.add(jsfsLabel, gridBagConstraints6);
			topPanel.add(getJsfsComboBox(), gridBagConstraints7);
			topPanel.add(thsjLabel, gridBagConstraints8);
			topPanel.add(getThsjField(), gridBagConstraints9);
			topPanel.add(jsrLabel, gridBagConstraints10);
			topPanel.add(getJsrField(), gridBagConstraints11);
		}
		return topPanel;
	}

	/**
	 * This method initializes bottomPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 6;
			gridBagConstraints23.fill = GridBagConstraints.NONE;
			gridBagConstraints23.gridy = 1;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 5;
			gridBagConstraints22.gridy = 1;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridx = 3;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 2;
			gridBagConstraints20.gridy = 1;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridy = 1;
			gridBagConstraints19.weightx = 1.0;
			gridBagConstraints19.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints19.gridx = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 1;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.anchor = GridBagConstraints.WEST;
			gridBagConstraints17.gridwidth = 2;
			gridBagConstraints17.gridx = 5;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 4;
			gridBagConstraints16.gridy = 0;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridy = 0;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints15.gridx = 3;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 2;
			gridBagConstraints14.gridy = 0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridy = 0;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints13.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.gridy = 0;
			czyLabel = new JLabel();
			czyLabel.setText("操作员");
			ysjlLabel = new JLabel();
			ysjlLabel.setText("验收结论");
			hjjeLabel = new JLabel();
			hjjeLabel.setText("hj金额");
			hpzsLabel = new JLabel();
			hpzsLabel.setText("货品总数");
			pzslLabel = new JLabel();
			pzslLabel.setText("品种数量");
			bottomPanel = new JPanel();
			bottomPanel.setLayout(new GridBagLayout());
			bottomPanel.add(pzslLabel, gridBagConstraints12);
			bottomPanel.add(getPzslField(), gridBagConstraints13);
			bottomPanel.add(hpzsLabel, gridBagConstraints14);
			bottomPanel.add(getHpzsField(), gridBagConstraints15);
			bottomPanel.add(hjjeLabel, gridBagConstraints16);
			bottomPanel.add(getHjjeField(), gridBagConstraints17);
			bottomPanel.add(ysjlLabel, gridBagConstraints18);
			bottomPanel.add(getYsjlField(), gridBagConstraints19);
			bottomPanel.add(czyLabel, gridBagConstraints20);
			bottomPanel.add(getCzyField(), gridBagConstraints21);
			bottomPanel.add(getTjButton(), gridBagConstraints22);
			bottomPanel.add(getThButton(), gridBagConstraints23);
		}
		return bottomPanel;
	}

	/**
	 * This method initializes tablePane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getTablePane() {
		if (tablePane == null) {
			tablePane = new JScrollPane();
			tablePane.setViewportView(getTable());
		}
		return tablePane;
	}

	/**
	 * This method initializes table
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			String[] columnNames = { "商品名称", "商品编号", "产地", "单位", "规格", "包装",
					"单价", "数量"};
			((DefaultTableModel) table.getModel())
					.setColumnIdentifiers(columnNames);
			TableColumn column = table.getColumnModel().getColumn(0);
			final DefaultCellEditor editor = new DefaultCellEditor(
					getSpComboBox());
			editor.setClickCountToStart(2);
			column.setCellEditor(editor);
		}
		return table;
	}

	/**
	 * This method initializes idField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getIdField() {
		if (idField == null) {
			idField = new JTextField();
		}
		return idField;
	}

	/**
	 * This method initializes gysField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getGysField() {
		if (gysField == null) {
			gysField = new JTextField();
		}
		return gysField;
	}

	/**
	 * This method initializes lxrField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getLxrField() {
		if (lxrField == null) {
			lxrField = new JTextField();
		}
		return lxrField;
	}

	/**
	 * This method initializes jsfsComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJsfsComboBox() {
		if (jsfsComboBox == null) {
			jsfsComboBox = new JComboBox();
		}
		return jsfsComboBox;
	}

	/**
	 * This method initializes thsjField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getThsjField() {
		if (thsjField == null) {
			thsjField = new JTextField();
		}
		return thsjField;
	}

	/**
	 * This method initializes jsrField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJsrField() {
		if (jsrField == null) {
			jsrField = new JTextField();
		}
		return jsrField;
	}

	/**
	 * This method initializes pzslField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getPzslField() {
		if (pzslField == null) {
			pzslField = new JTextField();
		}
		return pzslField;
	}

	/**
	 * This method initializes hpzsField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getHpzsField() {
		if (hpzsField == null) {
			hpzsField = new JTextField();
		}
		return hpzsField;
	}

	/**
	 * This method initializes hjjeField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getHjjeField() {
		if (hjjeField == null) {
			hjjeField = new JTextField();
		}
		return hjjeField;
	}

	/**
	 * This method initializes ysjlField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getYsjlField() {
		if (ysjlField == null) {
			ysjlField = new JTextField();
		}
		return ysjlField;
	}

	/**
	 * This method initializes czyField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getCzyField() {
		if (czyField == null) {
			czyField = new JTextField();
		}
		return czyField;
	}

	/**
	 * This method initializes tjButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getTjButton() {
		if (tjButton == null) {
			tjButton = new JButton();
			tjButton.setText("添加");
		}
		return tjButton;
	}

	/**
	 * This method initializes thButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getThButton() {
		if (thButton == null) {
			thButton = new JButton();
			thButton.setText("退货");
		}
		return thButton;
	}

	/**
	 * This method initializes spComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getSpComboBox() {
		if (spComboBox == null) {
			spComboBox = new JComboBox();
		}
		return spComboBox;
	}

} // @jve:decl-index=0:visual-constraint="-2,11"
