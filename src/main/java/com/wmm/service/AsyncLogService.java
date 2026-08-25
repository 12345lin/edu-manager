package com.wmm.service;

import com.wmm.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncLogService {

    @Autowired
    private OperateLogService operateLogService;

    @Async
    public void saveLogAsync(OperateLog operateLog) {
        try {
            operateLogService.insert(operateLog);
        } catch (Exception e) {
            log.error("异步记录操作日志失败", e);
        }
    }
}