##### 1.ACT_RE_DEPLOYMENT
这个表是流程部署表，每部署一个流程，这张表中就会新增一条记录，用来描述我们刚刚定义好的流程：
这里的 ID_、NAME_、CATEGORY_ 等等，就是我们在部署流程的时候设置的参数。

##### 2.ACT_RE_PROCDEF
这是流程定义表，我们每定义的一个流程，都会记录在这张表中
DEPLOYMENT_ID 字段，和 ACT_RE_DEPLOYMENT 表进行关联
当我们修改了流程的内容之后，重新部署的时候，ACT_RE_DEPLOYMENT 表和 ACT_RE_PROCDEF 表均会自动增加一条记录数，其中，流程定义表 ACT_RE_PROCDEF 中的记录的 VERSION_ 字段的值会自动加 1，这样我们就能够看到不同历史版本的流程定义。
流程的 id 属性，对应到表中，就是 ACT_RE_PROCDEF 表的 KEY_ 字段。processTest

##### 3.ACT_GE_BYTEARRAY
储存xml文件及对应工作流图片
#### 4.创建工作流实例后：生成对应任务：ACT_RU_TASK
所有操作记录报错在ACT_RU_ACTINST

流程驱动：
    根据bpms定义的class，通过类加载器夹在执行
### 1.定义activiti class
<serviceTask id="sendSeniorRejectEmail" name="发送高级审批拒绝邮件"
    activiti:class="com.chinaums.web.controller.flowable2.delegate.SendSeniorRejectionMailDelegate">
</serviceTask>
### 2.编写JavaDelegate实现自动逻辑（也就是组件对应实现）

![img.png](img.png)




