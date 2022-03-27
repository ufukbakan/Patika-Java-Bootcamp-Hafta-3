package dev.ufuk.bakan;

import java.util.ArrayList;
import java.util.List;

public class BrandList{
    private List<Brand> array = new ArrayList<>();

    public void add(String brandName){
        array.add(new Brand(brandName));
    }
    
    public Brand getBrandbyName(String name){
        // karakter case önemsemeden eşleştir bulamazsan null döndür:
        return array.stream().filter(brand -> brand.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }

    public Brand getBrandbyId(long id){
        return array.stream().filter(brand -> brand.getId()==id).findFirst().orElse(null);
    }

    public List<Brand> getAll(){
        return array;
    }
}
