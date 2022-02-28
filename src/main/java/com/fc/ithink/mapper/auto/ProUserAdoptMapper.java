package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProUserAdopt;
import com.fc.ithink.model.auto.ProUserAdoptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户创作采纳表 ProUserAdoptMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-12 16:48:09
 */
public interface ProUserAdoptMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProUserAdoptExample example);

    int deleteByExample(ProUserAdoptExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(ProUserAdopt record);

    int insertSelective(ProUserAdopt record);

    List<ProUserAdopt> selectByExample(ProUserAdoptExample example);
		
    ProUserAdopt selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") ProUserAdopt record, @Param("example") ProUserAdoptExample example);

    int updateByExample(@Param("record") ProUserAdopt record, @Param("example") ProUserAdoptExample example); 
		
    int updateByPrimaryKeySelective(ProUserAdopt record);

    int updateByPrimaryKey(ProUserAdopt record);
  	  	
}