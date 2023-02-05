package ba.unsa.etf.rpr.domain;

public class ProizvodDetalji implements Idable{
    private  int id;
    private String color;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private String size;
    private int stockLevel;

    public ProizvodDetalji(String color, String size, int stockLevel) {
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
}