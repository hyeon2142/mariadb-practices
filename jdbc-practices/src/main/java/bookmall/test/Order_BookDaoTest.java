package bookmall.test;

import java.util.List;

import bookmall.dao.Order_BookDao;
import bookmall.vo.Order_BookVo;

public class Order_BookDaoTest {

	public static void main(String[] args) {

		// insertTest();
		 findallTest();
		// deleteTest(2,1); // delete 사용 시 카테고리 번호를 넣어 줘야함
		// updateTest(1,1,3,20000); // update 사용 시 주문번호, 책 번호, 수량, 가격 입력

	}

	// select Test
	private static void findallTest() {
		List<Order_BookVo> list = new Order_BookDao().findAll();
		for (Order_BookVo vo : list) {
			System.out.println(vo);
		}

	}

	// delete Test
	private static void deleteTest(int o_num,int b_num) {
		Order_BookDao dao = new Order_BookDao();
		dao.delete(o_num,b_num);
	}

	// update Test
	private static void updateTest(int o_num,int b_num,int quantity) {
		Order_BookVo vo = null;
		Order_BookDao dao = new Order_BookDao();
		dao.update(o_num, b_num, quantity);
	}

	// insert Test
	private static void insertTest() {
		Order_BookVo vo = null;
		Order_BookDao dao = new Order_BookDao();

		vo = new Order_BookVo();
		vo.setO_num(1);
		vo.setB_num(5);
		vo.setQuantity(2);
		dao.insert(vo);

	}

}
