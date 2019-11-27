package entity;

public class Account {

    private int accountid;
    private String name;
    private String surName;
    private int account;

    public Account(int accountid, String name, String surName, int account) {
        this.accountid = accountid;
        this.name = name;
        this.surName = surName;
        this.account = account;
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

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return accountid + " " + name + " " + surName + " " + account + "\n";
    }
}
