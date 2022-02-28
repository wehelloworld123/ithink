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
import com.fc.ithink.mapper.auto.ProPaintPartMapper;
import com.fc.ithink.model.auto.ProPaintPart;
import com.fc.ithink.model.auto.ProPaintPartExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.StringUtils;

/**
 * 绘画作品分集 ProPaintPartService
 * @Title: ProPaintPartService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:26:54  
 **/
@Service
public class ProPaintPartService implements BaseService<ProPaintPart, ProPaintPartExample>{
	@Autowired
	private ProPaintPartMapper proPaintPartMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProPaintPart> list(Tablepar tablepar,ProPaintPart proPaintPart,boolean pageFlag){
			 ProPaintPartExample testExample=new ProPaintPartExample();
			 ProPaintPartExample.Criteria criteria = testExample.createCriteria();
			 if(StrUtil.isNotEmpty(proPaintPart.getSubject())){
				 criteria.andSubjectLike(proPaintPart.getSubject());
			 }
			 if(StrUtil.isNotEmpty(proPaintPart.getPaintId())){
				 criteria.andPaintIdEqualTo(proPaintPart.getPaintId());
			 }
			 if(StrUtil.isNotEmpty(proPaintPart.getSubject())){
				 criteria.andSubjectEqualTo(proPaintPart.getSubject());
			 }
			 if(proPaintPart.getId()!=null&&proPaintPart.getId()!=0){
				 criteria.andIdEqualTo(proPaintPart.getId());
			 }
			 if(proPaintPart.getIsDel()!=null){
				 criteria.andIsDelEqualTo(proPaintPart.getIsDel());
			 }
			 if(proPaintPart.getIsLock()!=null){
				 criteria.andIsLockEqualTo(proPaintPart.getIsLock());
			 }
			 if(proPaintPart.getFinish()!=null){
				 criteria.andFinishEqualTo(proPaintPart.getFinish());
			 }
			 if(proPaintPart.getRoot()!=null){
				 criteria.andRootEqualTo(proPaintPart.getRoot());
			 }
			 testExample.setOrderByClause("root_ord ASC,ord ASC");
			 if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
				 testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
			 }
			 if(pageFlag) {
				 PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
			 }
	        List<ProPaintPart> list= proPaintPartMapper.selectByExample(testExample);
	        PageInfo<ProPaintPart> pageInfo = new PageInfo<ProPaintPart>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			ProPaintPartExample example=new ProPaintPartExample();
			example.createCriteria().andIdIn(stringB);
			return proPaintPartMapper.deleteByExample(example);
		
				
	}


	public Map<String,Object> selectPartCountByPaintId(ProPaintPart record){
		return proPaintPartMapper.selectPartCountByPaintId(record);
	}


	public List<Map<String,Object>> queryRootInfo(ProPaintPart record){
		return proPaintPartMapper.queryRootInfo(record);
	}



	public List<Map<String,Object>> queryNoRootChaptInfo(ProPaintPart record){
		return proPaintPartMapper.queryNoRootChaptInfo(record);
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPaintPart> listByCreateBy(Tablepar tablepar,ProPaintPart record){
		//   ProPaintPartExample testExample=new ProPaintPartExample();
	 /*       testExample.createCriteria().andLikeQuery(record);
	        testExample.setOrderByClause("id ASC");
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }*/
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPaintPart> list= proPaintPartMapper.selectPartByCreateBy(record);
		PageInfo<ProPaintPart> pageInfo = new PageInfo<ProPaintPart>(list);
		return  pageInfo;
	}
	
	@Override
	public ProPaintPart selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return proPaintPartMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProPaintPart record) {
		return proPaintPartMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProPaintPart record) {

		if(record.getRoot()!=null&&record.getRoot()==1){
			record.setIsLock(null);
		}
		
				
		return proPaintPartMapper.insertSelective(record);
	}

	/**
	 * 批量添加
	 */
	public int insertSelective(List<ProPaintPart> record) {


		return proPaintPartMapper.insertBatch(record);
	}
	
	@Override
	public int updateByExampleSelective(ProPaintPart record, ProPaintPartExample example) {
		
		return proPaintPartMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProPaintPart record, ProPaintPartExample example) {
		
		return proPaintPartMapper.updateByExample(record, example);
	}

	@Override
	public List<ProPaintPart> selectByExample(ProPaintPartExample example) {
		
		return proPaintPartMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProPaintPartExample example) {
		
		return proPaintPartMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProPaintPartExample example) {
		
		return proPaintPartMapper.deleteByExample(example);
	}
	public Map<String,Object> queryProductInfoByChaptId(ProPaintPart record) {

		return proPaintPartMapper.queryProductInfoByChaptId(record);
	}

}
