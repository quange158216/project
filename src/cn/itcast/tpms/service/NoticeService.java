package cn.itcast.tpms.service;

import java.util.List;

import cn.itcast.tpms.domain.Notice;
import cn.itcast.tpms.pojo.NoticeVo;

public interface NoticeService {
	//查尊公告总记录数
	public Long findNoticeCount();
	//查询公告详情
	public List<Notice> findNotice(int firstResult, int maxResults);
	//查询通知详情
	public Notice findNoticeById(String nid);
	//添加公告信息
	public void insertNotice(NoticeVo noticeVo);
	//删除公告信息
	public void deleteNotice(String nid);
}
