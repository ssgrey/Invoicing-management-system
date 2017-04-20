package mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {

	private MenuBar frameMenuBar = null ;
	

	private JPanel frameContentPane = null ;
	private JToolBar toolbar = null ;
	private DesktopPanel desktopPanel = null;
		

	private JPanel statePanel = null ;
	private JLabel stateLabel = null ;
	private JLabel nameLabel = null ; 
	private JLabel nowDateLabel = null ;
	private static JLabel czyStateLabel = null ;
	
	private JSeparator separator1 = null ;
	private JSeparator separator2 = null ;

	private JSeparator separator3 = null;
	
	public static void main(String[] args) {
		
	}
		
	public MainFrame(){
		super();
		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		this.setTitle("企业进销管理系统");
		this.setJMenuBar(getFrameMenuBar());
		this.setContentPane(getFrameContentPane());
		this.setBounds(200, 100, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JPanel getFrameContentPane() {
		if(frameContentPane == null){
			frameContentPane = new JPanel();
			frameContentPane.setLayout(new BorderLayout());
			frameContentPane.add(getDesktopPanel(),BorderLayout.CENTER);
			frameContentPane.add(getStatePanel(),BorderLayout.SOUTH);
			frameContentPane.add(getToolBar(),BorderLayout.NORTH);
		}
		return frameContentPane;
	}

	private JToolBar getToolBar() {
		if(toolbar == null){
			toolbar = new ToolBar(getFrameMenuBar());
		}
		return toolbar;
	}

	private JPanel getStatePanel() {
		if(statePanel == null){
			statePanel = new JPanel();
			statePanel.setLayout(new GridBagLayout());
			GridBagConstraints gridconstrain = new GridBagConstraints();
			gridconstrain.gridx = 0 ;
			gridconstrain.gridy = 0 ;
			gridconstrain.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain.weightx = 1.0 ;
			gridconstrain.insets = new Insets(0,5,0,5);
			statePanel.add(getStateLabel(),gridconstrain);
			
			GridBagConstraints gridconstrain2 = new GridBagConstraints();
			gridconstrain2.gridx = 2 ;
			gridconstrain2.gridy = 0 ;
			gridconstrain2.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain2.weightx = 1.0 ;
			gridconstrain2.insets = new Insets(0,5,0,5);
			nameLabel = new JLabel("状态栏");
			statePanel.add(nameLabel,gridconstrain2);
			
			GridBagConstraints gridconstrain3 = new GridBagConstraints();
			gridconstrain3.gridx = 1 ;
			gridconstrain3.gridy = 0 ;
			gridconstrain3.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain3.weightx = 1.0 ;
			gridconstrain3.insets = new Insets(0,5,0,5);
			statePanel.add(getJSeparator1(),gridconstrain3);
			
			GridBagConstraints gridconstrain4 = new GridBagConstraints();
			gridconstrain4.gridx = 3 ;
			gridconstrain4.gridy = 0 ;
			gridconstrain4.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain4.weightx = 1.0 ;
			gridconstrain4.insets = new Insets(0,5,0,5);
			statePanel.add(getJSeparator2(), gridconstrain4);
			
			GridBagConstraints gridconstrain5 = new GridBagConstraints();
			gridconstrain5.gridx = 4 ;
			gridconstrain5.gridy = 0 ;
			gridconstrain5.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain5.weightx = 1.0 ;
			gridconstrain5.insets = new Insets(0,5,0,5);
			nowDateLabel = new JLabel();
			Date date = new Date();
			String dates = date.toString();
			nowDateLabel.setText(dates);
			statePanel.add(nowDateLabel, gridconstrain5);
			
			GridBagConstraints gridconstrain6 = new GridBagConstraints();
			gridconstrain6.gridx = 5 ;
			gridconstrain6.gridy = 0 ;
			gridconstrain6.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain6.weightx = 1.0 ;
			gridconstrain6.insets = new Insets(0,5,0,5);
			statePanel.add(getJSeparator3(), gridconstrain6);
			
			GridBagConstraints gridconstrain7 = new GridBagConstraints();
			gridconstrain7.gridx = 6 ;
			gridconstrain7.gridy = 0 ;
			gridconstrain7.fill = GridBagConstraints.VERTICAL ; 
			gridconstrain7.weightx = 1.0 ;
			gridconstrain7.insets = new Insets(0,5,0,5);
			statePanel.add(getCzyStateLabel(), gridconstrain7);
			statePanel.setBorder(BorderFactory.createBevelBorder(0));
		}
		return statePanel;
	}

	private Component getJSeparator3() {
		if(separator3 == null){
			separator3 = new JSeparator();
			separator3.setBackground(Color.BLUE);
			separator3.setOrientation(JSeparator.VERTICAL);
		}
		return separator3 ;
	}

	public static JLabel getCzyStateLabel() {
		if(czyStateLabel == null){
			czyStateLabel = new JLabel("宫帅辉");
		}
		return czyStateLabel ;
	}

	private  JSeparator getJSeparator2() {
		if(separator2 == null){
			separator2 = new JSeparator();
			separator2.setBackground(Color.BLUE);
			separator2.setOrientation(JSeparator.VERTICAL);
		}
		return separator2;
	}

	private JSeparator getJSeparator1() {
		if(separator1 == null){
			separator1 = new JSeparator();
			separator1.setBackground(Color.BLUE);
			separator1.setOrientation(JSeparator.VERTICAL);
		}
		return separator1;
	}

	private MenuBar getFrameMenuBar() {
		if(frameMenuBar == null){
			frameMenuBar = new MenuBar(getDesktopPanel(),getStateLabel());
		}
		return frameMenuBar;
	}

	private JLabel getStateLabel() {
		if(stateLabel == null){
			stateLabel = new JLabel("无窗口");
		}
		return stateLabel;
	}

	private JDesktopPane getDesktopPanel() {
		if(desktopPanel == null){
			desktopPanel = new DesktopPanel();
		}
		return desktopPanel;
	}
}
