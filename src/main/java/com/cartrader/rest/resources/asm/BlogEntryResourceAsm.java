package com.cartrader.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.cartrader.core.models.entities.BlogEntry;
import com.cartrader.rest.mvc.BlogController;
import com.cartrader.rest.mvc.BlogEntryController;
import com.cartrader.rest.resources.BlogEntryResource;

public class BlogEntryResourceAsm extends
		ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

	public BlogEntryResourceAsm() {
		super(BlogEntryController.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		res.setContent(blogEntry.getContent());
		res.setRid(blogEntry.getId());
		Link self = linkTo(BlogEntryController.class).slash(blogEntry.getId())
				.withSelfRel();
		res.add(self);
		if (blogEntry.getBlog() != null) {
			res.add((linkTo(BlogController.class).slash(
					blogEntry.getBlog().getId()).withRel("blog")));
		}
		return res;
	}
}
