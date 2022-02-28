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
import com.fc.ithink.mapper.auto.ProSaleMapper;
import com.fc.ithink.model.auto.ProSale;
import com.fc.ithink.model.auto.ProSaleExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.StringUtils;

/**
 * 作品上架表 ProSaleService
 * @Title: ProSaleService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 16:03:15  
 **/
@Service
public class ProSaleService implements BaseService<ProSale, ProSaleExample>{
	@Autowired
	private ProSaleMapper proSaleMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProSale> list(Tablepar tablepar,ProSale proSale){
	        ProSaleExample testExample=new ProSaleExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(proSale);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProSale> list= proSaleMapper.selectByExample(testExample);
	        PageInfo<ProSale> pageInfo = new PageInfo<ProSale>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			ProSaleExample example=new ProSaleExample();
			example.createCriteria().andIdIn(stringB);
			return proSaleMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public ProSale selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return proSaleMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProSale record) {
		return proSaleMapper.updateByPrimaryKeySelective(record);
	}

/*	public int updateProSaleStatus(ProSale record) {
	 	ProSaleExample example = new ProSaleExample();
	 	ProSaleExample.Criteria criteria = example.createCriteria();

	 	criteria.andIsDelEqualTo(0);
	 	criteria.andIdEqualTo(record.getId());
		return proSaleMapper.upda(record);
	}*/

	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProSale record) {
				
		record.setId(null);
		
				
		return proSaleMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProSale record, ProSaleExample example) {
		
		return proSaleMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProSale record, ProSaleExample example) {
		
		return proSaleMapper.updateByExample(record, example);
	}

	@Override
	public List<ProSale> selectByExample(ProSaleExample example) {
		
		return proSaleMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProSaleExample example) {
		
		return proSaleMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProSaleExample example) {
		
		return proSaleMapper.deleteByExample(example);
	}

	public List<Map<String,Object>> selectByCondition(Tablepar tablepar, ProSale proSale) {
		PageHelper.offsetPage(tablepar.getPage(),tablepar.getLimit());
		return proSaleMapper.selectOrderByDate(proSale);


	}


	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProSale> listByExample(Tablepar tablepar,ProSale record){

		ProSaleExample testExample=new ProSaleExample();
		testExample.createCriteria().equals(record.getSaleStatus());
		testExample.setOrderByClause("create_dat ASC");
		if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
		}
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProSale> list= proSaleMapper.selectByExample(testExample);
		PageInfo<ProSale> pageInfo = new PageInfo<ProSale>(list);
		return  pageInfo;
	}
}
