package subd.model;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String name;

    @OneToMany
    private List<Worker> worker;
    @OneToMany
    private List<Orders> orders;

    public Brigade(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Brigade {\n" +
                "id =" + id + ",\n" +
                "name=" + name + ",\n" +
                "}" + "\n";
    }
}
