package com.hui.javaBean;

import java.util.HashSet;
import java.util.Set;



public class TbRkthMain {
	private String rkthID;
	private Float pzs;
	private Float je;
	private String ysjl;
	private String gysname;
	private String rtdate;
	private String czy;
	private String jsr;
	private String jsfs;


	public TbRkthMain(String rkthID, Float pzs, Float je, String ysjl, String gysname, String rtdate, String czy,
			String jsr, String jsfs) {
		super();
		this.rkthID = rkthID;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.gysname = gysname;
		this.rtdate = rtdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}
	
	public String getRkthID() {
		return rkthID;
	}
	public void setRkthID(String rkthID) {
		this.rkthID = rkthID;
	}
	public Float getPzs() {
		return pzs;
	}
	public void setPzs(Float pzs) {
		this.pzs = pzs;
	}
	public Float getJe() {
		return je;
	}
	public void setJe(Float je) {
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
	public String getRtdate() {
		return rtdate;
	}
	public void setRtdate(String rtdate) {
		this.rtdate = rtdate;
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
	
	
}
