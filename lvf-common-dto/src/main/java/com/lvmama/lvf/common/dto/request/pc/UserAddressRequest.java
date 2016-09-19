package com.lvmama.lvf.common.dto.request.pc;



import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

import com.lvmama.lvf.common.dto.vst.UserAddressDto;

public class UserAddressRequest implements Serializable{

	private static final long serialVersionUID = 7351395760087607283L;
	
	private UserAddressDto dto;
	
	public UserAddressRequest() {
		
	}
	
	public UserAddressRequest(String userNo, UserAddressDto dto) {
		super();
		this.dto = dto;
	}	
	public UserAddressDto getDto() {
		return dto;
	}

	public void setDto(UserAddressDto dto) {
		this.dto = dto;
	}


	public int length() {
		return dto.getUserNo().length();
	}

	/*public boolean isEmpty() {
		return dto.getUserNo().isEmpty();
	}
	 */
	
	/*public char charAt(int index) {
		return dto.getUserNo().charAt(index);
	}

	public int codePointAt(int index) {
		return dto.getUserNo().codePointAt(index);
	}

	public int codePointBefore(int index) {
		return dto.getUserNo().codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return dto.getUserNo().codePointCount(beginIndex, endIndex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return dto.getUserNo().offsetByCodePoints(index, codePointOffset);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		dto.getUserNo().getChars(srcBegin, srcEnd, dst, dstBegin);
	}*/

	/*public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
		dto.getUserNo().getBytes(srcBegin, srcEnd, dst, dstBegin);
	}

	public byte[] getBytes(String charsetName)
			throws UnsupportedEncodingException {
		return dto.getUserNo().getBytes(charsetName);
	}

	public byte[] getBytes(Charset charset) {
		return dto.getUserNo().getBytes(charset);
	}

	public byte[] getBytes() {
		return dto.getUserNo().getBytes();
	}*/

	/*public boolean equals(Object anObject) {
		return dto.getUserNo().equals(anObject);
	}

	public boolean contentEquals(StringBuffer sb) {
		return dto.getUserNo().contentEquals(sb);
	}

	public boolean contentEquals(CharSequence cs) {
		return dto.getUserNo().contentEquals(cs);
	}

	public boolean equalsIgnoreCase(String anotherString) {
		return dto.getUserNo().equalsIgnoreCase(anotherString);
	}

	public int compareTo(String anotherString) {
		return dto.getUserNo().compareTo(anotherString);
	}

	public int compareToIgnoreCase(String str) {
		return dto.getUserNo().compareToIgnoreCase(str);
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return dto.getUserNo().regionMatches(toffset, other, ooffset, len);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, String other,
			int ooffset, int len) {
		return dto.getUserNo().regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	public boolean startsWith(String prefix, int toffset) {
		return dto.getUserNo().startsWith(prefix, toffset);
	}

	public boolean startsWith(String prefix) {
		return dto.getUserNo().startsWith(prefix);
	}

	public boolean endsWith(String suffix) {
		return dto.getUserNo().endsWith(suffix);
	}

	public int hashCode() {
		return dto.getUserNo().hashCode();
	}

	public int indexOf(int ch) {
		return dto.getUserNo().indexOf(ch);
	}

	public int indexOf(int ch, int fromIndex) {
		return dto.getUserNo().indexOf(ch, fromIndex);
	}

	public int lastIndexOf(int ch) {
		return dto.getUserNo().lastIndexOf(ch);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		return dto.getUserNo().lastIndexOf(ch, fromIndex);
	}

	public int indexOf(String str) {
		return dto.getUserNo().indexOf(str);
	}

	public int indexOf(String str, int fromIndex) {
		return dto.getUserNo().indexOf(str, fromIndex);
	}

	public int lastIndexOf(String str) {
		return dto.getUserNo().lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return dto.getUserNo().lastIndexOf(str, fromIndex);
	}

	public String substring(int beginIndex) {
		return dto.getUserNo().substring(beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return dto.getUserNo().substring(beginIndex, endIndex);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return dto.getUserNo().subSequence(beginIndex, endIndex);
	}

	public String concat(String str) {
		return dto.getUserNo().concat(str);
	}

	public String replace(char oldChar, char newChar) {
		return dto.getUserNo().replace(oldChar, newChar);
	}

	public boolean matches(String regex) {
		return dto.getUserNo().matches(regex);
	}

	public boolean contains(CharSequence s) {
		return dto.getUserNo().contains(s);
	}

	public String replaceFirst(String regex, String replacement) {
		return dto.getUserNo().replaceFirst(regex, replacement);
	}

	public String replaceAll(String regex, String replacement) {
		return dto.getUserNo().replaceAll(regex, replacement);
	}

	public String replace(CharSequence target, CharSequence replacement) {
		return dto.getUserNo().replace(target, replacement);
	}

	public String[] split(String regex, int limit) {
		return dto.getUserNo().split(regex, limit);
	}

	public String[] split(String regex) {
		return dto.getUserNo().split(regex);
	}

	public String toLowerCase(Locale locale) {
		return dto.getUserNo().toLowerCase(locale);
	}

	public String toLowerCase() {
		return dto.getUserNo().toLowerCase();
	}

	public String toUpperCase(Locale locale) {
		return dto.getUserNo().toUpperCase(locale);
	}

	public String toUpperCase() {
		return dto.getUserNo().toUpperCase();
	}

	public String trim() {
		return dto.getUserNo().trim();
	}

	public String toString() {
		return dto.getUserNo().toString();
	}

	public char[] toCharArray() {
		return dto.getUserNo().toCharArray();
	}

	public String intern() {
		return dto.getUserNo().intern();
	}

	public Long getAddressId() {
		return dto.getAddressId();
	}*/

