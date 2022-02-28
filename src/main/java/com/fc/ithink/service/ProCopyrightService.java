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
import com.fc.ithink.mapper.auto.ProCopyrightMapper;
import com.fc.ithink.model.auto.ProCopyright;
import com.fc.ithink.model.auto.ProCopyrightExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 作品版权分配 ProCopyrightService
 * @Title: ProCopyrightService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 15:53:57  
 **/
@Service
public class ProCopyrightService implements BaseService<ProCopyright, ProCopyrightExample>{
	@Autowired
	private ProCopyrightMapper proCopyrightMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProCopyright> list(Tablepar tablepar,ProCopyright proCopyright){
	        ProCopyrightExample testExample=new ProCopyrightExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proCopyright);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProCopyright> list= proCopyrightMapper.selectByExample(testExample);
	        PageInfo<ProCopyright> pageInfo = new PageInfo<ProCopyright>(list);
	        return  pageInfo;
	 }


	public PageInfo<ProCopyright> listByCondition(Tablepar tablepar,ProCopyright proCopyright){
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			proCopyright.setProNm(tablepar.getSearchText());
		}
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProCopyright> list= proCopyrightMapper.selectByCondition(proCopyright);
		PageInfo<ProCopyright> pageInfo = new PageInfo<ProCopyright>(list);
		return  pageInfo;
	}

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			ProCopyrightExample example=new ProCopyrightExample();
			example.createCriteria().andIdIn(stringB);
			return proCopyrightMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public ProCopyright selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return proCopyrightMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProCopyright record) {
		return proCopyrightMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProCopyright record) {
				
		record.setId(null);
		
				
		return proCopyrightMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProCopyright record, ProCopyrightExample example) {
		
		return proCopyrightMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProCopyright record, ProCopyrightExample example) {
		
		return proCopyrightMapper.updateByExample(record, example);
	}

	@Override
	public List<ProCopyright> selectByExample(ProCopyrightExample example) {
		
		return proCopyrightMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProCopyrightExample example) {
		
		return proCopyrightMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProCopyrightExample example) {
		
		return proCopyrightMapper.deleteByExample(example);
	}


}
