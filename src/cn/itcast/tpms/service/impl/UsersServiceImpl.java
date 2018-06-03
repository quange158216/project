package cn.itcast.tpms.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.tpms.dao.UsersDao;
import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.UsersVo;
import cn.itcast.tpms.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;
	

	@Override
	public Long findUsersCount(UsersVo usersVo) {
		return usersDao.findUsersCount(usersVo);
	}

	@Override
	public List<Users> findUsers(UsersVo usersVo, int firstResult, int maxResults) {
		return usersDao.findUsers(usersVo, firstResult, maxResults);
	}

	/**
	 * 用户登录
	 */
	@Override
	public List<Users> loginUser(UsersVo usersVo) {
		return usersDao.findUser(usersVo);
	}

	/**
	 * 注册用户
	 */
	@Override
	public void insertuser(UsersVo usersVo) {
		if(usersVo == null) {
			throw new RuntimeException("数据异常");
		}
		Users user = new Users();
		BeanUtils.copyProperties(usersVo, user);
		
		usersDao.insert(user);
	}

	/**
	 * 修改用户密码
	 */
	@Override
	public void updateUserPasswor(UsersVo usersVo,String uid) {
		
		Users users = usersDao.findById(uid);
		
		String upassword = usersVo.getUpassword();
		users.setUpassword(upassword);
	}
	
}