	public String getUserNo() {
		return dto.getUserNo();
	}

	public String getMobileNumber() {
		return dto.getMobileNumber();
	}

	public String getAreacode() {
		return dto.getAreacode();
	}

	public String getPhoneNumber() {
		return dto.getPhoneNumber();
	}

	public String getUserName() {
		return dto.getUserName();
	}

	public String getProvince() {
		return dto.getProvince();
	}

	public String getCity() {
		return dto.getCity();
	}

	public String getCounty() {
		return dto.getCounty();
	}

	public String getAddress() {
		return dto.getAddress();
	}

	public String getPostCode() {
		return dto.getPostCode();
	}

	public Date getCreateDate() {
		return dto.getCreateDate();
	}

	public Date getUpdateDate() {
		return dto.getUpdateDate();
	}

	public void setAddressId(Long addressId) {
		dto.setAddressId(addressId);
	}

	public void setUserNo(String userNo) {
		dto.setUserNo(userNo);
	}

	public void setMobileNumber(String mobileNumber) {
		dto.setMobileNumber(mobileNumber);
	}

	public void setAreacode(String areacode) {
		dto.setAreacode(areacode);
	}

	public void setPhoneNumber(String phoneNumber) {
		dto.setPhoneNumber(phoneNumber);
	}

	public void setUserName(String userName) {
		dto.setUserName(userName);
	}

	public void setProvince(String province) {
		dto.setProvince(province);
	}

	public void setCity(String city) {
		dto.setCity(city);
	}

	public void setCounty(String county) {
		dto.setCounty(county);
	}

	public void setAddress(String address) {
		dto.setAddress(address);
	}

	public void setPostCode(String postCode) {
		dto.setPostCode(postCode);
	}

	public String getIsValid() {
		return dto.getIsValid();
	}

	public void setIsValid(String isValid) {
		dto.setIsValid(isValid);
	}

	public void setCreateDate(Date createDate) {
		dto.setCreateDate(createDate);
	}

	public void setUpdateDate(Date updateDate) {
		dto.setUpdateDate(updateDate);
	}

	public String getAddressNo() {
		return dto.getAddressNo();
	}

	public void setAddressNo(String addressNo) {
		dto.setAddressNo(addressNo);
	}

	public Long getProvinceId() {
		return dto.getProvinceId();
	}

	public void setProvinceId(Long provinceId) {
		dto.setProvinceId(provinceId);
	}

	public Long getCityId() {
		return dto.getCityId();
	}

	public void setCityId(Long cityId) {
		dto.setCityId(cityId);
	}

	public Long getCountyId() {
		return dto.getCountyId();
	}

	public void setCountyId(Long countyId) {
		dto.setCountyId(countyId);
	}
	
	
	
}
