package com.xincao.todo_mvn.controller;

import com.xincao.todo_mvn.model.Schedule;
import com.xincao.todo_mvn.service.ScheduleService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 日程界面
 * 
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * 创建日程表单
     * 
     * @return 
     */
    @RequestMapping(value = "/create_form_schedule", method = RequestMethod.GET)
    public String createFormScheduleAction() {
        return "schedule/create_form_schedule";
    }

    /**
     * 创建日程
     * 
     * @param schedule
     * @return 
     */
    @RequestMapping(value = "/do_create_schedule", method = RequestMethod.GET)
    public String doCreateScheduleAction(@ModelAttribute Schedule schedule) {
        return "";
    }

    /**
     * 日程列表（默认为当前天）
     * 
     * @param date
     * @param map
     * @return 
     */
    @RequestMapping(value = "/daily_schedule_list/{date}", method = RequestMethod.GET)
    public String dailyScheduleListAction(@PathVariable(value = "date") String date, Map<String, Object> map) {
        return "schedule/daily_schedule_list";
    }
}