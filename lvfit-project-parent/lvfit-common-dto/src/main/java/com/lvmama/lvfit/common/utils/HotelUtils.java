package com.lvmama.lvfit.common.utils;
/**
 * @author lutianyu
 * @date   2016年1月3日
 */
public class HotelUtils {
	/**
	 * 根据成人，儿童数获取最小房间数
	 *
	 * @param adultNum
	 * @param childNum
	 * @return
	 */
	public static int getMinRoomCount(int adultNum, int childNum, int maxVisitorNum) {
		int count = (adultNum + childNum / 2) / maxVisitorNum;
		return count == 0 ? 1 : count;
	}
}
