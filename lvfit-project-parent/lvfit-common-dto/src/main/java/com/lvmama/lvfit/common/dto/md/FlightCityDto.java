package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

/**
 * Created by leizhengwei
 * 2016/8/11
 * 16:05
 */
public class FlightCityDto implements Serializable {

    private static final long serialVersionUID = -3966987676653972673L;
    /**城市名称 */
    private String cityName;

    /**城市全拼音 */
    private String cityAllPinYin;

    /**城市拼音小写缩写 */
    private String cityShortPinYin;

    /**城市三字码 */
    private String cityCode;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityAllPinYin() {
        return cityAllPinYin;
    }

    public void setCityAllPinYin(String cityAllPinYin) {
        this.cityAllPinYin = cityAllPinYin;
    }

    public String getCityShortPinYin() {
        return cityShortPinYin;
    }

    public void setCityShortPinYin(String cityShortPinYin) {
        this.cityShortPinYin = cityShortPinYin;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
