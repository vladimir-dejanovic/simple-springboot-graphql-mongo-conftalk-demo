package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.CommentRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@SpringBootApplication
public class SimpleSpringGraphqlMongoConftalkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringGraphqlMongoConftalkDemoApplication.class, args);
	}
	
	@Bean
	@Autowired
	public ServletRegistrationBean graphQLServlet(PostRepository postRepository, AuthorRepository authRepository, CommentRepository commentRepository) {
		return new ServletRegistrationBean(new GraphQLEntryPoint(postRepository, authRepository,commentRepository),"/graphql");
	}

}
