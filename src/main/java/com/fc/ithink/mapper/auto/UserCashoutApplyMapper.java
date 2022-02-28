package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.UserCashoutApply;
import com.fc.ithink.model.auto.UserCashoutApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 提现申请管理 UserCashoutApplyMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 14:41:23
 */
public interface UserCashoutApplyMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(UserCashoutApplyExample example);

    int deleteByExample(UserCashoutApplyExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(UserCashoutApply record);

    int insertSelective(UserCashoutApply record);

    List<UserCashoutApply> selectByExample(UserCashoutApplyExample example);
		
    UserCashoutApply selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") UserCashoutApply record, @Param("example") UserCashoutApplyExample example);

    int updateByExample(@Param("record") UserCashoutApply record, @Param("example") UserCashoutApplyExample example); 
		
    int updateByPrimaryKeySelective(UserCashoutApply record);

    int updateByPrimaryKey(UserCashoutApply record);
  	  	
}