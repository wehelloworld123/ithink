package com.fc.ithink.service;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.ProPoetryContentMapper;
import com.fc.ithink.model.auto.ProPoetryContent;
import com.fc.ithink.model.auto.ProPoetryContentExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;

/**
 * 诗歌创作内容 ProPoetryContentService
 * @Title: ProPoetryContentService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:25:00  
 **/
@Service
public class ProPoetryContentService implements BaseService<ProPoetryContent, ProPoetryContentExample>{
	@Autowired
	private ProPoetryContentMapper proPoetryContentMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProPoetryContent> list(Tablepar tablepar,ProPoetryContent proPoetryContent){
	        ProPoetryContentExample testExample=new ProPoetryContentExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proPoetryContent);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("no ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProPoetryContent> list= proPoetryContentMapper.selectByExample(testExample);
	        PageInfo<ProPoetryContent> pageInfo = new PageInfo<ProPoetryContent>(list);
	        return  pageInfo;
	 }

	public PageInfo<ProPoetryContent> queryContentList(Tablepar tablepar, ProPoetryContent record){

		ProPoetryContentExample testExample=new ProPoetryContentExample();
		ProPoetryContentExample.Criteria criteria =  testExample.createCriteria();
		criteria.andIsDelEqualTo(0);
		if(StrUtil.isNotEmpty(record.getTitle())){
			criteria.andTitleLike(record.getTitle());
		}
		if(record.getCharpId()!=null){
			criteria.andCharpIdEqualTo(record.getCharpId());
		}

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPoetryContent> list= proPoetryContentMapper.selectByExample(testExample);

		PageInfo<ProPoetryContent> pageInfo = new PageInfo<>(list);
		return  pageInfo;
	}
	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			ProPoetryContentExample example=new ProPoetryContentExample();
			example.createCriteria().andNoIn(lista);
			return proPoetryContentMapper.deleteByExample(example);
			
				
	}

	public Map<String,Object> selectUserContentByPrimaryKey(String id) {

		return proPoetryContentMapper.selectUserContentByPrimaryKey(id);

	}
	
	@Override
	public ProPoetryContent selectByPrimaryKey(String id) {
				
			return proPoetryContentMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProPoetryContent record) {
		return proPoetryContentMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProPoetryContent record) {
				
		//添加雪花主键id
		record.setNo(SnowflakeIdWorker.getUUID());
			
				
		return proPoetryContentMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProPoetryContent record, ProPoetryContentExample example) {
		
		return proPoetryContentMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProPoetryContent record, ProPoetryContentExample example) {
		
		return proPoetryContentMapper.updateByExample(record, example);
	}

	@Override
	public List<ProPoetryContent> selectByExample(ProPoetryContentExample example) {
		
		return proPoetryContentMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProPoetryContentExample example) {
		
		return proPoetryContentMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProPoetryContentExample example) {
		
		return proPoetryContentMapper.deleteByExample(example);
	}

	public int selectAdoptCount(ProPoetryContent record) {

		return proPoetryContentMapper.selectAdoptCount(record);

	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPoetryContent> queryAdoptContentList(Tablepar tablepar,ProPoetryContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPoetryContent> list= proPoetryContentMapper.selectAdoptContentByChaptId(record);
		PageInfo<ProPoetryContent> pageInfo = new PageInfo<ProPoetryContent>(list);
		return  pageInfo;
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPoetryContent> queryRecomContentList(Tablepar tablepar,ProPoetryContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPoetryContent> list= proPoetryContentMapper.selectRecomContentByChaptId(record);
		PageInfo<ProPoetryContent> pageInfo = new PageInfo<ProPoetryContent>(list);
		return  pageInfo;
	}

	/**
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		String[] strings = ConvertUtil.toStrArray(",", ids);
		List<String> stringB = Arrays.asList(strings);

		return proPoetryContentMapper.deleteBatchByPrimaryKey(stringB);
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPoetryContent> queryAdoptContentListByUserId(Tablepar tablepar,ProPoetryContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPoetryContent> list= proPoetryContentMapper.selectAdoptContentByUserId(record);
		PageInfo<ProPoetryContent> pageInfo = new PageInfo<ProPoetryContent>(list);
		return  pageInfo;
	}
}
