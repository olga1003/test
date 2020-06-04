package subd.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer cost;
    private Date dataFrom;
    private Date dataTo;
    private Timestamp date;


    @OneToMany
    private List<Materials> materials;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Brigade brigade;

    @ManyToOne
    private Customers customers;

    public String toString() {
        return "Orders {\n" +
                "id =" + id + ",\n" +
                "name=" + name + ",\n" +
                "cost=" + cost + ",\n" +
                "dataFrom = " + date + "\n" +
                "}" + "\n";
    }

    public void Constructor(Integer id, String name, Integer cost,Timestamp date) {
        this.name = name;
        this.cost = cost;
        this.date = date;
    }
}
