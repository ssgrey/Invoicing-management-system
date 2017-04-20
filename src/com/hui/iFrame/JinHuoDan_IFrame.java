package com.hui.iFrame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import com.hui.Dao.Dao;
import com.hui.javaBean.Item;
import com.hui.javaBean.TbGysInfo;
import com.hui.javaBean.TbRkthMain;
import com.hui.javaBean.TbRukuDetail;
import com.hui.javaBean.TbRukuMain;
import com.hui.javaBean.TbSpinfo;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;

public class JinHuoDan_IFrame extends JInternalFrame {
	private JTextField idField;
	private JTextField jhsjField;
	private JTextField lxrField;
	private JTextField pzslField;
	private JTextField ysjelField;
	private JTextField hpzsField;
	private JTextField czyField;
	private JTextField hjjeField;
	private JTable table ;
	JScrollPane scrollPane ;
	private JComboBox spComboBox ;
	private JComboBox gysComboBox ; 
	private JComboBox jbrComboBox ;
	private JComboBox jsfsComboBox ;
	private Date jhsjDate = new Date();
	
	List<String> list = new ArrayList<String>();//存储spComboBox使用过的项
	String tempSPID = null ;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
					JinHuoDan_IFrame frame = new JinHuoDan_IFrame();
					frame.setVisible(true);
				
	}
