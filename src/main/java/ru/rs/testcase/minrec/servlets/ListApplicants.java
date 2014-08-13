/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.testcase.minrec.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.rs.testcase.minrec.entities.Applicant;

/**
 *
 * @author Admin
 */
@WebServlet(name = "list", urlPatterns = "/list")
public class ListApplicants extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject result = new JSONObject();
        if (emf != null) {
            EntityManager em = null;
            try {
                em = emf.createEntityManager();

                List<Applicant> applicants = (List<Applicant>) em.createQuery("SELECT a FROM Applicant a").getResultList();

                if (!applicants.isEmpty()) {

                    JSONArray array = new JSONArray();
                    for (Applicant a : applicants) {
                        JSONObject person = new JSONObject();
                        person.put("name", a.getName());
                        person.put("comment", a.getComment());
                        person.put("time", a.getTime());
                        person.put("status", a.getStatus());
                        array.put(person);
                    }
                    System.out.println(array);

                    result.put("array", array);
                }
                resp.setContentType("text/html");
                resp.setCharacterEncoding("utf8");
                resp.getWriter().println(result);
            } catch (JSONException ex) {
                Logger.getLogger(ListApplicants.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

    }
}
