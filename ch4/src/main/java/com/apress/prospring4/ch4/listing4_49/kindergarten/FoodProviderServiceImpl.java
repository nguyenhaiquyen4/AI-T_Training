package com.apress.prospring4.ch4.listing4_49.kindergarten;

import com.apress.prospring4.ch4.listing4_49.Food;
import com.apress.prospring4.ch4.listing4_49.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<Food>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet;
    }
}