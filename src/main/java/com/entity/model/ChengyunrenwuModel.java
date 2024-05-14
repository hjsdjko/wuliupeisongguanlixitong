package com.entity.model;

import com.entity.ChengyunrenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 承运任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChengyunrenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 运单号
     */
    private String chengyunrenwuUuidNumber;


    /**
     * 出发地
     */
    private String chengyunrenwuChufadi;


    /**
     * 目的地
     */
    private String chengyunrenwuMudidi;


    /**
     * 成本
     */
    private Double chengyunrenwuMoney;


    /**
     * 运单状态
     */
    private Integer chengyunrenwuTypes;


    /**
     * 详情
     */
    private String chengyunrenwuContent;


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
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：运单号
	 */
    public String getChengyunrenwuUuidNumber() {
        return chengyunrenwuUuidNumber;
    }


    /**
	 * 设置：运单号
	 */
    public void setChengyunrenwuUuidNumber(String chengyunrenwuUuidNumber) {
        this.chengyunrenwuUuidNumber = chengyunrenwuUuidNumber;
    }
    /**
	 * 获取：出发地
	 */
    public String getChengyunrenwuChufadi() {
        return chengyunrenwuChufadi;
    }


    /**
	 * 设置：出发地
	 */
    public void setChengyunrenwuChufadi(String chengyunrenwuChufadi) {
        this.chengyunrenwuChufadi = chengyunrenwuChufadi;
    }
    /**
	 * 获取：目的地
	 */
    public String getChengyunrenwuMudidi() {
        return chengyunrenwuMudidi;
    }


    /**
	 * 设置：目的地
	 */
    public void setChengyunrenwuMudidi(String chengyunrenwuMudidi) {
        this.chengyunrenwuMudidi = chengyunrenwuMudidi;
    }
    /**
	 * 获取：成本
	 */
    public Double getChengyunrenwuMoney() {
        return chengyunrenwuMoney;
    }


    /**
	 * 设置：成本
	 */
    public void setChengyunrenwuMoney(Double chengyunrenwuMoney) {
        this.chengyunrenwuMoney = chengyunrenwuMoney;
    }
    /**
	 * 获取：运单状态
	 */
    public Integer getChengyunrenwuTypes() {
        return chengyunrenwuTypes;
    }


    /**
	 * 设置：运单状态
	 */
    public void setChengyunrenwuTypes(Integer chengyunrenwuTypes) {
        this.chengyunrenwuTypes = chengyunrenwuTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getChengyunrenwuContent() {
        return chengyunrenwuContent;
    }


    /**
	 * 设置：详情
	 */
    public void setChengyunrenwuContent(String chengyunrenwuContent) {
        this.chengyunrenwuContent = chengyunrenwuContent;
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
