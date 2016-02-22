package com.nov.hotel.main;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.dao.objects.Author;
import com.nov.hotel.dao.objects.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		MP3 firstMP3 = new MP3();
		firstMP3.setName("Song N55");

		Author author = new Author();
		author.setName("Justin");

		firstMP3.setAuthor(author);
		//
		// MP3 secondMP3 = new MP3();
		// secondMP3.setName("Song name2");
		// secondMP3.setAuthor("Song author2");
		//
		// List<MP3> list = new ArrayList<>();
		//
		// list.add(firstMP3);
		// list.add(secondMP3);
		//
		// // new SQLiteDAO().insertWithJDBC(mp3);
		//
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/app-context.xml");
		AppartTypeDao sqLiteDAO = (AppartTypeDao) context.getBean("appartTypeDao");

		System.out.println(sqLiteDAO.getAll());

	}
}
