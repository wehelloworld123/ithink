package com.fc.ithink.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Slf4j
public class ImageUtil {




    public static String convertFileToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            System.out.println("文件大小（字节）="+in.available());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        Base64.Encoder encoder = Base64.getMimeEncoder();
        String base64Str = encoder.encode(data).toString();
        return base64Str;
    }
    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        Base64.Decoder decoder = Base64.getMimeDecoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decode(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * base64转inputStream
     * @param base64string
     * @return
     */
    public static InputStream BaseToInputStream(String base64string){
        ByteArrayInputStream stream = null;
        try {
            Base64.Decoder decoder = Base64.getMimeDecoder();
            byte[] bytes1 = decoder.decode(base64string);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }


    /**
     * BufferedImage 编码转换为 base64
     * @param bufferedImage
     * @return
     */
    private static String BufferedImageToBase64(BufferedImage bufferedImage) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        try {
            ImageIO.write(bufferedImage, "png", baos);//写入流中
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();//转换成字节
        Base64.Encoder encoder = Base64.getMimeEncoder();
        String png_base64 = encoder.encode(bytes).toString();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        System.out.println("值为：" + "data:image/jpg;base64," + png_base64);
        return "data:image/jpg;base64," + png_base64;
    }

    /**
     * base64 编码转换为 BufferedImage
     * @param base64
     * @return
     */
    public  static BufferedImage base64ToBufferedImage(String base64) {
        Base64.Decoder decoder = Base64.getMimeDecoder();
        try {
            byte[] bytes1 = decoder.decode(base64);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bufferedImage = ImageIO.read(bais);
            return  bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将svg字符串转换为png
     *
     * @param svgFilePath svg路径
     * @param filePath 保存的路径
     * @throws TranscoderException svg代码异常
     * @throws IOException io错误
    **/
    public static String svgBase64ToPng(String base64, String filePath) throws IOException, TranscoderException {

        byte[] imageByte = base64.getBytes(StandardCharsets.UTF_8);
        //byte[] imageByte = getBytes(svgFilePath);
        /*Base64.Decoder decoder = Base64.getMimeDecoder();
        imageByte = decoder.decode(base64);*/
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
    /*    File file = new File("584269595368624129.svg");
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        Document doc = f.createDocument(file.toURI().toString());*/

        TranscoderInput inputSvgImage = new TranscoderInput(bis);

        PNGTranscoder converter = new PNGTranscoder();
        // 文件名称可根据自己的业务需求自定
    /*        String s = CommonUtil.generateUUID();
            String fileName = s + ".png";*/

        // 文件路径也可以根据自己的需求自定义
        File outputfile = new File(filePath);
        FileOutputStream pngFileStream = null;
        try {
            outputfile.createNewFile();
            pngFileStream = new FileOutputStream(outputfile);
            log.info(outputfile.getAbsolutePath());
            TranscoderOutput outputPngImage = new TranscoderOutput(pngFileStream);
            log.info("--------converter.transcode start-----------");
            converter.transcode(inputSvgImage, outputPngImage);
            pngFileStream.flush();
            log.info("--------converter.transcode end-----------");
            return filePath;
        }catch (TranscoderException e){
            log.info("error");
            log.error(e.getMessage());
            throw e;
        }catch (Exception e){
            log.info("error2");
            log.error(e.getMessage());
            throw e;
        }
        finally {

                if (pngFileStream != null) {
                    try {
                        pngFileStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }
    }



    public static BufferedImage ImageToBufferedImage(String filePath) throws IOException, TranscoderException {

        File outputfile = new File(filePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(outputfile);
            return  bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //图片到byte数组
    public static byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }


    private static byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }



    public static String replaceTxtByStr(String filePath) {
        String resultFileString="";

        try {
            File myFile=new File(filePath);

            if(!myFile.exists()){
                System.err.println("Can't Find " + filePath);

            }

            StringBuffer  returnString=new StringBuffer();

            InputStream inputStream=new FileInputStream(myFile);

            InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");

            BufferedReader in = new BufferedReader(isr);

            String str=null;

            while ((str = in.readLine()) != null)

            {
                returnString.append(str);

            }

            resultFileString=returnString.toString().replaceAll("′", "x").replaceAll("￡", "<=");

            in.close();

            isr.close();

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return resultFileString;

    }
}
