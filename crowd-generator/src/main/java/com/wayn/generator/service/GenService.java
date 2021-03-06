package com.wayn.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wayn.generator.domain.TableInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 代码生成service
 */
public interface GenService extends IService<TableInfo> {
    /**
     * 查询ry数据库表信息
     *
     *
     * @param page
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    public Page<TableInfo> selectTableList(Page<TableInfo> page, TableInfo tableInfo);

    /**
     * 生成代码
     *
     * @param tableName 表名称
     * @return 数据
     */
    byte[] generatorCode(String tableName);

    /**
     * 批量生成代码
     *
     * @param tableNames 表数组
     * @return 数据
     */
    byte[] generatorCode(String[] tableNames);

    /**
     * 预览代码
     * @return
     * @param tableName
     */
    Map<String, String> previewCode(String tableName);

    void export(TableInfo tableInfo, HttpServletResponse response, HttpServletRequest request) throws IOException;
}
