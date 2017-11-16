package com.quyen.ch10.converter;

import org.springframework.core.convert.converter.Converter;

public class A2V implements Converter<AmericanName, VietnameseName> {
    @Override
    public VietnameseName convert(AmericanName americanName) {
        VietnameseName vname = new VietnameseName();
        vname.setHo(americanName.getLastName());
        vname.setTen(americanName.getFirstName());
        vname.setChulot("");
        return vname;
    }
}
