package dev.ufuk.bakan;

public abstract class Product {
    private long id;
    private double price;
    private float offPercent; // yüzdesel indirim oranı (1.0 = 100%), (0.5 = 50%) vs.
    private int stock;
    private String name;
    private Brand brand;


    public Product(double price, float offPercent, int stock, String name, Brand brand) {
        this.price = price;
        setOffPercent(offPercent);
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }


    public double getSalePrice(){
        return ( price - (price*offPercent) );
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // getSalePrice kullanımını öne çıkarmak için devre dışı:
    // public double getPrice() {
    //     return this.price;
    // }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getOffPercent() {
        return this.offPercent;
    }

    public void setOffPercent(float offPercent) {
        if(offPercent >= 0 && offPercent < 1){
            this.offPercent = offPercent; // indirim miktarı 0.5 olarak girildiyse olduğu gibi al
        }else{
            this.offPercent = offPercent/100; // indirim miktarı 50 olarak girildiyse 100 e bölerek al
        }
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
