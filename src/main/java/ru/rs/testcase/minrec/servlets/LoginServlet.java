/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.testcase.minrec.servlets;

import java.io.IOException;
import javax.persistence.
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        em.resp.setContentType("text/html");
        resp.getWriter().println("{\"name\":\"qq\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameterNames());
    }
//        String minister = req.getParameter("minister");
//        String url = "/";
//        if (minister.equals("")) {
//            url = "/ministerPage";
//        } else {
//            url = "/secretaryPage";
//        }
//        req.getRequestDispatcher(url).forward(null, null);
//    }
}
