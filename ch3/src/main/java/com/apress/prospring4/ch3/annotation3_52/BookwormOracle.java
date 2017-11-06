package com.apress.prospring4.ch3.annotation3_52;

import com.apress.prospring4.ch3.Oracle;

public class BookwormOracle implements Oracle {
    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - use the Internet";
    }
}

