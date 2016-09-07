package com.lvmama.comm.jms;


/**
 * 消息处理接口
 * @author leizhengwei
 *
 */
public interface MessageProcesser {

	void process(Message message);
	
}
