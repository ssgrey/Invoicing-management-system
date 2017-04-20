package com.hui.iFrame;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.hui.iFrame.GysGuanli.GysTianJiaPanel;
import com.hui.iFrame.GysGuanli.GysXiuGaiPanel;

public class GysGuanLi extends JInternalFrame {
	public GysGuanLi() {
		setIconifiable(true);
		setClosable(true);
		setTitle("供应商管理");
		JTabbedPane tabPane = new JTabbedPane();
		final GysXiuGaiPanel spxgPanel = new GysXiuGaiPanel();
		final GysTianJiaPanel sptjPanel = new GysTianJiaPanel();
		tabPane.addTab("供应商添加", null, sptjPanel, "供应商添加");
		tabPane.addTab("供应商修改", null, spxgPanel, "供应商修改");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();
			}
		});
		pack();
		setVisible(true);
	}
}