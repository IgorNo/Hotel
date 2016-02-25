package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
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
public class TestApartTypeDaoImpl {

    private static Logger LOG = Logger.getLogger(TestApartTypeDaoImpl.class);
    @Autowired
    private CrudDao<ApartType> appartTypeDao;

    private static ApartType apartType1 = new ApartType();
    private static ApartType apartType2 = new ApartType();
    private static ApartType apartType3 = new ApartType();
    private static List<ApartType> testData = new LinkedList<ApartType>();
    private static List<ApartType> result = new LinkedList<>();

    @BeforeClass
    public static void initData(){
        apartType1.setName("Одномісний номер");
        apartType1.setSizing(1);
        apartType1.setPrice1(100.00f);
        apartType1.setPrice2(110.00f);
        apartType1.setPrice3(111.00f);
        apartType2.setName("Двомісний номер");
        apartType2.setSizing(2);
        apartType2.setPrice1(200.00f);
        apartType2.setPrice2(220.00f);
        apartType2.setPrice3(222.00f);
        apartType3.setName("Тримісний номер");
        apartType3.setSizing(3);
        apartType3.setPrice1(300.00f);
        apartType3.setPrice2(330.00f);
        apartType3.setPrice3(333.00f);
        testData.add(apartType1);
        testData.add(apartType2);
        testData.add(apartType3);
     }

    @Before
    public void createData(){
        appartTypeDao.deleteAll();
        assertEquals(0, appartTypeDao.count());
        LOG.warn("\nTest Data:\n"+ testData.toString());
        for (ApartType x: testData) {
            appartTypeDao.insert(x);
        }
        assertEquals(testData.size(), appartTypeDao.count());
    }


    @Test
    public void testGetByName(){
        result.clear();
        for (ApartType x: testData) {
            List<ApartType> type = appartTypeDao.getByName(x.getName());
            result.add(type.get(0));
            assertEquals(x.getName(),result.get(result.size()-1).getName());
            assertEquals(x.getSizing(),result.get(result.size()-1).getSizing());
            assertEquals(x.getPrice1(),result.get(result.size()-1).getPrice1(),0.001f);
            assertEquals(x.getPrice2(),result.get(result.size()-1).getPrice2(),0.001f);
            assertEquals(x.getPrice3(),result.get(result.size()-1).getPrice3(),0.001f);
        }
        LOG.warn("\ngetByName Data:\n"+result.toString());
    }

    @Test
    public void testGetById(){
        testGetByName();
        for (ApartType x:result ) {
            ApartType type = appartTypeDao.getById(x.getId());
            assertEquals(x.getId(),type.getId());
            assertEquals(x.getName(),type.getName());
            assertEquals(x.getSizing(),type.getSizing());
            assertEquals(x.getPrice1(),type.getPrice1(),0.001f);
            assertEquals(x.getPrice2(),type.getPrice2(),0.001f);
            assertEquals(x.getPrice3(),type.getPrice3(),0.001f);
        }
        LOG.warn("\ngetById Data:\n"+result.toString());
    }

    @Test
    public void testGetAll(){
        result.clear();
        result = appartTypeDao.getAll();
        for (int i = 0; i < testData.size(); i++) {
            ApartType testType = testData.get(i);
            ApartType resultType = result.get(i);
            assertEquals(testType.getName(),resultType.getName());
            assertEquals(testType.getSizing(),resultType.getSizing());
            assertEquals(testType.getPrice1(),resultType.getPrice1(),0.001f);
            assertEquals(testType.getPrice2(),resultType.getPrice2(),0.001f);
            assertEquals(testType.getPrice3(),resultType.getPrice3(),0.001f);

        }
        LOG.warn("\ngetAll Data:\n"+result.toString());
    }

    @Test
    public void testUpdate(){
        result.clear();
        result = appartTypeDao.getAll();
        ApartType apartType = new ApartType();
        apartType.setId(result.get(0).getId());
        apartType.setName("Одномісний номер люкс");
        apartType.setSizing(1);
        apartType.setPrice1(500.00f);
        apartType.setPrice2(550.00f);
        apartType.setPrice3(555.00f);
        appartTypeDao.update(apartType);
        ApartType type = appartTypeDao.getById(apartType.getId());
        assertEquals(apartType.getId(),type.getId());
        assertEquals(apartType.getName(),type.getName());
        assertEquals(apartType.getSizing(),type.getSizing());
        assertEquals(apartType.getPrice1(),type.getPrice1(),0.001f);
        assertEquals(apartType.getPrice2(),type.getPrice2(),0.001f);
        assertEquals(apartType.getPrice3(),type.getPrice3(),0.001f);
        LOG.warn("\nBefor Update:\n"+result.toString());
        LOG.warn("\nUpdate Data:\n"+ apartType.toString());
        result = appartTypeDao.getAll();
        LOG.warn("\nAfter Update:\n"+result.toString());

    }

    @Test
    public void testDelete(){
        result.clear();
        result = appartTypeDao.getAll();
        appartTypeDao.delete(result.get(0));
        assertEquals(testData.size()-1, appartTypeDao.count());
    }
}
