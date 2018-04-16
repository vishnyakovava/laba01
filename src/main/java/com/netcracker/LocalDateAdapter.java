package com.netcracker;


import org.joda.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String date){
        return LocalDate.parse(date);
    }

    @Override
    public String marshal(LocalDate date) {
        return date.toString();
    }
}
