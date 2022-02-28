package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProPoemset;
import com.fc.ithink.model.auto.ProPoemsetExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 诗歌作品分集 ProPoemsetMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:24:22
 */
public interface ProPoemsetMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProPoemsetExample example);

    int deleteByExample(ProPoemsetExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(ProPoemset record);

    int insertSelective(ProPoemset record);

    List<ProPoemset> selectByExample(ProPoemsetExample example);
		
    ProPoemset selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") ProPoemset record, @Param("example") ProPoemsetExample example);

    int updateByExample(@Param("record") ProPoemset record, @Param("example") ProPoemsetExample example); 
		
    int updateByPrimaryKeySelective(ProPoemset record);

    int updateByPrimaryKey(ProPoemset record);



    int insertBatch(List<ProPoemset> list);



    List<ProPoemset> selectChaptByCreateBy(ProPoemset record);



    Map<String,Object> selectChaptCountByPoetryId(ProPoemset record);

    Map<String,Object> queryProductInfoByChaptId(ProPoemset record);

    List<Map<String,Object>> queryRootInfo(ProPoemset record);

    List<Map<String,Object>> queryNoRootChaptInfo(ProPoemset record);

    List<ProPoemset> queryAdoptContentByPoetryId(ProPoemset proCharpt);

    int deleteStsByKey(ProPoemset proCharpt);

    int deleteBatchByPrimaryKey(List<Long> list);
  	  	
}