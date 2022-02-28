package com.fc.ithink.model.auto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class TsysUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@ApiModelProperty(value = "主键")
	private String id;
		
	/** 用户账号 **/
	@ApiModelProperty(value = "用户账号")
	private String username;
		
	/** 用户密码 **/
	@ApiModelProperty(value = "用户密码")
	private String password;
		
	/** 昵称 **/
	@ApiModelProperty(value = "昵称")
	private String nickname;
		
	/** 部门id **/
	@ApiModelProperty(value = "部门id")
	private Integer depId;
		
	/** 岗位id **/
	@ApiModelProperty(value = "岗位id")
	private String posId;


	/** 邮箱 **/
	@ApiModelProperty(value = "邮箱")
	private String email;
	/** 头像 **/
	@ApiModelProperty(value = "头像")
	private String avatar;
	/** 性别 **/
	@ApiModelProperty(value = "性别")
	private int sex;
	/** 描述 **/
	@ApiModelProperty(value = "描述")
	private String description;
	/** 标签 **/
	@ApiModelProperty(value = "标签")
	private String label;

	/** 思想 **/
	@ApiModelProperty(value = "思想")
	private int think;
	/** 禁言 **/
	@ApiModelProperty(value = "禁言")
	private String writeAuth;
	/** 作者 **/
	@ApiModelProperty(value = "作者")
	private String authSts;
	/** 生成时间 **/
	@ApiModelProperty(value = "生成时间")
	private Date createDat;

	private Date lUpdateDat;

	private int isDel;

	/**部门名称**/
	private String depName;
	/**岗位名称**/
	private String posName;

	

    public TsysUser(String id, String username, String password, String nickname, Integer depId, String posId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.depId = depId;
		this.posId = posId;
	}

	public TsysUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
	public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
	 
			
	public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getThink() {
		return think;
	}

	public void setThink(int think) {
		this.think = think;
	}

	public String getWriteAuth() {
		return writeAuth;
	}

	public void setWriteAuth(String writeAuth) {
		this.writeAuth = writeAuth;
	}

	public String getAuthSts() {
		return authSts;
	}

	public void setAuthSts(String authSts) {
		this.authSts = authSts;
	}

	public Date getCreateDat() {
		return createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	public Date getlUpdateDat() {
		return lUpdateDat;
	}

	public void setlUpdateDat(Date lUpdateDat) {
		this.lUpdateDat = lUpdateDat;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
}