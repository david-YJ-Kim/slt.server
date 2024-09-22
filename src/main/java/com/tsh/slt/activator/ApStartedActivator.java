package com.tsh.slt.activator;

import com.tsh.slt.data.ApSharedVariable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ApStartedActivator implements ApplicationRunner {

    @Autowired
    private Environment env;


//    @Autowired
//    BatchInvokeScheduler batchInvokeScheduler;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        this.initializeSharedVariables();

        this.initializeApService();

        log.info("Complete Initialization.");
    }


    /**
     * AP Common 영역 초기화
     */
    private void initializeSharedVariables(){

        // Shared Variable 초기화
        ApSharedVariable.createInstance(env);
    }

    /**
     * AP 서비스 영역 초기화
     */
    private void initializeApService(){

//        ScheduledExecutorService mainThread =  ApSharedVariable.getInstance().getApExecutorService();
//        batchInvokeScheduler.startSchedule(mainThread, TimeUnit.SECONDS, 30L);
    }
}
