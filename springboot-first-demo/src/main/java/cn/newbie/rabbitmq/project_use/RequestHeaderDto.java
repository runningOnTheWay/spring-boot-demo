package cn.newbie.rabbitmq.project_use;

import lombok.Data;

import java.io.Serializable;

/**
 * 共通请求头
 */
@Data
public class RequestHeaderDto implements Serializable {
	private static final long serialVersionUID = -1095429451607367468L;

	/** sessionKey*/
	private String test_hotel_dt;

	/** 操作用户ID*/
	private String test_uid;

	/** token*/
	private String test_token;

	/** 跟踪ID*/
	private String test_tracerid;

	/** 批量处理异步ID*/
	private String test_asyncid;

	/** 语种 */
	private String test_language;

	/** 业务id */
	private String test_businessid;
}
