package com.fc.ithink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.ProDatacountMapper;
import com.fc.ithink.model.auto.ProDatacount;
import com.fc.ithink.model.auto.ProDatacountExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;

/**
 *  ProDatacountService
 * @Title: ProDatacountService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-21 21:11:18  
 **/
@Service
public class ProDatacountService implements BaseService<ProDatacount, ProDatacountExample>{
	@Autowired
	private ProDatacountMapper proDatacountMapper;
	
      	   	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProDatacount> list(Tablepar tablepar,ProDatacount proDatacount){
	        ProDatacountExample testExample=new ProDatacountExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proDatacount);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProDatacount> list= proDatacountMapper.selectByExample(testExample);
	        PageInfo<ProDatacount> pageInfo = new PageInfo<ProDatacount>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			ProDatacountExample example=new ProDatacountExample();
			example.createCriteria().andIdIn(lista);
			return proDatacountMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ProDatacount selectByPrimaryKey(String id) {
				
			return proDatacountMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProDatacount record) {
		return proDatacountMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProDatacount record) {
				
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
			
				
		return proDatacountMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProDatacount record, ProDatacountExample example) {
		
		return proDatacountMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProDatacount record, ProDatacountExample example) {
		
		return proDatacountMapper.updateByExample(record, example);
	}

	@Override
	public List<ProDatacount> selectByExample(ProDatacountExample example) {
		
		return proDatacountMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProDatacountExample example) {
		
		return proDatacountMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProDatacountExample example) {
		
		return proDatacountMapper.deleteByExample(example);
	}


}
