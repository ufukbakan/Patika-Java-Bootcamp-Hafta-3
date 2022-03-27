package dev.ufuk.bakan;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // SortedSet interfaceini implement eden TreeSet sınıfından Set i oluştur:
        SortedSet<Book> bookSetOrderedByName = new TreeSet<>();
        // Kitapları ekle:
        bookSetOrderedByName.add(new Book("Sefiller", 550, "Victor Hugo", LocalDate.now()));
        bookSetOrderedByName.add(new Book("Beyaz Diş", 500, "Jack London", LocalDate.now()));
        bookSetOrderedByName.add(new Book("Denizler Altında 20.000 Fersah", 300, "Jules Verne", LocalDate.now()));
        bookSetOrderedByName.add(new Book("Notre Dame'ın Kamburu", 250, "Victor Hugo", LocalDate.now()));
        bookSetOrderedByName.add(new Book("Don Kişot", 100, "Cervantes", LocalDate.now()));

        // Comparator'ı sayfa sayısına göre olan Set'i oluştur:
        SortedSet<Book> bookSetOrderedByNumberOfPages = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if(b1.getNumberOfPages() > b2.getNumberOfPages()){
                    return 1;
                }else if(b1.getNumberOfPages() < b2.getNumberOfPages()){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        // Bu yeni oluşturulan sete önceki setdeki tüm elemanları ekle:
        bookSetOrderedByNumberOfPages.addAll(bookSetOrderedByName);
        // setleri ekrana yazdır :
        System.out.println(bookSetOrderedByName);
        System.out.println("====================");
        System.out.println(bookSetOrderedByNumberOfPages);
    }
}
