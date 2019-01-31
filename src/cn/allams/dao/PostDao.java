package cn.allams.dao;

import cn.allams.domain.Post;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PostDao {
    //连接池对象
    private QueryRunner qr = new TxQueryRunner();

    //新增帖子
    public void add(Post post){
        try {
            String sql = "INSERT INTO post values(?,?,?,?,?)";
            Object[] params = {post.getPid(),post.getUname(),post.getTopic(),post.getPostcontent(),"0"};
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询所有帖子
    public List<Post> findAll(){
        try {
            String sql = "SELECT * FROM post";
            return qr.query(sql, new BeanListHandler<Post>(Post.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //通过pid查询帖子
    public Post findByPid(String pid){
        try {
            String sql = "SELECT * FROM post WHERE pid=?";
            return qr.query(sql, new BeanHandler<Post>(Post.class), pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //新增帖子
    public void browsetimesUp(String pid){
        try {
            String sql = "UPDATE post SET browsetimes = browsetimes+1 WHERE pid = ?";
            Object[] params = {pid};
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //通过pid删除帖子
    public void delete(String pid){
        try {
            String sql = "DELETE FROM post WHERE pid=?";
            Object[] params = {pid};
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
