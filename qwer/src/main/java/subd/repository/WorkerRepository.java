package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import subd.model.Worker;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    @Query("SELECT w FROM Worker w  WHERE w.brigadeid IN ( SELECT b.id FROM Brigade b WHERE b.name = 'Lavr' )")
    public List<Worker> getBrigadeName();
}
