package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Materials;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Integer> {

}