package entity;

public class User {

    private int userid;
    private String name;
    private String surName;

    public User(int userid, String name, String surName) {
        this.userid = userid;
        this.name = name;
        this.surName = surName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return userid + " " + name + " " + surName + "\n";
    }
}
