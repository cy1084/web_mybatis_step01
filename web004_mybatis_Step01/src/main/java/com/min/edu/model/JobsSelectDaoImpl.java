package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobsVo;

public class JobsSelectDaoImpl implements IJobsSelectDao {

	// 사용자 로그
	private Logger log = Logger.getLogger(this.getClass());
	// mapper xml의 namespace 선언
	private final String NS = "com.min.edu.model.JobsSelectDaoImpl.";

	// SqlSessionFactory 객체
	private SqlSessionFactory manager;

	public JobsSelectDaoImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}

	@Override
	public Integer select01(String jobid) {
		log.trace("select01 TRACE 로그");
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "select01", jobid);
	}

	@Override
	public JobsVo select02(String jobid) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "select02", jobid);
	}
	
	@Override
	public JobsVo select03(String jobid) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "select03", jobid);
	}
	
	/**
	 * resultType을 JSF인 java.util.Map으로 처리
	 * "{[
	 * 		{"key:{"job_id":"","job_title":"","min_salary":"","max_salary":""}},
	 * 		{"key:{"job_id":"","job_title":"","min_salary":"","max_salary":""}}
	 * ]}"
	 * 
	 */
	@Override
	public Map<String, JobsVo> select04(){
		/*<key값, JobsVo에서 가져온 데이터*/
		log.info("결과가 java.util.Map인 경우 반드시 key가 되는 컬럼을 선정해줘야 한다");
		SqlSession session=manager.openSession();
		Map<String, JobsVo> jobsMap=session.selectMap(NS+"select04","JOB_ID");
		return jobsMap;
		
	}
	
	@Override
	public JobsVo select05(JobsVo vo) {
		log.info("입력하는 parameter가 여러개라면 DTO를 사용하여 getter를 통해 전달한다");
		SqlSession session=manager.openSession();
		return session.selectOne(NS+"select05",vo);
	}

	@Override
	public List<JobsVo> select06(Map<String, Object> map){
		SqlSession session=manager.openSession(); //mybatis 접속을 위한 session
		
		return session.selectList(NS+"select06",map);
	}
	
	@Override
	public List<JobsVo> select07(Object obj) {
		log.info("SQL문의 CDATA 처리");
		SqlSession session= manager.openSession();
		return session.selectList(NS+"select07",obj);
	}
	

}
