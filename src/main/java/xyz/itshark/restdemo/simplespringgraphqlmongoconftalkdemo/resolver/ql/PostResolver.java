package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;

@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {
	
	private final AuthorRepository authRepository;	
	
	public Author createdBy(Post post) {
		return authRepository.findOne(post.getAuthorId());
	}	
}
