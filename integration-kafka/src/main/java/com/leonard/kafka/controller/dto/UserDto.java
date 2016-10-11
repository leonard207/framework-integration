package com.leonard.kafka.controller.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by ning.li on 2016/10/11.
 */
public class UserDto {

    private Integer userId;
    private String userName;
    private List<Long> userList;
    private Date gmtCeate;
    
    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the userList
     */
    public List<Long> getUserList() {
        return userList;
    }
    
    /**
     * @param userList the userList to set
     */
    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }
    
    /**
     * @return the gmtCeate
     */
    public Date getGmtCeate() {
        return gmtCeate;
    }
    
    /**
     * @param gmtCeate the gmtCeate to set
     */
    public void setGmtCeate(Date gmtCeate) {
        this.gmtCeate = gmtCeate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userList=" + userList +
                ", gmtCeate=" + gmtCeate +
                '}';
    }
}
