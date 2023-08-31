/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.jspproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author guime
 */
@WebServlet(name = "svEquipos", urlPatterns = {"/svEquipos"})
public class svEquipos extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet svEquipos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet svEquipos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);

        //Determinar resultado de partidos
        int equipo1= Integer.parseInt(request.getParameter("equipo1"));
        int equipo2 = Integer.parseInt(request.getParameter("equipo2"));
        int equipo3 = Integer.parseInt(request.getParameter("equipo3"));
        int equipo4 = Integer.parseInt(request.getParameter("equipo4"));
        int equipo5 = Integer.parseInt(request.getParameter("equipo5"));
        int equipo6 = Integer.parseInt(request.getParameter("equipo6"));
        int equipo7 = Integer.parseInt(request.getParameter("equipo7"));
        int equipo8 = Integer.parseInt(request.getParameter("equipo8"));
        
        List<Equipos> clasificacion = new ArrayList<>();
        
        //Enfrentamiento1
        if (equipo1 > equipo2) {
            equipo1 = 3;
            equipo2 = 0;
        }else if(equipo1 == equipo2){
            equipo1 = 1;
            equipo2 = 1;
        }else{
            equipo1 = 0;
            equipo2 = 3;
        }
        
        //Enfrentamiento2
        if (equipo3 > equipo4) {
            equipo3 = 3;
            equipo4 = 0;
        }else if(equipo3 == equipo4){
            equipo3 = 1;
            equipo4 = 1;
        }else{
            equipo3 = 0;
            equipo4 = 3;
        }
        
        //Enfrentamiento3
        if (equipo5 > equipo6) {
            equipo5 = 3;
            equipo6 = 0;
        }else if(equipo5 == equipo6){
            equipo5 = 1;
            equipo6 = 1;
        }else{
            equipo5 = 0;
            equipo6 = 3;
        }
        
        //Enfrentamiento4
        if (equipo7 > equipo8) {
            equipo7 = 3;
            equipo8 = 0;
        }else if(equipo7 == equipo8){
            equipo7 = 1;
            equipo8 = 1;
        }else{
            equipo7 = 0;
            equipo8 = 3;
        }
        
        actualizarClasificacion(clasificacion, "Los Angeles Lakers", equipo1);
        actualizarClasificacion(clasificacion, "Real Madrid Baloncesto", equipo2);
        actualizarClasificacion(clasificacion, "CSKA Moscow", equipo3);
        actualizarClasificacion(clasificacion, "Perth Wildcats", equipo4);
        actualizarClasificacion(clasificacion, "Fenerbahçe Beko Istanbul", equipo5);
        actualizarClasificacion(clasificacion, "Boca Juniors", equipo6);
        actualizarClasificacion(clasificacion, "Guangdong Southern Tigers", equipo7);
        actualizarClasificacion(clasificacion, "Anadolu Efes Istanbul", equipo8);
        
        ordenarClasificacion(clasificacion);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("clasificacion", clasificacion);
        
        response.sendRedirect("index.jsp");
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
        //processRequest(request, response);
    }
    
    private void actualizarClasificacion(List<Equipos> clasificacion, String nombreEquipo, int puntos) {
        boolean encontrado = false;
        for (Equipos equipo : clasificacion) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                equipo.sumarPuntos(puntos);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            clasificacion.add(new Equipos(nombreEquipo, puntos));
        }
    }
    
    private void ordenarClasificacion(List<Equipos> clasificacion) {
        Collections.sort(clasificacion);
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
