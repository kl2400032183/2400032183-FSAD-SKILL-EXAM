package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.time.LocalDate;

public class ClientDemo {
    
    private static SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        insertRecords();
        updateServiceName(1, "Premium Service");
        updateServiceStatus(1, "Active");
        displayAllServices();
    }
    
    public static void insertRecords() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            
            Service service1 = new Service("Basic Service", LocalDate.now(), "Pending", "Basic support", 100.0);
            Service service2 = new Service("Standard Service", LocalDate.now(), "Inactive", "Standard support", 200.0);
            Service service3 = new Service("Premium Service", LocalDate.now(), "Active", "Premium support", 300.0);
            
            session.save(service1);
            session.save(service2);
            session.save(service3);
            
            session.getTransaction().commit();
            System.out.println("Records inserted successfully!");
        } finally {
            session.close();
        }
    }
    
    public static void updateServiceName(int id, String newName) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            
            Query query = session.createQuery("UPDATE Service SET name = :name WHERE id = :id");
            query.setParameter("name", newName);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            
            session.getTransaction().commit();
            System.out.println("Updated " + result + " record(s) with new name: " + newName);
        } finally {
            session.close();
        }
    }
    
    public static void updateServiceStatus(int id, String newStatus) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            
            Query query = session.createQuery("UPDATE Service SET status = :status WHERE id = :id");
            query.setParameter("status", newStatus);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            
            session.getTransaction().commit();
            System.out.println("Updated " + result + " record(s) with new status: " + newStatus);
        } finally {
            session.close();
        }
    }
    
    public static void displayAllServices() {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM Service");
            var services = query.getResultList();
            
            System.out.println("\n--- All Services ---");
            for (Object service : services) {
                System.out.println(service);
            }
        } finally {
            session.close();
        }
    }
}
