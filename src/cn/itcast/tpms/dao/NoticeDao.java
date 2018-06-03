package cn.itcast.tpms.dao;

import java.util.List;

import cn.itcast.tpms.domain.Notice;

public interface NoticeDao extends BaseDao<Notice, String>{
	//查询公告总记录数
	public Long findNoticeCount();
	//查询公告详情
	public List<Notice> findNotice(int firstResult, int maxResults);
}
