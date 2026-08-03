package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @Project: sky-take-out
 * @Package: com.sky.task
 * @Author: SUN
 * @Date: 2026/8/2 20:43
 * @Version: v1.0.0
 * @Description: 自定义定时
 **/
@Component
@Slf4j
public class MyTask {
	/**
	 * 定时任务，每隔5秒触发一次
	 */
	//@Scheduled(cron = "0/5 * * * * ?")
	public void executeTask(){
		log.info("定时任务开始执行：{}",new Date());
	}
}
