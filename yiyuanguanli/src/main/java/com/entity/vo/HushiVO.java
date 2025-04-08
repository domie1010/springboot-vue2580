package com.entity.vo;

import com.entity.HushiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 护士
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hushi")
public class HushiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 护士姓名
     */

    @TableField(value = "hushi_name")
    private String hushiName;


    /**
     * 护士手机号
     */

    @TableField(value = "hushi_phone")
    private String hushiPhone;


    /**
     * 护士身份证号
     */

    @TableField(value = "hushi_id_number")
    private String hushiIdNumber;


    /**
     * 护士照片
     */

    @TableField(value = "hushi_photo")
    private String hushiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：护士姓名
	 */
    public String getHushiName() {
        return hushiName;
    }


    /**
	 * 获取：护士姓名
	 */

    public void setHushiName(String hushiName) {
        this.hushiName = hushiName;
    }
    /**
	 * 设置：护士手机号
	 */
    public String getHushiPhone() {
        return hushiPhone;
    }


    /**
	 * 获取：护士手机号
	 */

    public void setHushiPhone(String hushiPhone) {
        this.hushiPhone = hushiPhone;
    }
    /**
	 * 设置：护士身份证号
	 */
    public String getHushiIdNumber() {
        return hushiIdNumber;
    }


    /**
	 * 获取：护士身份证号
	 */

    public void setHushiIdNumber(String hushiIdNumber) {
        this.hushiIdNumber = hushiIdNumber;
    }
    /**
	 * 设置：护士照片
	 */
    public String getHushiPhoto() {
        return hushiPhoto;
    }


    /**
	 * 获取：护士照片
	 */

    public void setHushiPhoto(String hushiPhoto) {
        this.hushiPhoto = hushiPhoto;
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
