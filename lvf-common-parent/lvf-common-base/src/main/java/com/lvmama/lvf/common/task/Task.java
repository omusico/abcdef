package com.lvmama.lvf.common.task;

public interface Task<T> {
	
	T execute(TaskContext context);
	
}
