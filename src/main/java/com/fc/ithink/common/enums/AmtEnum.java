package com.fc.ithink.common.enums;

public enum AmtEnum {


    FIRST_AMT(100, 6),

    SECOND_AMT(101, 72),

    THIRD_AMT(102,298),

    SIX_AMT(105,498),

    FORTH_AMT(103,640),

    FIVE_AMT (104,998);


    /**
     * 响应代码
     */
    private final int code;

    /**
     * 响应消息
     */
    private final int amt;

    AmtEnum(int _code, int _amt) {

        this.code = _code;
        this.amt = _amt;

    }

    public int getCode() {
        return code;
    }

    public int getAmt() {
        return amt;
    }

    /**
     * 通过枚举code获取对应的message
     *
     * @return 取不到时返回null
     */
    public static int getAmtByCode(int code) {
        for (AmtEnum _enum : values()) {
            if (_enum.getCode() == code) {
                return _enum.getAmt();
            }
        }
        return 0;
    }

    /**
     * 通过枚举code获取枚举对象
     *
     * @return 取不到时返回null
     */
    public static AmtEnum getByCode(int code) {
        for (AmtEnum _enum : values()) {
            if (_enum.getCode() == code) {
                return _enum;
            }
        }
        return null;
    }
}
