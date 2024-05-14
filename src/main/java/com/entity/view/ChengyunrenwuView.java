package com.entity.view;

import com.entity.ChengyunrenwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 承运任务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chengyunrenwu")
public class ChengyunrenwuView extends ChengyunrenwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 运单状态的值
		*/
		private String chengyunrenwuValue;



		//级联表 cheliang
			/**
			* 车辆 的 司机
			*/
			private Integer cheliangYonghuId;
			/**
			* 车牌号
			*/
			private String cheliangName;
			/**
			* 车辆类型
			*/
			private Integer cheliangTypes;
				/**
				* 车辆类型的值
				*/
				private String cheliangValue;
			/**
			* 车辆排量
			*/
			private String cheliangPailiang;
			/**
			* 车辆详情
			*/
			private String cheliangContent;

	public ChengyunrenwuView() {

	}

	public ChengyunrenwuView(ChengyunrenwuEntity chengyunrenwuEntity) {
		try {
			BeanUtils.copyProperties(this, chengyunrenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 运单状态的值
			*/
			public String getChengyunrenwuValue() {
				return chengyunrenwuValue;
			}
			/**
			* 设置： 运单状态的值
			*/
			public void setChengyunrenwuValue(String chengyunrenwuValue) {
				this.chengyunrenwuValue = chengyunrenwuValue;
			}




				//级联表的get和set cheliang
					/**
					* 获取：车辆 的 司机
					*/
					public Integer getCheliangYonghuId() {
						return cheliangYonghuId;
					}
					/**
					* 设置：车辆 的 司机
					*/
					public void setCheliangYonghuId(Integer cheliangYonghuId) {
						this.cheliangYonghuId = cheliangYonghuId;
					}

					/**
					* 获取： 车牌号
					*/
					public String getCheliangName() {
						return cheliangName;
					}
					/**
					* 设置： 车牌号
					*/
					public void setCheliangName(String cheliangName) {
						this.cheliangName = cheliangName;
					}
					/**
					* 获取： 车辆类型
					*/
					public Integer getCheliangTypes() {
						return cheliangTypes;
					}
					/**
					* 设置： 车辆类型
					*/
					public void setCheliangTypes(Integer cheliangTypes) {
						this.cheliangTypes = cheliangTypes;
					}


						/**
						* 获取： 车辆类型的值
						*/
						public String getCheliangValue() {
							return cheliangValue;
						}
						/**
						* 设置： 车辆类型的值
						*/
						public void setCheliangValue(String cheliangValue) {
							this.cheliangValue = cheliangValue;
						}
					/**
					* 获取： 车辆排量
					*/
					public String getCheliangPailiang() {
						return cheliangPailiang;
					}
					/**
					* 设置： 车辆排量
					*/
					public void setCheliangPailiang(String cheliangPailiang) {
						this.cheliangPailiang = cheliangPailiang;
					}
					/**
					* 获取： 车辆详情
					*/
					public String getCheliangContent() {
						return cheliangContent;
					}
					/**
					* 设置： 车辆详情
					*/
					public void setCheliangContent(String cheliangContent) {
						this.cheliangContent = cheliangContent;
					}










}
