package com.nov.hotel.entities;

public class Client {
    private long id;
    private String name;
    private String passportSer;
    private String passportNum;
    private String passportDate;
    private String innOkpo;
    private String banReq;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportSer() {
        return passportSer;
    }

    public void setPassportSer(String passportSer) {
        this.passportSer = passportSer;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(String passportDate) {
        this.passportDate = passportDate;
    }

    public String getInnOkpo() {
        return innOkpo;
    }

    public void setInnOkpo(String innOkpo) {
        this.innOkpo = innOkpo;
    }

    public String getBanReq() {
        return banReq;
    }

    public void setBanReq(String banReq) {
        this.banReq = banReq;
    }
}
