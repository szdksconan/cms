package com.cms.service.fastdfs;

import java.io.File;
import java.util.Map;
/**
 * 
 * @author weibo
 *
 */
public interface FastdfsClient {
	/**
	 * 上传一个文件
	 * @param file 要上传的文件
	 * @return fileid 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
	 * @throws Exception
	 */
	public String upload(File file) throws Exception;
	
	/**
	 * 上传一个文件
	 * @param file 要上传的文件
	 * @param ext 文件扩展名，like jpg，不带.
	 * @return fileid 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
	 * @throws Exception
	 */
	public String upload(File file,String ext) throws Exception;
	/**
     * 上传一个文件
     * @param file 要上传的文件
     * @param ext 文件扩展名，like jpg，不带.
     * @param meta meta key/value的meta data，可为null
     * @return fileid 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
     * @throws Exception
     */
    public String upload(File file,String ext,Map<String,String> meta) throws Exception;

    /**
     * 上传从文件
     * @param file
     * @param fileid 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
     * @param prefix slave的扩展名，如200x200
     * @param ext 文件扩展名，like jpg，不带.
     * @return 上传后的fileid   如 g1/M00/00/00/aaaabbbbccc_200x200.jpg
     * @throws Exception
     */
    public String uploadSlave(File file,String fileid, String prefix, String ext) throws Exception;
    /**
	 * 设置文件相关属性
	 * @param fileId 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
	 * @param meta
	 * @return
	 * @throws Exception
	 */
	public Boolean setMeta(String fileId,Map<String,String> meta) throws Exception;
	/**
	 * 获取文件相关属性
	 * @param fileId 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getMeta(String fileId) throws Exception;
	/**
	 * 获取文件url
	 * @param fileId 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
	 * @return 文件url
	 * @throws Exception
	 */
	public String getUrl(String fileId) throws Exception;
	
	/**
	 * 删除文件
	 * @param fileId 带group的fileid,如 g1/M00/00/00/aaaabbbbccc.jpg
	 * @return
	 * @throws Exception
	 */
	public Boolean delete(String fileId) throws Exception;
	/**
	 * 关闭连接池
	 */
	public void close();


    

}
