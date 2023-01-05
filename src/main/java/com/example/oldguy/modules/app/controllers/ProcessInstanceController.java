package com.example.oldguy.modules.app.controllers;

import com.example.oldguy.common.dto.CommonRsp;
import com.example.oldguy.modules.app.dto.rsp.ProcessInstanceRsp;
import com.example.oldguy.modules.app.services.ProcessInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *流程实例 ProcessInstance通过流程定义启动的一个流程，他表示一个流程从开始到结束的最大的流程分支，
 * 在一个流程中，只存在一个流程实例，流程实例和流程定义的关系就类似于 Java 对象和 Java 类之间的关系。
 **/
@Api(tags = "流程实例管理")
@RestController
@RequestMapping("/processInstance")
public class ProcessInstanceController {

    @Autowired
    private ProcessInstanceService processInstanceService;

    @ApiOperation("获取当前正在执行的流程实例列表")
    @GetMapping("/runtime/list")
    public CommonRsp<List<ProcessInstanceRsp>> getRuntimeProcessInstanceList(){
        return new CommonRsp<>(processInstanceService.getRuntimeProcessInstanceList());
    }

    /**
     * select * from ACT_RE_PROCDEF where KEY_ = 'custom_process'
     * @param key 对应ACT_RE_PROCDEF的key
     * @return
     */
    @ApiOperation("创建创建流程实例")
    @PostMapping("/crate")
    public CommonRsp<ProcessInstance> crateProcessInstance(String key){
        return new CommonRsp<>(processInstanceService.startProcessInstance(key));
    }
}
