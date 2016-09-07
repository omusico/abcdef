package com.lvmama.lvf.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * Gzip压缩解压的方法
 */
public class GzipUtil {
/**
 * @param args
 */
    /**
     * gZip解压方法
     */
    public static byte[] unGZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            gzip.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }

    /**
     * 将得到的返回结果进行处理，先BASE64解密，再Gzip解压
     *
     * @param responseContent
     * @return
     * @throws IOException
     */
    public static String getResponse(String responseContent) throws IOException {
        return new String(unGZip(org.apache.commons.codec.binary.Base64.decodeBase64(responseContent.getBytes("GBK"))),"UTF-8");
    }
}