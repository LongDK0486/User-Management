/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Copy.Copyimg;
import DAO.UserDAO;
import DTO.UserDTO;
import DTO.UserError;
import MaHoa.SHA256;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author PRREDETOR
 */
@WebServlet(name = "CreateuserController", urlPatterns = {"/CreateuserController"})
public class CreateuserController extends HttpServlet {
    private static final String SUCCESS="Login.jsp";
    private static final String ERROR="CreateAccount.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        UserError error=new UserError("", "", "", "", "", "", "");
        try {
             boolean flag=true;
             String userid=request.getParameter("userID");
            String name=request.getParameter("fullName");
            String role=request.getParameter("roleID");
             String email=request.getParameter("email");
            int phone =Integer.parseInt("0");
            String password=request.getParameter("password");
            String confirm=request.getParameter("confirm");
            String photo=request.getParameter("photo");
            int lastIndex = photo.lastIndexOf("\\");
            String photoName = photo.substring(lastIndex + 1);
            if(!photo.isEmpty()){
                if(photo.contains(".jpg")||photo.contains(".img")||photo.contains(".png")){
                    File head=new File(photo);
                    File tail=new File("D:\\PRJ321\\J3.L.P0017\\web\\image\\"+photoName);
                    Copyimg.copyfile(head, tail);                    
                }else{
                    flag=false;
                error.setPhotoERROR("Photo is wrong");
                }
            }           
            if(userid.length()<2||userid.length()>20){
                flag=false;
               error.setUserIDERROR("Id not must below than 2  and lager than 20 word ");
            }
            if(name.length()>30){
                flag=false;
                error.setFullnamERROR("Name must not lager than 30");
            }
            if(role.length()<1||role.length()>50){
                flag=false;
                error.setFullnamERROR("Address must not below than 3 and lager than 500");
            }           
            if(!password.equals(confirm)){
                flag=false;
                error.setConfirmERROR("password not confirm");
            }
            try {
                phone =Integer.parseInt(request.getParameter("phone"));
                if(phone<=0){
                    flag=false;
                    error.setPhoneERROR("Phone number must be 11 digit");
                }
            } catch (Exception e) {
                flag=false;
                error.setPhoneERROR("Phone number must be digit");
            }
            SHA256 sha = new SHA256();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));           
            if(flag){
                UserDTO dto=new UserDTO(userid, name,sha.bytesToHex(encodedhash), email, role, photoName, phone, null, true);
                UserDAO dao=new UserDAO();
                dao.insert(dto);
                request.setAttribute("NEW_ACCOUNT", dto);
                url=SUCCESS;               
            }else{
                request.setAttribute("ERROR", error);
            }
            
        } catch (Exception e) {
            log("Error at CreateController"+e.toString());
            if(e.toString().contains("duplicate")){
                error.setUserIDERROR("UserID duplicate");
                request.setAttribute("ERROR", error);
            }
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
