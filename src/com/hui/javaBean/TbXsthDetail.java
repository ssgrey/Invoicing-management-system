package com.hui.javaBean;
public class TbXsthDetail implements java.io.Serializable {
	private Float id;
	private String tbXsthMain;
	private String spid;
	private Float dj;
	private Float sl;
	public TbXsthDetail(Float id, String tbXsthMain, String spid, Float dj, Float sl) {
		super();
		this.id = id;
		this.tbXsthMain = tbXsthMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}
	public Float getId() {
		return id;
	}
	public void setId(Float id) {
		this.id = id;
	}
	public String getTbXsthMain() {
		return tbXsthMain;
	}
	public void setTbXsthMain(String tbXsthMain) {
		this.tbXsthMain = tbXsthMain;
	}
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public Float getDj() {
		return dj;
	}
	public void setDj(Float dj) {
		this.dj = dj;
	}
	public Float getSl() {
		return sl;
	}
	public void setSl(Float sl) {
		this.sl = sl;
	}

}