package com.nov.hotel.main;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Start {

	private static final Locale DEFAULT_LOCALE = new Locale("uk");

	public static final ApplicationContext APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("/spring/app-context.xml");

	public static void main(String[] args) {

		Locale.setDefault(DEFAULT_LOCALE);

//		AppartTypeDao sqLiteDAO = (AppartTypeDao) APPLICATION_CONTEXT.getBean("appartTypeDao");
//
//		System.out.println(sqLiteDAO.getAll());

	}
}
