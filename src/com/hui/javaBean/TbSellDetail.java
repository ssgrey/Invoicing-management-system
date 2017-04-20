package com.hui.javaBean;
public class TbSellDetail  {
	private String id;
	private String sellID;
	private String spid;
	private Float dj;
	private Float sl;
	public TbSellDetail(String id, String sellID, String spid, Float dj, Float sl) {
		super();
		this.id = id;
		this.sellID = sellID;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}
	public TbSellDetail() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSellID() {
		return sellID;
	}
	public void setSellID(String sellID) {
		this.sellID = sellID;
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