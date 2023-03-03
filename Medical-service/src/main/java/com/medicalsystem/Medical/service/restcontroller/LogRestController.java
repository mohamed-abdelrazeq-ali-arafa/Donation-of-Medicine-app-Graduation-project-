package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.entity.Log;
import com.medicalsystem.Medical.service.entity.Stock;
import com.medicalsystem.Medical.service.services.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/log")
public class LogRestController {

    ILogService logService;
    @Autowired
    public LogRestController (ILogService stockService){
        this.logService =stockService;

    }

    @RequestMapping(value="/addlog",method = RequestMethod.POST)
    public Log addLog(@RequestBody Log log){
        logService.addLog(log);
        return log;

    }

    @RequestMapping(value="/getlog/{theid}",method = RequestMethod.GET)
    public Log  getLog(@PathVariable String theid){
        return  logService.getLog(theid);

    }
    @RequestMapping(value="/getalllog",method = RequestMethod.GET)
    public List<Log> getAllLog(){
        return  logService.getAllLog();

    }
    @RequestMapping(value="/deletelog/{theid}",method = RequestMethod.DELETE)
    public String deleteLog(@PathVariable String theid){
        logService.deleteLog(theid);
        return "Log deleted with Id is  "+theid;
    }

    @RequestMapping(value="/updatelog/{theid}",method = RequestMethod.PUT)
    public void updatelog(@PathVariable String theid,@RequestBody Log log){

        logService.updatelOG(theid,log);


    }
}
