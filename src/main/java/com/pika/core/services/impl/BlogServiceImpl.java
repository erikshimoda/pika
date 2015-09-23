package com.pika.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pika.core.models.entities.Blog;
import com.pika.core.models.entities.BlogEntry;
import com.pika.core.repositories.BlogEntryRepo;
import com.pika.core.repositories.BlogRepo;
import com.pika.core.services.BlogService;
import com.pika.core.services.exceptions.BlogNotFoundException;
import com.pika.core.services.util.BlogEntryList;
import com.pika.core.services.util.BlogList;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepo blogRepo;

	@Autowired
	private BlogEntryRepo entryRepo;

	@Override
	public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
		Blog blog = blogRepo.findBlog(blogId);
		if (blog == null) {
			throw new BlogNotFoundException();
		}
		BlogEntry entry = entryRepo.createBlogEntry(data);
		entry.setBlog(blog);
		return entry;
	}

	@Override
	public BlogList findAllBlogs() {
		return new BlogList(blogRepo.findAllBlogs());
	}

	@Override
	public BlogEntryList findAllBlogEntries(Long blogId) {
		Blog blog = blogRepo.findBlog(blogId);
		if (blog == null) {
			throw new BlogNotFoundException();
		}
		return new BlogEntryList(blogId, entryRepo.findByBlogId(blogId));
	}

	@Override
	public Blog findBlog(Long id) {
		return blogRepo.findBlog(id);
	}
}
