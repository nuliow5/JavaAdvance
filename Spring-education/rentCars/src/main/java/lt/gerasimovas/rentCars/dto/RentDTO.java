package lt.gerasimovas.rentCars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentDTO {
    private Long id;
    private Long carId;
    private Long customerId;
    private LocalDate leased_from;
    private LocalDate leased_until;
}
