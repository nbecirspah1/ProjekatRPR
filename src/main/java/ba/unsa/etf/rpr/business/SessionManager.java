package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Proizvod;

public class SessionManager {

        private static SessionManager instance;
        private Integer kupacId;
        private Proizvod proizvod;
        private SessionManager() {}

        public static SessionManager getInstance() {
            if (instance == null) {
                instance = new SessionManager();
            }
            return instance;
        }

        public Integer getKupacId() {
            return kupacId;
        }

        public void setKupacId(Integer kupacId) {
            this.kupacId = kupacId;
        }

        public void clearSession() {
            kupacId = null;
            proizvod = null;
        }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
