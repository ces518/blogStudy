package kr.or.blog.blog;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.filter.reactive.HiddenHttpMethodFilter
@SpringBootApplication
@ComponentScan(basePackages="kr.or.blog.*")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
// jpa 레포지토리 스캔설정
@EnableJpaRepositories("kr.or.blog.*")
// 엔티티 스캔 설정
@EntityScan("kr.or.blog.entities")
public class BlogApplication{
	
	@Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}