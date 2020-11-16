package com.demo.playground;

import com.demo.playground.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Scheduler {

    private AsyncService asyncService;

    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @Scheduled(fixedRate = 60 * 1000) // per minute
    public void checkFiles() {
        System.out.println("ReadTasks have been triggered on: " +  Calendar.getInstance().getTime());
        asyncService.checkFiles();
    }
}
