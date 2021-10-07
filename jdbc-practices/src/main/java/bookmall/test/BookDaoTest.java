package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {

		// insertTest();
		// findallTest();
		// deleteTest(1);           // 삭제할 BOOK NUMBER 넣어줘야함 
		// updateTest(1,"테스트",20000,1);    // b_num, title, price, c_num

	}

	// select Test
	private static void findallTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}

	}

	// delete Test
	private static void deleteTest(int b_num) {
		BookDao dao = new BookDao();
		dao.delete(b_num);
	}

	// update Test
	private static void updateTest(int b_num, String title, int price, int c_num) {
		BookDao dao = new BookDao();
		dao.update(c_num, title, price, c_num);
	}

	// insert Test
	private static void insertTest() {
		BookVo vo = null;
		BookDao dao = new BookDao();

		vo = new BookVo();
		vo.setTitle("개미");
		vo.setPrice(14000);
		vo.setC_num(1);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("흑사병");
		vo.setPrice(20000);
		vo.setC_num(2);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("총,균,쇠");
		vo.setPrice(10000);
		vo.setC_num(3);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("나무");
		vo.setPrice(30000);
		vo.setC_num(4);
		dao.insert(vo);

	}

}
