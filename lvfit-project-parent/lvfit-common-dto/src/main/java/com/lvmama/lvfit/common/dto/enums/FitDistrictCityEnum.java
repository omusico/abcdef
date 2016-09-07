package com.lvmama.lvfit.common.dto.enums;

/**
 * 频道页站点用城市enum
 * @author lizongze
 *
 */
public enum FitDistrictCityEnum {
    
    SJZ(4L,"石家庄",1L),
    TS(5L,"唐山",1L),
    SAX(15L,"太原",1L),
    NMG(27L,"呼和浩特",1L),
    HLBE(354L,"呼伦贝尔",1L),
    DT(355L,"大同",1L),
    BT(112L,"包头",1L),
    SD(160L,"济南",1L),
    LN(42L,"沈阳",1L),
    DL(43L,"大连",1L),
    CC(57L,"长春",1L),
    HRB(67L,"哈尔滨",1L),
    QQHR(68L,"齐齐哈尔",1L),
    YB(3882L,"延边",1L),
    SX(339L,"西安",1L),
    YC(376L,"银川",1L),
    YL(364L,"榆林",1L),
    TA(159L,"泰安",1L),
    QD(161L,"青岛",1L),
    JYG(365L,"嘉峪关",1L),
    CD(279L,"成都",279L),
    GUZ(300L,"贵阳",279L),
    YN(312L,"昆明",279L),
    XSBN(362L,"西双版纳",279L),
    XGLLX(2210L,"香格里拉",279L),
    LASHA(null,"拉萨",279L),
    JZG(371L,"九寨沟",279L),
    XC(372L,"西昌",279L),
    QH(366L,"西宁",279L),
    XJ(3549L,"乌鲁木齐",279L),
    LZ(351L,"兰州",279L),
    KS(369L,"喀什",279L),
    KNS(370L,"喀纳斯",279L),
    NB(104L,"宁波",82L),
    YANGZHOU(null,"扬州",82L),
    ZHENJIANG(null,"镇江",82L),
    YANCHENG(519L,"盐城",82L),
    AH(119L,"合肥",82L),
    WH(120L,"芜湖",82L),
    HS(127L,"黄山",82L),
    FY(130L,"阜阳",82L),
    HB(199L,"武汉",82L),
    YCH(374L,"宜昌",82L),
    SNJ(367L,"神农架",82L),
    SUZ(87L,"苏州",79L),
    XM(135L,"厦门",79L),
    FZ(136L,"福州",79L),
    WX(83L,"无锡",79L),
    CZ(373L,"常州",79L),
    JIAXING(null,"嘉兴",79L),
    NANTONG(null,"南通",79L),
    SHAOXING(null,"绍兴",79L),
    WZ(107L,"温州",100L),
    JINHUA(null,"金华",100L),
    TAIZHOU(null,"台州",100L),
    JX(146L,"南昌",100L),
    WY(368L,"婺源",100L),
    CS(213L,"长沙",100L),
    ZJJ(221L,"张家界",100L),
    LY(353L,"洛阳",100L),
    JZ(352L,"焦作",100L),
    GANZH(356L,"赣州",229L),
    DG(359L,"东莞",229L),
    QY(360L,"清远",229L),
    NN(252L,"南宁",229L),
    GL(254L,"桂林",229L),
    SY(272L,"三亚",229L),
    HK(358L,"海口",229L),
    ZH(232L,"珠海",229L),
    XG(398L,"香港",231L),
    AM(400L,"澳门",231L),
    BJ(1L,"北京",1L),
    TJ(2L,"天津",2L),
    SH(79L,"上海",79L),
    NJ(82L,"南京",82L),
    HZ(100L,"杭州",100L),
    GZ(229L,"广州",229L),
    SZ(231L,"深圳",231L);
    
    FitDistrictCityEnum(Long destId, String cnName, Long parentDestId){
        this.destId = destId;       
        this.cnName = cnName;
        this.parentDestId = parentDestId;
    }
    
    public static FitDistrictCityEnum getByName(String name) {
        for (FitDistrictCityEnum item : FitDistrictCityEnum.values()) {
            if (item.getCnName().equals(name.trim())) {
                return item;
            }
        }
        return null;
    }

    private Long destId;
    private String cnName;
    private Long parentDestId;
    
    public Long getDestId() {
        return destId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public Long getParentDestId() {
        return parentDestId;
    }

    public void setParentDestId(Long parentDestId) {
        this.parentDestId = parentDestId;
    }
}
