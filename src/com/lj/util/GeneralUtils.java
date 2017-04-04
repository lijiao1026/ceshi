/*
 * 文 件 名:  GeneralUtils.java
 * 
 * 描    述:  通用的工具类
 * 版    本： 1.0
 * 创 建 人:  yanjq
 * 创建时间:  2010-10-11
 */
package com.lj.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.validator.GenericValidator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

import com.lj.constant.GeneralConstant;







/**
 * 通用的工具类
 * @author  yanjq
 * @version  [1.0, Oct 11, 2010]
 */
public final class GeneralUtils
{
    
  
    
    /**
     * INT 数字7
     */
    public static final int NUM_7 = 7;
    
    /**
     * INT 数字15
     */
    public static final int NUM_15 = 15;
    
    /**
     * 十六进制0x4014
     */
    public static final int NUM_4129 = 0x1021;
    
    /**
     * 数字8
     */
    private static final int NUM_8 = 8;
    
    /**
     * 数字3
     */
    private static final int NUM_3 = 3;
    
    /**
     * 数字
     */
    private static final int NUM_2 = 2;
    
    /**
     * 数字4
     */
    private static final int NUM_4 = 4;
    
    /**
     * 数字6
     */
    private static final int NUM_6 = 6;
    
    /**
     * 数字16
     */
    private static final int NUM_16 = 16;
    
    /**
     * 数字255
     */
    private static final int NUM_255 = 255;
    
    /**
     * 数字1000
     */
    private static final int NUM_1000 = 1000;
    
    /**
     * 数字65535
     */
    private static final int NUM_65535 = 65535;
    
    /**
     * 十六进制的0xff
     */
    private static final int HEX_255 = 0xff;
    
    /**
     * 十六进制的0xff
     */
    private static final int OXFF = 0xff;
    
    /**
     * 十六进制的0xff
     */
    private static final int OXFFFF = 0xffff;
    
    /**
     * 抛长度异常

     */
    private static final String LENGTH_EXCEPTION = "抛长度异常!";
    
    /**
     * 格式不正确

     */
    private static final String FORMAT_EXCEPTION = "格式不正确!";
    
    /**
     * 不正确的数据长度
     */
    private static final String ERROR_LENGTH = "不正确的数据长度:";
    
    private GeneralUtils()
    {
        
    }
    
    /** 
     * 增加小数点控制
     * 控制数字的小数点
     * 
     * @param value - 需要修改的小数 
     * @param scale - 控制的精度
     * @param roundingMode - 取整模式
     * @return byteArray 计算后返回的数值
     * @author  yanjq
     */
    public static double round(double value, int scale, int roundingMode)
    {
        // 大数类
        BigDecimal bd = new BigDecimal(value);
        
        // 设置精度
        bd = bd.setScale(scale, roundingMode);
        
        // 进行运算
        double dValue = bd.doubleValue();
        
        return dValue;
    }
    
    /**
     * 判断对象是否为null , 为null返回true,否则返回false
     * @param obj 被判断的对象
     * @return boolean
     */
    public static boolean isNull(Object obj)
    {
        return (null == obj) ? true : false;
    }
    
    /**
     * 判断对象是否为null , 为null返回false,否则返回true
     *
     * @param obj 被判断的对象
     * @return boolean
     */
    public static boolean isNotNull(Object obj)
    {
        return !isNull(obj);
    }
    
    /**
     * 判断字符串是否为null或者0长度，字符串在判断长度时，先去除前后的空格,空或者0长度返回true,否则返回false
     *
     * @param str 被判断的字符串
     * @return boolean
     */
    public static boolean isNullOrZeroLenght(String str)
    {
        return GenericValidator.isBlankOrNull(str);
    }
    
    /**
     * 判断字符串是否为null或者0长度，字符串在判断长度时，先去除前后的空格,空或者0长度返回false,否则返回true
     *
     * @param str 被判断的字符串
     * @return boolean
     */
    public static boolean isNotNullOrZeroLenght(String str)
    {
        return !isNullOrZeroLenght(str);
    }
    
