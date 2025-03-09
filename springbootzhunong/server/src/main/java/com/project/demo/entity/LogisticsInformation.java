package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 物流信息：(LogisticsInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "LogisticsInformation")
public class LogisticsInformation implements Serializable {

    // LogisticsInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logistics_information_id")
    private Integer logistics_information_id;

    // 店铺账号
    @Basic
    private Integer store_account;
    // 店铺名称
    @Basic
    private String store_name;
    // 用户账号
    @Basic
    private Integer user_account;
    // 用户姓名
    @Basic
    private String user_name;
    // 订单编号
    @Basic
    private String order_number;
    // 订单日期
    @Basic
    private Timestamp order_date;
    // 订单金额
    @Basic
    private Integer order_amount;
    // 物流状态
    @Basic
    private String logistics_status;
    // 物流单号
    @Basic
    private String logistics_tracking_number;
    // 物流信息
    @Basic
    private String logistics_information;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
