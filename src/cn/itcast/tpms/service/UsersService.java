package cn.itcast.tpms.service;

import java.util.List;

import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.UsersVo;

public interface UsersService {
	
	//查询用户总数
	public Long findUsersCount(UsersVo usersVo);
	//查询用户详细信息
	public List<Users> findUsers(UsersVo usersVo,int firstResult, int maxResults);
	//用户登录
	public List<Users> loginUser(UsersVo usersVo);
	public void  insertuser(UsersVo usersVo);
	//修改用户密码
	public void updateUserPasswor(UsersVo usersVo,String uid);
}
