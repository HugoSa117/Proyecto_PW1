/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
@WebServlet(name = "Guardar", urlPatterns = {"/GuardarServlet"})
public class Guardar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            
            MetodosSQL metodos = new MetodosSQL ();
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String nacimiento = request.getParameter("nacimiento");
            String correo = request.getParameter("correo");
            String usuario = request.getParameter("usuario");
            String confirmPassw = request.getParameter("confirmPassw");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>"); 
            out.println("<script type=\"text/javascript\">");
            
            
            boolean registro = metodos.registrarUsuario(usuario, confirmPassw, nombres, apellidos, nacimiento, correo);
            if (registro == true){
                out.println("alert('usuario registrado con exito :D')");       
                out.println("location ='Login.html'");
            }else{
                out.println("alert('usuario registrado sin exito')");
                out.println("location ='Login.html'");
            }
                 
            System.out.println("Registro en servlet es: " + registro);
            out.println("</script>"); 
            out.println("</body>");
            out.println("</html>");
        
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
