package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		// insertTest();
		// findallTest();
		// deleteTest(1); // delete 사용 시 카테고리 번호를 넣어 줘야함
		// updateTest(1,"테스트"); // update 사용 시 주문번호, 식별번호, 결제금액, 주소, 회원번호 적어줘야함

	}

	// select Test
	private static void findallTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}

	}

	// delete Test
	private static void deleteTest(int o_num) {
		OrderDao dao = new OrderDao();
		dao.delete(o_num);
	}

	// update Test
	private static void updateTest(int o_num, int ordernum, int payment, String address, int m_num) {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();
		dao.update(o_num, ordernum, payment, address, m_num);
	}

	// insert Test
	private static void insertTest() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();

		vo = new OrderVo();
		vo.setOrdernum(20211006);
		vo.setPayment(14000);
		vo.setAddress("부산광역시");
		vo.setM_num(1);
		dao.insert(vo);

	}

}
