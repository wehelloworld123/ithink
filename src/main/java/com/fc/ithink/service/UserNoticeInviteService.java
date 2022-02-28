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
import com.fc.ithink.mapper.auto.UserNoticeInviteMapper;
import com.fc.ithink.model.auto.UserNoticeInvite;
import com.fc.ithink.model.auto.UserNoticeInviteExample;
import com.fc.ithink.model.custom.Tablepar;

/**
 * 用户邀请通知 UserNoticeInviteService
 * @Title: UserNoticeInviteService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-04 09:49:12  
 **/
@Service
public class UserNoticeInviteService implements BaseService<UserNoticeInvite, UserNoticeInviteExample>{
	@Autowired
	private UserNoticeInviteMapper userNoticeInviteMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<UserNoticeInvite> list(Tablepar tablepar,UserNoticeInvite userNoticeInvite){
	        UserNoticeInviteExample testExample=new UserNoticeInviteExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(userNoticeInvite);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<UserNoticeInvite> list= userNoticeInviteMapper.selectByExample(testExample);
	        PageInfo<UserNoticeInvite> pageInfo = new PageInfo<UserNoticeInvite>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			UserNoticeInviteExample example=new UserNoticeInviteExample();
			example.createCriteria().andIdIn(stringB);
			return userNoticeInviteMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public UserNoticeInvite selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return userNoticeInviteMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(UserNoticeInvite record) {
		return userNoticeInviteMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(UserNoticeInvite record) {
				
		record.setId(null);
		
				
		return userNoticeInviteMapper.insertSelective(record);
	}

	public List<UserNoticeInvite> selectNoticeInviteByCondition(UserNoticeInvite record) {

		UserNoticeInviteExample example = new UserNoticeInviteExample();

		UserNoticeInviteExample.Criteria criteria = example.createCriteria();
		criteria.andInviteeIdEqualTo(record.getInviteeId());
		criteria.andInvitorIdEqualTo(record.getInvitorId());
		criteria.andProNoEqualTo(record.getProNo());
		criteria.andIsDelEqualTo(0);


		return userNoticeInviteMapper.selectByExample(example);
	}
	
	@Override
	public int updateByExampleSelective(UserNoticeInvite record, UserNoticeInviteExample example) {
		
		return userNoticeInviteMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(UserNoticeInvite record, UserNoticeInviteExample example) {
		
		return userNoticeInviteMapper.updateByExample(record, example);
	}

	@Override
	public List<UserNoticeInvite> selectByExample(UserNoticeInviteExample example) {
		
		return userNoticeInviteMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(UserNoticeInviteExample example) {
		
		return userNoticeInviteMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(UserNoticeInviteExample example) {
		
		return userNoticeInviteMapper.deleteByExample(example);
	}


}
