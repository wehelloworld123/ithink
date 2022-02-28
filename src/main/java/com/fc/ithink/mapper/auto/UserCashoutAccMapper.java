package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.UserCashoutAcc;
import com.fc.ithink.model.auto.UserCashoutAccExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户提现账号 UserCashoutAccMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 14:46:25
 */
public interface UserCashoutAccMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(UserCashoutAccExample example);

    int deleteByExample(UserCashoutAccExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(UserCashoutAcc record);

    int insertSelective(UserCashoutAcc record);

    List<UserCashoutAcc> selectByExample(UserCashoutAccExample example);
		
    UserCashoutAcc selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") UserCashoutAcc record, @Param("example") UserCashoutAccExample example);

    int updateByExample(@Param("record") UserCashoutAcc record, @Param("example") UserCashoutAccExample example); 
		
    int updateByPrimaryKeySelective(UserCashoutAcc record);

    int updateByPrimaryKey(UserCashoutAcc record);
  	  	
}