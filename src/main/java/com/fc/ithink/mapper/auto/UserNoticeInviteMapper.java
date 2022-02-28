package com.fc.ithink.mapper.auto;

import com.fc.ithink.model.auto.UserNoticeInvite;
import com.fc.ithink.model.auto.UserNoticeInviteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户邀请通知 UserNoticeInviteMapper
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-06-04 09:49:12
 */
public interface UserNoticeInviteMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(UserNoticeInviteExample example);

    int deleteByExample(UserNoticeInviteExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(UserNoticeInvite record);

    int insertSelective(UserNoticeInvite record);

    List<UserNoticeInvite> selectByExample(UserNoticeInviteExample example);
		
    UserNoticeInvite selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") UserNoticeInvite record, @Param("example") UserNoticeInviteExample example);

    int updateByExample(@Param("record") UserNoticeInvite record, @Param("example") UserNoticeInviteExample example); 
		
    int updateByPrimaryKeySelective(UserNoticeInvite record);

    int updateByPrimaryKey(UserNoticeInvite record);
  	  	
}