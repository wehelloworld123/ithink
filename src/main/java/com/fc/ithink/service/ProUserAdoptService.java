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
import com.fc.ithink.mapper.auto.ProUserAdoptMapper;
import com.fc.ithink.model.auto.ProUserAdopt;
import com.fc.ithink.model.auto.ProUserAdoptExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 用户创作采纳表 ProUserAdoptService
 * @Title: ProUserAdoptService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-12 16:48:09  
 **/
@Service
public class ProUserAdoptService implements BaseService<ProUserAdopt, ProUserAdoptExample>{
	@Autowired
	private ProUserAdoptMapper proUserAdoptMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProUserAdopt> list(Tablepar tablepar,ProUserAdopt proUserAdopt){
	        ProUserAdoptExample testExample=new ProUserAdoptExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proUserAdopt);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProUserAdopt> list= proUserAdoptMapper.selectByExample(testExample);
	        PageInfo<ProUserAdopt> pageInfo = new PageInfo<ProUserAdopt>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			ProUserAdoptExample example=new ProUserAdoptExample();
			example.createCriteria().andIdIn(stringB);
			return proUserAdoptMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public ProUserAdopt selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return proUserAdoptMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProUserAdopt record) {
		return proUserAdoptMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProUserAdopt record) {
				
		record.setId(null);
		
				
		return proUserAdoptMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProUserAdopt record, ProUserAdoptExample example) {
		
		return proUserAdoptMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProUserAdopt record, ProUserAdoptExample example) {
		
		return proUserAdoptMapper.updateByExample(record, example);
	}

	@Override
	public List<ProUserAdopt> selectByExample(ProUserAdoptExample example) {
		
		return proUserAdoptMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProUserAdoptExample example) {
		
		return proUserAdoptMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProUserAdoptExample example) {
		
		return proUserAdoptMapper.deleteByExample(example);
	}


}
