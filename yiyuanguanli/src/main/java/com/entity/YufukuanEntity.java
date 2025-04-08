package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 预付款账户
 *
 * @author 
 * @email
 */
@TableName("yufukuan")
public class YufukuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YufukuanEntity() {

	}

	public YufukuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Yufukuan{" +
            "id=" + id +
            ", bingliId=" + bingliId +
            ", yufukuanDanhaoNumber=" + yufukuanDanhaoNumber +
            ", yufukuanMoney=" + yufukuanMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
