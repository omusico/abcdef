/*
 * File:         login.js
 * Created:      2016-01-04
 * Last Updated: 2016-01-04
 * Author:       liuweiguo
 * Description:  登录相关
 */
var fit = fit || {};
var basePath=$("#basePath").val();
/**
 * 登录相关
 */
fit.login={
	/**
	 * 登录校验
	 */
	check:function(logined,notlogin){
   	 $.getJSON(
			"http://login.lvmama.com/nsso/ajax/checkLoginStatus.do?jsoncallback=?",
			{},
			 function(data) {
				if (data.success){
					logined();
				} else {
					var url = notlogin();
					if(url){
						loginURL(url);
					}else{
						showLogin();
					}
				}
			}
		);
	}
}

fit.login.booking={
		/**
		 * 登录校验
		 */
		check:function(logined,notlogin){
	   	 $.getJSON(
				"http://login.lvmama.com/nsso/ajax/checkLoginStatus.do?jsoncallback=?",
				{},
				 function(data) {
					if (data.success){
						logined();
					} else {
						showLogin(notlogin);
					}
				}
			);
		}
	}
