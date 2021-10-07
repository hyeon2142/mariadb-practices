package bookshop.test;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		
		insertTest();
		
	}

	private static void insertTest() {
		
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setAuthorNo(1L);
		vo.setStatus("대여가능");
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("뉴문");
		vo.setAuthorNo(1L);
		vo.setStatus("대여가능");
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("이클립스");
		vo.setAuthorNo(3L);
		vo.setStatus("대여가능");
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("디자인패턴");
		vo.setAuthorNo(4L);
		vo.setStatus("대여가능");
		dao.insert(vo);
		
	
		
	}

}
