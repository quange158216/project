package cn.itcast.tpms.dao;

import java.util.List;

import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.UsersVo;

public interface UsersDao extends BaseDao<Users, String>{
	//查询用户总数
	public Long findUsersCount(UsersVo usersVo);
	//查询用户信息
	public List<Users> findUsers(UsersVo usersVo, int firstResult, int maxResults);
	//用户登录
	public List<Users> findUser(UsersVo usersVo);
	
}
