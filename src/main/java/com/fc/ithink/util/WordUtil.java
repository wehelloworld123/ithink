package com.fc.ithink.util;

import com.aspose.words.FontSettings;
import com.aspose.words.FontSourceBase;
import com.aspose.words.License;
import com.aspose.words.MemoryFontSource;
import com.deepoove.poi.XWPFTemplate;
import com.fc.ithink.common.file.FileUtils;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Slf4j
public class WordUtil {

    final static String fontPath = WordUtil.class.getResource("/").getPath()+"static/file/STSONG.TTF";

    final static String fontPath2 = WordUtil.class.getResource("/").getPath()+"static/file/simhei.ttf";

    public static String license = WordUtil.class.getResource("/").getPath()+"license.xml";

   /* public static void main(String args[]){

        Map<String, Object> data = new HashMap<>();
        data.put("ids", "PAINT12345678");
        data.put("name", "我的世界");
        data.put("copyright", "30");
        data.put("reward", "1000—3000元");
        data.put("date", "2020/10/21");

        try {
            String worddes = "D:/v2file/"+SnowflakeIdWorker.getUUID()+".docx";
            WordSealUtil.sealInWord("D:/v2file/20201122.docx",worddes,"D:/v2file/4.jpg","(签字)",data,100,30,280,-2,false);
            String pdfFilePath = "D:/v2file/"+SnowflakeIdWorker.getUUID()+".pdf";
            WordUtil.wordConverterToPdf(worddes,pdfFilePath);
            WordUtil.itextPDFAddPicture(pdfFilePath,new HashMap<>(),"D:/v2file/"+SnowflakeIdWorker.getUUID()+"End.pdf");
            FileUtils.deleteFile(worddes);
            FileUtils.deleteFile(pdfFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

    /**
     *
     * @Title: replaceAndGenerateWord
     * @Description: 替换word中需要替换的特殊字符
     * 优化后是为了分别减少map遍历，增加性能，前提是表格的替换的数据不一样，所以将两者分离处理（加空间，提性能）
     * @param srcPath 需要替换的文档全路径
     * @param exportFile 替换后文档的保存路径
     * @param contentMap {key:将要被替换的内容,value:替换后的内容}
     * @param replaceTableMap {key:将要被替换的表格内容,value:替换后的表格内容}
     * @return boolean 返回成功状态
     */
    public static boolean replaceAndGenerateWord(String  srcPath, String exportFile, Map<String, String> contentMap, Map<String, String> replaceTableMap) {
        boolean bool = true;
        try {
            FileInputStream inputStream = new FileInputStream(srcPath);
            XWPFDocument document = new XWPFDocument(inputStream);
            // 替换段落中的指定文字
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = itPara.next();
                commonCode(paragraph, contentMap);
            }
            // 替换表格中的指定文字
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = itTable.next();
                int rcount = table.getNumberOfRows();
                for (int i = 0; i < rcount; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        //单元格中有段落，得做段落处理
                        List<XWPFParagraph> paragraphs = cell.getParagraphs();
                        for (XWPFParagraph paragraph : paragraphs) {
                            commonCode(paragraph, replaceTableMap);
                        }
                    }
                }
            }

            FileOutputStream outStream = new FileOutputStream(exportFile);
            document.write(outStream);
            outStream.close();
            inputStream.close();
        }catch (Exception e){
            bool = false;
            e.printStackTrace();
        }
        return bool;
    }

    /**
     *
     * @Title: commonCode
     * @Description: 替换内容
     * @param paragraph 被替换的文本信息
     * @param contentMap {key:将要被替换的内容,value:替换后的内容}
     */
    private static void commonCode(XWPFParagraph paragraph,Map<String, String> contentMap){
        List<XWPFRun> runs = paragraph.getRuns();
        for (XWPFRun run : runs) {
            String oneparaString = run.getText(run.getTextPosition());
            if (StringUtils.isEmpty(oneparaString)){
                continue;
            }
            for (Map.Entry<String, String> entry : contentMap.entrySet()) {
                oneparaString = oneparaString.replace(entry.getKey(), StringUtils.isEmpty(entry.getValue()) ? "--" : entry.getValue());
            }
            run.setText(oneparaString, 0);
        }
    }

    /**
     *
     * @Title: getLicense
     * @Description:验证license许可凭证
     * @return boolean 返回验证License状态
     */
    private static boolean getLicense() {
        boolean result = true;
        try {
 //       	new License().setLicense(new FileInputStream(new File("D:\\develop\\template\\license.xml").getAbsolutePath()));
            new License().setLicense(new FileInputStream(license));
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @Title: wordConverterToPdf
     * @Description: word转pdf(aspose转换)
     * @param wordPath word 全路径，包括文件全称
     * @param pdfPath pdf 保存路径，包括文件全称
     * @return boolean 返回转换状态
     */
    public static boolean wordConverterToPdf(String wordPath, String pdfPath) throws Exception {
        out.println("===================aspose开始转换=======================");
        //开始时间
        long start = System.currentTimeMillis();
        boolean bool = false;
        // 验证License,若不验证则转化出的pdf文档会有水印产生
        if (!getLicense()) return bool;
        try {
            FileOutputStream os = new FileOutputStream(pdfPath);// 新建一个pdf文档输出流
            com.aspose.words.Document doc = new com.aspose.words.Document(wordPath);// Address是将要被转化的word文档

            doc.setFontSettings(FontSettings.getDefaultInstance());
            byte[] fontBytes = Files.readAllBytes(Paths.get(fontPath));
            byte[] fontBytess = Files.readAllBytes(Paths.get(fontPath2));

            doc.getFontSettings().setFontsSources(new FontSourceBase[]{new MemoryFontSource(fontBytess,0),new MemoryFontSource(fontBytes,1)});

            doc.save(os, com.aspose.words.SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换

            os.close();
            bool = true;
        } catch (Exception e) {
            log.error("com.aspose.words.Document fail:"+e.getMessage());
            e.printStackTrace();
        } finally {
            out.println("(aspose)word转换PDF完成，用时"+(System.currentTimeMillis()-start)/1000.0+"秒");
        }
        return bool;
    }

    /**
     *
     * @Title: insertRow
     * @Description: 在word表格中指定位置插入一行，并将某一行的样式复制到新增行
     * @param table 需要插入的表格
     * @param copyrowIndex 需要复制的行位置
     * @param newrowIndex 需要新增一行的位置
     * @return void 返回类型
     */
    public static void insertRow(XWPFTable table, int copyrowIndex, int newrowIndex) {
        // 在表格中指定的位置新增一行
        XWPFTableRow targetRow = table.insertNewTableRow(newrowIndex);
        // 获取需要复制行对象
        XWPFTableRow copyRow = table.getRow(copyrowIndex);
        //复制行对象
        targetRow.getCtRow().setTrPr(copyRow.getCtRow().getTrPr());
        //或许需要复制的行的列
        List<XWPFTableCell> copyCells = copyRow.getTableCells();
        //复制列对象
        XWPFTableCell targetCell = null;
        for (int i = 0; i < copyCells.size(); i++) {
            XWPFTableCell copyCell = copyCells.get(i);
            targetCell = targetRow.addNewTableCell();
            targetCell.getCTTc().setTcPr(copyCell.getCTTc().getTcPr());
            if (copyCell.getParagraphs() != null && copyCell.getParagraphs().size() > 0) {
                targetCell.getParagraphs().get(0).getCTP().setPPr(copyCell.getParagraphs().get(0).getCTP().getPPr());
                if (copyCell.getParagraphs().get(0).getRuns() != null
                        && copyCell.getParagraphs().get(0).getRuns().size() > 0) {
                    XWPFRun cellR = targetCell.getParagraphs().get(0).createRun();
                    cellR.setBold(copyCell.getParagraphs().get(0).getRuns().get(0).isBold());
                }
            }
        }

    }
    /**
     *
     * @Title: itextPDFAddPicture
     * @Description: 为pdf加图片(电子合同盖公章)
     * @param filePath 电子合同pdf文件流
     * @param map {company:公司公章名称,purpose:公章用途，year:日期}
     * @param targetPath 保存路径
     * @throws Exception 异常参数
     */
    public static void itextPDFAddPicture(String filePath, Map<String, Object> map, String targetPath) throws Exception{
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (IOException e) {
            throw e;
        }
        // 1.1 读取模板文件
        PdfReader reader = new PdfReader(inputStream);
        // 1.2 创建文件输出流
        FileOutputStream out = new FileOutputStream(targetPath);
        // 2、创建PdfStamper对象
        PdfStamper stamper = new PdfStamper(reader, out);
        // 3、设置公章信息
        //String company = V2Config.getDefault_company();// 公司公章名称
        //String purpose = V2Config.getDefault_purpose();// 公章用途

        String company = "武汉闻嘉瑜信息技术有限公司";// 公司公章名称
        String purpose = "合同专用章";// 公章用途
        String year = (String) map.get("year");// 日期
        if (StringUtils.isEmpty(year)) {
            year = DateUtils.dateTimeNow("yyyy年MM月dd日");
        }
        // 4、生成公章,签名
        //String signImg = V2Config.getDefaultBaseDir()+ SnowflakeIdWorker.getUUID()+".png";
        String signImg = "D:/v2file/"+ SnowflakeIdWorker.getUUID()+".png";
        //String svgbase64 = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+PCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj48c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgdmVyc2lvbj0iMS4xIiB3aWR0aD0iNzIyIiBoZWlnaHQ9IjE2MSI+PHBhdGggc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIiBzdHJva2Utd2lkdGg9IjIiIHN0cm9rZT0icmdiKDE1OCwgMTY3LCAxNzkpIiBmaWxsPSJub25lIiBkPSJNIDIzNiAxIGMgMC4xMiAwLjA3IDUuNjggMi4yOCA3IDQgYyAxLjU1IDIuMDIgMi43IDYuMDMgMyA5IGMgMC42NiA2LjU2IDEuMTYgMTUuMDMgMCAyMSBjIC0wLjY0IDMuMzIgLTMuNjkgNy4wMyAtNiAxMCBjIC0yLjI0IDIuODggLTUuMDEgNi4wNCAtOCA4IGMgLTYuMjcgNC4xMSAtMjIuMjYgMTAuNDQgLTIxIDExIGMgMi42NiAxLjE5IDM0LjQzIDAuODcgNTAgMiBjIDEuNjggMC4xMiA0LjY4IDEuMDUgNSAyIGMgMC40MyAxLjI5IC0wLjU4IDUuNjYgLTIgNyBjIC0zLjY4IDMuNDggLTEwLjMyIDcuMzcgLTE2IDEwIGMgLTE3LjI2IDguMDEgLTUwLjgxIDE4LjgzIC01MyAyMiBjIC0xLjI5IDEuODYgMjEuODkgNi4yNiAzMyA3IGMgNDMuNSAyLjkgODcuODMgMS41NSAxMzIgNCBjIDEwLjE3IDAuNTcgMTkuNjEgMy41NyAzMCA1IGMgMTcuMjEgMi4zNyAzNC40OSA0LjU2IDUwIDYgYyAxLjI3IDAuMTIgMy4xNiAtMC4yMiA0IC0xIGMgMi45MSAtMi42OSA2LjQ2IC03LjMgOSAtMTEgYyAwLjk2IC0xLjQgMS41MyAtMy4yNyAyIC01IGMgMS41MyAtNS42MiAzLjI1IC0xMS4yOSA0IC0xNyBjIDAuOSAtNi44NyAxIC0yMSAxIC0yMSIvPjxwYXRoIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIiBzdHJva2U9InJnYigxNTgsIDE2NywgMTc5KSIgZmlsbD0ibm9uZSIgZD0iTSA0NDUgMzUgYyAtMC43NyAwLjUzIC0yOC43OSAyMC4xOSAtNDQgMzAgYyAtNS44OCAzLjc5IC0xMS43MSA3LjEgLTE4IDEwIGMgLTEwLjU2IDQuODYgLTIwLjg5IDguNzYgLTMyIDEzIGMgLTcuODMgMi45OSAtMTUuMDcgNS44MSAtMjMgOCBjIC0xMS42OSAzLjIyIC0yMi44NyA1LjUgLTM1IDggYyAtMTEuMzMgMi4zMyAtMjEuNTcgNC4yNCAtMzMgNiBjIC0xNS40NyAyLjM4IC00MC41NiA2LjIyIC00NSA2IGMgLTAuOTIgLTAuMDUgNSAtNi4yMyA1IC04IGMgMCAtMS4yIC0zLjE4IC0zLjE3IC01IC00IGMgLTUuMTMgLTIuMzMgLTExLjEzIC00LjYxIC0xNyAtNiBjIC0yMC45NiAtNC45OCAtNDEuMjIgLTguMyAtNjMgLTEzIGMgLTguNzEgLTEuODggLTE2LjU1IC0zLjcyIC0yNSAtNiBjIC00LjE2IC0xLjEyIC0xMS4zOCAtMi4zOCAtMTIgLTQgYyAtMC41NiAtMS40NiA0LjA3IC03LjgzIDcgLTkgYyAxMS40IC00LjU2IDI4LjI3IC04LjE3IDQzIC0xMSBjIDE4Ljc3IC0zLjYgMzYuNjcgLTUuODMgNTYgLTggYyAyMy42NyAtMi42NSA0NS4yNiAtNC42NyA2OSAtNiBjIDI1LjM4IC0xLjQyIDQ5LjE0IC0yLjg2IDc0IC0yIGMgMjMuOTYgMC44MyA0Ni42MSA0LjAyIDcxIDcgYyAyMC43NCAyLjUzIDM5LjkyIDQuNzMgNjAgOSBjIDI3LjY5IDUuODkgNTMuMzcgMTMuNDIgODEgMjEgYyA3LjMxIDIuMDEgMTMuODIgNS4yIDIxIDcgYyA4LjkxIDIuMjMgMjcuNzEgNC44OSAyNyA1IGMgLTIuNDUgMC4zNyAtNjEuNTIgMi42NiAtOTQgNSBjIC0zNC42NCAyLjUgLTY2LjIzIDUuNjIgLTEwMCA5IGMgLTMuNDMgMC4zNCAtOS41NSAxLjc4IC0xMCAyIGMgLTAuMTggMC4wOSAyLjY3IDAuOTggNCAxIGMgMjUuNDkgMC4zMSA1Mi42IC0wLjMxIDc5IDAgYyAyLjM2IDAuMDMgNi42NiAwLjY2IDcgMSBjIDAuMjEgMC4yMSAtMi42NCAxLjg0IC00IDIgYyAtOC44MyAxLjA3IC0xOS4wNSAxLjk1IC0yOSAyIGMgLTEzNS45IDAuNjQgLTI1OS40OCAwLjYgLTM5NyAwIGMgLTIxLjQ5IC0wLjA5IC01OC42NCAtMi4xMiAtNjIgLTIgYyAtMC40NCAwLjAyIDQuNjQgMy45OCA3IDQgYyAxNDIuNTcgMS4xNSAzMTguNiAtMC44NCA0ODggMCBjIDQwLjYzIDAuMiAxMTQuODggMi42OCAxMTcgMyBjIDAuOTIgMC4xNCAtMzMuMSA0LjE0IC01MCA3IGMgLTcuMjMgMS4yMiAtMTQuMDUgMi45MyAtMjEgNSBjIC01LjUgMS42NCAtMTYuMjggNi4xIC0xNiA2IGMgMC45IC0wLjMxIDMzLjUzIC0xMS41IDUxIC0xOCBjIDkuNDIgLTMuNSAxOC4wOSAtNi44MSAyNyAtMTEgYyA4LjM0IC0zLjkzIDE2LjA4IC04LjI1IDI0IC0xMyBjIDUuNjMgLTMuMzggMTAuNzcgLTcuMDcgMTYgLTExIGMgMi44NyAtMi4xNSA2LjMzIC00LjUgOCAtNyBjIDEuMjkgLTEuOTQgMS45MSAtNS4zOCAyIC04IGMgMC4yMyAtNi45OSAwLjU3IC0xNS40IC0xIC0yMiBjIC0xLjU2IC02LjU3IC02LjM1IC0xMy4zOCAtOSAtMjAgYyAtMC42MiAtMS41NCAtMC4xIC00LjEgLTEgLTUgYyAtMS41NyAtMS41NyAtNS40IC0zLjM5IC04IC00IGMgLTIuNjEgLTAuNjEgLTYuMjEgLTAuNjEgLTkgMCBjIC03LjQ1IDEuNjMgLTE1LjU0IDQuMDggLTIzIDcgYyAtNy45MSAzLjEgLTE1LjQxIDYuODIgLTIzIDExIGMgLTEyLjgyIDcuMDUgLTI0IDE0LjkzIC0zNyAyMiBjIC0zMCAxNi4zMiAtNTcuMzYgMzAuNDUgLTg4IDQ2IGMgLTE1LjczIDcuOTggLTI5LjkyIDE0LjY4IC00NiAyMiBjIC0yMi43MyAxMC4zNSAtNDMuNjUgMTkuNTkgLTY2IDI5IGMgLTMuMjQgMS4zNiAtOS44OCAyLjA4IC0xMCAzIGMgLTAuMTEgMC45MSA1Ljk4IDQuNDcgOSA1IGMgNy4zNCAxLjMgMTYuNzQgMS44MiAyNSAxIGMgNDUuNTggLTQuNSA4OS4zIC0xMS41OSAxMzcgLTE3IGMgNTAuMzcgLTUuNzIgOTYuNTUgLTguMjIgMTQ1IC0xNSBjIDE4Ljc4IC0yLjYzIDQ4LjAzIC0yLjY1IDU1IC0xMyBjIDExLjc3IC0xNy41IDEzLjMxIC02Ny42NiAxNyAtOTQgYyAwLjI2IC0xLjg1IC0xLjY5IC00LjU0IC0zIC02IGMgLTEuNDEgLTEuNTcgLTQuNDYgLTQuNTcgLTYgLTQgYyAtNy44MyAyLjg5IC0yMS4wOSAxMS40NyAtMzIgMTggYyAtNDMuNDYgMjYuMDIgLTgyLjA4IDUxLjI5IC0xMjUgNzYgYyAtMTIuOTkgNy40OCAtMjYuMTUgMTIuOTIgLTQwIDE5IGMgLTguNzEgMy44MyAtMTcuMTEgNy4zMiAtMjYgMTAgYyAtOC44MyAyLjY3IC0yMC40MiA1Ljc5IC0yNyA2IGMgLTEuNjggMC4wNSAtMy4xMSAtMy43IC01IC01IGMgLTcuNTcgLTUuMjIgLTE1LjY3IC0xMC41NyAtMjQgLTE1IGMgLTcuMzggLTMuOTMgLTE0Ljk3IC02LjYzIC0yMyAtMTAgYyAtOS4zNCAtMy45MiAtMTcuNjEgLTcuNSAtMjcgLTExIGMgLTEwLjkgLTQuMDYgLTIwLjg5IC03LjcyIC0zMiAtMTEgYyAtMTkuMDMgLTUuNjIgLTQxLjA3IC0xMC4zNyAtNTYgLTE1IGMgLTAuOTMgLTAuMjkgLTIuNDkgLTIuNzEgLTIgLTMgYyA0LjI4IC0yLjUzIDE5LjAzIC05LjkyIDI5IC0xMyBjIDE2Ljc0IC01LjE3IDMzLjg5IC04LjEyIDUyIC0xMiBjIDI1LjYyIC01LjQ5IDQ4LjM1IC0xMC4yNiA3NCAtMTUgYyAxOS4yNyAtMy41NiAzNi45NiAtNi44IDU2IC05IGMgMTMuMTEgLTEuNTIgMzMgLTIuOTUgMzkgLTIgYyAxLjI0IDAuMiAwLjE4IDYuMTcgLTEgOCBjIC0xLjk4IDMuMDYgLTYuMjQgNi45MyAtMTAgOSBjIC0xOS4wMiAxMC40NSAtNDAuMzggMjIuODQgLTYxIDMwIGMgLTE4LjU2IDYuNDQgLTM5LjMzIDguNjEgLTYwIDEyIGMgLTIxLjEyIDMuNDYgLTQwLjU3IDQuOTEgLTYyIDggYyAtMTcuMDIgMi40NSAtMzIuNDEgNS45NiAtNDkgOCBjIC04LjAyIDAuOTkgLTE4LjcgMS42MSAtMjQgMSBjIC0wLjk5IC0wLjExIC0xLjg4IC0yLjc1IC0yIC00IGMgLTAuMTcgLTEuNjkgMC4yNSAtNC4yOCAxIC02IGMgMS40NCAtMy4yOSAzLjcgLTYuODMgNiAtMTAgYyA0Ljc3IC02LjU4IDExLjA2IC0xMi41NyAxNSAtMTkgYyAyLjA2IC0zLjM2IDUuNjggLTExLjU4IDQgLTEyIGMgLTYuMzcgLTEuNTkgLTMzLjA4IC0wLjc4IC00OCAxIGMgLTYuMjkgMC43NSAtMTMuMjUgMy45NyAtMTkgNyBjIC01LjkgMy4xMiAtMTEuNTUgNy42NCAtMTcgMTIgYyAtNC42MyAzLjcxIC05LjUzIDcuNTYgLTEzIDEyIGMgLTQuNTcgNS44NSAtOC43NSAxMy4yOSAtMTIgMjAgYyAtMS41OSAzLjI4IC0yLjY1IDcuMzYgLTMgMTEgYyAtMC42MiA2LjM4IC0wLjg0IDE0LjA5IDAgMjAgYyAwLjM4IDIuNjQgMi4xNyA2LjE3IDQgOCBjIDIuNjcgMi42NyA3LjI2IDQuOSAxMSA3IGwgNSAyIi8+PC9zdmc+";
        String svgbase64 = (String)map.get("data");
        //ImageUtil.svgBase64ToPng(svgbase64,signImg);

        BufferedImage bufferedImage = Graphics2DUtil.startGraphics2D(company, purpose, year);// 整个公章图片流
        /*BufferedImage[] imgs = Graphics2DUtil.splitImage(bufferedImage, 1, 2);
        BufferedImage leftBufferedImage = imgs[0];// 左边公章图片流
        BufferedImage rightBufferedImage = imgs[1];// 右边公章图片流*/

        // 5、读公章图片
        Image image = Image.getInstance(imageToBytes(bufferedImage,"png"));
        byte[] byteBuffer = ImageUtil.image2byte(signImg);
        FileUtils.deleteFile(signImg);
        Image signature = Image.getInstance(byteBuffer);
       /* Image leftImage = Image.getInstance(imageToBytes(leftBufferedImage));
        Image rightImage = Image.getInstance(imageToBytes(rightBufferedImage));*/
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

        float xR = width-chunkHeight/2 + chunkHeight/8 + 4;
        float yR = yL;
        // 6.1 第一页盖左章
    /*    leftImage.scaleToFit(chunkWidth, chunkHeight);// 公章大小
        leftImage.setAbsolutePosition(xL, yL);// 公章位置*/
        // 6.2 第二页盖右章
     /*   rightImage.scaleToFit(chunkWidth, chunkHeight);// 公章大小
        rightImage.setAbsolutePosition(xR, yR);// 公章位置*/
        int pdfPages = reader.getNumberOfPages();// pdf页面页码
        // 遍历为每页盖左章或右章
        for (int i = 1; i <= pdfPages; i++) {
            if (i % 2 == 0) {// 盖右章
               // stamper.getOverContent(i).addImage(rightImage);
            } else {// 盖左章
              //  stamper.getOverContent(i).addImage(leftImage);
            }
        }
        // 6.2 最后一页签名
        signature.scaleToFit(chunkWidth, chunkWidth);
        signature.setAbsolutePosition(150,  140);
        // 6.3 最后一页盖公章
        image.scaleToFit(chunkWidth, chunkWidth);
        image.setAbsolutePosition(width/2 + 80,  75);
        stamper.getOverContent(pdfPages).addImage(image);
        stamper.getOverContent(pdfPages).addImage(signature);
        // 7、关闭相关流
        stamper.close();
        out.close();
        reader.close();
        inputStream.close();
    }

    /**
     * 转换BufferedImage 数据为byte数组
     *
     * @param image
     * Image对象
     * @param format
     * image格式字符串.如"gif","png"
     * @return byte数组
     */
    public static byte[] imageToBytes(BufferedImage image, String format) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, format, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static   void text2Word(String tempatePath,String targetPath,Map data) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile(tempatePath)
                .render(data);

        FileOutputStream out;
        out = new FileOutputStream(targetPath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}

