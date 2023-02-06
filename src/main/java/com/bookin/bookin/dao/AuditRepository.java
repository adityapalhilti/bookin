package com.bookin.bookin.dao;

import com.bookin.bookin.audit.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditRecord, Long> {

}
