package cn.itcast.tpms.dao;

import java.util.List;

import cn.itcast.tpms.domain.DetialCat;
import cn.itcast.tpms.pojo.DetialCatVo;

public interface DetialCatDao extends BaseDao<DetialCat, String>{

	//车辆总记录数
	public Long  findDetialCatCount(DetialCatVo detialCatVo);
	//根据用户uid查询车辆信息
	public List<DetialCat> findDetialCatByUid(DetialCatVo detialCatVo,int firstResult,int maxResults);
}
