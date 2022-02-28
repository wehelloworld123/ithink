package com.fc.ithink.service;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.ProRecomMapper;
import com.fc.ithink.model.auto.ProRecom;
import com.fc.ithink.model.auto.ProRecomExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 创作推荐表 ProRecomService
 * @Title: ProRecomService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-11 13:14:26  
 **/
@Service
public class ProRecomService implements BaseService<ProRecom, ProRecomExample>{
	@Autowired
	private ProRecomMapper proRecomMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProRecom> list(Tablepar tablepar,ProRecom proRecom){
	        ProRecomExample testExample=new ProRecomExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proRecom);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProRecom> list= proRecomMapper.selectByExample(testExample);
	        PageInfo<ProRecom> pageInfo = new PageInfo<ProRecom>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ProRecomExample example=new ProRecomExample();
			example.createCriteria().andIdIn(stringB);
			return proRecomMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ProRecom selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return proRecomMapper.selectByPrimaryKey(id1);
				
	}


	public List<ProRecom> queryRecomList(String no,int startIndex,int pageSize){
		PageHelper.startPage(startIndex, pageSize);
		List<ProRecom> list= proRecomMapper.select(no);
		PageInfo<ProRecom> pageInfo = new PageInfo<ProRecom>(list);
		return pageInfo.getList();
	}
	@Override
	public int updateByPrimaryKeySelective(ProRecom record) {
		return proRecomMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProRecom record) {
				
		record.setId(null);
		
				
		return proRecomMapper.insertSelective(record);
	}


	/**
	 * 检查name
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		Long[] strings = ConvertUtil.toLongArray(",", ids);
		List<Long> stringB = Arrays.asList(strings);

		return proRecomMapper.deleteBatchByPrimaryKey(stringB);
	}
	
	@Override
	public int updateByExampleSelective(ProRecom record, ProRecomExample example) {
		
		return proRecomMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProRecom record, ProRecomExample example) {
		
		return proRecomMapper.updateByExample(record, example);
	}

	@Override
	public List<ProRecom> selectByExample(ProRecomExample example) {
		
		return proRecomMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProRecomExample example) {
		
		return proRecomMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProRecomExample example) {
		
		return proRecomMapper.deleteByExample(example);
	}


}
