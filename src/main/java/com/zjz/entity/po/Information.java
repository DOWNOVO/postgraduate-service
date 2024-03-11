package com.zjz.entity.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 资料
 */
public class Information {
    /**
     * 资料id
     */
    private String infoId;
    /**
     * 资料添加的时间
     */
    private long addedTime;
    /**
     * 资料类型
     */
    private String infoType;
    /**
     * 资料保存的路径
     */
    private String infoPath;
    /**
     * 资料的标题
     */
    private String infoTitle;

}
