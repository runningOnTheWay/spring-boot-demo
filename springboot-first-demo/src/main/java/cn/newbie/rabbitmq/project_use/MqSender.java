/**
 * Copyright 2016 Joint Wisdom Inc. All Rights Reserved.
 * You may use it ONLY by accepting the License unless writing permission or applicable law is required. 
 * Other un-authorized conditions shall not use freely. 
*/
package cn.newbie.rabbitmq.project_use;



/**
 * ## 类说明：
 * 	MQ发送接口
 * @since
*/
public interface MqSender {

	/**
	 * 发番保存
	 * @param msg
	 */
	void sendNumber(MqRequestDto msg);

	/**
	 * 登录记录
	 * @param msg
	 */
	void sendLogin(MqRequestDto msg);

	/**
	 * 事务补偿
	 * @param msg
	 */
	void sendCompensating(MqRequestDto msg);

	/**
	 * 延迟队列的事务补偿
	 * @param msg
	 */
	void sendLongDelay(MqRequestDto msg);

	/**
	 * 发送操作日志并记录
	 * @param msg
	 */
	void sendLog(MqRequestDto msg);
}
