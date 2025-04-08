package com.entity.vo;

import com.entity.YufukuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预付款账户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yufukuan")
public class YufukuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 患者
     */

    @TableField(value = "bingli_id")
    private Integer bingliId;


    /**
     * 预付款账户
     */

    @TableField(value = "yufukuan_danhao_number")
    private String yufukuanDanhaoNumber;


    /**
     * 预付款金额
     */

    @TableField(value = "yufukuan_money")
    private Double yufukuanMoney;


    /**
     * 添加时间
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
	 * 设置：患者
	 */
    public Integer getBingliId() {
        return bingliId;
    }


    /**
	 * 获取：患者
	 */

    public void setBingliId(Integer bingliId) {
        this.bingliId = bingliId;
    }
    /**
	 * 设置：预付款账户
	 */
    public String getYufukuanDanhaoNumber() {
        return yufukuanDanhaoNumber;
    }


    /**
	 * 获取：预付款账户
	 */

    public void setYufukuanDanhaoNumber(String yufukuanDanhaoNumber) {
        this.yufukuanDanhaoNumber = yufukuanDanhaoNumber;
    }
    /**
	 * 设置：预付款金额
	 */
    public Double getYufukuanMoney() {
        return yufukuanMoney;
    }


    /**
	 * 获取：预付款金额
	 */

    public void setYufukuanMoney(Double yufukuanMoney) {
        this.yufukuanMoney = yufukuanMoney;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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