    /**
     * 判断str数组是否为null或者0长度，只要有一个空或者0长度返回false, 否则返回true
     *
     * @param str String 字符数组
     * @return boolean
     * @author  yanjq
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNotNullOrZeroLenght(String... str)
    {
        for (String s : str)
        {
            if (isNullOrZeroLenght(s))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 判断str数组是否为null或者0长度，只要有一个空或者0长度返回true, 否则返回false
     *
     * @param str String 字符数组
     * @return boolean
     * @author  yanjq
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNullOrZeroLenght(String... str)
    {
        return !isNotNullOrZeroLenght(str);
    }
    
    /**
     * 判断集合对象是否为null或者0大小 , 为空或0大小返回true ,否则返回false
     *
     * @param c collection 集合接口
     * @return boolean 布尔值
     * @author  yanjq
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNullOrZeroSize(Collection<? extends Object> c)
    {
        return isNull(c) || c.isEmpty();
    }
    
    /**
     * 判断集合对象是否为null或者0大小 , 为空或0大小返回false, 否则返回true
     *
     * @param c collection 集合接口
     * @return boolean 布尔值
     * @author  yanjq
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNotNullOrZeroSize(Collection<? extends Object> c)
    {
        return !isNullOrZeroSize(c);
    }
    
    /**
     * 判断数字类型是否为null或者0，如果是返回true，否则返回false
     *
     * @param number 被判断的数字
     * @return boolean
     */
    public static boolean isNullOrZero(Number number)
    {
        if (GeneralUtils.isNotNull(number))
        {
            return (number.doubleValue() != 0) ? false : true;
        }
        return true;
    }
    
    /**
     * 判断数字类型是否不为null或者0，如果是返回true，否则返回false
     *
     * @param number 被判断的数字
     * @return boolean
     */
    public static boolean isNotNullOrZero(Number number)
    {
        return !isNullOrZero(number);
    }
    
    /**
     * 将java.util.Date类型转化位String类型
     *
     * @param date 要转换的时间
     * @param format 时间格式
     * @return 如果转换成功，返回指定格式字符串，如果转换失败，返回null
     */
    public static String date2String(Date date, String format)
    {
        if (GeneralUtils.isNull(date) || GeneralUtils.isNull(format))
        {
            return null;
        }
        
        return DateFormatUtils.format(date, format);
    }
    
    /**
     * 将字符串时间转换成java.util.Date类型
     * @param str 要转换的字符串
     * @param format 时间格式
     * @return 如果转换失败，返回null
     */
    public static Date string2Date(String str, String format)
    {
        if (GeneralUtils.isNull(str) || GeneralUtils.isNull(format))
        {
            return null;
        }
        
        // 定义日期/时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date;
        
        try
        {
            // 转换日期/时间格式
            date = sdf.parse(str);
            // 判断转换前后时间是否一致
            
            if (!str.equals(sdf.format(date)))
            {
                date = null;
            }
        }
        catch (ParseException e)
        {
            date = null;
        }
        
        return date;
    }
    
    /**
     * 验证日期/时间格式
     * @param dateStr 待验证的字符串
     * @param format 类型
     * @return 是返回ture,否则返回false
     */
    public static boolean isDateTime(String dateStr, String format)
    {
        return GenericValidator.isDate(dateStr, format, true);
    }
    
    /**
     * 判断字符串长度，范围包含min和max的值
     *
     * @param str String
     * @param min 最小范围
     * @param max 最大范围
     * @return boolean
     */
    public static boolean isInRange(String str, int min, int max)
    {
        if (GeneralUtils.isNull(str))
        {
            return false;
        }
        
        try
        {
            int len = str.trim().getBytes(GeneralConstant.CHARACTER_CODING).length;
            return GenericValidator.isInRange(len, min, max);
        }
        catch (UnsupportedEncodingException e)
        {
            return false;
        }
    }
    
    /**
     * 判断字符串是否超过最大长度
     * @param str String
     * @param max 最大长度
     * @return boolean
     */
    public static boolean maxLength(String str, int max)
    {
        return isInRange(str, 0, max);
    }
    
    /**
     * 判断字符串是否低于最小长度
     * @param str String
     * @param min 最小长度
     * @return boolean
     */
    public static boolean minLength(String str, int min)
    {
        return isInRange(str, min, Integer.MAX_VALUE);
    }
    
    /**
     * 获取目录在系统中的绝对路径
     * @param path 路径
     * @return Sting
     */
    public static String getAbsolutePath(String path)
    {
        // 如果路进为null，则认为时当前目录
        
        path = (GeneralUtils.isNull(path)) ? "" : path;
        File file = new File(path);
        
        // 获取完整路径
        return FilenameUtils.separatorsToUnix(file.getAbsolutePath());
    }
    
