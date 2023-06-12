package org.example.model;

public class Researcher {
    private int researcherId;
    private String userName;
    private String nationalCode;
    private String password;

    public Researcher(int id,String userName,String nationalCode,String password) {
        this.researcherId=id;
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.password = password;
    }

    public Researcher(String userName, String nationalCode) {
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.password=nationalCode;
    }

    public Researcher(String userName, String nationalCode,
                      String password) {
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.password = password;
    }

    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(getPassword()==null){
            this.password = this.nationalCode;
        }else
            this.password = password;
    }
}
