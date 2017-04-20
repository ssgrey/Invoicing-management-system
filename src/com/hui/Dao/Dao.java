package com.hui.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.hui.javaBean.Item;
import com.hui.javaBean.TbGysInfo;
import com.hui.javaBean.TbJsr;
import com.hui.javaBean.TbKhInfo;
import com.hui.javaBean.TbKucun;
import com.hui.javaBean.TbRukuDetail;
import com.hui.javaBean.TbRukuMain;
import com.hui.javaBean.TbSellDetail;
import com.hui.javaBean.TbSellMain;
import com.hui.javaBean.TbSpinfo;


public class Dao {

	private static DBManager dbm = DBManager.getDBManager();

	private static Connection conn = null ;
	private static ResultSet set = null ;
	private static Statement st = null ;
	
	private Dao(){
		
	}
	public static ResultSet query(String queryStr){
		ResultSet set = findForResultSet(queryStr) ;
		return set ;
	}
	private static ResultSet findForResultSet(String queryStr) {
		conn = dbm.getConnection();		
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			set = st.executeQuery(queryStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}
	public static List getGysInfos() {
		List list = findForList("select id,name from tb_gysinfo");
		return list;
	}
	public static List findForList(String string) {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(string);
		try{
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();		
			while(rs.next()){
				List<String> row = new ArrayList<String>();
				for(int i = 1 ; i <= columnCount ; i ++){
					String str = rs.getString(i);
					if(str!=null && !str.isEmpty()){
						row.add(str.trim());
					}else{
						row.add(new String(""));
					}
				}
				list.add(row);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeResourse();
		return list;
	}
	public static TbGysInfo getGysInfo(Item item) {
		String where = "name='"+item.getName()+"'";
		if(item.getId()!=null){
			where = where + " and id='"+item.getId()+"'";
		}
		//System.out.println(where);
		TbGysInfo info = new TbGysInfo();
		ResultSet set = findForResultSet("select * from tb_gysinfo where "+where);
		//System.out.println(set);
		try{
			if(set.next()){
				info.setId(set.getString("id").trim());
				info.setAddress(set.getString("address").trim());
				info.setBianma(set.getString("bianma").trim());
				info.setFax(set.getString("fax").trim());
				info.setJc(set.getString("jc").trim());
				info.setLian(set.getString("lian").trim());
				info.setLtel(set.getString("ltel").trim());
				info.setMail(set.getString("mail").trim());
				info.setName(set.getString("name").trim());
				info.setTel(set.getString("tel").trim());
				info.setYh(set.getString("yh").trim());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeResourse();
		return info;
	}
	public static String getRuKuMainMaxId(java.sql.Date date) {
		
		return getMainTypeTableMaxId(date, "tb_ruku_main", "RK", "rkID");
	}
	//获取表中的最大id值并构建新的编号
	private static String getMainTypeTableMaxId(Date date, String table,
			String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table
				+ " where " + idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "000" : baseId
				.substring(baseId.length() - 3);
		int idNum = Integer.parseInt(baseId) + 1;
		id += String.format("%03d", idNum);
		if(set!=null){
			try {
				set.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		closeResourse();
		return id;
	}
	//调用完Dao里面的方法后一定要调用此方法，防止连接池爆满
	public static void closeResourse(){
		dbm.closeResource(conn, st, set);
	}
	public static boolean insertRukuInfo(TbRukuMain ruMain) {
		try {
			conn = dbm.getConnection();
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(true);
			insert("insert into tb_ruku_main values('" + ruMain.getRkID()
					+ "','" + ruMain.getPzs() + "'," + ruMain.getJe()
					+ ",'" + ruMain.getYsjl() + "','"
					+ ruMain.getGysname() + "','" + ruMain.getRkdate()
					+ "','" + ruMain.getCzy() + "','" + ruMain.getJsr()
					+ "','" + ruMain.getJsfs() + "')");
			Set<TbRukuDetail> rkDetails = ruMain.getSet();
			for (Iterator<TbRukuDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbRukuDetail details = iter.next();
				int id = getRkdMaxId() + 1;
				insert("insert into tb_ruku_detail values('"+id+"','"
						+ ruMain.getRkID() + "','"
						+ details.getSpid() + "'," + details.getDj()
						+ "," + details.getSl() + ")");//id自动增加
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() == null || kucun.getId().isEmpty()) {
						insert("insert into tb_kucun values('"
								+ spInfo.getId() + "','"
								+ spInfo.getSpname() + "','"
								+ spInfo.getJc() + "','" +  spInfo.getGg() + "','"
								+ spInfo.getBz() + "','" + spInfo.getDw()
								+ "'," + details.getDj() + ","
								+ details.getSl() + ")");
					} else {
						float sl = kucun.getKcsl() + details.getSl();
						update("update tb_kucun set kcsl=" + sl + ",dj="
								+ details.getDj() + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			//conn.commit();
			//conn.setAutoCommit(autoCommit);
			closeResourse();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	private static int getRkdMaxId() {
		int id = 0001 ;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select max(id) from tb_ruku_detail");
			if(rs.next()){
			String s  = rs.getString(1);
					if(s != null){
						id = Integer.parseInt(s);
					}
				
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return id;
	}
	public static int update(String sql) {
		System.out.println(sql);
		conn = dbm.getConnection() ;
		int result = 0;
		try {
			st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return result;
	}
	public static TbKucun getKucun(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_kucun where "
				+ where);
		TbKucun kucun = new TbKucun();
		try {
			if (rs.next()) {
				kucun.setId(rs.getString("id"));
				kucun.setSpname(rs.getString("spname"));
				kucun.setJc(rs.getString("jc"));
				kucun.setBz(rs.getString("bz"));
				//kucun.setCd(rs.getString("cd"));
				kucun.setDj(rs.getFloat("dj"));
				kucun.setDw(rs.getString("dw"));
				kucun.setGg(rs.getString("gg"));
				kucun.setKcsl(rs.getFloat("kcsl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		closeResourse();
		return kucun;
	}
	public static TbSpinfo getSpInfo(Item item) {
			String where = "spname='" + item.getName() + "'";
			if (item.getId() != null)
				where = "id='" + item.getId() + "'";
			ResultSet rs = findForResultSet("select * from tb_spinfo where "
					+ where);
			TbSpinfo spInfo = new TbSpinfo();
			try {
				if (rs.next()) {
					spInfo.setId(rs.getString("id").trim());
					spInfo.setBz(rs.getString("bz").trim());
					spInfo.setCd(rs.getString("cd").trim());
					spInfo.setDw(rs.getString("dw").trim());
					spInfo.setGg(rs.getString("gg").trim());
					spInfo.setGysname(rs.getString("gysname").trim());
					spInfo.setJc(rs.getString("jc").trim());
					spInfo.setMemo(rs.getString("memo").trim());
					spInfo.setPh(rs.getString("ph").trim());
					spInfo.setPzwh(rs.getString("pzwh").trim());
					spInfo.setSpname(rs.getString("spname").trim());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			closeResourse();
			return spInfo;
	}
	private static boolean insert(String string) {
		conn = dbm.getConnection() ;
		boolean result = true;
		try {
			st = conn.createStatement();
			st.execute(string);
		} catch (SQLException e) {
			result = false ;
			e.printStackTrace();
		}
		closeResourse();
		return result;
		
	}

	public static String getSellMainMaxId(java.sql.Date date) {
		return getMainTypeTableMaxId(date, "tb_sell_main", "XS", "sellID");
	}
	public static boolean insertSellInfo(TbSellMain sellMain) {
		boolean r1,res;

			res = insert("insert into tb_sell_main values('"+sellMain.getSellId()+"','"+sellMain.getPzs()+"','"+sellMain.getJe()+"','"
					+sellMain.getYsjl()+"','"+sellMain.getKhname()+"','"+sellMain.getXsdate()+"','"+sellMain.getCzy()+"','"+sellMain.getJsr()+"','"
					+sellMain.getJsfs()+"')");
			Set<TbSellDetail> set = sellMain.getTbSellDetails();
			for(Iterator<TbSellDetail> it = set.iterator(); it.hasNext();){
				TbSellDetail sellm = it.next() ;
				int id = getSellDetailMaxId() + 1;
				r1 = insert("insert into tb_sell_detail values('"+id+"','"+sellm.getSellID()+"','"+sellm.getSpid()+"','"+sellm.getDj()+"','"+sellm.getSl()+"')");
				ResultSet krs = query("select kcsl from tb_kucun where id ='"+sellm.getSpid()+"'");
				try {
					if(krs.next()){
						int num = Integer.parseInt(krs.getString(1));
						num = num - sellm.getSl().intValue();
						update("update tb_kucun set kcsl ='"+num+"' where id ='"+sellm.getSpid()+"'");
					}
					if(krs!=null){
						krs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if(!r1){
					res = false ;
				}
			}
			
	    closeResourse();
		return res;
	}
	private static int getSellDetailMaxId() {
		conn = dbm.getConnection() ;
		int id = 001 ;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select max(id) from tb_sell_detail");
			if(rs.next()){
				String ids = rs.getString(1);
				if(ids!=null){
					id = Integer.parseInt(ids);
				}
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return id;
	}
	public static List<List> getJsrs() {
		List<List> list = new ArrayList<>();
		ResultSet rs = query("select * from tb_jsr");
		try {
			while(rs.next()){
				List<String> li = new ArrayList<>();
				for(int i = 1 ; i < 7 ; i++){
					String s = rs.getString(i);
					if(s==null){
						li.add("");
					}else{
						li.add(s);
					}
				}
				list.add(li);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return list;
	}
	public static TbKhInfo getKhInfo(Item item) {
		TbKhInfo kehu = new TbKhInfo();
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_khinfo where "
				+ where);
		try {
			if(rs.next()){
				kehu.setId(rs.getString("id").trim());
				kehu.setKhname(rs.getString("khname").trim());
				kehu.setJian(rs.getString("jian").trim());
				kehu.setAddress(rs.getString("address").trim());
				kehu.setBianma(rs.getString("bianma").trim());
				kehu.setTel(rs.getString("tel").trim());
				kehu.setFax(rs.getString("fax").trim());
				kehu.setLian(rs.getString("lian").trim());
				kehu.setLtel(rs.getString("ltel").trim());
				kehu.setMail(rs.getString("mail").trim());
				kehu.setXinhang(rs.getString("xinhang").trim());
				kehu.setHao(rs.getString("hao"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return kehu;
	}
	public static List getKhInfos() {
		List<List> infos = new ArrayList<>();
		infos = findForList("select * from tb_khinfo") ;
		closeResourse();
		return infos;
	}
	public static List getKucunInfos() {
		List<List> infos = new ArrayList<>();
		infos = findForList("select * from tb_kucun") ;
		closeResourse();
		return infos;
	}
	public static int updateKucunDj(TbKucun kcInfo) {
		int r = 0 ;
		r = update("update tb_kucun set dj='"+kcInfo.getDj()+"' where id ='"+kcInfo.getId()+"'");
		return r;
	}
	public static List getSpInfos() {
		List list = new ArrayList<>();
		list = findForList("select*from tb_spinfo");
		return list;
	}
	public static void addSp(TbSpinfo sp) {
		insert("insert into tb_spinfo values ('"+sp.getId()+"','"+sp.getSpname()+"','"+sp.getJc()+"','"+sp.getCd()+
				"','"+sp.getDw()+"','"+sp.getGg()+"','"+sp.getBz()+"','"+sp.getPh()+"','"+sp.getPzwh()+"','"+sp.getMemo()+"','"+sp.getGysname()+"')");
	}
	public static int delete(String string) {
		conn = dbm.getConnection() ;
		int result =0;
		try {
			st = conn.createStatement();
			result = st.executeUpdate(string);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return result;

	}
	public static int updateSp(TbSpinfo sp) {
		int re = update("update tb_spinfo set spname='"+sp.getSpname()+"',jc='"+sp.getJc()+"',cd='"+sp.getCd()+
				"',dw='"+sp.getDw()+"',gg='"+sp.getGg()+"',bz='"+sp.getBz()+"',ph='"+sp.getPh()+"',pzwh='"+sp.getPzwh()
				+"',memo='"+sp.getMemo()+"',gysname='"+sp.getGysname()+"' where id='"+sp.getId()+"'");
		return re;
	}
	public static void addKeHu(TbKhInfo kh) {
		
		insert("insert into tb_khinfo values ('"+kh.getId()+"','"+kh.getKhname()+"','"+kh.getJian()+"','"+
		kh.getAddress()+"','"+kh.getBianma()+"','"+kh.getTel()+"','"+kh.getFax()+"','"+kh.getLian()+"','"+kh.getLtel()+"','"+
				kh.getMail()+"','"+kh.getXinhang()+"','"+kh.getHao()+"')");
		
	}
	public static int updateKeHu(TbKhInfo kh) {
		int rs =update("update tb_khinfo set khname='"+kh.getKhname()+"',jian='"+kh.getJian()+"',address='"+kh.getAddress()+"',bianma='"+kh.getBianma()+"',tel='"+
	kh.getTel()+"',fax='"+kh.getFax()+"',lian='"+kh.getLian()+"',ltel='"+kh.getLtel()+"',mail='"+kh.getMail()+"',xinhang='"+kh.getXinhang()+"',hao='"+kh.getHao()+"' where id='"+kh.getId()+"'");
		return rs;
	}
	public static void addGys(TbGysInfo gys) {
		
		insert("insert into tb_gysinfo values('"+gys.getId()+"','"+gys.getName()+"','"+gys.getJc()+"','"+
				gys.getAddress()+"','"+gys.getBianma()+"','"+gys.getTel()+"','"+gys.getFax()+"','"+gys.getLian()+"','"+gys.getLtel()+"','"+
				gys.getYh()+"','"+gys.getMail()+"')");
		
	}
	public static int updateGys(TbGysInfo gys) {
		int rs = update("update tb_gysinfo set jc='"+gys.getJc()+"',address='"+gys.getAddress()+"',bianma='"+gys.getBianma()+"',tel='"+
	gys.getTel()+"',fax='"+gys.getFax()+"',lian='"+gys.getLian()+"',ltel='"+gys.getLtel()+"',yh='"+gys.getYh()+"',mail='"+gys.getMail()+"'");
		return rs;
	}
	public static TbJsr getJsr(String nameStr, String ageStr) {
		TbJsr jsr = new TbJsr();
		ResultSet rs =findForResultSet("select * from tb_jsr where name='"+nameStr+"' and age='"+ageStr+"'");
		try {
			while(rs.next()){
				jsr.setName(nameStr);
				jsr.setSex(rs.getString(2));
				jsr.setAge(ageStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeResourse();
		return jsr;
	}
	public static int addJsr(TbJsr jsr) {
		int r = 0 ;
		boolean rs =insert("insert into tb_jsr(name,sex,age,tel,enable) values('"+jsr.getName()+"','"+jsr.getSex()+"','"+jsr.getAge()+"','"+jsr.getTel()+"','5')");
		
		if(rs){
			r = 1 ;
		}
		return r;
	}
	public static int modifyPassword(String oldPassStr, String newPass1Str) {
		return update("update tb_userlist set pass='" + newPass1Str
				+ "' where pass='" + oldPassStr + "'");
	}
	public static boolean checkLogin(String username, String psw) {
		boolean re = false ;
		ResultSet rs = findForResultSet("select*from tb_userlist where username='"+username+"' and pass='"+psw+"'");
		if(rs != null)
			re = true;
		closeResourse();
		return re;
	}
}
