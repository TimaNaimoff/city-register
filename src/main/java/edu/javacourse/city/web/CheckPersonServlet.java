package edu.javacourse.city.web;

import edu.javacourse.city.dao.PersonCheckDao;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="CheckPersonServlet",urlPatterns = {"/checkPerson"},loadOnStartup = 1)
public class CheckPersonServlet extends HttpServlet {
    private PersonCheckDao dao;
    private static final Logger logger=LoggerFactory.getLogger(CheckPersonServlet.class);
    @Override
    public void init() throws ServletException {
        logger.info("SERVLET is created");
        dao=new PersonCheckDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Get CheckPerson-called");
        req.setCharacterEncoding("UTF-8");
        PersonRequest pr=new PersonRequest();
        String surName=req.getParameter("surname");
        pr.setSurName(surName);
        pr.setGivenName("Balfor");
        pr.setPatromymic("Firewald");
        pr.setDateofBirth(LocalDate.of(1995, 3,18));
        pr.setStreetCode(1);
        pr.setBuilding("build");
        pr.setExtension("exten");
        pr.setApartment("apar");

        try {
            dao=new PersonCheckDao();
            PersonResponse respi=dao.checkPerson(pr);
            if(respi.isRegistered()){
                resp.getWriter().write("Registered");
            }
            else{
                resp.getWriter().write("Not registered");
            }

        } catch (PersonCheckException e) {
            e.printStackTrace();
        }
    }
}

//GET /city-register-1.0/checkPerson