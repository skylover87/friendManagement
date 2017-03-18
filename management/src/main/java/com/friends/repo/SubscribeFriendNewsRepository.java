package com.friends.repo;

import com.friends.domain.SubscribeFriendNews;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by seng kai on 3/19/2017.
 */
public interface SubscribeFriendNewsRepository extends CrudRepository<SubscribeFriendNews, String> {

  @Query("select f from SubscribeFriendNews f where f.ownerId = :ownerId and f.friendId = :friendId ")
  SubscribeFriendNews isAlreadySubscribeBlock(@Param("ownerId") String ownerId, @Param("friendId") String friendId);
}
