package com.lvmama.lvfit.common.dto.enums;

public enum FlightSegmentType {
	
	INTERNAL("国内","1") {
		@Override
		public boolean isInternational(){
			return false;
		}

		@Override
		public Product getProduct() {
			return Product.I_FLIGHT;
		}
	},
	HMT("港澳台","2") {
		@Override
		public boolean isInternational() {
			return true;
		}

		@Override
		public Product getProduct() {
			return Product.F_FLIGHT;
		}
	},
	FOREIGN("国际","2") {
		@Override
		public boolean isInternational() {
			return true;
		}

		@Override
		public Product getProduct() {
			return Product.F_FLIGHT;
		}
	};
	
	private String cnName;
	private String typeCode;

	private FlightSegmentType(String cnName, String typeCode) {
		this.cnName = cnName;
		this.typeCode = typeCode;
	}

	public String getCnName() {
		return cnName;
	}
	
	public String getTypeCode() {
		return typeCode;
	}



	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}



	public void setCnName(String cnName) {
		this.cnName = cnName;
	}



	public abstract  boolean isInternational();
	public abstract Product getProduct();
	
}
