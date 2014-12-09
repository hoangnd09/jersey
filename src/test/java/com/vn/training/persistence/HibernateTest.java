package com.vn.training.persistence;

import org.hibernate.Session;

import com.vn.training.persistence.entity.UserEntity;

public class HibernateTest {
	public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
 
        session.beginTransaction();
        UserEntity user =  new UserEntity();
        user.setName("hello world");
        session.save(user);
        session.getTransaction().commit();
        session.close();
        HibernateSessionFactory.shutdown();
    }
}
