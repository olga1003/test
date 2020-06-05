package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import subd.model.Orders;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT w FROM Orders w  WHERE w.date BETWEEN :fromDate AND :toDate" )
    List<Orders> getAllByDateBetween(Timestamp fromDate, Timestamp toDate);


}
