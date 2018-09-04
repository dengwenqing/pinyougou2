package com._360dwq.manage.controller;

import com._360dwq.pojo.TbBrand;
import com._360dwq.pojo.TbSpecification;
import com._360dwq.sellergoods.service.BrandService;
import com._360dwq.vo.PageResult;
import com._360dwq.vo.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Dw_Qin
 * @Date 2018/08/27 0:06
 * @Email 569806951@qq.com
 */
@RequestMapping("/brand")
@RestController
public class BrandController {
    @Reference
    private BrandService brandService;

    @PostMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            return Result.okay("保存数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("保存数据失败");
    }

    @PostMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return Result.okay("保存数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("保存数据失败");
    }

    @GetMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    @GetMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    @PostMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.deleteByIds(ids);
            return Result.okay("删除数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("删除数据失败");
    }

    @PostMapping("/search")
    public PageResult findPage(@RequestBody TbBrand tbBrand,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        PageResult pageInfo = brandService.search(tbBrand, page, rows);
        return pageInfo;
    }

    @GetMapping("/selectOptionList")
    public List<Map<String ,Object>> selectOptionList(){
        return brandService.selectOptionList();
    }
}
