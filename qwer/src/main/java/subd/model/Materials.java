package subd.model;

import javax.persistence.*;

@Entity
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer cost;

    @ManyToOne
    private Orders orders;

    @Override
    public String toString(){
        return "Materials {\n" +
                "id =" + id + ",\n" +
                "name=" + name + ",\n" +
                "cost=" + cost + ",\n" +
                "}" + "\n";
    }

    public void Constructor(Integer id, String name, Integer cost) {
        this.name = name;
        this.cost = cost;

    }
}