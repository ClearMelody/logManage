package com.log.logmanage.common;

import java.io.Serializable;
import java.util.Date;
/**
 * $DESCRIPTION
 *
 * @author wyk
 * @create 2019-10-16 14:52
 * @describe 日志模板
 */
public class LogModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private String module;
	private String params;
	private String objectValue;
	private String userName;
	private String realName;
	private String orgName;
	private String userIp;
	private String result;
	private Boolean flag;
	private String remark;
	private Integer source;
	private Date recordTime;
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getObjectValue() {
		return objectValue;
	}
	public void setObjectValue(String objectValue) {
		this.objectValue = objectValue;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
