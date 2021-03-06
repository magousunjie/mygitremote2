package cn.java.ckEc.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Member {
    private Integer id;
    
	@NotBlank
    @NotNull(message = "用户名格式错误!")
    @Pattern(regexp = ".{8,16}", message = "用户名格式错误!")
    private String memberName;
    
	@NotBlank
    @NotNull(message = "专业信息格式错误!")
    @Pattern(regexp = ".{2,30}", message = "专业信息格式错误!")
    private String major;
    
	@NotBlank
    @NotNull(message = "介绍信息格式错误!")
    @Pattern(regexp = ".{2,30}", message = "介绍信息格式错误!")
    private String description;
    
	@NotBlank
    @NotNull(message = "密码格式错误!")
    @Pattern(regexp = "\\w{8,32}", message = "密码格式错误!")
    private String password;

    private String headSculpture;

    private Boolean sex;
    
    private Date timeCreated;
    
    @NotBlank
    @NotNull(message = "手机号格式错误!")
    @Pattern(regexp = "1[356789]\\d{9}", message = "手机号格式错误!")
    private String cellphone;

    private Boolean permissionType1;

    private Boolean permissionType2;

    private Boolean permissionType3;

    private Boolean permissionType4;

    private Boolean permissionType5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Boolean getPermissionType1() {
        return permissionType1;
    }

    public void setPermissionType1(Boolean permissionType1) {
        this.permissionType1 = permissionType1;
    }

    public Boolean getPermissionType2() {
        return permissionType2;
    }

    public void setPermissionType2(Boolean permissionType2) {
        this.permissionType2 = permissionType2;
    }

    public Boolean getPermissionType3() {
        return permissionType3;
    }

    public void setPermissionType3(Boolean permissionType3) {
        this.permissionType3 = permissionType3;
    }

    public Boolean getPermissionType4() {
        return permissionType4;
    }

    public void setPermissionType4(Boolean permissionType4) {
        this.permissionType4 = permissionType4;
    }

    public Boolean getPermissionType5() {
        return permissionType5;
    }

    public void setPermissionType5(Boolean permissionType5) {
        this.permissionType5 = permissionType5;
    }
}