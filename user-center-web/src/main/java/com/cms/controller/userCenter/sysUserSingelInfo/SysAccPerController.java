package com.cms.controller.userCenter.sysUserSingelInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.userCenter.SysUserSingelInfoService;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserSingelInfo;
import com.cms.service.fastdfs.FastdfsClient;
import com.cms.service.fastdfs.FastdfsClientFactory;


@Controller
@RequestMapping("/sysUserSingelInfo")
public class SysAccPerController {
	//注入个人信息服务
	@Autowired
	private SysUserSingelInfoService sysUserSingelInfoService;
	@Autowired
	private GlobalIdService globalIdService;
	@RequestMapping("/shouye")
	public ModelAndView shouye(){
		ModelAndView model = new ModelAndView();
		model.setViewName("account-mana-per");
		return model;
	}
	
	//对个人信息页面进行跳转
	@RequestMapping("/baseInfo_per")
	public ModelAndView base_per() {
		ModelAndView model = new ModelAndView();
		Long uid = 695597107440123904L;
		//进入基本信息页面  对一些信息进行展示
		Map<String, Object> sysUser = sysUserSingelInfoService.getSysUser(uid);
		//去到特殊数据进行处理
		//对电话号码回显进行处理
		String tel = (String)sysUser.get("tel");
		String[] split = tel.split("-");
		for (int i = 0; i < split.length; i++) {
			sysUser.put("telphone"+i, split[i]);
		}
		//对传真号码回显进行处理
		String fax = (String)sysUser.get("fax");
		String[] split2 = fax.split("-");
		for (int i = 0; i < split2.length; i++) {
			sysUser.put("fax"+i, split2[i]);
		}
		//通过登录用户的id对跟人信息进行查询
		Map<String, Object> sysUserSingelInfo = sysUserSingelInfoService.get(uid);
		String nativePlace = (String)sysUserSingelInfo.get("native_place");
		String[] place = nativePlace.split("-");
		if(place.length==3){
			sysUserSingelInfo.put("country", place[0]);
			sysUserSingelInfo.put("province", place[1]);
			sysUserSingelInfo.put("city", place[2]);
		}
		model.addObject("sysUserSingelInfo", sysUserSingelInfo);
		//将数据放到作用域
		model.addObject("loginUser", sysUser);
		model.setViewName("account-mana-child/acc-info-per");
		return model;
	}
	//对特殊的生日信息进行处理
	@RequestMapping("/info")
	@ResponseBody
	public Map<String,Object> getBirthday(){
		Map<String,Object> infoMap = new HashMap<String, Object>();
		Long uid = 695597107440123904L;
		Map<String, Object> sysUserSingelInfo = sysUserSingelInfoService.get(uid);
		String birthday = (String)sysUserSingelInfo.get("birthday");
		String[] birthdays = birthday.split("-");
		if(birthdays.length==3){
			infoMap.put("year", birthdays[0]);
			infoMap.put("month", birthdays[1]);
			infoMap.put("day", birthdays[2]);
		}
		//对地址信息进行处理
		String place = (String)sysUserSingelInfo.get("native_place");
		String[] split = place.split("-");
		if(split.length==3){
			infoMap.put("province", split[1]);
			infoMap.put("city", split[2]);
		}
		
		Map<String, Object> sysUser = sysUserSingelInfoService.getSysUser(uid);
		String provincebase = (String)sysUser.get("company_address_province");
		String cityBase = (String)sysUser.get("company_address_city");
		String country = (String)sysUser.get("company_address_county");
		
		infoMap.put("provincebase", provincebase);
		infoMap.put("cityBase", cityBase);
		infoMap.put("country", country);
		
		
		return infoMap;
	}
	
