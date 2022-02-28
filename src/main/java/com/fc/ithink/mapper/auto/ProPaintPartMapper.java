package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProPaintPart;
import com.fc.ithink.model.auto.ProPaintPartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 绘画作品分集 ProPaintPartMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-07 14:26:54
 */
public interface ProPaintPartMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProPaintPartExample example);

    int deleteByExample(ProPaintPartExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(ProPaintPart record);

    int insertSelective(ProPaintPart record);

    List<ProPaintPart> selectByExample(ProPaintPartExample example);
		
    ProPaintPart selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") ProPaintPart record, @Param("example") ProPaintPartExample example);

    int updateByExample(@Param("record") ProPaintPart record, @Param("example") ProPaintPartExample example); 
		
    int updateByPrimaryKeySelective(ProPaintPart record);

    int updateByPrimaryKey(ProPaintPart record);

    int insertBatch(List<ProPaintPart> list);

    List<ProPaintPart> selectPartByCreateBy(ProPaintPart record);


    Map<String,Object> selectPartCountByPaintId(ProPaintPart record);

    Map<String,Object> queryProductInfoByChaptId(ProPaintPart record);

    List<Map<String,Object>> queryRootInfo(ProPaintPart record);

    List<Map<String,Object>> queryNoRootChaptInfo(ProPaintPart record);

    List<ProPaintPart> queryAdoptContentByPaintId(ProPaintPart proCharpt);

    int deleteStsByKey(ProPaintPart proCharpt);

    int deleteBatchByPrimaryKey(List<Long> list);
  	  	
}