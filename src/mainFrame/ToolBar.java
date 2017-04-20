package mainFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
	private MenuBar menuBar = null ;
	
	public ToolBar(MenuBar frameMenuBar){
		super();
		this.menuBar = frameMenuBar ;
		initialize();
	}

	private void initialize() {
		setSize(new Dimension(600, 30));
		this.setBackground(Color.cyan);
		setBorder(BorderFactory.createBevelBorder(0));
		add(createToobarButton(menuBar.getJinhuoItem()));
		add(createToobarButton(menuBar.getXiaoshou_danItem()));
		add(createToobarButton(menuBar.getKucun_pandianItem()));
		add(createToobarButton(menuBar.getJiage_tiaozhengItem()));
		add(createToobarButton(menuBar.getShangpin_chaxunItem()));
		add(createToobarButton(menuBar.getShangpin_guanliItem()));
		add(createToobarButton(menuBar.getKehu_guanliItem()));
		add(createToobarButton(menuBar.getGys_guanliItem()));
		add(createToobarButton(menuBar.getExitItem()));
		
		
	}
	
	private JButton createToobarButton(JMenuItem menuItem){
		JButton button = new JButton(menuItem.getText());
		button.setToolTipText(menuItem.getText());
		button.setIcon(menuItem.getIcon());
		button.setFocusable(false);//È¡Ïû°´Å¥¾Û½¹
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuItem.doClick();
			}
		});
		return button ;
	}
}
