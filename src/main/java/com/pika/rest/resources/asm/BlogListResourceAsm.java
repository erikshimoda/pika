package com.pika.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.pika.core.services.util.BlogList;
import com.pika.rest.mvc.BlogController;
import com.pika.rest.resources.BlogListResource;

public class BlogListResourceAsm extends
		ResourceAssemblerSupport<BlogList, BlogListResource> {

	public BlogListResourceAsm() {
		super(BlogController.class, BlogListResource.class);
	}

	@Override
	public BlogListResource toResource(BlogList blogList) {
		BlogListResource res = new BlogListResource();
		res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
		return res;
	}
}
