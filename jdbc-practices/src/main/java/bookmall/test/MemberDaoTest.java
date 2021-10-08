package bookmall.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;


public class MemberDaoTest {

	public static void main(String[] args) {

		// insertTest();
		 findallTest();
		// deleteTest(2); // delete 사용 시 카테고리 번호를 넣어 줘야함
		// updateTest(1,"테스트"); // update 사용 시 카테고리 번호와 바꿀 카테고리명을 넣어 줘야함

	}

	// select Test
	private static void findallTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}

	}

	// delete Test
	private static void deleteTest(int m_num) {
		MemberDao dao = new MemberDao();
		dao.delete(m_num);
	}

	// update Test
	private static void updateTest(int m_num, String name, String email, String password, String tel) {
		MemberVo vo = null;
		MemberDao dao = new MemberDao();
		dao.update(m_num,name,email,password,tel);
	}

	// insert Test
	private static void insertTest() {
		MemberVo vo = null;
		MemberDao dao = new MemberDao();

		vo = new MemberVo();
		vo.setName("이동현");
		vo.setEmail("hyeon2142@naver.com");
		vo.setPassword("hyeon123");
		vo.setTel("010-3997-7968");
		dao.insert(vo);

		vo = new MemberVo();
		vo.setName("김민수");
		vo.setEmail("Minsu123@naver.com");
		vo.setPassword("minsu1111");
		vo.setTel("010-1234-5678");
		dao.insert(vo);


	}

}
