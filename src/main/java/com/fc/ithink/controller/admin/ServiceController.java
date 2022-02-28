package com.fc.ithink.controller.admin;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.model.auto.*;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.ProDatacountService;
import com.fc.ithink.service.ProSaleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * 服务器信息Controller
 * @ClassName: ServiceController
 * @author fuce
 * @date 2019-06-23 00:55
 * @version V1.0
 */
@Api(value = "服务器信息")
@Controller
@RequestMapping("/ServiceController")
public class ServiceController extends BaseController{

	//跳转页面参数
	private final String prefix = "admin/service";

	@Autowired
	private ProSaleService proSaleService;
	@Autowired
	private ProDatacountService proDatacountService;
	
	/**
	 * 展示页面
	 * @param model
	 * @return
	 * @author fuce
	 * @Date 2019年11月11日 下午4:04:03
	 */
	@ApiOperation(value = "展示页面", notes = "展示页面")
	@GetMapping("/view")
	@RequiresPermissions("system:service:view")
    public String view(ModelMap model)
    {
    	List<SysNotice> sysNotices= sysNoticeService.getNEW();
    	//List<TsysOperLog> sysOperLog=sysOperLogService.getNEW();
		Tablepar tablepar = new Tablepar();

		tablepar.setPage(0);
		tablepar.setLimit(5);
		List<Map<String,Object>> proSales = proSaleService.selectByCondition(tablepar,new ProSale());
		//List<ProDatacount> dataCounts = new ArrayList<>();
		List<ProDatacount> proDatacounts = proDatacountService.selectByExample(new ProDatacountExample());
		int count = 0;
		for(ProDatacount datacount : proDatacounts){

			if("01".equals(datacount.getDataType())){
				count += datacount.getDataCount();
			}
			if("02".equals(datacount.getDataType())){
				count += datacount.getDataCount();
			}
			if("03".equals(datacount.getDataType())){
				count += datacount.getDataCount();
			}
		}
		proDatacounts.add(new ProDatacount(null,count,"4"));
		if(proSales!=null&&proSales.size()>0){
			for(Map map : proSales){
				if((Integer)map.get("typ")==1){
					map.put("typ","文学作品");
				}else if((Integer)map.get("typ")==2){
					map.put("typ","绘画作品");
				}else if((Integer)map.get("typ")==3){
					map.put("typ","诗词作品");
				}else{}
			}
		}
		if(sysNotices==null||sysNotices.size()<=0){
    		SysNotice sysNotice=new SysNotice();
    		sysNotice.setId("0");
    		sysNotice.setTitle("暂无公告");
    		sysNotice.setCreateTime(new Date());
    		sysNotices.add(sysNotice);
		}

		ProSale record = new ProSale();
		record.setSaleStatus("0");

		tablepar.setPage(0);
		tablepar.setLimit(12);

		PageInfo<ProSale> pageInfo = proSaleService.listByExample(tablepar,record);
		List<ProSale> list = pageInfo.getList();
		List<ProSale> proSale1 = new ArrayList<>();
		List<ProSale> proSale2 = new ArrayList<>();
		List<ProSale> proSale3 = new ArrayList<>();
		for(int i =0;i<list.size();i++){
			if(i<3){
				proSale1.add(list.get(i));
			}else if(i<6){
				proSale2.add(list.get(i));
			}else if(i<9){
				proSale3.add(list.get(i));
			}

		}
		model.addAttribute("proSale1",proSale1);
		model.addAttribute("proSale2",proSale2);
		model.addAttribute("proSale3",proSale3);
		//model.addAttribute("service", new Service());
		model.addAttribute("sysNotices", sysNotices);
		model.addAttribute("proDatacounts", proDatacounts);
		//model.addAttribute("sysOperLog", sysOperLog);
		model.addAttribute("proSales", proSales);
        return prefix + "/list";
    }
}
