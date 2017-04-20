package com.hui.javaBean;
import java.util.HashSet;
import java.util.Set;
public class TbRukuMain  implements java.io.Serializable {
	private String rkID;
	private Float pzs;
	private String je;
	private String ysjl;
	private String gysname;
	private String rkdate;
	private String czy;
	private String jsr;
	private String jsfs;
	private Set<TbRukuDetail> set = new HashSet<TbRukuDetail>() ;
	
	public Set<TbRukuDetail> getSet() {
		return set;
	}

	public void setSet(Set<TbRukuDetail> set) {
		this.set = set;
	}
	
	
	public String getRkID() {
		return rkID;
	}
	public void setRkID(String rkID) {
		this.rkID = rkID;
	}
	public Float getPzs() {
		return pzs;
	}
	public void setPzs(Float pzs) {
		this.pzs = pzs;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getYsjl() {
		return ysjl;
	}
	public void setYsjl(String ysjl) {
		this.ysjl = ysjl;
	}
	public String getGysname() {
		return gysname;
	}
	public void setGysname(String gysname) {
		this.gysname = gysname;
	}
	public String getRkdate() {
		return rkdate;
	}
	public void setRkdate(String rkdate) {
		this.rkdate = rkdate;
	}
	public String getCzy() {
		return czy;
	}
	public void setCzy(String czy) {
		this.czy = czy;
	}
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getJsfs() {
		return jsfs;
	}
	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}
	public TbRukuMain(String rkID, Float pzs, String je, String ysjl, String gysname, String rkdate, String czy,
			String jsr, String jsfs) {
		super();
		this.rkID = rkID;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.gysname = gysname;
		this.rkdate = rkdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}
   
}