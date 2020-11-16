package com.demo.playground;

import com.demo.playground.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    private AsyncService asyncService;

    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @Scheduled(fixedRate = 60 * 1000) // per minute
    public void checkFiles() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Date now: " + strDate);
        asyncService.checkFiles();
    }
}
