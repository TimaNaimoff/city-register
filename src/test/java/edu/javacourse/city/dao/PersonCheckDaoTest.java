package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonCheckDaoTest {
    @Test
    public void checkPerson() throws PersonCheckException {
        PersonRequest pr=new PersonRequest();
        pr.setSurName("Kozus");
        pr.setGivenName("Balfor");
        pr.setPatromymic("Firewald");
        pr.setDateofBirth(LocalDate.of(1995, 3,18));
        pr.setStreetCode(1);
        pr.setBuilding("build");
        pr.setExtension("exten");
        pr.setApartment("apar");

        PersonCheckDao dao=new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse resp=dao.checkPerson(pr);

        Assert.assertTrue(resp.isRegistered());
        Assert.assertFalse(resp.isTemporal());


            }
    @Test
    public void checkPerson2() throws PersonCheckException {
        PersonRequest pr=new PersonRequest();
        pr.setSurName("Valenta");
        pr.setGivenName("Balfor");
        pr.setPatromymic("Tornikay");
        pr.setDateofBirth(LocalDate.of(1994,3,11));
        pr.setStreetCode(1);
        pr.setBuilding("count1");
        pr.setApartment("4");

        PersonCheckDao dao=new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse resp=dao.checkPerson(pr);

        Assert.assertTrue(resp.isRegistered());
        Assert.assertFalse(resp.isTemporal());


    }
    }
