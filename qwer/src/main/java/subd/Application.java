package subd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.crud.*;
import subd.model.*;
import subd.repository.*;

import java.sql.Timestamp;
import java.text.ParseException;

@SpringBootApplication
public class Application {
    private BrigadeRepository brigadeRepository;
    private CustomersRepository customersRepository;
    private MaterialsRepository materialsRepository;
    private OrdersRepository ordersRepository;
    private PositionRepository positionRepository;
    private StatusRepository statusRepository;
    private WorkerRepository workerRepository;
    private BrigadeCrud brigadeCrud;
    private CustomersCrud customersCrud;
    private MaterialsCrud materialsCrud;
    private OrdersCrud ordersCrud;
    private PositionCrud positionCrud;
    private StatusCrud statusCrud;
    private WorkerCrud workerCrud;

    @Autowired
    public Application(BrigadeRepository brigadeRepository,
                       OrdersRepository ordersRepository,
                       CustomersRepository customersRepository,
                       StatusRepository statusRepository,
                       PositionRepository positionRepository,
                       MaterialsRepository materialsRepository,
                       WorkerRepository workerRepository){
        this.brigadeRepository = brigadeRepository;
        this.ordersRepository = ordersRepository;
        this.customersRepository = customersRepository;
        this.positionRepository = positionRepository;
        this.materialsRepository = materialsRepository;
        this.workerRepository = workerRepository;
        this.statusRepository = statusRepository;
    }

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() throws ParseException {
        workerCrud.createWorker(5, 2,"Иванов","Иван", 88888);

        workerCrud.readWorkers();

        customersCrud.createCustomers(21, "Артем","Артемович", 333111);
        customersCrud.createCustomers(21, "Петр","Петров", 33333);
        customersCrud.createCustomers(31, "Сидр","Сидоров", 111111);


        materialsCrud.createMaterials(32, "Дерево", 334);
        materialsCrud.createMaterials(3, "Гвозди", 300);

        materialsCrud.readMaterials();

        ordersCrud.createOrders(7, "Ремонт",1000000 ,new Timestamp(1583214200000L));

        System.out.println(ordersRepository.getAllByDateBetween(new Timestamp(1539547200000L), new Timestamp(System.currentTimeMillis())));

        }
}
