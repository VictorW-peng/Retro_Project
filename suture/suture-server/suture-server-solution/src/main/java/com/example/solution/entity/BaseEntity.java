/**
 * @author William.Patrick
 * @data 2022/10/10 22:49
 */
package com.example.solution.entity;

import lombok.Data;
import java.util.Date;
@Data
//公共字段设置
public class BaseEntity {

    private String createUser;

    private Date createTime;

    private String modifiedUser;

    private Date modifiedTime;

}
