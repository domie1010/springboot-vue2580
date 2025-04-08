package com.entity.vo;

import com.entity.JianchaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 检查
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiancha")
public class JianchaVO implements Serializable {
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
     * 检查名目
     */

    @TableField(value = "jiancha_name")
    private String jianchaName;


    /**
     * 检查类型
     */

    @TableField(value = "jiancha_types")
    private Integer jianchaTypes;


    /**
     * 检查结果
     */

    @TableField(value = "jiancha_content")
    private String jianchaContent;


    /**
     * 检查时间
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
	 * 设置：检查名目
	 */
    public String getJianchaName() {
        return jianchaName;
    }


    /**
	 * 获取：检查名目
	 */

    public void setJianchaName(String jianchaName) {
        this.jianchaName = jianchaName;
    }
    /**
	 * 设置：检查类型
	 */
    public Integer getJianchaTypes() {
        return jianchaTypes;
    }


    /**
	 * 获取：检查类型
	 */

    public void setJianchaTypes(Integer jianchaTypes) {
        this.jianchaTypes = jianchaTypes;
    }
    /**
	 * 设置：检查结果
	 */
    public String getJianchaContent() {
        return jianchaContent;
    }


    /**
	 * 获取：检查结果
	 */

    public void setJianchaContent(String jianchaContent) {
        this.jianchaContent = jianchaContent;
    }
    /**
	 * 设置：检查时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：检查时间
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
