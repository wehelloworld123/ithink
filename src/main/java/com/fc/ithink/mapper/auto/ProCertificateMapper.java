package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.ProCertificate;
import com.fc.ithink.model.auto.ProCertificateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 作品证明表 ProCertificateMapper
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2020-11-23 21:55:50
 */
public interface ProCertificateMapper {

    long countByExample(ProCertificateExample example);

    int deleteByExample(ProCertificateExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProCertificate record);

    int insertSelective(ProCertificate record);

    List<ProCertificate> selectByExample(ProCertificateExample example);

    ProCertificate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProCertificate record, @Param("example") ProCertificateExample example);

    int updateByExample(@Param("record") ProCertificate record, @Param("example") ProCertificateExample example);

    int updateByPrimaryKeySelective(ProCertificate record);

    int updateByPrimaryKey(ProCertificate record);

}