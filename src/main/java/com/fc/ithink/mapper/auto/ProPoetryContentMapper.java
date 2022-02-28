package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProPoetryContent;
import com.fc.ithink.model.auto.ProPoetryContentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 诗歌创作内容 ProPoetryContentMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:25:00
 */
public interface ProPoetryContentMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProPoetryContentExample example);

    int deleteByExample(ProPoetryContentExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ProPoetryContent record);

    int insertSelective(ProPoetryContent record);

    List<ProPoetryContent> selectByExample(ProPoetryContentExample example);
		
    ProPoetryContent selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ProPoetryContent record, @Param("example") ProPoetryContentExample example);

    int updateByExample(@Param("record") ProPoetryContent record, @Param("example") ProPoetryContentExample example); 
		
    int updateByPrimaryKeySelective(ProPoetryContent record);

    int updateByPrimaryKey(ProPoetryContent record);

    List<ProPoetryContent> selectRecomContentByChaptId(ProPoetryContent record);

    List<ProPoetryContent> selectAdoptContentByChaptId(ProPoetryContent record);

    List<ProPoetryContent> selectAdoptContentByUserId(ProPoetryContent record);

    int selectAdoptCount(ProPoetryContent record);

    int deleteStsByKey(ProPoetryContent proCharpt);

    int deleteBatchByPrimaryKey(List<String> list);

    Map<String,Object> selectUserContentByPrimaryKey(String no);
  	  	
}