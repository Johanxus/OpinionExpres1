/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LogicaOpinionExpress;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
/**
 *
 * @author Johanxus
 */
@WebServlet(name = "LogicaServlet", urlPatterns = {"/login"})
public class LogicaServlet extends HttpServlet {

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
        String usuario = request.getParameter("usuario"); //Estas variables se usan para recoger los valores del login
        String clave = request.getParameter("contraseña");
         SessionFactory factory = new Configuration()
                .configure("Hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class) //Aqui al session factory con el hibernate.cfg que tiene la configuracion de la base de datosy la ip
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction(); //Se inicia la transaccion
        String hql = "from Usuario u where u.correo = :correo AND u.clave = :clave"; //Se crea una variable el cual contendra la sentencia hql 
        Query<Usuario> query = session.createQuery(hql); //Se ejecuta la sentencia
        query.setParameter("correo", usuario); // Se colocan los valores recogidas en las variables 
        query.setParameter("clave", clave);
        List<Usuario> resultados = query.list(); //Se creo esta lista para verificar si existe el usuario al cual se esta intentando ingrear
       if (!resultados.isEmpty()) {  //Si la lista no esta vacia entonces se redirigue al panl
    response.sendRedirect("Panel.html");
    
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
