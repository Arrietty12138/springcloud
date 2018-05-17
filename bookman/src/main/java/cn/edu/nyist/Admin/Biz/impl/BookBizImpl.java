package cn.edu.nyist.Admin.Biz.impl;

import cn.edu.nyist.Admin.Biz.BookBiz;
import cn.edu.nyist.Admin.Dao.BookDao;
import cn.edu.nyist.Admin.Dao.Jdbc.Impl.BookDaoJdbcImpl;
import cn.edu.nyist.bookman.Vo.BookVo;

public class BookBizImpl implements BookBiz {
	@Override
	public int saveBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(bookVo);
	}
}
