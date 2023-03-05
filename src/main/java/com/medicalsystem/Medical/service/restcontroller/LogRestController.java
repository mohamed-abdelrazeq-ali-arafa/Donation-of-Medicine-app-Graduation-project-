package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Log;
import com.medicalsystem.Medical.service.services.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/log")
public class LogRestController {

    ILogService logService;
    @Autowired
    public LogRestController (ILogService stockService){
        this.logService =stockService;

    }

    @RequestMapping(value="/addlog",method = RequestMethod.POST)
    public ResponseEntity addLog(@RequestBody Log log){
        Response res=logService.addLog(log);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }

    @RequestMapping(value="/getlog/{theid}",method = RequestMethod.GET)
    public ResponseEntity  getLog(@PathVariable String theid){
        Response res=logService.getLog(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }
    @RequestMapping(value="/getalllog",method = RequestMethod.GET)
    public ResponseEntity getAllLog(){
        Response res=logService.getAllLog();
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }
    @RequestMapping(value="/deletelog/{theid}",method = RequestMethod.DELETE)
    public ResponseEntity deleteLog(@PathVariable String theid){
        Response res=logService.deleteLog(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }

    @RequestMapping(value="/updatelog/{theid}",method = RequestMethod.PUT)
    public ResponseEntity updatelog(@PathVariable String theid,@RequestBody Log log){

        Response res=logService.updatelog(theid,log);
        return ResponseEntity.status(res.getCode()).body(res.toData());


    }
}
