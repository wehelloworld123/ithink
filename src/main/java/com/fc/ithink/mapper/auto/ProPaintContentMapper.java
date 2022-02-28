package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProPaintContent;
import com.fc.ithink.model.auto.ProPaintContentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 绘画创作内容 ProPaintContentMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:27:22
 */
public interface ProPaintContentMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProPaintContentExample example);

    int deleteByExample(ProPaintContentExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ProPaintContent record);

    int insertSelective(ProPaintContent record);

    List<ProPaintContent> selectByExample(ProPaintContentExample example);
		
    ProPaintContent selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ProPaintContent record, @Param("example") ProPaintContentExample example);

    int updateByExample(@Param("record") ProPaintContent record, @Param("example") ProPaintContentExample example); 
		
    int updateByPrimaryKeySelective(ProPaintContent record);

    int updateByPrimaryKey(ProPaintContent record);








    List<ProPaintContent> selectRecomContentByPartId(ProPaintContent record);

    List<ProPaintContent> selectAdoptContentByPartId(ProPaintContent record);

    List<ProPaintContent> selectAdoptContentByUserId(ProPaintContent record);



    int selectAdoptCount(ProPaintContent record);

    int deleteStsByKey(ProPaintContent proCharpt);

    int deleteBatchByPrimaryKey(List<String> list);


    Map<String,Object>  selectUserContentByPrimaryKey(String no);
  	  	
}