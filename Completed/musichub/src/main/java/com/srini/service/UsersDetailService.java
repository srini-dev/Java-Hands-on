package com.srini.service;

import com.srini.model.MUsersDetail;

import java.util.List;


public interface UsersDetailService {

    void addUser (MUsersDetail usersDetail);

    MUsersDetail getUserById (int userId);

    List<MUsersDetail> getAllUsers();

    MUsersDetail getUserByUsername (String username);
}
