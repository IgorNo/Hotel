package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartStatus;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/app-context.xml"})
public class TestApartStatusDaoImpl {

    private static Logger LOG = Logger.getLogger(TestApartStatusDaoImpl.class);
    @Autowired
    private CrudDao<ApartStatus> apartStatusDao;

    private static ApartStatus apartStatus1 = new ApartStatus();
    private static ApartStatus apartStatus2 = new ApartStatus();
    private static ApartStatus apartStatus3 = new ApartStatus();
    private static ApartStatus apartStatus4 = new ApartStatus();
    private static List<ApartStatus> testData = new LinkedList<ApartStatus>();
    private static List<ApartStatus> result = new LinkedList<>();

    @BeforeClass
    public static void initData(){
        apartStatus1.setName("Вільний номер");
        apartStatus1.setColor("1");
        apartStatus2.setName("Бронь");
        apartStatus2.setColor("2");
        apartStatus3.setName("Зайнятий");
        apartStatus3.setColor("3");
        apartStatus4.setName("Ремонт");
        apartStatus4.setColor("4");
        testData.add(apartStatus1);
        testData.add(apartStatus2);
        testData.add(apartStatus3);
        testData.add(apartStatus4);
    }

    @Before
    public void createData(){
        apartStatusDao.deleteAll();
        assertEquals(0, apartStatusDao.count());
        LOG.warn("\nTest Data:\n"+ testData.toString());
        for (ApartStatus x: testData) {
            apartStatusDao.insert(x);
        }
        assertEquals(testData.size(), apartStatusDao.count());
    }


    @Test
    public void testGetByName(){
        result.clear();
        for (ApartStatus x: testData) {
            List<ApartStatus> type = apartStatusDao.getByName(x.getName());
            result.add(type.get(0));
            assertEquals(x.getName(),result.get(result.size()-1).getName());
            assertEquals(x.getColor(),result.get(result.size()-1).getColor());
        }
        LOG.warn("\ngetByName Data:\n"+result.toString());
    }

    @Test
    public void testGetById(){
        testGetByName();
        for (ApartStatus x:result ) {
            ApartStatus type = apartStatusDao.getById(x.getId());
            assertEquals(x.getId(),type.getId());
            assertEquals(x.getName(),type.getName());
            assertEquals(x.getColor(),type.getColor());
        }
        LOG.warn("\ngetById Data:\n"+result.toString());
    }

    @Test
    public void testGetAll(){
        result.clear();
        result = apartStatusDao.getAll();
        for (int i = 0; i < testData.size(); i++) {
            ApartStatus testType = testData.get(i);
            ApartStatus resultType = result.get(i);
            assertEquals(testType.getName(),resultType.getName());
            assertEquals(testType.getColor(),resultType.getColor());
        }
        LOG.warn("\ngetAll Data:\n"+result.toString());
    }

    @Test
    public void testUpdate(){
        result.clear();
        result = apartStatusDao.getAll();
        ApartStatus apartType = new ApartStatus();
        apartType.setId(result.get(0).getId());
        apartType.setName("Одномісний номер люкс");
        apartType.setColor("1");
        apartStatusDao.update(apartType);
        ApartStatus type = apartStatusDao.getById(apartType.getId());
        assertEquals(apartType.getId(),type.getId());
        assertEquals(apartType.getName(),type.getName());
        assertEquals(apartType.getColor(),type.getColor());
        LOG.warn("\nBefor Update:\n"+result.toString());
        LOG.warn("\nUpdate Data:\n"+ apartType.toString());
        result = apartStatusDao.getAll();
        LOG.warn("\nAfter Update:\n"+result.toString());

    }

    @Test
    public void testDelete(){
        result.clear();
        result = apartStatusDao.getAll();
        apartStatusDao.delete(result.get(0));
        assertEquals(testData.size()-1, apartStatusDao.count());
    }
}
