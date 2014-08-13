/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.testcase.minrec.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import org.json.JSONArray;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = "/register")
public class RegServlet extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;
    @Resource
    UserTransaction utx;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String status = req.getParameter("status");
        String array = req.getParameter("array");

        StringBuilder query = new StringBuilder("update Applicant a set a.status=\'" + status + "\' where ");
        JSONArray arr = new JSONArray();

        EntityManager em = null;

        try {
            arr = new JSONArray(array);
            int i = 0;
            query.append("a.name=\'").append(arr.getString(i)).append("\'");
            while (++i < arr.length()) {
//                if ((i + 1) != arr.length()) {
                query.append(" or ");
//                }
                query.append("a.name=\'").append(arr.getString(i)).append("\'");

            }
            utx.begin();
            em = emf.createEntityManager();
            Query q = em.createQuery(query.toString());
            q.executeUpdate();
            utx.commit();
        } catch (Exception ex) {
            Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(query.toString());
    }

}
