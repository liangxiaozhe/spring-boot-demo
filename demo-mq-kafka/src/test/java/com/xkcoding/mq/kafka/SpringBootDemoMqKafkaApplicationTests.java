package com.xkcoding.mq.kafka;

import com.xkcoding.mq.kafka.config.KafkaConfig;
import com.xkcoding.mq.kafka.constants.KafkaConsts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaConfig.class)
public class SpringBootDemoMqKafkaApplicationTests {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 测试发送消息
     */
    @Test
    public void testSend() {
        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello,kafka..." + i);
            kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello,kafka..." + i);
        }
    }

    /**
     * 指定partition发送
     */
    @Test
    public void testSend1() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("test2", 0, "10087", "hello,顺序消息" + i);
        }
    }

}

