package com.bookin.bookin.audit;

import com.bookin.bookin.dao.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;

@Repository
public class AuditAdd {
    @Autowired
    AuditRepository auditRepository;

    @KafkaListener(topics="topic", groupId="myGroup")
    public void addAudit(AuditRecord audit) {
        auditRepository.save(audit);
    }
}
