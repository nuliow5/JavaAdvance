package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping
    public List<StatisticsDTO> getAllStatistic(){
        return this.statisticsService.getAllStatistics();
    }

//    @GetMapping
//    public List<StatisticsDTO> getAllStatistic(@RequestParam(name ="examName", required = false) String examName){
//        return this.statisticsService.getAllStatistics();
//    }

}
