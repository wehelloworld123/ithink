package com.fc.ithink.service;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.ProLiterMapper;
import com.fc.ithink.model.auto.ProLiter;
import com.fc.ithink.model.auto.ProLiterExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.StringUtils;

/**
 * 文学创作信息表 ProLiterService
 * @Title: ProLiterService.java 
 * @Package com.fc.v2.service 
 * @author xy_自动生成
 * @email ${email}
 * @date 2021-05-27 16:40:31  
 **/
@Service
public class ProLiterService implements BaseService<ProLiter, ProLiterExample>{
	@Autowired
	private ProLiterMapper proLiterMapper;


	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProLiter> list(Tablepar tablepar,ProLiter record){
		ProLiterExample testExample=new ProLiterExample();

		ProLiterExample.Criteria criteria= testExample.createCriteria();
		if(StrUtil.isNotEmpty(record.getCreateBy())) {
			criteria.andCreateByEqualTo(record.getCreateBy());
		}
		if(record.getFinish()!=null){
			criteria.andFinishEqualTo(record.getFinish());
		}
		if(StrUtil.isNotEmpty(record.getUid())){
			criteria.andUidEqualTo(record.getUid());
		}
		if(StrUtil.isNotEmpty(record.getName())){
			criteria.andNameEqualTo(record.getName());
		}
		if(StrUtil.isNotEmpty(record.getTyp())){
			criteria.andTypEqualTo(record.getTyp());
		}
		if(StrUtil.isNotEmpty(record.getName())){
			criteria.andNameLike(record.getName());
		}
		if(record.getRate()!=null){
			criteria.andRateEqualTo(record.getRate());
		}
		if(record.getIsDel()!=null){
			criteria.andIsDelEqualTo(record.getIsDel());
		}
		testExample.setOrderByClause("uid ASC");
		if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
		}
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProLiter> list= proLiterMapper.selectByExample(testExample);
		PageInfo<ProLiter> pageInfo = new PageInfo<ProLiter>(list);
		return  pageInfo;
	}

	@Override
	public int deleteByPrimaryKey(String ids) {

		List<String> lista=ConvertUtil.toListStrArray(ids);
		ProLiterExample example=new ProLiterExample();
		example.createCriteria().andUidIn(lista);
		return proLiterMapper.deleteByExample(example);


	}


	@Override
	public ProLiter selectByPrimaryKey(String id) {

		return proLiterMapper.selectByPrimaryKey(id);

	}

	public Map<String,Object> selectFinChapterCount(ProLiter record) {

		return proLiterMapper.selectFinChapterCount(record);

	}
	public Map<String,Object> selectRewardSum(String userid) {

		return proLiterMapper.selectRewardSum(userid);

	}


	@Override
	public int updateByPrimaryKeySelective(ProLiter record) {
		return proLiterMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProLiter record) {



		return proLiterMapper.insertSelective(record);
	}


	@Override
	public int updateByExampleSelective(ProLiter record, ProLiterExample example) {

		return proLiterMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(ProLiter record, ProLiterExample example) {

		return proLiterMapper.updateByExample(record, example);
	}

	@Override
	public List<ProLiter> selectByExample(ProLiterExample example) {

		return proLiterMapper.selectByExample(example);
	}

	@Override
	public long countByExample(ProLiterExample example) {

		return proLiterMapper.countByExample(example);
	}


	@Override
	public int deleteByExample(ProLiterExample example) {

		return proLiterMapper.deleteByExample(example);
	}

	public int deleteStsByKey(ProLiter proLiter) {

		return proLiterMapper.deleteStsByKey(proLiter);
	}

	/**
	 * 检查name
	 * @param ids
	 * @return
	 */
	public int deleteBatchByPrimaryKey(String ids){
		String[] strings = ConvertUtil.toStrArray(",", ids);
		List<String> stringB = Arrays.asList(strings);

		return proLiterMapper.deleteBatchByPrimaryKey(stringB);
	}

	/**
	 * 检查name
	 * @param proLiter
	 * @return
	 */
	public int checkNameUnique(ProLiter proLiter){
		ProLiterExample example=new ProLiterExample();
		example.createCriteria().andCreateByEqualTo(proLiter.getCreateBy());
		List<ProLiter> list=proLiterMapper.selectByExample(example);
		return list.size();
	}


}
