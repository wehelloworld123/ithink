package com.fc.ithink.util;

import com.fc.ithink.common.conf.V2Config;
import com.fc.ithink.common.file.FileUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.security.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.commons.codec.binary.Base64;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.util.Map;

@Slf4j
public class PdfUtil {

    final static String templatePath = PdfUtil.class.getResource("/").getPath()+"static/file/20201122.docx";

    public static final String KEYSTORE = PdfUtil.class.getResource("/").getPath()+"static/file/user.pfx";

    public static final char[] PASSWORD = "W1j2y3x4y5".toCharArray();//keystory密码

    public static final String SRC = PdfUtil.class.getResource("/").getPath()+"static/file/491542797531353088.pdf";

    public static final String DEST = PdfUtil.class.getResource("/").getPath()+"static/file/";

    final static String certificatePath = PdfUtil.class.getResource("/").getPath()+"static/file/20201122.docx";

    /*public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", "TLITER528448471062155264");
        map.put("no", new TextRenderData("000000", "TLITER528448471062155264"));
        map.put("name", new TextRenderData("000000", "我是你的一面镜子"));
        map.put("copyright", new TextRenderData("000000", "20"));
        map.put("reward", new TextRenderData("000000", "3000"));
        map.put("date", new TextRenderData("000000", DateUtils.dateTimeNow("yyyy/MM/dd")));

        map.put("data", "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+PCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj48c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgdmVyc2lvbj0iMS4xIiB3aWR0aD0iNTA4IiBoZWlnaHQ9IjE0OSI+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDE4IDE2IGMgMC4xOCAwIDcuMTkgLTAuNDMgMTAgMCBjIDEuMDEgMC4xNiAxLjk2IDEuODQgMyAyIGMgNC42MiAwLjczIDExLjEgMS41MiAxNiAxIGMgMy44NiAtMC40MSA3Ljg1IC0yLjkxIDEyIC00IGMgOC43NiAtMi4zIDI2IC02IDI2IC02Ii8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDU1IDEgYyAwLjA1IDAuMDUgMi41NCAxLjgyIDMgMyBjIDMuMTUgOC4xNSA3LjYgMTguODMgOSAyOCBjIDEuNDcgOS42NiAwLjc4IDI2LjMyIDAgMzEgYyAtMC4xMyAwLjc3IC01IC0xIC01IC0xIi8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDU2IDI3IGMgLTAuMTIgMC4xNiAtNC40MSA2LjU4IC03IDkgYyAtMi4xNCAyIC01LjQ5IDMuMTIgLTggNSBjIC0yLjgyIDIuMTIgLTUuMDkgNC45NiAtOCA3IGMgLTkuNDkgNi42NyAtMjkgMTkgLTI5IDE5Ii8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDczIDMyIGMgMC4xOCAwIDcuMTYgLTAuNzUgMTAgMCBjIDIuOTIgMC43NyA2LjI1IDMuMDYgOSA1IGMgMi44MyAyIDUuNDcgNS42NCA4IDcgYyAxLjE5IDAuNjQgMy42MSAtMC40NiA1IDAgYyAyLjIzIDAuNzQgNyA0IDcgNCIvPjxwYXRoIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIiBzdHJva2U9InJnYigzMywgMzcsIDQxKSIgZmlsbD0ibm9uZSIgZD0iTSA0OCA2OSBjIDAuOTggMCA0OS43NiAtMC45OCA1NiAwIGMgMS4wNSAwLjE2IC0yLjg0IDYuMzggLTUgOCBjIC0zLjc5IDIuODQgLTEwLjU0IDQuNDIgLTE1IDcgYyAtMS41MiAwLjg4IC0yLjU2IDIuODggLTQgNCBjIC0xLjQ5IDEuMTYgLTMuMzEgMi4zMiAtNSAzIGMgLTEuNDggMC41OSAtMy44NCAwLjM0IC01IDEgYyAtMC44MiAwLjQ3IC0xLjg4IDIuMDYgLTIgMyBjIC0wLjE3IDEuMzMgMC4zNSAzLjcgMSA1IGMgMC41NCAxLjA4IDIuMjIgMS44OSAzIDMgYyAxLjQ4IDIuMTIgMi4zOCA1LjA4IDQgNyBjIDEuODYgMi4xOSA1LjUgMy45NCA3IDYgYyAwLjgzIDEuMTQgMC40NSAzLjU0IDEgNSBjIDAuMzkgMS4wMyAxLjkgMS45OCAyIDMgYyAwLjQ5IDUuMSAwLjY0IDEzLjcyIDAgMTggYyAtMC4xMyAwLjg2IC0yLjA1IDEuODkgLTMgMiBsIC02IC0xIi8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDEgMTE2IGMgMC4xNCAtMC4wNyA1LjMzIC0zLjI2IDggLTQgYyAzIC0wLjgzIDYuNjkgLTAuMzQgMTAgLTEgYyAxMC4xNCAtMi4wMyAxOS44NSAtNS4yOCAzMCAtNyBjIDcuNjEgLTEuMjkgMTUuMTUgLTEuNjcgMjMgLTIgYyA4LjUgLTAuMzUgMTYuODYgMC44MyAyNSAwIGMgNy45OCAtMC44MSAxNi4wMiAtNC4xNyAyNCAtNSBjIDcuODEgLTAuODEgMTYuMTMgMC43NyAyNCAwIGMgOS4wMSAtMC44OCAxOC4wNSAtMi45MyAyNyAtNSBjIDQuMTIgLTAuOTUgOC4xIC0zLjIyIDEyIC00IGMgMi40NiAtMC40OSA1LjY4IDAuNTggOCAwIGMgMi41OSAtMC42NSA1LjQyIC0zLjMxIDggLTQgYyAyLjAyIC0wLjU0IDQuOTUgMC4zNyA3IDAgbCA0IC0yIi8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDIyMCA0MCBjIDAuMDcgMC4wMiAyLjggMC40NSA0IDEgYyAyLjM0IDEuMDcgNS41MiAyLjUyIDcgNCBjIDAuNzYgMC43NiAwLjMzIDIuOTUgMSA0IGMgMi4wOSAzLjI1IDYuMzQgNi44OSA4IDEwIGMgMC42NSAxLjIxIC0wLjU1IDMuOSAwIDUgbCA0IDMiLz48cGF0aCBzdHJva2UtbGluZWpvaW49InJvdW5kIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS13aWR0aD0iMiIgc3Ryb2tlPSJyZ2IoMzMsIDM3LCA0MSkiIGZpbGw9Im5vbmUiIGQ9Ik0gMjY5IDI1IGMgMC41MyAwIDIwLjE4IC0wLjY1IDMwIDAgYyA1LjAxIDAuMzMgOS45MiAyLjM4IDE1IDMgYyA1Ljk4IDAuNzIgMTIgMC40OCAxOCAxIGMgMS43IDAuMTUgMy41NCAwLjQ1IDUgMSBjIDEuMDMgMC4zOSAyLjc3IDEuMTYgMyAyIGMgMC41NyAyLjA5IDAuOTQgNi42NiAwIDkgYyAtMS40MSAzLjU0IC01LjEgNy4zOCAtOCAxMSBjIC0zLjkzIDQuOTEgLTcuNjQgOS44MSAtMTIgMTQgYyAtNC4yMSA0LjA1IC0xNCAxMSAtMTQgMTEiLz48cGF0aCBzdHJva2UtbGluZWpvaW49InJvdW5kIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS13aWR0aD0iMiIgc3Ryb2tlPSJyZ2IoMzMsIDM3LCA0MSkiIGZpbGw9Im5vbmUiIGQ9Ik0gMjc1IDU4IGMgMC4wNSAtMC4wNSAxLjg0IC0yLjY5IDMgLTMgYyA4LjY2IC0yLjI5IDMxIC02IDMxIC02Ii8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDI3MiA3NSBjIDAuMTkgLTAuMDUgNy4zNyAtMi42NCAxMSAtMyBjIDYuMDYgLTAuNjEgMTIuNzcgMC4yNiAxOSAwIGMgMS42NyAtMC4wNyA1IC0xIDUgLTEiLz48cGF0aCBzdHJva2UtbGluZWpvaW49InJvdW5kIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS13aWR0aD0iMiIgc3Ryb2tlPSJyZ2IoMzMsIDM3LCA0MSkiIGZpbGw9Im5vbmUiIGQ9Ik0gMjQyIDk3IGMgMCAwLjIzIDAuNTIgOC44NyAwIDEzIGMgLTAuNDUgMy42MiAtMi4zNyA3LjQgLTMgMTEgYyAtMC4zMyAxLjg5IC0wLjM3IDQuMzMgMCA2IGMgMC4yMiAxIDEuMTkgMi45NSAyIDMgYyAzLjQxIDAuMiAxMC41MiAtMC43OCAxNSAtMiBjIDIuMzkgLTAuNjUgNyAtNCA3IC00Ii8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDI1OCAxMDYgYyAtMC4wNyAwLjAyIC0yLjg4IDAuMzkgLTQgMSBjIC0yLjMzIDEuMjcgLTcgNSAtNyA1Ii8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDI4OCA5NiBjIDAuMDcgMC4wNSAzLjcyIDEuOCA0IDMgYyAwLjc5IDMuMzYgLTAuNDcgMTAuMDQgMCAxNCBjIDAuMTIgMS4wMiAxLjg0IDEuOTkgMiAzIGMgMC40MyAyLjgxIC0wLjQyIDcuMDUgMCAxMCBjIDAuMTkgMS4zMiAxLjE2IDMgMiA0IGMgMC42NyAwLjgxIDEuOTggMS45MyAzIDIgYyA3LjA5IDAuNTEgMTcuMDkgMC42OCAyNSAwIGMgMy4zIC0wLjI4IDcuMDIgLTEuNzIgMTAgLTMgYyAxLjQzIC0wLjYxIDMuMiAtMS44OSA0IC0zIGwgMSAtNCIvPjxwYXRoIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIiBzdHJva2U9InJnYigzMywgMzcsIDQxKSIgZmlsbD0ibm9uZSIgZD0iTSAzMTUgOTcgYyAtMC4xOSAwLjI2IC03LjIyIDEwLjQ3IC0xMSAxNSBjIC0xLjAyIDEuMjIgLTQgMyAtNCAzIi8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDM5MiA1NiBjIDAuMDcgMC4wMiAzLjA4IDAuMzkgNCAxIGMgMC44IDAuNTQgMS42NiAxLjkzIDIgMyBjIDEuNTUgNC45IDMuMDkgMTAuNzYgNCAxNiBjIDAuMzkgMi4yMyAwIDcgMCA3Ii8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDQxMyAzNyBjIDAuMDkgMCAzLjc3IC0wLjQ2IDUgMCBjIDEuMDQgMC4zOSAyLjE4IDEuODggMyAzIGMgMi44IDMuODEgNS45NiA3LjkxIDggMTIgYyAxLjQ4IDIuOTYgMi4zOSA2Ljc0IDMgMTAgYyAwLjM1IDEuODcgMC4yNyA0LjA4IDAgNiBjIC0wLjM4IDIuNjMgLTEuMDIgNS41NSAtMiA4IGMgLTAuOTYgMi4zOSAtNCA3IC00IDciLz48cGF0aCBzdHJva2UtbGluZWpvaW49InJvdW5kIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS13aWR0aD0iMiIgc3Ryb2tlPSJyZ2IoMzMsIDM3LCA0MSkiIGZpbGw9Im5vbmUiIGQ9Ik0gNDEwIDY4IGMgMC4wNCAtMC4wNSAxLjIgLTIuNDYgMiAtMyBjIDAuOTIgLTAuNjEgMi45NiAtMC40MSA0IC0xIGMgMS4wNyAtMC42MSAzIC0zIDMgLTMiLz48cGF0aCBzdHJva2UtbGluZWpvaW49InJvdW5kIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS13aWR0aD0iMiIgc3Ryb2tlPSJyZ2IoMzMsIDM3LCA0MSkiIGZpbGw9Im5vbmUiIGQ9Ik0gNDA2IDc4IGMgMC4zIC0wLjA3IDExLjgxIC0yLjQ0IDE3IC00IGMgMS4wNyAtMC4zMiAyIC0xLjc4IDMgLTIgYyAxLjY3IC0wLjM3IDQuMzMgMC4zNyA2IDAgbCAzIC0yIi8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDQ1MiAyMCBjIDAuMDcgMC4xMiAzLjcyIDQuNjYgNCA3IGMgMC45MSA3LjU0IDAuNCAxNy4yMyAwIDI2IGMgLTAuMjggNi4xMSAtMC4zOCAxMi4zNyAtMiAxOCBjIC0zLjkxIDEzLjU2IC05LjI4IDI4LjM4IC0xNSA0MSBjIC0xLjk2IDQuMzQgLTYuMyA3Ljg1IC05IDEyIGMgLTEuNjEgMi40NyAtMi4zOCA1LjU3IC00IDggYyAtMi4zMiAzLjQ4IC01LjEyIDYuOTMgLTggMTAgYyAtMi4wOCAyLjIxIC03IDYgLTcgNiIvPjxwYXRoIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIiBzdHJva2U9InJnYigzMywgMzcsIDQxKSIgZmlsbD0ibm9uZSIgZD0iTSA0NjAgMTggYyAwLjA5IDAgMy4zOCAwLjI2IDUgMCBjIDYuNjEgLTEuMDYgMTMuOTUgLTIuNDIgMjAgLTQgYyAxLjA3IC0wLjI4IDIgLTEuNzggMyAtMiBjIDEuNjcgLTAuMzcgNC40IC0wLjQ4IDYgMCBjIDEuMzMgMC40IDIuOTkgMS44NSA0IDMgYyAxLjE4IDEuMzUgMi4zOSAzLjMxIDMgNSBjIDAuNjQgMS43NiAwLjQyIDQuMTIgMSA2IGMgMC43MiAyLjM1IDIuOTIgNC42OCAzIDcgYyAwLjg0IDIzLjQ2IC0wLjU4IDUyLjgyIDAgNzcgYyAwLjA1IDEuOTkgMS44NSA0LjAyIDIgNiBjIDAuNDkgNi41OCAwLjY0IDE0LjM2IDAgMjEgYyAtMC4zMiAzLjMgLTEuMzcgOC4zNyAtMyAxMCBjIC0xLjI2IDEuMjYgLTYuNDEgMS44NSAtOCAxIGMgLTEuODYgLTEgLTMuMTEgLTUuNzQgLTUgLTggYyAtMS4yOCAtMS41NCAtMy4yMiAtMi45IC01IC00IGwgLTggLTQiLz48cGF0aCBzdHJva2UtbGluZWpvaW49InJvdW5kIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS13aWR0aD0iMiIgc3Ryb2tlPSJyZ2IoMzMsIDM3LCA0MSkiIGZpbGw9Im5vbmUiIGQ9Ik0gNDY3IDcwIGMgMC4zIDAgMTEuNzkgLTAuNDcgMTcgMCBjIDEuNjUgMC4xNSA1IDIgNSAyIi8+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDMzLCAzNywgNDEpIiBmaWxsPSJub25lIiBkPSJNIDQ2NiA4NyBjIDAuMTQgMC4wOSA1LjQ0IDQuMDkgOCA1IGMgMS42MyAwLjU4IDQuMzMgLTAuMzcgNiAwIGMgMSAwLjIyIDIgMS43NSAzIDIgYyAxLjM4IDAuMzQgMy42MiAtMC4zNCA1IDAgbCAzIDIiLz48L3N2Zz4=");

        String pdfFilePath = "D:\\pdffile\\contract\\1-TLITER528448471062155264.pdf";
        String imgPath = "D:\\pdffile\\contract\\2.png";
        StringBuffer svgCode = new  StringBuffer();

        genContractPdf(map,pdfFilePath);

    }*/

