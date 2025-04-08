package com.entity.view;

import com.entity.ChuangweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 床位
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuangwei")
public class ChuangweiView extends ChuangweiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否入住的值
		*/
		private String chuangweiYesnoValue;



	public ChuangweiView() {

	}

	public ChuangweiView(ChuangweiEntity chuangweiEntity) {
		try {
			BeanUtils.copyProperties(this, chuangweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
