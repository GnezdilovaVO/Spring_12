package com.example.ex_4_hw.repository;

import com.example.ex_4_hw.model.Cat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CatRepository {
    List<Cat> cats = new ArrayList<>();
    public void addCat(Cat cat){
        cats.add(cat);
    }
    public List<Cat> getCats(){
        return cats;
    }
}
