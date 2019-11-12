/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simplejdbc.CustomerEntity;
import simplejdbc.DAOException;
import simplejdbc.DataSourceFactory;
import simplejdbc.ExtendedDAO;

/**
 *
 * @author pedago
 */
@WebServlet(name = "TauxRemiseController", urlPatterns = {"/TauxRemiseController"})
public class TauxRemiseController extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws simplejdbc.DAOException
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, DAOException {
		String jspView; // La page à afficher
		// En fonction des paramètres, on initialise les variables utilisées dans les JSP
		// Et on choisit la vue (page JSP) à afficher
                ExtendedDAO dao = new ExtendedDAO(DataSourceFactory.getDataSource());
		Map<String, Float> listeCodes = dao.existingCode();
                request.setAttribute("listeCodes",listeCodes);
                jspView = "tauxRemiseView.jsp";
		// On continue vers la page JSP sélectionnée
		request.getRequestDispatcher("views/" + jspView).forward(request, response);
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
            try {
                processRequest(request, response);
            } catch (DAOException ex) {
                Logger.getLogger(TauxRemiseController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                processRequest(request, response);
            } catch (DAOException ex) {
                Logger.getLogger(TauxRemiseController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
