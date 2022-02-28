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
import com.fc.ithink.mapper.auto.ProPaintMapper;
import com.fc.ithink.model.auto.ProPaint;
import com.fc.ithink.model.auto.ProPaintExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.StringUtils;

/**
 * 绘画创作集 ProPaintService
 * @Title: ProPaintService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:26:23  
 **/
@Service
public class ProPaintService implements BaseService<ProPaint, ProPaintExample>{
	@Autowired
	private ProPaintMapper proPaintMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param proPaint
	 * @return
	 */
	 public PageInfo<ProPaint> list(Tablepar tablepar,ProPaint proPaint){
	        ProPaintExample testExample=new ProPaintExample();
			//搜索
		 	ProPaintExample.Criteria criteria= testExample.createCriteria();
			if(StrUtil.isNotEmpty(proPaint.getCreateBy())) {
			 criteria.andCreateByEqualTo(proPaint.getCreateBy());
			}
			if(proPaint.getFinish()!=null){
			 criteria.andFinishEqualTo(proPaint.getFinish());
			}
			if(StrUtil.isNotEmpty(proPaint.getUid())){
			 criteria.andUidEqualTo(proPaint.getUid());
			}
			if(StrUtil.isNotEmpty(proPaint.getName())){
			 criteria.andNameEqualTo(proPaint.getName());
			}
			if(StrUtil.isNotEmpty(proPaint.getKind())){
			 criteria.andKindEqualTo(proPaint.getKind());
			}

			if(proPaint.getRate()!=null){
			 criteria.andRateEqualTo(proPaint.getRate());
			}
			if(proPaint.getIsDel()!=null){
			 criteria.andIsDelEqualTo(proPaint.getIsDel());
			}
			testExample.setOrderByClause("uid ASC");
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			 testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
			}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProPaint> list= proPaintMapper.selectByExample(testExample);
	        PageInfo<ProPaint> pageInfo = new PageInfo<ProPaint>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			ProPaintExample example=new ProPaintExample();
			example.createCriteria().andUidIn(lista);
			return proPaintMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ProPaint selectByPrimaryKey(String id) {
				
			return proPaintMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProPaint record) {
		return proPaintMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProPaint record) {
				
		//添加雪花主键id
		return proPaintMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProPaint record, ProPaintExample example) {
		
		return proPaintMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProPaint record, ProPaintExample example) {
		
		return proPaintMapper.updateByExample(record, example);
	}

	@Override
	public List<ProPaint> selectByExample(ProPaintExample example) {
		
		return proPaintMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProPaintExample example) {
		
		return proPaintMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProPaintExample example) {
		
		return proPaintMapper.deleteByExample(example);
	}

	public Map<String,Object> selectRewardSum(String userid) {

		return proPaintMapper.selectRewardSum(userid);

	}

	/**
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		String[] strings = ConvertUtil.toStrArray(",", ids);
		List<String> stringB = Arrays.asList(strings);

		return proPaintMapper.deleteBatchByPrimaryKey(stringB);
	}

	public Map<String,Object> selectFinPartCount(ProPaint record) {

		return proPaintMapper.selectFinPartCount(record);

	}
}
