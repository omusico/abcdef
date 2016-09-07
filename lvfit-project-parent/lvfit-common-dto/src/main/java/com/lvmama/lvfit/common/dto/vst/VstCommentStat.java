package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.text.DecimalFormat;

public class VstCommentStat implements Serializable{
	
	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1355166607310193584L;
	/**
	 * 目的地Id(包含邮轮id)
	 */
	private Long placeId;
	/**
	 * 产品ID
	 */
	private Long productId;
	/**
	 * 点评数
	 */
	private Long commentCount = 0L;
	/**
	 * 平均分
	 */
	private Float avgScore = 0F;
	
	private String FormatAvgScore;
	/**
	 * 0分点评数
	 */
	//private Integer zeroScoreCount = 0;
	/**
	 * 1分点评数
	 */
	//private Integer oneScoreCount = 0;
	/**
	 * 2分点评数
	 */
	//private Integer twoScoreCount = 0;
	/**
	 * 3分点评数
	 */
	//private Integer threeScoreCount = 0;
	/**
	 * 4分点评数
	 */
	//private Integer fourScoreCount = 0;
	/**
	 * 5分点评数
	 */
	//private Integer fiveScoreCount = 0;
	/**
	 * 目的地类型
	 */
	//private String placeType;
	/**
	 * 品类类型
	 */
	//private String vstType;
	/**
	 * 目的地名称或产品名称
	 */
	//private String titleName;
	/**
	 * vst产品品类
	 */
	//private String productCategory;
	/**
	 * 平台类型VST,SUPER
	 */
	//private String platform;
	/**
	 * placeId存的是目的地id还是产品id或者邮轮id(PRODUCT/PLACE)
	 */
	//private String placeIdType;
	/**
	 * POI/产品的 第一张图
	 */
	//private String picUrl;
	/**
	 * 产品链接
	 */
	//private String productUrl;

	/**
	 * 四舍五入获取平均分
	 * @return int
	 */
	public int getIntegerOfAvgScore() {
		return Integer.parseInt(Math.round(this.getAvgScore()) + "");
	}
	/**
	 * 获取分数计算规则之后的好评率
	 * @return the avgScore
	 * */
	public String getFormatAvgScore(){
		DecimalFormat df = new DecimalFormat("####.0");
		float f = (float)(((avgScore+5.0)/10)*100);
		int avg = (int)f;
		String formatAvgScore = df.format(f);
		if(avg-f==0){
			formatAvgScore = String.valueOf(avg);
		}
		return formatAvgScore;
	}
	/**
	 * 获取平均分的区间值
	 * @return float
	 */
	public String getRoundHalfUpOfAvgScore() {
		float avg = getAvgScore();
		String value = "0";
		if (avg == 0) {
			value = "0";
		} else if (avg > 0 && avg <= 0.5) {
			value = "05";
		} else if (avg > 0.5 && avg <= 1) {
			value = "1";
		} else if (avg > 1 && avg <= 1.5) {
			value = "15";
		} else if (avg > 1.5 && avg <= 2) {
			value = "2";
		} else if (avg > 2 && avg <= 2.5) {
			value = "25";
		} else if (avg > 2.5 && avg <= 3) {
			value = "3";
		} else if (avg > 3 && avg <= 3.5) {
			value = "35";
		} else if (avg > 3.5 && avg <= 4) {
			value = "4";
		} else if (avg > 4 && avg <= 4.5) {
			value = "45";
		} else if (avg > 4.5 && avg <= 5) {
			value = "5";
		}
		return value;
	}
	
	
	public Float getAvgScorePercent() {
		return avgScore * 20;
	}
	
	public String getAvgScoreStr() {
		return avgScore.toString();
	}
	
	
	
	/**
	 *  ----------------------  get and set property -------------------------------
	 */
	public void setPlaceId(final Long placeId) {
		this.placeId = placeId;
	}
	public void setCommentCount(final Long commentCount) {
		this.commentCount = commentCount;
	}
	public void setAvgScore(final Float avgScore) {
		this.avgScore = avgScore;
	}
	
	
	public Long getPlaceId() {
		return placeId;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public Float getAvgScore() {
		return avgScore;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductId() {
		return productId;
	}
	public void setFormatAvgScore(String formatAvgScore) {
		FormatAvgScore = formatAvgScore;
	}
   
}
