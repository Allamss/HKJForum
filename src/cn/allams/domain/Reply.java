package cn.allams.domain;

public class Reply {
    String rid;//回复id
    String pid;//被回复帖子id
    String uname;//回复用户id
    String replycontent;//回复内容

    //各种getset方法
    public String getRid() {
        return rid;
    }
    public void setRid(String rid) {
        this.rid = rid;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getReplycontent() {
        return replycontent;
    }
    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }
}
