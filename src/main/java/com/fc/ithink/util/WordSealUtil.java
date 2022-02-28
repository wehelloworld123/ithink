package com.fc.ithink.util;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSealUtil {
  /*  public static void main(String[] args) throws Exception {
        sealInWord("D:\\test\\test.docx","D:\\test\\SealInWord.docx","D:\\test\\hh01.png","(签字/盖章)",0,0,300,-30,false);
    }*/


    /**
     * <b> Word中添加图章
     * </b><br><br><i>Description</i> :
     * String srcPath, 源Word路径
     * String storePath, 添加图章后的路径
     * String sealPath, 图章路径（即图片）
     * tString abText, 在Word中盖图章的标识字符串，如：(签字/盖章)
     * int width, 图章宽度
     * int height, 图章高度
     * int leftOffset, 图章在编辑段落向左偏移量
     * int topOffset, 图章在编辑段落向上偏移量
     * boolean behind，图章是否在文字下面
     * @return void
     * <br><br>Date: 2019/12/26 15:12     <br>Author : dxl
     */
    public static void sealInWord(String srcPath, String storePath,String sealPath,String tabText,Map<String,Object> params,
                                  int width, int height, int leftOffset, int topOffset, boolean behind) throws Exception {
        File fileTem = new File(srcPath);
        InputStream is = new FileInputStream(fileTem);
        XWPFDocument document = new XWPFDocument(is);
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        XWPFRun targetRun = null;
        for(XWPFParagraph  paragraph : paragraphs){

       /*     if(!"".equals(paragraph.getText()) && paragraph.getText().contains(tabText)){
                List<XWPFRun> runs = paragraph.getRuns();
                targetRun = runs.get(runs.size()-1);
            }*/

            replaceInPara(paragraph, params);
        }
        if(targetRun != null){
            InputStream in = new FileInputStream(sealPath);//设置图片路径
            if(width <= 0){
                width = 100;
            }
            if(height <= 0){
                height = 100;
            }
            //创建Random类对象
            Random random = new Random();
            //产生随机数
            int number = random.nextInt(999) + 1;
            targetRun.addPicture(in, Document.PICTURE_TYPE_PNG, "Seal"+number, Units.toEMU(width), Units.toEMU(height));
            in.close();
            // 2. 获取到图片数据
            CTDrawing drawing = targetRun.getCTR().getDrawingArray(0);
            CTGraphicalObject graphicalobject = drawing.getInlineArray(0).getGraphic();

            //拿到新插入的图片替换添加CTAnchor 设置浮动属性 删除inline属性
            CTAnchor anchor = getAnchorWithGraphic(graphicalobject, "Seal"+number,
                    Units.toEMU(width), Units.toEMU(height),//图片大小
                    Units.toEMU(leftOffset), Units.toEMU(topOffset), behind);//相对当前段落位置 需要计算段落已有内容的左偏移
            drawing.setAnchorArray(new CTAnchor[]{anchor});//添加浮动属性
            drawing.removeInline(0);//删除行内属性
        }
        File file = new File(storePath);
        document.write(new FileOutputStream(file));
        document.close();
    }
    /**
     * @param ctGraphicalObject 图片数据
     * @param deskFileName      图片描述
     * @param width             宽
     * @param height            高
     * @param leftOffset        水平偏移 left
     * @param topOffset         垂直偏移 top
     * @param behind            文字上方，文字下方
     * @return
     * @throws Exception
     */
    public static CTAnchor getAnchorWithGraphic(CTGraphicalObject ctGraphicalObject,
                                                String deskFileName, int width, int height,
                                                int leftOffset, int topOffset, boolean behind) {
        System.out.println(">>width>>"+width+"; >>height>>>>"+height);
        String anchorXML =
                "<wp:anchor xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" "
                        + "simplePos=\"0\" relativeHeight=\"0\" behindDoc=\"" + ((behind) ? 1 : 0) + "\" locked=\"0\" layoutInCell=\"1\" allowOverlap=\"1\">"
                        + "<wp:simplePos x=\"0\" y=\"0\"/>"
                        + "<wp:positionH relativeFrom=\"column\">"
                        + "<wp:posOffset>" + leftOffset + "</wp:posOffset>"
                        + "</wp:positionH>"
                        + "<wp:positionV relativeFrom=\"paragraph\">"
                        + "<wp:posOffset>" + topOffset + "</wp:posOffset>" +
                        "</wp:positionV>"
                        + "<wp:extent cx=\"" + width + "\" cy=\"" + height + "\"/>"
                        + "<wp:effectExtent l=\"0\" t=\"0\" r=\"0\" b=\"0\"/>"
                        + "<wp:wrapNone/>"
                        + "<wp:docPr id=\"1\" name=\"Drawing 0\" descr=\"" + deskFileName + "\"/><wp:cNvGraphicFramePr/>"
                        + "</wp:anchor>";

        CTDrawing drawing = null;
        try {
            drawing = CTDrawing.Factory.parse(anchorXML);
        } catch (XmlException e) {
            e.printStackTrace();
        }
        CTAnchor anchor = drawing.getAnchorArray(0);
        anchor.setGraphic(ctGraphicalObject);
        return anchor;
    }
    /**
     * 替换段落里面的变量
     * @param para 要替换的段落
     * @param params 参数
     */
    private static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        replaceText(para);//如果para拆分的不对，则用这个方法修改成正确的
        if (matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            for (int i=0; i<runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = matcher(runText);
                if (matcher.find()) {
                    while ((matcher = matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
                    //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                    //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                    para.removeRun(i);
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }

    /**
     * 合并runs中的内容
     * @param para
     * @return
     */
    private static List<XWPFRun> replaceText(XWPFParagraph para){
        List<XWPFRun> runs = para.getRuns();
        String str = "";
        boolean flag = false;
        for (int i=0; i<runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();
            if( flag || runText.equals("${") ){

                str = str + runText;
                flag = true;
                para.removeRun(i);
                if( runText.equals("}") ){
                    flag = false;
                    para.insertNewRun(i).setText(str);
                    str = "";
                }
                i--;
            }

        }

        return runs;
    }

    /**
     * 正则匹配字符串
     * @param str
     * @return
     */
    private static Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
}
