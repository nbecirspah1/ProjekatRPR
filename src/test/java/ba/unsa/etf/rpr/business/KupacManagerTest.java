package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.KupacDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kupac;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;

import java.util.List;

   public class KupacManagerTest {
    private KupacManager kupacManager;
    private Kupac kupac;
    private KupacDaoSQLImpl kupacDaoSQLMock;
    private List<Kupac> kupci;

       /**
        * Ova metoda ce se pozivati prije svake test metode
        */
    @BeforeEach
    public void initializeObjectsWeNeed() {
        kupacManager = Mockito.mock(KupacManager.class);
        kupac = new Kupac();
        kupac.setName("NekoTri");
        kupac.setSurname("NekicTri");
        kupac.setPassword("Password3");
        kupac.setAdress("Adresa3");
        kupac.setPhoneNumber("+387062111222");
        kupac.setEmail("neko3@gmail.com");
        kupac.setId(50);

        kupacDaoSQLMock = Mockito.mock(KupacDaoSQLImpl.class);
        kupci = new ArrayList<>();
        kupci.addAll(Arrays.asList( new Kupac("NekoTri", "NekicTri", "Adresa3", "+387062111222", "Password3", "neko3@gmail.com"),
                                    new Kupac("NekoCetiri", "NekicCetiri", "Adresa 4", "+387062123123", "Password4", "neko4@gmail.com" ),
                                    new Kupac("NekoPet", "NekicPet", "Adresa 5", "+387062123124", "Password5", "neko5@gmail.com"),
                                    new Kupac("NekoSest", "NekicSest", "Adresa 6", "+387062123125", "Password5", "neko6@gmail.com")));

    }
}
