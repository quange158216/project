package cn.itcast.tpms.service;

import java.util.List;

import cn.itcast.tpms.domain.DetialCat;
import cn.itcast.tpms.pojo.DetialCatVo;

public interface DetialCatService {
	//车辆信息
	public List<DetialCat> findDetialCatByUid(DetialCatVo detialCatVo,int firstResult,int maxResults);
	//车辆总记录数
	public Long findDetialCatCount(DetialCatVo detialCatVo);
	//根据汽车牌号查询车辆信息
	public DetialCat findDetialCat(String dlicensePlateNumber);
	//添加汽车信息
	public void insertCat(DetialCatVo detialCatVo);
}
