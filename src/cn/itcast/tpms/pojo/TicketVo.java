package cn.itcast.tpms.pojo;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.tpms.domain.Ticket;

public class TicketVo extends Ticket{
	
	private String[] dlicensePlateNumbers = new String[10];

	
	public String[] getDlicensePlateNumbers() {
		return dlicensePlateNumbers;
	}
	public void setDlicensePlateNumbers(String[] dlicensePlateNumbers) {
		this.dlicensePlateNumbers = dlicensePlateNumbers;
	}
	
	private int page;
	private int rows;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
	private String pid;


	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
}
