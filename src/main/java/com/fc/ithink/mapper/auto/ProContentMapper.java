package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProContent;
import com.fc.ithink.model.auto.ProContentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 文学创作内容 ProContentMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 16:41:14
 */
public interface ProContentMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProContentExample example);

    int deleteByExample(ProContentExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ProContent record);

    int insertSelective(ProContent record);

    List<ProContent> selectByExample(ProContentExample example);
		
    ProContent selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ProContent record, @Param("example") ProContentExample example);

    int updateByExample(@Param("record") ProContent record, @Param("example") ProContentExample example); 
		
    int updateByPrimaryKeySelective(ProContent record);

    int updateByPrimaryKey(ProContent record);


    List<ProContent> selectRecomContentByChapId(ProContent record);

    List<ProContent> selectAdoptContentByChapId(ProContent record);

    List<ProContent> selectAdoptContentByUserId(ProContent record);



    int selectAdoptCount(ProContent record);

    int deleteStsByKey(ProContent proCharpt);

    int deleteBatchByPrimaryKey(List<String> list);

    Map<String,Object> selectUserContentByPrimaryKey(String no);
  	  	
}