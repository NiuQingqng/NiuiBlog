package ltd.niui.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userNickname;
    private String userSex;
    private Date userBirthday;
    private String userCity;
    private String userEmail;
    private String userAvatar;
    private String userDescribe;
    private String userLastLoginIp;
    private Date userRegisterTime;
    private Date userLastLoginTime;
    private Integer userRole;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userCity='" + userCity + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", userLastLoginIp='" + userLastLoginIp + '\'' +
                ", userRegisterTime=" + userRegisterTime +
                ", userLastLoginTime=" + userLastLoginTime +
                ", userRole=" + userRole +
                '}';
    }
}
