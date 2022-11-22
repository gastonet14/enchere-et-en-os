package fr.eni.EnchereEtEnOs.dal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EnchereEtEnOs.BusinessException;
import fr.eni.EnchereEtEnOs.bll.UtilisateurManager;

@WebServlet("/seconnecter")
public class ServletSeConnecter extends HttpServlet {
    private static final long serialVersionUID = 11;
    public ServletSeConnecter(){

    }
    /**
     * @see HttpServletlet#doget(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("WEB-INF/seconnecter.jsp").forward(request, response);
    }
    /**
     * @see HttpServletlet#doget(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String identifiant = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        try {
            UtilisateurManager.getInstance().seConnecter(identifiant,mdp);
            response.sendRedirect("https://www.google.fr");
        } catch (BusinessException e) {
            request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
            request.getRequestDispatcher("WEb-INF/JSP/seconnecter.jsp").forward(request, response);
        }  
    }
}