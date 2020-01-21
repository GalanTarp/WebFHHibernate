/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Categoria;
import pojos.Producto;
import util.HibernateUtil;

/**
 *
 * @author Alberto
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        Session singleton = HibernateUtil.getSessionFactory().openSession();
         
        List<Categoria> categorias;
        List<Producto> productos;
        Producto producto;
                
        RequestDispatcher dispatcher;
        if (op.equals("inicio")) {
            Query q = singleton.createQuery("from Categoria");
            categorias = q.list();
            session.setAttribute("categorias", categorias);
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } else if (op.equals("dameproductos")) {
            String categoriaid = request.getParameter(String.valueOf("id"));
            Query q = singleton.createQuery("from Producto where categoria.id = ?");
            q.setString(0,categoriaid);
            productos = (List<Producto>)q.list();

            session.setAttribute("productos", productos);
            dispatcher = request.getRequestDispatcher("product.jsp");
            dispatcher.forward(request, response);

        } else if (op.equals("dameproducto")) {
            String productoid = request.getParameter(String.valueOf("id"));
            Query q = singleton.createQuery("from Producto where id = ?");
            q.setString(0,productoid);
            producto = (Producto)q.uniqueResult();
            Query q2 = singleton.createQuery("select round(avg(puntos)) from Punto where producto.id = ?");
            q2.setString(0,productoid);
            int estrellasmedia = (int)q2.uniqueResult();
            
            session.setAttribute("producto", producto);
            session.setAttribute("estrellasmedia", estrellasmedia);
            dispatcher = request.getRequestDispatcher("producto.jsp");
            dispatcher.forward(request, response);
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
