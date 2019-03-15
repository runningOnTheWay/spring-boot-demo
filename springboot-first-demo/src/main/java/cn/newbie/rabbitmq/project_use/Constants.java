package cn.newbie.rabbitmq.project_use;

public class Constants {

	/** x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称*/
	public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

	/** x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称*/
	public static final String DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

	/** 消息分隔符 **/
	public static final String KEY_SEPARATOR = " ";

	/** 线程数 **/
	public final static int THREAD_COUNT = 5;

	/** 最大线程数 **/
	public final static int MAX_THREAD_COUNT = 10;

	public final static int THREAD_COUNT_SINGLE = 1;

	/** 处理间隔时间 **/
	/** mils **/
	public final static int INTERVAL_MILS = 0;

	/** consumer失败后等待时间(mils) **/
	public static final int ONE_SECOND = 1 * 1000;

	/** 异常sleep时间(mils)，从1分钟改为10秒 **/
	public static final int ONE_MINUTE = 1 * 10 * 1000;

	/** MQ消息retry时间 **/
	public static final int RETRY_TIME_INTERVAL = ONE_MINUTE;

	/** MQ消息有效时间 **/
	public static final int VALID_TIME = ONE_MINUTE;

	/** 重试次数 **/
	public static final int RETRYTIMES = 3;

	/** 线程池阻塞队列容量上线  */
	public static final Integer BLOCKING_QUEUE_NUMBER = 1000;

	/** MQ线程池名称 */
	public static final String MQ_THREADPOOL_NAME = "MQ-Executor";

	/** 定时器线程池名称 */
	public static final String SCHEDULE_THREADPOOL_NAME = "SCHEDULE-Executor";
}
