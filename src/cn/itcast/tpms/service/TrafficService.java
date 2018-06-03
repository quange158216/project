package cn.itcast.tpms.service;

import java.util.List;

import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.pojo.TrafficVo;

public interface TrafficService {
	//查询交警总数
	public Long findTrafficCount(TrafficVo trafficVo);
	//查询交警详细信息
	public List<Traffic> findTraffic(TrafficVo trafficVo, int firstResult, int maxResults);
	//交警登录
	public List<Traffic> loginUser(TrafficVo trafficVo);
	//交警注册
	public void insertTraffic(TrafficVo trafficVo);
	//修改交警密码
	public void updateTrafficPassword(TrafficVo trafficVo, String pid);
}
