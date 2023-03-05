package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Log;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILogService {

    public Response addLog(Log log);

    public Response deleteLog(String id);
    public Response getLog(String id);
    public Response getAllLog();
    public Response updatelog(String id, @RequestBody Log log);


}
