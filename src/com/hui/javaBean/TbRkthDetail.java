package com.hui.javaBean;

public class TbRkthDetail {
	private Float id;
	private String tbRkthMain;
	private String spid;
	private Float dj;
	private Float sl;
	
	public TbRkthDetail() {
		super();
	}
	public TbRkthDetail(Float id, String tbRkthMain, String spid, Float dj, Float sl) {
		super();
		this.id = id;
		this.tbRkthMain = tbRkthMain;
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
	public String getTbRkthMain() {
		return tbRkthMain;
	}
	public void setTbRkthMain(String tbRkthMain) {
		this.tbRkthMain = tbRkthMain;
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
