package project.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
@Data
@Getter
public class DeviceRequestNoRent {
    private long id;
    private String name;
    private String description;
    private int cost;
    private Date expirationDate;
}
