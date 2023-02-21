package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.KupacDaoSQLImpl;
import ba.unsa.etf.rpr.dao.PlacanjeDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Placanje;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlacanjeManagerTest {

    private PlacanjeManager placanjeManager;
    private Placanje placanje;
    private PlacanjeDaoSQLImpl placanjeDaoSQLMock;
    private List<Placanje> placanja;

    @BeforeEach
    public void initializeObjectsWeNeed() {
        placanjeManager = Mockito.mock(PlacanjeManager.class);
        placanje = new Placanje();
        placanje.setKupacID(1);
        placanje.setPaymentMethod("gotovina");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        placanje.setPaymentDate(date);
        placanje.setProizvodID(1);
        placanje.setId(50);

        placanjeDaoSQLMock = Mockito.mock(PlacanjeDaoSQLImpl.class);
        placanja = new ArrayList<>();
        Date paymentDate = new Date(1645411200000L);
        placanja.addAll(Arrays.asList(
                new Placanje(1, new Date(), "kreditna kartica", 123, 456),
                new Placanje(2, paymentDate, "gotovina", 789, 101112)));

    }

    @Test
    void add() throws ProjekatException {
        MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
        daoFactoryMockedStatic.when(DaoFactory::placanjeDao).thenReturn(placanjeDaoSQLMock);

        when(DaoFactory.placanjeDao().getAll()).thenReturn(placanja);
        Mockito.doCallRealMethod().when(placanjeManager).add(placanje);
        ProjekatException projekatException = Assertions.assertThrows(ProjekatException.class, () -> {
            placanjeManager.add(placanje);}, "Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.");

        Assertions.assertEquals("Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.", projekatException.getMessage());
        daoFactoryMockedStatic.verify(DaoFactory::placanjeDao);
        verify(placanjeManager).add(placanje);
        daoFactoryMockedStatic.close();
    }
}
