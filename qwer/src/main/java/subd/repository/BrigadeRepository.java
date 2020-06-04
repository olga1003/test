package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import subd.model.Brigade;

public interface BrigadeRepository extends JpaRepository<Brigade, Integer> {
}