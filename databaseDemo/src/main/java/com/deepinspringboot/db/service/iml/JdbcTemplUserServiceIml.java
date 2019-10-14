package com.deepinspringboot.db.service.iml;

import com.deepinspringboot.db.enums.SexEnum;
import com.deepinspringboot.db.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@Service
public class JdbcTemplUserServiceIml implements com.deepinspringboot.db.service.JdbcTemplUserService, StatementCallback {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;
    private Statement statement = null;
    //获取映射关系
    public RowMapper<User> getUserMapper(){
        //使用Lambda表达式创建用户映射关系
        RowMapper<User> userRowMapper = (ResultSet rs,int rownum)->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            user.setNote(rs.getString("note"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            return user;
        };
        return userRowMapper;
    }
    @Override
    public User getUser(Long id) {
        //执行的SQL
        String sql = " select id,user_name,sex,note from t_user where id = ?";
        //参数
        Object[] params = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql,params,getUserMapper());
        return null;
    }

    @Override
    public List<User> findUsers(String username, String note) {
        String sql = "select id ,user_name,sex,note from t_user" +
                "where user_name like concat('%',?,'%')" +
                "and note like concat('%'+?+'%')";
        Object[] params = new Object[]{username,note};
        List<User> users = jdbcTemplate.query(sql, params, getUserMapper());
        return users;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user (id,user_name,sex,note) values (?,?,?,?)";
        Object[] params = new Object[]{user.getId(),user.getUserName(),user.getSex().getId(),user.getNote()};
        int result = jdbcTemplate.update(sql, params);
        return result;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name = ?,sex = ?,note = ? where id = ?";
        Object[] params = new Object[]{user.getUserName(),user.getSex().getId(),user.getNote(),user.getId()};
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user where id = ?";
        int result = jdbcTemplate.update(sql,id);
        return 0;
    }

    @Override
    public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
        this.statement = statement;
        return null;
    }
}
