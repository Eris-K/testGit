package company;

public class login {
    private String uname;
    private  String upwd;
    public login(){

    }
    public login(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }
    public String getUpwd() {
        return upwd;
    }
}
