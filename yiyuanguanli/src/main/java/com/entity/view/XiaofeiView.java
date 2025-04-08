package com.entity.view;

import com.entity.XiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 消费
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiaofei")
public class XiaofeiView extends XiaofeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 消费类型的值
		*/
		private String xiaofeiValue;



		//级联表 yufukuan
			/**
			* 患者
			*/
			private Integer bingliId;
			/**
			* 预付款账户
			*/
			private String yufukuanDanhaoNumber;
			/**
			* 预付款金额
			*/
			private Double yufukuanMoney;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 添加时间
			*/
			private Date insertTime;

	public XiaofeiView() {

	}

	public XiaofeiView(XiaofeiEntity xiaofeiEntity) {
		try {
			BeanUtils.copyProperties(this, xiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 消费类型的值
			*/
			public String getXiaofeiValue() {
				return xiaofeiValue;
			}
			/**
			* 设置： 消费类型的值
			*/
			public void setXiaofeiValue(String xiaofeiValue) {
				this.xiaofeiValue = xiaofeiValue;
			}






















				//级联表的get和set yufukuan
					/**
					* 获取： 患者
					*/
					public Integer getBingliId() {
						return bingliId;
					}
					/**
					* 设置： 患者
					*/
					public void setBingliId(Integer bingliId) {
						this.bingliId = bingliId;
					}
					/**
					* 获取： 预付款账户
					*/
					public String getYufukuanDanhaoNumber() {
						return yufukuanDanhaoNumber;
					}
					/**
					* 设置： 预付款账户
					*/
					public void setYufukuanDanhaoNumber(String yufukuanDanhaoNumber) {
						this.yufukuanDanhaoNumber = yufukuanDanhaoNumber;
					}
					/**
					* 获取： 预付款金额
					*/
					public Double getYufukuanMoney() {
						return yufukuanMoney;
					}
					/**
					* 设置： 预付款金额
					*/
					public void setYufukuanMoney(Double yufukuanMoney) {
						this.yufukuanMoney = yufukuanMoney;
					}
					/**
					* 获取： 添加时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 添加时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}




}
