package lt.gerasimovas.rentCars.mappers;

import lt.gerasimovas.rentCars.dto.CarDTO;
import lt.gerasimovas.rentCars.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {
    public static Car dtoToCar(CarDTO carDTO) {
        Car car = null;
        if (carDTO != null) {
            car = new Car();
            car.setId(carDTO.getId());
            car.setCarClass(carDTO.getCarClass());
            car.setBrand(carDTO.getBrand());
            car.setNumber(carDTO.getNumber());
            car.setSeats(carDTO.getSeats());
            car.setDoors(carDTO.getDoors());
            car.setAirConditioner(carDTO.getAirConditioner());
            car.setCostPerDay(carDTO.getCostPerDay());
        }
        return car;
    }


    public static CarDTO carToDTO(Car car) {
        CarDTO carDTO = null;
        if (car != null) {
            carDTO = new CarDTO(
                    car.getId(),
                    car.getCarClass(),
                    car.getBrand(),
                    car.getNumber(),
                    car.getSeats(),
                    car.getDoors(),
                    car.getAirConditioner(),
                    car.getCostPerDay()
            );
        }
        return carDTO;
    }

    public static List<CarDTO> carsToDTOList(List<Car> cars) {
        List<CarDTO> carDTOList = null;
        if (cars != null && !cars.isEmpty()){
            carDTOList = new ArrayList<>();
            for (Car car : cars){
                carDTOList.add(carToDTO(car));
            }
        }
        return carDTOList;
    }

}
