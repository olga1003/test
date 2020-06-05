package subd.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Materials;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;
import subd.model.Worker;
import subd.repository.WorkerRepository;

import java.util.List;

public class WorkerCrud {
    public WorkerRepository workerRepository;

    public void createWorker(Integer id ,Integer brigadeid , String last_name, String first_name, Integer phone_number) {
        Worker worker = new Worker(id, brigadeid, last_name,first_name,phone_number);
        workerRepository.save(worker);
    }

    public void readWorkers() {
        for ( Worker worker: workerRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(worker);
        }
    }
    public PageableItems<Worker> findAll(int offset, int count) {
        final Page<Worker> page = workerRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }
    public void deleteOrders() {
        workerRepository.deleteById(1);
    }

    public void updateWorker(Integer id ,Integer brigadeid , String last_name, String first_name, Integer phone_number) {
        Worker worker = new Worker(id, brigadeid, last_name,first_name,phone_number);
        workerRepository.save(worker);
    }
}
