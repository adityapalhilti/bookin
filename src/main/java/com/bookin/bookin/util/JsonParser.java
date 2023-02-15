package com.bookin.bookin.util;


import com.bookin.bookin.audit.AuditRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonParser {

    static ObjectMapper mapper = new ObjectMapper();

    public String stringify(AuditRecord audit) throws JsonProcessingException {

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(audit);

    }
    public static AuditRecord parser(String jsonString) throws JsonProcessingException {

        return mapper.readValue(jsonString, AuditRecord.class);

    }
}