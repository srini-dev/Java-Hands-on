package com.coders.rscontrollers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.coders.dao.UsersDao;
import com.coders.model.Users;



@RestController
public class UsersController
{
	@Autowired
	Users users;
	
	@Autowired
	UsersDao usersDao;
	
	
	  //-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> listAllUsers() {
        List<Users> userslst = usersDao.getAllUser();
        
        if(userslst.isEmpty()){
            return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Users>>(userslst, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/dologs/{uid}/{pwd}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUser(@PathVariable("uid") String uid,@PathVariable("pwd") String pwd) {
        System.out.println("Fetching User with id "+uid);
        users = usersDao.getUsr(uid, pwd);
        if (users == null) {
            System.out.println("User with id  not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/insert/", method = RequestMethod.POST )
    public ResponseEntity<Void> createUser(@ModelAttribute("user") Users user, @RequestBody Users users,   UriComponentsBuilder ucBuilder) {
           System.out.println("Done Here "+user.getEmail());
           
        usersDao.SaveOrUpdate(users);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(users.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Users> updateUser(@PathVariable("id") String uid, @RequestBody Users users) {
//        System.out.println("Updating User gggg" + uid);
//         
//        Users currentUser = usersDao.getUsr(uid);
//         
//        if (currentUser==null) {
//            System.out.println("User with id " + uid + " not found");
//            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
//        }
// 
//        currentUser.setId(users.getId());
//        currentUser.setUid(users.getUid());
//        currentUser.setPwd(users.getPwd());
//        currentUser.setUnam(users.getUnam());
//         
//        usersDao.SaveOrUpdate(currentUser);
//        return new ResponseEntity<Users>(currentUser, HttpStatus.OK);
//    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteUser(@PathVariable("uid") int id) {
        System.out.println("Fetching & Deleting User with id " + id);
        usersDao.delete(id);
        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
    }
 
     
    
   
}
