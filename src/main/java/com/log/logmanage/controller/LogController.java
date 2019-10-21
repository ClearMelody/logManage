package com.log.logmanage.controller;


import com.log.logmanage.common.LogModel;
import com.log.logmanage.common.Page;
import com.log.logmanage.service.LogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
/**
 * $DESCRIPTION
 *
 * @author wyk
 * @create 2019-10-16 14:52
 * @describe 日志访问查询相关接口
 */
@Api(value = "wyk")
@ApiModel(value = "日志管理中心API接口")
@RestController
class LogController {

	@Autowired
	private LogService logService;

	/**
	 * 对外日志记录API接口
	 * @param logJson
	 */
	@PostMapping("/api-logs/save")
	@ApiOperation(value = "日志记录API接口",httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(paramType = "body", name = "logJson", required = true, value = "日志json")
	public void save(@RequestBody String logJson) {
		logService.save(logJson);
	}

	/**
	 * 日志查询
	 * 
	 * @param params
	 * @return
	 */
	@GetMapping("/api-logs/query")
	@ApiOperation(value = "日志查询API接口",httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType="query", name = "params", value = "参数集合", required = false, dataType = "Map"),
			@ApiImplicitParam(paramType="query", name = "authorization", value = "权限校验key值", required = true, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "start", value = "页码（从0开始）", required = true, dataType = "int"),
			@ApiImplicitParam(paramType="query", name = "length", value = "分页大小", required = true, dataType = "int"),
			@ApiImplicitParam(paramType="query", name = "module", value = "模块名称", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "userName", value = "用户名", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "realName", value = "用户姓名", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "orgName", value = "组织机构", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "objectValue", value = "查询对象值", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "source", value = "数据源", required = false, dataType = "int"),
			@ApiImplicitParam(paramType="query", name = "flag", value = "方法是否执行成功(1/0,true/false)", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "stime", value = "开始时间", required = false, dataType = "String"),
			@ApiImplicitParam(paramType="query", name = "etime", value = "结束时间", required = false, dataType = "String")
	})
	public Page<LogModel> findLogs(@RequestParam Map<String, Object> params) {
		return logService.findLogs(params);
	}

}
