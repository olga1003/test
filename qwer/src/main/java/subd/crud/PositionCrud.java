package subd.crud;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Position;
import subd.repository.PositionRepository;

public class PositionCrud {
    public PositionRepository positionRepository;

    public void createPosition(Integer id , String name, Integer salary) {
        Position position = new Position(id, name, salary);
        positionRepository.save(position);
    }
    public void readPosition() {
        for ( Position position:positionRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(position);
        }
    }

    public void deleteOrders() {
        positionRepository.deleteById(1);
    }

    public void updatePosition(Integer id , String name, Integer salary) {
        Position position = new Position(id, name, salary);
        positionRepository.save(position);
    }
}
