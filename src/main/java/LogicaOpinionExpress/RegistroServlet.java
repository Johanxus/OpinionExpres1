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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Johanxus
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {

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
        //Variables que recogeran los datos obtenidos en el formulario
        String nombres = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String celular = request.getParameter("telefono");
       
        String correo = request.getParameter("correo");
        String Clave = request.getParameter("contraseña");
        String confirmacion = request.getParameter("confirmarcontraseña");
        
        
        SessionFactory factory = new Configuration()
                .configure("Hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class) // Se configura sessionfactory con la configuracion
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        if(Clave != null && Clave.equals(confirmacion)){ //Si la contraseña y la confirmacion son iguales y no son valores null, entonces se continua con el siguiente bloque de codigo
          Usuario usuario1 = new Usuario(nombres,apellidos, celular,correo,Clave); //Se usa el constructor
          session.beginTransaction(); //Se inicia la transaccion
          session.save(usuario1);//Se guarda en la base de datos
          session.getTransaction().commit();
        response.sendRedirect("Login.html"); //Se redirigue
        
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
