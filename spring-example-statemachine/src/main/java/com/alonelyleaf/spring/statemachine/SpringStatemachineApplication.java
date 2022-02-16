package com.alonelyleaf.spring.statemachine;

import com.alonelyleaf.spring.statemachine.enums.Events;
import com.alonelyleaf.spring.statemachine.enums.States;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import javax.annotation.Resource;

/**
 * https://www.cnblogs.com/javaadu/p/11832581.html
 *
 * 使用Spring StateMachine的步骤如下：
 * 1.定义状态枚举和事件枚举
 * 2.定义状态机的初始状态和所有状态
 * 3.定义状态之间的转移规则
 * 4.在业务对象中使用状态机，编写响应状态变化的监听器方法
 *
 * 使用Spring StateMachine的好处在于自己无需关心状态机的实现细节，只需要关心业务有什么状态、它们之间的转移规则是什么、每个状态转移后真正要进行的业务操作。
 */
@SpringBootApplication
public class SpringStatemachineApplication implements CommandLineRunner {

    @Resource
    StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(SpringStatemachineApplication.class, args);
    }

    @Override
    public void run(String... args) {
        stateMachine.start();
        stateMachine.sendEvent(Events.ONLINE);
        stateMachine.sendEvent(Events.PUBLISH);
        stateMachine.sendEvent(Events.ROLLBACK);
    }
}
