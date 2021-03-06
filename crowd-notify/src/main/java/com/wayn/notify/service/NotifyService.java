package com.wayn.notify.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wayn.notify.domain.Notify;
import org.quartz.SchedulerException;

/**
 * 通知通告 服务层
 *
 * @author wayn
 * @date 2019-08-10
 */
public interface NotifyService extends IService<Notify> {
    /**
     * 查询通知通告信息
     *
     * @param page 分页对象，自动分页
     * @return 通知通告信息
     */
    public Page<Notify> selectNotifyList(Page<Notify> page, Notify notify);

    /**
     * 新增{tableComment}
     *
     * @param notify 通知通告信息
     * @param receiveUserIds
     * @return 结果
     */
    boolean save(Notify notify, String receiveUserIds);

    /**
     * 修改通知通告
     *
     * @param notify 通知通告信息
     * @param receiveUserIds
     * @return 结果
     */
    boolean update(Notify notify, String receiveUserIds) throws SchedulerException;

    /**
     * 删除通知通告
     *
     * @param id
     * @return 结果
     */
    boolean remove(Long id) throws SchedulerException;

    /**
     * 批量删除通知通告
     *
     * @param ids
     * @return 结果
     */
    boolean batchRemove(Long[] ids) throws SchedulerException;
}
