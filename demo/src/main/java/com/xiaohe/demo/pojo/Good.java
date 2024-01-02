package com.xiaohe.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author : 小何
 * @Description : 商品
 * @date : 2023-10-11 23:48
 */
@TableName("Good")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private Integer id;
    private String name;

    private Double price;

    private Integer count;

    private String description;

}
