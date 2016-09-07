package com.lvmama.lvf.common.convert;


public interface Converter {
	public <S,T> T to(S s,Class<T> t,String prefix) throws Exception;
	public <S,T> String toXml(S s,String t,String prefix) throws Exception;
	public <S,T> T to(S s,Class<T> t) throws Exception;
	public <S,T> String toXml(S s,String t) throws Exception;
	
}
