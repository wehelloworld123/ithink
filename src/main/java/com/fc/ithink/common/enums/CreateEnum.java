package com.fc.ithink.common.enums;

import java.io.Serializable;

public enum CreateEnum implements Serializable {
    HISTORY("1"), LITERATURE("2"), THINKING("3"), GAME("4"), ROMANTIC("5"), PSYCHOLOGY("6"),
    PHOTO("01"), INK("02"), OIL("03"), GOUACHE("04"), LANDSCAPE("05"), SKETCH("06"),
    POEM("001"), BRAND("002"),INCLUDED("00");//自由创作
    private final String value;

    CreateEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
   public static CreateEnum valueof(String value) {
        switch (value) {
            case "00":
                return CreateEnum.INCLUDED;
            case "1":
                return CreateEnum.HISTORY;
            case "2":
                return CreateEnum.LITERATURE;
            case "3":
                return CreateEnum.THINKING;
            case "4":
                return CreateEnum.GAME;
            case "5":
                return CreateEnum.ROMANTIC;
            case "6":
                return CreateEnum.PSYCHOLOGY;
            case "01":
                return CreateEnum.PHOTO;
            case "02":
                return CreateEnum.INK;
            case "03":
                return CreateEnum.OIL;
            case "04":
                return CreateEnum.GOUACHE;
            case "05":
                return CreateEnum.LANDSCAPE;
            case "06":
                return CreateEnum.SKETCH;
            case "001":
                return CreateEnum.POEM;
            case "002":
                return CreateEnum.BRAND;
            default:
                return null;
        }
    }

    public static String valueOfName(String value) {
        switch (value) {
            case "00":
                return "自由创作";
            case "1":
                return "历史";
            case "2":
                return "文学";
            case "3":
                return "思想";
            case "4":
                return "游戏";
            case "5":
                return "言情";
            case "6":
                return "心理";
            case "01":
                return "摄影";
            case "02":
                return "水墨";
            case "03":
                return "油墨";
            case "04":
                return "水粉";
            case "05":
                return "山水";
            case "06":
                return "素描";
            case "001":
                return "诗";
            case "002":
                return "词";
            default:
                return null;
        }
    }
}
