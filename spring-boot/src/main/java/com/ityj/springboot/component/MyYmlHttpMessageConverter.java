package com.ityj.springboot.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public class MyYmlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

	private static final MediaType APPLICATION_YML = new MediaType("application", "yml");

	private ObjectMapper objectMapper;

	public MyYmlHttpMessageConverter() {
		// 告诉springboot 当前的MessageConverter支持哪个MediaType
		super(APPLICATION_YML);
		YAMLFactory yamlFactory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
		this.objectMapper = new ObjectMapper(yamlFactory);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override  // 处理@RequestBody
	protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override// 处理@ResponseBody
	protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		this.objectMapper.writeValue(outputMessage.getBody(), o);
	}


}
