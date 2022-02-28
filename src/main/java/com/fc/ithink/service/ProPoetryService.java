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
import com.fc.ithink.mapper.auto.ProPoetryMapper;
import com.fc.ithink.model.auto.ProPoetry;
import com.fc.ithink.model.auto.ProPoetryExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.StringUtils;

/**
 * 诗歌创作集 ProPoetryService
 * @Title: ProPoetryService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:22:57  
 **/
@Service
public class ProPoetryService implements BaseService<ProPoetry, ProPoetryExample>{
	@Autowired
	private ProPoetryMapper proPoetryMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param proPoetry
	 * @return
	 */
	 public PageInfo<ProPoetry> list(Tablepar tablepar,ProPoetry proPoetry){
	        ProPoetryExample testExample=new ProPoetryExample();
		 	ProPoetryExample.Criteria criteria= testExample.createCriteria();
			if(StrUtil.isNotEmpty(proPoetry.getCreateBy())) {
			 criteria.andCreateByEqualTo(proPoetry.getCreateBy());
			}
			if(proPoetry.getFinish()!=null){
			 criteria.andFinishEqualTo(proPoetry.getFinish());
			}
			if(StrUtil.isNotEmpty(proPoetry.getUid())){
			 criteria.andUidEqualTo(proPoetry.getUid());
			}
			if(StrUtil.isNotEmpty(proPoetry.getName())){
			 criteria.andNameEqualTo(proPoetry.getName());
			}
			if(StrUtil.isNotEmpty(proPoetry.getKind())){
			 criteria.andKindEqualTo(proPoetry.getKind());
			}

			if(proPoetry.getRate()!=null){
			 criteria.andRateEqualTo(proPoetry.getRate());
			}
			if(proPoetry.getIsDel()!=null){
			 criteria.andIsDelEqualTo(proPoetry.getIsDel());
			}
			testExample.setOrderByClause("uid ASC");
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			 testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
			}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProPoetry> list= proPoetryMapper.selectByExample(testExample);
	        PageInfo<ProPoetry> pageInfo = new PageInfo<ProPoetry>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			ProPoetryExample example=new ProPoetryExample();
			example.createCriteria().andUidIn(lista);
			return proPoetryMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ProPoetry selectByPrimaryKey(String id) {
				
			return proPoetryMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProPoetry record) {
		return proPoetryMapper.updateByPrimaryKeySelective(record);
	}

	public Map<String,Object> selectFinChaptCount(ProPoetry record) {

		return proPoetryMapper.selectFinChaptCount(record);

	}
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProPoetry record) {
				
		//添加雪花主键id

		return proPoetryMapper.insertSelective(record);
	}


	/**
	 * 检查name
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		String[] strings = ConvertUtil.toStrArray(",", ids);
		List<String> stringB = Arrays.asList(strings);

		return proPoetryMapper.deleteBatchByPrimaryKey(stringB);
	}
	
	
	@Override
	public int updateByExampleSelective(ProPoetry record, ProPoetryExample example) {
		
		return proPoetryMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProPoetry record, ProPoetryExample example) {
		
		return proPoetryMapper.updateByExample(record, example);
	}

	@Override
	public List<ProPoetry> selectByExample(ProPoetryExample example) {
		
		return proPoetryMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProPoetryExample example) {
		
		return proPoetryMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProPoetryExample example) {
		
		return proPoetryMapper.deleteByExample(example);
	}

	public Map<String,Object> selectRewardSum(String userid) {

		return proPoetryMapper.selectRewardSum(userid);

	}
}
