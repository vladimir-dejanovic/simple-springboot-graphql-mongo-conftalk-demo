package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="posts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

	@Id
	private final String id;
	
	//private final String authourId;
	
	@NotNull
	private String authorId;
	
	private final String title;
	private final String body;
	
	private String zika;
}
