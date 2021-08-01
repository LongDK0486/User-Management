/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RoleDTO;
import DTO.UserDTO;
import MaHoa.SHA256;
import Utils.DBUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author PRREDETOR
 */
public class UserDAO {
    Connection conn=null;
    PreparedStatement ps =null;
    ResultSet rs=null;
    public void closeConnection() throws SQLException{
        if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
    }
   
     public UserDTO login(String id,String password) throws SQLException, NoSuchAlgorithmException{
        UserDTO user=null;
         SHA256 sha = new SHA256();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql=" Select UserID,UserName,email,phone,photo,photoName,RoleID,status"
                        + " From tblUsers"
                        + " Where UserID='" + id + "' And password='" + sha.bytesToHex(encodedhash) + "'";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){         
                    String name =rs.getString("UserName");
                    String email=rs.getString("email");
                    byte[] photo=rs.getBytes("photo");
                     String photoname=rs.getString("photoName");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("RoleID");                    
                    boolean status=rs.getBoolean("status");
                    if(status==true){
                       user=new UserDTO(id, name, "", email, roleID,photoname, phone, photo, status);
                    }else{
                        return user;
                    }         
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return user;
    }
     
     public List<UserDTO>GetListUser(String search,String role) throws SQLException{
        List<UserDTO> list=null;       
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select UserID,UserName,email,phone,photo,photoName,RoleID,status"
                        + " From tblUsers"
                        + " Where UserName Like ? and status=1 and RoleID=?";
                ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+ search +"%");
                ps.setString(2,role ); 
                rs=ps.executeQuery();
                
                while(rs.next()){
                    String itemid=rs.getString("UserID");
                     String name =rs.getString("UserName");
                    String email=rs.getString("email");                   
                    byte[] photo=rs.getBytes("photo");
                     String photoname=rs.getString("photoName");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("RoleID");                    
                    boolean status=rs.getBoolean("status");
                    if(list==null){     
                        list=new ArrayList<>();
                    }
                    
                    list.add(new UserDTO(itemid, name, "", email, roleID, photoname, phone, photo, status));
                    
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
     public List<UserDTO>GetallListUser(String role) throws SQLException{
        List<UserDTO> list=null;       
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select UserID,UserName,email,phone,photo,photoName,RoleID,status"
                        + " From tblUsers"
                        + " Where status=1 and RoleID='" + role + "'";                     
                ps=conn.prepareStatement(sql);            
                rs=ps.executeQuery();              
                while(rs.next()){
                    String itemid=rs.getString("UserID");
                     String name =rs.getString("UserName");
                    String email=rs.getString("email");                    
                    byte[] photo=rs.getBytes("photo");
                     String photoname=rs.getString("photoName");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("RoleID");                    
                    boolean status=rs.getBoolean("status");
                    if(list==null){     
                        list=new ArrayList<>();
                    }                    
                    list.add(new UserDTO(itemid, name, "", email, roleID, photoname, phone, photo, status));                   
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
     public List<UserDTO>GetallListUserAdmin() throws SQLException{
        List<UserDTO> list=null;       
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select UserID,UserName,email,phone,photo,photoName,RoleID,status"
                        + " From tblUsers"
                        + " Where status = 1";
                                            
                ps=conn.prepareStatement(sql);            
                rs=ps.executeQuery();              
                while(rs.next()){
                    String itemid=rs.getString("UserID");
                     String name =rs.getString("UserName");
                    String email=rs.getString("email");                    
                    byte[] photo=rs.getBytes("photo");
                     String photoname=rs.getString("photoName");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("RoleID");                    
                    boolean status=rs.getBoolean("status");
                    if(list==null){     
                        list=new ArrayList<>();
                    }                    
                    list.add(new UserDTO(itemid, name, "", email, roleID, photoname, phone, photo, status));                   
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
     public List<UserDTO>GetallListUserroleAdmin(String role) throws SQLException{
        List<UserDTO> list=null;       
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select UserID,UserName,email,phone,photo,photoName,RoleID,status"
                        + " From tblUsers"
                        + " Where status = 1";                                           
                ps=conn.prepareStatement(sql);            
                rs=ps.executeQuery();              
                while(rs.next()){
                    String itemid=rs.getString("UserID");
                     String name =rs.getString("UserName");
                    String email=rs.getString("email");                    
                    byte[] photo=rs.getBytes("photo");
                     String photoname=rs.getString("photoName");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("RoleID");                    
                    boolean status=rs.getBoolean("status");
                    if(list==null){     
                        list=new ArrayList<>();
                    } 
                    if(role.equals("0")||roleID.equals(role)){
                        list.add(new UserDTO(itemid, name, "", email, roleID, photoname, phone, photo, status)); 
                    }
                                      
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
      public boolean DeleteUser(String id)throws SQLException{
        boolean check = false;     
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblUsers Set status = 0"
                        + " Where UserID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
      public List<UserDTO>GetListUserAdmin(String search) throws SQLException{
        List<UserDTO> list=null;       
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select UserID,UserName,email,phone,photo,photoName,RoleID,status"
                        + " From tblUsers"
                        + " Where UserName Like ? and status=1 ";
                ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+ search +"%");
                rs=ps.executeQuery();
                
                while(rs.next()){
                    String itemid=rs.getString("UserID");
                     String name =rs.getString("UserName");
                    String email=rs.getString("email");
                    
                    byte[] photo=rs.getBytes("photo");
                     String photoname=rs.getString("photoName");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("RoleID");                    
                    boolean status=rs.getBoolean("status");
                    if(list==null){     
                        list=new ArrayList<>();
                    }
                    
                    list.add(new UserDTO(itemid, name, "", email, roleID, photoname, phone, photo, status));
                    
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
       public void insert(UserDTO user) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tblUsers(UserID,UserName,password,email,phone,photo,photoName,RoleID,status)"
                        + " Values(?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserID());
                ps.setString(2, user.getUserName());
                ps.setString(3, user.getPassword());
                 ps.setString(4, user.getEmail());
                  ps.setInt(5, user.getPhone());
                   ps.setBytes(6, user.getPhoto());
                  ps.setString(7, user.getPhotoName());
                  ps.setString(8, user.getRoleID());
                  ps.setBoolean(9, user.isStatus());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    public boolean update(UserDTO user) throws SQLException{
        boolean check=false;    
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Update tblUsers Set UserName=?,email=?,phone=?,photoName=?,RoleID=?"
                        + " Where UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getEmail());
                ps.setInt(3, user.getPhone());
                ps.setString(4, user.getPhotoName());
                ps.setString(5, user.getRoleID());
                ps.setString(6, user.getUserID());
                check=ps.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{          
          closeConnection();
        }
        return check;
    }
    public List<UserDTO> getName() throws SQLException{
        List<UserDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select UserID,UserName,photoName"
                        + " From tblUsers";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    String UserID=rs.getString("UserID");
                    String UserName=rs.getString("UserName");
                    String photoName=rs.getString("photoName");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new UserDTO(UserID, UserName,photoName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
}
