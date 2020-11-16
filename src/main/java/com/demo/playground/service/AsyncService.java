package com.demo.playground.service;

import com.demo.playground.tasks.ReadTask;
import com.demo.playground.config.FileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AsyncService {

    private TaskExecutor taskExecutor;

    @Autowired
    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void execAsync(ReadTask readTask) {
        taskExecutor.execute(readTask);
    }

    @Async
    public void checkFiles() {
        File[] fileList = new File(FileConfig.INPUT_DIR).listFiles();
        assert fileList != null;
        for(File eachFile: fileList) {
            ReadTask readTask = applicationContext.getBean(ReadTask.class);
            readTask.setFile(eachFile);
            execAsync(readTask);
        }
    }
}
