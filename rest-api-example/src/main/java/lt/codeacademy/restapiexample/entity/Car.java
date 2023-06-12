package lt.codeacademy.restapiexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.restapiexample.enums.Fuel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    private Long id;
    private String name;
    private double engineSizeDisplacement;
    private Fuel fuelType;
    private double weight;
}
