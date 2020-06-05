package subd.model;

import javax.persistence.*;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer brigadeid;
    private String last_name;
    private String first_name;
    private Integer phone_number;

    @ManyToOne
    private Position position;

    @ManyToOne
    private Brigade brigade;

    public Worker(Integer id, Integer brigadeid, String last_name, String first_name, Integer phone_number) {
        this.id = id;
        this.last_name = last_name;
        this.brigadeid = brigadeid;
        this.first_name = first_name;
        this.phone_number = phone_number;
    }

    @Override
    public String toString(){
        return "Worker {\n" +
                "brigadeid =" + brigadeid + ",\n" +
                "last_name=" + last_name + ",\n" +
                "first_name=" + first_name + ",\n" +
                "phone_number=" + phone_number + ",\n" +
                "}" + "\n";
    }
}
