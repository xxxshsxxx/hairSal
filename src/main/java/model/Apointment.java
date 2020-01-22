package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apointment {
    private int id;
    private String name;
    private String surname;
    private String email;
    private Date date;
    private String time;
    private Date createdDate;
    private String phone;
    private int serviceId;
    private int masterId;
    private String notes;
}
