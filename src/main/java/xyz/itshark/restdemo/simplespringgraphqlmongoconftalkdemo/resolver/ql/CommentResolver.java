package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Comment;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RequiredArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {
	
	private final AuthorRepository authRepository;
	private final PostRepository postRepository;
	
	public Author createdBy(Comment comment) {
		return authRepository.findOne(comment.getAuthorId());
	}
	
	public Post belongsTo(Comment comment) {
		return postRepository.findOne(comment.getPostId());
	}

}
