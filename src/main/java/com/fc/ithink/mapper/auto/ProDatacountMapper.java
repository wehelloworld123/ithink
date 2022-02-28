package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProDatacount;
import com.fc.ithink.model.auto.ProDatacountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ProDatacountMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-21 21:11:18
 */
public interface ProDatacountMapper {
      	   	      	      	      
    long countByExample(ProDatacountExample example);

    int deleteByExample(ProDatacountExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ProDatacount record);

    int insertSelective(ProDatacount record);

    List<ProDatacount> selectByExample(ProDatacountExample example);
		
    ProDatacount selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ProDatacount record, @Param("example") ProDatacountExample example);

    int updateByExample(@Param("record") ProDatacount record, @Param("example") ProDatacountExample example); 
		
    int updateByPrimaryKeySelective(ProDatacount record);

    int updateByPrimaryKey(ProDatacount record);
  	  	
}