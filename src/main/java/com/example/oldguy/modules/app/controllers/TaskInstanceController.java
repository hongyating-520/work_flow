package com.example.oldguy.modules.app.controllers;

import com.example.oldguy.common.dto.CommonRsp;
import com.example.oldguy.modules.app.dto.rsp.TaskRsp;
import com.example.oldguy.modules.app.services.TaskInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TaskController
 * @Author: huangrenhao
 * @Description:
 * @CreateTime： 2020/2/11 0011 下午 9:13
 * @Version：
 **/
@Api(tags = "任务实例")
@RestController
@RequestMapping("task")
public class TaskInstanceController {

    static {
        System.out.println("TaskInstanceController 类加载");
    }

    @Autowired
    private TaskInstanceService taskInstanceService;
    @Autowired
    private TaskService taskService;

    @ApiOperation("完成任务")
    @GetMapping("runtime/{taskId}/complete/{approved}")
    public CommonRsp completeTask(@PathVariable String taskId,@PathVariable Boolean approved){
        Map<String, Object> map = new HashMap<>();
        map.put("approved", approved?"Y":"N");//审批结果
        map.put("comment", approved?"同意，审批通过！":"拒绝，让狗审批！");//审批意见
        taskService.complete(taskId,map);
        return CommonRsp.SUCCESS;
    }

    @ApiOperation("获取任务列表")
    @GetMapping("runtime/list")
    public CommonRsp<List<TaskRsp>> getTaskRspList(String assignee) {
        return new CommonRsp<>(taskInstanceService.getTaskList(assignee));
    }

    @ApiOperation("获取指定流程-正在执行任务列表")
    @GetMapping("runtime/{processInstanceId}/list")
    public CommonRsp<List<TaskRsp>> getListByProcessInstanceId(@PathVariable String processInstanceId){
        return new CommonRsp<>(taskInstanceService.getTaskListByProcessInstanceId(processInstanceId));
    }

    @ApiOperation("获取指定流程-历史任务列表")
    @GetMapping("history/{processInstanceId}/list")
    public CommonRsp<List<TaskRsp>> getHistoryListByProcessInstanceId(@PathVariable String processInstanceId){
        return new CommonRsp<>(taskInstanceService.getHistoryListByProcessInstanceId(processInstanceId));
    }

}