*/
	/**
	 * Create the frame.
	 */
	public JinHuoDan_IFrame() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 714, 381);
		getContentPane().setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(10, 5, 678, 64);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel label = new JLabel("\u8FDB\u8D27\u7968\u53F7\uFF1A");
		label.setBounds(10, 10, 64, 23);
		topPanel.add(label);
		
		JLabel label_1 = new JLabel("\u7ED3\u7B97\u65B9\u5F0F\uFF1A");
		label_1.setBounds(10, 39, 64, 23);
		topPanel.add(label_1);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(84, 11, 101, 21);
		topPanel.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546:");
		lblNewLabel.setBounds(226, 13, 54, 15);
		topPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8FDB\u8D27\u65F6\u95F4:");
		lblNewLabel_1.setBounds(226, 42, 54, 15);
		topPanel.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("\u8054\u7CFB\u4EBA:");
		lblNewLabel_2.setBounds(469, 14, 54, 15);
		topPanel.add(lblNewLabel_2);
		
		jhsjField = new JTextField();
		jhsjField.setBounds(302, 40, 145, 21);
		topPanel.add(jhsjField);
		jhsjField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7ECF\u529E\u4EBA:");
		lblNewLabel_3.setBounds(469, 43, 54, 15);
		topPanel.add(lblNewLabel_3);
		
		lxrField = new JTextField();
		lxrField.setBounds(549, 11, 119, 21);
		topPanel.add(lxrField);
		lxrField.setColumns(10);
		
		jbrComboBox = new JComboBox();
		jbrComboBox.setModel(new DefaultComboBoxModel(new String[] {"张三", "李四"}));
		jbrComboBox.setBounds(549, 40, 119, 21);
		topPanel.add(jbrComboBox);
		
		jsfsComboBox = new JComboBox();
		jsfsComboBox.setModel(new DefaultComboBoxModel(new String[] {"支付宝", "微信", "建设银行"}));
		jsfsComboBox.setBounds(84, 40, 101, 21);
		topPanel.add(jsfsComboBox);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(20, 260, 678, 82);
		getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u54C1\u79CD\u6570\u91CF:");
		lblNewLabel_4.setBounds(10, 10, 65, 22);
		bottomPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u9A8C\u6536\u7ED3\u8BBA:");
		lblNewLabel_5.setBounds(10, 42, 65, 22);
		bottomPanel.add(lblNewLabel_5);
		
		pzslField = new JTextField();
		pzslField.setEditable(false);
		pzslField.setBounds(97, 11, 119, 21);
		bottomPanel.add(pzslField);
		pzslField.setColumns(10);
		
		ysjelField = new JTextField();
		ysjelField.setBounds(97, 43, 119, 21);
		bottomPanel.add(ysjelField);
		ysjelField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8D27\u54C1\u603B\u6570:");
		lblNewLabel_6.setBounds(251, 17, 54, 15);
		bottomPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u64CD\u4F5C\u5458:");
		lblNewLabel_7.setBounds(251, 46, 54, 15);
		bottomPanel.add(lblNewLabel_7);
		
		hpzsField = new JTextField();
		hpzsField.setEditable(false);
		hpzsField.setBounds(323, 11, 119, 21);
		bottomPanel.add(hpzsField);
		hpzsField.setColumns(10);
		
		czyField = new JTextField();
		czyField.setBounds(323, 43, 119, 21);
		bottomPanel.add(czyField);
		czyField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u5408\u8BA1\u91D1\u989D:");
		lblNewLabel_8.setBounds(471, 17, 54, 15);
		bottomPanel.add(lblNewLabel_8);
		
		hjjeField = new JTextField();
		hjjeField.setEditable(false);
		hjjeField.setBounds(546, 14, 122, 21);
		bottomPanel.add(hjjeField);
		hjjeField.setColumns(10);
		
		JButton tjButton = new JButton("\u6DFB\u52A0");
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Date date = new java.sql.Date(jhsjDate.getTime());
				jhsjField.setText(date.toString());
				String maxId = Dao.getRuKuMainMaxId(date);
				idField.setText(maxId);
				stopTableCellEditing();
				for (int i = 0; i <= table.getRowCount()-1; i++) {
					if (table.getValueAt(i, 0) == null || ((TbSpinfo)table.getValueAt(i, 0)).toString()==null)
					{
						System.out.println("停止");
						
						spComboBox.removeAllItems();
						spComboBox.addItem(new TbSpinfo());
						ResultSet rs = Dao.query("select * from tb_spinfo where gysname='"+getGysComboBox().getSelectedItem()+"'");
						System.out.println("select * from tb_spinfo where gysname='"+getGysComboBox().getSelectedItem()+"'");
						updateSpComboBox(rs);
						
						return;
					}
				}
				DefaultTableModel model = (DefaultTableModel) table
						.getModel();
				model.addRow(new Vector());
				//initSpBox();//更新spCombobox
			}
		});
		tjButton.setBounds(464, 42, 93, 23);
		bottomPanel.add(tjButton);
		
		JButton rukuButton = new JButton("入库");
		rukuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();
				Float pzsStr =  Float.parseFloat(pzslField.getText().trim());
				String jeStr = hjjeField.getText().trim();
				String jsfsStr = jsfsComboBox.getSelectedItem().toString();
				String jsrStr = jbrComboBox.getSelectedItem() + ""; 
				String czyStr = czyField.getText().trim(); 
				String rkDate = jhsjField.getText().trim(); 
				String ysjlStr = ysjelField.getText().trim(); 
				String id = idField.getText(); 
				String gysName = gysComboBox.getSelectedItem() + "";
				
				if (jsrStr == null || jsrStr.isEmpty()) {
					JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
							"经手人不能为空！");
					return;
				}
				if (ysjlStr == null || ysjlStr.isEmpty()) {
					JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
							"验收结论不能为空！");
					return;
				}
				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
							"没有商品！");
					return;
				}			
				TbRukuMain ruMain = new TbRukuMain(id, pzsStr, jeStr,
						ysjlStr, gysName, rkDate, czyStr, jsrStr, jsfsStr);
				Set<TbRukuDetail> set = ruMain.getSet();
				int rows = table.getRowCount();
				for (int i = 0; i < rows; i++) {
					TbSpinfo spinfo = (TbSpinfo) table.getValueAt(i, 0);
					if (spinfo == null || spinfo.getId() == null
							|| spinfo.getId().isEmpty())
						continue;
					String djStr = (String) table.getValueAt(i, 6);
					String slStr = (String) table.getValueAt(i, 7);
					Float dj = Float.valueOf(djStr);
					Float sl = Float.valueOf(slStr);
					TbRukuDetail detail = new TbRukuDetail();
					detail.setSpid(spinfo.getId());
					detail.setRkID(ruMain.getRkID());
					detail.setDj(dj);
					detail.setSl(sl);
					set.add(detail);
				}
				
				boolean rs = Dao.insertRukuInfo(ruMain);
				if (rs) {
					JOptionPane.showMessageDialog(JinHuoDan_IFrame.this,
							"入库成功！");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					pzslField.setText("0");
					hpzsField.setText("0");
					hjjeField.setText("0");
				}
			}
		});
		rukuButton.setBounds(575, 42, 93, 23);
		bottomPanel.add(rukuButton);
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 678, 170);
		scrollPane.setViewportView(getTable());
		getContentPane().add(scrollPane);*/
		getContentPane().add(getScrollPane());
		
		//JComboBox gysComboBox = new JComboBox();
				//gysComboBox.setBounds(302, 10, 145, 21);
		topPanel.add(getGysComboBox());
	}
	/*
	protected void initSpBox() {
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; table != null && i <table.getRowCount() ; i++ ){
			TbSpinfo spinfo =(TbSpinfo)table.getValueAt(i, 0);
			if(spinfo!=null&&spinfo.getId()!=null){
				list.add(spinfo.getId());
			}
		}

	}*/

	protected void stopTableCellEditing() {
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();	
	}

	private JComboBox getGysComboBox() {
		if(gysComboBox == null){
			gysComboBox = new JComboBox();
			gysComboBox.setBounds(302, 10, 145, 21);
			List gysInfos = Dao.getGysInfos();
			Dao.closeResourse();
			Iterator it = gysInfos.iterator() ;
			while(it.hasNext()){
				List row = (List)it.next() ;
				Item item = new Item();
				item.setId(row.get(0).toString().trim());
				item.setName(row.get(1).toString().trim());
				gysComboBox.addItem(item);
			}
			updateLxr();
			gysComboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					updateLxr();
				}
			});
			
			
		}
		return gysComboBox;
	}

	private void updateLxr() {
		Item item = (Item)gysComboBox.getSelectedItem();
		TbGysInfo gysInfo = Dao.getGysInfo(item);
		Dao.closeResourse();
		lxrField.setText(gysInfo.getLian());
		
	}
	private JScrollPane getScrollPane(){
		if(scrollPane == null){
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 678, 170);
			scrollPane.setViewportView(getTable());
			
		}
		return scrollPane ;
	}

	private JTable getTable() {
		if(table == null){
			String[] columnNames = { "商品名称", "商品编号", "产地", "单位", "规格", "包装",
					"单价", "数量", "批号", "批准文号" };
			String[][] tablevalue = {{"333","333","333","333","333","333","333","333","333","333"}};
			//DefaultTableModel dtm = new DefaultTableModel(columnNames);
			table = new JTable();
			table.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			table.setShowGrid(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);
			TableColumn column = table.getColumnModel().getColumn(0);
			final DefaultCellEditor editor = new DefaultCellEditor(getSpComboBox());
			//table.setModel(dtm);
			column.setCellEditor(editor);
			table.addPropertyChangeListener(new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					
					if(evt.getPropertyName().equals("tableCellEditor")){
						ComputeInfo();
					}
				}
			});
		}
		return table;
	}

	protected void ComputeInfo() {
					int rows = table.getRowCount();
					int count = 0;
					double money = 0.0;
					TbSpinfo column = null;
					Object valueAt = table.getValueAt(rows - 1, 0);
					if(!(valueAt instanceof TbSpinfo))
						return;
					if (rows > 0)
						column = (TbSpinfo) valueAt;
					if (rows > 0 && (column == null || column.getId()==null ||column.getId().isEmpty()))
						rows--;
					for (int i = 0; i < rows; i++) {
						String column7 = (String) table.getValueAt(i, 7);
						String column6 = (String) table.getValueAt(i, 6);
						int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer
								.parseInt(column7);
						float c6 = (column6 == null || column6.isEmpty()) ? 0 : Float
								.parseFloat(column6);
						count += c7;
						money += c6 * c7;
					}

					pzslField.setText(rows + "");
					hpzsField.setText(count + "");
					hjjeField.setText(money + "");	
	}

	private JComboBox getSpComboBox() {
		if(spComboBox == null){
			spComboBox = new JComboBox() ;		
			spComboBox.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(spComboBox.getSelectedItem() != null){						
						return ;
					}
					spComboBox.removeAllItems();
					spComboBox.addItem(new TbSpinfo());
					ResultSet rs = Dao.query("select * from tb_spinfo where gysname='"+getGysComboBox().getSelectedItem()+"'");
					System.out.println("更新商品："+"select * from tb_spinfo where gysname='"+getGysComboBox().getSelectedItem()+"'");
					updateSpComboBox(rs);
				}
			});
			
			spComboBox.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					TbSpinfo info = (TbSpinfo) spComboBox.getSelectedItem();
					if (info != null && info.getId() != null) {
						updateTable();	
					}				
				}
			});
		}
		return spComboBox;
	}

	protected synchronized void updateTable() {
		TbSpinfo spinfo = (TbSpinfo)spComboBox.getSelectedItem();
		int row = table.getSelectedRow();
		if(row>=0 && spinfo != null){
			table.setValueAt(spinfo.getId(),row , 1);
			table.setValueAt(spinfo.getCd(), row, 2);
			table.setValueAt(spinfo.getDw(), row, 3);
			table.setValueAt(spinfo.getGg(), row, 4);
			table.setValueAt(spinfo.getBz(), row, 5);
			table.setValueAt("0", row, 6);
			table.setValueAt("0", row, 7);
			table.setValueAt(spinfo.getPh(), row, 8);
			table.setValueAt(spinfo.getPzwh(), row, 9);
			table.editCellAt(row, 6);
		}
	}

	protected void updateSpComboBox(ResultSet set) {
		//判断原来表中已有的商品	
		for(int i = 0 ; table != null && i <table.getRowCount() ; i++ ){
			TbSpinfo spinfo1 =(TbSpinfo)table.getValueAt(i, 0);
			if(spinfo1!=null&&spinfo1.getId()!=null){
				list.add(spinfo1.getId());
				System.out.println("list中的id"+spinfo1.getId());
			}
		}
		
		
		
		try {
			while (set.next()) {
				TbSpinfo spinfo = new TbSpinfo();
				spinfo.setId(set.getString("id").trim());
				spinfo.setSpname(set.getString("spname").trim());
				spinfo.setCd(set.getString("cd").trim());
				spinfo.setJc(set.getString("jc").trim());
				spinfo.setDw(set.getString("dw").trim());
				spinfo.setGg(set.getString("gg").trim());
				spinfo.setBz(set.getString("bz").trim());
				spinfo.setPh(set.getString("ph").trim());
				spinfo.setPzwh(set.getString("pzwh").trim());
				spinfo.setMemo(set.getString("memo").trim());
				spinfo.setGysname(set.getString("gysname").trim());
				DefaultComboBoxModel model = (DefaultComboBoxModel) spComboBox
						.getModel();				
				if (model.getIndexOf(spinfo) < 0 && !list.contains(spinfo.getId()))	
				{
					spComboBox.addItem(spinfo); 
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Dao.closeResourse();
	}
}
