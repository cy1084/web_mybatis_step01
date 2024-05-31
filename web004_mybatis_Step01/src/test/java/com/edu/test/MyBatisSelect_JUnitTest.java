package com.edu.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobsSelectDao;
import com.min.edu.model.JobsSelectDaoImpl;
import com.min.edu.vo.JobsVo;

public class MyBatisSelect_JUnitTest {

	private IJobsSelectDao dao;

	@Before
	public void init() {
		dao = new JobsSelectDaoImpl();
	}

	// @Test
	public void test() {
		// 검색된 결과의 값이 없다면 MyBatis의 selectOne은 null 객체를 반환한다
		// selectOne의 결과는 null이거나 하나의 객체(resultType).
		// 근데 sql문의 결과가 여러 개라면 too many의 오류를 발생시킨다
		Integer minSalary = dao.select01("IT_PROG");
		assertNotNull(minSalary);
	}

	//@Test
	public void select02_JUnitTest() {

		// selectOne의 실행 결과가 공집합이라면 null로 반환
		JobsVo vo = dao.select02("PR_REP");
		System.out.println("select02의 결과: \n" + vo);
		assertNotNull(vo);
	}

	//@Test
	public void select03_JUnitTest() {
		JobsVo playerToVo = dao.select03("2007155");
		System.out.println("select03의 결과: \n" + playerToVo);
		assertNotNull(playerToVo);
	}
	
	//@Test
	public void select04_JUnitTest() {
		Map<String, JobsVo> jobsMap  = dao.select04();
		System.out.println("select04의 결과: \n" + jobsMap);
		
		//하나의 결과만 가져오고 싶을 때
		System.out.println("select04의 결과: \n" + jobsMap.get("AD_VP"));
		System.out.println("select04의 결과: \n" + jobsMap.get("AD_VP").getMax_salary());
		assertNotNull(jobsMap);
	}
	
	//@Test
	public void select05_JUnitTest() {
		JobsVo vo=dao.select05(new JobsVo("AD_PRES","President",null,null));
		System.out.println("select05의 결과: " +vo);
		assertNotNull(vo);
	}
	
	//@Test
	public void select06_JUnitTest() {
		List<JobsVo> jobsList=dao.select06(new HashMap<String,Object>()
			{{
				put("id","AD_PRES");
				put("title","President");
			}});
		assertNotEquals(0, jobsList.size());
	}
	
	@Test
	public void select07_JUnitTest() {		
		Object obj=3000;
		List<JobsVo> jobsList=dao.select07(obj);
		assertNotEquals(0, jobsList.size());
	}
}
