package com.hui.iFrame;


import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JsrGL extends JInternalFrame {
	public JsrGL() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 491, 200);
		setTitle("经手人管理");
		JTabbedPane tabPane = new JTabbedPane();
		final TJJingShouRen tjPanel = new TJJingShouRen();
		final SetJSR setPanel = new SetJSR();
		tabPane.addTab("添加", null, tjPanel, "添加");
		tabPane.addTab("设置", null, setPanel, "设置");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setPanel.initTable();
			}
		});
		pack();
		setVisible(true);
	}
}
