package com.techmania.remoteservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestServiceImpl{
	
	
	RestTemplate restTemplate;
	
	public <T, O> O postCall(T input, String url, Class<O> output) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<T> httpEntity = new HttpEntity<T>(input,headers);
		restTemplate = new RestTemplate();
		ResponseEntity<O> response = restTemplate.exchange(url, HttpMethod.POST,httpEntity,output);
		O res = response != null ? (O)response.getBody() : null;
		return res;
	}

	public RestTemplate getRestTemplate() {
		if(restTemplate != null) {
			return restTemplate;
		}
		restTemplate = new RestTemplate();
		
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter convertor =new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypeList = new ArrayList<MediaType>();
		mediaTypeList.add(MediaType.ALL);
		convertor.setSupportedMediaTypes(mediaTypeList);
		messageConverters.add(convertor);
		
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}
}
