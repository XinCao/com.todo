package com.todo.mapper;

import com.todo.model.Schedule;
import java.util.List;

/**
 *
 * @author caoxin
 */
public interface ScheduleMapper {

    public void insertSchedule(Schedule schedule);

    public void deleteSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public Schedule selectSchedule(Schedule schedule);

    public List<Schedule> selectScheduleList(Schedule schedule);
}