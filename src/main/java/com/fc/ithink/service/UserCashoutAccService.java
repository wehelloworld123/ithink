package com.fc.ithink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.UserCashoutAccMapper;
import com.fc.ithink.model.auto.UserCashoutAcc;
import com.fc.ithink.model.auto.UserCashoutAccExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;

/**
 * 用户提现账号 UserCashoutAccService
 * @Title: UserCashoutAccService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 14:46:25  
 **/
@Service
public class UserCashoutAccService implements BaseService<UserCashoutAcc, UserCashoutAccExample>{
	@Autowired
	private UserCashoutAccMapper userCashoutAccMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<UserCashoutAcc> list(Tablepar tablepar,UserCashoutAcc userCashoutAcc){
	        UserCashoutAccExample testExample=new UserCashoutAccExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(userCashoutAcc);
	        }
			 if(StrUtil.isNotEmpty(userCashoutAcc.getCreateBy())) {//小窗体
				 testExample.createCriteria().andCreateByEqualTo(userCashoutAcc.getCreateBy());
			 }
			 if(userCashoutAcc.getIsDel()!=null) {//小窗体
				 testExample.createCriteria().andIsDelEqualTo(userCashoutAcc.getIsDel());
			 }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("no ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<UserCashoutAcc> list= userCashoutAccMapper.selectByExample(testExample);
	        PageInfo<UserCashoutAcc> pageInfo = new PageInfo<UserCashoutAcc>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			UserCashoutAccExample example=new UserCashoutAccExample();
			example.createCriteria().andNoIn(lista);
			return userCashoutAccMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public UserCashoutAcc selectByPrimaryKey(String id) {
				
			return userCashoutAccMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(UserCashoutAcc record) {
		return userCashoutAccMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(UserCashoutAcc record) {
				
		//添加雪花主键id
		record.setNo(SnowflakeIdWorker.getUUID());
			
				
		return userCashoutAccMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(UserCashoutAcc record, UserCashoutAccExample example) {
		
		return userCashoutAccMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(UserCashoutAcc record, UserCashoutAccExample example) {
		
		return userCashoutAccMapper.updateByExample(record, example);
	}

	@Override
	public List<UserCashoutAcc> selectByExample(UserCashoutAccExample example) {
		
		return userCashoutAccMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(UserCashoutAccExample example) {
		
		return userCashoutAccMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(UserCashoutAccExample example) {
		
		return userCashoutAccMapper.deleteByExample(example);
	}


}
