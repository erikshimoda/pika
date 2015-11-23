package com.cartrader.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.cartrader.core.models.entities.Blog;
import com.cartrader.rest.mvc.AccountController;
import com.cartrader.rest.mvc.BlogController;
import com.cartrader.rest.resources.BlogResource;

public class BlogResourceAsm extends
		ResourceAssemblerSupport<Blog, BlogResource> {
	public BlogResourceAsm() {
		super(BlogController.class, BlogResource.class);
	}

	@Override
	public BlogResource toResource(Blog blog) {
		BlogResource resource = new BlogResource();
		resource.setTitle(blog.getTitle());
		resource.add(linkTo(BlogController.class).slash(blog.getId())
				.withSelfRel());
		resource.add(linkTo(BlogController.class).slash(blog.getId())
				.slash("blog-entries").withRel("entries"));
		resource.setRid(blog.getId());
		if (blog.getOwner() != null)
			resource.add(linkTo(AccountController.class).slash(
					blog.getOwner().getId()).withRel("owner"));
		return resource;
	}
}
