package com.springJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao{

    private Connection connection = null;
    private String sqlCode = null;
    private DataSource dataSource;



    @Override
    public void addPerson(Person person) {
       sqlCode ="Insert into sys.person ( name , sureName)" +
               "VALUES(? , ? )";
       try {
           connection = dataSource.getConnection();
           PreparedStatement statement;
           statement = connection.prepareStatement(sqlCode);
           statement.setString(1 ,person.getName());
           statement.setString(2 ,person.getSureName());
           statement.executeUpdate();
           statement.close();
       }catch (SQLException e) {
              throw new RuntimeException(String.valueOf(e.getErrorCode()));
       } finally {
           if(connection != null){
               try {
                   connection.close();
               } catch (SQLException e) {
                   throw new RuntimeException(String.valueOf(e.getErrorCode()));
               }
           }
       }
    }

    @Override
    public Person getPersonById(int id) {
        sqlCode ="select * from sys.person where idperson = ?";
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement;
            statement = connection.prepareStatement(sqlCode);
            statement.setInt(1 ,id);
            Person person = null;
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                person = new Person(resultSet.getString("name") ,
                        resultSet.getString("sureName"),resultSet.getInt("idperson"));
            }
            resultSet.close();
            statement.close();
            return person;
        }catch (SQLException e) {
            throw new RuntimeException(String.valueOf(e.getErrorCode()));
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(String.valueOf(e.getErrorCode()));
                }
            }
        }
    }

    @Override
    public List<Person> getAllPersons() {
        sqlCode ="select * from sys.person";
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement;
            statement = connection.prepareStatement(sqlCode);
            List<Person> personList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            Person person=null;
            while(resultSet.next()){
                 person = new Person(resultSet.getString("name") ,
                        resultSet.getString("sureName"),resultSet.getInt("idperson"));
                personList.add(person);
            }
            resultSet.close();
            statement.close();
            return personList;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(String.valueOf(e.getErrorCode()));
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(String.valueOf(e.getErrorCode()));
                }
            }
        }
    }

    @Override
    public void createPerson(Person person) {
        sqlCode ="Insert into sys.person ( name , sureName)" +
                "VALUES(? , ? )";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object [] args = new Object[]{person.getName() , person.getSureName()};
        jdbcTemplate.update(sqlCode , args);
    }

    @Override
    public void deletePerson(int id) {
        sqlCode ="delete sys.person where idperson = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object [] args = new Object[]{id};
        jdbcTemplate.update(sqlCode , args);
    }

    @Override
    public void updatePerson(Person person ,int id) {
        sqlCode ="update sys.person set name = ? , sureName = ?" +
                "where idperson = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object [] args = new Object[]{person.getName() , person.getSureName() ,id};
        jdbcTemplate.update(sqlCode , args);
    }

    @Override
    public Person readPerson(int id) {
        sqlCode ="select * from sys.person where idperson = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object [] args = new Object[]{id};
        Person person = jdbcTemplate.queryForObject(sqlCode, args, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person1 = new Person();
                   person1.setPersonId(rs.getInt("idperson"));
                   person1.setName(rs.getString("name"));
                   person1.setSureName(rs.getString("sureName"));

                return person1;
            }
        });
        return  person;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
