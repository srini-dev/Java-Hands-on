import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coders.dao.BlogMasterDao;
import com.coders.model.BlogMaster;






public class TestBlog {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.coders");
		ctx.refresh();
		BlogMaster bm=(BlogMaster) ctx.getBean("blogMaster");
		BlogMasterDao bmdao=(BlogMasterDao) ctx.getBean("blogMasterDao");
//		bm=new BlogMaster("BlogTitle", "This is testing", new java.util.Date(), "aa", "Edu", 0, 0);
//		bmdao.SaveOrUpdate(bm);
		System.out.println(bmdao.list().size());
		
		
//		BComment bc=(BComment) ctx.getBean("bcomment");
//		BCommentDao bdao=(BCommentDao) ctx.getBean("bcommentDao");
//		List<BComment> lst=bdao.getCmts(1);
//		System.out.println(lst.size());
	}
}
