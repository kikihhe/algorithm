package com.xiaohe.demo.controller;

import com.xiaohe.demo.mapper.GoodMapper;
import com.xiaohe.demo.pojo.Good;
import com.xiaohe.demo.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-10-12 00:02
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    private GoodMapper goodMapper;

    @RequestMapping("/get")
    public Result getAll(@RequestParam String name) {
        name = name.toUpperCase(Locale.ROOT);
        List<Good> goods = goodMapper.selectLike(name);
        return Result.success(goods);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody Map<String, Object> map) {
        String name = (String) map.get("name");
        Double price = Double.valueOf((String) map.get("price")) ;
        Integer count = Integer.valueOf((String) map.get("count")) ;
        String description = (String) map.get("description");
        Good good = new Good(null, name, price, count, description);
        if (!StringUtils.hasText(good.getName())) {
            return Result.error("名称不能为空", good);
        }
        if (good.getPrice() == null || good.getPrice() < 0) {
            return Result.error("价格为空或不符合格式", good);
        }
        if (good.getCount() == null || good.getCount() < 0) {
            return Result.error("数量为空或不符合格式", good);
        }
        int insert = goodMapper.insert(good);
        if (insert > 0) {
            return Result.success("新增成功!", null);
        } else {
            return Result.success("新政失败", null);
        }

    }

    @RequestMapping("/getOne")
    public Result getOne(Integer id) {
        Good good = goodMapper.selectById(id);
        return Result.success(good);
    }

    @RequestMapping("/delete")
    public Result delete(Integer id) {
        int delete = goodMapper.deleteById(id);
        if (delete > 0) {
            return Result.success("删除成功", null);
        }
        return Result.error("修改失败");
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Map<String, Object> map) {
        Integer id = (Integer) map.get("id");
        String name = (String) map.get("name");
        Double price = Double.valueOf((String) map.get("price")) ;
        Integer count = Integer.valueOf((String) map.get("count")) ;
        String description = (String) map.get("description");
        Good good = new Good(id, name, price, count, description);
        if (!StringUtils.hasText(good.getName())) {
            return Result.error("名称不能为空", null);
        }
        if (good.getPrice() == null || good.getCount() == null || good.getPrice() < 0 || good.getCount() < 0) {
            return Result.error("价格、数量填写有误");
        }
        goodMapper.updateById(good);
        return Result.success("修改成功", null);
    }
}
