package lt.gerasimovas.rentCars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.gerasimovas.rentCars.enumes.CarClass;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDTO {
    private Long id;
    private CarClass carClass;
    private String brand;
    private String number;
    private Integer seats;
    private Integer doors;
    private Boolean airConditioner;
    private BigDecimal costPerDay;
}
