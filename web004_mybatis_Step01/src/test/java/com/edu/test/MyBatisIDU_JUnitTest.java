package com.edu.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import com.min.edu.model.IJobsIDUDao;
import com.min.edu.model.JobsIDUDaoImpl;
import com.min.edu.vo.JobsVo;

public class MyBatisIDU_JUnitTest {

	private IJobsIDUDao dao; //여기에 new 금지, 초기화만!
	
	
	public MyBatisIDU_JUnitTest() {
		dao=new JobsIDUDaoImpl();
	}
	
	//@Test
	public void insert01_JUnitTest() {
		int row = dao.insert01(new JobsVo("IT","IT",1000,1000));
		assertEquals(1, row);
		
	}
	
	@Test
	public void update01_JUnitTest() {
		int row=dao.update01(new HashMap<String,Object>(){{
			put("oldid","IT_PROG");
			put("newid","IT_DEV");
			put("oldtitle","");
			put("newtitle","개발자");
		}});
		System.out.println(row);
		assertEquals(2,row);
	}
	
	//@Test
	public void delete01_JUnitTest() {
		boolean isc=
				dao.delete01(new HashMap<String,Object>(){{
					put("id","IT");
					put("title","IT");
				}});
		assertTrue(isc);
	}
	
	

}
