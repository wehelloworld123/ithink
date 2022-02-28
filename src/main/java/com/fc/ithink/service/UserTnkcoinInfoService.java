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
import com.fc.ithink.mapper.auto.UserTnkcoinInfoMapper;
import com.fc.ithink.model.auto.UserTnkcoinInfo;
import com.fc.ithink.model.auto.UserTnkcoinInfoExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 用户充值信息 UserTnkcoinInfoService
 * @Title: UserTnkcoinInfoService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 13:07:35  
 **/
@Service
public class UserTnkcoinInfoService implements BaseService<UserTnkcoinInfo, UserTnkcoinInfoExample>{
	@Autowired
	private UserTnkcoinInfoMapper userTnkcoinInfoMapper;
	
      	   	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<UserTnkcoinInfo> list(Tablepar tablepar,UserTnkcoinInfo userTnkcoinInfo){
	        UserTnkcoinInfoExample testExample=new UserTnkcoinInfoExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(userTnkcoinInfo);
	        }

			 if(StrUtil.isNotEmpty(userTnkcoinInfo.getCreateBy())) {//小窗体
				 testExample.createCriteria().andCreateByEqualTo(userTnkcoinInfo.getCreateBy());
			 }
			 if(userTnkcoinInfo.getIsDel()!=null) {//小窗体
				 testExample.createCriteria().andIsDelEqualTo(userTnkcoinInfo.getIsDel());
			 }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<UserTnkcoinInfo> list= userTnkcoinInfoMapper.selectByExample(testExample);
	        PageInfo<UserTnkcoinInfo> pageInfo = new PageInfo<UserTnkcoinInfo>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			UserTnkcoinInfoExample example=new UserTnkcoinInfoExample();
			example.createCriteria().andIdIn(stringB);
			return userTnkcoinInfoMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public UserTnkcoinInfo selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return userTnkcoinInfoMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(UserTnkcoinInfo record) {
		return userTnkcoinInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(UserTnkcoinInfo record) {
				
		record.setId(null);
		
				
		return userTnkcoinInfoMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(UserTnkcoinInfo record, UserTnkcoinInfoExample example) {
		
		return userTnkcoinInfoMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(UserTnkcoinInfo record, UserTnkcoinInfoExample example) {
		
		return userTnkcoinInfoMapper.updateByExample(record, example);
	}

	@Override
	public List<UserTnkcoinInfo> selectByExample(UserTnkcoinInfoExample example) {
		
		return userTnkcoinInfoMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(UserTnkcoinInfoExample example) {
		
		return userTnkcoinInfoMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(UserTnkcoinInfoExample example) {
		
		return userTnkcoinInfoMapper.deleteByExample(example);
	}

	public UserTnkcoinInfo selectUserTnkcoinByuserid(String userId){
		UserTnkcoinInfoExample example=new UserTnkcoinInfoExample();
		example.createCriteria().andUseridEqualTo(userId);
		List<UserTnkcoinInfo> list=userTnkcoinInfoMapper.selectByExample(example);

		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
