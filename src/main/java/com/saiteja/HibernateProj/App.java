package com.saiteja.HibernateProj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	AlienName an = new AlienName();
    	an.setFname("Saiteja");
    	an.setLname("Bollabathini");
    	an.setMname("Sai");
    	
        Alien saitej = new Alien();
        saitej.setAid(101);
        saitej.setAname(an);
        saitej.setColor("Green");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(saitej);
        
        tx.commit();
        
        //saitej = (Alien) session.get(Alien.class, 102);
        
        System.out.println(saitej);
    }
}
