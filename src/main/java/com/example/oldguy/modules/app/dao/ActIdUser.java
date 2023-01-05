package com.example.oldguy.modules.app.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author generator
 * @since 2023-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ACT_ID_USER")
public class ActIdUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("FIRST_")
    private String firstName;

    @TableField("LAST_")
    private String lastName;

    @TableField("DISPLAY_NAME_")
    private String fullName;

    @TableField("EMAIL_")
    private String email;

    @TableField("PWD_")
    private String password;

    @TableField("PICTURE_ID_")
    private String pictureId;

    @TableField("TENANT_ID_")
    private String tenantId;


}
