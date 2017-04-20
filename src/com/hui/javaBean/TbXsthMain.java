package com.hui.javaBean;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class TbXsthMain implements java.io.Serializable {
	private String xsthID;
	private Float pzs;
	private Float je;
	private String ysjl;
	private String khname;
	private String thdate;
	private String czy;
	private String jsr;
	private String jsfs;
	public String getXsthID() {
		return xsthID;
	}
	public void setXsthID(String xsthID) {
		this.xsthID = xsthID;
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
	public String getKhname() {
		return khname;
	}
	public void setKhname(String khname) {
		this.khname = khname;
	}
	public String getThdate() {
		return thdate;
	}
	public void setThdate(String thdate) {
		this.thdate = thdate;
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
	public TbXsthMain(String xsthID, Float pzs, Float je, String ysjl, String khname, String thdate, String czy,
			String jsr, String jsfs) {
		super();
		this.xsthID = xsthID;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.thdate = thdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}
	
	
}