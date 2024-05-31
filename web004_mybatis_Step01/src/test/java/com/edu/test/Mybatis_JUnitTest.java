package com.edu.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobsVo;

public class Mybatis_JUnitTest {

	private SqlSession session;
	
	//먼저 실행
	@Before
	public void test() {
		SqlSessionFactory manager= SqlSessionFactoryManager.getFactory();
		session= manager.openSession();
		assertNotNull(session);
	}
	
	//@Test
	public void mapper_A_Test() {
		List<JobsVo> lists= session.selectList("com.min.edu.jobs.selectJobAll"); //namespace명.id명
		assertNotEquals(0,lists.size());
		
	}
	
	
	@Test
	public void voTest() {
		JobsVo vo=new JobsVo();
		System.out.println("lombok으로 생성된 메소드: "+vo.getJob_id());
	}

}
