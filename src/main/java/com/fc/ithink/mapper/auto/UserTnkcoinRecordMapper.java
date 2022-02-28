package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.UserTnkcoinRecord;
import com.fc.ithink.model.auto.UserTnkcoinRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 充值记录 UserTnkcoinRecordMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 13:57:17
 */
public interface UserTnkcoinRecordMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(UserTnkcoinRecordExample example);

    int deleteByExample(UserTnkcoinRecordExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(UserTnkcoinRecord record);

    int insertSelective(UserTnkcoinRecord record);

    List<UserTnkcoinRecord> selectByExample(UserTnkcoinRecordExample example);
		
    UserTnkcoinRecord selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") UserTnkcoinRecord record, @Param("example") UserTnkcoinRecordExample example);

    int updateByExample(@Param("record") UserTnkcoinRecord record, @Param("example") UserTnkcoinRecordExample example); 
		
    int updateByPrimaryKeySelective(UserTnkcoinRecord record);

    int updateByPrimaryKey(UserTnkcoinRecord record);
  	  	
}