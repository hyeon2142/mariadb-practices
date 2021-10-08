package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {

		// insertTest();
		 findallTest();
		// deleteTest(1,1); // 삭제할 BOOK NUMBER 넣어줘야함
		// updateTest(1,1,3); // 회원 번호, 책 번호, 수량

	}
	
	// select Test
		private static void findallTest() {
			List<CartVo> list = new CartDao().findAll();
			for (CartVo vo : list) {
				System.out.println(vo);
			}

		}

		// delete Test
		private static void deleteTest(int m_num, int b_num) {
			CartDao dao = new CartDao();
			dao.delete(m_num, b_num);
		}

		// update Test
		private static void updateTest(int m_num, int b_num, int quantity) {
			CartDao dao = new CartDao();
			dao.update(m_num,b_num,quantity);
		}

		// insert Test
		private static void insertTest() {
			CartVo vo = null;
			CartDao dao = new CartDao();

			vo = new CartVo();
			vo.setM_num(1);
			vo.setB_num(1);
			vo.setQuantity(2);
			dao.insert(vo);
			
			vo = new CartVo();
			vo.setM_num(2);
			vo.setB_num(3);
			vo.setQuantity(2);
			dao.insert(vo);

			

		}
	

}
