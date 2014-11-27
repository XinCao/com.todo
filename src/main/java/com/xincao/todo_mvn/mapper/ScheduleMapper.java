package com.xincao.todo_mvn.mapper;

import com.xincao.todo_mvn.model.Schedule;
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