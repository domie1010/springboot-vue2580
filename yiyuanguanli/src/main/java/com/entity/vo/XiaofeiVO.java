package com.entity.vo;

import com.entity.XiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 消费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaofei")
public class XiaofeiVO implements Serializable {
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
     * 消费名目
     */

    @TableField(value = "xiaofei_name")
    private String xiaofeiName;


    /**
     * 消费类型
     */

    @TableField(value = "xiaofei_types")
    private Integer xiaofeiTypes;


    /**
     * 消费金额
     */

    @TableField(value = "xiaofei_money")
    private Double xiaofeiMoney;


    /**
     * 备注
     */

    @TableField(value = "xiaofei_content")
    private String xiaofeiContent;


    /**
     * 消费时间
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
	 * 设置：消费名目
	 */
    public String getXiaofeiName() {
        return xiaofeiName;
    }


    /**
	 * 获取：消费名目
	 */

    public void setXiaofeiName(String xiaofeiName) {
        this.xiaofeiName = xiaofeiName;
    }
    /**
	 * 设置：消费类型
	 */
    public Integer getXiaofeiTypes() {
        return xiaofeiTypes;
    }


    /**
	 * 获取：消费类型
	 */

    public void setXiaofeiTypes(Integer xiaofeiTypes) {
        this.xiaofeiTypes = xiaofeiTypes;
    }
    /**
	 * 设置：消费金额
	 */
    public Double getXiaofeiMoney() {
        return xiaofeiMoney;
    }


    /**
	 * 获取：消费金额
	 */

    public void setXiaofeiMoney(Double xiaofeiMoney) {
        this.xiaofeiMoney = xiaofeiMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getXiaofeiContent() {
        return xiaofeiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setXiaofeiContent(String xiaofeiContent) {
        this.xiaofeiContent = xiaofeiContent;
    }
    /**
	 * 设置：消费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：消费时间
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
