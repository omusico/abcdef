package com.lvmama.lvf.common.dto.enums;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.audit.AuditOpDto;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketCTMTRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketIssueRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketRTVTRequest;
import com.lvmama.lvf.common.dto.status.OpType;
import com.lvmama.lvf.common.utils.JSONMapper;

public enum AuditType {

	ORDER_BOOKING("订单预订", OpType.NULL) {
		@Override
		public AuditOpDto<?> convert(String request) {
			return null;
		}

	},
	TICKET_RTVT("退废票", OpType.RTVT) {
		@Override
		public AuditOpDto<FlightOrderTicketRTVTRequest> convert(String request) throws JsonParseException, JsonMappingException, IOException {
			return JSONMapper.getInstance().readValue(request, new TypeReference<AuditOpDto<FlightOrderTicketRTVTRequest>>() {});
		}
	},
	TICKET_CTMT("改期改签", OpType.CTMT) {
		@Override
		public AuditOpDto<FlightOrderTicketCTMTRequest> convert(String request) throws JsonParseException, JsonMappingException, IOException {
			return JSONMapper.getInstance().readValue(request, new TypeReference<AuditOpDto<FlightOrderTicketCTMTRequest>>() {});
		}
	},
	TICKET_ISSUE("人工出票", OpType.ISSUE) {
		@Override
		public AuditOpDto<FlightOrderTicketIssueRequest> convert(String request) throws JsonParseException, JsonMappingException, IOException {
			return JSONMapper.getInstance().readValue(request, new TypeReference<AuditOpDto<FlightOrderTicketIssueRequest>>() {});
		}
	};
	
	private String cnName;
	
	private OpType opType;

	public String getCnName() {
		return cnName;
	}
	
	public OpType getOpType() {
		return opType;
	}

	private AuditType(String cnName, OpType opType) {
		this.cnName = cnName;
		this.opType = opType;
	}
	
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public void setOpType(OpType opType) {
		this.opType = opType;
	}

	public abstract AuditOpDto<? extends BaseAuditRequest> convert(String request) throws JsonParseException, JsonMappingException, IOException;
	
}
