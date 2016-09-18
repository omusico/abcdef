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
		double count = (double) (adultNum + childNum / 2) / maxVisitorNum;
		return (int) Math.ceil(count);
	}

	public static void main(String[] args) {
		System.out.println(getMinRoomCount(2, 0, 3));
	}
}
