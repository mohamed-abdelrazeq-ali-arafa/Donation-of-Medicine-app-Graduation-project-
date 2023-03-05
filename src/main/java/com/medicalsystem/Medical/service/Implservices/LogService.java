package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.ILogRepository;
import com.medicalsystem.Medical.service.entity.Log;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.services.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService {
    ILogRepository logRepository;

    @Autowired
    public LogService( ILogRepository logRepository){
        this.logRepository=logRepository;
    }

    @Override
    public Response addLog(Log log) {
        var res=new Response();
        logRepository.save(log);
        res.make("Success Insert of Log",201,log);
        return res;

    }

    @Override
    public Response deleteLog(String id) {
        var res=new Response();
        Log tempLog=logRepository.findById(id).orElse(null);
        if(tempLog==null)
            res.make("Failed Deletion of Log with this id ",400,null);
        else {
            res.make("Success Deleteion of Log", 201, tempLog);
            logRepository.deleteById(id);
        }
        return res;
    }

    @Override
    public Response getLog(String id) {
        var res=new Response();
        Log tempLog=logRepository.findById(id).orElse(null);
        if(tempLog==null)
            res.make("Failed There is No Log with this id",400,null);
        else {
            res.make("Success Retrive of Log", 201, tempLog);

        }
        return res;
    }

    @Override
    public Response getAllLog() {
        var res=new Response();
        List<Log> logs= logRepository.findAll();
        res.make("Sucess retrive of log",200,logs);
        return res;
    }

    @Override
    public Response updatelog(String id, Log log) {
        var res=new Response();
        Log tempLog=logRepository.findById(id).orElse(null);
        if(tempLog==null)
            res.make("Failed There is No Log with this id",400,null);
        else {
            tempLog.setCreatedAt(log.getCreatedAt());
            tempLog.setTitle(log.getTitle());
            tempLog.setDiscreption(log.getDiscreption());
            tempLog.setCreatedBy(log.getCreatedBy());
            logRepository.save(tempLog);
            res.make("Sucess Update of log",200,tempLog);

        }
        return res;

    }
}
