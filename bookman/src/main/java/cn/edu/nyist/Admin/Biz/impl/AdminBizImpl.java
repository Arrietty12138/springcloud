package cn.edu.nyist.Admin.Biz.impl;

import cn.edu.nyist.Admin.Biz.AdimnBiz;
import cn.edu.nyist.Admin.Dao.AdminDao;
import cn.edu.nyist.Admin.Dao.Jdbc.Impl.AdminDaoJdbcImpl;

public class AdminBizImpl implements AdimnBiz{
	@Override
	public boolean findAdminByNameAndPwd(String name, String pwd) {
		AdminDao adminDao=new AdminDaoJdbcImpl();
		return adminDao.get(name,pwd);
	}

}
