package com.cms.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.cms.model.util.GlobalConstant;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadUtil {
	private static final int BUFFER_SIZE = 16 * 1024;//缓存

    /**
     * 图片上传工具类
     * @param request
     * @param typepath 业务系统唯一目录如：上传身份证就为身份证编号
     * @param typeNames 页面上传组件name
     * @return
     * @throws IOException
     */
	public static Map<String,String> uploadImg(MultipartHttpServletRequest request,String typepath,String[] typeNames) throws IOException {
		// --------------------文件上传
		InputStream in = null;
		OutputStream out = null;
		String path = "";
		Map<String,String> map = new HashMap<String,String>();
		for (int i=0;i<typeNames.length;i++){
			List<MultipartFile> list = request.getFiles(typeNames[i]);
			if(list!=null && list.size()>0){
				try {
					// 系统平台
					String platform = System.getProperty("os.name","No Define System name!");
					// 判断平台
					if (platform.toLowerCase().indexOf("windows") != -1) {
						path = GlobalConstant.windowsFilePath+typeNames[i]+"/"+typepath+"/";
					} else {
						path = GlobalConstant.linuxFilePath+typeNames[i]+"/"+typepath+"/";
					}
					File excelFileFile = new File(path);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String fileStr = sdf.format(new Date());
					String fileStrMin = fileStr+"_min";
					StringBuffer str = new StringBuffer();
					StringBuffer str_min = new StringBuffer();
					boolean mapFlag = false;
					for (int j=0;j<list.size();j++){
						if (!list.get(j).isEmpty()){
							mapFlag=true;
							// 如果不存在这个路径，就创建一个
							if (excelFileFile.exists()){
								deleteFile(excelFileFile);
							}
							excelFileFile.mkdirs();
							MultipartFile file = list.get(j);
							String filename = file.getOriginalFilename();
							String[] array = filename.split("\\.");
					        String path1 = path + fileStr+"."+array[array.length-1];
					        String path2 = path+fileStrMin+"."+array[array.length-1];
					        makeSmallImage(file, path2);
							str_min.append(path2+",");
							excelFileFile = new File(path1);
							// 获取流
							in = new BufferedInputStream(file.getInputStream(),BUFFER_SIZE);
							out = new BufferedOutputStream(new FileOutputStream(excelFileFile),BUFFER_SIZE);
							byte[] buffer = new byte[BUFFER_SIZE];
							// 写入数据
							while (in.read(buffer) > 0) {
								out.write(buffer);
							}
							if (in != null) {
								in.close();
							}
							if (out != null) {
								out.close();
							}
							str.append(path1+",");
						}
					}
					if (mapFlag){
						map.put(typeNames[i]+"Min", str_min.toString().substring(0, str_min.toString().length()-1));
						map.put(typeNames[i], str.toString().substring(0, str.toString().length()-1));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (in != null) {
						in.close();
					}
					if (out != null) {
						out.close();
					}
				}
			}
		}
		return map;
	}
	
	/**
	 * 将指定文件名的图片展示在页面上
	 * @param response
	 * @param url  图片路径
	 */
	public static void showImg(HttpServletResponse response,String url){
		try {
			FileInputStream hFile = new FileInputStream(url); // 以byte流的方式打开文件   
			int i=hFile.available(); //得到文件大小   
			byte data[]=new byte[i];   
			hFile.read(data);  //读数据   
			response.setContentType("image/*"); //设置返回的文件类型   
			OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象   
			toClient.write(data);  //输出数据   
			toClient.flush();  
			toClient.close();   
			hFile.close(); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * 图片压缩
     * @param file
     * @param path
     * @throws Exception
     */
	public static void makeSmallImage(MultipartFile file,String path) throws Exception {
		int nw = 200;  
        /* 
        AffineTransform 类表示 2D 仿射变换，它执行从 2D 坐标到其他 2D 
        	坐标的线性映射，保留了线的“直线性”和“平行性”。可以使用一系 
        	列平移、缩放、翻转、旋转和剪切来构造仿射变换。 
        */  
        AffineTransform transform = new AffineTransform();
        BufferedImage bis = ImageIO.read(file.getInputStream()); //读取图片 
        int w = bis.getWidth();
        int h = bis.getHeight();
        if (h<=nw){//如果原图高度比规定的高度小，则不用压缩
        	InputStream in = new BufferedInputStream(file.getInputStream(),BUFFER_SIZE);
        	OutputStream out = new BufferedOutputStream(new FileOutputStream(path),BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			// 写入数据
			try{
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			}finally{
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			}
        	return;
        }
         //double scale = (double)w/h;  
        int nh = (nw*h)/w ;
        double sx = (double)nw/w;
        double sy = (double)nh/h;
        transform.setToScale(sx,sy); //setToScale(double sx, double sy) 将此变换设置为缩放变换。  
        /* 
         * AffineTransformOp类使用仿射转换来执行从源图像或 Raster 中 2D 坐标到目标图像或 
         *  Raster 中 2D 坐标的线性映射。所使用的插值类型由构造方法通过 
         *  一个 RenderingHints 对象或通过此类中定义的整数插值类型之一来指定。 
		        如果在构造方法中指定了 RenderingHints 对象，则使用插值提示和呈现 
		        的质量提示为此操作设置插值类型。要求进行颜色转换时，可以使用颜色 
		        呈现提示和抖动提示。 注意，务必要满足以下约束：源图像与目标图像 
		        必须不同。 对于 Raster 对象，源图像中的 band 数必须等于目标图像中 
		        的 band 数。 
        */  
        AffineTransformOp ato = new AffineTransformOp(transform,null);
        BufferedImage bid = new BufferedImage(nw,nh,BufferedImage.TYPE_3BYTE_BGR);
        /* 
         * TYPE_3BYTE_BGR 表示一个具有 8 位 RGB 颜色分量的图像， 
         * 对应于 Windows 风格的 BGR 颜色模型，具有用 3 字节存 
         * 储的 Blue、Green 和 Red 三种颜色。 
        */  
        ato.filter(bis,bid);
        File fo = new File(path);
        ImageIO.write(bid,"jpeg",fo);
    }

    /**
     * 文件删除
     * @param dir
     * @return
     */
	public static boolean deleteFile(File dir){
		if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteFile(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
	}
}
