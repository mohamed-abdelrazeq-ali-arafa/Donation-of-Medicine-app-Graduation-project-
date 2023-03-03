package com.medicalsystem.Medical.service.Implservices;

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
    public void addLog(Log log) {
        logRepository.save(log);

    }

    @Override
    public void deleteLog(String id) {
        Log tempLog=logRepository.findById(id).orElse(null);
        if(tempLog==null)
            throw new RuntimeException("There is no log with this id");
        logRepository.deleteById(id);

    }

    @Override
    public Log getLog(String id) {
        Log tempLog=logRepository.findById(id).orElse(null);
        if(tempLog==null)
            throw new RuntimeException("There is no log with this id");
        return  tempLog;
    }

    @Override
    public List<Log> getAllLog() {
        return logRepository.findAll();
    }

    @Override
    public void updatelOG(String id, Log log) {

        Log tempLog=logRepository.findById(id).orElse(null);
        if(tempLog==null)
            throw new RuntimeException("There is no Transaction with this id");

        tempLog.setCreatedAt(log.getCreatedAt());
        tempLog.setTitle(log.getTitle());
        tempLog.setDiscreption(log.getDiscreption());
        tempLog.setCreatedBy(log.getCreatedBy());

        logRepository.save(tempLog);

    }
}
