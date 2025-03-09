package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 销售信息：(SalesInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SalesInformation")
public class SalesInformation implements Serializable {

    // SalesInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_information_id")
    private Integer sales_information_id;

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
    // 销售月份
    @Basic
    private String sales_month;
    // 订单金额
    @Basic
    private Integer order_amount;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
