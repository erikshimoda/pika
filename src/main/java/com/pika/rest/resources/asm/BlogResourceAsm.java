package com.pika.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.pika.core.models.entities.Blog;
import com.pika.rest.mvc.AccountController;
import com.pika.rest.mvc.BlogController;
import com.pika.rest.resources.BlogResource;

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
