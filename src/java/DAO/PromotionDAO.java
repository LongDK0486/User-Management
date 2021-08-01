/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PromotionDTO;
import DTO.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRREDETOR
 */
public class PromotionDAO {
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
     public void insert(PromotionDTO user) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tblPromotion(UserID,RoleID,datecreatereq,RankPromotion,status)"
                        + " Values(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserid());
                ps.setString(2, user.getRoleid());
                ps.setDate(3, user.getDate());
                 ps.setInt(4, user.getRank()); 
                 ps.setBoolean(5, user.isStatus());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
      public  boolean checkuser(String userID) throws SQLException{
        boolean check=false;      
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Update tblPromotion Set status = 1 "
                        + " Where UserID = ? and status = 0";
                ps=conn.prepareStatement(sql);
                ps.setString(1, userID);              
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
     public List<PromotionDTO> searchPromotion() throws SQLException{
        List<PromotionDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select idpromotion,UserID,RoleID,datecreatereq,RankPromotion"
                        + " From tblPromotion"
                        + " Where status = 1";                   
                ps=conn.prepareStatement(sql);               
                rs=ps.executeQuery();
                while(rs.next()){
                    String id=rs.getString("idpromotion");
                    String userid=rs.getString("UserID");
                    String roleID=rs.getString("RoleID");
                    Date datecreate=rs.getDate("datecreatereq");
                    int status=rs.getInt("RankPromotion");
                    if(list==null){
                        list=new ArrayList<>();
                    }                 
                        list.add(new PromotionDTO(id, userid, roleID, datecreate, status));           
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
     
      public  boolean deletePromotion(String userID,Date deletedate) throws SQLException{
        boolean check=false;      
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Update tblPromotion Set status = 0 ,deletedate = ?"
                        + " Where UserID = ?";
                ps=conn.prepareStatement(sql);
                ps.setDate(1, deletedate);
                 ps.setString(2, userID);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
      public  boolean updaterank(String userID,Date update,int rank) throws SQLException{
        boolean check=false;      
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Update tblPromotion Set RankPromotion = ? ,updatedate = ?"
                        + " Where UserID = ?";
                ps=conn.prepareStatement(sql);
                ps.setInt(1, rank);
                ps.setDate(2, update);
                ps.setString(3, userID);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
      public List<PromotionDTO> searchPromotiondate (String userid) throws SQLException{
        List<PromotionDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select updatedate,deletedate,datecreatereq,RankPromotion"
                        + " From tblPromotion"
                        + " Where UserID = ?";                   
                ps=conn.prepareStatement(sql);                    
                ps.setString(1, userid);
                rs=ps.executeQuery();
                while(rs.next()){
                    Date updateday=rs.getDate("updatedate");
                    Date deleteday=rs.getDate("deletedate");
                    Date datecreate=rs.getDate("datecreatereq");
                    int rank=rs.getInt("RankPromotion");                  
                    if(list==null){
                        list=new ArrayList<>();
                    }                 
                        list.add(new PromotionDTO(datecreate, updateday, deleteday, rank));           
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
