package com.cpy.BI.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户
 * @TableName chart
 */
@TableName(value ="chart")
@Data
public class Chart implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表数据
     */
    private String charData;

    /**
     * 图标类型
     */
    private String charType;

    /**
     * 生成的图表数据
     */
    private String genChart;

    /**
     * 生成的分析结论
     */
    private String genResult;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic(value = "0",delval = "1")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Chart other = (Chart) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoal() == null ? other.getGoal() == null : this.getGoal().equals(other.getGoal()))
            && (this.getCharData() == null ? other.getCharData() == null : this.getCharData().equals(other.getCharData()))
            && (this.getCharType() == null ? other.getCharType() == null : this.getCharType().equals(other.getCharType()))
            && (this.getGenChart() == null ? other.getGenChart() == null : this.getGenChart().equals(other.getGenChart()))
            && (this.getGenResult() == null ? other.getGenResult() == null : this.getGenResult().equals(other.getGenResult()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoal() == null) ? 0 : getGoal().hashCode());
        result = prime * result + ((getCharData() == null) ? 0 : getCharData().hashCode());
        result = prime * result + ((getCharType() == null) ? 0 : getCharType().hashCode());
        result = prime * result + ((getGenChart() == null) ? 0 : getGenChart().hashCode());
        result = prime * result + ((getGenResult() == null) ? 0 : getGenResult().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goal=").append(goal);
        sb.append(", charData=").append(charData);
        sb.append(", charType=").append(charType);
        sb.append(", genChart=").append(genChart);
        sb.append(", genResult=").append(genResult);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}