package com.fc.ithink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseService;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.mapper.auto.ProCertificateMapper;
import com.fc.ithink.model.auto.ProCertificate;
import com.fc.ithink.model.auto.ProCertificateExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.util.SnowflakeIdWorker;
import com.fc.ithink.util.StringUtils;

/**
 * 作品证明表 ProCertificateService
 * @Title: ProCertificateService.java 
 * @Package com.fc.test.service 
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2020-11-23 21:55:50  
 **/
@Service
public class ProCertificateService implements BaseService<ProCertificate, ProCertificateExample>{
	@Autowired
	private ProCertificateMapper proCertificateMapper;


	/**
	 * 分页查询
	 * @param tablepar
	 * @param record
	 * @return
	 */
	public PageInfo<ProCertificate> list(Tablepar tablepar,ProCertificate record){
		ProCertificateExample testExample=new ProCertificateExample();
		testExample.createCriteria().andLikeQuery(record);
		testExample.setOrderByClause("certid ASC");
		if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
		}
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<ProCertificate> list= proCertificateMapper.selectByExample(testExample);
		PageInfo<ProCertificate> pageInfo = new PageInfo<ProCertificate>(list);
		return  pageInfo;
	}

	@Override
	public int deleteByPrimaryKey(String ids) {

		List<String> lista=ConvertUtil.toListStrArray(ids);
		ProCertificateExample example=new ProCertificateExample();
		example.createCriteria().andCertidIn(lista);
		return proCertificateMapper.deleteByExample(example);


	}


	@Override
	public ProCertificate selectByPrimaryKey(String id) {

		return proCertificateMapper.selectByPrimaryKey(id);

	}


	@Override
	public int updateByPrimaryKeySelective(ProCertificate record) {
		return proCertificateMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProCertificate record) {

		//添加雪花主键id
		record.setCertid(SnowflakeIdWorker.getUUID());


		return proCertificateMapper.insertSelective(record);
	}


	@Override
	public int updateByExampleSelective(ProCertificate record, ProCertificateExample example) {

		return proCertificateMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(ProCertificate record, ProCertificateExample example) {

		return proCertificateMapper.updateByExample(record, example);
	}

	@Override
	public List<ProCertificate> selectByExample(ProCertificateExample example) {

		return proCertificateMapper.selectByExample(example);
	}


	@Override
	public long countByExample(ProCertificateExample example) {

		return proCertificateMapper.countByExample(example);
	}


	@Override
	public int deleteByExample(ProCertificateExample example) {

		return proCertificateMapper.deleteByExample(example);
	}

	/**
	 * 检查name
	 * @param proCertificate
	 * @return
	 */
	public int checkNameUnique(ProCertificate proCertificate){
		ProCertificateExample example=new ProCertificateExample();
		example.createCriteria().andAppidEqualTo(proCertificate.getAppid());
		List<ProCertificate> list=proCertificateMapper.selectByExample(example);
		return list.size();
	}

	public List<ProCertificate> selectByProNoAndSts(String proNo,String status) {
		ProCertificateExample example = new ProCertificateExample();
		example.createCriteria().andProNoEqualTo(proNo);
		example.createCriteria().andSignStatusEqualTo(status);
		example.createCriteria().andIsDelEqualTo(0);
		return proCertificateMapper.selectByExample(example);

	}


	public int updateSignStatusByProNo(String proNo,String preSts,ProCertificate record) {
		ProCertificateExample example = new ProCertificateExample();
		example.createCriteria().andProNoEqualTo(proNo);
		example.createCriteria().andSignStatusEqualTo(preSts);
		example.createCriteria().andIsDelEqualTo(0);

		return proCertificateMapper.updateByExampleSelective(record,example);
	}
}
