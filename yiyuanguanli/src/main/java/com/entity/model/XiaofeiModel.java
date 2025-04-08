package com.entity.model;

import com.entity.XiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 消费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预付款账户
     */
    private Integer yufukuanId;


    /**
     * 消费名目
     */
    private String xiaofeiName;


    /**
     * 消费类型
     */
    private Integer xiaofeiTypes;


    /**
     * 消费金额
     */
    private Double xiaofeiMoney;


    /**
     * 备注
     */
    private String xiaofeiContent;


    /**
     * 消费时间
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
	 * 获取：预付款账户
	 */
    public Integer getYufukuanId() {
        return yufukuanId;
    }


    /**
	 * 设置：预付款账户
	 */
    public void setYufukuanId(Integer yufukuanId) {
        this.yufukuanId = yufukuanId;
    }
    /**
	 * 获取：消费名目
	 */
    public String getXiaofeiName() {
        return xiaofeiName;
    }


    /**
	 * 设置：消费名目
	 */
    public void setXiaofeiName(String xiaofeiName) {
        this.xiaofeiName = xiaofeiName;
    }
    /**
	 * 获取：消费类型
	 */
    public Integer getXiaofeiTypes() {
        return xiaofeiTypes;
    }


    /**
	 * 设置：消费类型
	 */
    public void setXiaofeiTypes(Integer xiaofeiTypes) {
        this.xiaofeiTypes = xiaofeiTypes;
    }
    /**
	 * 获取：消费金额
	 */
    public Double getXiaofeiMoney() {
        return xiaofeiMoney;
    }


    /**
	 * 设置：消费金额
	 */
    public void setXiaofeiMoney(Double xiaofeiMoney) {
        this.xiaofeiMoney = xiaofeiMoney;
    }
    /**
	 * 获取：备注
	 */
    public String getXiaofeiContent() {
        return xiaofeiContent;
    }


    /**
	 * 设置：备注
	 */
    public void setXiaofeiContent(String xiaofeiContent) {
        this.xiaofeiContent = xiaofeiContent;
    }
    /**
	 * 获取：消费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：消费时间
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
