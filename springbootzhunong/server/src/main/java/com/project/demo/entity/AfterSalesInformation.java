package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 售后信息：(AfterSalesInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AfterSalesInformation")
public class AfterSalesInformation implements Serializable {

    // AfterSalesInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "after_sales_information_id")
    private Integer after_sales_information_id;

    // 用户账号
    @Basic
    private Integer user_account;
    // 用户姓名
    @Basic
    private String user_name;
    // 店铺账号
    @Basic
    private Integer store_account;
    // 店铺名称
    @Basic
    private String store_name;
    // 订单编号
    @Basic
    private String order_number;
    // 订单日期
    @Basic
    private Timestamp order_date;
    // 售后类型
    @Basic
    private String after_sales_type;
    // 售后原因
    @Basic
    private String after_sales_reasons;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
