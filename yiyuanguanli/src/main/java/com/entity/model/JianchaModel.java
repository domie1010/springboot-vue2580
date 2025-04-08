package com.entity.model;

import com.entity.JianchaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 检查
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianchaModel implements Serializable {
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
     * 检查名目
     */
    private String jianchaName;


    /**
     * 检查类型
     */
    private Integer jianchaTypes;


    /**
     * 检查结果
     */
    private String jianchaContent;


    /**
     * 检查时间
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
	 * 获取：检查名目
	 */
    public String getJianchaName() {
        return jianchaName;
    }


    /**
	 * 设置：检查名目
	 */
    public void setJianchaName(String jianchaName) {
        this.jianchaName = jianchaName;
    }
    /**
	 * 获取：检查类型
	 */
    public Integer getJianchaTypes() {
        return jianchaTypes;
    }


    /**
	 * 设置：检查类型
	 */
    public void setJianchaTypes(Integer jianchaTypes) {
        this.jianchaTypes = jianchaTypes;
    }
    /**
	 * 获取：检查结果
	 */
    public String getJianchaContent() {
        return jianchaContent;
    }


    /**
	 * 设置：检查结果
	 */
    public void setJianchaContent(String jianchaContent) {
        this.jianchaContent = jianchaContent;
    }
    /**
	 * 获取：检查时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：检查时间
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
