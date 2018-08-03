package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Comment;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.CommentRepository;

@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {
	
	private final AuthorRepository authRepository;
	private final CommentRepository commentRepository;
	
	public Author createdBy(Post post) {
		System.out.println("post " + post.getTitle() + " authour" + post.getAuthorId());
		return authRepository.findOne(post.getAuthorId());
	}	
	
	public List<Comment> comments(Post post) {
		return commentRepository.findByPostId(post.getId());
	}	
}
