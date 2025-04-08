package com.entity.model;

import com.entity.YizhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医嘱
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YizhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer bingliId;


    /**
     * 医嘱名字
     */
    private String yizhuName;


    /**
     * 医嘱类型
     */
    private Integer yizhuTypes;


    /**
     * 医嘱详情
     */
    private String yizhuContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：患者
	 */
    public Integer getBingliId() {
        return bingliId;
    }


    /**
	 * 设置：患者
	 */
    public void setBingliId(Integer bingliId) {
        this.bingliId = bingliId;
    }
    /**
	 * 获取：医嘱名字
	 */
    public String getYizhuName() {
        return yizhuName;
    }


    /**
	 * 设置：医嘱名字
	 */
    public void setYizhuName(String yizhuName) {
        this.yizhuName = yizhuName;
    }
    /**
	 * 获取：医嘱类型
	 */
    public Integer getYizhuTypes() {
        return yizhuTypes;
    }


    /**
	 * 设置：医嘱类型
	 */
    public void setYizhuTypes(Integer yizhuTypes) {
        this.yizhuTypes = yizhuTypes;
    }
    /**
	 * 获取：医嘱详情
	 */
    public String getYizhuContent() {
        return yizhuContent;
    }


    /**
	 * 设置：医嘱详情
	 */
    public void setYizhuContent(String yizhuContent) {
        this.yizhuContent = yizhuContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
