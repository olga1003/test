package subd.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Brigade;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;
import subd.model.Worker;
import subd.repository.BrigadeRepository;
import java.util.List;


public class BrigadeCrud {
    public BrigadeRepository brigadeRepository;

    public void createBrigade(Integer id , String name) {
        Brigade brigade = new Brigade(id, name);
        brigadeRepository.save(brigade);
    }

    public void readBrigade() {
        for ( Brigade brigade: brigadeRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(brigade);
        }
    }

    public void deleteOrders() {
        brigadeRepository.deleteById(1);
    }

    public void updateBrigade(Integer id , String name) {
        Brigade brigade = new Brigade(id, name);
        brigadeRepository.save(brigade);
    }
    public PageableItems<Brigade> findAll(int offset, int count) {
        final Page<Brigade> page = brigadeRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }
}
