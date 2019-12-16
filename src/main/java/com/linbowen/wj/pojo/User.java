package com.linbowen.wj.pojo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class User {

  private long id;
  private String username;
  private String password;
  private Date createTime;
  private Date updateTime;

  // token的有效时长
  private final static long EXPIRE_TIME = 1000*60*30;

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

    /**
     * 根据user信息生成token
     * @param
     * @return
     */
  public String getToken() {
      String token = "";
      token = JWT.create().withAudience(String.valueOf(this.getId()))
              .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
              .sign(Algorithm.HMAC256(this.getPassword()));
      return token;
  }

}
