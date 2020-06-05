package subd.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.*;
import subd.repository.PositionRepository;

import java.util.List;

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
    public PageableItems<Position> findAll(int offset, int count) {
        final Page<Position> page = positionRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }
    public void deleteOrders() {
        positionRepository.deleteById(1);
    }

    public void updatePosition(Integer id , String name, Integer salary) {
        Position position = new Position(id, name, salary);
        positionRepository.save(position);
    }
}
