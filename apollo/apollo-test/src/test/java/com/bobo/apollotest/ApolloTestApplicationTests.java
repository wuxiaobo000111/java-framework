package com.bobo.apollotest;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApolloTestApplicationTests {

    private Logger logger = LoggerFactory.getLogger(ApolloTestApplicationTests.class);
    @Test
    public void contextLoads() {
        Config config = ConfigService.getConfig("TEST2.Hermes.Producer");
        Integer defaultSenderBatchSize = 200;
        Integer senderBatchSize = config.getIntProperty("sender.batchsize", defaultSenderBatchSize);
        System.out.println(senderBatchSize);
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                if ( changeEvent.isChanged("sender.batchsize ")) {
                    logger.info("sender.batchsize changed");
                }
            }
        });
    }

}

