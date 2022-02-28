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
import com.fc.ithink.mapper.auto.ProContentMapper;
import com.fc.ithink.model.auto.ProContent;
import com.fc.ithink.model.auto.ProContentExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;
import com.fc.ithink.util.StringUtils;

/**
 * 文学创作内容 ProContentService
 * @Title: ProContentService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 16:41:14  
 **/
@Service
public class ProContentService implements BaseService<ProContent, ProContentExample>{
	@Autowired
	private ProContentMapper proContentMapper;



	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProContent> list(Tablepar tablepar,ProContent record){
		ProContentExample testExample=new ProContentExample();
		testExample.createCriteria().andLikeQuery(record);
		testExample.setOrderByClause("no ASC");
		if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
		}
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProContent> list= proContentMapper.selectByExample(testExample);
		PageInfo<ProContent> pageInfo = new PageInfo<ProContent>(list);
		return  pageInfo;
	}

	@Override
	public int deleteByPrimaryKey(String ids) {

		List<String> lista=ConvertUtil.toListStrArray(ids);
		ProContentExample example=new ProContentExample();
		example.createCriteria().andNoIn(lista);
		return proContentMapper.deleteByExample(example);


	}

	public int deleteStsByKey(ProContent proContent) {

		return proContentMapper.deleteStsByKey(proContent);
	}

	/**
	 * 检查name
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		String[] strings = ConvertUtil.toStrArray(",", ids);
		List<String> stringB = Arrays.asList(strings);

		return proContentMapper.deleteBatchByPrimaryKey(stringB);
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProContent> queryRecomContentList(Tablepar tablepar,ProContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProContent> list= proContentMapper.selectRecomContentByChapId(record);
		PageInfo<ProContent> pageInfo = new PageInfo<ProContent>(list);
		return  pageInfo;
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProContent> queryAdoptContentList(Tablepar tablepar,ProContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProContent> list= proContentMapper.selectAdoptContentByChapId(record);
		PageInfo<ProContent> pageInfo = new PageInfo<ProContent>(list);
		return  pageInfo;
	}


	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProContent> queryAdoptContentListByUserId(Tablepar tablepar,ProContent record){

		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProContent> list= proContentMapper.selectAdoptContentByUserId(record);
		PageInfo<ProContent> pageInfo = new PageInfo<ProContent>(list);
		return  pageInfo;
	}


	public PageInfo<ProContent> queryContentList(Tablepar tablepar,ProContent record){

		ProContentExample testExample=new ProContentExample();
		ProContentExample.Criteria criteria =  testExample.createCriteria();
		criteria.andIsDelEqualTo(0);
		if(StrUtil.isNotEmpty(record.getTitle())){
			criteria.andTitleLike(record.getTitle());
		}
		if(record.getCharpId()!=null){
			criteria.andCharpIdEqualTo(record.getCharpId());
		}
	/*	if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
		}*/
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProContent> list= proContentMapper.selectByExample(testExample);

		PageInfo<ProContent> pageInfo = new PageInfo<ProContent>(list);
		return  pageInfo;
	}

	public int selectAdoptCount(ProContent record) {

		return proContentMapper.selectAdoptCount(record);

	}

	public Map<String,Object> selectUserContentByPrimaryKey(String id) {

		return proContentMapper.selectUserContentByPrimaryKey(id);

	}
	@Override
	public ProContent selectByPrimaryKey(String id) {

		return proContentMapper.selectByPrimaryKey(id);

	}


	@Override
	public int updateByPrimaryKeySelective(ProContent record) {
		return proContentMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProContent record) {

		//添加雪花主键id
		record.setNo(SnowflakeIdWorker.getUUID());


		return proContentMapper.insertSelective(record);
	}


	@Override
	public int updateByExampleSelective(ProContent record, ProContentExample example) {

		return proContentMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(ProContent record, ProContentExample example) {

		return proContentMapper.updateByExample(record, example);
	}

	@Override
	public List<ProContent> selectByExample(ProContentExample example) {

		return proContentMapper.selectByExample(example);
	}


	@Override
	public long countByExample(ProContentExample example) {

		return proContentMapper.countByExample(example);
	}


	@Override
	public int deleteByExample(ProContentExample example) {

		return proContentMapper.deleteByExample(example);
	}

	/**
	 * 检查name
	 * @param proContent
	 * @return
	 */
	public int checkNameUnique(ProContent proContent){
		ProContentExample example=new ProContentExample();
		example.createCriteria().andCharpIdEqualTo(proContent.getCharpId());
		List<ProContent> list=proContentMapper.selectByExample(example);
		return list.size();
	}



}
