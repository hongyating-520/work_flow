package com.example.oldguy.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/*
 * @author ZZQ
 * @Date 2023/1/5 10:31 上午
 */
public class SendMsgDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("执行发送邮件任务。。。。。");
    }
}
