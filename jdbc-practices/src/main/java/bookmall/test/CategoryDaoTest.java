package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		
		//insertTest();
		findallTest();
		//deleteTest(6);                // delete 사용 시 카테고리 번호를 넣어 줘야함
		//updateTest(1,"테스트");			// update 사용 시 카테고리 번호와 바꿀 카테고리명을 넣어 줘야함
		

	}

	// select Test
	private static void findallTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}

	}
	
	// delete Test
	private static void deleteTest(int c_num) {
		CategoryDao dao = new CategoryDao();
		dao.delete(c_num);
	}
	
	// update Test
	private static void updateTest(int c_num,String c_name) {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();
		dao.update(c_num, c_name);
	}
	
	// insert Test
	private static void insertTest() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();
		
		
		vo = new CategoryVo();
		vo.setC_name("소설");
		dao.insert(vo);
	
		vo = new CategoryVo();
		vo.setC_name("수필");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setC_name("컴퓨터/IT");
		dao.insert(vo);
		
		
	}
}
