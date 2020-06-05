package subd.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer salary;

    @OneToMany
    private List<Worker> worker;

    public Position(Integer id, String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Position {\n" +
                "id =" + id + ",\n" +
                "name=" + name + ",\n" +
                "salary=" + salary + ",\n" +
                "}" + "\n";
    }

    public void Constructor(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
