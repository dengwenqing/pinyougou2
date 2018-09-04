package com._360dwq.shop.controller;

import com._360dwq.vo.PageResult;
import com._360dwq.vo.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import com._360dwq.pojo.TbGoodsDesc;
import com._360dwq.sellergoods.service.GoodsDescService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/goodsDesc")
@RestController
public class GoodsDescController {

    @Reference
    private GoodsDescService goodsDescService;

    @RequestMapping("/findAll")
    public List<TbGoodsDesc> findAll() {
        return goodsDescService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "10")Integer rows) {
        return goodsDescService.findPage(page, rows);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TbGoodsDesc goodsDesc) {
        try {
            goodsDescService.add(goodsDesc);
            return Result.okay("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("增加失败");
    }

    @GetMapping("/findOne")
    public TbGoodsDesc findOne(Long id) {
        return goodsDescService.findOne(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody TbGoodsDesc goodsDesc) {
        try {
            goodsDescService.update(goodsDesc);
            return Result.okay("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("修改失败");
    }

    @GetMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            goodsDescService.deleteByIds(ids);
            return Result.okay("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("删除失败");
    }

    /**
     * 分页查询列表
     * @param goodsDesc 查询条件
     * @param page 页号
     * @param rows 每页大小
     * @return
     */
    @PostMapping("/search")
    public PageResult search(@RequestBody  TbGoodsDesc goodsDesc, @RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "10")Integer rows) {
        return goodsDescService.search(page, rows, goodsDesc);
    }

}
