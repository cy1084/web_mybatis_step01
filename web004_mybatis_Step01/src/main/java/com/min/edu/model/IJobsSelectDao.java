package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.JobsVo;

public interface IJobsSelectDao {

	/**
		primitive Type -> primitive Type
	 */
	public Integer select01(String jobid);
	
	/**
		primitive Type -> VO/DTO
	 */
	public JobsVo select02(String jobid);
	
	/**
	 	primitive Type -> VO/DTO
	 	SQL 문의 Alias를 변경해서 DTO(setter)와 매핑
	 */
	public JobsVo select03(String jobid);
	
	public Map<String, JobsVo> select04();
	
	
	/**
		입력 전달 값 여러 개 job_id, job_title
		DTO 객체를 통해 전달한다
	 */
	public JobsVo select05(JobsVo vo);
	
	
	/**
	 	입력 전달 값 여러 개 job_id, job_title
	 	java.util.Map을 통해 전달
	 */
	public List<JobsVo> select06(Map<String, Object> map);
	
	/**
	 	입력은 java.lang.Object로 처리
	 	MyBatis는 자동으로 형변환을 통해 값을 바인딩한다
	 	xml은 DTD에 의해 확인되고, 열림 태그 닫힘 태그가 있기 때문에 Entity Tag를 사용해야 한다
	 	sql문에서 크다와 작다의 문법을 tag로 인식하기 때문에 그 영역을 CDATA를 사용하면 
	 	문법으로 컴파일하지 않고 문자로 인식
	 */
	
	public List<JobsVo> select07(Object obj);
	
}
