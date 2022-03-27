package dev.ufuk.bakan;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        UBList<Integer> liste = new UBList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("Index of 20: " + liste.indexOf(20));
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(1); // delete 20
        System.out.println("Index of 20: " + liste.indexOf(20));
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        liste.add(40);
        liste.set(0, 100); // change 10 to 100
        System.out.println("Index of 40: " + liste.indexOf(40));
        System.out.println("0. indisteki değer : " + liste.get(0));
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Index of 100: " + liste.indexOf(100));
        System.out.println("Last Index of 100: " + liste.lastIndexOf(100));
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        System.out.println("Listemde 110 değeri : " + liste.contains(110));
        System.out.println("Listemde 120 değeri : " + liste.contains(120));
        System.out.println(liste.toString());
        System.out.print("Liste to array: ");
        printArray(liste.toArray());
        System.out.print("Sublist [5-9]: ");
        System.out.println(liste.sublist(5,9) .toString());
        liste.clear();
        System.out.println(liste.toString());
    }

    private static <T> void printArray(T[] array){
        System.out.print("[");
        Arrays.stream(array).forEach(element -> System.out.print(element.toString()+", "));
        System.out.println("]");
    }
}
