package com.zjz.untils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * 返回值的模式
 *
 * @author HCY
 * @since 2020/12/20 上午 11:40
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Result {
    /**
     * 返回的具体信息
     */
    private Object message;

    /**
     * 调用的URL
     */
    private String path;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 200 成功
     */
    public static final Integer STATUS_OK_200 = 200;

    /**
     * 401 非法
     */
    public static final Integer STATUS_ILLEGAL_401 = 401;

    /**
     * 403 禁止
     */
    public static final Integer STATUS_BAN_403 = 403;

    /**
     * 404 未找到
     */
    public static final Integer STATUS_NOT_FOUND_404 = 404;

    /**
     * 500 错误
     */
    public static final Integer STATUS_ERROR_500 = 500;

    /**
     * 200 -> 成功
     * 401 -> 非法
     * 403 -> 禁止
     * 404 -> 未找到
     * 500 -> 错误
     */

    /**
     * 具体信息
     */
    private String info;

    public static final String INFO_OK_200 = "OK";
    public static final String INFO_ILLEGAL_401 = "ILLEGAL";
    public static final String INFO_BAN_403 = "BAN";
    public static final String INFO_NOT_FOUND_404 = "NOT FOUND";
    public static final String INFO_ERROR_500 = "ERROR";


    /**
     * 详情
     */
    private String details;

    public static final String DETAILS_OK_200 = "成功";
    public static final String DETAILS_ILLEGAL_401 = "非法";
    public static final String DETAILS_BAN_403 = "禁止";
    public static final String DETAILS_NOT_FOUND_404 = "未找到";
    public static final String DETAILS_ERROR_500 = "错误";

    /**
     * 调用的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date timestamp;

    /**
     * OK
     *
     * @author HCY
     * @since 2020/12/20 上午 11:53
     * @param message: 返回的具体信息
     * @param path: URL路径
     * @return com.inet.code.result.Result
    */
    public Result result200(Object message , String path){
        return new Result(
                 message
                ,path
                ,Result.STATUS_OK_200
                ,Result.INFO_OK_200
                ,Result.DETAILS_OK_200
                ,new Date()
        );
    }

    /**
     * ILLEGAL
     *
     * @author HCY
     * @since 2020/12/20 上午 11:53
     * @param message: 返回的具体信息
     * @param path: URL路径
     * @return com.inet.code.result.Result
     */
    public Result result401(Object message , String path){
        return new Result(
                message
                ,path
                ,Result.STATUS_ILLEGAL_401
                ,Result.INFO_ILLEGAL_401
                ,Result.DETAILS_ILLEGAL_401
                ,new Date()
        );
    }

    /**
     * BAN
     *
     * @author HCY
     * @since 2020/12/20 上午 11:53
     * @param message: 返回的具体信息
     * @param path: URL路径
     * @return com.inet.code.result.Result
     */
    public Result result403(Object message , String path){
        return new Result(
                message
                ,path
                ,Result.STATUS_BAN_403
                ,Result.INFO_BAN_403
                ,Result.DETAILS_BAN_403
                ,new Date()
        );
    }

    /**
     * NOT FOUND
     *
     * @author HCY
     * @since 2020/12/20 上午 11:53
     * @param message: 返回的具体信息
     * @param path: URL路径
     * @return com.inet.code.result.Result
     */
    public Result result404(Object message , String path){
        return new Result(
                message
                ,path
                ,Result.STATUS_NOT_FOUND_404
                ,Result.INFO_NOT_FOUND_404
                ,Result.DETAILS_NOT_FOUND_404
                ,new Date()
        );
    }

    /**
     * ERROR
     *
     * @author HCY
     * @since 2020/12/20 上午 11:53
     * @param message: 返回的具体信息
     * @param path: URL路径
     * @return com.inet.code.result.Result
     */
    public Result result500(Object message , String path){
        return new Result(
                message
                ,path
                ,Result.STATUS_ERROR_500
                ,Result.INFO_ERROR_500
                ,Result.DETAILS_ERROR_500
                ,new Date()
        );
    }
}
