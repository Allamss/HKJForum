package cn.allams.domain;

import java.util.List;

public class Post {
    String pid;//帖子id
    String uname;//作者id
    String topic;//帖子标题
    String postcontent;//帖子内容
    String browsetimes;//访问次数
    List<Reply> replys;//帖子回复集合

    //各种getset方法
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
    public String getPostcontent() {
        return postcontent;
    }
    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }
    public String getBrowsetimes() {
        return browsetimes;
    }
    public void setBrowsetimes(String browsetimes) {
        this.browsetimes = browsetimes;
    }
    public List<Reply> getReplys() {
        return replys;
    }
    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
}
