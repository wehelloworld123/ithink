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
import com.fc.ithink.mapper.auto.UserTnkcoinRecordMapper;
import com.fc.ithink.model.auto.UserTnkcoinRecord;
import com.fc.ithink.model.auto.UserTnkcoinRecordExample;
import com.fc.ithink.model.custom.Tablepar;


/**
 * 充值记录 UserTnkcoinRecordService
 * @Title: UserTnkcoinRecordService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 13:57:17  
 **/
@Service
public class UserTnkcoinRecordService implements BaseService<UserTnkcoinRecord, UserTnkcoinRecordExample>{
	@Autowired
	private UserTnkcoinRecordMapper userTnkcoinRecordMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param userTnkcoinRecord
	 * @return
	 */
	 public PageInfo<UserTnkcoinRecord> list(Tablepar tablepar,UserTnkcoinRecord userTnkcoinRecord){
	        UserTnkcoinRecordExample testExample=new UserTnkcoinRecordExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(userTnkcoinRecord);
	        }

			if(userTnkcoinRecord.getIsDel()!=null) {//小窗体
			 	testExample.createCriteria().andIsDelEqualTo(userTnkcoinRecord.getIsDel());
		 	}

			 if(StrUtil.isNotEmpty(userTnkcoinRecord.getCreateBy())) {//小窗体
				 testExample.createCriteria().andCreateByEqualTo(userTnkcoinRecord.getCreateBy());
			 }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<UserTnkcoinRecord> list= userTnkcoinRecordMapper.selectByExample(testExample);
	        PageInfo<UserTnkcoinRecord> pageInfo = new PageInfo<UserTnkcoinRecord>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			UserTnkcoinRecordExample example=new UserTnkcoinRecordExample();
			example.createCriteria().andIdIn(stringB);
			return userTnkcoinRecordMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public UserTnkcoinRecord selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return userTnkcoinRecordMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(UserTnkcoinRecord record) {
		return userTnkcoinRecordMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(UserTnkcoinRecord record) {
				
		record.setId(null);
		
				
		return userTnkcoinRecordMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(UserTnkcoinRecord record, UserTnkcoinRecordExample example) {
		
		return userTnkcoinRecordMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(UserTnkcoinRecord record, UserTnkcoinRecordExample example) {
		
		return userTnkcoinRecordMapper.updateByExample(record, example);
	}

	@Override
	public List<UserTnkcoinRecord> selectByExample(UserTnkcoinRecordExample example) {
		
		return userTnkcoinRecordMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(UserTnkcoinRecordExample example) {
		
		return userTnkcoinRecordMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(UserTnkcoinRecordExample example) {
		
		return userTnkcoinRecordMapper.deleteByExample(example);
	}


}
