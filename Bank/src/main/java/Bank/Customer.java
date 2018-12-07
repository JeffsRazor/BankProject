package csc.groupProject.Bank.Bank;

public class Customer { // use builder pattern
    private String username;
    private String address;
    private double salary;
    private int ssn;
    private int creditScore;
    private String password;

    public Customer(){
        this.setUsername(getUsername());
        this.setPassword(getPassword());
        this.setAddress(getAddress());
        this.setSalary(getSalary());
        this.setSsn(getSsn());
        this.setCreditScore(getCreditScore());

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public int getSsn() {
        return ssn;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public String getPassword() {
        return password;
    }
}
