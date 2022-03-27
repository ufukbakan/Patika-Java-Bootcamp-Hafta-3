package dev.ufuk.bakan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Brand implements Comparable<Brand> {
    private long id;
    private static long brandIdCounter = 0;
    private String name;
    private Set<Product> products = new HashSet<>(); // markaya ait ürünler

    public Brand(String name) {
        this.name = name;
        this.id = brandIdCounter; // id sayacın şimdiki durumuna eşit
        brandIdCounter++; // sonraki eklenecek marka için sayacı arttır
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    // Referans kullanımını öne çıkarmak için Set products kullanımını devre dışı
    // bırak
    // setProducts yerine getProducts.add ve getProducts.remove metotlarını kullan.
    // veya addProduct remove product oluşturulacak
    // public void setProducts(Set<Product> products) {
    // this.products = products;
    // }

    public long addProduct(Product e) {
        try {
            products.add(e);
            if (e instanceof Phone) {
                return (Phone.idCounter - 1);
            }else if (e instanceof Notebook) {
                return (Notebook.idCounter - 1);
            }
            else{
                throw new Exception("Unknown product type");
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return -1;
        }
    }

    public void deletePhone(long i){
        products = products.stream().filter(product -> product.getId() != i || !(product instanceof Phone)).collect(Collectors.toSet());
    }

    public void deleteNotebook(long i){
        products = products.stream().filter(product -> product.getId() != i || !(product instanceof Notebook)).collect(Collectors.toSet());
    }

    public List<Phone> getPhones(){
        List<Phone> result = new ArrayList<>();
        for(Product p: getProducts()){
            if(p instanceof Phone){
                result.add((Phone) p);
            }
        }
        return result;
    }

    public List<Notebook> getNotebooks(){
        List<Notebook> result = new ArrayList<>();
        for(Product p: getProducts()){
            if(p instanceof Notebook){
                result.add((Notebook) p);
            }
        }
        return result;
    }

    @Override
    public int compareTo(Brand otherBrand) {
        return this.name.compareTo(otherBrand.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Brand)) {
            return false;
        }
        Brand brand = (Brand) o;
        return id == brand.id && Objects.equals(name, brand.name) && Objects.equals(products, brand.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }

}
