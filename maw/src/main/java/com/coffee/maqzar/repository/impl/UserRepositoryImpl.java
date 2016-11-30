package com.coffee.maqzar.repository.impl;

import com.coffee.maqzar.domain.User;
import com.coffee.maqzar.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        Map<String, Object> params = new HashMap<String, Object>();

        String query = "SELECT * FROM SIC_U";

        List<User> listUsers = jdbcTemplate.query(query, params, new UserMapper());

        return listUsers;
    }

    @Override
    public User findUserById(Long userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", userId);

        String query = "SELECT * FROM SIC_U WHERE ID = :id";

        User user = jdbcTemplate.queryForObject(query, params, new UserMapper());

        return user;
    }

    @Override
    public List<User> findUserByLastName(String lastName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("lastName", "%"+lastName+"%");

        String query = "SELECT * FROM SIC_U WHERE LAST_NAME like :lastName";

        List<User> listUser = jdbcTemplate.query(query, params, new UserMapper());
        return listUser;
    }

    @Override
    public List<User> findUserByName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "%"+name+"%");

        String query = "SELECT * FROM SIC_U WHERE name like :name";

        List<User> listUser = jdbcTemplate.query(query, params, new UserMapper());

        return listUser;
    }

    @Override
    public void addUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("lastName", user.getLastName());
        params.put("middleName", user.getMiddleName());
        params.put("age", user.getAge());
        params.put("active", user.getActive());

        String query = "INSERT INTO SIC_U (NAME,LAST_NAME, MIDDLE_NAME, AGE, ACTIVE) VALUES (:name, :lastName, :middleName, :age, :active)";

        jdbcTemplate.update(query, params);
    }

    private static final class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getLong("ID"));
            user.setName(rs.getString("NAME"));
            user.setLastName(rs.getString("LAST_NAME"));
            user.setMiddleName(rs.getString("MIDDLE_NAME"));
            user.setAge(rs.getInt("AGE"));
            user.setActive(rs.getBoolean("ACTIVE"));
            return user;
        }
    }
}
