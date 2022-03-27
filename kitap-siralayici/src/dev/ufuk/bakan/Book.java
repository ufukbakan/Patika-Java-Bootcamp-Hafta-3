package dev.ufuk.bakan;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book>{

    private String name;
    private int numberOfPages;
    private String author;
    private LocalDate publishDate;

    public Book(String name, int numberOfPages, String author, LocalDate publishDate){
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    // comparator:
    @Override
    public int compareTo(Book o) {
        return name.compareTo(o.name);
    }

//    REDUNDANT CODE (realized its same as string.compareTo :P
//    private int nameComparator(String s1, String s2){
//        char[] s1c = s1.toCharArray();
//        char[] s2c = s2.toCharArray();
//        int limit = Math.min(s1c.length, s2c.length);
//        for(int i = 0; i < limit; i++){
//            if(s1c[i] > s2c[i]){
//
//            }else if(s2c[i] > s1c[i]){
//
//            }else{
//                continue;
//            }
//        }
//        if(s1.length() == s2.length()){
//            return 0;
//        }else{
//            return Arrays.equals(Stream.of(s1, s2).reduce((x, y) -> x.length() < y.length() ? x : y).get().toCharArray(), s1c) ? -1 : 1;
//        }
//    }

    // equals and hashcode :

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPages);
    }

    @Override
    public String toString() {
        return "" +
                "'" + name + '\'' +
                "[" + numberOfPages +
                ']';
    }
}
