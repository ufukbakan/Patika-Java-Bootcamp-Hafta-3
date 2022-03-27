package dev.ufuk.bakan;

public class Notebook extends Product{
    public static long idCounter = 0; // statik ortak id sayacı
    private Storage storage;
    private int ram;
    private float screenInches;


    public Notebook(double price, float offPercent, int stock, String name, Brand brand, Storage storage, int ram, float screenInches) {
        super(price, offPercent, stock, name, brand);
        super.setId(idCounter); // sayaçtaki sayı ürünün idsi
        idCounter++; // bir sonraki eklenecek ürünün idsi için sayacı arttır
        this.storage = storage;
        this.ram = ram;
        this.screenInches = screenInches;
    }


    public Storage getStorage() {
        return this.storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public float getScreenInches() {
        return this.screenInches;
    }

    public void setScreenInches(float screenInches) {
        this.screenInches = screenInches;
    }

    @Override
    public String toString(){
        return String.format("%-4d $%-6.2f %-12s %-22s %-12.1f %4d GB %-3s %-2d GB %-8d", super.getId() ,super.getSalePrice(), super.getBrand().getName() ,super.getName(), getScreenInches(), getStorage().getStorageSize(), getStorage().getStorageType().toString(), getRam(), getStock());
    }

}
