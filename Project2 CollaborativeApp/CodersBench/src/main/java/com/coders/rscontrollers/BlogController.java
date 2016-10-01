package com.coders.rscontrollers;

import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.coders.dao.BCommentDao;
import com.coders.dao.BlogMasterDao;
import com.coders.model.BComment;
import com.coders.model.BlogMaster;


@RestController
public class BlogController {
	
	@Autowired
	BlogMaster blogMaster;
	
	@Autowired
	BlogMasterDao blogMasterDao;
	
	@Autowired
	BCommentDao bcommentDao;
	
	@Autowired
	BComment bcomment;
	
	 @RequestMapping(value = "/blogs", method = RequestMethod.GET)
	    public ResponseEntity<List<BlogMaster>> listAllblogs() {
	        List<BlogMaster> bloglst = blogMasterDao.list();
	        
	        if(bloglst.isEmpty()){
	            return new ResponseEntity<List<BlogMaster>>(HttpStatus.NO_CONTENT);
	            //You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<BlogMaster>>(bloglst, HttpStatus.OK);
	    }
	 
	 
	 @RequestMapping(value = "/blog/insert/", method = RequestMethod.POST )
	    public ResponseEntity<Void> createUser(@ModelAttribute("blog") BlogMaster blogmaster, @RequestBody BlogMaster blogMaster,   UriComponentsBuilder ucBuilder) {
	           System.out.println("Done Here Blog Storing ");
	           

	        blogMasterDao.SaveOrUpdate(blogMaster);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(blogMaster.getBid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	 
	 
	 
	 
	 //COMMENTS
	 
	 @RequestMapping(value = "/coments/{bid}", method = RequestMethod.GET)
	    public ResponseEntity<List<BComment>> listAllComents(@PathVariable("bid") int bid) {
	     System.out.println(bid);   
		 List<BComment> cmtlst = bcommentDao.getCmts(bid);
	        
	        if(cmtlst.isEmpty()){
	            return new ResponseEntity<List<BComment>>(HttpStatus.NO_CONTENT);
	            //You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<BComment>>(cmtlst, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/cmnt/insert/", method = RequestMethod.POST )
	    public ResponseEntity<Void> createUser(@ModelAttribute("comment") BComment bcomment, @RequestBody BComment comment,   UriComponentsBuilder ucBuilder) {
	           System.out.println("Done Here commect Storing ");
	           

	        bcommentDao.SaveOrUpdate(comment);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(comment.getBid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
}
