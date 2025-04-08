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
 * 患者住院房屋
 *
 * @author 
 * @email
 */
@TableName("chuangwei_bingli")
public class ChuangweiBingliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuangweiBingliEntity() {

	}

	public ChuangweiBingliEntity(T t) {
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
     * 床位
     */
    @TableField(value = "chuangwei_id")

    private Integer chuangweiId;


    /**
     * 患者
     */
    @TableField(value = "bingli_id")

    private Integer bingliId;


    /**
     * 备注
     */
    @TableField(value = "chuangwei_bingli_content")

    private String chuangweiBingliContent;


    /**
     * 是否在住
     */
    @TableField(value = "chuangwei_bingli_yesno_types")

    private Integer chuangweiBingliYesnoTypes;


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
	 * 设置：床位
	 */
    public Integer getChuangweiId() {
        return chuangweiId;
    }


    /**
	 * 获取：床位
	 */

    public void setChuangweiId(Integer chuangweiId) {
        this.chuangweiId = chuangweiId;
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
	 * 设置：备注
	 */
    public String getChuangweiBingliContent() {
        return chuangweiBingliContent;
    }


    /**
	 * 获取：备注
	 */

    public void setChuangweiBingliContent(String chuangweiBingliContent) {
        this.chuangweiBingliContent = chuangweiBingliContent;
    }
    /**
	 * 设置：是否在住
	 */
    public Integer getChuangweiBingliYesnoTypes() {
        return chuangweiBingliYesnoTypes;
    }


    /**
	 * 获取：是否在住
	 */

    public void setChuangweiBingliYesnoTypes(Integer chuangweiBingliYesnoTypes) {
        this.chuangweiBingliYesnoTypes = chuangweiBingliYesnoTypes;
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
        return "ChuangweiBingli{" +
            "id=" + id +
            ", chuangweiId=" + chuangweiId +
            ", bingliId=" + bingliId +
            ", chuangweiBingliContent=" + chuangweiBingliContent +
            ", chuangweiBingliYesnoTypes=" + chuangweiBingliYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
