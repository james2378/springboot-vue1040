package com.project.demo.controller;

import com.project.demo.entity.ReceivingInformation;
import com.project.demo.service.ReceivingInformationService;
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
 * 收货信息：(ReceivingInformation)表控制层
 *
 */
@RestController
@RequestMapping("/receiving_information")
public class ReceivingInformationController extends BaseController<ReceivingInformation, ReceivingInformationService> {

    /**
     * 收货信息对象
     */
    @Autowired
    public ReceivingInformationController(ReceivingInformationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
