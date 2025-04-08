package com.entity.view;

import com.entity.ChuangweiBingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 患者住院房屋
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuangwei_bingli")
public class ChuangweiBingliView extends ChuangweiBingliEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否在住的值
		*/
		private String chuangweiBingliYesnoValue;



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

		//级联表 chuangwei
			/**
			* 楼栋
			*/
			private String building;
			/**
			* 单元
			*/
			private String unit;
			/**
			* 房间号
			*/
			private String room;
			/**
			* 是否入住
			*/
			private Integer chuangweiYesnoTypes;
				/**
				* 是否入住的值
				*/
				private String chuangweiYesnoValue;

	public ChuangweiBingliView() {

	}

	public ChuangweiBingliView(ChuangweiBingliEntity chuangweiBingliEntity) {
		try {
			BeanUtils.copyProperties(this, chuangweiBingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否在住的值
			*/
			public String getChuangweiBingliYesnoValue() {
				return chuangweiBingliYesnoValue;
			}
			/**
			* 设置： 是否在住的值
			*/
			public void setChuangweiBingliYesnoValue(String chuangweiBingliYesnoValue) {
				this.chuangweiBingliYesnoValue = chuangweiBingliYesnoValue;
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


				//级联表的get和set chuangwei
					/**
					* 获取： 楼栋
					*/
					public String getBuilding() {
						return building;
					}
					/**
					* 设置： 楼栋
					*/
					public void setBuilding(String building) {
						this.building = building;
					}
					/**
					* 获取： 单元
					*/
					public String getUnit() {
						return unit;
					}
					/**
					* 设置： 单元
					*/
					public void setUnit(String unit) {
						this.unit = unit;
					}
					/**
					* 获取： 房间号
					*/
					public String getRoom() {
						return room;
					}
					/**
					* 设置： 房间号
					*/
					public void setRoom(String room) {
						this.room = room;
					}
					/**
					* 获取： 是否入住
					*/
					public Integer getChuangweiYesnoTypes() {
						return chuangweiYesnoTypes;
					}
					/**
					* 设置： 是否入住
					*/
					public void setChuangweiYesnoTypes(Integer chuangweiYesnoTypes) {
						this.chuangweiYesnoTypes = chuangweiYesnoTypes;
					}


						/**
						* 获取： 是否入住的值
						*/
						public String getChuangweiYesnoValue() {
							return chuangweiYesnoValue;
						}
						/**
						* 设置： 是否入住的值
						*/
						public void setChuangweiYesnoValue(String chuangweiYesnoValue) {
							this.chuangweiYesnoValue = chuangweiYesnoValue;
						}































}
