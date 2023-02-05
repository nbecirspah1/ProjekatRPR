package ba.unsa.etf.rpr.domain;

public class ProizvodDetalji implements Idable{
    private  int id;
    private String color;
    private String size;

    private int stockLevel;
    private int ProizvodID;
    public int getProizvodID() {
        return ProizvodID;
    }

    public void setProizvodID(int proizvodID) {
        ProizvodID = proizvodID;
    }


    public ProizvodDetalji() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }




    public ProizvodDetalji(String color, String size, int stockLevel, int ProizvodID) {
        this.color = color;
        this.size = size;
        this.stockLevel = stockLevel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProizvodDetalji pd = (ProizvodDetalji) o;
        return id == pd.id;
    }
}
