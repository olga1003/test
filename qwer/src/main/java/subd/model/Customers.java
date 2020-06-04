package subd.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String last_name;
    private String first_name;
    private Integer phone_number;

    @OneToMany
    private List<Orders> orders;

    @Override
    public String toString(){
        return "Customers {\n" +
                "id =" + id + ",\n" +
                "last_name=" + last_name + ",\n" +
                "first_name=" + first_name + ",\n" +
                "phone_number=" + phone_number + ",\n" +
                "}" + "\n";
    }
    public void Constructor(Integer id, String last_name, String first_name, Integer phone_number) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone_number = phone_number;
    }
}
