package lt.codeacademy.restapiexample.controlers;

import lt.codeacademy.restapiexample.entities.Car;
import lt.codeacademy.restapiexample.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        return this.carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable(name ="id") long id){
        return this.carService.getCarById(id);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return this.carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public Car deleteCarById(@PathVariable long id){
        return this.carService.deleteCartById(id);
    }

    @PutMapping("/{id}")
    public List<Car> updateCarById(@PathVariable long id, @RequestBody Car car){
        return this.carService.updateCarById(id, car);
    }

    @PatchMapping("/{id}")
    public List<Car> patchCarById(@PathVariable long id, @RequestBody Car car){
        return this.carService.patchCarById(id, car);
    }



}
