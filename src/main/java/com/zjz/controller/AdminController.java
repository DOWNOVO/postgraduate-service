package com.zjz.controller;

import com.zjz.entity.po.Admission;
import com.zjz.entity.po.GeneralRegulations;
import com.zjz.service.AdminService;
import com.zjz.untils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 删除录取信息
     * @return
     */
    @RequestMapping("/deleteAdmission/{admissionId}")
    public Result deleteAdmission(@PathVariable String admissionId){
        return adminService.deleteAdmission(admissionId,"/hbb/admin/deleteAdmission/{admissionId}");
    }

    /**
     * 更新录取信息
     * @return
     */
    @RequestMapping("/updateAdmission")
    public Result updateAdmission(@RequestBody Admission admission){
        return adminService.updateAdmission(admission,"/hbb/admin/updateAdmission");
    }

    /**
     * 添加录取信息
     * @return
     */
    @RequestMapping("/insertAdmission")
    public Result insertAdmission(@RequestBody Admission admission){
        return adminService.insertAdmission(admission,"/hbb/admin/insertAdmission");
    }

    /**
     * 删除资料
     * @return
     */
    @RequestMapping("/deleteInformation/{informationId}")
    public Result deleteInformation(@PathVariable String informationId){
        return adminService.deleteInformation(informationId,"/hbb/admin/deleteInformation/{informationId}");
    }


    /**
     * 删除招生简章
     * @return
     */
    @RequestMapping("/deleteGeneralRegulations/{generalRegulationsId}")
    public Result deleteGeneralRegulations(@PathVariable String generalRegulationsId){
        return adminService.deleteGeneralRegulations(generalRegulationsId,"/hbb/admin/deleteGeneralRegulations/{generalRegulationsId}");
    }

    /**
     * 插入招生简章
     * @return
     */
    @RequestMapping("/insertGeneralRegulations")
    public Result insertGeneralRegulations(@RequestBody GeneralRegulations generalRegulations){
        return adminService.insertGeneralRegulations(generalRegulations,"/hbb/admin/insertGeneralRegulations");
    }

    /**
     * 修改招生简章
     * @return
     */
    @RequestMapping("/updateGeneralRegulations")
    public Result updateGeneralRegulations(@RequestBody GeneralRegulations generalRegulations){
        return adminService.updateGeneralRegulations(generalRegulations,"/hbb/admin/updateGeneralRegulations");
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/deleteUser/{username}")
    public Result deleteUser(@PathVariable String username){
        return adminService.deleteUser(username,"/hbb/admin/deleteUser/{username}");
    }

}
