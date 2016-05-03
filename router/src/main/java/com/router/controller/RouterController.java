package com.router.controller;

import com.router.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoshibushi on 2016/4/29.
 */
@Controller
@RequestMapping("/router")
public class RouterController {

    @RequestMapping("/getBestPath")
    @ResponseBody
    public String getBestPath(HttpServletRequest request){
        String startLon=request.getParameter("startLon");
        String startLat=request.getParameter("startLat");
        String endLon=request.getParameter("endLon");
        String endLat=request.getParameter("endtLat");

        double startLonDouble=Double.parseDouble(startLon);
        double startLatDouble=Double.parseDouble(startLat);

        double endLonDouble=Double.parseDouble(endLon);
        double endLatDouble=Double.parseDouble(endLat);
        RouterService routerService=new RouterService(startLatDouble,startLonDouble,endLatDouble,endLonDouble);
        String resultStr= routerService.getPath();
        return resultStr;
    }
}
