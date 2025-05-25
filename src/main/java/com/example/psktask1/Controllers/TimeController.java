package com.example.psktask1.Controllers;

import com.example.psktask1.Services.TimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/timer")
@RequiredArgsConstructor
public class TimeController {

    private final TimerService timerService;

    @PostMapping("/start")
    public ResponseEntity<Map<String, String>> startCalculation() {
        if (!timerService.isRunning()) {
            timerService.startTimer();
            return ResponseEntity.ok(Map.of(
                    "status", "started",
                    "message", "Calculation started"
            ));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "status", "already_running",
                "message", "Calculation is already in progress"
        ));
    }

    @GetMapping("/initial-status")
    public ResponseEntity<Map<String, Object>> getInitialStatus() {
        return ResponseEntity.ok(Map.of(
                "isRunning", timerService.isRunning(),
                "isDone", timerService.isDone(),
                "result", timerService.getResult()
        ));
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getResult() {
        if (timerService.isDone()) {
            return ResponseEntity.ok(Map.of(
                    "status", "done",
                    "result", timerService.getResult()
            ));
        }
        return ResponseEntity.ok(Map.of(
                "status", timerService.isRunning() ? "running" : "not_started"
        ));
    }
}
