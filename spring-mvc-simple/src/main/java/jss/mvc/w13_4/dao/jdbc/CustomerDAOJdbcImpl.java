package jss.mvc.w13_4.dao.jdbc;

import jss.mvc.w13_4.dao.DAO;
import jss.mvc.w13_4.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDAOJdbcImpl implements DAO<Customer> {

    static CustomerRowMapper customerRowMapper = new CustomerRowMapper();
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer get(long id) {
        String sql = "SELECT * FROM customers WHERE id=?";
        Customer customer = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                customerRowMapper
        );

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT * FROM customers";
        List<Customer> customers = jdbcTemplate.query(sql, customerRowMapper);

        return customers;
    }

    // because object pass by link, Customer will have id
    @Override
    public void save(Customer transition) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO customers (name, phone, address, rating) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                new Object[]{transition.getName(), transition.getPhone(), transition.getAddress(), transition.getRating()},
                holder
        );

        transition.setId(holder.getKey().longValue());
    }

    @Override
    public Long update(Customer detached) {
        Long affectedAmount = Long.valueOf(0);
        if (detached.getId() != null) {
            String sql = "UPDATE customers SET name=?, phone=?, address=? , rating=? WHERE id=?";
            affectedAmount = Long.valueOf(jdbcTemplate.update(
                    sql,
                    new Object[]{
                            detached.getName(),
                            detached.getPhone(),
                            detached.getAddress(),
                            detached.getRating(),
                            detached.getId()
                    }
            ));
        }

        return affectedAmount;
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM customers WHERE id=?";
        int affectedAmount = jdbcTemplate.update(
                sql,
                new Object[]{id}
        );
    }

    static class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int i) throws SQLException {
            return new Customer(
                    rs.getLong("id"),
                    rs.getString("address"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getInt("rating")
            );
        }
    }
}
