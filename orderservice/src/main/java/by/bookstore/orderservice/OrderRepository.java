package by.bookstore.orderservice;

import java.util.List;

public interface OrderRepository {

    Order addOrder(Order order);

    Order deleteOrder(Order order);

    Order deleteOrderById(int id);

    Order updateBook(long book, int id);

    Order updateStatus(long status, int id);

    Order updateAddress(String address, int id);

    Order updateStore(long store, int id);

    List<Order> findAllOrders();

    List<Order> findAllById(int id);

    List<Order> findAllByStatus(long status);

    List<Order> findAllByStore(long store);

    List<Order> findAllByAddress(String address);

    List<Order> findAllByUser(long user);

}
