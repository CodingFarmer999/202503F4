package com.course.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void repeatSecond() {
        logger.info(dateFormat.format(new Date()));
    }
    
    @Scheduled(fixedDelay = 5000)
    public void repeatFixedDelay() {
        logger.info(dateFormat.format(new Date()));
    }
}
