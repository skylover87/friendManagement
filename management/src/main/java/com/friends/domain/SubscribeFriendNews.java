package com.friends.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by seng kai on 3/18/2017.
 */
@Entity
public class SubscribeFriendNews implements Serializable {

  private static final long serialVersionUID = 1513819381743977949L;
  private Long id;
  private String ownerId;
  private String friendId;
  private boolean isSubscribeOrBlock;

  public SubscribeFriendNews() {
  }

  public SubscribeFriendNews(String ownerId, String friendId, boolean isSubscribeOrBlock) {
    this.ownerId = ownerId;
    this.friendId = friendId;
    this.isSubscribeOrBlock = isSubscribeOrBlock;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(nullable = false)
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  @Column(nullable = false)
  public String getFriendId() {
    return friendId;
  }

  public void setFriendId(String friendId) {
    this.friendId = friendId;
  }

  @Column(nullable = false)
  @Type(type="true_false")
  public boolean isSubscribeOrBlock() {
    return isSubscribeOrBlock;
  }

  public void setSubscribeOrBlock(boolean subscribeOrBlock) {
    isSubscribeOrBlock = subscribeOrBlock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscribeFriendNews that = (SubscribeFriendNews) o;
    return isSubscribeOrBlock == that.isSubscribeOrBlock &&
        Objects.equals(id, that.id) &&
        Objects.equals(ownerId, that.ownerId) &&
        Objects.equals(friendId, that.friendId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ownerId, friendId, isSubscribeOrBlock);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .append("id", id)
        .append("ownerId", ownerId)
        .append("friendId", friendId)
        .append("isSubscribeOrBlock", isSubscribeOrBlock)
        .toString();
  }
}
