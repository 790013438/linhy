package com.xy.ssm.common;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author wuchen
 *
 * ajax 请求的返回类型封装JSON结果
 * 
 * 主要用于bootstrap table
 */
public class BootStrapTableResult<T> implements Serializable {

	private static final long serialVersionUID = -4185151304730685014L;

	private List<T> data;
	private int count;

	public BootStrapTableResult(List<T> data) {
		super();
		this.data = data;
	}

	public BootStrapTableResult(List<T> data , int count) {
		super();
		this.data = data;
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

