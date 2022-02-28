package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProSubTopic;
import com.fc.ithink.model.auto.ProSubTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 专题表 ProSubTopicMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 14:57:53
 */
public interface ProSubTopicMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProSubTopicExample example);

    int deleteByExample(ProSubTopicExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ProSubTopic record);

    int insertSelective(ProSubTopic record);

    List<ProSubTopic> selectByExample(ProSubTopicExample example);
		
    ProSubTopic selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ProSubTopic record, @Param("example") ProSubTopicExample example);

    int updateByExample(@Param("record") ProSubTopic record, @Param("example") ProSubTopicExample example); 
		
    int updateByPrimaryKeySelective(ProSubTopic record);

    int updateByPrimaryKey(ProSubTopic record);
  	  	
}