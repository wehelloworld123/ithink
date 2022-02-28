package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.TsysUser;
import com.fc.ithink.model.auto.TsysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TsysUserMapper {
    long countByExample(TsysUserExample example);

    int deleteByExample(TsysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TsysUser record);

    int insertSelective(TsysUser record);

    List<TsysUser> selectByExample(TsysUserExample example);

    TsysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TsysUser record, @Param("example") TsysUserExample example);

    int updateByExample(@Param("record") TsysUser record, @Param("example") TsysUserExample example);

    int updateByPrimaryKeySelective(TsysUser record);

    int updateByPrimaryKey(TsysUser record);

    List<Map<String,Object>> selectUserInfoByIdOrName(String username);

    TsysUser selectUserInfoByUserId(String id);

    TsysUser selectByUserName(String username);



    int updateUserAuthSts(TsysUser record);

    int updateUserWriteAuth(TsysUser record);


    int deleteStsByKey(TsysUser proCharpt);

    int deleteBatchByPrimaryKey(List<String> list);

    int deleteUserByPrimaryKey(List<String> list);

    int updateBatchByPrimaryKey(List<String> list);
}