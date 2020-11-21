package newprojectspring.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
