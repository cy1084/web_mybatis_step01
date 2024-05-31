package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobsVo;

public class JobsIDUDaoImpl implements IJobsIDUDao {

	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.JobsIDUDaoImpl.";

	@Override
	public int insert01(JobsVo vo) {
		log.info("insert01 입력: " + vo);
		SqlSession session = manager.openSession(true);
		// openSession(): DB와의 접속을 만들어줌(pooled 방식)
		// openSession() default 값은 false이다.
		int n = session.insert(NS + "insert01", vo);
		session.commit(); // 수동 commit
		return n;
	}

	@Override
	public int update01(Map<String, Object> map) {
		log.info("update01 수정");
		SqlSession session = manager.openSession(true); 
		return session.update(NS+"update01",map);
	}
	
	@Override
	public boolean delete01(Map<String, Object> obj) {
		log.info("delete01 반드시 SQL문의 바인딩되는 변수명을 확인");
		SqlSession session = manager.openSession(true); // auto commit;
		int n = session.delete(NS + "delete01", obj);
		return (n > 0) ? true : false;
	}

}
