package com.demo.playground.tasks;

import com.demo.playground.config.FileConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Calendar;


@Component
@Scope("prototype")
public class ReadTask extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadTask.class);

    private File file;

    public void setFile(File file) { this.file = file; }

    @Override
    public void run() {
        LOGGER.info("ReadTask has started for file {}. Time: {}", file.getName(), Calendar.getInstance().getTime());
        File directory = new File(FileConfig.OUTPUT_DIR);

        if(!directory.exists()) directory.mkdir();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line; int sum = 0;

            while((line = bufferedReader.readLine()) != null)
                sum += Integer.parseInt(line);

            FileWriter fileWriter = new FileWriter(new File(FileConfig.OUTPUT_DIR + "/" + file.getName()));
            fileWriter.write(sum + "");
            fileWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
