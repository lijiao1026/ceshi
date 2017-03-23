/*
 * 文 件 名:  GeneralConstant.java
 * 版    权:  Linkage Technology Co., Ltd. Copyright 2010-2011,  All rights reserved
 * 描    述:  全局常量类
 * 版    本： 1.0
 * 创 建 人:  xuyh
 * 创建时间:  2010-10-11
 */
package com.lj.constant;

/**
 * 全局常量类
 * @author lij
 *
 *
 */
public interface GeneralConstant
{
	
    /**
     * 系统默认编码格式
     */
    String CHARACTER_CODING = "UTF-8";
    
    /**
     * 验证码
     */
    String SESSION_CONFIRM_CODE = "confirmCode";
    
    /**
     * 12位时间格式 yyMMDDHHmmss 应用端时间戳使用
     */
    String DATETIME_12_A = "yyMMddHHmmss";
    
    /**
     * 15位时间格式 yyMMddHHmmssSSS 应用端时间戳使用
     */
    String DATETIME_15_A = "yyMMddHHmmssSSS";
    
    /**
     * 17位时间格式 yyyyMMddHHmmssSSS
     */
    String DATETIME_17 = "yyyyMMddHHmmssSSS";
    
    /**
     * 14位时间格式 yyyyMMddHHmmss
     */
    String DATETIME_14 = "yyyyMMddHHmmss";
    
    /**
     * 14位时间格式 yyyy-MM-dd HH:mm:ss
     */
    String DATETIME_14_COMMON = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 10位时间格式 日期部分 yyyy-MM-dd
     */
    String DATETIME_10 = "yyyy-MM-dd";
    
    /**
     * 8位时间格式 日期部分 yyyyMMdd
     */
    String DATETIME_8 = "yyyyMMdd";
    
    /**
     * 6位时间格式 日期部分 yyyymm
     */
    String DATE_6 = "yyyyMM";
    
    /**
     * 6位短日期格式 yymmdd
     */
    String DATE_SHORT_6 = "yyMMdd";
    
    /**
     * 8位日期格式 yyyy年MM月dd日
     */
    String DATETIME_8_CN = "yyyy年MM月dd日";
    
    /**
     * 6位时间格式 时间部分 HHmmss
     */
    String DATETIME_6 = "HHmmss";
    
    /**
     * 路径分割符
     */
    String SEPARATOR = "/";
    
    /**
     * 控制主菜单指向具体哪个div
     */
    String SESSION_DIVSHOW="session_divshow";
    
    /**
     * 一级菜单编号
     */
    String SESSION_TOPMENUCODE = "session_topmenucode";
    
    /**
     * 控制二级菜单指向具体哪个div
     */
    String SESSION_TWODIVSHOW="session_twodivshow";
    
    /**
     * 控制父菜单名称
     */
    String SESSION_PARENTNAME="session_parentname";
    /**
     * 分割符
     */
    String SPLIT_CHAR = ",";
    
    /**
     * 当前页码
     */
    int INIT_CURRENT_PAGE = 1;
    
    /**
     * SQL排序常量--升序，用作map中key对应的value， 
     * 举例appfile中对id，appid，fileName排序，可以map.put("id", SQL_SORT_ASC);map.put("appid",
     * SQL_SORT_DESC);map.put("fileName",SQL_SORT_DESC); 
     * 生成的order by 子句为：order by id asc, appid desc, fileName desc
     * 也可以这么放map.put("id, appid, fileName", SQL_SORT_DESC);
     * 会生成:order by id, appid, fileName desc 注意map中的value必须有"ASC",
     * "DESC"这些值，不能为null，也不能为其他值
     */
    String SQL_SORT_ASC = "ASC";
    
    /**
     * 排序条件 降序
     */
    String SQL_SORT_DESC = "DESC";
    
    /**
     * 日记配置文件名
     */
    String M2M_LOG = "M2M-log.xml";
    
    /**
     * 跳转url
     */
    String URL = "URL";
    
    /**
     * 每页记录数
     */
    String PAGESIZE = "pageSize";
    
    /**
     * 页码
     */
    String PAGENO = "pageNo";
    
    /**
     * 页面查询参数连接符(?)
     */
    String QUESTION_MARK = "?";
    
    /**
     * 等于
     */
    String EQUAL = "=";
    
    /**
     * 与号
     */
    String UNION_STRING = "&";
    /**
     * 业务ID
     */
    String SERVICE_ID = "serviceID";
    /**
     * 业务ID
     */
    String MODEL_SERVICE_ID = "service.id";
    
    /**
     * 路径分隔符
     */
    String PATH_SEPARATOR = "/";
    
    /**
     * 页面表单数据缓存对象
     */
    String PAGE_FROM_CACHE = "pageFormCache";
    
    /**
     * 页面表单数据缓存对象 Action对象缓存
     */
    String PAGE_FROM_OBJ_CACHE = "pageFormObjCache";
    
    /**
     * 登录用户信息
     */
    String SESSION_USER = "session_user";
    
    /**
     * 用户权限信息
     */
    String SESSION_PERMISSION = "session_permission";
    
    /**
     * 主菜单
     */
    String SESSION_FIRSRMENULIST = "session_firstmenulist";
    
    /**
     * 所有菜单
     */
    String SESSION_MENULIST = "session_menulist";
    
    /**
     * 列表页的开始页
     */
    int START_PAGE = 1;
    
    /**
     * 默认一页显示的记录数
     */
    int DEFAULT_PAGE_SIZE = 10;
    
    int DEFAULT_PAGE_SIZE_20 = 15;
}
