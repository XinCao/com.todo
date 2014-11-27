package com.xincao.todo_mvn.service;

import com.xincao.todo_mvn.mapper.ScheduleMapper;
import com.xincao.todo_mvn.model.Schedule;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);
    private ScheduleMapper scheduleMapper;

    public void addSchedule(Schedule schedule) {
        if (schedule == null) {
            logger.warn("param is NULL");
            return;
        }
        this.scheduleMapper.insertSchedule(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        if (schedule == null) {
            logger.warn("param is NULL");
            return;
        }
        this.scheduleMapper.deleteSchedule(schedule);
    }

    public void updateSchedule(Schedule schedule) {
        if (schedule == null) {
            logger.warn("param is NULL");
            return;
        }
        this.scheduleMapper.updateSchedule(schedule);
    }

    public List<Schedule> getSchedules(Schedule schedule) {
        if (schedule == null) {
            logger.warn("param is NULL");
            return null;
        }
        return this.scheduleMapper.selectScheduleList(schedule);
    }

    public Schedule getSchedule(Schedule schedule) {
        if (schedule == null) {
            logger.warn("param is NULL");
            return null;
        }
        return this.scheduleMapper.selectSchedule(schedule);
    }

}