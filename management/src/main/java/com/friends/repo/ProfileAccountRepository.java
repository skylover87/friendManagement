package com.friends.repo;

import com.friends.domain.ProfileAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by seng kai on 3/18/2017.
 */
@RepositoryRestResource
public interface ProfileAccountRepository extends CrudRepository<ProfileAccount, String>{
}
