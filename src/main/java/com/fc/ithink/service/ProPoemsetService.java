package com.fc.ithink.service;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.fc.ithink.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.ProPoemsetMapper;
import com.fc.ithink.model.auto.ProPoemset;
import com.fc.ithink.model.auto.ProPoemsetExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 诗歌作品分集 ProPoemsetService
 * @Title: ProPoemsetService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:24:22  
 **/
@Service
public class ProPoemsetService implements BaseService<ProPoemset, ProPoemsetExample>{
	@Autowired
	private ProPoemsetMapper proPoemsetMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param proPoemset
	 * @return
	 */
	 public PageInfo<ProPoemset> list(Tablepar tablepar,ProPoemset proPoemset,boolean pageFlag){
			 ProPoemsetExample testExample=new ProPoemsetExample();
			 ProPoemsetExample.Criteria criteria = testExample.createCriteria();
			 if(StrUtil.isNotEmpty(proPoemset.getCharpter())){
				 criteria.andCharpterLike(proPoemset.getCharpter());
			 }
			 if(StrUtil.isNotEmpty(proPoemset.getPoetryId())){
				 criteria.andPoetryIdEqualTo(proPoemset.getPoetryId());
			 }
			 if(proPoemset.getId()!=null&&proPoemset.getId()!=0){
				 criteria.andIdEqualTo(proPoemset.getId());
			 }
			 if(proPoemset.getIsDel()!=null){
				 criteria.andIsDelEqualTo(proPoemset.getIsDel());
			 }
			 if(proPoemset.getRoot()!=null){
				 criteria.andRootEqualTo(proPoemset.getRoot());
			 }
			 if(proPoemset.getIsLock()!=null){
				 criteria.andIsLockEqualTo(proPoemset.getIsLock());
			 }
			 if(proPoemset.getFinish()!=null){
				 criteria.andFinishEqualTo(proPoemset.getFinish());
			 }
			 testExample.setOrderByClause("root_ord ASC,ord ASC");
			 if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
				 testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
			 }
			 if(pageFlag) {
				 PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
			 }
	        List<ProPoemset> list= proPoemsetMapper.selectByExample(testExample);
	        PageInfo<ProPoemset> pageInfo = new PageInfo<ProPoemset>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			ProPoemsetExample example=new ProPoemsetExample();
			example.createCriteria().andIdIn(stringB);
			return proPoemsetMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public ProPoemset selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return proPoemsetMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProPoemset record) {
		return proPoemsetMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProPoemset record) {

		if(record.getRoot()!=null&&record.getRoot()==1){
			record.setIsLock(null);
		}
		
				
		return proPoemsetMapper.insertSelective(record);
	}


	public Map<String,Object> queryChapterCountByPoetryId(ProPoemset record){
		return proPoemsetMapper.selectChaptCountByPoetryId(record);
	}
	/**
	 * 批量添加
	 */
	public int inserBathcSelective(List<ProPoemset> record) {


		return proPoemsetMapper.insertBatch(record);
	}

	@Override
	public int updateByExampleSelective(ProPoemset record, ProPoemsetExample example) {
		
		return proPoemsetMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProPoemset record, ProPoemsetExample example) {
		
		return proPoemsetMapper.updateByExample(record, example);
	}

	@Override
	public List<ProPoemset> selectByExample(ProPoemsetExample example) {
		
		return proPoemsetMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProPoemsetExample example) {
		
		return proPoemsetMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProPoemsetExample example) {
		
		return proPoemsetMapper.deleteByExample(example);
	}


	public List<Map<String,Object>> queryRootInfo(ProPoemset record){
		return proPoemsetMapper.queryRootInfo(record);
	}


	public List<Map<String,Object>> queryNoRootChaptInfo(ProPoemset record){
		return proPoemsetMapper.queryNoRootChaptInfo(record);
	}

	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProPoemset> listByCreateBy(Tablepar tablepar,ProPoemset record){
		//   ProPaintPartExample testExample=new ProPaintPartExample();
	 /*       testExample.createCriteria().andLikeQuery(record);
	        testExample.setOrderByClause("id ASC");
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }*/
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProPoemset> list= proPoemsetMapper.selectChaptByCreateBy(record);
		PageInfo<ProPoemset> pageInfo = new PageInfo<ProPoemset>(list);
		return  pageInfo;
	}

	public Map<String,Object> queryProductInfoByChaptId(ProPoemset record) {

		return proPoemsetMapper.queryProductInfoByChaptId(record);
	}
}
