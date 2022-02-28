package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProLiter;
import com.fc.ithink.model.auto.ProLiterExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 文学创作信息表 ProLiterMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 16:40:31
 */
public interface ProLiterMapper {

    long countByExample(ProLiterExample example);

    int deleteByExample(ProLiterExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProLiter record);

    int insertSelective(ProLiter record);

    List<ProLiter> selectByExample(ProLiterExample example);

    ProLiter selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProLiter record, @Param("example") ProLiterExample example);

    int updateByExample(@Param("record") ProLiter record, @Param("example") ProLiterExample example);

    int updateByPrimaryKeySelective(ProLiter record);

    int updateByPrimaryKey(ProLiter record);

    Map<String,Object> selectFinChapterCount(ProLiter record);

    int deleteStsByKey(ProLiter proCharpt);

    int deleteBatchByPrimaryKey(List<String> list);

    Map<String,Object> selectRewardSum(String userid);
  	  	
}