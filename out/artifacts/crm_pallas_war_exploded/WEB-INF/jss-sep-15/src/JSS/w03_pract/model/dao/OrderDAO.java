package JSS.w03_pract.model.dao;


import JSS.w03_pract.model.DatabaseConnection;
import JSS.w03_pract.model.om.Customer;
import JSS.w03_pract.model.om.Order;
import JSS.w03_pract.model.om.Product;
import jdk.internal.org.objectweb.asm.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;

public class OrderDAO implements DAO<Order> {

    LinkedHashMap<Long,Order> data = new LinkedHashMap<>(100);
    Connection conn = null;

    Filter filter = null;
    Ordering ordering = null;

    @Override
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public void setOrderingField(String field) {
        ordering = () -> field;
    }
    public String getOrderingField() {
        return ordering!=null? ordering.getSQLOrdering() : "";
    }

    @Override
    public void refresh() {
        data.clear();
        Connection conn = DatabaseConnection.getConnection("salesdept");
        try (Statement stmt = conn.createStatement()) {
            String sql = "Select * from orderView";
            if (filter!=null) {
                sql += " where " + filter.getSQLCondition();
            }
            if (ordering!=null) {
                sql += " order by " + ordering.getSQLOrdering();
            }
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getLong("customer_id"),
                        rs.getString("name"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getInt("rating")
                );
                Product product = new Product(
                        rs.getLong("product_id"),
                        rs.getString("description"),
                        rs.getFloat("price")
                );
                Order order = new Order(rs.getLong("order_id"), customer, product, rs.getDate("date"), rs.getInt("qty"), rs.getFloat("amount"));
                data.put(order.getId(), order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getByID(long id) {
        return data.get(id);
    }

    @Override
    public Order getByPosition(int pos) {
        if (pos >=0 && pos <data.size()) {
            return (Order) data.values().toArray()[pos];
        } else return null;
    }

    @Override
    public List<Order> getAsList() {
        List list = new ArrayList(data.size());
        data.values().forEach(o -> list.add(o));

        return list;
    }

    @Override
    public List<Order> getAsList(Predicate<Order> predicate) {
        List list = new ArrayList(data.size());
        data.values().stream().filter(predicate).forEach(o -> list.add(o));
        return list;
    }

    @Override
    public long add(Order order) {
        long id = -1;

        String sql = "{call insertOrder(?,?,?,?,?,?)}";
        try ( CallableStatement stmt = conn.prepareCall(sql) ) {

            stmt.setString(1,order.getCustomer().getName());
            stmt.setLong(2, order.getProduct().getId());
            stmt.setDate(3, order.getDate());
            stmt.setInt(4, order.getQty());
            stmt.setFloat(5, order.getAmount());

            stmt.registerOutParameter(6, Type.LONG);

            stmt.execute();

            id = stmt.getLong(6);

            refresh();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean update(Order customer) {
        return false;
    }

    @Override
    public boolean delete(Order customer) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Iterator<Order> iterator() {
        return data.values().iterator();
    }
}
