$(function($) {
	var $resortOverlay = $('.resortOverlay'), $hotelAlert = $('.hotelAlert');
	$('.JS_hotelAlertClose').click(function() {
		$hotelAlert.stop(true, true).fadeOut();
		$resortOverlay.stop(true, true).fadeOut();
		$('body').removeAttr('style');
	});
});

function showAlert(alertIndex, longitude, latitude, hotelName) {
	var $resortOverlay = $('.resortOverlay'),
		$hotelAlert = $('.hotelAlert');
		$('.hotelAlert-tit .yh').html(hotelName);
	$resortOverlay.fadeIn(300);
	$hotelAlert.fadeIn(300);
	$('body').attr('style', 'overflow:none;+overflow:hidden;_overflow:hidden;height=100%;overflow:hidden;+overflow:none;_overflow:none;padding:0 17px 0 0');
	$hotelAlert.on('click', '.hotelAlertTab li', function() {
		var $oLi = $(this),
			$oCon = $oLi.parent().next().children('.hotelAlertCon-li'),
			$index = $oLi.index();
		$oLi.addClass('active').siblings().removeClass('active');
		$oCon.eq($index).show().siblings().hide();
		if ($index == 2) {
			baiduMap(longitude, latitude, hotelName);
		}
	});
	$hotelAlert.find('.hotelAlertTab li').eq(alertIndex).trigger('click');
	alertScroll();
	$('.JS-ufeed-btn').click(function() {
		var $me = $(this),
			$par = $me.parent();
		if ($par.hasClass('showmore')) {
			$me.html('查看详情');
			$par.removeClass('showmore');
		} else {
			$me.html('收起');
			$par.addClass('showmore');
		}
	});
}

function alertScroll() {
	var $oUl = $('.hotelInfo-spic>ul'),
		$oPic = $('.hotelInfo-pic>p'),
		pageIndex = 0,
		len, $oLi, $btn = $('.hotelInfo-Img>.hotelImg-btn');
	$oUl.on("click", "li", function() {
		pageIndex = $(this).index();
		$oLi = $oUl.find("li");
		len = $oLi.length;
		change();
	});
	$btn.click(function() {
		var $type = $(this).index();
		$oLi = $oUl.find("li");
		len = $oLi.length;
		$type > 2 ? pageIndex++ : pageIndex--;
		pageIndex = pageIndex >= len ? 0 : pageIndex;
		pageIndex = pageIndex < 0 ? len - 1 : pageIndex;
		change();
		console.log(pageIndex);
	});

	function change() {
		$oLi.eq(pageIndex).addClass('active').siblings().removeClass('active');
		$oPic.eq(pageIndex).addClass('active').siblings('p').removeClass('active');
		if (len - 4 > 0) {
			if (pageIndex > 2) {
				$oUl.stop(true, true).animate({
					"left": (pageIndex - 2) * -105
				}, 500);
			} else {
				$oUl.stop(true, true).animate({
					"left": 0
				}, 500);
			}
		}
	}
}

function baiduMap(x, y, name) {
	var mapID = document.getElementById('traffic-map');
	var map = new BMap.Map("traffic-map");
	var point = new BMap.Point(x, y);
	var mapThisText = name;
	map.centerAndZoom(point, 14);
	map.enableScrollWheelZoom(true);
	var myDis = new BMapLib.DistanceTool(map);
	var opts = {
		type: BMAP_NAVIGATION_CONTROL_LARGE
	}
	map.addControl(new BMap.NavigationControl(opts));
	var map_ceju = document.createElement("div");
	map_ceju.className = 'map_ceju';
	map_ceju.innerHTML = '测距';
	mapID.appendChild(map_ceju);
	map_ceju.onclick = function() {
		myDis.open();
	}

	function SquareOverlay(center, w, h) {
		this._center = center;
		this._w = w;
		this._h = h;
	}
	SquareOverlay.prototype = new BMap.Overlay();
	SquareOverlay.prototype.initialize = function(map) {
		this._map = map;
		var mapThis = document.createElement("div");
		mapThis.className = 'mapThis';
		mapThis.innerHTML = '<div class="mapNum"></div><p>' + mapThisText + '</p>'
		map.getPanes().markerPane.appendChild(mapThis);
		this._div = mapThis;
		return mapThis;
	}
	SquareOverlay.prototype.draw = function() {
		var position = this._map.pointToOverlayPixel(this._center);
		this._div.style.left = position.x - this._w / 2 + "px";
		this._div.style.top = position.y - this._h + "px";
	}
	var mySquare = new SquareOverlay(map.getCenter(), 26, 32);
	map.addOverlay(mySquare);
};