package cn.itcast.tpms.dao;

import java.util.List;

import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.pojo.TrafficVo;

public interface TrafficDao extends BaseDao<Traffic, String>{
	//查询交警总数
	public Long findTrafficCount(TrafficVo trafficVo);
	//查询交警详细信息
	public List<Traffic> findTraffic(TrafficVo trafficVo, int firstResult, int maxResults);
	//交警登录
	public List<Traffic> findTraffic(TrafficVo trafficVo);
}
