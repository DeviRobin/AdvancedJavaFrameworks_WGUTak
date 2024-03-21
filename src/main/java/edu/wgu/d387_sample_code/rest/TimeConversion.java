package edu.wgu.d387_sample_code.rest;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Component
public class TimeConversion {

    private ZoneId zEastern = ZoneId.of("America/New_York");
    private ZoneId zMountain = ZoneId.of("Canada/Mountain");
    private ZoneId zUniversal = ZoneId.of("Etc/UTC");

    private ZoneId zoneId = ZoneId.systemDefault();

    private LocalDateTime localDateTime = LocalDateTime.of(2024,03,20,8,30);





    public List<String> convertTime() {
        List<String> formattedTimes = new ArrayList<>();

        ZonedDateTime startTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        formattedTimes.add(String.valueOf(zonedDateTime));
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        formattedTimes.add(formatTime(localDateTimeEastern));
        ZonedDateTime zonedDateTimeMountian=zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountian.toLocalDateTime();
        formattedTimes.add(formatTime(localDateTimeMountain));
        ZonedDateTime zonedDateTimeUniversal=zonedDateTime.withZoneSameInstant(zUniversal);
        LocalDateTime localDateTimeUniversal=zonedDateTimeUniversal.toLocalDateTime();
        formattedTimes.add(formatTime(localDateTimeUniversal));



        return formattedTimes;
    }

  private String formatTime(LocalDateTime localDateTime) {
        return  localDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}