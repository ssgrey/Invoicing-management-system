package com.hui.javaBean;
public class TbRukuDetail  {
	private String id;
	private String rkID;
	private String spid;
	private Float dj;
	private Float sl;
	
	
	public TbRukuDetail(String id, String rkID, String spid, Float dj, Float sl) {
		super();
		this.id = id;
		this.rkID = rkID;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}
	public TbRukuDetail() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRkID() {
		return rkID;
	}
	public void setRkID(String rkID) {
		this.rkID = rkID;
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