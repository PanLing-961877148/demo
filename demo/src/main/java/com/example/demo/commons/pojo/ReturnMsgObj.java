package com.example.demo.commons.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * 返回信息封装类
 */
@Data
@ToString
public class ReturnMsgObj {
    private String code;//1：成功，0：失败
    private String message;//错误信息
    private Object other;//其它信息
}
