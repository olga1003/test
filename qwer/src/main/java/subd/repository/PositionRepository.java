package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}