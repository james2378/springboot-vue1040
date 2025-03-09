package com.project.demo.controller;

import com.project.demo.entity.AfterSalesInformation;
import com.project.demo.service.AfterSalesInformationService;
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
 * 售后信息：(AfterSalesInformation)表控制层
 *
 */
@RestController
@RequestMapping("/after_sales_information")
public class AfterSalesInformationController extends BaseController<AfterSalesInformation, AfterSalesInformationService> {

    /**
     * 售后信息对象
     */
    @Autowired
    public AfterSalesInformationController(AfterSalesInformationService service) {
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
