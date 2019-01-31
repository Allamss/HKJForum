package cn.allams.service;

import cn.allams.dao.ReplyDao;
import cn.allams.domain.Reply;

import java.util.List;

public class ReplyService {
    ReplyDao replyDao = new ReplyDao();

    //通过pid查找回复方法
    public List<Reply> findByPid(String pid){
        return replyDao.findByPid(pid);
    }


    //回复方法
    public void reply(Reply form) throws ReplyException{
        replyDao.add(form);
    }

    public void delete(String pid){
        replyDao.delete(pid);
    }
}
