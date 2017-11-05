package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Comment;


public interface CommentRepository extends MongoRepository<Comment,String> {
	List<Comment> findByPostId(String postId);
}
