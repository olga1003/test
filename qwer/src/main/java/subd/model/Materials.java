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

    public Materials(Integer id, String name, Integer cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "Materials {\n" +
                "id =" + id + ",\n" +
                "name=" + name + ",\n" +
                "cost=" + cost + ",\n" +
                "}" + "\n";
    }
}