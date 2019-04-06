package com.zhd.test;
/**
 * 多对多
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zhd.bean.Authority;
import com.zhd.bean.User;

public class ManyToManyMainTest {

	public static void main(String[] args) {
		//创建entityMangerFactory工厂
				EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("jpa_many_to_many");
				//创建entityManager工厂
				EntityManager entityManager = entityMangerFactory.createEntityManager(); // Retrieve an application managed entity manager
		        //开启事务
				EntityTransaction transaction = entityManager.getTransaction();
		        transaction.begin();
		        
		        addUser(entityManager);
//		        addAuthority(entityManager);
		        
				transaction.commit();
		        entityManager.close();
		        entityMangerFactory.close();
	}
	public static void addUser(EntityManager entityManager) {
		List<Authority> authorityList = entityManager.createQuery("SELECT a FROM Authority a ").getResultList();
		// 4. 持久化操作
		User u = new User();
		u.setPassword("123");
		u.setUsername("张三");
		u.setAuthorityList(authorityList);
		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(u);
	}
	public static void addAuthority(EntityManager entityManager) {
		// 4. 持久化操作
		Authority a = new Authority();

		a.setName("bbb");

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(a);


	}
}
