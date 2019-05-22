package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/hello")
    public List<Question> getQuestions(){
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM Ip1qtX0zCG.Question;";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query(sql, new ResultSetExtractor() {
            @Override
            public List<Question> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                while(resultSet.next()){
                    Question q = new Question(resultSet);
                    list.add(q);
                }
                return list;
            }
        });
        return list;
    }
}
