/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author PRREDETOR
 */
public class PromotionDTO {
    String id,userid,roleid;
    Date date,dateupdate,datedelete;
    int rank;
    boolean status;

    public PromotionDTO() {
    }

    public PromotionDTO(Date date, Date dateupdate, Date datedelete, int rank) {
        this.date = date;
        this.dateupdate = dateupdate;
        this.datedelete = datedelete;
        this.rank = rank;
    }

    public PromotionDTO(String id, String userid, String roleid, Date date, int rank) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.date = date;
        this.rank = rank;
    }

    public PromotionDTO(String userid, String roleid, Date date, int rank) {
        this.userid = userid;
        this.roleid = roleid;
        this.date = date;
        this.rank = rank;
    }

    public PromotionDTO(String id, String userid, String roleid, Date date, Date dateupdate, Date datedelete, int rank, boolean status) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.date = date;
        this.dateupdate = dateupdate;
        this.datedelete = datedelete;
        this.rank = rank;
        this.status = status;
    }

    public PromotionDTO(String userid, String roleid, Date date, int rank, boolean status) {
        this.userid = userid;
        this.roleid = roleid;
        this.date = date;
        this.rank = rank;
        this.status = status;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getDateupdate() {
        return dateupdate;
    }

    public void setDateupdate(Date dateupdate) {
        this.dateupdate = dateupdate;
    }

    public Date getDatedelete() {
        return datedelete;
    }

    public void setDatedelete(Date datedelete) {
        this.datedelete = datedelete;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
