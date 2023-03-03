package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.Log;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILogService {

    public void addLog(Log log);

    public void deleteLog(String id);
    public Log getLog(String id);
    public List<Log> getAllLog();
    public void updatelOG(String id, @RequestBody Log log);


}
