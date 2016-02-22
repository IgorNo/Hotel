package impl;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.entities.AppartType;
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

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/app-context.xml"})
public class TestAppartTypeDaoImpl {

    private static Logger LOG = Logger.getLogger(TestAppartTypeDaoImpl.class);
    @Autowired
    private AppartTypeDao appartTypeDao;

    private static AppartType appartType1 = new AppartType();
    private static AppartType appartType2 = new AppartType();
    private static AppartType appartType3 = new AppartType();
    private static List<AppartType> appartTypes = new LinkedList<AppartType>();
    private static List<AppartType> result;

    @BeforeClass
    public static void initData(){
        appartType1.setName("Одномісний номер");
        appartType1.setPrice1(100.00f);
        appartType1.setPrice2(110.00f);
        appartType1.setPrice3(111.00f);
        appartType2.setName("Двоомісний номер");
        appartType2.setPrice1(200.00f);
        appartType2.setPrice2(220.00f);
        appartType2.setPrice3(222.00f);
        appartType3.setName("Тримісний номер");
        appartType3.setPrice1(300.00f);
        appartType3.setPrice2(330.00f);
        appartType3.setPrice3(333.00f);
        appartTypes.add(appartType1);
        appartTypes.add(appartType2);
        appartTypes.add(appartType3);

    }

    @Before
    public void createData(){
        appartTypeDao.deleteAll();
        assertEquals(0, appartTypeDao.count());
        LOG.warn("\nTest Data:\n"+appartTypes.toString());
        for (AppartType x:appartTypes ) {
            appartTypeDao.insert(x);
        }
        assertEquals(appartTypes.size(), appartTypeDao.count());
    }


    @Test
    public void testGetByName(){
        result = new LinkedList<AppartType>();
        for (AppartType x:appartTypes ) {
            AppartType type = appartTypeDao.getByName(x.getName());
            result.add(type);
            assertEquals(x.getName(),result.get(result.size()-1).getName());
            assertEquals(x.getPrice1(),result.get(result.size()-1).getPrice1(),0.001f);
            assertEquals(x.getPrice2(),result.get(result.size()-1).getPrice2(),0.001f);
            assertEquals(x.getPrice3(),result.get(result.size()-1).getPrice3(),0.001f);
        }
        LOG.warn("\ngetByName Data:\n"+result.toString());
    }

    @Test
    public void testGetById(){
        testGetByName();
        for (AppartType x:result ) {
            AppartType type = appartTypeDao.getById(x.getId());
            assertEquals(x.getId(),type.getId());
            assertEquals(x.getName(),type.getName());
            assertEquals(x.getPrice1(),type.getPrice1(),0.001f);
            assertEquals(x.getPrice2(),type.getPrice2(),0.001f);
            assertEquals(x.getPrice3(),type.getPrice3(),0.001f);
        }
        LOG.warn("\ngetById Data:\n"+result.toString());
    }

    @Test
    public void testGetAll(){
        result = appartTypeDao.getAll();
        for (int i = 0; i < appartTypes.size(); i++) {
            AppartType testType = appartTypes.get(i);
            AppartType resultType = result.get(i);
            assertEquals(testType.getName(),resultType.getName());
            assertEquals(testType.getPrice1(),resultType.getPrice1(),0.001f);
            assertEquals(testType.getPrice2(),resultType.getPrice2(),0.001f);
            assertEquals(testType.getPrice3(),resultType.getPrice3(),0.001f);

        }
        LOG.warn("\ngetAll Data:\n"+result.toString());
    }

    @Test
    public void testUpdate(){
        result = appartTypeDao.getAll();
        AppartType appartType = new AppartType();
        appartType.setId(result.get(0).getId());
        appartType.setName("Одномісний номер люкс");
        appartType.setPrice1(500.00f);
        appartType.setPrice2(550.00f);
        appartType.setPrice3(555.00f);
        appartTypeDao.update(appartType);
        AppartType type = appartTypeDao.getById(appartType.getId());
        assertEquals(appartType.getId(),type.getId());
        assertEquals(appartType.getName(),type.getName());
        assertEquals(appartType.getPrice1(),type.getPrice1(),0.001f);
        assertEquals(appartType.getPrice2(),type.getPrice2(),0.001f);
        assertEquals(appartType.getPrice3(),type.getPrice3(),0.001f);
        LOG.warn("\nBefor Update:\n"+result.toString());
        LOG.warn("\nUpdate Data:\n"+appartType.toString());
        result = appartTypeDao.getAll();
        LOG.warn("\nAfter Update:\n"+result.toString());

    }
}
