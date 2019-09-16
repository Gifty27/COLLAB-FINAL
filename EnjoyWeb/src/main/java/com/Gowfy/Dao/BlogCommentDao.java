package com.Gowfy.Dao;

import java.util.List;

import com.Gowfy.model.BlogComment;

public interface BlogCommentDao {
	void addBlogComment(BlogComment blogcomment);
	List<BlogComment> getBlogComment(int BlogPostId);
	void deleteBlogComment(BlogComment blogcomment);

}
