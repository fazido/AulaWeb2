package Util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Francisco 1455
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
          String driver = "org.apache.derby.jdbc.ClientDriver";
          String url = "jdbc:derby://localhost:1527/masp";
          String username = "adm";
          String password = "adm";
            
          try {
              Class.forName(driver);
              Connection connection = DriverManager.getConnection(url, username, password);
              
            Statement statement = connection.createStatement();
              
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String data = request.getParameter("data");
            String tecnica = request.getParameter("tecnica");
            String dimensoes = request.getParameter("dimensoes");
            String autor = request.getParameter("autor");
            String procedencia = request.getParameter("procedencia");
            String tipo = request.getParameter("tipo");
                     
            String insert = "INSERT INTO OBRAS VALUES ('" + id + "','" + nome + "', '" + data +"', '" + tecnica + "', '" + dimensoes +"', '" + autor +"', '" + procedencia +"', '" + tipo +"')";
            statement.executeUpdate(insert);
              
              connection.close();
          } catch(ClassNotFoundException cnfe) {
              out.println("Erro loading driver" + cnfe);
          } catch(SQLException sqle) {
              out.println("Erro loading driver" + sqle);
            
        }
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