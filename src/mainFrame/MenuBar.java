package mainFrame;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.DesktopPaneUI;

import com.hui.iFrame.BackupAndRestore;
import com.hui.iFrame.GengGaiMiMa;
import com.hui.iFrame.GuanYu;
import com.hui.iFrame.GysGuanLi;
import com.hui.iFrame.JiaGeTiaoZheng;
import com.hui.iFrame.JinHuoDan_IFrame;
import com.hui.iFrame.Jinhuo_Tuihuo_IFrame;
import com.hui.iFrame.JsrGL;
import com.hui.iFrame.KeHuGuanLi;
import com.hui.iFrame.KuCunPanDian;
import com.hui.iFrame.ShangPinChaXun;
import com.hui.iFrame.ShangPinGuanLi;
import com.hui.iFrame.XiaoShouChaXun;
import com.hui.iFrame.XiaoShouDan;
import com.hui.iFrame.XiaoShouPaiHang;


public class MenuBar extends JMenuBar {
	private JMenu jinhuo_Menu = null ;
	private JMenuItem jinhuoItem = null;
	private JMenuItem jinhuo_tuihuoItem = null;
	private JMenu xiaoshou_Menu = null;

	private Map<JMenuItem, JInternalFrame> iFrames = null;	
	

	private JLabel stateLabel = null;

	private int nextFrameX, nextFrameY;

	private JMenu kucun_Menu = null;

	private JMenu xinxi_chaxunMenu = null;

	private JMenu jiben_ziliaoMenu = null;


	private JMenu xitong_weihuMenu = null;


	private JMenu chuang_kouMenu = null;


	private JMenu bang_zhuMenu = null;


	private JMenuItem guanyu_Item = null;


	private JMenuItem bugItem = null;


	private JMenuItem fangwen_wangzhanItem = null;


	private JMenuItem xiaoshou_danItem = null;


	private JMenuItem xiaoshou_tuihuoItem = null;


	private JMenuItem kucun_pandianItem = null;

	private JMenuItem jiage_tiaozhengItem = null;


	private JMenuItem xiaoshou_chaxunItem = null;


	private JMenuItem shangpin_chaxunItem = null;


	private JMenuItem xiaoshou_paihangItem = null;


	private JMenuItem shangpin_guanliItem = null;


	private JMenuItem kehu_guanliItem = null;


	private JMenuItem gys_guanliItem = null;

	private JMenuItem jsr_guanliItem = null;


	private JMenuItem mima_xiugaiItem = null;


	private JMenuItem shuju_beifenItem = null;


	private JMenuItem exitItem = null;


	private JMenuItem pingpuItem = null ;
	
	private JMenuItem closeAllItem = null ;
	
	private JMenuItem allIconItem = null ;
	
	private JMenuItem allResumeItem = null ;


	private JDesktopPane desktopPanel = null;

	
	public MenuBar(JDesktopPane desktopPanel , JLabel stateLabel){
		super();
		iFrames = new HashMap<JMenuItem,JInternalFrame>();
		this.stateLabel = stateLabel ;
		this.desktopPanel = desktopPanel ;		
		initialize();
	}

	private void initialize() {
		this.setSize(600, 25);
		this.add(getJinhuoMenu());
		add(getXiaoshou_Menu());
		add(getKucun_Menu());
		add(getXinxi_chaxunMenu());
		add(getJiben_ziliaoMenu());
		add(getXitong_weihuMenu());
		add(getChuang_kouMenu());
		add(getBang_zhuMenu());
	}
	
