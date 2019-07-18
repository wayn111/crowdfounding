package com.wayn.web.controller.monitor;

import com.wayn.commom.base.BaseControlller;
import com.wayn.framework.annotation.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/monitor")
public class MonitorController extends BaseControlller {

	@Log(value = "数据源监控")
	@RequiresPermissions("monitor:system:driud")
	@GetMapping
	public String monitorindex(Model model) {
		return redirectTo("/druid");
	}
}
