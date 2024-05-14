package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 承运任务
 *
 * @author 
 * @email
 */
@TableName("chengyunrenwu")
public class ChengyunrenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengyunrenwuEntity() {

	}

	public ChengyunrenwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 车辆
     */
    @TableField(value = "cheliang_id")

    private Integer cheliangId;


    /**
     * 运单号
     */
    @TableField(value = "chengyunrenwu_uuid_number")

    private String chengyunrenwuUuidNumber;


    /**
     * 出发地
     */
    @TableField(value = "chengyunrenwu_chufadi")

    private String chengyunrenwuChufadi;


    /**
     * 目的地
     */
    @TableField(value = "chengyunrenwu_mudidi")

    private String chengyunrenwuMudidi;


    /**
     * 成本
     */
    @TableField(value = "chengyunrenwu_money")

    private Double chengyunrenwuMoney;


    /**
     * 运单状态
     */
    @TableField(value = "chengyunrenwu_types")

    private Integer chengyunrenwuTypes;


    /**
     * 详情
     */
    @TableField(value = "chengyunrenwu_content")

    private String chengyunrenwuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：运单号
	 */
    public String getChengyunrenwuUuidNumber() {
        return chengyunrenwuUuidNumber;
    }


    /**
	 * 获取：运单号
	 */

    public void setChengyunrenwuUuidNumber(String chengyunrenwuUuidNumber) {
        this.chengyunrenwuUuidNumber = chengyunrenwuUuidNumber;
    }
    /**
	 * 设置：出发地
	 */
    public String getChengyunrenwuChufadi() {
        return chengyunrenwuChufadi;
    }


    /**
	 * 获取：出发地
	 */

    public void setChengyunrenwuChufadi(String chengyunrenwuChufadi) {
        this.chengyunrenwuChufadi = chengyunrenwuChufadi;
    }
    /**
	 * 设置：目的地
	 */
    public String getChengyunrenwuMudidi() {
        return chengyunrenwuMudidi;
    }


    /**
	 * 获取：目的地
	 */

    public void setChengyunrenwuMudidi(String chengyunrenwuMudidi) {
        this.chengyunrenwuMudidi = chengyunrenwuMudidi;
    }
    /**
	 * 设置：成本
	 */
    public Double getChengyunrenwuMoney() {
        return chengyunrenwuMoney;
    }


    /**
	 * 获取：成本
	 */

    public void setChengyunrenwuMoney(Double chengyunrenwuMoney) {
        this.chengyunrenwuMoney = chengyunrenwuMoney;
    }
    /**
	 * 设置：运单状态
	 */
    public Integer getChengyunrenwuTypes() {
        return chengyunrenwuTypes;
    }


    /**
	 * 获取：运单状态
	 */

    public void setChengyunrenwuTypes(Integer chengyunrenwuTypes) {
        this.chengyunrenwuTypes = chengyunrenwuTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getChengyunrenwuContent() {
        return chengyunrenwuContent;
    }


    /**
	 * 获取：详情
	 */

    public void setChengyunrenwuContent(String chengyunrenwuContent) {
        this.chengyunrenwuContent = chengyunrenwuContent;
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

    @Override
    public String toString() {
        return "Chengyunrenwu{" +
            "id=" + id +
            ", cheliangId=" + cheliangId +
            ", chengyunrenwuUuidNumber=" + chengyunrenwuUuidNumber +
            ", chengyunrenwuChufadi=" + chengyunrenwuChufadi +
            ", chengyunrenwuMudidi=" + chengyunrenwuMudidi +
            ", chengyunrenwuMoney=" + chengyunrenwuMoney +
            ", chengyunrenwuTypes=" + chengyunrenwuTypes +
            ", chengyunrenwuContent=" + chengyunrenwuContent +
            ", createTime=" + createTime +
        "}";
    }
}
