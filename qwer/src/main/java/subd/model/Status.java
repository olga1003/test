package subd.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String status;

    @OneToMany
    private List<Orders> orders;

    public Status(Integer id, String statuss) {
        this.id = id;
        this.status = statuss;
    }

    public String toString() {
        return "Status {\n" +
                "id =" + id + ",\n" +
                "status=" + status + ",\n" +
                "}" + "\n";
    }
}
