package subd.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.*;
import subd.repository.StatusRepository;

import java.util.List;

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
    public PageableItems<Status> findAll(int offset, int count) {
        final Page<Status> page = statusRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }
    public void updateStatus(Integer id , String statuss) {
        Status status = new Status(id, statuss);
        statusRepository.save(status);
    }
}
