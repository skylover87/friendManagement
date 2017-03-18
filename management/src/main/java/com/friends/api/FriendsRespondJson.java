package com.friends.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "friends",
    "count"
})
public class FriendsRespondJson implements Serializable {

  private final static long serialVersionUID = 6533355981690220684L;
  @JsonProperty("success")
  private Boolean success;
  @JsonProperty("friends")
  private List<String> friends = new ArrayList<String>();
  @JsonProperty("count")
  private Integer count;

  public FriendsRespondJson() {

  }

  private FriendsRespondJson(Builder builder) {
    setSuccess(builder.success);
    setFriends(builder.friends);
    setCount(builder.count);
  }

  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  @JsonProperty("success")
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  @JsonProperty("friends")
  public List<String> getFriends() {
    return friends;
  }

  @JsonProperty("friends")
  public void setFriends(List<String> friends) {
    this.friends = friends;
  }

  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  @JsonProperty("count")
  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FriendsRespondJson that = (FriendsRespondJson) o;
    return Objects.equals(success, that.success) &&
        Objects.equals(friends, that.friends) &&
        Objects.equals(count, that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, friends, count);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .append("success", success)
        .append("friends", friends)
        .append("count", count)
        .toString();
  }


  public static final class Builder {
    private Boolean success;
    private List<String> friends;
    private Integer count;

    public Builder() {
    }

    public Builder success(Boolean val) {
      success = val;
      return this;
    }

    public Builder friends(List<String> val) {
      friends = val;
      return this;
    }

    public Builder count(Integer val) {
      count = val;
      return this;
    }

    public FriendsRespondJson build() {
      return new FriendsRespondJson(this);
    }
  }
}