	private JMenu getChuang_kouMenu() {
		if(chuang_kouMenu == null ){
			chuang_kouMenu = new JMenu("窗口");
			chuang_kouMenu.setMnemonic(KeyEvent.VK_W);
			chuang_kouMenu.addMenuListener(new MenuListener() {
				
				@Override
				public void menuSelected(MenuEvent e) {
					
					chuang_kouMenu.removeAll();
					chuang_kouMenu.add(getPingpuItem());
					chuang_kouMenu.add(getClassAllItem());
					chuang_kouMenu.add(getAllIconItem());
					chuang_kouMenu.add(getAllResumeItem());
					chuang_kouMenu.addSeparator();
					int count = 0 ;
					JInternalFrame[] frames = desktopPanel.getAllFrames();
					for(JInternalFrame frame : frames){
						String frameTitle = frame.getTitle();
						JMenuItem item =new JMenuItem();
						item.setText(count+"."+frameTitle);
						item.setIcon(frame.getFrameIcon());
						item.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								frame.setVisible(true);
								try {
									frame.setSelected(true);
								} catch (PropertyVetoException e1) {
									e1.printStackTrace();
								}
								
							}
						});
						chuang_kouMenu.add(item);
						count++ ;
					}
					
				}
				
				@Override
				public void menuDeselected(MenuEvent e) {
				}
				
				@Override
				public void menuCanceled(MenuEvent e) {				
				}
			});
		}
		
		return chuang_kouMenu;
	}

	protected JMenuItem getAllResumeItem() {
		if(allResumeItem == null){
			allResumeItem = new JMenuItem("全部恢复");
			allResumeItem.setIcon(new ImageIcon(this.getClass().getResource(
					"/res/icon/quanbu_huanyuan.png")));
			allResumeItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JInternalFrame[] frames = desktopPanel.getAllFrames();
					for(JInternalFrame frame : frames ){
						try {
							frame.setIcon(false);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return allResumeItem;
	}

	protected JMenuItem getAllIconItem() {
		if(allIconItem == null){
			allIconItem = new JMenuItem("图标化");
			allIconItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/quanbu_zuixiaohua.png")));
			allIconItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JInternalFrame[] frames = desktopPanel.getAllFrames();
					for(JInternalFrame frame : frames ){
						//desktopPanel.getDesktopManager().iconifyFrame(frame);
						try {
							frame.setIcon(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			});
		}
		return allIconItem;
	}

	protected JMenuItem getClassAllItem() {
		if(closeAllItem == null){
			closeAllItem = new JMenuItem("全部关闭");
			closeAllItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/quanbu_guanbi.png")));
			closeAllItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for(JInternalFrame frame : allFrames){
						frame.doDefaultCloseAction();
					}
					
				}
			});
		}
		return closeAllItem;
	}

	protected JMenuItem getPingpuItem() {
		if(pingpuItem == null){
			pingpuItem = new JMenuItem("平铺");
			pingpuItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/chuangkou_pingpu.png")));
			pingpuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					int x = 0 ;
					int y = 0 ;
					for(JInternalFrame frame : allFrames){
						frame.setLocation(x, y);
						try {
							frame.setSelected(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						int frameH = frame.getPreferredSize().height ;
						int panelH = frame.getContentPane().getHeight();
						int fSpace = frameH - panelH ;
						x += fSpace ;
						y += fSpace ;
						if(x + getWidth()/2 > desktopPanel.getWidth())
							x = 0 ;
						if(y + getHeight()/2 > desktopPanel.getHeight())
							y = 0 ;
					}
					
				}
			});
		}
		return pingpuItem;
	}

	public JMenu getBang_zhuMenu() {
		if (bang_zhuMenu == null) {
			bang_zhuMenu = new JMenu();
			bang_zhuMenu.setText("帮助(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());
		}
		return bang_zhuMenu;
	}
	
	public JMenuItem getGuanyu_Item() {
		if(guanyu_Item == null){
			guanyu_Item = new JMenuItem("关于");
			guanyu_Item.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/guanyu.png")));
			guanyu_Item.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					createFrame(guanyu_Item, GuanYu.class);
				}
			});
		}
		return guanyu_Item;
	}

	private JMenuItem getFangwen_wangzhanItem() {
		if(fangwen_wangzhanItem == null){
			fangwen_wangzhanItem = new JMenuItem("访问网站");
			fangwen_wangzhanItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/jishu_wangzhan.png")));
			fangwen_wangzhanItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Desktop.isDesktopSupported()){
						Desktop desktop = Desktop.getDesktop();
						try {
							desktop.browse(new URI("www.baidu.com"));
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			});
		}
		return fangwen_wangzhanItem;
	}

	private JMenuItem getBugItem() {
		if(bugItem == null ){
			bugItem = new JMenuItem("技术支持");
			bugItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jishu_zhichi.png")));
			bugItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Desktop.isDesktopSupported()){
						Desktop desktop = Desktop.getDesktop();					
							URI url;
							try {
								url = new URI("1214585404@qq.com");
								desktop.mail(url);
							} catch (URISyntaxException | IOException e1) {
								
								e1.printStackTrace();
							}						
					}
					
				}
			});
		}
		return bugItem;
	}

	public JMenu getXitong_weihuMenu() {
		if (xitong_weihuMenu == null) {
			xitong_weihuMenu = new JMenu();
			xitong_weihuMenu.setText("系统维护(S)");
			xitong_weihuMenu.setMnemonic(KeyEvent.VK_S);
			xitong_weihuMenu.add(getShuju_beifenItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getMima_xiugaiItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getExitItem());
		}
		return xitong_weihuMenu;
	}
	
	public JMenuItem getExitItem() {
		if (exitItem == null) {
			exitItem = new JMenuItem();
			exitItem.setText("退出");
			exitItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/tuichu_xitong.png")));
			exitItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitItem;
	}
	
	public JMenuItem getMima_xiugaiItem() {
		if (mima_xiugaiItem == null) {
			mima_xiugaiItem = new JMenuItem();
			mima_xiugaiItem.setText("密码修改");
			mima_xiugaiItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/mima_xiugai.png")));
			mima_xiugaiItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							createFrame(mima_xiugaiItem, GengGaiMiMa.class);
						}
					});
		}
		return mima_xiugaiItem;
	}
	
	public JMenuItem getShuju_beifenItem() {
		if (shuju_beifenItem == null) {
			shuju_beifenItem = new JMenuItem();
			shuju_beifenItem.setText("数据备份");
			shuju_beifenItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/shujuku_beifen_huifu.png")));
			shuju_beifenItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							createFrame(shuju_beifenItem, BackupAndRestore.class);
						}
					});
		}
		return shuju_beifenItem;
	}
	
	public JMenu getJiben_ziliaoMenu() {
		if (jiben_ziliaoMenu == null) {
			jiben_ziliaoMenu = new JMenu();
			jiben_ziliaoMenu.setText("基本资料(B)");
			jiben_ziliaoMenu.setMnemonic(KeyEvent.VK_B);
			jiben_ziliaoMenu.add(getShangpin_guanliItem());
			jiben_ziliaoMenu.add(getKehu_guanliItem());
			jiben_ziliaoMenu.add(getGys_guanliItem());
			jiben_ziliaoMenu.addSeparator();
			jiben_ziliaoMenu.add(getJsr_guanliItem());
		}
		return jiben_ziliaoMenu;
	}
	
	public JMenuItem getJsr_guanliItem() {
		if (jsr_guanliItem == null) {
			jsr_guanliItem = new JMenuItem();
			jsr_guanliItem.setText("经手人管理");
			jsr_guanliItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/jsr_shezhi.png")));
			jsr_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createFrame(jsr_guanliItem, JsrGL.class);
				}
			});
		}
		return jsr_guanliItem;
	}
	
	public JMenuItem getGys_guanliItem() {
		if (gys_guanliItem == null) {
			gys_guanliItem = new JMenuItem();
			gys_guanliItem.setText("供应商管理");
			gys_guanliItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/gys_guanli.png")));
			gys_guanliItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							createFrame(gys_guanliItem, GysGuanLi.class);
						}
					});
		}
		return gys_guanliItem;
	}
	
	public JMenuItem getKehu_guanliItem() {
		if (kehu_guanliItem == null) {
			kehu_guanliItem = new JMenuItem();
			kehu_guanliItem.setText("客户管理");
			kehu_guanliItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/kehu_guanli.png")));
			kehu_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createFrame(kehu_guanliItem, KeHuGuanLi.class);
				}
			});
		}
		return kehu_guanliItem;
	}
	public JMenuItem getShangpin_guanliItem() {
		if (shangpin_guanliItem == null) {
			shangpin_guanliItem = new JMenuItem();
			shangpin_guanliItem.setText("商品管理");
			shangpin_guanliItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/shangpin_guanli.png")));
			shangpin_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createFrame(shangpin_guanliItem, ShangPinGuanLi.class);
				}
			});
		}
		return shangpin_guanliItem;
	}

	public JMenu getXinxi_chaxunMenu() {
		if (xinxi_chaxunMenu == null) {
			xinxi_chaxunMenu = new JMenu();
			xinxi_chaxunMenu.setText("信息查询(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;
	}
	
	public JMenuItem getXiaoshou_paihangItem() {
		if (xiaoshou_paihangItem == null) {
			xiaoshou_paihangItem = new JMenuItem();
			xiaoshou_paihangItem.setText("销售排行");
			xiaoshou_paihangItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/xiaoshou_paihang.png")));
			xiaoshou_paihangItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							createFrame(xiaoshou_paihangItem, XiaoShouPaiHang.class);
						}
					});
		}
		return xiaoshou_paihangItem;
	}
	public JMenuItem getShangpin_chaxunItem() {
		if (shangpin_chaxunItem == null) {
			shangpin_chaxunItem = new JMenuItem();
			shangpin_chaxunItem.setText("商品查询");
			shangpin_chaxunItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/shangpin_chaxun.png")));
			shangpin_chaxunItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							createFrame(shangpin_chaxunItem, ShangPinChaXun.class);
						}
					});
		}
		return shangpin_chaxunItem;
	}
	
	public JMenuItem getXiaoshou_chaxunItem() {
		if (xiaoshou_chaxunItem == null) {
			xiaoshou_chaxunItem = new JMenuItem();
			xiaoshou_chaxunItem.setText("销售查询");
			xiaoshou_chaxunItem.setIcon(new ImageIcon(getClass().getResource(
					"/res/icon/xiaoshou_chaxun.png")));
			xiaoshou_chaxunItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							createFrame(xiaoshou_chaxunItem, XiaoShouChaXun.class);
						}
					});
		}
		return xiaoshou_chaxunItem;
	}

	private JMenu getKucun_Menu() {
		if(kucun_Menu == null){
			kucun_Menu = new JMenu("库存(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getKucun_pandianItem());
			kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;
	}

	public JMenuItem getJiage_tiaozhengItem() {
		if(jiage_tiaozhengItem == null ){
			jiage_tiaozhengItem = new JMenuItem("价格调整");
			jiage_tiaozhengItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					createFrame(jiage_tiaozhengItem, JiaGeTiaoZheng.class);
				}
			});
		}
		return jiage_tiaozhengItem;
	}

	public JMenuItem getKucun_pandianItem() {
		if(kucun_pandianItem == null){
			kucun_pandianItem = new JMenuItem("库存盘点");
			kucun_pandianItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					createFrame(kucun_pandianItem, KuCunPanDian.class);
				}
			});
		}
		return kucun_pandianItem;
	}

	private JMenu getXiaoshou_Menu() {
		if(xiaoshou_Menu == null){
			xiaoshou_Menu = new JMenu("销售(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
			xiaoshou_Menu.add(getXiaoshou_danItem());
		
		}
		return xiaoshou_Menu;
	}

	private JMenuItem getXiaoshou_tuihuoItem() {
		if(xiaoshou_tuihuoItem == null){
			xiaoshou_tuihuoItem = new JMenuItem("销售退货");
			xiaoshou_danItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return xiaoshou_tuihuoItem;
	}

	public JMenuItem getXiaoshou_danItem() {
		if(xiaoshou_danItem == null){
			xiaoshou_danItem = new JMenuItem("销售单");
			xiaoshou_danItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					createFrame(xiaoshou_danItem, XiaoShouDan.class);
				}
			});
		}
		return xiaoshou_danItem;
	}

	private JMenu getJinhuoMenu() {
		if(jinhuo_Menu == null){
			jinhuo_Menu = new JMenu("进货(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			jinhuo_Menu.add(getJinhuoItem());
		}
		return jinhuo_Menu;
	}
	
	public JMenuItem getJinhuoItem(){
		if(jinhuoItem == null){
			jinhuoItem = new JMenuItem("进货单");
			jinhuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jinhuodan.png")));
			jinhuoItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					createFrame(jinhuoItem, JinHuoDan_IFrame.class);
				}
			});
		}
		return jinhuoItem ;
	}
	
	private JMenuItem getJinhuo_tuihuoItem(){
		if(jinhuo_tuihuoItem == null){
			jinhuo_tuihuoItem = new JMenuItem("进货退货");
			jinhuo_tuihuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jinhuo_tuihuo.png")));
			jinhuo_tuihuoItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					createFrame(jinhuo_tuihuoItem, Jinhuo_Tuihuo_IFrame.class);
					
				}
			});
		}
		return jinhuo_tuihuoItem ;
	}
	/**
	 * 
	 * 
	 */
	private JInternalFrame createFrame(JMenuItem item , Class clzz){
		Constructor constructor = clzz.getConstructors()[0];
		JInternalFrame interFrame = iFrames.get(item);
		if(interFrame == null || interFrame.isClosed()){
			try {
				interFrame = (JInternalFrame)constructor.newInstance(new Object[]{});
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			iFrames.put(item, interFrame);
			interFrame.setFrameIcon(item.getIcon());
			interFrame.setTitle(item.getText());
			interFrame.setLocation(nextFrameX, nextFrameY);
			int frameH = interFrame.getPreferredSize().height ;
			int panelH = interFrame.getContentPane().getPreferredSize().height;
			int Fspace = frameH - panelH ;
			nextFrameX += Fspace ;
			nextFrameY += Fspace ;
			if(nextFrameX + interFrame.getWidth() > desktopPanel.getWidth())
				nextFrameX = 0 ;
			if(nextFrameY + interFrame.getHeight() > desktopPanel.getHeight())
				nextFrameY = 0 ;
			desktopPanel.add(interFrame);
			interFrame.setVisible(true);
			interFrame.setResizable(false);
			interFrame.setMaximizable(false);
		}
		try {
			interFrame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}	
		stateLabel.setText(interFrame.getTitle());
		interFrame.addInternalFrameListener(new InternalFrameListener() {
			
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				stateLabel.setText("未选中窗口");
				
			}
			
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				JInternalFrame frame = e.getInternalFrame();
				stateLabel.setText(frame.getTitle());
				
			}
		});
		
		return interFrame ;
	}
	
	
}
