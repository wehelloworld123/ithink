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
import com.fc.ithink.mapper.auto.ProPaintContentMapper;
import com.fc.ithink.model.auto.ProPaintContent;
import com.fc.ithink.model.auto.ProPaintContentExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;

/**
 * 绘画创作内容 ProPaintContentService
 * @Title: ProPaintContentService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:27:22  
 **/
@Service
public class ProPaintContentService implements BaseService<ProPaintContent, ProPaintContentExample>{
	@Autowired
	private ProPaintContentMapper proPaintContentMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param proPaintContent
	 * @return
	 */
	 public PageInfo<ProPaintContent> list(Tablepar tablepar,ProPaintContent proPaintContent){
	        ProPaintContentExample testExample=new ProPaintContentExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proPaintContent);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("no ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProPaintContent> list= proPaintContentMapper.selectByExample(testExample);
	        PageInfo<ProPaintContent> pageInfo = new PageInfo<ProPaintContent>(list);
	        return  pageInfo;
	 }


	public PageInfo<ProPaintContent> queryContentList(Tablepar tablepar, ProPaintContent record){

		ProPaintContentExample testExample=new ProPaintContentExample();
		ProPaintContentExample.Criteria criteria =  testExample.createCriteria();
		criteria.andIsDelEqualTo(0);
		if(StrUtil.isNotEmpty(record.getTitle())){
			criteria.andTitleLike(record.getTitle());
		}
		if(record.getPartId()!=null){
			criteria.andPartIdEqualTo(record.getPartId());
		}
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPaintContent> list= proPaintContentMapper.selectByExample(testExample);

		PageInfo<ProPaintContent> pageInfo = new PageInfo<>(list);
		return  pageInfo;
	}
	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			ProPaintContentExample example=new ProPaintContentExample();
			example.createCriteria().andNoIn(lista);
			return proPaintContentMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ProPaintContent selectByPrimaryKey(String id) {
				
			return proPaintContentMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProPaintContent record) {
		return proPaintContentMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProPaintContent record) {
				
		//添加雪花主键id
		record.setNo(SnowflakeIdWorker.getUUID());
			
				
		return proPaintContentMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProPaintContent record, ProPaintContentExample example) {
		
		return proPaintContentMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProPaintContent record, ProPaintContentExample example) {
		
		return proPaintContentMapper.updateByExample(record, example);
	}

	@Override
	public List<ProPaintContent> selectByExample(ProPaintContentExample example) {
		
		return proPaintContentMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProPaintContentExample example) {
		
		return proPaintContentMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProPaintContentExample example) {
		
		return proPaintContentMapper.deleteByExample(example);
	}





	public int deleteStsByKey(ProPaintContent proPaintContent) {

		return proPaintContentMapper.deleteStsByKey(proPaintContent);
	}

	/**
	 * 检查name
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		String[] strings = ConvertUtil.toStrArray(",", ids);
		List<String> stringB = Arrays.asList(strings);

		return proPaintContentMapper.deleteBatchByPrimaryKey(stringB);
	}


	public int selectAdoptCount(ProPaintContent record) {

		return proPaintContentMapper.selectAdoptCount(record);

	}


	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPaintContent> queryAdoptContentListByUserId(Tablepar tablepar,ProPaintContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPaintContent> list= proPaintContentMapper.selectAdoptContentByUserId(record);
		PageInfo<ProPaintContent> pageInfo = new PageInfo<ProPaintContent>(list);
		return  pageInfo;
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param proPaintContent
	 * @return
	 */
	public PageInfo<ProPaintContent> queryRecomContentList(Tablepar tablepar,ProPaintContent proPaintContent){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPaintContent> list= proPaintContentMapper.selectRecomContentByPartId(proPaintContent);
		PageInfo<ProPaintContent> pageInfo = new PageInfo<ProPaintContent>(list);
		return  pageInfo;
	}


	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPaintContent> queryAdoptContentList(Tablepar tablepar,ProPaintContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPaintContent> list= proPaintContentMapper.selectAdoptContentByPartId(record);
		PageInfo<ProPaintContent> pageInfo = new PageInfo<ProPaintContent>(list);
		return  pageInfo;
	}

	public Map<String,Object> selectUserContentByPrimaryKey(String id) {

		return proPaintContentMapper.selectUserContentByPrimaryKey(id);

	}
}
