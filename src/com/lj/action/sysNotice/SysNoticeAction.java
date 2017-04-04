package com.lj.action.sysNotice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;
import com.lj.pojo.user.User;
import com.lj.service.sysNotice.SysNoticeService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 公告Action类
 * @author lij
 *
 *
 */
public class SysNoticeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysNoticeService sysNoticeService;
	
	public void setSysNoticeService(SysNoticeService sysNoticeService) {
		this.sysNoticeService = sysNoticeService;
	}
	/**
	 * 公告对象
	 */
	private SysNotice sysNotice;
	 /**
     * 当前页数
     */
    private Integer currPage = 1;
    /**
     * 公告集合
     */
	private List<SysNotice> sysNoticeList;
	/**
	 * 总页数
	 */
    private Integer totalPage;
    /**
     * 公告标题查询
     */
    private String searchNoticeTitle;
    /**
     * 提示消息
     */
	private String message;
	/**
	 * 公告序号
	 */
	private Integer serial;

	/**
	 * 查询
	 * @return
	 */
	public String queryList(){
  		try {
  			//因为用户类型为1的是用户 所以这里传入1
  			if(searchNoticeTitle==null||searchNoticeTitle.equals("")){
  				PageBean<SysNotice> pageBean = sysNoticeService.findByPage(currPage); 
  				sysNoticeList= pageBean.getList();
  	  			while(sysNoticeList.size()<10&&sysNoticeList.size()!=0){
  	  				SysNotice sysNotice=new SysNotice();
  	  				sysNotice=null;
  	  				sysNoticeList.add(sysNotice);
  	  			}
  	  			totalPage=pageBean.getTotalPage();
  			}else{
  			
  	  		PageBean<SysNotice> pageBean =sysNoticeService.findBySysNotice(currPage,searchNoticeTitle);	
				sysNoticeList= pageBean.getList();
	  			while(sysNoticeList.size()<10&&sysNoticeList.size()!=0){
	  				SysNotice sysNotice=new SysNotice();
	  				sysNotice=null;
	  				sysNoticeList.add(sysNotice);
	  			}
	  			totalPage=pageBean.getTotalCount();
  			}
  		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
  	public String toAdd(){
  		try {
  			return "toAdd";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  		
  	}
	/**
	 * 保存
	 * @return
	 */
	public String addSave(){
		if(sysNotice!=null){
			try {
				sysNotice.setCreateTime(getSysTime());
				sysNoticeService.saveSysNotice(sysNotice);
				
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "addSuccess";
	}
	
	/**
	 * 获取系统时间
	 * @return
	 */
    private String getSysTime()
    {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String SysTime = format.format(date);
        return SysTime;
    }
	/**
	 * 查看
	 * @return
	 */
	public String toDetail(){
		try {
			sysNotice = sysNoticeService.findByUid(serial);
			return "detail";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String toEdit(){
		try {
			sysNotice = sysNoticeService.findByUid(serial);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
  	 * 保存更新
  	 * @return
  	 */
  	public String editSave(){
  		if(sysNotice!=null){
			try {
				sysNotice.setCreateTime(getSysTime());
				sysNoticeService.saveUpdate(sysNotice);
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "editSuccess";
  	}
	
  	/**
	 * 删除公告
	 * @return
	 */
  	public String delete(){
  		try {
  			sysNotice = sysNoticeService.findByUid(serial);
  			sysNoticeService.delete(sysNotice);
  			message="1";
  			return "delete";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public SysNotice getSysNotice() {
		return sysNotice;
	}
	public void setSysNotice(SysNotice sysNotice) {
		this.sysNotice = sysNotice;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public List<SysNotice> getSysNoticeList() {
		return sysNoticeList;
	}
	public void setSysNoticeList(List<SysNotice> sysNoticeList) {
		this.sysNoticeList = sysNoticeList;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public String getSearchNoticeTitle() {
		return searchNoticeTitle;
	}
	public void setSearchNoticeTitle(String searchNoticeTitle) {
		this.searchNoticeTitle = searchNoticeTitle;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
	
}
