package cn.itcast.tpms.domain;
// Generated Mar 17, 2018 9:36:51 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * DetialCat generated by hbm2java
 */
public class DetialCat implements java.io.Serializable {

	private String dlicensePlateNumber;
	private Users users;
	private String dcolor;
	private String dengineType;
	private String dtype;
	private String dbrand;
	@JSONField(format="yyyy-MM-dd HH-mm-ss")
	private Date dcreatetime;
	private String dpic;
	private String ticket;
	@JSONField(serialize=false)
	private Set tickets = new HashSet(0);

	public DetialCat() {
	}

	public DetialCat(String dlicensePlateNumber, Users users, String dcolor, String dengineType, String dtype,
			String dbrand, Date dcreatetime) {
		this.dlicensePlateNumber = dlicensePlateNumber;
		this.users = users;
		this.dcolor = dcolor;
		this.dengineType = dengineType;
		this.dtype = dtype;
		this.dbrand = dbrand;
		this.dcreatetime = dcreatetime;
	}

	public DetialCat(String dlicensePlateNumber, Users users, String dcolor, String dengineType, String dtype,
			String dbrand, Date dcreatetime, String dpic, String ticket, Set tickets) {
		this.dlicensePlateNumber = dlicensePlateNumber;
		this.users = users;
		this.dcolor = dcolor;
		this.dengineType = dengineType;
		this.dtype = dtype;
		this.dbrand = dbrand;
		this.dcreatetime = dcreatetime;
		this.dpic = dpic;
		this.ticket = ticket;
		this.tickets = tickets;
	}

	public String getDlicensePlateNumber() {
		return this.dlicensePlateNumber;
	}

	public void setDlicensePlateNumber(String dlicensePlateNumber) {
		this.dlicensePlateNumber = dlicensePlateNumber;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDcolor() {
		return this.dcolor;
	}

	public void setDcolor(String dcolor) {
		this.dcolor = dcolor;
	}

	public String getDengineType() {
		return this.dengineType;
	}

	public void setDengineType(String dengineType) {
		this.dengineType = dengineType;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDbrand() {
		return this.dbrand;
	}

	public void setDbrand(String dbrand) {
		this.dbrand = dbrand;
	}

	public Date getDcreatetime() {
		return this.dcreatetime;
	}

	public void setDcreatetime(Date dcreatetime) {
		this.dcreatetime = dcreatetime;
	}

	public String getDpic() {
		return this.dpic;
	}

	public void setDpic(String dpic) {
		this.dpic = dpic;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Set getTickets() {
		return this.tickets;
	}

	public void setTickets(Set tickets) {
		this.tickets = tickets;
	}

}
