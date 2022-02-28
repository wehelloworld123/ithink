package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProSale;
import com.fc.ithink.model.auto.ProSaleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 作品上架表 ProSaleMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 16:03:15
 */
public interface ProSaleMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ProSaleExample example);

    int deleteByExample(ProSaleExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(ProSale record);

    int insertSelective(ProSale record);

    List<ProSale> selectByExample(ProSaleExample example);
		
    ProSale selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") ProSale record, @Param("example") ProSaleExample example);

    int updateByExample(@Param("record") ProSale record, @Param("example") ProSaleExample example); 
		
    int updateByPrimaryKeySelective(ProSale record);

    int updateByPrimaryKey(ProSale record);


    List<Map<String,Object>> selectOrderByDate(ProSale proSale);
  	  	
}