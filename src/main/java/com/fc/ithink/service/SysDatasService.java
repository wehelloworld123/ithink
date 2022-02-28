package com.fc.ithink.service;

import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.conf.V2Config;
import com.fc.ithink.common.file.FileUploadUtils;
import com.fc.ithink.common.file.FileUtils;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.TsysDatasMapper;
import com.fc.ithink.model.auto.TsysDatas;
import com.fc.ithink.model.auto.TsysDatasExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.CosClientUtil;
import com.fc.ithink.util.SnowflakeIdWorker;
import com.fc.ithink.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SysDatasService implements BaseService<TsysDatas, TsysDatasExample>{
	
	
	@Autowired
	private TsysDatasMapper tsysDatasMapper;

	@Autowired
	private V2Config v2Config;
	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	 public PageInfo<TsysDatas> list(Tablepar tablepar,String searchText){
	        TsysDatasExample testExample=new TsysDatasExample();
	        testExample.setOrderByClause("id+0 DESC");
	        if(searchText!=null&&!"".equals(searchText)){
	        	testExample.createCriteria().andIdLike("%"+searchText+"%");
	        }
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<TsysDatas> list= tsysDatasMapper.selectByExample(testExample);
	        PageInfo<TsysDatas> pageInfo = new PageInfo<TsysDatas>(list);
	        return  pageInfo;
	 }

	
	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=ConvertUtil.toListStrArray(ids);
		TsysDatasExample example=new TsysDatasExample();
		example.createCriteria().andIdIn(lista);
		return tsysDatasMapper.deleteByExample(example);
	}



	
	
	/**
	 * 文件上传文件存储到文件表
	 * @param file
	 * @return 主键
	 * @throws IOException 
	 */
	public String insertSelective(MultipartFile file) throws IOException {
		//文件上传获取文件名字
        String files_name = FileUploadUtils.upload(file);
        //相对路径——项目url请求路径
        String relative_filesURL=v2Config.getIsroot_dir()+files_name;
        //绝对路径-删除需要得路径
        String absolute_filesURL=null;
        
        
    	if ("Y".equals(v2Config.getIsstatic())) {//项目路径
           	absolute_filesURL=v2Config.getIsroot_dir()+files_name;
   		}else {//磁盘路径
   			absolute_filesURL=v2Config.getDefaultBaseDir()+files_name;
   			//filesURL=V2Config.getIsroot_dir()+files;
   		}
     
        String fileName=file.getOriginalFilename();
    	// 获得文件后缀名称
    	String suffixName = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
    	if(StringUtils.isEmpty(suffixName)) {
    		//如果没有后缀默认后缀
    		suffixName=FileUploadUtils.IMAGE_JPG_EXTENSION;
    	}
     
		TsysDatas record=new TsysDatas();
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		record.setFilePath(relative_filesURL);
		record.setFileAbsolutePath(absolute_filesURL);
		record.setFileSuffix(suffixName);
		//上传路径类型
		record.setFileType(v2Config.getIsstatic());
		if(tsysDatasMapper.insertSelective(record)>0)
		{
			return record.getId();
		}
		return null;
	}



	/**
	 * 文件上传文件存储到文件表
	 * @param file
	 * @param fullFileName
	 * @return 主键
	 * @throws IOException
	 */
	public String uploadImage2Cos(MultipartFile file,String fullFileName) throws IOException {
		//文件上传获取文件名字
		File file1 = FileUtils.multipartFile2File(file);
		String filePath = CosClientUtil.uploadFile(fullFileName, file1);
		file1.delete();
		return filePath;


	}



	/**
	 * 文件上传文件存储到文件表
	 * @param file
	 * @return 主键
	 * @throws IOException
	 */
	public String saveImage(MultipartFile file) throws IOException {
		//文件上传获取文件名字
		String files_name = FileUploadUtils.upload(file);
		//相对路径——项目url请求路径
		String relative_filesURL=v2Config.getIsroot_dir()+files_name;
		//绝对路径-删除需要得路径
		String absolute_filesURL=null;


		if ("Y".equals(v2Config.getIsstatic())) {//项目路径
			absolute_filesURL=v2Config.getIsroot_dir()+files_name;
		}else {//磁盘路径
			absolute_filesURL=v2Config.getDefaultBaseDir()+files_name;
			//filesURL=V2Config.getIsroot_dir()+files;
		}

		String fileName=file.getOriginalFilename();
		// 获得文件后缀名称
		String suffixName = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
		if(StringUtils.isEmpty(suffixName)) {
			//如果没有后缀默认后缀
			suffixName=FileUploadUtils.IMAGE_JPG_EXTENSION;
		}

		return absolute_filesURL;
	}
	@Override
	public int insertSelective(TsysDatas record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return tsysDatasMapper.insertSelective(record);
	}

	@Override
	public TsysDatas selectByPrimaryKey(String id) {
		
		return tsysDatasMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(TsysDatas record) {
		return tsysDatasMapper.updateByPrimaryKeySelective(record);
	}
	
	public int updateByPrimaryKey(TsysDatas record) {
		return tsysDatasMapper.updateByPrimaryKey(record);
	}

	
	@Override
	public int updateByExampleSelective(TsysDatas record, TsysDatasExample example) {
		
		return tsysDatasMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(TsysDatas record, TsysDatasExample example) {
		
		return tsysDatasMapper.updateByExample(record, example);
	}

	@Override
	public List<TsysDatas> selectByExample(TsysDatasExample example) {
		
		return tsysDatasMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(TsysDatasExample example) {
		
		return tsysDatasMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(TsysDatasExample example) {
		
		return tsysDatasMapper.deleteByExample(example);
	}
	

	
}
