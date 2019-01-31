package cn.allams.dao;

import cn.allams.domain.User;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    //连接池对象
    private QueryRunner qr = new TxQueryRunner();

    //通过id查找User实体类
    public User findById(String id){
        try {
            String sql = "SELECT * FROM user WHERE uid=?";
            return qr.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //通过用户名查找User实体类
    public User findByUsername(String username){
        try {
            String sql = "SELECT * FROM user WHERE username=?";
            return qr.query(sql, new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //新增用户
    public void add(User user){
        try {
            String sql = "INSERT INTO user values(?,?,?,?)";
            Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),null};
            qr.update(sql,params);
            //qr.insert(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
