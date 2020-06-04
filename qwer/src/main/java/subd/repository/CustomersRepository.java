package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import subd.model.Customers;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    @Query("SELECT w FROM Customers w  ORDER BY w.last_name DESC" )
    public List<Customers> getCustomersLastName();

}