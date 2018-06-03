package cn.itcast.tpms.pojo;

import cn.itcast.tpms.domain.Manager;
import cn.itcast.tpms.domain.Users;

public class ManagerVo extends Manager{
	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
