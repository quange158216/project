package cn.itcast.tpms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.tpms.dao.TrafficDao;
import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.pojo.TrafficVo;
import cn.itcast.tpms.service.TrafficService;

@Service("trafficService")
public class TrafficServiceImpl implements TrafficService{

	
	@Autowired
	private TrafficDao trafficDao;
	/**
	 * 查询交警总数
	 */
	@Override
	public Long findTrafficCount(TrafficVo trafficVo) {
		return trafficDao.findTrafficCount(trafficVo);
	}

	@Override
	public List<Traffic> findTraffic(TrafficVo trafficVo, int firstResult, int maxResults) {
		return trafficDao.findTraffic(trafficVo, firstResult, maxResults);
	}

	/**
	 * 交警登录
	 */
	@Override
	public List<Traffic> loginUser(TrafficVo trafficVo) {
		return trafficDao.findTraffic(trafficVo);
	}

	/**
	 * 交警注册
	 */
	@Override
	public void insertTraffic(TrafficVo trafficVo) {
		if(trafficVo == null) {
			throw new RuntimeException("数据异常");
		}
		
		Traffic traffic = new Traffic();
		
		BeanUtils.copyProperties(trafficVo, traffic);
		
		trafficDao.insert(traffic);
	}

	@Override
	public void updateTrafficPassword(TrafficVo trafficVo, String pid) {
		Traffic traffic = trafficDao.findById(pid);
		
		String ppassword = trafficVo.getPpassword();
		
		traffic.setPpassword(ppassword);
		
	}

}
