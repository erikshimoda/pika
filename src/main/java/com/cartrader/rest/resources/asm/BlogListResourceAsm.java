package com.cartrader.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.cartrader.core.services.util.BlogList;
import com.cartrader.rest.mvc.BlogController;
import com.cartrader.rest.resources.BlogListResource;

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
