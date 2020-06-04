package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}