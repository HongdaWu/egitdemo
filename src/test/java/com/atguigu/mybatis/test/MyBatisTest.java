package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.pojo.Employee;


public class MyBatisTest {
		private SqlSessionFactory sqlSessionFactory;
		//?????
		@Before
		public void testBuildSqlSessionFactory() throws IOException {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		@Test
		public void testGetSqlSession() {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Employee result = sqlSession.selectOne("myemployee.selectEmp",1);
			System.out.println(result);
		}
}

