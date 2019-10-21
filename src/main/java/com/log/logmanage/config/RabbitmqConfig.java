package com.log.logmanage.config;

import com.log.logmanage.common.LogQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * $DESCRIPTION
 *
 * @author wyk
 * @create 2019-10-16 14:52
 * @describe 消息队列MQ配置相关
 */
@Configuration
public class RabbitmqConfig {

	/**
	 * 声明队列
	 * 
	 * @return
	 */
	@Bean
	public Queue logQueue() {
		Queue queue = new Queue(LogQueue.LOG_QUEUE);
		return queue;
	}
}
