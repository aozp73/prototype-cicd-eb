package com.portfolio.portfolio_project.core.util.date_utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MongoDate {
    
    public static ZonedDateTime stringToZonedDateTime(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
    
        return localDate.atStartOfDay(ZoneId.of("Asia/Seoul"));
    }
}
