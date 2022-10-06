package edu.javacourse.city.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    private static final String PATTERN="dd.MM.yyyy";

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(PATTERN));
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.format(DateTimeFormatter.ofPattern(PATTERN));
    }
}
