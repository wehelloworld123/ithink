package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProRecom;
import com.fc.ithink.model.auto.ProRecomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 创作推荐表 ProRecomMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-11 13:14:26
 */
public interface ProRecomMapper {

    long countByExample(ProRecomExample example);

    int deleteByExample(ProRecomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProRecom record);

    int insertSelective(ProRecom record);

    List<ProRecom> selectByExample(ProRecomExample example);

    List<ProRecom> select(@Param("no") String no);

    ProRecom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProRecom record, @Param("example") ProRecomExample example);

    int updateByExample(@Param("record") ProRecom record, @Param("example") ProRecomExample example);

    int updateByPrimaryKeySelective(ProRecom record);

    int updateByPrimaryKey(ProRecom record);

    int deleteStsByKey(ProRecom proCharpt);

    int deleteBatchByPrimaryKey(List<Long> list);
  	  	
}