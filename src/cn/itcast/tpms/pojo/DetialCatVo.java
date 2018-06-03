package cn.itcast.tpms.pojo;

import cn.itcast.tpms.domain.DetialCat;

public class DetialCatVo extends DetialCat{

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
}
