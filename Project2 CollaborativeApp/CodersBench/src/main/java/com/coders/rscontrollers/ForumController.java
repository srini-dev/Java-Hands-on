package com.coders.rscontrollers;

import java.util.List;

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

import com.coders.dao.FReplyDao;
import com.coders.dao.ForumMaterDao;
import com.coders.model.FReply;
import com.coders.model.ForumMaster;

@RestController
public class ForumController
{
	@Autowired
	ForumMaster forumMaster;
	
	@Autowired
	ForumMaterDao forumMaterDao;
	
	@Autowired
	FReplyDao fReplyDao;
	
	@Autowired
	FReply fReply;
	
	@RequestMapping(value = "/forums", method = RequestMethod.GET)
    public ResponseEntity<List<ForumMaster>> listAllblogs() {
        List<ForumMaster> frmlst = forumMaterDao.list();
        
        if(frmlst.isEmpty()){
            return new ResponseEntity<List<ForumMaster>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ForumMaster>>(frmlst, HttpStatus.OK);
    }
 
 
 @RequestMapping(value = "/frmadd/insert/", method = RequestMethod.POST )
    public ResponseEntity<Void> createForum(@ModelAttribute("forumm") ForumMaster forummaster, @RequestBody ForumMaster forumMaster,   UriComponentsBuilder ucBuilder) {
           System.out.println("Done Here Blog Storing ");
           forumMaterDao.SaveOrUpdate(forumMaster);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/frmadd/{fid}").buildAndExpand(forumMaster.getFid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
  //REPLYES---------------------------------------------------------------------------------------------------------------------
 @RequestMapping(value = "/reply/insert/", method = RequestMethod.POST )
 public ResponseEntity<Void> addReply(@ModelAttribute("reply") FReply frply,@RequestBody FReply fReply,   UriComponentsBuilder ucBuilder) {
        System.out.println("Done Here commect Storing ");
        fReplyDao.SaveOrUpdate(fReply);
//        int x=0;
//        x=forumMaterDao.getlikes(fReply.getFid());
//        System.out.println("UUUUUUUUUUUUUUUUUUUUU"+x);
//        System.out.println("UUUUUUUUUUUUUUUUUUUUU  "+forumMaster.getFdy());
//        x=x+1;
//        forumMaster.setFcmtct(x);
//        forumMaster.setFid(fReply.getFid());;
//        forumMaterDao.SaveOrUpdate(forumMaster);
        
     HttpHeaders headers = new HttpHeaders();
     headers.setLocation(ucBuilder.path("/reply/{fid}").buildAndExpand(fReply.getFid()).toUri());
     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 }
 
 @RequestMapping(value = "/replies/{fid}", method = RequestMethod.GET)
    public ResponseEntity<List<FReply>> listAllComents(@PathVariable("fid") int fid) {
     System.out.println(fid);   
	 List<FReply> rpllst = fReplyDao.getRpls(fid);
        
        if(rpllst.isEmpty()){
            return new ResponseEntity<List<FReply>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FReply>>(rpllst, HttpStatus.OK);
    }
// 
 
	
}
