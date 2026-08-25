package com.wmm.service.impl;

import com.wmm.mapper.OperateLogMapper;
import com.wmm.pojo.OperateLog;
import com.wmm.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 操作日志服务实现类
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 记录操作日志
     * @param operateLog 操作日志对象
     */
    @Override
    public void insert(OperateLog operateLog) {
        operateLogMapper.insert(operateLog);
    }
}
