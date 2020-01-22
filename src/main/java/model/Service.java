package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Service {
    private int id;
    private String name;
    private Double price;
    private String description;
    private int userId;
    private String imagePath;
}
