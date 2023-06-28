package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<StatisticsDTO, Long> {


}
