package com.lvmama.lvfit.common.utils;
/**
 * @author lutianyu
 * @date   2016年1月3日
 */
public class HotelUtils {
	/**
	 * 根据成人，儿童数获取最小房间数
	 * @param adultNum
	 * @param childNum
	 * @return
	 */
	public static int getMinRoomCount(int adultNum, int childNum){
		int roomCount = 0;
		if (adultNum == 1) {
			roomCount = 1;
		} else if (adultNum == 2) {
			if (childNum < 2) {
				roomCount = 1;
			} else {
				roomCount = 2;
			}
		} else if (adultNum == 3) {
			if (childNum < 4) {
				roomCount = 2;
			} else {
				roomCount = 3;
			}

		} else if (adultNum == 4) {
			if (childNum <= 2) {
				roomCount = 2;
			} else {
				roomCount = 3;
			}
		} else if (adultNum == 5 || adultNum == 6) {
			roomCount = 3;
		} else if (adultNum == 7 || adultNum == 8) {
			roomCount = 4;
		} else {
			roomCount = 5;
		}
		return roomCount;
	}
}
