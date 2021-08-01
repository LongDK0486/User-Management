/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PRREDETOR
 */
public class UserDTO {
    String userID,userName,password,email,roleID,photoName;
    int phone;
    byte[] photo;
    boolean status;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String password, String email, String roleID, String photoName, int phone, byte[] photo, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
        this.photoName = photoName;
        this.phone = phone;
        this.photo = photo;
        this.status = status;
    }

    public UserDTO(String userID, String userName, String photoName) {
        this.userID = userID;
        this.userName = userName;
        this.photoName = photoName;
    }

    public UserDTO(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   

    
            
}
