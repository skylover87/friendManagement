package com.friends.service;

import com.friends.api.FriendsJson;
import com.friends.api.FriendsRespondJson;
import com.friends.domain.Friends;
import com.friends.domain.ProfileAccount;
import com.friends.repo.FriendsRepository;
import com.friends.repo.ProfileAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seng kai on 3/18/2017.
 */
@Service
public class FriendConnectionService implements IFriendConnectionService {

  @Autowired
  private ProfileAccountRepository profileAccountRepository;

  @Autowired
  private FriendsRepository friendsRepository;

  @Override
  public FriendsRespondJson createFriendsConnection(FriendsJson friendsJson) {

    //Check for any duplicates
    List<String>
        listWithoutDuplicates =
        friendsJson.getFriends().parallelStream().distinct().collect(
            Collectors.toList());

    //Check if the account exist if does not exist create first
    listWithoutDuplicates.stream().forEach(s -> {
      ProfileAccount profileAccount = null;
      profileAccount = profileAccountRepository.findOne(s);

      if (profileAccount == null) {
        profileAccount = new ProfileAccount(s);
        profileAccountRepository.save(profileAccount);
      }
    });

    boolean
        isConnectionExist =
        (friendsRepository
            .isFriendConnectionExist(listWithoutDuplicates.get(0), listWithoutDuplicates.get(1))
            != null ? true : false);

    if (!isConnectionExist) {
      Friends friends = new Friends(listWithoutDuplicates.get(0), listWithoutDuplicates.get(1));
      friendsRepository.save(friends);

      return new FriendsRespondJson.Builder().success(true).build();
    }
    return new FriendsRespondJson.Builder().success(false).build();
  }

  @Override
  public FriendsRespondJson getFriendList(String accountId) {
    List<String> friendList = friendsRepository.getFriendList(accountId);
    if(friendList.isEmpty()){
      return new FriendsRespondJson.Builder().success(false).count(0)
          .build();
    }else{
      return new FriendsRespondJson.Builder()
          .success(true)
          .friends(friendList)
          .count(friendList.size())
          .build();
    }
  }
}
