package com.quyen.ch10.converter;

import org.springframework.core.convert.converter.Converter;

public class V2A implements Converter<VietnameseName, AmericanName> {
    @Override
    public AmericanName convert(VietnameseName vName) {
        AmericanName aname = new AmericanName();
        aname.setFirstName(vName.getChulot()+" "+vName.getTen());
        aname.setLastName(vName.getHo());
        return aname;
    }
}
