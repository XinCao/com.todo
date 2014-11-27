package com.xincao.todo_mvn.controller;

import com.xincao.todo_mvn.service.TaskService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 任务界面
 *
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 待办任务
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/wait_to_be_done_task", method = RequestMethod.GET)
    public String showWaitToBeDoneTaskAction(Map<String, Object> map) {
        return "task/wait_to_be_done_task";
    }

    /**
     * 收集箱
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/collection_task", method = RequestMethod.GET)
    public String showCollectionAction(Map<String, Object> map) {
        return "task/collection_task";
    }

    /**
     * 过期任务
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/expired_task", method = RequestMethod.GET)
    public String showExpiredTaskAction(Map<String, Object> map) {
        return "task/expired_task";
    }

    /**
     * 接受到的任务
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/received_task", method = RequestMethod.GET)
    public String showReceivedTaskAction(Map<String, Object> map) {
        return "task/received_task";
    }

    /**
     * 发送的任务
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/sent_task", method = RequestMethod.GET)
    public String showSentTaskAction(Map<String, Object> map) {
        return "task/sent_task";
    }

    /**
     * 完成的任务
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/finish_task", method = RequestMethod.GET)
    public String showFinishTaskAction(Map<String, Object> map) {
        return "task/finish_task";
    }
}