	//对个人信息进行保存
	@RequestMapping("/info_save")
	public String info_save(SysUserSingelInfo sysUserSingelInfo,String year,String month,String day,String country,String province,String city){
		//可能会对得到的个别信息进行处理
		if(sysUserSingelInfo!=null){
			//对特殊数据进行处理
			String birthday = year+"-"+month+"-"+day;
			String nativePlace = country+"-"+province+"-"+city;
			sysUserSingelInfo.setNativePlace(nativePlace);
			sysUserSingelInfo.setBirthday(birthday);
		}
		if(sysUserSingelInfo!=null&&sysUserSingelInfo.getPid()!=null){
			Long uid =695597107440123904L; 
			sysUserSingelInfo.setUid(uid);
			sysUserSingelInfoService.update(sysUserSingelInfo);
		}else{
			sysUserSingelInfo.setPid(globalIdService.getGlobalId());
			Long uid =695597107440123904L; 
			sysUserSingelInfo.setUid(uid);
			sysUserSingelInfoService.insert(sysUserSingelInfo);
		}
		return "redirect:shouye";
	}
	/**
	 * 上传文件最好使用ajax进行文件的上传 使用异步方法进行处理
	 * 
	 * 将控制器中的方法进行抽取成业务方法(控制层中不应该出现业务代码)
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/ImgUpload")
	@ResponseBody
	public Map<String,Object> uploadImg(@RequestParam CommonsMultipartFile __avatar1,HttpServletRequest request) throws Exception{
		Long uid =695597107440123904L; 
		Map<String,Object> usermap = new HashMap<String,Object>();
        InputStream inputStream = __avatar1.getInputStream();
        String realPath = request.getSession().getServletContext().getRealPath("upload");
        File tempFile = new File(realPath);
        if  (!tempFile .exists()  && !tempFile .isDirectory())      
        {       
            tempFile .mkdir();
        }
        Long random = new Date().getTime();
        String fileName = random+".jpg";
        
        File uploadFile = new File(realPath+"/"+fileName);
        FileUtils.copyInputStreamToFile(inputStream, uploadFile);
		FastdfsClient client = FastdfsClientFactory.getFastdfsClient();
		String upload = client.upload(uploadFile);
		//然后再讲本地的文件删掉
		uploadFile.delete();
		//将图片的地址存储到数据库
		sysUserSingelInfoService.updateImgPath(upload,uid);
		usermap.put("success", true);
		usermap.put("avatarUrls", upload);
		return usermap;
	}
	@RequestMapping("/approve")
	@ResponseBody
	public void approve(String realname){
		System.out.println("执行用户名验证:"+realname);
	}
	
	/**
	 *   对基本信息进行保存
	 *   对个人用户的基本信息进行修改
	 * @param sysUser
	 * @return
	 */
	
	@RequestMapping(value="/update_basicinfo", method= RequestMethod.POST)
	public String update_basicinfo(SysUser sysUser,String tel1,String tel2,String tel3,String fax1,String fax2,String fax3){
		//模拟登陆用户
		sysUser.setRealname("张三");
		long uid =695597107440123904L; ;
		//模拟登陆用户为个人用户
		sysUser.setUid(uid);
		String userType = "1";
		sysUser.setUserType(userType);
		//对电话号码进行处理
		
		String replace = tel1+"-"+tel2+"-"+tel3;
		sysUser.setTel(replace);
		
		//对传真号码进行处理
		String faxReplace = fax1+"-"+fax2+"-"+fax3;
		sysUser.setFax(faxReplace);
		//对基本用户信息进行修改
		sysUserSingelInfoService.updateBasicInfoPer(sysUser);
		
		return "redirect:baseInfo_per";
	}
	//对修改密码的页面进行跳转
	@RequestMapping("/update_page")
	public ModelAndView update_page(){
		ModelAndView model = new ModelAndView();
		//获得登录用户目前的手机号
		Long uid = 695597107440123904L;
		
		Map<String, Object> sysUser = sysUserSingelInfoService.getSysUser(uid);
		
		Object phone = sysUser.get("phone");
		model.addObject("phone", phone);
		model.setViewName("account-mana-child/updatePhone");
		return  model;
	}
	//处理修改手机号码业务
	@RequestMapping("/update_phone")
	public  ModelAndView pdate_phone(SysUser sysUser,String safeCode){
		//模拟登陆用户信息uid
		Long uid = 695597107440123904L;
		sysUser.setUid(uid);
		ModelAndView model = new ModelAndView();
		//提供一个服务来进行判断;
		//获得当前登录用户的id
		sysUserSingelInfoService.updatePhone(sysUser);
			//将错误信息添加至页面
		model.addObject("phone", sysUser);
		model.setViewName("redirect:shouye");
		return  model;
	}
	
	//专门写一控制方法用来判断验证码是否正确
	@RequestMapping("/phone_code")
	public void phone_code(String safeCode,HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		try {
			sysUserSingelInfoService.checkCode(safeCode);
			writer.print("手机验证码输入正确");
		} catch (Exception e) {
			writer.print("手机验证码输入错误");
			e.printStackTrace();
		}
		writer.close();
	}
	
	//对修改邮箱页面进行跳转
	@RequestMapping("/email_page")
	public String addEmail(){
		return "account-mana-child/updateEmail";
	}
	
	//修改业务邮箱
	@RequestMapping("/email_update")
	public String update_email(SysUser sysUser){
		Long uid = 695597107440123904L;
		sysUser.setUid(uid);
		//执行邮箱修改
		sysUserSingelInfoService.updateEmail(sysUser);
		return "redirect:shouye";
	}
}
