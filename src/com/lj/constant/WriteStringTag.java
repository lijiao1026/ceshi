 
package com.lj.constant;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import com.lj.util.GeneralUtils;



/**
 * bean:wirte标签重写
 * @author  yanjq
 * @version 1.0
 */
public class WriteStringTag extends BodyTagSupport
{
    
    private static final long serialVersionUID = -3799653730218351416L;
    
    private static final int NUM_8 = 8;
    
    private static final int NUM_14 = 14;
    
    private static final int NUM_17 = 17;
    
    /**
     * 字符串截取长度
     */
    private int length = -1;
    
    /**
     * 是否需要以省略号显示
     */
    private boolean ellipsis;
    
    /**
     * 格式化字符表达式
     */
    private String formatStr;
    
    /**
     * 格式化字符表达式
     */
    private Object property;
    
    public boolean isEllipsis()
    {
        return ellipsis;
    }
    
    public void setEllipsis(boolean ellipsis)
    {
        this.ellipsis = ellipsis;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public void setLength(int length)
    {
        this.length = length;
    }
    
    public String getFormatStr()
    {
        return formatStr;
    }
    
    public void setFormatStr(String formatStr)
    {
        this.formatStr = formatStr;
    }
    
    public Object getProperty()
    {
        return property;
    }
    
    public void setProperty(Object property)
    {
        this.property = property;
    }
    
    /**
     * 重写格式化方法，提供对于字符串的截取、格式化为日期格式功能 <br>
     * <br>
     * 字符串格式化时采取最短长度策略,即: <br>
     * 如果原始字符串比格式化字符串短，则依据原始字符串的长度进行格式化；否则，依据格式化字符串的长度格式化； <br>
     * 示例1: <br>
     * 原始字符串："200812" <br>
     * 格式化字符串："####-##-##" <br>
     * 格式化后输出："2008-12" <br>
     * <br>
     * 示例2: <br>
     * 原始字符串："20081202000000" <br>
     * 格式化字符串："####-##-##" <br>
     * 格式化后输出："2008-12-02"
     * 
     
     * @return String       - 格式化后字符串
     * @throws JspException
     *             JspException
     * @see org.apache.struts.taglib.bean.WriteTag#formatValue(java.lang.Object)
     */
    
    public int doStartTag() throws JspException
    {
        Object value = property;
        String formatString = formatStr;
        
        String priStr = "";
        
        if (value instanceof java.lang.String)
        {
            String strValue = ((String)value).trim();
            
            if (length > 0)
            {
                strValue = StringUtils.substring(strValue, 0, length);
                
                if (ellipsis && (((String)value).length() > length))
                {
                    strValue = strValue + "...";
                }
            }
            
            if (!StringUtils.isBlank(formatString) && StringUtils.contains(formatString, '#'))
            {
                StringBuffer strCache = new StringBuffer(strValue);
                
                // 输出字符串的有效长度
                int outputStrLen = strValue.length();
                for (int i = 0; i < formatString.length(); i++)
                {
                    if (i >= strCache.length())
                    {
                        break;
                    }
                    else if (!ObjectUtils.equals('#', formatString.charAt(i)))
                    {
                        outputStrLen++;
                        strCache.insert(i, formatString.charAt(i));
                    }
                }
                
                if (outputStrLen > formatString.length())
                {
                    outputStrLen = formatString.length();
                }
                
                strValue = strCache.substring(0, outputStrLen);
            }
            else if (!StringUtils.isBlank(formatString) && !StringUtils.contains(formatString, '#'))
            {
                //为了减少圈复杂度，将里面的逻辑用一个方法代替
                
                strValue = containsOfChar(strValue, formatString);
            }
            
            priStr = strValue;
            
        }
        else
        {
            if (GeneralUtils.isNotNull(value))
            {
                priStr = String.valueOf(property);
            }
        }
        
        try
        {
            pageContext.getOut().print(priStr);
        }
        catch (IOException e)
        {
            e.getMessage();
        }
        
        return super.doStartTag();
    }
    
    /**
     * 根据指定的格式化字符串进行格式化
     * @param strValue - 字符串值     * @param formatString - 格式化字符串
     * @return - 格式化以后的数据
     */
    private String containsOfChar(String strValue, String formatString)
    {
        String returnstr = "";
        
        Date date = null;
        if (NUM_8 == strValue.length())
        {
            date = GeneralUtils.string2Date(strValue, GeneralConstant.DATETIME_8);
        }
        else if (NUM_14 == strValue.length())
        {
            date = GeneralUtils.string2Date(strValue, GeneralConstant.DATETIME_14);
        }
        else if (NUM_17 == strValue.length())
        {
            date = GeneralUtils.string2Date(strValue, GeneralConstant.DATETIME_17);
        }
        
        if (GeneralUtils.isNotNull(date))
        {
            returnstr = GeneralUtils.date2String(date, formatString);
        }
        
        return returnstr;
    }
}