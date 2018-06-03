package cn.itcast.tpms.service.impl;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.tpms.dao.NoticeDao;
import cn.itcast.tpms.domain.Notice;
import cn.itcast.tpms.pojo.NoticeVo;
import cn.itcast.tpms.service.NoticeService;
import cn.itcast.tpms.utils.IDUtils;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	
	@Autowired
	private NoticeDao noticeDao;

	/**
	 * 查询公告总记录数
	 */
	@Override
	public Long findNoticeCount() {
		return noticeDao.findNoticeCount();
	}

	/**
	 * 查询公告详情
	 */
	@Override
	public List<Notice> findNotice(int firstResult, int maxResults) {
		return noticeDao.findNotice(firstResult, maxResults);
	}
	
	@Test
	public void text() {
		Notice notice = noticeDao.findById("1");
		System.out.println(notice);
	}

	/**
	 * 通知详情
	 */
	@Override
	public Notice findNoticeById(String nid) {
		return noticeDao.findById(nid);
	}

	@Override
	public void insertNotice(NoticeVo noticeVo) {
		if(noticeVo == null) {
			throw new RuntimeException("数据异常");
		}
		Notice notice = new Notice();
		
		BeanUtils.copyProperties(noticeVo, notice);
		
		notice.setNid(UUID.randomUUID().toString().replace("-", ""));
		
		noticeDao.insert(notice);
		
	}
	/**
	 * 删除公告
	 */
	@Override
	public void deleteNotice(String nid) {
		noticeDao.deleteById(nid);
		
	}
}
