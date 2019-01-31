package cn.allams.domain;

public class User {
    String uid;//用户id
    String username;//用户名
    String password;//用户密码
    String ifsuper;//是否为超级用户


    //各种get set方法
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIfsuper() {
        return ifsuper;
    }
    public void setIfsuper(String ifsuper) {
        this.ifsuper = ifsuper;
    }
}
