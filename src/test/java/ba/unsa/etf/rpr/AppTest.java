package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.dao.KupacDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kupac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple ba.unsa.etf.rpr.App.
 */
public class AppTest 
{
        @Mock

        private Kupac kupac;


        @BeforeEach
        public void initializeObjectsWeNeed(){

            kupac = new Kupac();
            kupac.setName("NekoTri");
            kupac.setSurname("NekicTri");
            kupac.setPassword("Password3");
            kupac.setAdress("Adresa3");
            kupac.setPhoneNumber("+387062111222");
            kupac.setEmail("neko3@gmail.com");
            kupac.setId(50);
        }

        @Test
        public void testSetterAndGetter(){
            assertEquals("NekoTri", kupac.getName());
            assertEquals("NekicTri", kupac.getSurname());
            assertEquals("Password3", kupac.getPassword());
            assertEquals("Adresa3", kupac.getAdress());
            assertEquals("+387062111222", kupac.getPhoneNumber());
            assertEquals("neko3@gmail.com", kupac.getEmail());
            assertEquals(50, kupac.getId());
        }



    }

