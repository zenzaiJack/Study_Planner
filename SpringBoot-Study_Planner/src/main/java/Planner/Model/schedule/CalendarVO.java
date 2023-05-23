package Planner.Model.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CalendarVO {
    private Long event_id;
    private String title;
    private String subject;
    private String member_id;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean allDay;
}
