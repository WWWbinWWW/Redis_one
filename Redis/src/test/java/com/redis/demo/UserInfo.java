package com.redis.demo;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tel;

    private String nickName;

    private String passWord;

    public UserInfo(){}

    @Override
    public String toString(){
        return "UserInfo{" +
                "tel = '" + tel + '\'' +
                ", nickName = '" + nickName + '\'' +
                ", passWord = '" + passWord + '\'' + '}';
    }

    public UserInfo(String tel, String nickName, String passWord){
        this.tel = tel;
        this.nickName = nickName;
        this.passWord = passWord;
    }

    public String getTel(){
        return tel;
    }

    public void setTel(String tel){
        this.tel = tel;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
}
