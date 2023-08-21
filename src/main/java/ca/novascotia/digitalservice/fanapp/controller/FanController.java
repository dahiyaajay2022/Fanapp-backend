package ca.novascotia.digitalservice.fanapp.controller;

import ca.novascotia.digitalservice.fanapp.modal.dto.Fan;
import ca.novascotia.digitalservice.fanapp.services.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fan")
public class FanController {

    private final FanService fanService;

    @Autowired
    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to FanApp!";
    }

    @PostMapping("/pullSpeedCord")
    public ResponseEntity<Fan> pullSpeedCord() {
        Fan fan = fanService.pullSpeedCord();
        return new ResponseEntity<>(fan, HttpStatus.OK);
    }

    @PostMapping("/pullDirectionCord")
    public ResponseEntity<Fan> pullDirectionCord() {
        Fan fan = fanService.pullDirectionCord();
        return new ResponseEntity<>(fan, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Fan> getFanStatus() {
        Fan fan = fanService.getFanStatus();
        return new ResponseEntity<>(fan, HttpStatus.OK);
    }

    @GetMapping
    public List<Fan> getAllFans() {
        return fanService.getAllFans();
    }
}





