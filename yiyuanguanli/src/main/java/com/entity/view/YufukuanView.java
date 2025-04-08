package com.entity.view;

import com.entity.YufukuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 预付款账户
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yufukuan")
public class YufukuanView extends YufukuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 bingli
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
			* 科室
			*/
			private Integer keshiTypes;
				/**
				* 科室的值
				*/
				private String keshiValue;
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
				* 病例状态的值
				*/
				private String bingliYesnoValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 诊断时间
			*/
			private Date insertTime;

	public YufukuanView() {

	}

	public YufukuanView(YufukuanEntity yufukuanEntity) {
		try {
			BeanUtils.copyProperties(this, yufukuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set bingli
					/**
					* 获取： 住院号
					*/
					public String getHuanzheDanhaoNumber() {
						return huanzheDanhaoNumber;
					}
					/**
					* 设置： 住院号
					*/
					public void setHuanzheDanhaoNumber(String huanzheDanhaoNumber) {
						this.huanzheDanhaoNumber = huanzheDanhaoNumber;
					}
					/**
					* 获取： 患者姓名
					*/
					public String getHuanzheName() {
						return huanzheName;
					}
					/**
					* 设置： 患者姓名
					*/
					public void setHuanzheName(String huanzheName) {
						this.huanzheName = huanzheName;
					}
					/**
					* 获取： 患者手机号
					*/
					public String getHuanzhePhone() {
						return huanzhePhone;
					}
					/**
					* 设置： 患者手机号
					*/
					public void setHuanzhePhone(String huanzhePhone) {
						this.huanzhePhone = huanzhePhone;
					}
					/**
					* 获取： 患者身份证号
					*/
					public String getHuanzheIdNumber() {
						return huanzheIdNumber;
					}
					/**
					* 设置： 患者身份证号
					*/
					public void setHuanzheIdNumber(String huanzheIdNumber) {
						this.huanzheIdNumber = huanzheIdNumber;
					}
					/**
					* 获取： 科室
					*/
					public Integer getKeshiTypes() {
						return keshiTypes;
					}
					/**
					* 设置： 科室
					*/
					public void setKeshiTypes(Integer keshiTypes) {
						this.keshiTypes = keshiTypes;
					}


						/**
						* 获取： 科室的值
						*/
						public String getKeshiValue() {
							return keshiValue;
						}
						/**
						* 设置： 科室的值
						*/
						public void setKeshiValue(String keshiValue) {
							this.keshiValue = keshiValue;
						}
					/**
					* 获取： 主诉详情
					*/
					public String getZhusuContent() {
						return zhusuContent;
					}
					/**
					* 设置： 主诉详情
					*/
					public void setZhusuContent(String zhusuContent) {
						this.zhusuContent = zhusuContent;
					}
					/**
					* 获取： 诊断详情
					*/
					public String getZhenduanContent() {
						return zhenduanContent;
					}
					/**
					* 设置： 诊断详情
					*/
					public void setZhenduanContent(String zhenduanContent) {
						this.zhenduanContent = zhenduanContent;
					}
					/**
					* 获取： 病例状态
					*/
					public Integer getBingliYesnoTypes() {
						return bingliYesnoTypes;
					}
					/**
					* 设置： 病例状态
					*/
					public void setBingliYesnoTypes(Integer bingliYesnoTypes) {
						this.bingliYesnoTypes = bingliYesnoTypes;
					}


						/**
						* 获取： 病例状态的值
						*/
						public String getBingliYesnoValue() {
							return bingliYesnoValue;
						}
						/**
						* 设置： 病例状态的值
						*/
						public void setBingliYesnoValue(String bingliYesnoValue) {
							this.bingliYesnoValue = bingliYesnoValue;
						}
					/**
					* 获取： 诊断时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 诊断时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}






















}
