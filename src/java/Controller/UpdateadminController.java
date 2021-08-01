/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Copy.Copyimg;
import DAO.UserDAO;
import DTO.UserDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRREDETOR
 */
@WebServlet(name = "UpdateadminController", urlPatterns = {"/UpdateadminController"})
public class UpdateadminController extends HttpServlet {
    private final static String SUCCESS="SearchroleController?search=&action=Search";
    private final static String ERROR="update.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String url=ERROR;
        try {
             String userID= request.getParameter("userID");
            String fullName= request.getParameter("fullName");
            String emmail= request.getParameter("email");
            String roleID= request.getParameter("roleid");
            String phone= request.getParameter("phone");
            String photo= request.getParameter("picture");
             int lastIndex = photo.lastIndexOf("\\");
            String photoName = photo.substring(lastIndex + 1);
            if(!photo.isEmpty()){
                if(photo.contains(".jpg")||photo.contains(".img")||photo.contains(".png")){
                    File head=new File(photo);
                    File tail=new File("D:\\PRJ321\\J3.L.P0017\\web\\image\\"+photoName);
                    Copyimg.copyfile(head, tail);                    
                }else{
                    //flag=false;
                    //error.setPhotoERROR("Photo is wrong");
                }
            }
            UserDAO dao=new UserDAO();
            UserDTO user=new UserDTO(userID, fullName, "", emmail, roleID, photoName, Integer.parseInt(phone), null, true);
            boolean check =dao.update(user);
            if(check){
                url=SUCCESS;
            }
        } catch (Exception e) {
        }finally{
             request.getRequestDispatcher(url).forward(request, response);
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
