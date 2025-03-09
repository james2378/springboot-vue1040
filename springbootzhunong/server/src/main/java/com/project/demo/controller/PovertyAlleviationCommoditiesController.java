package com.project.demo.controller;

import com.project.demo.entity.PovertyAlleviationCommodities;
import com.project.demo.service.PovertyAlleviationCommoditiesService;
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
 * 扶贫商品：(PovertyAlleviationCommodities)表控制层
 *
 */
@RestController
@RequestMapping("/poverty_alleviation_commodities")
public class PovertyAlleviationCommoditiesController extends BaseController<PovertyAlleviationCommodities, PovertyAlleviationCommoditiesService> {

    /**
     * 扶贫商品对象
     */
    @Autowired
    public PovertyAlleviationCommoditiesController(PovertyAlleviationCommoditiesService service) {
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
