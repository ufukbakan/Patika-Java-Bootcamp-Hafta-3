package dev.ufuk.bakan;

public class Phone extends Product{
    public static long idCounter = 0; // statik ortak id sayacı
    private int storageMemory;
    private float screenInches;
    private int batteryMAh;
    private int ram;
    private Color color;

    public Phone(double price, float offPercent, int stock, String name, Brand brand, int storageMemory, float screenInches, int batteryMAh, int ram, Color color) {
        super(price, offPercent, stock, name, brand);
        super.setId(idCounter); // sayaçtaki sayı ürünün idsi
        idCounter++; // bir sonraki eklenecek ürünün idsi için sayacı arttır
        this.storageMemory = storageMemory;
        this.screenInches = screenInches;
        this.batteryMAh = batteryMAh;
        this.ram = ram;
        this.color = color;
    }
 
    public int getStorageMemory() {
        return this.storageMemory;
    }

    public void setStorageMemory(int storageMemory) {
        this.storageMemory = storageMemory;
    }

    public float getScreenInches() {
        return this.screenInches;
    }

    public void setScreenInches(float screenInches) {
        this.screenInches = screenInches;
    }

    public int getBatteryMAh() {
        return this.batteryMAh;
    }

    public void setBatteryMAh(int batteryMAh) {
        this.batteryMAh = batteryMAh;
    }

    public int getRAM() {
        return this.ram;
    }

    public void setRAM(int ram) {
        this.ram = ram;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return String.format("%-4d $%6.2f %12s %22s %8s %12.1f %8d GB %2d GB %-8d", super.getId() ,super.getSalePrice(), super.getBrand().getName() ,super.getName(), getColor().toString(), getScreenInches(), getStorageMemory(), getRAM(), getStock());
    }


}
