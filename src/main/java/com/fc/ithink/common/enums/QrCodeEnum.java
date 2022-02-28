package com.fc.ithink.common.enums;

public enum QrCodeEnum {
    BOOKURL("001"),
    LOGINAPPLY("002");

    private final String value;

    QrCodeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static QrCodeEnum value(String value) {
        switch (value) {
            case "001":
                return QrCodeEnum.BOOKURL;
            case "002":
                return QrCodeEnum.LOGINAPPLY;
            default:
                return null;
        }
    }


}
