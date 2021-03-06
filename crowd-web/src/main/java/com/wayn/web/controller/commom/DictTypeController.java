package com.wayn.web.controller.commom;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wayn.commom.annotation.Log;
import com.wayn.commom.base.BaseController;
import com.wayn.commom.domain.Dict;
import com.wayn.commom.enums.Operator;
import com.wayn.commom.service.DictService;
import com.wayn.commom.util.ParameterUtil;
import com.wayn.commom.util.Response;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 字典管理
 */
@RequestMapping("/commom/dict/type")
@Controller
public class DictTypeController extends BaseController {

    private static final String PREFIX = "commom/dict/type";

    @Autowired
    private DictService dictService;

    @RequiresPermissions("commom:dict:type")
    @GetMapping
    public String typeIndex() {
        return PREFIX + "/type";
    }

    @Log(value = "字典管理")
    @RequiresPermissions("commom:dict:type")
    @ResponseBody
    @PostMapping("/list")
    public Page<Dict> list(Model model, Dict dict) {
        Page<Dict> page = getPage();
        //设置通用查询字段
        ParameterUtil.setWrapper();
        return dictService.listPage(page, dict);
    }

    @RequiresPermissions("commom:dict:add")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        modelMap.put("type", 1);
        return PREFIX + "/add";
    }

    @RequiresPermissions("commom:dict:edit")
    @GetMapping("/edit/{id}")
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Dict dict = dictService.getById(id);
        modelMap.put("dict", dict);
        return PREFIX + "/edit";
    }

    @Log(value = "字典管理",operator = Operator.ADD)
    @RequiresPermissions("commom:dict:add")
    @ResponseBody
    @PostMapping("/addSave")
    public Response addSave(ModelMap modelMap, Dict dict) {
        dictService.save(dict);
        return Response.success("新增字典分类成功");
    }

    @Log(value = "字典管理",operator = Operator.UPDATE)
    @RequiresPermissions("commom:dict:edit")
    @ResponseBody
    @PostMapping("/editSave")
    public Response editSave(ModelMap modelMap, Dict dict) {
        dictService.update(dict);
        return Response.success("修改字典分类成功");
    }

    @Log(value = "字典管理",operator = Operator.DELETE)
    @RequiresPermissions("commom:dict:remove")
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    public Response remove(ModelMap modelMap, @PathVariable("id") Long id) {
        dictService.remove(id);
        return Response.success("删除字典分类成功");
    }

    @Log(value = "字典管理",operator = Operator.DELETE)
    @RequiresPermissions("commom:dict:remove")
    @ResponseBody
    @PostMapping("/batchRemove")
    public Response batchRemove(ModelMap modelMap, @RequestParam("ids[]") Long[] ids) {
        dictService.batchRemove(ids);
        return Response.success("删除字典分类成功");
    }

    @ResponseBody
    @PostMapping("/exists")
    public boolean exists(ModelMap modelMap, Dict dict) {
        return !dictService.exists(dict);
    }
}
