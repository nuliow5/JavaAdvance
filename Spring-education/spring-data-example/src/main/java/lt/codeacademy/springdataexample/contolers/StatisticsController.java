package lt.codeacademy.springdataexample.contolers;

import lombok.Getter;
import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping
    public List<StatisticsDTO> getAllStatistic() {
        return this.statisticsService.getAllStatistics();
    }

//    @GetMapping
//    public List<StatisticsDTO> getAllStatistic(@RequestParam(name ="examName", required = false) String examName){
//        return this.statisticsService.getAllStatistics();
//    }


//    @GetMapping("/{examTitle}")
//    public StatisticsDTO getStatisticDTOByExamTitle(@PathVariable String examTitle) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(statisticsService.getStatisticDTOByExamTitle(examTitle)).getBody();
//
//        } catch (NoSuchElementException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    String.format("Exam by title: %s not found", examTitle));
//        }
//
//    }

}
