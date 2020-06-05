package subd.crud;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Status;
import subd.repository.StatusRepository;

public class StatusCrud {
    public StatusRepository statusRepository;

    public void createStatus(Integer id , String statuss) {
        Status status = new Status(id, statuss);
        statusRepository.save(status);
    }

    public void readStatus() {
        for ( Status status: statusRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(status);
        }
    }

    public void deleteOrders() {
        statusRepository.deleteById(1);
    }

    public void updateStatus(Integer id , String statuss) {
        Status status = new Status(id, statuss);
        statusRepository.save(status);
    }
}
