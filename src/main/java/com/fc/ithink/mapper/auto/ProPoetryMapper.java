package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProPoetry;
import com.fc.ithink.model.auto.ProPoetryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 诗歌创作集 ProPoetryMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:22:57
 */
public interface ProPoetryMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProPoetryExample example);

    int deleteByExample(ProPoetryExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ProPoetry record);

    int insertSelective(ProPoetry record);

    List<ProPoetry> selectByExample(ProPoetryExample example);
		
    ProPoetry selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ProPoetry record, @Param("example") ProPoetryExample example);

    int updateByExample(@Param("record") ProPoetry record, @Param("example") ProPoetryExample example); 
		
    int updateByPrimaryKeySelective(ProPoetry record);

    int updateByPrimaryKey(ProPoetry record);

    Map<String,Object> selectFinChaptCount(ProPoetry record);

    int deleteStsByKey(ProPoetry proCharpt);

    int deleteBatchByPrimaryKey(List<String> list);

    Map<String,Object> selectRewardSum(String userid);
  	  	
}