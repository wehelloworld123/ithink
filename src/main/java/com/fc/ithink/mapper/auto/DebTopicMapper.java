package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.DebTopic;
import com.fc.ithink.model.auto.DebTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 论题信息 DebTopicMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 15:14:38
 */
public interface DebTopicMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(DebTopicExample example);

    int deleteByExample(DebTopicExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(DebTopic record);

    int insertSelective(DebTopic record);

    List<DebTopic> selectByExample(DebTopicExample example);
		
    DebTopic selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") DebTopic record, @Param("example") DebTopicExample example);

    int updateByExample(@Param("record") DebTopic record, @Param("example") DebTopicExample example); 
		
    int updateByPrimaryKeySelective(DebTopic record);

    int updateByPrimaryKey(DebTopic record);
  	  	
}