package project.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
@Data
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date expirationDate;

    @Column
    private int cost;

    public Device(){}

    public Device(String name, String description, int cost, Date date)
    {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.expirationDate = date;
    }

}
