package com.log.logmanage.consumer;

import com.log.logmanage.common.LogQueue;
import com.log.logmanage.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * $DESCRIPTION
 *
 * @author wyk
 * @create 2019-10-16 14:52
 * @describe 从MQ队列消费日志数据
 */
@Component
public class LogConsumer {

	private static final Logger logger = LoggerFactory.getLogger(LogConsumer.class);

	@Autowired
	private LogService logService;

	/**
	 * 处理消息
	 * 
	 * @param log
	 */
	@RabbitListener(queues = LogQueue.LOG_QUEUE) // 监听队列
	public void logHandler(Message log) {
		try {
			String data=new String(log.getBody(),"UTF-8");
			logService.save(data);
		} catch (Exception e) {
			logger.error("保存日志失败，日志：{}，异常：{}", log, e);
		}

	}
}
