package subd.model;
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

    @Override
    public String toString(){
        return "Brigade {\n" +
                "id =" + id + ",\n" +
                "name=" + name + ",\n" +
                "}" + "\n";
    }

    public void Constructor(Integer id, String name) {
        this.name = name;
    }
}
