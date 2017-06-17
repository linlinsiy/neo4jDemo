package com.lsy.controller;

import com.lsy.services.PersonService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by lsy on 2017/6/13.
 */
@RestController
@RequestMapping(value="/person")
public class PersonController {
    @Autowired
    PersonService personService;

    /**
     * 初始化数据库
     * @return
     */
    @RequestMapping(value="/setup",method= RequestMethod.GET)
    public String setup(){
        personService.setup();
        return "初始化成功";
      //  return "index.jsp";
    }

    /**
     * 清理数据库
     * @return
     */
    @RequestMapping(value = "/clear",method = RequestMethod.GET)
    public String clear(){
        personService.purgeDatabase();
        return "删除成功";
    }

    @RequestMapping(value = "/graph",method = RequestMethod.GET)
    public Map<String,Object> graph(@RequestParam(value = "limit",required = false) Integer limit){
        return personService.graph(limit == null ? 100 : limit);
    }
}
