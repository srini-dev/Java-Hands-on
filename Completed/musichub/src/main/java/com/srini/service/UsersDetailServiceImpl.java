package com.srini.service;

import com.srini.dao.UsersDetailDao;
import com.srini.model.MUsersDetail;
import com.srini.service.UsersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UsersDetailServiceImpl implements UsersDetailService{

    @Autowired
    private UsersDetailDao usersDetailDao;

    public void addUser (MUsersDetail usersDetail) {
    	usersDetailDao.addUser(usersDetail);
    }

    public MUsersDetail getUserById(int userId) {
        return usersDetailDao.getUserById(userId);
    }

    public List<MUsersDetail> getAllUsers() {
        return usersDetailDao.getAllUsers();
    }

    public MUsersDetail getUserByUsername (String username) {
        return usersDetailDao.getUserByUsername(username);
    }
}