    public static String genContractPdf(Map data,String pdfFilePath) throws Exception {

        KeyStore ks = KeyStore.getInstance("PKCS12");

        ks.load(new FileInputStream(KEYSTORE), PASSWORD);

        String alias = (String)ks.aliases().nextElement();

        PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);

        Certificate[] chain = ks.getCertificateChain(alias);
        try {

            log.info("pdfFilePathGen:"+pdfFilePath);
            String worddes = SnowflakeIdWorker.getUUID()+".docx";
            WordSealUtil.sealInWord(templatePath,worddes,null,"(签字)",data,100,30,280,-2,false);
            String pdfTempPath = SnowflakeIdWorker.getUUID()+".pdf";
            WordUtil.wordConverterToPdf(worddes,pdfTempPath);

            //WordUtil.itextPDFAddPicture(pdfTempPath,data,pdfFilePath);
            sign(pdfTempPath,pdfFilePath,chain,pk,DigestAlgorithms.SHA1,null, MakeSignature.CryptoStandard.CMS, data,MD5Util.getMD5(new File(pdfTempPath)), "wjy");
            FileUtils.deleteFile(worddes);
            FileUtils.deleteFile(pdfTempPath);
            log.info("pdfFilePathGen:success");
            return pdfFilePath;
        } catch (Exception e) {
            log.info("pdfFilePathGen:fail");
            log.info("pdfFilePathGen:"+e.getMessage());
            e.printStackTrace();
            return null;
        }

    }



    public static void sign(String src //需要签章的pdf文件路径
                ,String dest // 签完章的pdf文件路径
                ,Certificate[] chain //证书链
                ,PrivateKey pk //签名私钥
                ,String digestAlgorithm //摘要算法名称，例如SHA-1
                ,String provider // 密钥算法提供者，可以为null
                ,MakeSignature.CryptoStandard subfilter //数字签名格式，itext有2种
                ,Map<String, Object> param//参数数据
                ,String reason //签名的原因，显示在pdf签名属性中，随便填
                ,String location) //签名的地点，显示在pdf签名属性中，随便填
            throws GeneralSecurityException, IOException, DocumentException, TranscoderException {
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(src);
        } catch (IOException e) {
            log.error("PdfUtil sign IOException fail:"+e.getMessage());
            throw e;
        }
        // Creating the reader and the stamper，开始pdfreader
        PdfReader reader = new PdfReader(inputStream);
        //PdfReader reader2 = new PdfReader(inputStream);
        int chunkWidth = 200;// 公章大小，x轴
        int chunkHeight = 200;// 公章大小，y轴
        // 获取pdf页面的高和宽
        Rectangle pageSize = reader.getPageSize(1);
        float height = pageSize.getHeight();
        float width = pageSize.getWidth();
        // 6、为pdf每页加印章
        // 设置公章的位置
        float xL = width - chunkWidth/2 - 2;
        float yL = height/2-chunkHeight/2-25;

        int pdfPages = reader.getNumberOfPages();// pdf页面页码
        //目标文件输出流
        FileOutputStream os = new FileOutputStream(dest);
        //创建签章工具PdfStamper ，最后一个boolean参数
        //false的话，pdf文件只允许被签名一次，多次签名，最后一次有效
        //true的话，pdf可以被追加签名，验签工具可以识别出每次签名之后文档是否被修改
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0', null, true);

        /* 使用中文字体 */
    /*    com.itextpdf.text.pdf.AcroFields acroFields = stamper.getAcroFields();

        com.itextpdf.text.pdf.BaseFont bf = com.itextpdf.text.pdf.BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        ArrayList<BaseFont> fontList = new ArrayList<BaseFont>(1);
        fontList.add(bf);
        acroFields.setSubstitutionFonts(fontList);*/
        // 4、生成公章,签名
        String signImg = SnowflakeIdWorker.getUUID()+".png";
        String svgImg = SnowflakeIdWorker.getUUID()+".svg";
        //String signImg = "D:/v2file/"+ SnowflakeIdWorker.getUUID()+".png";
        //String svgbase64 = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+PCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj48c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgdmVyc2lvbj0iMS4xIiB3aWR0aD0iNzIyIiBoZWlnaHQ9IjE2MSI+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDE1OCwgMTY3LCAxNzkpIiBmaWxsPSJub25lIiBkPSJNIDIzNiAxIGMgMC4xMiAwLjA3IDUuNjggMi4yOCA3IDQgYyAxLjU1IDIuMDIgMi43IDYuMDMgMyA5IGMgMC42NiA2LjU2IDEuMTYgMTUuMDMgMCAyMSBjIC0wLjY0IDMuMzIgLTMuNjkgNy4wMyAtNiAxMCBjIC0yLjI0IDIuODggLTUuMDEgNi4wNCAtOCA4IGMgLTYuMjcgNC4xMSAtMjIuMjYgMTAuNDQgLTIxIDExIGMgMi42NiAxLjE5IDM0LjQzIDAuODcgNTAgMiBjIDEuNjggMC4xMiA0LjY4IDEuMDUgNSAyIGMgMC40MyAxLjI5IC0wLjU4IDUuNjYgLTIgNyBjIC0zLjY4IDMuNDggLTEwLjMyIDcuMzcgLTE2IDEwIGMgLTE3LjI2IDguMDEgLTUwLjgxIDE4LjgzIC01MyAyMiBjIC0xLjI5IDEuODYgMjEuODkgNi4yNiAzMyA3IGMgNDMuNSAyLjkgODcuODMgMS41NSAxMzIgNCBjIDEwLjE3IDAuNTcgMTkuNjEgMy41NyAzMCA1IGMgMTcuMjEgMi4zNyAzNC40OSA0LjU2IDUwIDYgYyAxLjI3IDAuMTIgMy4xNiAtMC4yMiA0IC0xIGMgMi45MSAtMi42OSA2LjQ2IC03LjMgOSAtMTEgYyAwLjk2IC0xLjQgMS41MyAtMy4yNyAyIC01IGMgMS41MyAtNS42MiAzLjI1IC0xMS4yOSA0IC0xNyBjIDAuOSAtNi44NyAxIC0yMSAxIC0yMSIvPjxwYXRoIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIiBzdHJva2U9InJnYigxNTgsIDE2NywgMTc5KSIgZmlsbD0ibm9uZSIgZD0iTSA0NDUgMzUgYyAtMC43NyAwLjUzIC0yOC43OSAyMC4xOSAtNDQgMzAgYyAtNS44OCAzLjc5IC0xMS43MSA3LjEgLTE4IDEwIGMgLTEwLjU2IDQuODYgLTIwLjg5IDguNzYgLTMyIDEzIGMgLTcuODMgMi45OSAtMTUuMDcgNS44MSAtMjMgOCBjIC0xMS42OSAzLjIyIC0yMi44NyA1LjUgLTM1IDggYyAtMTEuMzMgMi4zMyAtMjEuNTcgNC4yNCAtMzMgNiBjIC0xNS40NyAyLjM4IC00MC41NiA2LjIyIC00NSA2IGMgLTAuOTIgLTAuMDUgNSAtNi4yMyA1IC04IGMgMCAtMS4yIC0zLjE4IC0zLjE3IC01IC00IGMgLTUuMTMgLTIuMzMgLTExLjEzIC00LjYxIC0xNyAtNiBjIC0yMC45NiAtNC45OCAtNDEuMjIgLTguMyAtNjMgLTEzIGMgLTguNzEgLTEuODggLTE2LjU1IC0zLjcyIC0yNSAtNiBjIC00LjE2IC0xLjEyIC0xMS4zOCAtMi4zOCAtMTIgLTQgYyAtMC41NiAtMS40NiA0LjA3IC03LjgzIDcgLTkgYyAxMS40IC00LjU2IDI4LjI3IC04LjE3IDQzIC0xMSBjIDE4Ljc3IC0zLjYgMzYuNjcgLTUuODMgNTYgLTggYyAyMy42NyAtMi42NSA0NS4yNiAtNC42NyA2OSAtNiBjIDI1LjM4IC0xLjQyIDQ5LjE0IC0yLjg2IDc0IC0yIGMgMjMuOTYgMC44MyA0Ni42MSA0LjAyIDcxIDcgYyAyMC43NCAyLjUzIDM5LjkyIDQuNzMgNjAgOSBjIDI3LjY5IDUuODkgNTMuMzcgMTMuNDIgODEgMjEgYyA3LjMxIDIuMDEgMTMuODIgNS4yIDIxIDcgYyA4LjkxIDIuMjMgMjcuNzEgNC44OSAyNyA1IGMgLTIuNDUgMC4zNyAtNjEuNTIgMi42NiAtOTQgNSBjIC0zNC42NCAyLjUgLTY2LjIzIDUuNjIgLTEwMCA5IGMgLTMuNDMgMC4zNCAtOS41NSAxLjc4IC0xMCAyIGMgLTAuMTggMC4wOSAyLjY3IDAuOTggNCAxIGMgMjUuNDkgMC4zMSA1Mi42IC0wLjMxIDc5IDAgYyAyLjM2IDAuMDMgNi42NiAwLjY2IDcgMSBjIDAuMjEgMC4yMSAtMi42NCAxLjg0IC00IDIgYyAtOC44MyAxLjA3IC0xOS4wNSAxLjk1IC0yOSAyIGMgLTEzNS45IDAuNjQgLTI1OS40OCAwLjYgLTM5NyAwIGMgLTIxLjQ5IC0wLjA5IC01OC42NCAtMi4xMiAtNjIgLTIgYyAtMC40NCAwLjAyIDQuNjQgMy45OCA3IDQgYyAxNDIuNTcgMS4xNSAzMTguNiAtMC44NCA0ODggMCBjIDQwLjYzIDAuMiAxMTQuODggMi42OCAxMTcgMyBjIDAuOTIgMC4xNCAtMzMuMSA0LjE0IC01MCA3IGMgLTcuMjMgMS4yMiAtMTQuMDUgMi45MyAtMjEgNSBjIC01LjUgMS42NCAtMTYuMjggNi4xIC0xNiA2IGMgMC45IC0wLjMxIDMzLjUzIC0xMS41IDUxIC0xOCBjIDkuNDIgLTMuNSAxOC4wOSAtNi44MSAyNyAtMTEgYyA4LjM0IC0zLjkzIDE2LjA4IC04LjI1IDI0IC0xMyBjIDUuNjMgLTMuMzggMTAuNzcgLTcuMDcgMTYgLTExIGMgMi44NyAtMi4xNSA2LjMzIC00LjUgOCAtNyBjIDEuMjkgLTEuOTQgMS45MSAtNS4zOCAyIC04IGMgMC4yMyAtNi45OSAwLjU3IC0xNS40IC0xIC0yMiBjIC0xLjU2IC02LjU3IC02LjM1IC0xMy4zOCAtOSAtMjAgYyAtMC42MiAtMS41NCAtMC4xIC00LjEgLTEgLTUgYyAtMS41NyAtMS41NyAtNS40IC0zLjM5IC04IC00IGMgLTIuNjEgLTAuNjEgLTYuMjEgLTAuNjEgLTkgMCBjIC03LjQ1IDEuNjMgLTE1LjU0IDQuMDggLTIzIDcgYyAtNy45MSAzLjEgLTE1LjQxIDYuODIgLTIzIDExIGMgLTEyLjgyIDcuMDUgLTI0IDE0LjkzIC0zNyAyMiBjIC0zMCAxNi4zMiAtNTcuMzYgMzAuNDUgLTg4IDQ2IGMgLTE1LjczIDcuOTggLTI5LjkyIDE0LjY4IC00NiAyMiBjIC0yMi43MyAxMC4zNSAtNDMuNjUgMTkuNTkgLTY2IDI5IGMgLTMuMjQgMS4zNiAtOS44OCAyLjA4IC0xMCAzIGMgLTAuMTEgMC45MSA1Ljk4IDQuNDcgOSA1IGMgNy4zNCAxLjMgMTYuNzQgMS44MiAyNSAxIGMgNDUuNTggLTQuNSA4OS4zIC0xMS41OSAxMzcgLTE3IGMgNTAuMzcgLTUuNzIgOTYuNTUgLTguMjIgMTQ1IC0xNSBjIDE4Ljc4IC0yLjYzIDQ4LjAzIC0yLjY1IDU1IC0xMyBjIDExLjc3IC0xNy41IDEzLjMxIC02Ny42NiAxNyAtOTQgYyAwLjI2IC0xLjg1IC0xLjY5IC00LjU0IC0zIC02IGMgLTEuNDEgLTEuNTcgLTQuNDYgLTQuNTcgLTYgLTQgYyAtNy44MyAyLjg5IC0yMS4wOSAxMS40NyAtMzIgMTggYyAtNDMuNDYgMjYuMDIgLTgyLjA4IDUxLjI5IC0xMjUgNzYgYyAtMTIuOTkgNy40OCAtMjYuMTUgMTIuOTIgLTQwIDE5IGMgLTguNzEgMy44MyAtMTcuMTEgNy4zMiAtMjYgMTAgYyAtOC44MyAyLjY3IC0yMC40MiA1Ljc5IC0yNyA2IGMgLTEuNjggMC4wNSAtMy4xMSAtMy43IC01IC01IGMgLTcuNTcgLTUuMjIgLTE1LjY3IC0xMC41NyAtMjQgLTE1IGMgLTcuMzggLTMuOTMgLTE0Ljk3IC02LjYzIC0yMyAtMTAgYyAtOS4zNCAtMy45MiAtMTcuNjEgLTcuNSAtMjcgLTExIGMgLTEwLjkgLTQuMDYgLTIwLjg5IC03LjcyIC0zMiAtMTEgYyAtMTkuMDMgLTUuNjIgLTQxLjA3IC0xMC4zNyAtNTYgLTE1IGMgLTAuOTMgLTAuMjkgLTIuNDkgLTIuNzEgLTIgLTMgYyA0LjI4IC0yLjUzIDE5LjAzIC05LjkyIDI5IC0xMyBjIDE2Ljc0IC01LjE3IDMzLjg5IC04LjEyIDUyIC0xMiBjIDI1LjYyIC01LjQ5IDQ4LjM1IC0xMC4yNiA3NCAtMTUgYyAxOS4yNyAtMy41NiAzNi45NiAtNi44IDU2IC05IGMgMTMuMTEgLTEuNTIgMzMgLTIuOTUgMzkgLTIgYyAxLjI0IDAuMiAwLjE4IDYuMTcgLTEgOCBjIC0xLjk4IDMuMDYgLTYuMjQgNi45MyAtMTAgOSBjIC0xOS4wMiAxMC40NSAtNDAuMzggMjIuODQgLTYxIDMwIGMgLTE4LjU2IDYuNDQgLTM5LjMzIDguNjEgLTYwIDEyIGMgLTIxLjEyIDMuNDYgLTQwLjU3IDQuOTEgLTYyIDggYyAtMTcuMDIgMi40NSAtMzIuNDEgNS45NiAtNDkgOCBjIC04LjAyIDAuOTkgLTE4LjcgMS42MSAtMjQgMSBjIC0wLjk5IC0wLjExIC0xLjg4IC0yLjc1IC0yIC00IGMgLTAuMTcgLTEuNjkgMC4yNSAtNC4yOCAxIC02IGMgMS40NCAtMy4yOSAzLjcgLTYuODMgNiAtMTAgYyA0Ljc3IC02LjU4IDExLjA2IC0xMi41NyAxNSAtMTkgYyAyLjA2IC0zLjM2IDUuNjggLTExLjU4IDQgLTEyIGMgLTYuMzcgLTEuNTkgLTMzLjA4IC0wLjc4IC00OCAxIGMgLTYuMjkgMC43NSAtMTMuMjUgMy45NyAtMTkgNyBjIC01LjkgMy4xMiAtMTEuNTUgNy42NCAtMTcgMTIgYyAtNC42MyAzLjcxIC05LjUzIDcuNTYgLTEzIDEyIGMgLTQuNTcgNS44NSAtOC43NSAxMy4yOSAtMTIgMjAgYyAtMS41OSAzLjI4IC0yLjY1IDcuMzYgLTMgMTEgYyAtMC42MiA2LjM4IC0wLjg0IDE0LjA5IDAgMjAgYyAwLjM4IDIuNjQgMi4xNyA2LjE3IDQgOCBjIDIuNjcgMi42NyA3LjI2IDQuOSAxMSA3IGwgNSAyIi8+PC9zdmc+";
        String svgbase64 = (String)param.get("data");

        ImageUtil.GenerateImage(svgbase64,svgImg);
        String svgCode = ImageUtil.replaceTxtByStr(svgImg);
        svgCode = svgCode.replaceAll("\\<\\?xml(.+?)\\?\\>","").replaceAll("\\<\\!DOCTYPE(.+?)\\>","").trim();
        ImageUtil.svgBase64ToPng(svgCode,signImg);
        byte[] byteBuffer = ImageUtil.image2byte(signImg);

        Image signature = Image.getInstance(byteBuffer);

        // 6.2 最后一页签名
        signature.scaleToFit(chunkWidth, chunkWidth);
        signature.setAbsolutePosition(150,  140);
        // 6.3 最后一页盖公章

        stamper.getOverContent(pdfPages).addImage(signature);
        // 获取数字签章属性对象，设定数字签章的属性
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason(reason);
        appearance.setLocation(location);
        //设置签名的位置，页码，签名域名称，多次追加签名的时候，签名预名称不能一样
        //签名的位置，是图章相对于pdf页面的位置坐标，原点为pdf页面左下角
        // 四个参数的分别是，图章左下角x，图章左下角y，图章右上角x，图章右上角y

        appearance.setVisibleSignature(new Rectangle(1000, 80, 000, 250), 1, "sig1");
        //读取图章图片，这个image是itext包的image
        String company = V2Config.getDefault_company();// 公司公章名称
        //String purpose = V2Config.getDefault_purpose();// 公章用途
        //String company = "武汉闻嘉瑜信息技术有限公司";// 公司公章名称
        String purpose = "合同专用章";// 公章用途
      /*  String year = (String) param.get("year");// 日期
        if (StringUtils.isEmpty(year)) {
            year = DateUtils.dateTimeNow("yyyy年MM月dd日");
        }*/
        BufferedImage bufferedImage = Graphics2DUtil.startGraphics2D(company, purpose, null);// 整个公章图片流
        Image image = Image.getInstance(WordUtil.imageToBytes(bufferedImage,"png"));
        appearance.setSignatureGraphic(image);
        appearance.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
        //设置图章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
        appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
        // 这里的itext提供了2个用于签名的接口，可以自己实现，后边着重说这个实现

        // 摘要算法
        com.itextpdf.text.pdf.security.ExternalDigest digest = new com.itextpdf.text.pdf.security.BouncyCastleDigest();
        // 签名算法
        ExternalSignature certificate = new PrivateKeySignature(pk, digestAlgorithm, null);
        // 调用itext签名方法完成pdf签章
        MakeSignature.signDetached(appearance, digest, certificate, chain, null, null, null, 0, subfilter);
        // 7、关闭相关流
        FileUtils.deleteFile(svgImg);//删除用户签名svg
        FileUtils.deleteFile(signImg);//删除用户签名

        stamper.close();
        os.close();
        reader.close();
        inputStream.close();
    }


    public static String msgDigest(String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        // 更新要计算的内容
        md5Digest.update(msg.getBytes());
        // 完成哈希计算，得到摘要
        byte[] md5Encoded = md5Digest.digest();

        MessageDigest shaDigest = MessageDigest.getInstance("SHA");
        // 更新要计算的内容
        shaDigest.update(msg.getBytes());
        // 完成哈希计算，得到摘要
        byte[] shaEncoded = shaDigest.digest();


        log.info("MD5摘要: " + Base64.encodeBase64URLSafeString(md5Encoded));
        log.info("SHA摘要: " + Base64.encodeBase64URLSafeString(shaEncoded));
        return Base64.encodeBase64URLSafeString(shaEncoded);
    }


    /**
     * pdf摘要生成
     *
     * @param file   配置
     */
   /* public static String getPdfDigest(File file){
        String digestFinal = null;
        byte[] contractFile =File2byte(file);
        try{

            MechanismFactory factory  = new MechanismFactory();
            digestFinal = factory.getMechanismContext(contractFile);
        } catch (GSSException e) {
            e.printStackTrace();
        }
    }*/

    public static byte[] File2byte(File file){
        byte[] buffer = null;
        try{
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while((n=fis.read(b))!=-1){
                bos.write(b,0,n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  buffer;
    }

/*
    public static void main(String[] args) throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException {
        genContractPdf(new HashMap(),"D:/v2file/"+SnowflakeIdWorker.getUUID()+".pdf");

    }*/
}
