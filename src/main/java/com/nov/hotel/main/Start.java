package com.nov.hotel.main;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.dao.objects.Author;
import com.nov.hotel.dao.objects.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Start {

	private static final Locale DEFAULT_LOCALE = new Locale("ua");

	public static void main(String[] args) {

		Locale.setDefault(DEFAULT_LOCALE);

		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/app-context.xml");

		AppartTypeDao sqLiteDAO = (AppartTypeDao) context.getBean("appartTypeDao");
		System.out.println(sqLiteDAO.getAll());

	}
}
