/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RoleDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRREDETOR
 */
public class RoleDAO {
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
    public List<RoleDTO> getRole() throws SQLException{
        List<RoleDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select RoleID,RoleName"
                        + " From tblRole";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    String RoleID=rs.getString("RoleID");
                    String RoleName=rs.getString("RoleName");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new RoleDTO(RoleID, RoleName));
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
