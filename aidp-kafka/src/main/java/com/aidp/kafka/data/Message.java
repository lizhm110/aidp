package com.aidp.kafka.data;

import lombok.Data;

import java.util.Date;

/**
 * 消息实体类
 * @Author lizhm
 * @Date 2019-2-22
 */
@Data
public class Message {
    /**
     * id
     */
    private Long id;
    /**
     * 消息
     */
    private String msg;
    /**
     * 时间戳
     */
    private Date sendTime;
}