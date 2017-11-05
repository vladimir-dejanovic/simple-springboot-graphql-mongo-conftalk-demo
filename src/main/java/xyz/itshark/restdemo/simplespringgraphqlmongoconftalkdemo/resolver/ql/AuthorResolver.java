package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RequiredArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {
	
	private final PostRepository postRepository;
	
	public List<Post> posts(Author auth) {
		return postRepository.findByAuthorId(auth.getId());
	}
}
