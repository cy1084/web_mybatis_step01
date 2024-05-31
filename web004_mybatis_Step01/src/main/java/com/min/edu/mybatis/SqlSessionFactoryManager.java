package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 환경설정 파일의 값은 Configuration.xml 파일과 mapper.xml 파일을 읽어서 
 * java 객체인 SqlSessionFactory 객체를 만들어야 한다
 * 따라서 설정되는 값들이 많기 때문에 xml을 통해 작성 후에, (ibatis에서 io를 구현한) Resources를 통해서 읽어내어
 * 값으로 변환한다
 * 웹 시스템은 CRUD가 기본이기 때문에 static으로 생성한다
 * 고려 사항: SqlSession이 생성된다는 것과, 접속을 하기 위한 정보가 같다는 것은 아니다.
 * => "SqlSessionFactory 객체 생성" 이 정상적으로 실행됐다고 해서 crud가 되는 것 아님
 * */
public class SqlSessionFactoryManager {
	private static SqlSessionFactory factory;

	static {
		//사용할 xml 위치(path)
		String path = "mybatis/Configuration.xml";
		try {
			//xml을 읽어서 MyBatis가 필요하는 값으로 변경(key=value)
			Reader reader = Resources.getResourceAsReader(path);
			// static이어서 throws는 못함
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 객체 생성");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
