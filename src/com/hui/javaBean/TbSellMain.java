package com.hui.javaBean;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class TbSellMain implements java.io.Serializable {
	private String sellId;
	private Float pzs;
	private String je;
	private String ysjl;
	private String khname;
	private String xsdate;
	private String czy;
	private String jsr;
	private String jsfs;
	private Set<TbSellDetail> set = new HashSet<TbSellDetail>();
	public TbSellMain(String sellId, Float pzs, String je, String ysjl, String khname, String xsdate, String czy,
			String jsr, String jsfs) {
		super();
		this.sellId = sellId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.xsdate = xsdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}
	public String getSellId() {
		return sellId;
	}
	public void setSellId(String sellId) {
		this.sellId = sellId;
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
	public String getKhname() {
		return khname;
	}
	public void setKhname(String khname) {
		this.khname = khname;
	}
	public String getXsdate() {
		return xsdate;
	}
	public void setXsdate(String xsdate) {
		this.xsdate = xsdate;
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
	public Set<TbSellDetail> getTbSellDetails() {
		
		return this.set;
	}
	
}