package lt.gerasimovas.rentCars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
   private Long id;
    private String name;
    private String surName;
    private String address;
    private String mail;
}
