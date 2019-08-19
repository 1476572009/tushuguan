package org.taru.lanqiao.mmmm.model;

import java.util.List;

public class role {
    private String roleId;
    private String roleName;
    private String roleComment;
    private String roleStatus;
    private List pris;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public List getPris() {
        return pris;
    }

    public void setPris(List pris) {
        this.pris = pris;
    }
}
