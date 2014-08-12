/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.rs.testcase.minrec.servlets;

import java.io.IOException;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import ru.rs.testcase.minrec.entities.Applicant;

/**
 *
 * @author dns
 */
@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet{

    @PersistenceUnit
    EntityManagerFactory eFactory;
    @Resource
    UserTransaction transaction;
    
   
            
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em=null;
        try{ 
            
        String name=req.getParameter("name");
        String comment=req.getParameter("comment");
        if(!name.equals("")){
            Applicant applicant=new Applicant(name,comment);
            applicant.setTime(new Date());
            applicant.setStatus("Ожидает");
            transaction.begin();
            em=eFactory.createEntityManager();
          
            em.persist(applicant);
            transaction.commit();
            
            
            req.getRequestDispatcher("/pages/sechome.jsp").forward(req, resp);
        }
        }catch(Exception e) {
                        e.printStackTrace();

            throw new ServletException(e);
        } finally {
            if(em!=null){
                em.close();
            }
        }
        
        
        
    }
    
    
}
