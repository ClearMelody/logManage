package com.log.logmanage.common;

import java.io.Serializable;
import java.util.List;


/**
 * 分页对象
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = -275582248840137389L;
	private int total;
	private List<T> data;

	public Page(int total, List<T> data) {
		this.total = total;
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
