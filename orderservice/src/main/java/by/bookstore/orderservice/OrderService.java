package by.bookstore.orderservice;
import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    Order deleteOrder(Order order);
    Order deleteOrderById(int id);
    Order updateBookInOrder(long book, int id);
    Order updateStatusInOrder(long status, int id);
    Order updateAddressInOrder(String address, int id);
    Order updateStoreInOrder(long store, int id);
    List<Order> findAll();
    List<Order> findAllById(int id);
    List<Order> findAllByStatus(long status);
    List<Order> findAllByStore(long store);
    List<Order> findAllByAddress(String address);
    List<Order> findAllByUser(long user);

}
