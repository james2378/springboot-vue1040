package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 收货信息：(ReceivingInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ReceivingInformation")
public class ReceivingInformation implements Serializable {

    // ReceivingInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiving_information_id")
    private Integer receiving_information_id;

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
    // 物流单号
    @Basic
    private String logistics_tracking_number;
    // 确认收货
    @Basic
    private String confirm_receipt;



    // 审核状态
    @Basic
    private String examine_state;











    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
