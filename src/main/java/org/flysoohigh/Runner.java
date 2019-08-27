package org.flysoohigh;

import org.flysoohigh.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;

public class Runner {
    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("First User");
        user.setDescription("Description");
        user.setJoinDate(new Date());

        Address homeAddress = new Address();
        homeAddress.setCity("Home Samara");
        homeAddress.setStreet("Home Street");
        homeAddress.setState("Home Samara");
        homeAddress.setZipcode("Home 443000");

        Address officeAddress = new Address();
        officeAddress.setCity("office Samara2");
        officeAddress.setStreet("office Street2");
        officeAddress.setState("office Samara2");
        officeAddress.setZipcode("office 443002");

        user.setHomeAddress(homeAddress);
        user.setOfficeAddress(officeAddress);

//        UserDetails user2 = new UserDetails();
//        user2.setUserName("Second User");
//        user2.setAddress("Address2");
//        user2.setDescription("Description2");
//        user2.setJoinDate(new Date());

        Alien a1 = new Alien();
        a1.setName("Vasia");
        a1.setColor("Green");

        Laptop acer = new Laptop("Acer");
        acer.setOwner(a1);
        Laptop lenovo = new Laptop("Lenovo");
        lenovo.setOwner(a1);

        a1.setLaptops(Arrays.asList(acer, lenovo));

        Alien a2 = new Alien();
        a2.setName("Gosha");
        a2.setColor("Yellow");

        Alien a3 = new Alien();
        a3.setName("Sereza");
        a3.setColor("Blue");

        Laptop hp = new Laptop("HP");
        hp.setOwner(a3);
        Laptop macBook = new Laptop("MacBook");
        macBook.setOwner(a3);
        Laptop asus = new Laptop("Asus");
        asus.setOwner(a3);

        a3.setLaptops(Arrays.asList(hp, macBook, asus));

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Payment payment1 = new Payment();
        payment1.setType("payment1");

        Payment payment2 = new Payment();
        payment2.setType("payment2");

        Transaction transaction = session.beginTransaction();
//        session.save(user);

        session.save(payment1);
        session.save(payment2);

        session.save(payment1);
        session.save(payment2);

//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
//        session.save(acer);
//        session.save(lenovo);
//        session.save(hp);
//        session.save(macBook);
//        session.save(asus);

        transaction.commit();

//        user = null;
//        session = factory.openSession();
//        session.beginTransaction();
//        UserDetails user1 = session.get(UserDetails.class, 1L);
//        a3 = session.get(Alien.class, 3L);
//
////        System.out.println("UserName fetched from user object: " + user1.toString());
//        System.out.println("Alien fetched: " + a3);
//
//        for (Laptop lap: a3.getLaptops()) {
//            System.out.println(lap);
//        }

        session.close();
    }
}