    /**
     * 将字符串首字符待大写
     * @param str 源字符串
     * @return 首字符大写后的字符串
     * @see [类、类#方法、类#成员]
     */
    public static String firstCharUpper(String str)
    {
        char firstChar = CharUtils.toChar(str);
        String upFirstChar = StringUtils.upperCase(String.valueOf(firstChar));
        return StringUtils.replaceOnce(str, String.valueOf(firstChar), upFirstChar);
    }
    
    /**
     * Object - > String
     * @param obj  对象参数
     * @return  String 字符串
     */
    public static String object2String(Object obj)
    {
        if (isNull(obj))
        {
            return "";
        }
        else
        {
            return obj.toString();
        }
    }
    
    /**
     * 返回当前的时间戳
     * @return 时间戳
     */
    public static String getCurrentTimeStamp()
    {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
    /**
     * 返回当前时间戳
     * @param pattern 默认为：yyyyMMddHHmmss
     * @return string  时间字符串
     */
    public static String getCurrentTimeStamp(String pattern)
    {
        if (isNullOrZeroLenght(pattern))
        {
            pattern = GeneralConstant.DATETIME_14;
        }
        Date date = new Date(System.currentTimeMillis());
        return date2String(date, pattern);
    }
    
    /**
     * 返回当前时间戳
     * @return 17位时间戳表示
     */
    public static String getCurrentTimeStamp17Bit()
    {
        Date date = new Date(System.currentTimeMillis());
        return date2String(date, GeneralConstant.DATETIME_17);
    }
    
    /**
     * 返回当前时间戳
     * @return 12位时间戳表示
     */
    public static String getCurrentTimeStamp12Bit()
    {
        Date date = new Date(System.currentTimeMillis());
        return date2String(date, GeneralConstant.DATETIME_12_A);
    }
    
    /**
     * 根据格式和间隔时间返回系统当前日期N天前或者N天后的日期
     * @param pattan 格式化时间
     * @param days 间隔时间 正数代表之后的日期，负数代表之前的日期
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getNSystemTime(String pattan, int days)
    {
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, days);
        Date date = currentDate.getTime();
        SimpleDateFormat df = new SimpleDateFormat(pattan);
        String preDay = df.format(date);
        return preDay;
    }
    
    /**
     * 根据格式化字符获取时间
     * @param dateStr 字符串时间
     * @param pattern 格式化方式
     * @return Date Date
     */
    public static Date getDate(String dateStr, String pattern)
    {
        Date date = null;
        try
        {
            date = new SimpleDateFormat(pattern).parse(dateStr);
        }
        catch (ParseException e)
        {
            return null;
        }
        return date;
    }
    
    /**
     * 拼装文件路径
     * @param basePath 文件路径
     * @param fullFilenameToAdd 文件名或带部分路径的文件名
     * @return 返回处理后的字符串
     */
    public static String filePathConcat(String basePath, String fullFilenameToAdd)
    {
        String path1 = FilenameUtils.separatorsToUnix(GeneralUtils.isNull(basePath) ? "" : basePath);
        String path2 = FilenameUtils.separatorsToUnix(GeneralUtils.isNull(fullFilenameToAdd) ? "" : fullFilenameToAdd);
        
        if (GeneralUtils.isNullOrZeroLenght(path1))
        {
            return path2;
        }
        
        if ((path1.length() - 1) == StringUtils.lastIndexOf(path1, GeneralConstant.SEPARATOR))
        {
            path1 = StringUtils.substring(path1, 0, path1.length() - 1);
        }
        
        if (0 == StringUtils.indexOf(path2, GeneralConstant.SEPARATOR))
        {
            path2 = StringUtils.substring(path2, 1);
        }
        
        return path1 + GeneralConstant.SEPARATOR + path2;
        
    }
    
 
    
    /**
     * int转换2进制
     * @see [类、类#方法、类#成员]
     */
    public static int getBinaryMask(long mask, int index)
    {
        return (int)(mask >> index) & 0x00000001;
    }
    
    /**
     * 生成EXCEL
     * @param filePath 文件路径
     * @param xlContents 需要生成的内容
     * @param cellConfig 配置
     * @see [类、类#方法、类#成员]
     */
    public static void createExcel(String filePath, List<Object> xlContents, int[] cellConfig)
    {
        File f = new File(filePath);
        int[] widthConfig = new int[cellConfig.length];
        int widthTemp = 0;
        
        try
        {
            WritableWorkbook book = Workbook.createWorkbook(f);
            WritableSheet sheet = book.createSheet("sheet", 0);
            //保护
            sheet.getSettings().setProtected(true);
            //保护密码
            sheet.getSettings().setPassword("ls");
            //冻结标题
            sheet.getSettings().setVerticalFreeze(1);
            
            for (int i = 0; i < xlContents.size(); i++)
            {
                Object iContents = xlContents.get(i);
                
                if (iContents instanceof String[])
                {
                    for (int j = 0; j < ((String[])iContents).length; j++)
                    {
                        WritableCellFormat wcf = new WritableCellFormat();
                        wcf.setAlignment(jxl.format.Alignment.CENTRE);
                        
                        Label label = new Label(j, i, ((String[])iContents)[j], wcf);
                        sheet.addCell(label);
                        
                        widthTemp = String.valueOf(((String[])iContents)[j]).getBytes("GBK").length + 1;
                        if (widthTemp > widthConfig[j])
                        {
                            widthConfig[j] = widthTemp;
                        }
                    }
                }
                else
                {
                    for (int j = 0; j < ((List<?>)iContents).size(); j++)
                    {
                        Object obj = ((List<?>)iContents).get(j);
                        
                        WritableCellFormat wcf = new WritableCellFormat();
                        if (cellConfig[j] == 1)
                        {
                            wcf.setLocked(true);
                        }
                        else
                        {
                            wcf.setLocked(false);
                        }
                        
                        if (obj instanceof Double)
                        {
                            jxl.write.Number number = new jxl.write.Number(j, i, (Double)obj, wcf);
                            sheet.addCell(number);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                        else if (obj instanceof Integer)
                        {
                            jxl.write.Number number = new jxl.write.Number(j, i, (Integer)obj, wcf);
                            sheet.addCell(number);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                        else if (obj instanceof Long)
                        {
                            jxl.write.Number number = new jxl.write.Number(j, i, (Long)obj, wcf);
                            sheet.addCell(number);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                        else
                        {
                            Label label = new Label(j, i, (String)obj, wcf);
                            sheet.addCell(label);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < widthConfig.length; i++)
            {
                sheet.setColumnView(i, widthConfig[i]);
                //System.out.println(widthConfig[i]);
            }
            
            book.write();
            book.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 生成Excel
     * 同时写入os中
     * @param os  
     * @param xlContents 需要生成的内容
     * @param cellConfig 配置
     * @param totalMoney 总计
     * @param param   备份参数
     * @see [类、类#方法、类#成员]
     */
    public static void createExcelAndRet0utDataStream(OutputStream os, List<Object> xlContents, int[] cellConfig,
        Double totalMoney, String param)
    {
        
        int[] widthConfig = new int[cellConfig.length];
        int widthTemp = 0;
        try
        {
            WritableWorkbook book = Workbook.createWorkbook(os);
            WritableSheet sheet = book.createSheet("sheet", 0);
            //保护
            sheet.getSettings().setProtected(true);
            //保护密码
            sheet.getSettings().setPassword("ls");
            //冻结标题
            sheet.getSettings().setVerticalFreeze(1);
            
            for (int i = 0; i < xlContents.size(); i++)
            {
                Object iContents = xlContents.get(i);
                
                if (iContents instanceof String[])
                {
                    for (int j = 0; j < ((String[])iContents).length; j++)
                    {
                        WritableCellFormat wcf = new WritableCellFormat();
                        wcf.setAlignment(jxl.format.Alignment.CENTRE);
                        
                        Label label = new Label(j, i, ((String[])iContents)[j], wcf);
                        sheet.addCell(label);
                        
                        widthTemp = String.valueOf(((String[])iContents)[j]).getBytes("GBK").length + 1;
                        if (widthTemp > widthConfig[j])
                        {
                            widthConfig[j] = widthTemp;
                        }
                    }
                }
                else
                {
                    for (int j = 0; j < ((List<?>)iContents).size(); j++)
                    {
                        Object obj = ((List<?>)iContents).get(j);
                        
                        WritableCellFormat wcf = new WritableCellFormat();
                        if (cellConfig[j] == 1)
                        {
                            wcf.setLocked(true);
                        }
                        else
                        {
                            wcf.setLocked(false);
                        }
                        
                        if (obj instanceof Double)
                        {
                            jxl.write.Number number = new jxl.write.Number(j, i, (Double)obj, wcf);
                            sheet.addCell(number);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                        else if (obj instanceof Integer)
                        {
                            jxl.write.Number number = new jxl.write.Number(j, i, (Integer)obj, wcf);
                            sheet.addCell(number);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                        else if (obj instanceof Long)
                        {
                            jxl.write.Number number = new jxl.write.Number(j, i, (Long)obj, wcf);
                            sheet.addCell(number);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                        else
                        {
                            Label label = new Label(j, i, (String)obj, wcf);
                            sheet.addCell(label);
                            
                            widthTemp = String.valueOf(obj).getBytes("GBK").length + 1;
                            if (widthTemp > widthConfig[j])
                            {
                                widthConfig[j] = widthTemp;
                            }
                        }
                    }
                }
            }
            
            if (GeneralUtils.isNotNull(param) && "suppProdSell".equals(param))
            {
                WritableFont font1 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
                WritableCellFormat wcf1 = new WritableCellFormat(font1);
                wcf1.setAlignment(jxl.format.Alignment.RIGHT);
                
                String obj = "总计(元)：" + String.valueOf(totalMoney) + "元";
                Label label = new Label(0, xlContents.size(), (String)obj, wcf1);
                sheet.mergeCells(0, xlContents.size(), cellConfig.length - 1, xlContents.size());
                sheet.addCell(label);
            }
            for (int i = 0; i < widthConfig.length; i++)
            {
                sheet.setColumnView(i, widthConfig[i]);
                //System.out.println(widthConfig[i]);
            }
            
            book.write();
            book.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 讲字符串转换成byte数组
     * @param str 字符串
     * @return 转换后的byte数组
     */
    public static byte[] stringToBytes(String str)
    {
        try
        {
            if (GeneralUtils.isNotNull(str))
            {
                return str.getBytes(GeneralConstant.CHARACTER_CODING);
            }
            else
            {
                return new byte[0];
            }
            
        }
        catch (UnsupportedEncodingException e)
        {
            // 该异常不会发生
            
            return new byte[0];
        }
    }
    
    /**
     * 讲byte[]转换成字符窜
     * @param arr byte数组
     * @return 转换后的字符串
     */
    public static String bytesToSting(byte[] arr)
    {
        try
        {
            return new String(arr, GeneralConstant.CHARACTER_CODING);
        }
        catch (UnsupportedEncodingException e)
        {
            // 该异常不会发生
            
            return "";
        }
    }
    
    /**
     * 大字段转字符串
     * 
     * @param clob 大字段对象
     * @return 字符串
     * @throws Exception 异常
     */
    public static String clobToString(java.sql.Clob clob)
        throws Exception
    {
        if (isNull(clob))
        {
            return " ";
        }
        StringBuffer sb2 = new StringBuffer();
        Reader instream = null;
        instream = clob.getCharacterStream();
        BufferedReader in = new BufferedReader(instream);
        String line = null;
        while ((line = in.readLine()) != null)
        {
            sb2.append(line);
        }
        return sb2.toString();
    }
    
    /**
     * 数量格式化工具
     * 如果是1.0则格式化为1
     * 如果是1.10则格式化为1.1
     * @param number 数字
     * @return 数字字符串
     * @see [类、类#方法、类#成员]
     */
    public static String doubleToIntString(double number)
    {
        String numStr = String.valueOf(number);
        if (numStr.endsWith(".0"))
        {
            numStr = numStr.substring(0, numStr.indexOf(".0"));
        }
        return numStr;
    }
    
    /**
     * 格式化GOOGLE地图返回的经纬度串
     * 源字符串格式为"（111.9009,98.47498）"
     * 转换过后格式为"111.9009,98.47498"
     * @param latlng
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String formatGoogleLatlng(String latlng)
    {
        if (GeneralUtils.isNotNullOrZeroLenght(latlng))
        {
            return latlng.replace("(", "").replace(")", "");
        }
        return null;
    }
    
    public static String numberFormat(Double d)
    {
        if (null != d)
        {
            DecimalFormat df = new DecimalFormat();
            String style = "#,##0.00#";
            df.applyPattern(style);
            return df.format(d);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 获取当前日期的前一天的时间,如：20120410235959
     * 
     * @return
     * @throws Exception
     */
    public static String createLastDayfStr()
        throws Exception
    {
        StringBuilder sb = new StringBuilder();
        
        Calendar rightNow = Calendar.getInstance();
        
        rightNow.add(Calendar.DATE, -1);
        
        sb.append(rightNow.get(Calendar.YEAR));
        
        int currentMonth = rightNow.get(Calendar.MONTH)+1;
        
        if(currentMonth < 10)
        {
            sb.append("0");
        }
        
        sb.append(currentMonth);
        
        int date = rightNow.get(Calendar.DATE);
        
        if(date < 10)
        {
            sb.append("0");
        }
        
        sb.append(date);
        
        sb.append("235959");
        
        return sb.toString();
    }
    
    /**
     * 计算时间差 time2-time1
     * @param unit 返回的日期格式 <br/>
     *             d:天 h:天-小时 m:天-小时-分 s:天-小时-分-秒<br/>
     *             H:小时-分-秒 M:分-秒 Hm:小时-分
     * @param time1 时间1 格式务必为(yyyyyMMddHHmmss )（被减数）
     * @param time2 时间2 格式务必为(yyyyMMddHHmmss )（减数）
     * @return 时间差
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    public static String calcTimeDiff(String unit, String time1, String time2)
        throws Exception
    {
        //时间单位(如：不足1天(24小时) 则返回0)，开始时间，结束时间
        Date date1 = new SimpleDateFormat("yyyyMMddHHmmss").parse(time1);
        Date date2 = new SimpleDateFormat("yyyyMMddHHmmss").parse(time2);
        long ltime =
            date1.getTime() - date2.getTime() < 0 ? date2.getTime() - date1.getTime() : date1.getTime()
                - date2.getTime();
        //返回天数
        long dnum = ltime / 86400000;
        //返回秒
        long secnum = ltime / 1000;
        long hnum = 0;
        long mnum = 0;
        long snum = 0;
        if (secnum < 86400)
            dnum = 0;
        long sd = dnum * 24 * 3600;
        long sh = secnum - sd;
        hnum = sh / 3600;
        long sm = sh - hnum * 3600;
        mnum = sm / 60;
        snum = sm - mnum * 60;
        if (unit.equals("d"))
        {
            return dnum + "天";
        }
        else if (unit.equals("h"))
        {
            return dnum + "天" + hnum + "小时";
        }
        else if (unit.equals("m"))
        {
            return dnum + "天" + hnum + "小时" + mnum + "分";
        }
        else if (unit.equals("s"))
        {
            return dnum + "天" + hnum + "小时" + mnum + "分" + snum + "秒";
        }
        else if (unit.equals("H"))
        {
            return dnum * 24 + hnum + "小时" + mnum + "分" + snum + "秒";
        }
        else if (unit.equals("M"))
        {
            return (dnum * 24 + hnum) * 60 + "分" + snum + "秒";
        }
        else if (unit.equals("Hm"))
        {
            return dnum * 24 + hnum + "小时" + mnum + "分";
        }
        else
        {
            return dnum + "天" + hnum + "小时" + mnum + "分" + snum + "秒";
        }
    }
//    public static void main(String[] args) throws Exception
//    {
//        String currentDate=  GeneralUtils.getCurrentTimeStamp(null);
//
////      System.out.println(  calcTimeMinutes("20160701091400",currentDate));
//      System.out.println(  calcTimeMinutes("20160701100000",currentDate));
//    }
    public static long calcTimeMinutes( String reqTime, String nowTime)
    throws Exception
    {
//        java.text.DateFormat df = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
//        java.util.Calendar c1 = java.util.Calendar.getInstance();
//        java.util.Calendar c2 = java.util.Calendar.getInstance();
//        try
//        {
//            c1.setTime(df.parse(time1));
//            
//            c2.setTime(df.parse(time2));
//        }
//        catch (java.text.ParseException e)
//        {
//            System.err.println("格式不正确");
//        }
//        int result = c1.compareTo(c2);
//        return result;
            //时间单位(如：不足1天(24小时) 则返回0)，开始时间，结束时间
        
            Date reqDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(reqTime);
            Date nowDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(nowTime);
            long ltime =reqDate.getTime()- nowDate.getTime();
//            System.out.println("ltime:"+ltime/1000);
//            System.out.println("ltime2:"+ltime/1000/60);
            return ltime/1000/60;
            
//            if(ltime>=0){
//                return 0;
//            }
//            //返回天数
//            long dnum = ltime / 86400000;
//            //返回秒
//            long secnum = ltime / 1000;
//            long hnum = 0;
//            long mnum = 0;
//            if (secnum < 86400)
//                dnum = 0;
//            long sd = dnum * 24 * 3600;
//            long sh = secnum - sd;
//            hnum = sh / 3600;
//            long sm = sh - hnum * 3600;
//            mnum = sm / 60;
//            secnum=secnum / 60;
//            return secnum;
        
    }
    /**
     * 
     * 2个时间，计算相差小时
     * <功能详细描述>
     * @param time1
     * @param time2
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static long calcTimeDiffHour(String time1, String time2)
    throws Exception
{
    //时间单位(如：不足1天(24小时) 则返回0)，开始时间，结束时间
    Date date1 = new SimpleDateFormat("yyyyMMddHHmmss").parse(time1);
    Date date2 = new SimpleDateFormat("yyyyMMddHHmmss").parse(time2);
    long ltime =
        date1.getTime() - date2.getTime() < 0 ? date2.getTime() - date1.getTime() : date1.getTime()
            - date2.getTime();
    //返回天数
    long dnum = ltime / 86400000;
    //返回秒
    long secnum = ltime / 1000;
    long hnum = 0;
    if (secnum < 86400)
        dnum = 0;
    long sd = dnum * 24 * 3600;
    long sh = secnum - sd;
    hnum = sh / 3600;
    return hnum;
   
}
    
    /**
     * 获取当前时间的上一个月同等时间
     * 
     * @return String 时间格式:YYYYMMDDHHMMSS
     * @throws Exception Exception
     */
    public static String createLastMonthTime()
        throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        long timeMillis = calendar.getTimeInMillis() - 2592000000l;
        calendar.setTimeInMillis(timeMillis);
        
        return GeneralUtils.date2String(calendar.getTime(), GeneralConstant.DATETIME_14);
    }
    
    /**
     * 获取当前时间的上一个月同等时间差
     * 
     * @return String 时间格式:YYYYMMDDHHMMSS
     * @throws Exception Exception
     */
    public static long getIntervalDays(Date fDate, Date oDate)
    {
        
        if (null == fDate || null == oDate)
        {
            
            return -1;
        }
        
        long intervalMilli = oDate.getTime() - fDate.getTime();
        
        return intervalMilli;
    }
    /**
     * 16进制转2进制 字符串长度为2的倍数
     * @param hexString 16进制字符串 长度为2的倍数
     * @return 2进制字符串
     */
    public static String hexStr2binaryStr(String hexString)
    {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++)
        {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }
    /**
     * 二进制转16进制 
     * @param bString 二进制字符串,长度为8的倍数
     * @return 16进制字符串
     */
    public static String binaryStr2hexStr(String bString)
    {
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)
            return null;
        StringBuffer tmp = new StringBuffer();
        int iTmp = 0;
        for (int i = 0; i < bString.length(); i += 4)
        {
            iTmp = 0;
            for (int j = 0; j < 4; j++)
            {
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
            }
            tmp.append(Integer.toHexString(iTmp));
        }
        return tmp.toString();
    }
    
    /**
     * 将0x开头的4位16进制字符串转换为Integer类型的数字

     * @param str 字符串

     * @return Integer
     */
    public static Integer hexString2Ingeter(String str)
    {
        if (isNull(str) || str.length() != NUM_6 || (!StringUtils.equals("0x", str.substring(0, NUM_2))))
        {
            throw new NumberFormatException(FORMAT_EXCEPTION);
        }
        return Integer.parseInt(str.substring(NUM_2, NUM_6), NUM_16);
    }
    /**
     * 创建通用的Head节点
     * @param headInfo
     * @return Element 节点
     */
    public static Element createHeadElement()
    {
        Element head = new Element("Head");
        //消息流水号
        int sid = 0;
        head.addContent(new Element("Sid").setText(String.valueOf(sid)));
        head.addContent(new Element("Timestamp").setText(GeneralUtils.getCurrentTimeStamp(null)));
        head.addContent(new Element("Serviceid").setText("100"));
        head.addContent(new Element("Version").setText("v1.0"));
        
        return head;
    }
    
    /**
     * 创建Body节点
     * 
     * @param elementMap Body元素Map
     * @return Element body节点<Body>....</Body>
     */
    public static Element createBodyElement(Map<String, String> elementMap)
    {
        //判断是否含有元素
        if (elementMap == null || elementMap.size() == 0)
        {
            return null;
        }
        
        Element body = new Element("Body");
        
        Set<Entry<String, String>> entrySet = elementMap.entrySet();
        
        for (Entry<String, String> entryObj : entrySet)
        {
            body.addContent(new Element(entryObj.getKey()).setText(entryObj.getValue()));
        }
        
        return body;
    }
    
    /**
     * 将XML转换成String
     * 
     * @param root xml文档 
     * @return String xmlString
     */
    public static String createXmltoString(Element root)
    {
        Document doc = new Document(root);
        
        XMLOutputter out;
        
        Format format = Format.getCompactFormat();
        
        //setEncoding 设置编码
        format.setEncoding("utf-8");
        
        //setIndent 设置分隔符 自动换行并缩进
        //如果这样写setIndent("")，就只有换行功能，而不会缩进了，如果写成setIndent(null)，这样就即不换行也不缩进，全部以一行显示了，默认的就是这样的效果。
        format.setIndent(" ");
        
        out = new XMLOutputter(format);
        
        return out.outputString(doc);
    }
    
    /**
     * 创建消息XML文档
     * 
     * @param rootName 根节点名称
     * @param elementMap 消息体元素键值对
     * @return String XML字符串
     */
    public static String createXmlDoc(String rootName, Map<String, String> elementMap)
    {
        Element root = new Element(rootName);
        
        Element head = createHeadElement();
        
        Element body = createBodyElement(elementMap);
        
        Element hash = new Element("Hash").setText("hash");
        
        root.addContent(head);
        root.addContent(body);
        root.addContent(hash);

        return createXmltoString(root);
        
    }
    
 
    /**
     * 解析消息结果
     * 
     * @param xml XML字符串
     * @return String 结果码
     * @throws Exception Exception
     */
    public static String parseMsgXml(String xml)
        throws Exception
    {
        // 创建一个新的字符串
        StringReader read = new StringReader(xml);
        
        // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        
        // 创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        
        // 通过输入源构造一个Document
        Document doc = sb.build(source);
        
        Element root = doc.getRootElement();
        
        String resultCode = root.getChild("Body").getChild("ResultCode").getText();
        
        return resultCode;
    }
    
    /**
     * 将16进制数字符串类型转换成字节数组

     * @param value 16进制数字符串表现形式
     * @return byte[]
     * @see [类、类#方法、类#成员]
     */
    public static byte[] hexString2ByteArray(String value)
    {
        if (value.length() % NUM_2 != 0)
        {
            throw new IllegalStateException(value + ERROR_LENGTH + value.length());
        }
        byte[] returnValue = new byte[value.length() / NUM_2];
        try
        {
            byte[] bytes = value.getBytes(GeneralConstant.CHARACTER_CODING);
            for (int i = 0, j = 0; i < bytes.length; i += NUM_2, j++)
            {
                returnValue[j] = (byte)Integer.parseInt(new String(new byte[] {bytes[i], bytes[i + 1]}), NUM_16);
            }
        }
        catch (UnsupportedEncodingException e)
        {
            return null;
        }
        return returnValue;
    }
    
    /**
     * 
     * 判断上报的位置信息，是否定位成功
     * 
     * @param hexState TL_LOCATION_HISTORY表中STATUS_HEX_STR字段
     * @return true 表示定位成功;flase 表示定位不成功
     */
    public static boolean isGpsValid(String hexState)
    {
        if(GeneralUtils.isNullOrZeroLenght(hexState))
        {
            return false;
        }
        
        byte[] bytes = GeneralUtils.hexString2ByteArray(hexState);
        
        int state = ((bytes[bytes.length-1] & 0x02)>>1);
        
        if(state==1)
        {
            return true;
        }
        else
        {
            return false;
        }     
                
    }
    /**
	 * 数字不足位数补0
	 * @param str
	 * @param strLength
	 * @param isLeft	为true时，左补；否则，右补
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength,Boolean isLeft) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				str = isLeft ?  sb.append("0").append(str).toString() : sb.append(str).append("0").toString();
				strLen = str.length();
			}
		}
		return str;
	}
	
	/**
	 * 数字不足位数左补0
	 * @param str
	 * @param strLength
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength) {
		return addZeroForNum(str, strLength,true);
	}
	
	public static String addZeroForNum(Integer i, int strLength) {
		return addZeroForNum(i.toString(), strLength,true);
	}
	static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
	public static  Map<String, Double> bd_encrypt(double gg_lat, double gg_lon)
	{
		Double x = gg_lon, y = gg_lat;
		Double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		Double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		Double bd_lon = z * Math.cos(theta) + 0.0065;
		Double bd_lat = z * Math.sin(theta) + 0.006;
		
		 Map<String, Double> map = new HashMap<String, Double>();
	        map.put("bd_lon", bd_lon);
	        map.put("bd_lat", bd_lat);
	        return map;
	}
}
