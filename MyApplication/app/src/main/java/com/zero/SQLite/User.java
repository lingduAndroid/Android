package com.zero.SQLite;

/**
 * Created by zero°c on 2018/3/12.
 */

public class User  {

    private int id;
    private String Username;
    private String Password;
    private String sex;
    private int age;

    /**
     * 登陆构造
     * @param Username
     * @param Password
     */
    public User(String Username,String Password){
        this.Username = Username;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserPassword(String userPassword) {
        Password = userPassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {

    }
}
