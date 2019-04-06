package com.zhd.test;
/**
 * 一对多
 * 多对一
 */
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zhd.bean.Account;
import com.zhd.bean.Orders;

public class ToOneToManyMainTest {

	public static void main(String[] args) {
		//创建entityMangerFactory工厂
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("jpa_many_to_many");
		//创建entityManager工厂
		EntityManager entityManager = entityMangerFactory.createEntityManager(); // Retrieve an application managed entity manager
        //开启事务
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
//        addAccount(entityManager);
//        deleteAccount(entityManager,5);
        deleteOrders(entityManager,4);
        
		transaction.commit();
        entityManager.close();
        entityMangerFactory.close();
	}
	/**
	 * 新增顾客
	 * @param entityManager
	 */
	public static void addAccount(EntityManager entityManager) {
		Account account = new Account();
		account.setName("yly2");
		account.setPwd("2");
		entityManager.persist(account);
		
		addOrders(entityManager, account.getId());
	}
	/**
	 * 新增订单
	 * @param entityManager
	 * @param id   新增订单的用户id
	 */
	public static void addOrders(EntityManager entityManager,int id) {
		Account account =  entityManager.createQuery("select a from Account a where a.id = ?1 ",Account.class).setParameter(1, id).getSingleResult();
		Orders orders = new Orders();
		orders.setNumber("123");
		orders.setDate(new Date());
		orders.setAccount(account);
		entityManager.persist(orders);
	}
	/**
	 * 删除用户  这个用户相应的订单也会被删除
	 * @param entityManager
	 * @param id   顾客id
	 */
	public static void deleteAccount(EntityManager entityManager,int id) {
		Account account = entityManager.find(Account.class, id);
		entityManager.remove(account);
	}
	/**
	 * 删除订单  用户无影响
	 * @param entityManager
	 * @param id  订单id
	 */
	public static void deleteOrders(EntityManager entityManager,int id) {
		Orders orders = entityManager.find(Orders.class, id);
		entityManager.remove(orders);
	}
}
