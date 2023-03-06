package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Log;
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
    public Response<Log> addLog(@RequestBody Log log){
        Response<Log> res=logService.addLog(log);
        return res;

    }

    @RequestMapping(value="/getlog/{theid}",method = RequestMethod.GET)
    public Response<Log>  getLog(@PathVariable String theid){
        Response<Log> res=logService.getLog(theid);
        return res;

    }
    @RequestMapping(value="/getalllog",method = RequestMethod.GET)
    public Response<List<Log>> getAllLog(){
        Response<List<Log>> res=logService.getAllLog();
        return res;

    }
    @RequestMapping(value="/deletelog/{theid}",method = RequestMethod.DELETE)
    public Response<Log> deleteLog(@PathVariable String theid){
        Response<Log> res=logService.deleteLog(theid);
        return res;
    }

    @RequestMapping(value="/updatelog/{theid}",method = RequestMethod.PUT)
    public Response<Log> updatelog(@PathVariable String theid,@RequestBody Log log){

        Response<Log> res=logService.updatelog(theid,log);
        return res;

    }
}
