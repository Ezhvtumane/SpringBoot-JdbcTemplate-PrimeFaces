package ogs.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcService {

    private List<User> users;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        return jdbcTemplate.query(
                " select id, name, email from ogst "
                       ,
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getString("id"), rs.getString("name"),
                                rs.getString("email"));
                    }
                });
    }

}
