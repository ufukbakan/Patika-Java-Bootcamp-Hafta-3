package dev.ufuk.bakan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner keyboardScanner = new Scanner(System.in);
    static BrandList brandList = new BrandList();
    static List<Product> productList = new ArrayList<>();

    static {
        brandList.add("Samsung");
        brandList.add("Lenovo");
        brandList.add("Apple");
        brandList.add("Huawei");
        brandList.add("Casper");
        brandList.add("Asus");
        brandList.add("HP");
        brandList.add("Xiaomi");
        brandList.add("Monster");

        Brand apple = brandList.getBrandbyName("Apple");
        apple.getProducts().add(new Phone(1100.0, 0.1f, 100, "Iphone 12", apple, 256, 6.1f, 4500, 6, Color.GREY));
        apple.getProducts().add(new Phone(1100.0, 30, 100, "Iphone 11", apple, 256, 6.1f, 4500, 6, Color.BLACK));
        apple.getProducts().add(
                new Notebook(1100, 0.1f, 200, "M1 Macbook Air", apple, new Storage(StorageType.SSD, 512), 16, 13.3f));
    }

    public static void main(String[] args) throws Exception {
        byte choice = -127; // döngüye girmesi için 0 olmayan bir ilk değer
        while (choice != 0) {
            printMainMenu();
            choice = askForInput();
            handleChoice(choice); // Seçim eylemini gerçekleştir
        }
    }

    private static byte askForInput() {
        System.out.print("Tercihiniz: ");
        return keyboardScanner.nextByte(); // kullanıcının girdisini döndürür
    }

    private static void printMainMenu() {
        System.out.println(
                "PatikaStore Ürün Yönetim Paneli !\n1 - Notebook İşlemleri\n2 - Cep Telefonu İşlemleri\n3 - Marka Listele\n0 - Çıkış Yap");
    }

    private static void handleChoice(byte choice) {
        switch (choice) {
            case 0:
                break;
            case 1:
                notebookMenuLoop();
                break;
            case 2:
                phoneMenuLoop();
                break;
            case 3:
                listBrands();
                break;
            case 4:
                listPhones();
                break;
        }
    }

    private static void printPhoneListHeader() {
        // tablo başlık satırı:
        System.out.println(String.format("%-4s $%6s %12s %22s %8s %12s %11s %5s %-8s", "ID", "Fiyat", "Marka", "Ürün",
                "Renk", "Ekran Boyutu", "Depolama", "RAM", "Stok"));
    }

    private static void listPhones() {
        printPhoneListHeader();
        // telefonları string olarak satır satır yaz :
        for (Brand brand : brandList.getAll()) {
            for (Phone phone : brand.getPhones()) {
                System.out.println(phone);
            }
        }
    }

    private static void listBrands() {
        System.out.print("\n");
        System.out.println("Markalarımız\n--------------");
        for (Brand brand : brandList.getAll()) {
            System.out.println("- " + brand);
        }
    }

    private static void printPhoneMainMenu() {
        System.out.println(
                "Cep Telefonu işlemleri\n1 - Cep telefonlarını listele\n2 - Cep telefonu ekle\n3 - Cep telefonu sil\n4 - Markaya göre filtrele\n5 - ID'ye göre filtrele\n0 - Ana menüye dön");
    }

    private static void phoneMenuLoop() {
        byte subChoice = -127; // döngüye girmesi için 0 olmayan bir ilk değer
        while (subChoice != 0) {
            printPhoneMainMenu();
            subChoice = askForInput();
            handlePhoneMainSelection(subChoice);
        }
    }

    private static void handlePhoneMainSelection(byte choice) {
        keyboardScanner.nextLine(); // nextByte seçiminden sonraki arta kalan Enter karakterini okur ve nextLine
                                    // loopların bozulmasını engeller
        switch (choice) {
            case 1:
                listPhones();
                break;
            case 2:
                addPhoneLoop();
                break;
            case 3:
                deletePhoneLoop();
                break;
            case 4:
                filterPhoneByBrandLoop();
                break;
            case 5:
                filterPhoneByIdLoop();
                break;
            case 0:
                break;
        }
    }

    private static void addPhoneLoop() {
        try {
            Brand brand;
            System.out.println("Cep telefonu hangi markaya ait?: ");
            brand = brandList.getBrandbyName(keyboardScanner.nextLine());
            double price;
            System.out.println("Telefon fiyatının indirimsiz kaç $ olduğunu giriniz");
            price = Double.parseDouble(keyboardScanner.nextLine());
            System.out.println("İndirim uygulanacaksa % kaç uygulanacağını giriniz yoksa 0 giriniz");
            float offPercent = Float.parseFloat(keyboardScanner.nextLine());
            System.out.println("Stokta kaç adet bulunduğunu giriniz");
            int stock = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Ürünün ismini giriniz");
            String name = keyboardScanner.nextLine();
            System.out.println("Depolama alanının kaç GB olduğunu giriniz");
            int storageMemory = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Ekran boyutunun kaç inç olduğunu giriniz");
            float screenInches = Float.parseFloat(keyboardScanner.nextLine());
            System.out.println("Bataryanın kaç mAh olduğunu giriniz");
            int batteryMAh = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Belleğin (RAM) kaç GB olduğunu giriniz");
            int ram = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Ürünün hangi renk olduğunu ingilizce büyük harflerle giriniz");
            Color color = Color.valueOf(keyboardScanner.nextLine());
            long id = brand.addProduct(new Phone(price, offPercent, stock, name, brand, storageMemory, screenInches,
                    batteryMAh, ram, color));
            if (id > -1) {
                System.out.println(String.format("Ürününüz %d id ile eklendi", id));
            } else {
                System.out.println("Ürününüz eklenemedi");
            }
        } catch (Exception ex) {
            System.out.println("Ürününüz eklenemedi");
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static void deletePhoneLoop() {
        System.out.println("Silmek istediğiniz telefonun idsini girin");
        long id = Long.parseLong(keyboardScanner.nextLine());
        for (Brand brand : brandList.getAll()) {
            brand.deletePhone(id);
        }
    }

    private static void filterPhoneByBrandLoop() {
        System.out.println("Hangi markanın telefonlarını listelemek istiyorsunuz");
        try {
            Brand brand = brandList.getBrandbyName(keyboardScanner.nextLine());
            printPhoneListHeader();
            for (Phone phone : brand.getPhones()) {
                System.out.println(phone);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void filterPhoneByIdLoop() {
        System.out.println("ID alt sınırı girin");
        long lowerLimit = Long.parseLong(keyboardScanner.nextLine());
        System.out.println("ID üst sınırı girin");
        long upperLimit = Long.parseLong(keyboardScanner.nextLine());
        // tablo başlığı :
        printPhoneListHeader();
        // filtrelenmiş tablo satırları :
        for (Brand brand : brandList.getAll()) {
            brand.getPhones().stream().filter(phone -> phone.getId() >= lowerLimit && phone.getId() <= upperLimit)
                    .forEach(filteredPhone -> System.out.println(filteredPhone));
        }
    }

    private static void printNotebookMainMenu() {
        System.out.println(
                "Notebook İşlemleri\n1 - Notebookları listele\n2 - Notebook ekle\n3 - Notebook sil\n4 - Markaya göre filtrele\n5 - ID'ye göre filtrele\n0 - Ana menüye dön");
    }

    private static void notebookMenuLoop() {
        byte subChoice = -127; // döngüye girmesi için 0 olmayan bir ilk değer
        while (subChoice != 0) {
            printNotebookMainMenu();
            subChoice = askForInput();
            handleNotebookMainMenuSelection(subChoice);
        }
    }

    private static void handleNotebookMainMenuSelection(byte choice){
        keyboardScanner.nextLine(); // nextByte seçiminden sonraki arta kalan Enter karakterini okur ve nextLine loopların bozulmasını engeller
        switch(choice){
            case 1:
                listNotebooks();
                break;
            case 2:
                addNotebookLoop();
                break;
            case 3:
                deleteNotebookLoop();
                break;
            case 4:
                filterNotebookByBrandLoop();
                break;
            case 5:
                filterNotebookByIdLoop();
                break;
        }
    }

    private static void printNotebookListHeader(){
        System.out.format("%-4s $%-6s %-12s %-22s %-12s %11s %-5s %-8s\n", "ID", "Fiyat", "Marka", "Ürün", "Ekran Boyutu","Depolama","RAM","Stok");
    }

    private static void listNotebooks(){
        printNotebookListHeader();
        for(Brand brand : brandList.getAll()){
            for(Notebook notebook : brand.getNotebooks()){
                System.out.println(notebook);
            }
        }
    }

    private static void addNotebookLoop(){
        try{
            System.out.println("Eklemek istediğiniz notebook hangi markaya ait");
            Brand brand = brandList.getBrandbyName(keyboardScanner.nextLine());
            System.out.println("Eklemek istediğiniz ürünün ismi nedir");
            String name = keyboardScanner.nextLine();
            System.out.println("Eklemek istdiğiniz ürünün fiyatı kaç $");
            double price = Double.parseDouble(keyboardScanner.nextLine());
            System.out.println("Uygulamak istediğiniz indirim yüzdesini giriniz");
            float offPercent = Float.parseFloat(keyboardScanner.nextLine());
            System.out.println("Stok miktarını giriniz");
            int stock = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Depolama alanını (GB) girin");
            int storageSize = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Depolama türünü büyük harflerle girin (HDD/SSD)");
            Storage storage = new Storage(StorageType.valueOf(keyboardScanner.nextLine()), storageSize);
            System.out.println("RAM miktarını girin (GB)");
            int ram = Integer.parseInt(keyboardScanner.nextLine());
            System.out.println("Ekran boyutunu girin (inch)");
            float screenInches = Float.parseFloat(keyboardScanner.nextLine());
            long id = brand.addProduct(new Notebook(price, offPercent, stock, name, brand, storage, ram, screenInches));
            if (id > -1) {
                System.out.println(String.format("Ürününüz %d id ile eklendi", id));
            } else {
                System.out.println("Ürününüz eklenemedi");
            }
        }
        catch(Exception ex){
            System.out.println("Ürününüz eklenemedi");
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static void deleteNotebookLoop(){
        System.out.println("Silmek istediğiniz notebook ürün id'sini girin");
        long id = Long.parseLong(keyboardScanner.nextLine());
        for(Brand brand : brandList.getAll()){
            brand.deleteNotebook(id);
        }
    }

    private static void filterNotebookByBrandLoop(){
        System.out.println("Notebooklarını listelemek istediğiniz markanın ismini giriniz");
        Brand brand = brandList.getBrandbyName(keyboardScanner.nextLine());
        printNotebookListHeader(); // tablo başlık satırı
        for(Notebook notebook : brand.getNotebooks()){
            System.out.println(notebook); // ürün
        }
    }
    
    private static void filterNotebookByIdLoop(){
        System.out.println("ID alt sınırı girin");
        long lowerLimit = Long.parseLong(keyboardScanner.nextLine());
        System.out.println("ID üst sınırı girin");
        long upperLimit = Long.parseLong(keyboardScanner.nextLine());
        // tablo başlığı :
        printPhoneListHeader();
        // filtrelenmiş tablo satırları :
        for (Brand brand : brandList.getAll()) {
            brand.getNotebooks().stream().filter(notebook -> notebook.getId() >= lowerLimit && notebook.getId() <= upperLimit)
                    .forEach(filteredNB -> System.out.println(filteredNB));
        }
    }
}
