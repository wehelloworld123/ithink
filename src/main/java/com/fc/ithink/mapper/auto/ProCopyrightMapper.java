package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProCopyright;
import com.fc.ithink.model.auto.ProCopyrightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 作品版权分配 ProCopyrightMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 15:53:57
 */
public interface ProCopyrightMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProCopyrightExample example);

    int deleteByExample(ProCopyrightExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(ProCopyright record);

    int insertSelective(ProCopyright record);

    List<ProCopyright> selectByExample(ProCopyrightExample example);

    List<ProCopyright> selectByCondition(ProCopyright proCopyright);
		
    ProCopyright selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") ProCopyright record, @Param("example") ProCopyrightExample example);

    int updateByExample(@Param("record") ProCopyright record, @Param("example") ProCopyrightExample example); 
		
    int updateByPrimaryKeySelective(ProCopyright record);

    int updateByPrimaryKey(ProCopyright record);
  	  	
}