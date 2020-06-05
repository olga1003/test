package subd.crud;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Orders;
import subd.repository.OrdersRepository;

import java.sql.Timestamp;

public class OrdersCrud {
    private OrdersRepository ordersRepository;

    public void createOrders(Integer id, String name, Integer cost, Timestamp date) {
        Orders orders = new Orders(id, name, cost, date);
        ordersRepository.save(orders);
    }

    public void readOrders() {
        for (Orders orders : ordersRepository.findAll(PageRequest.of(0, 3, Sort.unsorted())).toList()) {
            System.out.println(orders);
        }
    }

    public void deleteOrders() {
        ordersRepository.deleteById(1);
    }

    public void updateOrders(Integer id, String name, Integer cost, Timestamp date) {
        {
            Orders orders = new Orders(id, name, cost, date);
            ordersRepository.save(orders);
        }
    }
}
