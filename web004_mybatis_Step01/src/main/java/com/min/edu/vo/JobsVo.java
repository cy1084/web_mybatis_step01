package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 * POJO(Plain Old Java Object) 객체로 만들어서 DB에 입력할 때, 결과를 가져올 때, 화면으로 이동할 때 사용 => DTO/VO
 * 
 * 이름을 갖는 은닉화된 객체
 * 
 * MyBatis에 값을 전달 parameterType은 DTO 객체를 전달받았다면 DTO 객체에는 반드시 getter 함수가 있어야 한다
 * 									결과를 DTO 객체에 담으려면 setter 함수가 있어야 한다
 * 생성자는 필수!
 * 
 * Camel, Hungarian 방식으로 호출
 */

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JobsVo {

	private String job_id;
	private String job_title;
	private Integer min_salary;
	private Integer max_salary;
	
	//내일 아침엔 lombok 말고 getter setter 사용!
	
	//lombok -> getter,setter 선언할 필요 없음

}
