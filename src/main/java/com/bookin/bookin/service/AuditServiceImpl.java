package com.bookin.bookin.service;
import com.bookin.bookin.audit.AuditRecord;
import com.bookin.bookin.audit.AuditAdd;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService{


    @Autowired
    AuditAdd auditAdd;

    ObjectMapper mapper = new ObjectMapper();
    @KafkaListener(topics="topic", groupId="myGroup")
    public void consume(String message) throws JsonProcessingException {
        auditAdd.addAudit(mapper.readValue(message, AuditRecord.class));
    }

}