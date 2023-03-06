package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Log;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILogService {

    public Response<Log> addLog(Log log);

    public Response<Log> deleteLog(String id);
    public Response<Log> getLog(String id);
    public Response<List<Log>> getAllLog();
    public Response<Log> updatelog(String id, @RequestBody Log log);


}
