package com.fc.ithink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.UserClientMapper;
import com.fc.ithink.model.auto.UserClient;
import com.fc.ithink.model.auto.UserClientExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;

/**
 * 用户设备表 UserClientService
 * @Title: UserClientService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-10 10:24:20  
 **/
@Service
public class UserClientService implements BaseService<UserClient, UserClientExample>{
	@Autowired
	private UserClientMapper userClientMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<UserClient> list(Tablepar tablepar,UserClient userClient){
	        UserClientExample testExample=new UserClientExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(userClient);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<UserClient> list= userClientMapper.selectByExample(testExample);
	        PageInfo<UserClient> pageInfo = new PageInfo<UserClient>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			UserClientExample example=new UserClientExample();
			example.createCriteria().andIdIn(lista);
			return userClientMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public UserClient selectByPrimaryKey(String id) {
				
			return userClientMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(UserClient record) {
		return userClientMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(UserClient record) {
				
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
			
				
		return userClientMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(UserClient record, UserClientExample example) {
		
		return userClientMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(UserClient record, UserClientExample example) {
		
		return userClientMapper.updateByExample(record, example);
	}

	@Override
	public List<UserClient> selectByExample(UserClientExample example) {
		
		return userClientMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(UserClientExample example) {
		
		return userClientMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(UserClientExample example) {
		
		return userClientMapper.deleteByExample(example);
	}


}
