package cn.itcast.tpms.pojo;

import java.util.List;

import cn.itcast.tpms.domain.Notice;

public class NoticeVo extends Notice{

	//当前页码
	private int pageCode;
	//总记录数
	private Long totalCount;
	//页面显示记录数
	private int pageSize;
	//总页数
	private int totalPage;
	//存放公告信息
	private List<Notice> noticesList;
	//表示那个用户
	private int ut;
	//表示管理员
	private int manager;
	private int pc;
	
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getUt() {
		return ut;
	}
	public void setUt(int ut) {
		this.ut = ut;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getTotalPage() {
		totalPage = (int) (totalCount /pageSize);
		if(totalCount % pageSize == 0) {
			return totalPage;
		}
		return totalPage + 1;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Notice> getNoticesList() {
		return noticesList;
	}
	public void setNoticesList(List<Notice> noticesList) {
		this.noticesList = noticesList;
	}

	
	
}
