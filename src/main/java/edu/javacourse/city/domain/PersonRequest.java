package edu.javacourse.city.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class PersonRequest {
    private String surName;
    private String givenName;
    private String patromymic;
    @XmlJavaTypeAdapter(value=LocalDateAdapter.class)
    private LocalDate dateofBirth;
    private Integer streetCode;
    private String building;
    private String extension;
    private String apartment;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatromymic() {
        return patromymic;
    }

    public void setPatromymic(String patromymic) {
        this.patromymic = patromymic;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Integer getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Integer streetCode) {
        this.streetCode = streetCode;
    }

    @Override
    public String toString() {
        return "PersonRequest{" +
                "surName='" + surName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patromymic='" + patromymic + '\'' +
                ", dateofBirth=" + dateofBirth +
                ", streetCode=" + streetCode +
                ", building='" + building + '\'' +
                ", extension='" + extension + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
