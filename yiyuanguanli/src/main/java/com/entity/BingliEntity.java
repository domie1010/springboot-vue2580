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
 * 病例
 *
 * @author 
 * @email
 */
@TableName("bingli")
public class BingliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingliEntity() {

	}

	public BingliEntity(T t) {
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
     * 住院号
     */
    @TableField(value = "huanzhe_danhao_number")

    private String huanzheDanhaoNumber;


    /**
     * 患者姓名
     */
    @TableField(value = "huanzhe_name")

    private String huanzheName;


    /**
     * 患者手机号
     */
    @TableField(value = "huanzhe_phone")

    private String huanzhePhone;


    /**
     * 患者身份证号
     */
    @TableField(value = "huanzhe_id_number")

    private String huanzheIdNumber;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 科室
     */
    @TableField(value = "keshi_types")

    private Integer keshiTypes;


    /**
     * 主诉详情
     */
    @TableField(value = "zhusu_content")

    private String zhusuContent;


    /**
     * 诊断详情
     */
    @TableField(value = "zhenduan_content")

    private String zhenduanContent;


    /**
     * 病例状态
     */
    @TableField(value = "bingli_yesno_types")

    private Integer bingliYesnoTypes;


    /**
     * 诊断时间
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
	 * 设置：住院号
	 */
    public String getHuanzheDanhaoNumber() {
        return huanzheDanhaoNumber;
    }


    /**
	 * 获取：住院号
	 */

    public void setHuanzheDanhaoNumber(String huanzheDanhaoNumber) {
        this.huanzheDanhaoNumber = huanzheDanhaoNumber;
    }
    /**
	 * 设置：患者姓名
	 */
    public String getHuanzheName() {
        return huanzheName;
    }


    /**
	 * 获取：患者姓名
	 */

    public void setHuanzheName(String huanzheName) {
        this.huanzheName = huanzheName;
    }
    /**
	 * 设置：患者手机号
	 */
    public String getHuanzhePhone() {
        return huanzhePhone;
    }


    /**
	 * 获取：患者手机号
	 */

    public void setHuanzhePhone(String huanzhePhone) {
        this.huanzhePhone = huanzhePhone;
    }
    /**
	 * 设置：患者身份证号
	 */
    public String getHuanzheIdNumber() {
        return huanzheIdNumber;
    }


    /**
	 * 获取：患者身份证号
	 */

    public void setHuanzheIdNumber(String huanzheIdNumber) {
        this.huanzheIdNumber = huanzheIdNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：科室
	 */
    public Integer getKeshiTypes() {
        return keshiTypes;
    }


    /**
	 * 获取：科室
	 */

    public void setKeshiTypes(Integer keshiTypes) {
        this.keshiTypes = keshiTypes;
    }
    /**
	 * 设置：主诉详情
	 */
    public String getZhusuContent() {
        return zhusuContent;
    }


    /**
	 * 获取：主诉详情
	 */

    public void setZhusuContent(String zhusuContent) {
        this.zhusuContent = zhusuContent;
    }
    /**
	 * 设置：诊断详情
	 */
    public String getZhenduanContent() {
        return zhenduanContent;
    }


    /**
	 * 获取：诊断详情
	 */

    public void setZhenduanContent(String zhenduanContent) {
        this.zhenduanContent = zhenduanContent;
    }
    /**
	 * 设置：病例状态
	 */
    public Integer getBingliYesnoTypes() {
        return bingliYesnoTypes;
    }


    /**
	 * 获取：病例状态
	 */

    public void setBingliYesnoTypes(Integer bingliYesnoTypes) {
        this.bingliYesnoTypes = bingliYesnoTypes;
    }
    /**
	 * 设置：诊断时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：诊断时间
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
        return "Bingli{" +
            "id=" + id +
            ", huanzheDanhaoNumber=" + huanzheDanhaoNumber +
            ", huanzheName=" + huanzheName +
            ", huanzhePhone=" + huanzhePhone +
            ", huanzheIdNumber=" + huanzheIdNumber +
            ", sexTypes=" + sexTypes +
            ", keshiTypes=" + keshiTypes +
            ", zhusuContent=" + zhusuContent +
            ", zhenduanContent=" + zhenduanContent +
            ", bingliYesnoTypes=" + bingliYesnoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
