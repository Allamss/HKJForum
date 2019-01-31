package cn.allams.service;

import cn.allams.dao.PostDao;
import cn.allams.domain.Post;

import java.util.List;

public class PostService {
    PostDao postDao = new PostDao();

    //发新帖子方法
    public void post(Post form) throws PostException{
        postDao.add(form);
    }

    //得到所有帖子
    public List<Post> findAll(){
        return postDao.findAll();
    }

    //通过pid查找帖子方法
    public Post findByPid(String pid){
        postDao.browsetimesUp(pid);
        return postDao.findByPid(pid);
    }

    public void delete(String pid){
        postDao.delete(pid);
    }
}
