package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.UserTnkcoinInfo;
import com.fc.ithink.model.auto.UserTnkcoinInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户充值信息 UserTnkcoinInfoMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 13:07:35
 */
public interface UserTnkcoinInfoMapper {
      	   	      	      	      	      	      	      	      
    long countByExample(UserTnkcoinInfoExample example);

    int deleteByExample(UserTnkcoinInfoExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(UserTnkcoinInfo record);

    int insertSelective(UserTnkcoinInfo record);

    List<UserTnkcoinInfo> selectByExample(UserTnkcoinInfoExample example);
		
    UserTnkcoinInfo selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") UserTnkcoinInfo record, @Param("example") UserTnkcoinInfoExample example);

    int updateByExample(@Param("record") UserTnkcoinInfo record, @Param("example") UserTnkcoinInfoExample example); 
		
    int updateByPrimaryKeySelective(UserTnkcoinInfo record);

    int updateByPrimaryKey(UserTnkcoinInfo record);
  	  	
}