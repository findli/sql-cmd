package JSS.w03_pract.model;


import JSS.w03_pract.model.dao.DAO;
import JSS.w03_pract.model.dao.OrderDAO;
import JSS.w03_pract.model.om.Order;

import java.util.List;

public class demo {

    public static void main(String[] args) {
        DAO<Order> orderDAO = new OrderDAO();
        orderDAO.setFilter(() -> " date > '2008-01-01' or qty >10" );   // Unsafe !!!!
        orderDAO.setOrdering(() -> "date desc");

        orderDAO.refresh();

        List<Order> list = orderDAO.getAsList();

        for( Order o : orderDAO ) {
            System.out.println( o.getId() + " \t" + o.getDate() + " \t" + o.getCustomer().getName());
        }

        //Order order = new Order(....);
        //orderDAO.add(order);


    }
}
