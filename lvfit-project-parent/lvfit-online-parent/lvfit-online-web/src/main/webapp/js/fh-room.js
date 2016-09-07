/*
 * File:         fh-room.js
 * Created:      2016-01-01
 * Last Updated: 2016-01-01
 * Author:       liuweiguo
 * Description:  机酒系统酒店房间相关
 */
var fit = fit || {};
/**
 * 酒店房间相关
 */
fit.room = {
	/**
	 * 产品选择页加载可选择房间数
	 */
	loadProductRoomCount : function(adultCount, childCount) {
		var minCount = fit.room.getMinRoomCount(adultCount, childCount);
		var maxCount = adultCount;
		var content = "";
		$(".select-room-list").empty();
		for ( var i = minCount; i <= maxCount; i++) {
			content += ("<li data-num=" + i + ">" + i + "</li>");
		}
		$(".select-room-list").append(content);
	},
	/**
	 * 更换酒店页加载可选择房间数
	 */
	loadChangedHotelRoomCount : function(adultCount, childCount) {
		var minCount = fit.room.getMinRoomCount(adultCount, childCount);
		var maxCount = adultCount;
		var content = "";
		$(".select-div-list").empty();
		for ( var i = minCount; i <= maxCount; i++) {
			content += ("<li data-num=" + i + ">" + i + "</li>");
		}
		$(".select-div-list").append(content);
	},
	/**
	 * 根据成人和儿童数计算最小房间数
	 */
	getMinRoomCount : function(adultNo, childNo) {
		var roomCount = 0;
		if (adultNo == 1) {
			roomCount = 1;
		} else if (adultNo == 2) {
			if (childNo < 2) {
				roomCount = 1;
			} else {
				roomCount = 2;
			}
		} else if (adultNo == 3) {
			if (childNo < 4) {
				roomCount = 2;
			} else {
				roomCount = 3;
			}

		} else if (adultNo == 4) {
			if (childNo <= 2) {
				roomCount = 2;
			} else {
				roomCount = 3;
			}
		} else if (adultNo == 5 || adultNo == 6) {
			roomCount = 3;
		} else if (adultNo == 7 || adultNo == 8) {
			roomCount = 4;
		} else {
			roomCount = 5;
		}
		return roomCount;
	}
}