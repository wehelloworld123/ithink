package com.fc.ithink.service;

import java.util.List;

import com.fc.ithink.common.constant.ProjectConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.DebTopicMapper;
import com.fc.ithink.model.auto.DebTopic;
import com.fc.ithink.model.auto.DebTopicExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;

/**
 * 论题信息 DebTopicService
 * @Title: DebTopicService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 15:14:38  
 **/
@Service
public class DebTopicService implements BaseService<DebTopic, DebTopicExample>{
	@Autowired
	private DebTopicMapper debTopicMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param debTopic
	 * @return
	 */
	 public PageInfo<DebTopic> list(Tablepar tablepar,DebTopic debTopic){
	        DebTopicExample testExample=new DebTopicExample();
		 	DebTopicExample.Criteria criteria = testExample.createCriteria();
		 	criteria.andIsDelEqualTo(0);
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
				criteria.andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
				criteria.andLikeQuery(debTopic);
	        }

			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("uid ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<DebTopic> list= debTopicMapper.selectByExample(testExample);
	        PageInfo<DebTopic> pageInfo = new PageInfo<DebTopic>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			DebTopicExample example=new DebTopicExample();
			example.createCriteria().andUidIn(lista);
			return debTopicMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public DebTopic selectByPrimaryKey(String id) {
				
			return debTopicMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(DebTopic record) {
		return debTopicMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(DebTopic record) {
				
		//添加雪花主键id
		record.setUid(ProjectConstant.TOPICPREFIX+SnowflakeIdWorker.getUUID());
			
				
		return debTopicMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(DebTopic record, DebTopicExample example) {
		
		return debTopicMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(DebTopic record, DebTopicExample example) {
		
		return debTopicMapper.updateByExample(record, example);
	}

	@Override
	public List<DebTopic> selectByExample(DebTopicExample example) {
		
		return debTopicMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(DebTopicExample example) {
		
		return debTopicMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(DebTopicExample example) {
		
		return debTopicMapper.deleteByExample(example);
	}


}
