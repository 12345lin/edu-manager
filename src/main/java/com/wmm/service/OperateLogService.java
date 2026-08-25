package com.wmm.service;

import com.wmm.pojo.OperateLog;

/**
 * 操作日志服务接口
 */
public interface OperateLogService {

    /**
     * 记录操作日志
     * @param operateLog 操作日志对象
     */
    void insert(OperateLog operateLog);
}
