package com.min.edu.model;

import java.util.Map;

import com.min.edu.vo.JobsVo;

public interface IJobsIDUDao {

	public int insert01(JobsVo vo);
	
	public int update01(Map<String, Object> map);
	
	public boolean delete01(Map<String, Object> obj);
}
