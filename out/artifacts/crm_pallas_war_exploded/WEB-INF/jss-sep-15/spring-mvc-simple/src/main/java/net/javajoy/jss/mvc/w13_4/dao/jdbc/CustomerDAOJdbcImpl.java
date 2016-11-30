package net.javajoy.jss.mvc.w13_4.dao.jdbc;

import net.javajoy.jss.mvc.w13_4.dao.DAO;
import net.javajoy.jss.mvc.w13_4.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */
@Repository
public class CustomerDAOJdbcImpl implements DAO<Customer> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int i) throws SQLException {
            return new Customer(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getInt("rating")
            );
        }
    }

    static CustomerRowMapper customerRowMapper = new CustomerRowMapper();

    @Override
    public Customer get(long id) {
        String sql = "select * from customers where id=?";
        Customer cust = jdbcTemplate.queryForObject(
                sql,
                new Object[] {id},
                customerRowMapper);
        return cust;
    }

    @Override
    public List<Customer> getAll() {
        String sql = "select * from customers";
        List<Customer> list = jdbcTemplate.query(sql, customerRowMapper);
        return list;
    }

    @Override
    public void delete(long id) {
        String sql = "delete from customers where id=?";
        int affectedRowCount = jdbcTemplate.update(sql, new Object[] {id} );
    }

    @Override
    public void update(Customer detached) {
        if (detached.getId()!=null) {
            String sql = "update customers set name=?, phone=?, address=?, rating=? where id=?";
            int affectedRowCount = jdbcTemplate.update( sql,
                    new Object[] {detached.getName(), detached.getPhone(), detached.getAddress(), detached.getRating(), detached.getId()} );

        }
    }

    @Override
    public void save(Customer trans) {
        KeyHolder holder = new GeneratedKeyHolder();

        String sql = "insert into customers (name, phone, address, rating) values (?,?,?,?)";
        int affectedRowCount = jdbcTemplate.update( sql,
                new Object[] {trans.getName(), trans.getPhone(), trans.getAddress(), trans.getRating(), trans.getId()},
                holder);
        trans.setId( holder.getKey().longValue() );
    }


}
