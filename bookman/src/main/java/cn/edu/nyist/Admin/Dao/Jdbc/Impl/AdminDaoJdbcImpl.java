package cn.edu.nyist.Admin.Dao.Jdbc.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nyist.Admin.Dao.AdminDao;
import cn.edu.nyist.bookman.Util.DsUtil;

public class AdminDaoJdbcImpl implements AdminDao {

	public boolean get(String name, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean ret = false;
		try {
			conn = DsUtil.getConn();
			//修改二：表用拼接字符串，用占位符写法
			//String sql = "select * from t_user where name='" + name + "' and pwd='" + pwd + "'";
			//?就是占位符，表示将来要用一个具体来替代改位置
			String sql = "select from t_book where name=? and pwd=?";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			//对特殊字符转义
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			//修改三:因为上面已经传入并非占位符赋值了，因而表再传
			//rs = stmt.executeQuery(sql);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DsUtil.free(rs, stmt, conn);
		}
		return ret;
	}

}
