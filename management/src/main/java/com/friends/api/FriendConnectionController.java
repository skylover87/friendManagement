package com.friends.api;

import com.friends.service.IFriendConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by seng kai on 3/18/2017.
 */
@RestController
public class FriendConnectionController {

  @Autowired
  IFriendConnectionService iFriendConnectionService;

  @RequestMapping(value = "/friends/createConnection", method = RequestMethod.POST)
  @ResponseBody
  public FriendsRespondJson createFriendsConnection(@Valid @RequestBody FriendsJson friendsJson){
    return iFriendConnectionService.createFriendsConnection(friendsJson);
  }

  @RequestMapping(value = "/friends/findFriend", method = RequestMethod.POST)
  @ResponseBody
  public FriendsRespondJson getFriendList(@Valid @RequestBody FriendsJson friendsJson){
    return iFriendConnectionService.getFriendList(friendsJson.getEmail());
  }
}
