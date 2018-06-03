package cn.itcast.tpms.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.tpms.dao.DetialCatDao;
import cn.itcast.tpms.domain.DetialCat;
import cn.itcast.tpms.pojo.DetialCatVo;
import cn.itcast.tpms.service.DetialCatService;

@Service("detialCatService")
public class DetialCatServiceImpl implements DetialCatService{

	@Autowired
	private DetialCatDao detialCatDao;
	
	/**
	 * 车辆总记录数
	 */
	@Override
	public Long findDetialCatCount(DetialCatVo detialCatVo) {
		return detialCatDao.findDetialCatCount(detialCatVo);
	}
	/**
	 * 车辆总信息
	 */
	@Override
	public List<DetialCat> findDetialCatByUid(DetialCatVo detialCatVo, int firstResult, int maxResults) {
		return detialCatDao.findDetialCatByUid(detialCatVo, firstResult, maxResults);
		
	}

	@Test
	public void test() {
		DetialCat detialCat = detialCatDao.findById("皖A-88888");
		System.out.println(detialCat);
		
	}
	/**
	 * 根据车牌号查询汽车信息
	 */
	@Override
	public DetialCat findDetialCat(String  dlicensePlateNumber) {
		return detialCatDao.findById(dlicensePlateNumber);
	}
	/**
	 * 添加汽车信息
	 */
	@Override
	public void insertCat(DetialCatVo detialCatVo) {
		if(detialCatVo == null) {
			throw new RuntimeException("数据异常");
		}
		DetialCat detialcat = new DetialCat();
		BeanUtils.copyProperties(detialCatVo, detialcat);
		
	
		
		detialCatDao.insert(detialcat);
		
	}
	

}
