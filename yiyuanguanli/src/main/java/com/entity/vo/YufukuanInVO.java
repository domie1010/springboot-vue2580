package com.entity.vo;

import com.entity.YufukuanInEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预付款缴费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yufukuan_in")
public class YufukuanInVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预付款账户
     */

    @TableField(value = "yufukuan_id")
    private Integer yufukuanId;


    /**
     * 缴费金额
     */

    @TableField(value = "yufukuan_in_money")
    private Double yufukuanInMoney;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预付款账户
	 */
    public Integer getYufukuanId() {
        return yufukuanId;
    }


    /**
	 * 获取：预付款账户
	 */

    public void setYufukuanId(Integer yufukuanId) {
        this.yufukuanId = yufukuanId;
    }
    /**
	 * 设置：缴费金额
	 */
    public Double getYufukuanInMoney() {
        return yufukuanInMoney;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setYufukuanInMoney(Double yufukuanInMoney) {
        this.yufukuanInMoney = yufukuanInMoney;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：缴费时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
