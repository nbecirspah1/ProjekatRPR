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

import static org.junit.Assert.assertEquals;
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
            kupacManager.validateKupacName(incorrectNameShort);}, "Ime mora sadr??avati samo slova, i du??ina imena ne smije biti manja ili jednaka 2");
        Assertions.assertEquals("Ime mora sadr??avati samo slova, i du??ina imena ne smije biti manja ili jednaka 2", projekatException1.getMessage());

        String incorrectNameNumbers = "Ajla3";
        Mockito.doCallRealMethod().when(kupacManager).validateKupacName(incorrectNameNumbers);
        ProjekatException projekatException2 = Assertions.assertThrows(ProjekatException.class, () -> {
            kupacManager.validateKupacName(incorrectNameNumbers);}, "Ime mora sadr??avati samo slova, i du??ina imena ne smije biti manja ili jednaka 2");
        Assertions.assertEquals("Ime mora sadr??avati samo slova, i du??ina imena ne smije biti manja ili jednaka 2", projekatException2.getMessage());

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
               kupacManager.validateKupacSurname(incorrectSurnameShort);}, "Prezime mora sadr??avati samo slova, i du??ina prezimena ne smije biti manja ili jednaka 2");
           Assertions.assertEquals("Prezime mora sadr??avati samo slova, i du??ina prezimena ne smije biti manja ili jednaka 2", projekatException1.getMessage());

           String incorrectSurnameNumbers = "Nekic3";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacSurname(incorrectSurnameNumbers);
           ProjekatException projekatException2 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacSurname(incorrectSurnameNumbers);}, "Prezime mora sadr??avati samo slova, i du??ina prezimena ne smije biti manja ili jednaka 2");
           Assertions.assertEquals("Prezime mora sadr??avati samo slova, i du??ina prezimena ne smije biti manja ili jednaka 2", projekatException2.getMessage());

       }

       @Test
       void validateKupacAdresa() throws ProjekatException {
           String correctAddress = "Adresa 566";
           try{
               Mockito.doCallRealMethod().when(kupacManager).validateKupacAdresa(correctAddress);
           }catch (ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }

           String incorrectAdressShort = "A 1";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacAdresa(incorrectAdressShort);
           ProjekatException projekatException1 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacAdresa(incorrectAdressShort);}, "Adresa nije validna.");
           Assertions.assertEquals("Adresa nije validna.", projekatException1.getMessage());


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


          String emailAlreadyExists = "neko3@gmail.com";
           MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
           daoFactoryMockedStatic.when(DaoFactory::kupacDao).thenReturn(kupacDaoSQLMock);

           List<Kupac> kupac = new ArrayList<>();
           kupac.add(kupci.get(0));
           when(DaoFactory.kupacDao().searchByEmail(emailAlreadyExists)).thenReturn(kupac);
           try{
               Mockito.doCallRealMethod().when(kupacManager).searchByEmail(emailAlreadyExists);

           }catch(ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }
           Mockito.doCallRealMethod().when(kupacManager).validateKupacEmail(emailAlreadyExists);
           ProjekatException projekatException3 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacEmail(emailAlreadyExists);}, "Ve?? postoji account sa ovim emailom.");
           Assertions.assertEquals("Ve?? postoji account sa ovim emailom.", projekatException3.getMessage());
           daoFactoryMockedStatic.close();

       }


       @Test
       void validateKupacPhoneNumber() throws ProjekatException {
           String correctPhoneNumber = "+387062111111";
           try{
               Mockito.doCallRealMethod().when(kupacManager).validateKupacPhoneNumber(correctPhoneNumber);
           }catch (ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }

           String incorrectPhoneNumber = "062123123";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacPhoneNumber(incorrectPhoneNumber);
           ProjekatException projekatException1 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacPhoneNumber(incorrectPhoneNumber);}, "Broj telefona mora biti u formatu +387XXXXXXXXX");
           Assertions.assertEquals("Broj telefona mora biti u formatu +387XXXXXXXXX", projekatException1.getMessage());


       }


       @Test
       void validateKupacPassword() throws ProjekatException {
           String correctPassword = "Password";
           try{
               Mockito.doCallRealMethod().when(kupacManager).validateKupacPassword(correctPassword);
           }catch (ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }

           String incorrectPassword = "123n";
           Mockito.doCallRealMethod().when(kupacManager).validateKupacPassword(incorrectPassword);
           ProjekatException projekatException1 = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.validateKupacPassword(incorrectPassword);}, "Password mora sadr??avati najmanje 8 karaktera.");
           Assertions.assertEquals("Password mora sadr??avati najmanje 8 karaktera.", projekatException1.getMessage());


       }
       @Test
       void add() throws ProjekatException {
           MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
           daoFactoryMockedStatic.when(DaoFactory::kupacDao).thenReturn(kupacDaoSQLMock);

           when(DaoFactory.kupacDao().getAll()).thenReturn(kupci);
           Mockito.doCallRealMethod().when(kupacManager).add(kupac);
           ProjekatException projekatException = Assertions.assertThrows(ProjekatException.class, () -> {
               kupacManager.add(kupac);}, "Kategorija sa postoje??im ID-em se ne mo??e dodati. ID mora biti automatski generisan.");

           Assertions.assertEquals("Kategorija sa postoje??im ID-em se ne mo??e dodati. ID mora biti automatski generisan.", projekatException.getMessage());
           daoFactoryMockedStatic.verify(DaoFactory::kupacDao);
           verify(kupacManager).add(kupac);
           daoFactoryMockedStatic.close();
       }

       @Test
       void searchByEmail() throws ProjekatException {
           MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
           daoFactoryMockedStatic.when(DaoFactory::kupacDao).thenReturn(kupacDaoSQLMock);
        /*
        An exception will be thrown because our instance of Category.java class has value for id
         */
           List<Kupac> kupac = new ArrayList<>();
           kupac.add(kupci.get(0));
           when(DaoFactory.kupacDao().searchByEmail("neko3@gmail.com")).thenReturn(kupac);
           try{
               Mockito.doCallRealMethod().when(kupacManager).searchByEmail("neko3@gmail.com");

           }catch(ProjekatException e){
               e.printStackTrace();
               Assertions.assertTrue(false);
           }

       }




}
