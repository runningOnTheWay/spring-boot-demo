package cn.newbie.rabbitmq.project_use;

import java.io.Serializable;

public class MqRequestDto<T> implements Serializable {

	private RequestHeaderDto requestHeaderDto;
//	private Map<String,Object> headerDto;

	private T body;

	public RequestHeaderDto getRequestHeaderDto() {
		return requestHeaderDto;
	}

	public void setRequestHeaderDto(RequestHeaderDto requestHeaderDto) {
		this.requestHeaderDto = requestHeaderDto;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
