package com.entity.model;

import com.entity.BingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 住院号
     */
    private String huanzheDanhaoNumber;


    /**
     * 患者姓名
     */
    private String huanzheName;


    /**
     * 患者手机号
     */
    private String huanzhePhone;


    /**
     * 患者身份证号
     */
    private String huanzheIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 科室
     */
    private Integer keshiTypes;


    /**
     * 主诉详情
     */
    private String zhusuContent;


    /**
     * 诊断详情
     */
    private String zhenduanContent;


    /**
     * 病例状态
     */
    private Integer bingliYesnoTypes;


    /**
     * 诊断时间
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
	 * 获取：住院号
	 */
    public String getHuanzheDanhaoNumber() {
        return huanzheDanhaoNumber;
    }


    /**
	 * 设置：住院号
	 */
    public void setHuanzheDanhaoNumber(String huanzheDanhaoNumber) {
        this.huanzheDanhaoNumber = huanzheDanhaoNumber;
    }
    /**
	 * 获取：患者姓名
	 */
    public String getHuanzheName() {
        return huanzheName;
    }


    /**
	 * 设置：患者姓名
	 */
    public void setHuanzheName(String huanzheName) {
        this.huanzheName = huanzheName;
    }
    /**
	 * 获取：患者手机号
	 */
    public String getHuanzhePhone() {
        return huanzhePhone;
    }


    /**
	 * 设置：患者手机号
	 */
    public void setHuanzhePhone(String huanzhePhone) {
        this.huanzhePhone = huanzhePhone;
    }
    /**
	 * 获取：患者身份证号
	 */
    public String getHuanzheIdNumber() {
        return huanzheIdNumber;
    }


    /**
	 * 设置：患者身份证号
	 */
    public void setHuanzheIdNumber(String huanzheIdNumber) {
        this.huanzheIdNumber = huanzheIdNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：科室
	 */
    public Integer getKeshiTypes() {
        return keshiTypes;
    }


    /**
	 * 设置：科室
	 */
    public void setKeshiTypes(Integer keshiTypes) {
        this.keshiTypes = keshiTypes;
    }
    /**
	 * 获取：主诉详情
	 */
    public String getZhusuContent() {
        return zhusuContent;
    }


    /**
	 * 设置：主诉详情
	 */
    public void setZhusuContent(String zhusuContent) {
        this.zhusuContent = zhusuContent;
    }
    /**
	 * 获取：诊断详情
	 */
    public String getZhenduanContent() {
        return zhenduanContent;
    }


    /**
	 * 设置：诊断详情
	 */
    public void setZhenduanContent(String zhenduanContent) {
        this.zhenduanContent = zhenduanContent;
    }
    /**
	 * 获取：病例状态
	 */
    public Integer getBingliYesnoTypes() {
        return bingliYesnoTypes;
    }


    /**
	 * 设置：病例状态
	 */
    public void setBingliYesnoTypes(Integer bingliYesnoTypes) {
        this.bingliYesnoTypes = bingliYesnoTypes;
    }
    /**
	 * 获取：诊断时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：诊断时间
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
