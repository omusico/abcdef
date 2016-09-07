package com.lvmama.comm.jms;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.collections.CollectionUtils;

/**
 * Vst产品队列消息消费者
 * @author leizhengwei
 *
 */
public class MessageConsumer {

	private List<MessageProcesser> processers = new ArrayList<MessageProcesser>();

	private String destName;

	public void receive(Message m) {
		
		if(CollectionUtils.isNotEmpty(this.getProcessers())){
			for (MessageProcesser processer : processers) {
				processer.process(m);
			}
		}
		
	}

	public List<MessageProcesser> getProcessers() {
		return processers;
	}

	public void setProcessers(List<MessageProcesser> processers) {
		this.processers = processers;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	

}
