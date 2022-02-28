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
import com.fc.ithink.mapper.auto.UserCashoutApplyMapper;
import com.fc.ithink.model.auto.UserCashoutApply;
import com.fc.ithink.model.auto.UserCashoutApplyExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 提现申请管理 UserCashoutApplyService
 * @Title: UserCashoutApplyService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 14:41:23  
 **/
@Service
public class UserCashoutApplyService implements BaseService<UserCashoutApply, UserCashoutApplyExample>{
	@Autowired
	private UserCashoutApplyMapper userCashoutApplyMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<UserCashoutApply> list(Tablepar tablepar,UserCashoutApply userCashoutApply){
	        UserCashoutApplyExample testExample=new UserCashoutApplyExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(userCashoutApply);
	        }
			 if(StrUtil.isNotEmpty(userCashoutApply.getCreateBy())) {//小窗体
				 testExample.createCriteria().andCreateByEqualTo(userCashoutApply.getCreateBy());
			 }

			 if(userCashoutApply.getIsDel()!=null) {//小窗体
				 testExample.createCriteria().andIsDelEqualTo(userCashoutApply.getIsDel());
			 }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<UserCashoutApply> list= userCashoutApplyMapper.selectByExample(testExample);
	        PageInfo<UserCashoutApply> pageInfo = new PageInfo<UserCashoutApply>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			UserCashoutApplyExample example=new UserCashoutApplyExample();
			example.createCriteria().andIdIn(stringB);
			return userCashoutApplyMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public UserCashoutApply selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return userCashoutApplyMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(UserCashoutApply record) {
		return userCashoutApplyMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(UserCashoutApply record) {
				
		record.setId(null);
		
				
		return userCashoutApplyMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(UserCashoutApply record, UserCashoutApplyExample example) {
		
		return userCashoutApplyMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(UserCashoutApply record, UserCashoutApplyExample example) {
		
		return userCashoutApplyMapper.updateByExample(record, example);
	}

	@Override
	public List<UserCashoutApply> selectByExample(UserCashoutApplyExample example) {
		
		return userCashoutApplyMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(UserCashoutApplyExample example) {
		
		return userCashoutApplyMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(UserCashoutApplyExample example) {
		
		return userCashoutApplyMapper.deleteByExample(example);
	}


}
