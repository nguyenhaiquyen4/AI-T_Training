package com.quyen.ch10.converter;

import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service("customConversionServiceFactoryBean")
public class CustomConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {
    private Set<Formatter<?>> formatters = new HashSet<>();
    @PostConstruct
    public void init() {
        formatters.add(getNameFormatter());
        setFormatters(formatters);
    }

    public Formatter<AmericanName> getNameFormatter() {
        return new Formatter<AmericanName>() {
            @Override
            public AmericanName parse(String s, Locale locale) throws ParseException {
                AmericanName ret = new AmericanName();
                String[] sp = s.split(" ");
                ret.setLastName(sp[1]);
                ret.setFirstName(sp[0]);
                return ret;
            }

            @Override
            public String print(AmericanName name, Locale locale) {
                System.out.println("AmericanName : "+name);
                return name.toString();
            }
        };
    }
}
