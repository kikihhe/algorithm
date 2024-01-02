package com.xiaohe.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohe.demo.pojo.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-10-11 23:54
 */
@Mapper
public interface GoodMapper extends BaseMapper<Good> {
    public List<Good> selectLike(String name);
}
