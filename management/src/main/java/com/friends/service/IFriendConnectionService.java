package com.friends.service;

import com.friends.api.FriendsJson;
import com.friends.api.FriendsRespondJson;

/**
 * Created by seng kai on 3/18/2017.
 */
public interface IFriendConnectionService {

  FriendsRespondJson createFriendsConnection(FriendsJson friendsJson);

  FriendsRespondJson getFriendList(String accountId);
}
