package com.log.logmanage.service;

import java.util.Map;

import com.log.logmanage.common.LogModel;
import com.log.logmanage.common.Page;

public interface LogService {

	/**
	 * 保存日志
	 *
	 * @param log
	 */
	void save(String logJson);

	/**
	 * 查询日志
	 * @param params
	 * @return
	 */
	Page<LogModel> findLogs(Map<String, Object> params);
}
