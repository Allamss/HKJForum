package cn.allams.dao;

import cn.allams.domain.Reply;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ReplyDao {
    //连接池对象
    private QueryRunner qr = new TxQueryRunner();



    public List<Reply> findByPid(String pid){
        try {
            String sql = "SELECT * FROM reply WHERE pid=?";
            return qr.query(sql, new BeanListHandler<Reply>(Reply.class), pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //新增回复
    public void add(Reply reply){
        try {
            String sql = "INSERT INTO reply values(?,?,?,?)";
            Object[] params = {reply.getRid(),reply.getUname(),reply.getPid(),reply.getReplycontent()};
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String pid){
        try {
            String sql = "DELETE  FROM reply WHERE pid=?";
            Object[] params = {pid};
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
