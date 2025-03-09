package com.project.demo.controller;

import com.project.demo.entity.LogisticsInformation;
import com.project.demo.service.LogisticsInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 物流信息：(LogisticsInformation)表控制层
 *
 */
@RestController
@RequestMapping("/logistics_information")
public class LogisticsInformationController extends BaseController<LogisticsInformation, LogisticsInformationService> {

    /**
     * 物流信息对象
     */
    @Autowired
    public LogisticsInformationController(LogisticsInformationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> maplogistics_tracking_number = new HashMap<>();
        maplogistics_tracking_number.put("logistics_tracking_number",String.valueOf(paramMap.get("logistics_tracking_number")));
        List listlogistics_tracking_number = service.select(maplogistics_tracking_number, new HashMap<>()).getResultList();
        if (listlogistics_tracking_number.size()>0){
            return error(30000, "字段物流单号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
