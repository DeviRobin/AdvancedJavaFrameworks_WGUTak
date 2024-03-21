package edu.wgu.d387_sample_code.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TimeConversionController {
    private final TimeConversion timeConversion;

    public TimeConversionController(TimeConversion timeConversion){
        this.timeConversion = timeConversion;
    }
    @GetMapping("/times")
    public ResponseEntity<List<String>> getFormattedTimes(){
        List<String>formattedTimes = timeConversion.convertTime();
        return new ResponseEntity<>(formattedTimes, HttpStatus.OK);
    }
}
