package cn.edu.nyist.Admin.Dao;

import cn.edu.nyist.bookman.Vo.BookVo;

public interface BookDao {
	//int save(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
		int save(BookVo bookVo);
}
