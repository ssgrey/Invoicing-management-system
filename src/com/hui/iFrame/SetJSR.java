package com.hui.iFrame;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.hui.Dao.Dao;



public class SetJSR extends JPanel {
	private JTextField sexField;

	private JTextField ageField;

	private JTextField nameField;

	private JTable table;

	private DefaultTableModel dftm;

	private String[] columnNames;

	public SetJSR() {
		super();
		setBounds(0, 0, 491, 200);
		setLayout(new GridBagLayout());

		final JScrollPane scrollPane = new JScrollPane();
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(0, 0, 20, 0);
		gridBagConstraints.gridwidth = 12;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.ipady = -195;
		add(scrollPane, gridBagConstraints);

		table = new JTable();
		dftm = (DefaultTableModel) table.getModel();
		columnNames = new String[] { "id","姓名", "性别", "年龄",  "电话", "enable" };
		dftm.setColumnIdentifiers(columnNames);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				String nameStr, ageStr, sexStr;
				int selRow = table.getSelectedRow();
				nameStr = table.getValueAt(selRow, 1).toString().trim();
				ageStr = table.getValueAt(selRow, 3).toString().trim();
				sexStr = table.getValueAt(selRow, 2).toString().trim();
				nameField.setText(nameStr);
				ageField.setText(ageStr);
				sexField.setText(sexStr);
			}
		});
		scrollPane.setViewportView(table);

		final JLabel label = new JLabel();
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 2;
		gridBagConstraints_3.gridx = 0;
		add(label, gridBagConstraints_3);
		label.setText("姓名");

		nameField = new JTextField();
		nameField.setEditable(false);
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_4.weightx = 1.0;
		gridBagConstraints_4.gridy = 2;
		gridBagConstraints_4.gridx = 3;
		add(nameField, gridBagConstraints_4);

		final JLabel label_2 = new JLabel();
		label_2.setText("性别");
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy = 2;
		gridBagConstraints_7.gridx = 4;
		add(label_2, gridBagConstraints_7);

		sexField = new JTextField();
		sexField.setEditable(false);
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.weightx = 1.0;
		gridBagConstraints_8.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_8.gridy = 2;
		gridBagConstraints_8.gridx = 5;
		add(sexField, gridBagConstraints_8);

		final JLabel label_1 = new JLabel();
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy = 2;
		gridBagConstraints_6.gridx = 6;
		add(label_1, gridBagConstraints_6);
		label_1.setText("年龄");

		ageField = new JTextField();
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.weightx = 1.0;
		gridBagConstraints_5.gridy = 2;
		gridBagConstraints_5.gridx = 7;
		add(ageField, gridBagConstraints_5);
		ageField.setEditable(false);

		final JButton button = new JButton("删除");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(5, 0, 5, 0);
		gridBagConstraints_1.gridy = 7;
		gridBagConstraints_1.gridx = 4;
		add(button, gridBagConstraints_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetJSR.this,
						"确认删除？");
				if (op == JOptionPane.OK_OPTION) {
					int selRow = table.getSelectedRow();
					if(selRow<0)
						return;
					String id = table.getValueAt(selRow, 0).toString().trim();
					Dao.delete("delete from tb_jsr where id='" + id + "'");
					sexField.setText("");
					ageField.setText("");
					nameField.setText("");
					initTable();
				}
			}
		});

		final JButton enableButton = new JButton("修改");
		final GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.insets = new Insets(5, 0, 5, 0);
		gridBagConstraints4.gridy = 7;
		gridBagConstraints4.gridx = 3;
		add(enableButton, gridBagConstraints4);
		enableButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int selRow = table.getSelectedRow();
				if(selRow<0)
					return;
				int op = JOptionPane.showConfirmDialog(SetJSR.this,
						"确认修改？");
				if (op == JOptionPane.OK_OPTION) {
					if(selRow<0)
						return;
					String id = table.getValueAt(selRow, 0).toString().trim();
					Dao.update("update tb_jsr set enable=enable-1 where id='"
							+ id + "'");
					initTable();
				}
			}
		});

		final JButton button_1 = new JButton("关闭");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.insets = new Insets(5, 0, 5, 0);
		gridBagConstraints_2.gridy = 7;
		gridBagConstraints_2.gridx = 6;
		add(button_1, gridBagConstraints_2);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JsrGL parent = (JsrGL) SetJSR.this.getRootPane()
						.getParent();
				parent.doDefaultCloseAction();
			}
		});
	}

	public void initTable() {
		List ul = Dao.getJsrs();
		Iterator it = ul.iterator();
		String[] data = new String[6];
		dftm.setDataVector(null, columnNames);
		while (it.hasNext()) {
			
			List userlist = (List) it.next();
			data[0] = (String) userlist.get(0);
			data[1] = (String) userlist.get(1);
			data[2] = (String) userlist.get(2);
			data[3] = (String) userlist.get(3);
			data[4] = (String) userlist.get(4);
			data[5] = ((String) userlist.get(5)).equals("1") ? "是" : "否";
			dftm.addRow(data);
		}
		setVisible(true);
	}
}
