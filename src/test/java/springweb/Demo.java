package springweb;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo {

    public static void main(String[] args) throws JsonProcessingException {

        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(3000);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(m);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.setMessageConverters(messageConverters);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "2ef80a528f8f4040ba34c91ef314ef9a");
        map.put("userid", "ddd");
        map.put("info", "来个校花");

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(map);
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonStr, headers);

        ResponseEntity<String> entity = restTemplate.postForEntity("http://www.tuling123.com/openapi/api", formEntity,
                String.class);

        System.out.println(entity.getBody());
    }

}
