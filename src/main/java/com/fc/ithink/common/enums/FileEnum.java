package com.fc.ithink.common.enums;

//图片目录
public enum FileEnum {
    QRCODE("6"),//二维码
    AVATAR("4"),//头像
    LITERATURE("1"),//文学
    PAINTING("2"),//绘画
    POETRY("3"),//诗歌
    LITERCHAPTER("01"),//章节
    POEMSET("03"),//分集
    PAINTINGPART("02"),//分篇
    LITERCONTENT("001"),//文学创作
    PAINTCONTENT("002"),//绘画创作
    POEMCONTENT("003"),//诗歌创作
    DISSUSS("5");//帖子
    private String value;
    FileEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static FileEnum valuesOf(String value) {
        switch (value) {
            case "1":
                return FileEnum.LITERATURE;
            case "2":
                return FileEnum.PAINTING;
            case "3":
                return FileEnum.POETRY;
            case "4":
                return FileEnum.AVATAR;
            case "5":
                return FileEnum.DISSUSS;
            case "6":
                return FileEnum.QRCODE;
            case "01":
                return FileEnum.LITERCHAPTER;
            case "02":
                return FileEnum.PAINTINGPART;
            case "03":
                return FileEnum.POEMSET;
            case "001":
                return FileEnum.LITERCONTENT;
            case "002":
                return FileEnum.PAINTCONTENT;
            case "003":
                return FileEnum.POEMCONTENT;
            default:
                return null;
        }
    }

    public static String valueOfString(String value) {
        switch (value) {
            case "1":
                return "literature";
            case "2":
                return "painting";
            case "3":
                return "poetry";
            case "4":
                return "avat";
            case "5":
                return "disscuss";
            case "6":
                return "qcode";
            case "01":
                return "chapter";
            case "02":
                return "part";
            case "03":
                return "set";
            case "001":
                return "content";
            case "002":
                return "paint";
            case "003":
                return "poem";
            default:
                return null;
        }
    }
}
