package subd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.*;
import subd.repository.*;

import java.sql.Timestamp;
import java.text.ParseException;

@SpringBootApplication
public class app {
    private BrigadeRepository brigadeRepository;
    private CustomersRepository customersRepository;
    private MaterialsRepository materialsRepository;
    private OrdersRepository ordersRepository;
    private PositionRepository positionRepository;
    private StatusRepository statusRepository;
    private WorkerRepository workerRepository;

    @Autowired
    public app(BrigadeRepository brigadeRepository,
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

        SpringApplication.run(app.class,args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() throws ParseException {
        createWorker(5, 2,"Иванов","Иван", 88888);
     //   readWorkers();
        createCustomers(21, "Артем","Артемович", 333111);
        createCustomers(21, "Петр","Петров", 33333);
        createCustomers(31, "Сидр","Сидоров", 111111);
      //  readCustomers();
        createBrigade(11, "Qwer");
        createBrigade(2, "Lavr");

        readBrigade();
        createMaterials(32, "Дерево", 334);
        createMaterials(3, "Гвозди", 300);

        readMaterials();
        createPosition(4, "Инженер",22000);
        createPosition(34, "Бригадир",23000);
        readPosition();
        createOrders(7, "Ремонт",1000000 ,new Timestamp(1583214200000L));
 //       readOrders();
        createStatus(5, "Готово");
        createStatus(15, "Выполняяется");
        readStatus();
        System.out.println(customersRepository.getCustomersLastName());
        System.out.println("/////////////////////////");
        System.out.println(workerRepository.getBrigadeName());
        System.out.println("/////////////////////////");
        System.out.println(ordersRepository.getAllByDateBetween(new Timestamp(1539547200000L), new Timestamp(System.currentTimeMillis())));

        }


    private void createCustomers(Integer id , String last_name, String first_name, Integer phone_number) {
        Customers customers = new Customers();
        customers.Constructor(id,last_name,first_name,phone_number);
        customersRepository.save(customers);
    }

    private void readCustomers() {
        for ( Customers customers: customersRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(customers);
        }
    }

    private void createWorker(Integer id ,Integer brigadeid , String last_name, String first_name, Integer phone_number) {
        Worker worker = new Worker();
        worker.Constructor(id, brigadeid, last_name,first_name,phone_number);
        workerRepository.save(worker);
    }

    private void readWorkers() {
        for ( Worker worker: workerRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(worker);
        }
    }
    private void createBrigade(Integer id , String name) {
        Brigade brigade = new Brigade();
        brigade.Constructor(id, name);
        brigadeRepository.save(brigade);
    }

    private void readBrigade() {
        for ( Brigade brigade: brigadeRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(brigade);
        }
    }
    private void createMaterials(Integer id , String name, Integer cost) {
        Materials materials = new Materials();
        materials.Constructor(id, name, cost);
        materialsRepository.save(materials);
    }
    private void readMaterials() {
        for ( Materials materials:materialsRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(materials);
        }
    }
    private void createPosition(Integer id , String name, Integer salary) {
        Position position = new Position();
        position.Constructor(id, name, salary);
        positionRepository.save(position);
    }
    private void readPosition() {
        for ( Position position:positionRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(position);
        }
    }
    private void createOrders(Integer id , String name, Integer cost,  Timestamp date) {
        Orders orders = new Orders();
        orders.Constructor(id, name, cost, date);
        ordersRepository.save(orders);
    }
    private void readOrders() {
        for ( Orders orders:ordersRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(orders);
        }
    }
    private void createStatus(Integer id , String statuss) {
        Status status = new Status();
        status.Constructor(id, statuss);
        statusRepository.save(status);
    }

    private void readStatus() {
        for ( Status status: statusRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(status);
        }
    }
}
