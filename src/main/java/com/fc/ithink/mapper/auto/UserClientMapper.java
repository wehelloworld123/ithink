package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.UserClient;
import com.fc.ithink.model.auto.UserClientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户设备表 UserClientMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-10 10:24:20
 */
public interface UserClientMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(UserClientExample example);

    int deleteByExample(UserClientExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(UserClient record);

    int insertSelective(UserClient record);

    List<UserClient> selectByExample(UserClientExample example);
		
    UserClient selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") UserClient record, @Param("example") UserClientExample example);

    int updateByExample(@Param("record") UserClient record, @Param("example") UserClientExample example); 
		
    int updateByPrimaryKeySelective(UserClient record);

    int updateByPrimaryKey(UserClient record);
  	  	
}