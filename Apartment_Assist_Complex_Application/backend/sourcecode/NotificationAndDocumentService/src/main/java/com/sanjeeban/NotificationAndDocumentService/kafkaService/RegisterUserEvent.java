package com.sanjeeban.NotificationAndDocumentService.kafkaService;


import com.sanjeeban.NotificationAndDocumentService.dto.RegisterUserKafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserEvent {


    @KafkaListener(
            topics = "register-user",
            groupId = "notification-group"
    )
    public void consumeRegisterUserEvent(RegisterUserKafkaMessage event){
        String msg = event.getDataMap().get("Msg1");
        System.out.println("Kafka msg is : "+msg);
        System.out.println("Kafka msg is -------------------------------------------: "+msg);
    }

}
