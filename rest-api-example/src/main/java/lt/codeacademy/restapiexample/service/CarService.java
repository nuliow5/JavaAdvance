package lt.codeacademy.restapiexample.service;

import lt.codeacademy.restapiexample.entity.Car;
import lt.codeacademy.restapiexample.entity.Fuel;
import lt.codeacademy.restapiexample.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public List<Car> simulate(){
        cars.add(new Car(1L, "Acura", 2000.0, Fuel.Diesel, 2500.0));
        cars.add(new Car(2L, "Porsche", 4500.0, Fuel.Ethanol, 2000.0));
        cars.add(new Car(3L, "Mclaren", 3000.0, Fuel.Bio_diesel, 2500.0));
        cars.add(new Car(4L, "VWPassat", 2000.0, Fuel.Gasoline, 1800.0));

        return this.cars;
    }

    public List<Car> getAllCars() {
        if (this.cars.isEmpty()) {
            simulate();
        }

        return this.cars;
    }

    public Car getCarById(long id){
        return
                this.cars.stream()
                        .filter(car -> car.getId().equals(id))
                        .findFirst().orElseThrow();

    }

    public Car addCar(Car car){
        this.cars.add(car);
        return car;
    }

    public Car deleteCartById(long id){
        Car deleteCar =
                this.cars.stream()
                        .filter(car -> car.getId().equals(id))
                        .findFirst().orElseThrow();

        cars.remove(deleteCar);

        return deleteCar;
    }

    public List<Car> updateCarById(long id, Car car) {
        Car updateCar = getCarById(id);
        updateCar.setName(car.getName());
        updateCar.setEngineSizeDisplacement(car.getEngineSizeDisplacement());
        updateCar.setFuelType(car.getFuelType());
        updateCar.setWeight(car.getWeight());

        return cars;
    }

    public List<Car> patchCarById(long id, Car car){
        Car carByReplace = getCarById(id);
        if (car.getId() != null){
            carByReplace.setId(car.getId());
        }

        if (car.getName() != null){
            carByReplace.setName(car.getName());
        }

        if (car.getEngineSizeDisplacement() != 0){
            carByReplace.setEngineSizeDisplacement(car.getEngineSizeDisplacement());
        }

        if (car.getFuelType() != null){
            carByReplace.setFuelType(car.getFuelType());
        }

        if (car.getWeight() != 0){
            carByReplace.setWeight(car.getWeight());
        }

        int indexOfStudent = this.cars.indexOf(carByReplace);
        this.cars.set(indexOfStudent, carByReplace);
        return this.cars;

    }




}
