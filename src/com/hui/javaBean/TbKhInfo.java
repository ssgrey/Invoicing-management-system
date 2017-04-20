package com.hui.javaBean;
/**
 * �ͻ�������Ϣ
 * @author Administrator
 *
 */
public class TbKhInfo {
	private String id;
	private String khname;
    private String jian;
    private String address;
    private String bianma;
    private String tel;
    private String fax;
    private String lian;
    private String ltel;
    private String mail;
    private String xinhang;
    private String hao;
    
    
    
    public TbKhInfo(String id, String khname, String jian, String address, String bianma, String tel, String fax,
			String lian, String ltel, String mail, String xinhang, String hao) {
		super();
		this.id = id;
		this.khname = khname;
		this.jian = jian;
		this.address = address;
		this.bianma = bianma;
		this.tel = tel;
		this.fax = fax;
		this.lian = lian;
		this.ltel = ltel;
		this.mail = mail;
		this.xinhang = xinhang;
		this.hao = hao;
	}
	public TbKhInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKhname() {
		return khname;
	}
	public void setKhname(String khname) {
		this.khname = khname;
	}
	public String getJian() {
		return jian;
	}
	public void setJian(String jian) {
		this.jian = jian;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBianma() {
		return bianma;
	}
	public void setBianma(String bianma) {
		this.bianma = bianma;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getLian() {
		return lian;
	}
	public void setLian(String lian) {
		this.lian = lian;
	}
	public String getLtel() {
		return ltel;
	}
	public void setLtel(String ltel) {
		this.ltel = ltel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getXinhang() {
		return xinhang;
	}
	public void setXinhang(String xinhang) {
		this.xinhang = xinhang;
	}
	public String getHao() {
		return hao;
	}
	public void setHao(String hao) {
		this.hao = hao;
	}

}
