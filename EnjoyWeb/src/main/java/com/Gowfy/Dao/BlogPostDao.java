package com.Gowfy.Dao;

import java.util.List;

import com.Gowfy.model.BlogPost;

public interface BlogPostDao {
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getApprovedBlogs();
	BlogPost getBlogPost(int id);
	List<BlogPost> getBlogWaitingForApproval();
	void updateBlogPost(BlogPost blogPost);
	void deleteBlogPost(BlogPost blogPost);
	void updateLike(BlogPost blogPost);
}

