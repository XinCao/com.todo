package com.todo.service;

import com.todo.mapper.ScheduleMapper;
import com.todo.model.Schedule;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class ScheduleService {

    private ScheduleMapper scheduleMapper;

    public void addSchedule(Schedule schedule) {
        if (schedule == null) {
            return;
        }
        this.scheduleMapper.insertSchedule(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        if (schedule == null) {
            return;
        }
        this.scheduleMapper.deleteSchedule(schedule);
    }

    public void updateSchedule(Schedule schedule) {
        if (schedule == null) {
            return;
        }
        this.scheduleMapper.updateSchedule(schedule);
    }

    public List<Schedule> getSchedules(Schedule schedule) {
        if (schedule == null) {
            return null;
        }
        return this.scheduleMapper.selectScheduleList(schedule);
    }

    public Schedule getSchedule(Schedule schedule) {
        if (schedule == null) {
            return null;
        }
        return this.scheduleMapper.selectSchedule(schedule);
    }
}