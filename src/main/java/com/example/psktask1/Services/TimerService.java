package com.example.psktask1.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimerService {

    private CompletableFuture<Integer> counter = new CompletableFuture<>();
    private boolean isRunning = false;

    public void startTimer() {
        isRunning = true;
        counter = CompletableFuture.supplyAsync(() -> {
            try {
                log.info("started");
                Thread.sleep(10000);
                log.info("stopped");
                return 10;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                isRunning = false;
            }
        });
    }

    public boolean isDone() {
        return counter != null && counter.isDone();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getResult() {
        if(counter.isDone()) {
            return counter.join();
        } else{
            return 0;
        }
    }
}

