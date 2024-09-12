/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dto.Response_DTO;
import entity.Model;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.Validations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "LoadSingleProduct", urlPatterns = {"/LoadSingleProduct"})
public class LoadSingleProduct extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            String productId = "9";
            
            Gson gson = new Gson();
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            Response_DTO response_DTO = new Response_DTO();
            
            if (Validations.isInteger(productId)) {
                
                Product product = (Product) session.get(Product.class, Integer.parseInt(productId));
                Criteria criteria1 = session.createCriteria(Model.class);
                criteria1.add(Restrictions.eq("category", product.getModel().getCategory()));
                List<Model> modelList = criteria1.list();
                
                Criteria criteria2 = session.createCriteria(Product.class);
                criteria2.add(Restrictions.in("model", modelList));
                criteria2.setMaxResults(4);
                
                List<Product> productList = criteria2.list();
                
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(productList));
                
            } else {
                response_DTO.setContent("Product not Found");
                
            }
        } catch (Exception e) {
        }
    }
    
}
