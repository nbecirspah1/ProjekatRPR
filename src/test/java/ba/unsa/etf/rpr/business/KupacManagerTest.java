package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.KupacDao;
import ba.unsa.etf.rpr.dao.KupacDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
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

    @Test
       void validateKupacName() throws ProjekatException {
        String correctName = "NekoTri";
        try{
            Mockito.doCallRealMethod().when(kupacManager).validateKupacName(correctName);
        }catch (ProjekatException e){
            e.printStackTrace();
            Assertions.assertTrue(false);
        }

        String incorrectNameShort = "AA";
        Mockito.doCallRealMethod().when(kupacManager).validateKupacName(incorrectNameShort);
        ProjekatException projekatException1 = Assertions.assertThrows(ProjekatException.class, () -> {
            kupacManager.validateKupacName(incorrectNameShort);}, "Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2");
        Assertions.assertEquals("Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2", projekatException1.getMessage());

        String incorrectNameNumbers = "Ajla3";
        Mockito.doCallRealMethod().when(kupacManager).validateKupacName(incorrectNameNumbers);
        ProjekatException projekatException2 = Assertions.assertThrows(ProjekatException.class, () -> {
            kupacManager.validateKupacName(incorrectNameNumbers);}, "Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2");
        Assertions.assertEquals("Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2", projekatException2.getMessage());

    }


       @Test
       void validateKupacSurname() throws ProjekatException {
           String correctSurname = "NekicTri";
           try{
               Mockito.doCallRealMethod().when(kupacManager).validateKupacSurname(correctSurname);
           }catch (ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }

           String incorrectSurnameShort = "AA";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacSurname(incorrectSurnameShort);
           ProjekatException projekatException1 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacSurname(incorrectSurnameShort);}, "Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2");
           Assertions.assertEquals("Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2", projekatException1.getMessage());

           String incorrectSurnameNumbers = "Nekic3";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacSurname(incorrectSurnameNumbers);
           ProjekatException projekatException2 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacSurname(incorrectSurnameNumbers);}, "Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2");
           Assertions.assertEquals("Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2", projekatException2.getMessage());

       }
       @Test
       void validateKupacEmail() throws ProjekatException {
           String correctSurname = "neko@gmail.com";
           try{
               Mockito.doCallRealMethod().when(kupacManager).validateKupacEmail(correctSurname);
           }catch (ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }

           String incorrectEmail = "neko@gmail";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacEmail(incorrectEmail);
           ProjekatException projekatException1 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacEmail(incorrectEmail);}, "Email nije validan.");
           Assertions.assertEquals("Email nije validan.", projekatException1.getMessage());

           String incorrectEmail2 = "neko@.com";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacEmail(incorrectEmail2);
           ProjekatException projekatException2 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacEmail(incorrectEmail2);}, "Email nije validan.");
           Assertions.assertEquals("Email nije validan.", projekatException2.getMessage());

          /* String emailAlreadyExists = "neko3@gmail.com";
           MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
           daoFactoryMockedStatic.when(DaoFactory::kupacDao).thenReturn(kupacDaoSQLMock);

           when(DaoFactory.kupacDao().searchByEmail(emailAlreadyExists)).thenReturn((List<Kupac>) kupci.get(0));
           Mockito.doCallRealMethod().when(kupacManager).searchByEmail(emailAlreadyExists);
           ProjekatException projekatException = Assertions.assertThrows(ProjekatException.class, () -> {
              kupacManager.searchByEmail(emailAlreadyExists);}, "Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.");

           Assertions.assertEquals("Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.", projekatException.getMessage());
           daoFactoryMockedStatic.verify(DaoFactory::kupacDao);
           Mockito.verify(kupacManager).searchByEmail(emailAlreadyExists);
           Mockito.doCallRealMethod().when(kupacManager).validateKupacEmail(emailAlreadyExists);
           ProjekatException projekatException3 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacEmail(emailAlreadyExists);}, "Već postoji account sa ovim emailom.");
           Assertions.assertEquals("Već postoji account sa ovim emailom.", projekatException3.getMessage());
           daoFactoryMockedStatic.close();*/


       }

       @Test
       void add() throws ProjekatException {
           MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
           daoFactoryMockedStatic.when(DaoFactory::kupacDao).thenReturn(kupacDaoSQLMock);
        /*
        An exception will be thrown because our instance of Category.java class has value for id
         */
           when(DaoFactory.kupacDao().getAll()).thenReturn(kupci);
           Mockito.doCallRealMethod().when(kupacManager).add(kupac);
           ProjekatException quoteException = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.add(kupac);}, "Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.");

           Assertions.assertEquals("Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.", quoteException.getMessage());
           daoFactoryMockedStatic.verify(DaoFactory::kupacDao);
           verify(kupacManager).add(kupac);
           daoFactoryMockedStatic.close();
       }
}
