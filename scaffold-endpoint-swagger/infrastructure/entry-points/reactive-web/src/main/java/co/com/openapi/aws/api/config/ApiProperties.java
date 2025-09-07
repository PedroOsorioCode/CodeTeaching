package co.com.openapi.aws.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "entries.reactive-web")
public class ApiProperties {
    private String pathBase;
    private String methodGet;
    private String methodPost;
    private String methodPut;
    private String methodDelete;
    private String methodFind;
}