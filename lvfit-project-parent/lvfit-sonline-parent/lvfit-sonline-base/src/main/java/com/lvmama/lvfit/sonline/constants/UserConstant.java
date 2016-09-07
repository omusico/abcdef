package com.lvmama.lvfit.sonline.constants;
/**
 * 参考机票后台.
 * ClassName: UserConstant <br/>
 * date: 2015-12-10 下午7:42:19 <br/>
 *
 * @author liuweiguo
 * @version 
 * @since JDK 1.6
 */
public class UserConstant {
	
	public final static String SESSION_BACK_USER = "SESSION_BACK_USER";
	public static final String LV_SESSION_ID="lvsessionid";
	public final static String DEFAULT_LOCATION = "www";
	
	public static enum LOGIN_TYPE {
		MOBILE("手机"), HTML5("wap");
		private String cnName;

		LOGIN_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (LOGIN_TYPE item : LOGIN_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
	}
}
