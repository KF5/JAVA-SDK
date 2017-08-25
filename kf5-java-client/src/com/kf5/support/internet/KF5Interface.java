package com.kf5.support.internet;

import java.net.URLEncoder;
import java.util.Map;

public class KF5Interface {

	private static final String PAGE = "page";

	private static final String PER_PAGE = "per_page";

	private final static String SERVER = "https://%1$s";

	/**
	 * 工单（客服）相关接口
	 */
	// 工单列表
	private final static String AGENT_ORDER_LIST = SERVER + "/apiv2/tickets.json";
	// 指定客服受理的工单列表
	private final static String AGENT_ORDER_LIST_WITH_ID = SERVER + "/apiv2/users/%2$s/tickets.json";
	// 查看工单
	private final static String AGENT_ORDER_DETAILS = SERVER + "/apiv2/tickets/%2$s.json";
	// 查看多个工单，最多返回100条数据
	private final static String AGENT_MANY_ORDER = SERVER + "/apiv2/tickets/show_many.json?ids=%2$s";
	// 创建工单
	private final static String AGENT_CREATE_ORDER = SERVER + "/apiv2/tickets.json";
	// 更新工单
	private final static String AGENT_UPDATE_ORDER = SERVER + "/apiv2/tickets/%2$s.json";
	// 更新多个工单
	private final static String AGENT_UPDATE_MANY_ORDERS = SERVER + "/apiv2/tickets/update_many.json?ids=";
	// 删除工单
	private final static String AGENT_DELETE_ORDER = SERVER + "/apiv2/tickets/%2$s.json";
	// 删除多个工单
	private final static String AGENT_DELETE_MANY_ORDERS = SERVER + "/apiv2/tickets/delete_many.json?ids=";
	// 工单被关联的事务列表
	private final static String AGENT_ORDER_INCIDENTS_LIST = SERVER + "/apiv2/tickets/%2$s/incidents.json";
	// 故障类型的工单列表
	private final static String AGENT_ORDER_PROBLEM_LIST = SERVER + "/apiv2/tickets/problems.json";
	// 工单可用的副本用户
	private final static String AGENT_ORDER_COLLABORATORS = SERVER + "/apiv2/tickets/%2$s/collaborators.json";

	/**
	 * 工单（普通用户）相关接口
	 */

	// 工单请求列表
	private final static String REQUEST_ORDER_LIST = SERVER + "/apiv2/requests.json";
	// 状态小于已解决的工单
	private final static String REQUEST_ORDER_STATUS_OPEN = SERVER + "/apiv2/requests/open.json";
	// 状态为已解决和已关闭的工单
	private final static String REQUEST_ORDER_STATUS_SOLVED = SERVER + "/apiv2/requests/solved.json";
	// 获取指定用户的工单请求
	private final static String REQUEST_ORDER_LIST_WITH_ID = SERVER + "/apiv2/users/%2$s/requests.json";
	// 获取指定公司组织的工单请求
	private final static String ORGANZIATION_ORDER_WITH_ID = SERVER + "/apiv2/organizations/%2$s/requests.json";
	// 搜索工单请求
	private final static String SERCH_ORDER = SERVER + "/apiv2/requests/search.json?%2$s";
	// 查看工单请求
	private final static String REQUEST_VIEW_ORDER = SERVER + "/apiv2/requests/%2$s.json";
	// 创建工单请求
	private final static String REQUEST_CREATE_ORDER = SERVER + "/apiv2/requests.json";
	// 回复工单
	private final static String REQUESTER_REPLY_ORDER = SERVER + "/apiv2/requests/%2$s.json";
	// 工单回复列表
	private final static String REQUESTER_COMMENT_LIST = SERVER + "/apiv2/requests/%2$s/comments.json";
	// 查看指定工单回复
	private final static String REQUESTER_COMMENT_WITH_ID = SERVER + "/apiv2/requests/%2$s/comments/%3$s.json";

	/**
	 * 工单回复接口
	 */
	// 工单回复列表
	private final static String ORDER_COMMENT_LIST = SERVER + "/apiv2/tickets/%2$s/comments.json";

	/**
	 * 工单自定义字段接口
	 */

	// 工单自定义字段列表
	private final static String TICKET_FIELD_LIST = SERVER + "/apiv2/ticket_fields.json";
	// 获取状态为启动的自定义字段列表
	private final static String TICKET_FIELD_LIST_ACTIVE = SERVER + "/apiv2/ticket_fields/active.json";
	// 查看自定义字段
	private final static String TICKET_FIELD_LIST_BY_ID = SERVER + "/apiv2/ticket_fields/%2$s.json";
	// 删除自定义字段
	private final static String DELETE_TICKET_FIELD = SERVER + "/apiv2/ticket_fields/%2$s.json";

	/**
	 * 工单查看分类接口
	 */

	// 工单查看分类列表
	private final static String VIEWS_ORDER_TYPE_LIST = SERVER + "/apiv2/views.json";
	// 获取可用的工单查看分类
	private final static String VIEWS_ORDER_TYPE_ACTIVE = SERVER + "/apiv2/views/active.json";
	// 获取指定查看分类
	private final static String VIEW_ORDER_LIST_WITH_ID = SERVER + "/apiv2/views/%2$s.json";
	// 获取指定查看分类里的工单
	private final static String VIEW_TICKET_BY_ID = SERVER + "/apiv2/views/%2$s/tickets.json";
	// 获取指定查看分类的工单个数
	private final static String VIEW_TICKET_COUNT = SERVER + "/apiv2/views/%2$s/count.json";
	// 获取多个查看分类的工单个数
	private final static String VIEW_MANY_TICKET_COUNT = SERVER + "/apiv2/views/count_many.json?ids=";

	/**
	 * 用户接口
	 */
	// 获取用户列表
	private final static String USER_LIST = SERVER + "/apiv2/users.json";
	// 查看指定用户信息
	private final static String USER_INFO = SERVER + "/apiv2/users/%2$s.json";
	// 查看自己的信息
	private final static String INFO_OF_MINE = SERVER + "/apiv2/users/me.json";
	// 获取多个用户信息
	private final static String INFO_OF_MANY = SERVER + "/apiv2/users/show_many.json?ids=";
	// 创建用户信息
	private final static String CREATE_USER_INFO = SERVER + "/apiv2/users.json";
	// 合并用户
	private final static String MERGE_USER = SERVER + "/apiv2/users/%2$s/merge.json";
	// 修改用户信息
	private final static String UPDATE_USER_INFO = SERVER + "/apiv2/users/%2$s.json";
	// 删除用户
	private final static String DELETE_USER = SERVER + "/apiv2/users/%2$s.json";
	// 搜索用户
	private final static String SEARCH_USER = SERVER + "/apiv2/users/search.json?query=%2$s";

	/**
	 * 用户自定义字段接口
	 */

	// 用户自定义字段列表
	private final static String USER_FIELDS = SERVER + "/apiv2/user_fields.json";
	// 获取状态为启动的自定义的字段列表
	private final static String USER_FIELDS_ACTIVE = SERVER + "/apiv2/user_fields/active.json";
	// 查看用户自定义字段
	private final static String USER_FIELDS_BY_ID = SERVER + "/apiv2/user_fields/%2$s.json";
	// 删除用户自定义字段
	private final static String DELETE_USER_FIELDS = SERVER + "/apiv2/user_fields/%2$s.json";

	/**
	 * 客服组
	 */

	// 客服组列表
	private final static String GROUP_LIST = SERVER + "/apiv2/groups.json";
	// 查看客服组
	private final static String GROUP_LIST_BY_ID = SERVER + "/apiv2/groups/%2$s.json";
	// 创建客服组
	private final static String CREATE_GROUP = SERVER + "/apiv2/groups.json";
	// 修改客服组
	private final static String UPDATE_GROUP = SERVER + "/apiv2/groups/%2$s.json";
	// 删除客服组
	private final static String DELETE_GROUP = SERVER + "/apiv2/groups/%2$s.json";

	/**
	 * 公司组织接口
	 */
	// 公司组织列表
	private final static String ORGANIZATION_LIST = SERVER + "/apiv2/organizations.json";
	// 查看公司组织
	private final static String VIEW_ORGANIZATION = SERVER + "/apiv2/organizations/%2$s.json";
	// 创建公司组织
	private final static String CREATE_ORGANIZATION = SERVER + "/apiv2/organizations.json";
	// 修改公司组织
	private final static String UPDATE_ORGANIZATION = SERVER + "/apiv2/organizations/%2$s.json";
	// 删除公司组织
	private final static String DELETE_ORGANIZATION = SERVER + "/apiv2/organizations/%2$s.json";

	/**
	 * 文档分区接口
	 */
	// 文档分区列表
	private final static String CATEGORIES_LIST = SERVER + "/apiv2/categories.json";
	// 查看文档分区
	private final static String CATEGORIES_LIST_WITH_ID = SERVER + "/apiv2/categories/%2$s.json";
	// 创建文档分区
	private final static String CREATE_CATEGORY = SERVER + "/apiv2/categories.json";
	// 修改文档分区
	private final static String UPDATE_CATEGORY = SERVER + "/apiv2/categories/%2$s.json";
	// 删除文档分区
	private final static String DELETE_CATEGORY = SERVER + "/apiv2/categories/%2$s.json";

	/**
	 * 文档分类接口
	 */

	// 文档分类列表
	private final static String FORUMS_LIST = SERVER + "/apiv2/forums.json";
	// 查看文档分类
	private final static String FORUMS_LIST_BY_ID = SERVER + "/apiv2/forums/%2$s.json";
	// 创建文档分类
	private final static String CREATE_FORUM = SERVER + "/apiv2/forums.json";
	// 修改文档分类
	private final static String UPDATE_FORUM = SERVER + "/apiv2/forums/%2$s.json";
	// 删除文档分类
	private final static String DELETE_FORUM = SERVER + "/apiv2/forums/%2$s.json";

	/**
	 * 文档接口
	 */
	// 文档列表
	private final static String POST_LIST = SERVER + "/apiv2/posts.json";
	// 查看文档
	private final static String POST_DETAIL = SERVER + "/apiv2/posts/%2$s.json";
	// 查看多个文档
	private final static String POST_MANY = SERVER + "/apiv2/posts/show_many.json?ids=";
	// 搜索文档
	private final static String SEARCH_POST = SERVER + "/apiv2/posts/search.json?query=%2$s";
	// 创建文档
	private final static String CREATE_POST = SERVER + "/apiv2/posts.json";
	// 修改文档
	private final static String UPDATE_POST = SERVER + "/apiv2/posts/%2$s.json";
	// 删除文档
	private final static String DELETE_POST = SERVER + "/apiv2/posts/%2$s.json";
	// 文档回复列表
	private final static String POST_COMMENT_LIST = SERVER + "/apiv2/posts/%2$s/comments.json";
	// 查看指定文档回复
	private final static String POST_COMMETN_BY_ID = SERVER + "/apiv2/posts/%2$s/comments/%3$s.json";
	// 回复文档
	private final static String POST_REPLY = SERVER + "/apiv2/posts/%2$s/comments.json";

	/**
	 * 社区话题接口
	 */

	// 社区话题列表
	private final static String TOPIC_LIST = SERVER + "/apiv2/topics.json";
	// 查看社区话题
	private final static String TOPIC_BY_ID = SERVER + "/apiv2/topics/%2$s.json";
	// 创建社区话题
	private final static String TOPIC_CREATE = SERVER + "/apiv2/topics.json";
	// 修改社区话题
	private final static String TOPIC_UPDATE = SERVER + "/apiv2/topics/%2$s.json";
	// 删除社区话题
	private final static String TOPIC_DELETE = SERVER + "/apiv2/topics/%2$s.json";

	/**
	 * 社区问题接口
	 */
	// 社区问题列表
	private final static String QUESTION_LIST = SERVER + "/apiv2/questions.json";
	// 查看社区问题
	private final static String QUESTION_BY_ID = SERVER + "/apiv2/questions/%2$s.json";
	// 创建社区问题
	private final static String QUESTION_CREATE = SERVER + "/apiv2/questions.json";
	// 修改社区问题
	private final static String QUESTION_UPDATE = SERVER + "/apiv2/questions/%2$s.json";
	// 删除社区问题
	private final static String QUESTION_DELETE = SERVER + "/apiv2/questions/%2$s.json";
	// 社区问题回复列表
	private final static String QUESTION_COMMENT_LIST = SERVER + "/apiv2/questions/%2$s/comments.json";
	// 查看指定社区问题回复
	private final static String QUESTION_COMMENT_BY_ID = SERVER + "/apiv2/questions/%2$s/comments/%3$s.json";
	// 回复社区问题
	private final static String QUESTION_REPLY = SERVER + "/apiv2/questions/%2$s/comments.json";

	/**
	 * 附件接口
	 */

	// 上传附件
	private final static String ATTACHMENTS_UPLOAD = SERVER + "/apiv2/attachments.json?filename=%2$s";
	// 查看附件
	private final static String ATTACHMENT_VIEW = SERVER + "/apiv2/attachments/%2$s.json";
	// 删除附件
	private final static String ATTACHMENT_DELETE = SERVER + "/apiv2/attachments/%2$s.json";

	/**
	 * 导入接口
	 */

	// 工单导入
	private final static String ORDER_IMPORT = SERVER + "/apiv2/imports/tickets.json";

	/**
	 * 导出接口
	 */

	private final static String ORDER_EXPORT = SERVER + "/apiv2/exports/tickets.json";

	/**
	 * KChat在线客服
	 */
	// 获取对话列表
	private final static String CHAT_LIST = SERVER + "/apiv2/chats.json";

	private final static String CHAT_DETAIL_BY_ID = SERVER + "/apiv2/chats/%2$s.json";

	/**
	 * KChat机器人题库
	 */

	// 获取机器人问题列表
	private static final String ROBOT_QUESTION_LIST = SERVER + "/apiv2/robot/questions.json";

	// 创建问题
	private static final String CREATE_AI_QUESTION = SERVER + "/apiv2/robot/questions.json";

	// 修改问题
	private static final String UPDATE_QUESTION_BY_ID = SERVER + "/apiv2/robot/questions/%2$s.json";

	// 删除问题
	private static final String DELETE_QUESTION_BY_ID = SERVER + "/apiv2/robot/questions.json";

	// 分组列表
	private static final String QUESTION_CATEGORIES_LIST = SERVER + "/apiv2/robot/question_categories.json";

	// 创建分组
	private static final String CREATE_QUESTION_CATEGORIES = SERVER + "/apiv2/robot/question_categories.json";

	// 修改分组
	private static final String UPDATE_QUESTION_CATEGORIES = SERVER + "/apiv2/robot/question_categories/%2$s.json";

	// 删除分组
	private static final String DELETE_QUESTION_CATEGORIES = SERVER + "/apiv2/robot/question_categories.json";

	/*
	 * ###########################################2017-8-21新增API################
	 * ###########################
	 */

	/**
	 * 工单（客服）
	 */
	// 搜索工单
	private final static String AGENT_SEARCH_TICKET = SERVER + "/apiv2/tickets/search.json";

	/**
	 * 触发器相关接口
	 */

	// 获取触发器列表
	private final static String TRIGGER_LIST = SERVER + "/apiv2/triggers.json";

	// 查看指定ID的触发器
	private static final String GET_TRIGGER_BY_ID = SERVER + "/apiv2/triggers/%2$s.json";

	// 查看启用的触发器列表
	private static final String GET_ACTIVE_TRIGGER_LIST = SERVER + "/apiv2/triggers/active.json";

	/**
	 * 自动化任务
	 */

	// 获取自动化任务列表
	private static final String AUTOMATION_LIST = SERVER + "/apiv2/automations.json";

	// 查看指定ID的自动化任务
	private static final String GET_AUTOMATION_BY_ID = SERVER + "/apiv2/automations/%2$s.json";

	// 查看启用的自动化任务列表
	private static final String GET_ACTIVE_AUTOMATION_LIST = SERVER + "/apiv2/automations/active.json";

	/**
	 * IM历史对话
	 */

	// 对话列表
	private static final String HISTORY_CHAT_LIST = SERVER + "/apiv2/kchat/history.json";

	// 查看对话
	private static final String HISTORY_CHAT_BY_ID = SERVER + "/apiv2/kchat/history/%2$s.json";

	// 客服登录状态日志列表
	private static final String AGENT_LOGIN_LOG = SERVER + "/apiv2/kchat/chats/AgentLog.json";

	/**
	 * 机器人题库标签
	 */

	// 获取标签列表
	private static final String AI_TAG_LIST = SERVER + "/apiv2/robot/tags.json";

	// 创建标签
	private static final String CREATE_AI_TAG = AI_TAG_LIST;

	// 修改标签
	private static final String UPDATE_AI_TAG = SERVER + "/apiv2/robot/tags/%2$s.json";

	// 删除标签
	private static final String DELETE_AI_TAG = SERVER + "/apiv2/robot/tags/%2$s.json";

	/**
	 * IM监控
	 */

	// 坐席状态监控列表
	private static final String AGNET_STATUS_LIST = SERVER + "/apiv2/kchat/monitor/agents.json";

	// 正在对话监控列表
	private static final String MONITOR_CHAT_STATUS = SERVER + "/apiv2/kchat/monitor/chats.json";

	// 客服排队监控列表
	private static final String MONITOR_VISITOR_QUEUE_LIST = SERVER + "/apiv2/kchat/monitor/visitors.json";

	/**
	 * 对话统计
	 */

	// 客服工作量统计
	private static final String AGENT_WORK_STATUS = SERVER + "/apiv2/kchat/stats/agentworkstats.json";

	// 客服对话量统计
	private static final String AGENT_CONVERSATION = SERVER + "/apiv2/kchat/stats/conversationstats.json";

	// 客服状态时长统计
	private static final String AGENT_STATUS_TIME = SERVER + "/apiv2/kchat/stats/StateStats.json";

	// 对话来源统计
	private static final String CHAT_SOURCE = SERVER + "/apiv2/kchat/stats/sourcestats.json";

	/**
	 * 管理功能
	 */
	// 更新客服在线状态
	private static final String UPDATE_AGNET_STATUS = SERVER + "/apiv2/kchat/agent/availabilities.json";

	/**
	 * 电话呼叫中心API
	 */

	// 通话明细列表
	private static final String VOICE_HISTORY_LIST = SERVER + "/apiv2/voice/histories.json";

	// 查看通话明细
	private static final String VOICE_DETAIL = SERVER + "/apiv2/voice/histories/%2$s.json";

	/**
	 * 呼叫中心高级接口
	 */
	private static final String VOICE_ACCOUNT_LIST = SERVER + "/apiv2/voice/agents.json";

	// 客服语音账号
	private static final String VOICE_ACCOUNT_BY_ID = SERVER + "/apiv2/voice/agents/%2$s.json";

	// 更新客服语音账号
	private static final String UPDATE_VOICE_ACCOUNT = VOICE_ACCOUNT_BY_ID;

	// 客服登录明细列表
	private static final String VOICE_AGENT_LOGIN_STATE = SERVER + "/apiv2/voice/agent_state_logs.json";

	// 未接通呼入明细列表
	private static final String VOICE_CALL_UN_ANSWERED_LIST = SERVER + "/apiv2/voice/unanswereds.json";

	// 呼出服务量
	private static final String AGENT_OUTBOUND_STATE_LIST = SERVER + "/apiv2/voice/agent_outbound_stats.json";

	// 呼入服务量
	private static final String AGENT_INBOUNT_STATE_LIST = SERVER + "/apiv2/voice/agent_inbound_stats.json";

	// 客服工作量
	private static final String AGENT_VOICE_PERFORMANCE = SERVER + "/apiv2/voice/agent_performance_stats.json";

	// 客服状态时长
	private static final String AGENT_STATE_TIME = SERVER + "/apiv2/voice/agent_state_stats.json";

	// 分时段呼入量
	private static final String AGENT_SUBSECTION_INBOUND = SERVER + "/apiv2/voice/inbound_stats.json";

	// 分时段呼出量
	private static final String AGENT_SUBSECTION_OUTBOUND = SERVER + "/apiv2/voice/outbound_stats.json";

	// 通话队列
	private static final String VOICE_QUEUE_CALL = SERVER + "/apiv2/voice/queue_calls.json";

	// 客服状态列表
	private static final String VOICE_AGENT_STATUS = SERVER + "/apiv2/voice/availabilities.json";

	// 查看客服状态
	private static final String GET_AGENT_VOICE_STATUS = SERVER + "/apiv2/voice/availabilities/%2$s.json";

	/**
	 * 电话功能API
	 */

	// 客服在线
	private static final String AGENT_VOICE_ONLINE = SERVER + "/voice/online";

	//客服忙碌
	private static final String AGENT_VOICE_BUSY = SERVER+"/voice/busy";
	
	//客服小休
	private static final String AGENT_VOICE_BREAK = SERVER+"/voice/break";
	
	//客服离线
	private static final String AGENT_VOICE_OFFLINE = SERVER+"/voice/offline";
	
	
	// 操作日志列表
	private static final String SYSTEM_LOG = SERVER + "/apiv2/system_log.json";
	
	
	/**
	 * 自定义IM消息来源
	 */
	
	private static final String GET_IM_AGENT_LIST = "https://webapi.kf5.com/kchat/message";
	
	
	//自定义IM上传附件
	private static final String CUSTOM_IM_UPLOAD_ATTACHMENT = "https://webapi.kf5.com/kchat/upload";
	
	/**
	 * 创建机器人题库问题 调用权限：admin
	 * 
	 * POST请求
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createAIQuestion(String domain) {
		return String.format(CREATE_AI_QUESTION, domain);
	}

	/**
	 * 修改机器人题库中的问题 调用权限：admin PUT请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            问题id
	 * @return
	 */
	public static String updateQuestionByID(String domain, int id) {

		return String.format(UPDATE_QUESTION_BY_ID, domain, id);
	}

	/**
	 * 删除问题 调用权限 ：admin DELETE请求
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String deleteQuestionById(String domain) {

		return String.format(DELETE_QUESTION_BY_ID, domain);

	}

	/**
	 * 获取机器人题库分组列表 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getQuestionCategoriesList(String domain, String query) {

		return String.format(QUESTION_CATEGORIES_LIST, domain) + getQueryData(query);
	}

	/**
	 * 创建机器人题库分组 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createQuestionCategories(String domain) {

		return String.format(CREATE_QUESTION_CATEGORIES, domain);
	}

	/**
	 * 修改机器人题库分组 调用权限：admin PUT请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            分组id
	 * @return
	 */
	public static String updateQuestionCategories(String domain, int id) {

		return String.format(UPDATE_QUESTION_CATEGORIES, domain, id);

	}

	/**
	 * 删除机器人题库分组 调用权限：admin DELETE请求
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String deleteQuestionCategories(String domain) {

		return String.format(DELETE_QUESTION_CATEGORIES, domain);

	}

	/**
	 * 获取机器人问题列表 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param query
	 *            筛选参数
	 * @return
	 */
	public static String getAIQuestionList(String domain, String query) {

		return String.format(ROBOT_QUESTION_LIST, domain) + getQueryData(query);

	}

	/**
	 * 获取对话列表 GET请求 调用权限：Agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param query
	 */
	public static String getChatList(String domain, String query) {

		return String.format(CHAT_LIST, domain) + getQueryData(query);
	}

	/**
	 * 查看对话
	 * 
	 * @param domain
	 *            平台地址
	 * @param chat_id
	 *            对话id
	 * @return
	 */
	public static String getChatDetailByID(String domain, int chat_id) {

		return String.format(CHAT_DETAIL_BY_ID, domain, chat_id);

	}

	/**
	 * 
	 * 工单可用的副本用户 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            工单id
	 * @return
	 */
	public static String getAgentOrderCollaborators(String domain, String id) {

		return String.format(AGENT_ORDER_COLLABORATORS, domain, id);
	}

	/**
	 * 导出工单 GET请求 调用权限：admin 请求参数：start_time:设定请求导出的工单创建时间的开始点(时间戳)
	 * end_time:设定请求导出的工单创建时间的结束点(时间戳) order：ID排序 'ASC' or 'DESC' 每页最多返回500条数据
	 * 注意：若不设置start_time，默认导出end_time之前创建的工单；
	 * 若不设置end_time，默认导出从start_time至当前时间内创建的工单; 若不设置order，默认导出工单按ID正序排列。 url示例：
	 * https://{subdomain}.kf5.com/apiv2/exports/tickets.json?start_time=
	 * 1425698858
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String orderExport(String domain, String query) {
		return String.format(ORDER_EXPORT, domain) + getQueryData(query);
	}

	/**
	 * 导入工单 POST请求 调用权限：admin 导入接收数据为单个工单数据，批量导入时请循环调用接口。如果在导入时出错，可以方便处理出错数据
	 * 工单在导入时，触发器等系统规则对该条工单不生效 导入时允许设置工单的created_at,updated_at等时间字段
	 * 允许设置工单回复comments的创建时间created_at, 注意comments数据必须包含author_id,content字段值
	 * 请在导入前确认工单及回复所涉及的用户全部存在于云客服平台里，如果没有请调用 用户接口 Users API 进行创建
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String importOrder(String domain) {

		return String.format(ORDER_IMPORT, domain);
	}

	/**
	 * 删除附件 DELETE请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            附件id
	 * @return
	 */
	public static String deleteAttachment(String domain, String id) {
		return String.format(ATTACHMENT_DELETE, domain, id);
	}

	/**
	 * 查看附件 调用权限：agent GET请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            附件id
	 * @return
	 */
	public static String viewAttachment(String domain, String id) {

		return String.format(ATTACHMENT_VIEW, domain, id);
	}

	/**
	 * 上传附件 POST请求
	 * 注意：需要在url里添加filename参数来设置附件文件名（如：/apiv2/attachments.json?filename=test.
	 * jpg） 同一个附件只能对应一个工单或一个工单回复或一个文档 请求header里需要设置
	 * "Content-Type: application/binary"
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String uploadAttachment(String domain, String filename) {

		return String.format(ATTACHMENTS_UPLOAD, domain, filename);
	}

	/**
	 * 回复社区问题 PUT请求 调用权限：end user
	 * 
	 * @param domain
	 *            平台地址
	 * @param question_id
	 *            问题id
	 * @return
	 */
	public static String replyQuestion(String domain, String question_id) {
		return String.format(QUESTION_REPLY, domain, question_id);
	}

	/**
	 * 查看指定社区问题回复 GET请求 调用权限：end user
	 * 
	 * @param domain
	 *            平台地址
	 * @param question_id
	 *            问题id
	 * @param id
	 *            回复id
	 * @return
	 */
	public static String getQuestionCommentByID(String domain, String question_id, String id) {
		return String.format(QUESTION_COMMENT_BY_ID, domain, question_id, id);
	}

	/**
	 * 社区问题回复列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param question_id
	 *            问题id
	 * @return
	 */
	public static String getQuestionCommentList(String domain, String question_id, String query) {

		return String.format(QUESTION_COMMENT_LIST, domain, question_id) + getQueryData(query);

	}

	/**
	 * 删除社区问题 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 * @param question_id
	 * @return
	 */
	public static String deleteQuestion(String domain, String question_id) {

		return String.format(QUESTION_DELETE, domain, question_id);
	}

	/**
	 * 修改社区问题 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 * @param question_id
	 * @return
	 */
	public static String updateQuestion(String domain, String question_id) {

		return String.format(QUESTION_UPDATE, domain, question_id);
	}

	/**
	 * 创建社区问题 POST请求 调用权限：all
	 * 
	 * @param domain
	 * @return
	 */
	public static String createQuestion(String domain) {

		return String.format(QUESTION_CREATE, domain);
	}

	/**
	 * 查看社区问题 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param question_id
	 *            问题id
	 * @return
	 */
	public static String getQuestionByID(String domain, String question_id) {
		return String.format(QUESTION_BY_ID, domain, question_id);
	}

	/**
	 * 社区问题列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 * @return
	 */
	public static String getQuestionList(String domain, String query) {

		return String.format(QUESTION_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除社区话题 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param topic_id
	 *            话题id
	 * @return
	 */
	public static String deleteTopic(String domain, String topic_id) {
		return String.format(TOPIC_DELETE, domain, topic_id);
	}

	/**
	 * 修改社区话题 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param topic_id
	 *            话题id
	 * @return
	 */
	public static String updateTopic(String domain, String topic_id) {
		return String.format(TOPIC_UPDATE, domain, topic_id);
	}

	/**
	 * 创建社区话题 POST请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createTopic(String domain) {

		return String.format(TOPIC_CREATE, domain);

	}

	/**
	 * 查看社区话题 GET请求 调用权限：all
	 * 
	 * @param domain
	 * @param topic_id
	 * @return
	 */
	public static String getTopicByID(String domain, String topic_id) {

		return String.format(TOPIC_BY_ID, domain, topic_id);
	}

	/**
	 * 社区话题列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getTopicList(String domain, String query) {
		return String.format(TOPIC_LIST, domain) + getQueryData(query);
	}

	/**
	 * 回复文档 POST请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param post_id
	 *            文档id
	 * @return
	 */
	public static String postReply(String domain, String post_id) {

		return String.format(POST_REPLY, domain, post_id);
	}

	/**
	 * 查看指定文档回复 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param post_id
	 *            文档id
	 * @param id
	 *            回复id
	 * @return
	 */
	public static String getPostCommentByID(String domain, String post_id, String id) {

		return String.format(POST_COMMETN_BY_ID, domain, post_id, id);
	}

	/**
	 * 文档回复列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param post_id
	 *            文档id
	 * @return
	 */
	public static String getPostCommentList(String domain, String post_id, String query) {

		return String.format(POST_COMMENT_LIST, domain, post_id) + getQueryData(query);
	}

	/**
	 * 删除文档 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param post_id
	 *            文档id
	 * @return
	 */
	public static String deletePost(String domain, String post_id) {
		return String.format(DELETE_POST, domain, post_id);
	}

	/**
	 * 修改文档 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param post_id
	 *            文档id
	 * @return
	 */
	public static String updatePost(String domain, String post_id) {

		return String.format(UPDATE_POST, domain, post_id);
	}

	/**
	 * 创建文档 POST请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createPost(String domain) {
		return String.format(CREATE_POST, domain);
	}

	/**
	 * 搜索文档 GET请求 调用权限：all
	 * 
	 * @param domain平台地址
	 * @param key_word
	 *            搜索关键字
	 * @return
	 */
	public static String searchPost(String domain, String key_word, int page, int per_page) {
		StringBuilder stringBuilder = new StringBuilder();
		if (page > 0) {
			stringBuilder.append("&");
			stringBuilder.append(PAGE).append("=").append(page);
		}
		if (per_page > 0) {
			stringBuilder.append("&");
			stringBuilder.append(PER_PAGE).append("=").append(per_page);
		}
		return String.format(SEARCH_POST, domain, key_word) + stringBuilder.toString();
	}

	/**
	 * 查看多个文档 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param posts_id
	 *            多个文档id;格式为：1,2,3
	 * @return
	 */
	public static String getManyPosts(String domain, String posts_id) {

		return String.format(POST_MANY, domain) + posts_id;
	}

	/**
	 * 查看文档 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param post_id
	 *            文档id
	 * @return
	 */
	public static String getPostDetail(String domain, String post_id) {
		return String.format(POST_DETAIL, domain, post_id);
	}

	/**
	 * 获取文档列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getPostList(String domain, String query) {
		return String.format(POST_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除文档分类 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 * @param forum_id
	 * @return
	 */
	public static String deleteForum(String domain, String forum_id) {
		return String.format(DELETE_FORUM, domain, forum_id);
	}

	/**
	 * 修改文档分类 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param forum_id
	 *            文档分类id
	 * @return
	 */
	public static String updateForum(String domain, String forum_id) {

		return String.format(UPDATE_FORUM, domain, forum_id);
	}

	/**
	 * 创建文档分类 POST请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createForum(String domain) {

		return String.format(CREATE_FORUM, domain);
	}

	/**
	 * 查看文档分类 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param forum_id
	 *            文档分类id
	 * @return
	 */
	public static String getForumByID(String domain, String forum_id) {
		return String.format(FORUMS_LIST_BY_ID, domain, forum_id);
	}

	/**
	 * 获取文档分区列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 * @return
	 */
	public static String getForumList(String domain, String query) {
		return String.format(FORUMS_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除文档分区 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param category_id
	 *            文档分区id
	 * @return
	 */
	public static String deleteCategory(String domain, String category_id) {
		return String.format(DELETE_CATEGORY, domain, category_id);
	}

	/**
	 * 修改文档分区 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param category_id
	 *            文档分区id
	 * @return
	 */
	public static String updateCategory(String domain, String category_id) {

		return String.format(UPDATE_CATEGORY, domain, category_id);
	}

	/**
	 * 创建文档分区 POST请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createCategory(String domain) {
		return String.format(CREATE_CATEGORY, domain);
	}

	/**
	 * 查看文档分区 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @param category_id
	 *            分区id
	 * @return
	 */
	public static String getCategoryByID(String domain, String category_id) {
		return String.format(CATEGORIES_LIST_WITH_ID, domain, category_id);
	}

	/**
	 * 获取文档分区列表 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getCategoriesList(String domain, String query) {
		return String.format(CATEGORIES_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除公司组织 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param organization_id
	 *            公司组织id
	 * @return
	 */
	public static String deleteOrganization(String domain, String organization_id) {

		return String.format(DELETE_ORGANIZATION, domain, organization_id);

	}

	/**
	 * 修改公司组织 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param organization_id
	 *            公司组织id
	 * @return
	 */
	public static String updateOrganization(String domain, String organization_id) {

		return String.format(UPDATE_ORGANIZATION, domain, organization_id);
	}

	/**
	 * 创建公司组织 POST请求方式 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createOrganization(String domain) {

		return String.format(CREATE_ORGANIZATION, domain);

	}

	/**
	 * 查看公司组织 GET请求 调用权限：agents
	 * 
	 * @param domain
	 *            平台地址
	 * @param organization_id
	 *            公司组织id
	 * @return
	 */
	public static String getOrganizationByID(String domain, String organization_id) {

		return String.format(VIEW_ORGANIZATION, domain, organization_id);

	}

	/**
	 * 公司组织列表 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getOrganizationList(String domain, String query) {
		return String.format(ORGANIZATION_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除客服组 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param group_id
	 *            客服组id
	 * @return
	 */
	public static String deleteGroup(String domain, String group_id) {

		return String.format(DELETE_GROUP, domain, group_id);

	}

	/**
	 * 修改客服组 PUT请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param group_id
	 *            客服组id
	 * @return
	 */
	public static String updateGroup(String domain, String group_id) {

		return String.format(UPDATE_GROUP, domain, group_id);

	}

	/**
	 * 创建客服组 POST请求 调用权限：admin
	 * 
	 * @param domain
	 * @return
	 */
	public static String createGroup(String domain) {
		return String.format(CREATE_GROUP, domain);
	}

	/**
	 * 查看客服组 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param group_id
	 *            客服组id
	 * @return
	 */
	public static String getGroupListByID(String domain, String group_id) {

		return String.format(GROUP_LIST_BY_ID, domain, group_id);

	}

	/**
	 * 客服组列表 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getGroupList(String domain, String query) {
		return String.format(GROUP_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除用户自定义字段 DELETE字段 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            字段id
	 * @return
	 */
	public static String deleteUserField(String domain, String id) {

		return String.format(DELETE_USER_FIELDS, domain, id);
	}

	/**
	 * 查看用户自定义字段 GET请求 调用权限：agents
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            字段id
	 * @return
	 */
	public static String getUserFieldListByID(String domain, String id) {

		return String.format(USER_FIELDS_BY_ID, domain, id);
	}

	/**
	 * 获取状态为启用的自定义字段列表 GET请求 调用权限：agents
	 * 
	 * @param domain
	 * @return
	 */
	public static String getUserFieldActiveList(String domain, String query) {

		return String.format(USER_FIELDS_ACTIVE, domain) + getQueryData(query);
	}

	/**
	 * 获取自定义字段列表 GET请求 调用权限：agents
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getUserFieldList(String domain, String query) {

		return String.format(USER_FIELDS, domain) + getQueryData(query);
	}

	/**
	 * 搜索用户 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String searchUser(String domain, String keys, int page, int per_page) {

		StringBuilder stringBuilder = new StringBuilder();
		if (page > 0) {
			stringBuilder.append("&");
			stringBuilder.append(PAGE).append("=").append(page);
		}
		if (per_page > 0) {
			stringBuilder.append("&");
			stringBuilder.append(PER_PAGE).append("=").append(per_page);
		}
		return String.format(SEARCH_USER, domain, keys) + stringBuilder.toString();
	}

	/**
	 * 删除用户 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public static String deleteUser(String domain, String user_id) {
		return String.format(DELETE_USER, domain, user_id);
	}

	/**
	 * 修改用户信息 PUT请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public static String updateUserInfo(String domain, String user_id) {
		return String.format(UPDATE_USER_INFO, domain, user_id);
	}

	/**
	 * 合并用户 PUT请求 调用权限：admin 注：URL里指定id的用户，将会被合并到传递参数中id所代表的用户。
	 * 前者的数据也会合并为后者的数据，之后前者将会被删除。 被合并的用户，只能是普通用户角色。
	 * 
	 * @param domain
	 * @param user_id
	 * @return
	 */
	public static String mergeUser(String domain, String user_id) {

		return String.format(MERGE_USER, domain, user_id);
	}

	/**
	 * 创建用户信息 POST请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createUserInfo(String domain) {
		return String.format(CREATE_USER_INFO, domain);
	}

	/**
	 * 获取多个用户信息 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getManyUsersInfo(String domain) {
		return String.format(INFO_OF_MANY, domain);
	}

	/**
	 * 查看自己的信息 GET请求 调用权限：all
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getMyInfo(String domain) {

		return String.format(INFO_OF_MINE, domain);
	}

	/**
	 * 查看指定用户信息 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public static String getUserInfo(String domain, String user_id) {
		return String.format(USER_INFO, domain, user_id);
	}

	/**
	 * 获取用户列表 GET请求 调用权限： agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getUserList(String domain, String query) {

		return String.format(USER_LIST, domain) + getQueryData(query);
	}

	/**
	 * 获取多个查看分类的工单个数 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getManyTicketCountByTypeIds(String domain) {
		return String.format(VIEW_MANY_TICKET_COUNT, domain);
	}

	/**
	 * 获取指定查看分类的工单个数 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param type_id
	 *            分类id
	 * @return
	 */
	public static String getTicketCountByTypeID(String domain, String type_id) {

		return String.format(VIEW_TICKET_COUNT, domain, type_id);
	}

	/**
	 * 获取指定查看分类里的工单 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param type_id
	 *            分类id
	 * @return
	 */
	public static String getTicketListByTypeID(String domain, String type_id, String query) {

		return String.format(VIEW_TICKET_BY_ID, domain, type_id) + getQueryData(query);
	}

	/**
	 * 获取指定查看分类 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 * @return
	 */
	public static String getOrderTypeListByID(String domain, String id) {
		return String.format(VIEW_ORDER_LIST_WITH_ID, domain, id);
	}

	/**
	 * 获取当前客户可用的工单查看分类 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getOrderTypeListActive(String domain, String query) {
		return String.format(VIEWS_ORDER_TYPE_ACTIVE, domain) + getQueryData(query);
	}

	/**
	 * 获取当前客户的工单查看分类 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getOrderTypeList(String domain, String query) {

		return String.format(VIEWS_ORDER_TYPE_LIST, domain) + getQueryData(query);
	}

	/**
	 * 删除自定义字段 DELETE请求 调用权限：admin
	 * 
	 * @param domain
	 * @param ticket_field_id
	 * @return
	 */
	public static String deleteTicketFieldByID(String domain, String ticket_field_id) {

		return String.format(DELETE_TICKET_FIELD, domain, ticket_field_id);
	}

	/**
	 * 查看自定义字段 GET请求 调用权限：agents
	 * 
	 * @param domain
	 *            平台地址
	 * @param ticket_field_id
	 *            自定义字段id
	 * @return
	 */
	public static String getTicketFieldByID(String domain, String ticket_field_id) {

		return String.format(TICKET_FIELD_LIST_BY_ID, domain, ticket_field_id);
	}

	/**
	 * 获取状态为启动的自定义字段列表 GET请求方式 调用权限：agents
	 * 
	 * @param domain
	 * @return
	 */
	public static String getTicketFieldListActive(String domain, String query) {

		return String.format(TICKET_FIELD_LIST_ACTIVE, domain) + getQueryData(query);
	}

	/**
	 * 获取工单自定义字段列表 GET请求 调用权限：agents
	 * 
	 * @param domain
	 * @return
	 */
	public static String getTicketFieldList(String domain, String query) {

		return String.format(TICKET_FIELD_LIST, domain) + getQueryData(query);

	}

	/**
	 * 获取工单回复列表 GET请求 调用权限：客服
	 * 
	 * @param domain
	 *            平台地址
	 * @param query
	 *            筛选条件
	 * @return
	 */
	public static String getOrderCommentList(String domain, String ticket_id, String query) {

		return String.format(ORDER_COMMENT_LIST, domain, ticket_id) + getQueryData(query);
	}

	/**
	 * 查看指定的工单回复 调用权限：普通用户 GET请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param ticket_id
	 *            工单id
	 * @param id
	 *            回复id
	 * @return
	 */
	public static String getOrderCommentWithID(String domain, String ticket_id, String id) {
		return String.format(REQUESTER_COMMENT_WITH_ID, domain, ticket_id, id);
	}

	/**
	 * 获取工单回复列表 GET请求 调用权限：普通用户
	 * 按创建时间排序，可以添加排序参数，sort_order:排序规则，可选值：asc，desc（默认为asc）；
	 * 
	 * @param domain
	 *            平台地址
	 * @param order_id
	 *            工单id
	 * @param query
	 *            筛选条件
	 * @return
	 */
	public static String getCommentListByEndUser(String domain, String order_id, String query) {

		return String.format(REQUESTER_COMMENT_LIST, domain, order_id) + getQueryData(query);
	}

	/**
	 * 回复工单 调用权限： 普通用户 PUT请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param order_id
	 *            工单id
	 * @return
	 */
	public static String replyOrderByEndUser(String domain, String order_id) {

		return String.format(REQUESTER_REPLY_ORDER, domain, order_id);
	}

	/**
	 * 创建工单请求 POST请求 调用权限：普通用户
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createOrderByRequester(String domain) {

		return String.format(REQUEST_CREATE_ORDER, domain);

	}

	/**
	 * 查看工单请求 调用权限：普通用户 GET请求
	 * 
	 * @param domain
	 * @param id
	 * @return
	 */
	public static String getOrderDetailByRequester(String domain, String id) {

		return String.format(REQUEST_VIEW_ORDER, domain, id);
	}

	/**
	 * 搜索工单请求 调用权限：普通用户 GET请求
	 * 请求参数：query：查询关键词，模糊查询多个字段；status：状态筛选条件；fieldvalue:自定义字段条件；
	 * 
	 * @param domain
	 * @return
	 */
	public static String searchOrder(String domain, String keys, int page, int per_page) {
		StringBuilder stringBuilder = new StringBuilder();
		if (page > 0) {
			stringBuilder.append("&");
			stringBuilder.append(PAGE).append("=").append(page);
		}
		if (per_page > 0) {
			stringBuilder.append("&");
			stringBuilder.append(PER_PAGE).append("=").append(per_page);
		}
		return String.format(SERCH_ORDER, domain, keys) + stringBuilder.toString();
	}

	/**
	 * 获取指定公司组织的工单请求 调用权限：客服 GET请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param organization_id
	 *            公司组织id
	 * @param query
	 *            筛选条件
	 * @return
	 */
	public static String getOrganizationOrderList(String domain, String organization_id, String query) {

		return String.format(ORGANZIATION_ORDER_WITH_ID, domain, organization_id) + getQueryData(query);
	}

	/**
	 * 获取指定用户的工单请求 调用权限：客服 GET请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param endUserId
	 *            用户id
	 * @return
	 */
	public static String getRequesterOrderListByID(String domain, String endUserId, String query) {

		return String.format(REQUEST_ORDER_LIST_WITH_ID, domain, endUserId) + getQueryData(query);
	}

	/**
	 * 获取状态为已解决和已关闭的工单 GET请求 调用权限：普通用户
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getRequesterOrderListStatusSolved(String domain, String query) {

		return String.format(REQUEST_ORDER_STATUS_SOLVED, domain) + getQueryData(query);
	}

	/**
	 * 获取状态小于已解决的工单 GET请求 调用权限：普通用户
	 * 
	 * @param domain
	 *            平台地址
	 * @param query
	 *            筛选条件
	 * @return
	 */
	public static String getRequesterOrderListStatusOpen(String domain, String query) {

		return String.format(REQUEST_ORDER_STATUS_OPEN, domain) + getQueryData(query);
	}

	/**
	 * 工单请求列表 GET请求 调用权限：普通用户
	 * 
	 * @param domain
	 *            平台地址
	 * @param query
	 *            筛选条件
	 * @return
	 */
	public static String getRequesterOrderList(String domain, String query) {
		return String.format(REQUEST_ORDER_LIST, domain) + getQueryData(query);
	}

	/**
	 * 故障类型的工单列表 GET请求 调用权限：客服
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getProblemOrderList(String domain) {
		return String.format(AGENT_ORDER_PROBLEM_LIST, domain);
	}

	/**
	 * 工单被关联的事务列表 调用权限：客服 GET请求
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            工单id
	 * @return
	 */
	public static String getAgentOrderIncidentList(String domain, String id) {
		return String.format(AGENT_ORDER_INCIDENTS_LIST, domain, id);
	}

	/**
	 * 删除多个工单 调用权限：管理员 DELETE请求
	 * 
	 * @param domain
	 * @return
	 */
	public static String deleteManyOrders(String domain) {

		return String.format(AGENT_DELETE_MANY_ORDERS, domain);
	}

	/**
	 * 删除工单 DELETE请求 调用权限：管理员
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            工单id
	 * @return
	 */
	public static String deleteOrder(String domain, String id) {

		return String.format(AGENT_DELETE_ORDER, domain, id);
	}

	/**
	 * 更新多个工单，一次操作最多更新100个工单 PUT请求 调用权限：客服
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String updateManyOrders(String domain) {

		return String.format(AGENT_UPDATE_MANY_ORDERS, domain);
	}

	/**
	 * 获取当前用户所有的工单列表 GET请求 调用权限：admin
	 * 
	 * @param domain
	 *            云客服平台地址
	 * @param page
	 *            可选，指定页数
	 * @param per_page
	 *            可选，指定每页记录数，默认：100
	 * @return
	 */
	public static String getOrderList(String domain, String query) {

		return String.format(AGENT_ORDER_LIST, domain) + getQueryData(query);
	}

	/**
	 * 查看指定客服的受理工单列表 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param assignee_id
	 *            受理客服id
	 * @param query
	 *            筛选条件
	 * @return
	 */
	public static String getOrderListWithID(String domain, String assignee_id, String query) {

		return String.format(AGENT_ORDER_LIST_WITH_ID, domain, assignee_id) + getQueryData(query);
	}

	/**
	 * 查看工单 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            工单id
	 * @return
	 */
	public static String getOrderDetailByAgent(String domain, String id) {

		return String.format(AGENT_ORDER_DETAILS, domain, id);
	}

	/**
	 * 查看多个工单，最多返回100条数据 GET请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param num
	 *            工单数量
	 * @return
	 */
	public static String getAgentManyOrder(String domain, String id) {

		return String.format(AGENT_MANY_ORDER, domain, id);
	}

	/**
	 * 创建工单 POST请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createOrder(String domain) {
		return String.format(AGENT_CREATE_ORDER, domain);
	}

	/**
	 * 更新工单 PUT请求 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            工单id
	 * @return
	 */
	public static String updateOrder(String domain, String id) {
		return String.format(AGENT_UPDATE_ORDER, domain, id);
	}

	private static boolean isNotNull(String query) {

		if (query == null || query.trim().equals(""))
			return false;
		return true;
	}

	private static String getQueryData(String query) {
		StringBuilder stringBuilder = new StringBuilder();
		if (isNotNull(query)) {
			stringBuilder.append("?").append(query);
		}
		return stringBuilder.toString().replace(" ", "");
	}

	/*
	 * ###########################################2017-8-21新增API################
	 * ###########################
	 */

	/**
	 * 搜索工单 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            请求参数 query:查询关键词，模糊查询多个字段; status: 查询筛选条件，例如：open,solved;
	 *            fieldvalue:自定义字段条件; created_order：搜索结果按创建时间排序，可选值：asc,desc
	 *            (默认为desc)
	 * @return
	 */
	public static String searchTickets(String domain, Map<String, String> params) {
		return String.format(AGENT_SEARCH_TICKET, domain) + getMapString(params);
	}

	/**
	 * 触发器列表 ，调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return 返回所有触发器，触发器按SORT倒序，ID正序排列
	 */
	public static String getTriggerList(String domain) {
		return String.format(TRIGGER_LIST, domain);
	}

	/**
	 * 查看指定的id触发器 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            触发器id
	 * @return
	 */
	public static String getTriggerById(String domain, int id) {
		return String.format(GET_TRIGGER_BY_ID, domain, id);
	}

	/**
	 * 查看启用的触发器列表 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getActiveTriggerList(String domain) {
		return String.format(GET_ACTIVE_TRIGGER_LIST, domain);
	}

	/**
	 * 获取自动化任务列表 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getAutomationList(String domain) {
		return String.format(AUTOMATION_LIST, domain);
	}

	/**
	 * 查看指定id的自动化任务 调用权限：admin
	 * 
	 * @param doamin
	 *            平台地址
	 * @param id
	 *            任务id
	 * @return
	 */
	public static String getAutomationById(String doamin, int id) {
		return String.format(GET_AUTOMATION_BY_ID, doamin, id);
	}

	/**
	 * 查看启用的自动化任务列表
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getActiveAutomationList(String domain) {
		return String.format(GET_ACTIVE_AUTOMATION_LIST, domain);
	}

	/**
	 * 获取历史对话列表 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            query参数：
	 *            </p>
	 *            visitor_id(int):筛选指定访客的对话列表
	 *            </p>
	 *            start(String):按创建时间筛选，开始时间，如：2016-01-01
	 *            </p>
	 *            end(String):按创建时间筛选，结束时间，如：2016-01-01
	 *            </P>
	 *            user_id(int):工单系统用户ID（IM访客已关联工单系统用户）
	 *            </p>
	 *            page(int):页码，默认为 1
	 *            </p>
	 *            per_page(int):分页尺寸，默认为 100
	 * @return
	 */
	public static String getHistoryChatList(String domain, Map<String, String> params) {
		return String.format(HISTORY_CHAT_LIST, domain) + getMapString(params);
	}

	/**
	 * 查看对话
	 * </p>
	 * 调用权限：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param chat_id
	 *            对话id
	 * @return
	 */
	public static String getHistroyChatById(String domain, int chat_id) {
		return String.format(HISTORY_CHAT_BY_ID, domain, chat_id);
	}

	/**
	 * 获取客服登录状态日志列表
	 * </p>
	 * 调用权限 ：agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            Query参数集合
	 *            </p>
	 *            start :按创建时间筛选，开始时间，如：2016-01-01(必填)
	 *            </p>
	 *            end :按创建时间筛选，结束时间，如：2016-01-01(必填)
	 *            </p>
	 *            page :页码，默认为 1(非必填)
	 *            </p>
	 *            operate :默认空，全部状态(非必填)
	 * @return
	 */
	public static String getAgentLoginLogList(String domain, Map<String, String> params) {
		return String.format(AGENT_LOGIN_LOG, domain) + getMapString(params);
	}

	/**
	 * 获取机器人题库标签列表
	 * </p>
	 * 调用权限：agent or admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            Query参数
	 *            </p>
	 *            page :页码，默认为 1(非必填)
	 *            </p>
	 *            per_page :分页尺寸，默认为 100(非必填)
	 * @return
	 */
	public static String getAITagList(String domain, Map<String, String> params) {
		return String.format(AI_TAG_LIST, domain) + getMapString(params);
	}

	/**
	 * 创建机器人题库标签
	 * </p>
	 * 调用权限：agent or admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String createAITag(String domain) {
		return String.format(CREATE_AI_TAG, domain);
	}

	/**
	 * 修改标签
	 * </p>
	 * 调用权限：agent or admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param tagId
	 *            标签id
	 * @return
	 */
	public static String updateAITag(String domain, int tagId) {
		return String.format(UPDATE_AI_TAG, domain, tagId);
	}

	/**
	 * 删除标签
	 * </p>
	 * 调用权限：agent or admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param tagId
	 *            标签id
	 * @return
	 */
	public static String deleteAITag(String domain, int tagId) {
		return String.format(DELETE_AI_TAG, domain, tagId);
	}

	/**
	 * 坐席状态监控列表
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            Query参数
	 *            </p>
	 *            start:传递格式：2017-7-10(必填)
	 *            </p>
	 *            end:传递格式：2017-7-10(必填)
	 *            </p>
	 *            agent_ids:查看的客服id,不同的客服id用英文逗号隔开（不传此参数默认查看全部客服）(非必填)
	 * @return
	 */
	public static String getMonitorAgentList(String domain, Map<String, String> params) {
		return String.format(AGNET_STATUS_LIST, domain) + getMapString(params);
	}

	/**
	 * 正在对话监控列表
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getMonitorChatList(String domain) {
		return String.format(MONITOR_CHAT_STATUS, domain);
	}

	/**
	 * 客户排队监控列表
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domian
	 *            平台地址
	 * @return
	 */
	public static String getMonitorVisitorQueueList(String domian) {
		return String.format(MONITOR_VISITOR_QUEUE_LIST, domian);
	}

	/**
	 * 客服工作量统计
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            Query参数
	 *            </p>
	 *            start:传递格式：2017-7-10(必填)
	 *            </p>
	 *            end:传递格式：2017-7-10(必填)
	 * @return
	 */
	public static String getAgentWorkStatusList(String domain, Map<String, String> params) {
		return String.format(AGENT_WORK_STATUS, domain) + getMapString(params);
	}

	/**
	 * 客服对话量统计
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            Query参数
	 *            </p>
	 *            start:传递格式：2017-7-10(必填)
	 *            </p>
	 *            end:传递格式：2017-7-10(必填)
	 * @return
	 */
	public static String getAgentConversation(String domain, Map<String, String> params) {
		return String.format(AGENT_CONVERSATION, domain) + getMapString(params);
	}

	/**
	 * 客服状态时长统计
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param params
	 *            Query参数
	 *            </p>
	 *            start:传递格式：2017-7-10(必填)
	 *            </p>
	 *            end:传递格式：2017-7-10(必填)
	 * @return
	 */
	public static String getAgentStatusTime(String domain, Map<String, String> map) {
		return String.format(AGENT_STATUS_TIME, domain) + getMapString(map);
	}

	/**
	 * 
	 * 对话来源统计
	 * </p>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </p>
	 *            start:传递格式：2017-7-10(必填)
	 *            </p>
	 *            end:传递格式：2017-7-10(必填)
	 */
	public static String getChatSource(String domain, Map<String, String> map) {
		return String.format(CHAT_SOURCE, domain) + getMapString(map);
	}

	/**
	 * GET请求 更新客服在线状态
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 * @param map
	 *            Query参数
	 *            </p>
	 *            agent_id:客服的id(必填)
	 *            </p>
	 *            status:更新的状态，online,offline,busy，三种状态(必填)
	 * @return
	 */
	public static String updateAgentStatu(String domain, Map<String, String> map) {
		return String.format(UPDATE_AGNET_STATUS, domain) + getMapString(map);
	}

	/**
	 * GET请求 通话明细列表
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:按创建时间筛选，开始时间(非必填)
	 *            </P>
	 *            created_end:按创建时间筛选，结束时间(非必填)
	 *            </P>
	 *            page:页码，默认为 1(非必填)
	 *            </P>
	 *            per_page:分页尺寸，默认为 100(非必填)
	 *            </P>
	 *            备注：按创建和更新时间进行筛选的参数
	 *            created_start、created_end、updated_start、updated_end，支持日期格式（如
	 *            2016-01-01 00:00:00）和时间戳（秒级别的整型）。
	 * @return
	 */
	public static String getVoiceCallList(String domain, Map<String, String> map) {
		return String.format(VOICE_HISTORY_LIST, domain) + getMapString(map);
	}

	/**
	 * GET请求，查看通话明细
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param call_id
	 *            通话id
	 * @return
	 */
	public static String getVoiceCallById(String domain, int call_id) {
		return String.format(VOICE_DETAIL, domain, call_id);
	}

	/**
	 * GET请求，语音账号列表
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * 
	 * @param map
	 *            Query参数
	 *            </P>
	 *            page:页码，默认为 1(非必填)
	 *            </P>
	 *            per_page:分页尺寸，默认为 100(非必填)
	 * @return
	 */
	public static String getVoiceAccountList(String domain, Map<String, String> map) {
		return String.format(VOICE_ACCOUNT_LIST, domain) + getMapString(map);
	}

	/**
	 * 客服语音账号
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param voice_account_id
	 *            资源id
	 * @return
	 */
	public static String getVoiceAccountById(String domain, String voice_account_id) {
		return String.format(VOICE_ACCOUNT_BY_ID, domain, voice_account_id);
	}

	/**
	 * 更新客服语音账号
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param id
	 *            资源id
	 * @return
	 */
	public static String updateVoiceAccount(String domain, String id) {
		return String.format(UPDATE_VOICE_ACCOUNT, domain, id);
	}

	/**
	 * 客服登录明细列表
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domian
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(非必填)
	 *            </P>
	 *            created_end: 截止时间(非必填)
	 *            </P>
	 *            page:页码，默认为 1(非必填)
	 *            </P>
	 *            per_page:分页尺寸，默认为 100(非必填)
	 *            </P>
	 *            agent_id:查看某坐席的明细(非必填)
	 * @return
	 */
	public static String getVoiceAgentLoginStateList(String domian, Map<String, String> map) {
		return String.format(VOICE_AGENT_LOGIN_STATE, domian) + getMapString(map);
	}

	/**
	 * 未接通呼入明细列表
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(非必填)
	 *            </P>
	 *            created_end: 截止时间(非必填)
	 *            </P>
	 *            page:页码，默认为 1(非必填)
	 *            </P>
	 *            per_page:分页尺寸，默认为 100(非必填)
	 *            </P>
	 *            agent_id:查看某坐席的明细(非必填)
	 *            </P>
	 *            reason:未接通原因(非必填)
	 *            </P>
	 *            sort:0：降序，1：升序(非必填)
	 * @return
	 */
	public static String getVoiceCallUnAnsweredList(String domain, Map<String, String> map) {
		return String.format(VOICE_CALL_UN_ANSWERED_LIST, domain) + getMapString(map);
	}

	/**
	 * 呼出服务量
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(必填)
	 *            </P>
	 *            created_end: 截止时间(必填)
	 *            </P>
	 *            group_id:客服组ID(非必填)
	 * @return
	 */
	public static String getAgentVoiceCallOutboundList(String domain, Map<String, String> map) {
		return String.format(AGENT_OUTBOUND_STATE_LIST, domain) + getMapString(map);
	}

	/**
	 * 呼入服务量
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(必填)
	 *            </P>
	 *            created_end: 截止时间(必填)
	 *            </P>
	 *            group_id:客服组ID(非必填)
	 * @return
	 */
	public static String getAgentVoiceCallInboundList(String domain, Map<String, String> map) {
		return String.format(AGENT_INBOUNT_STATE_LIST, domain) + getMapString(map);
	}

	/**
	 * 
	 * 客服工作量
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(必填)
	 *            </P>
	 *            created_end: 截止时间(必填)
	 *            </P>
	 *            group_id:客服组ID(非必填)
	 * @return
	 */
	public static String getAgentVoicePerformance(String domain, Map<String, String> map) {
		return String.format(AGENT_VOICE_PERFORMANCE, domain) + getMapString(map);
	}

	/**
	 * 
	 * 客服状态时长
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(必填)
	 *            </P>
	 *            created_end: 截止时间(必填)
	 *            </P>
	 *            group_id:客服组ID(非必填)
	 * @return
	 */
	public static String getAgentVoiceStateTime(String domain, Map<String, String> map) {
		return String.format(AGENT_STATE_TIME, domain) + getMapString(map);
	}

	/**
	 * 
	 * 分时段呼入量
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(必填)
	 *            </P>
	 *            created_end: 截止时间(必填)
	 * @return
	 */
	public static String getAgentVoiceCallSubsectionInbound(String domain, Map<String, String> map) {
		return String.format(AGENT_SUBSECTION_INBOUND, domain) + getMapString(map);
	}

	/**
	 * 
	 * 分时段呼出量
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param map
	 *            Query参数
	 *            </P>
	 *            created_start:起始时间(必填)
	 *            </P>
	 *            created_end: 截止时间(必填)
	 * @return
	 */
	public static String getAgentVoiceCallSubsectionOutbound(String domain, Map<String, String> map) {
		return String.format(AGENT_SUBSECTION_OUTBOUND, domain) + getMapString(map);
	}

	/**
	 * 通话队列
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @return
	 */
	public static String getVoiceQueueCall(String domain) {
		return String.format(VOICE_QUEUE_CALL, domain);
	}

	/**
	 * 客服状态列表
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 * @return
	 */
	public static String getVoiceAgentStatus(String domain) {
		return String.format(VOICE_AGENT_STATUS, domain);
	}

	/**
	 * 查看客服状态
	 * </P>
	 * 调用权限：admin
	 * 
	 * @param domain
	 *            平台地址
	 * @param user_id
	 *            用户UID
	 * @return
	 */
	public static String getAgentVoiceStatusById(String domain, String user_id) {
		return String.format(GET_AGENT_VOICE_STATUS, domain, user_id);
	}

	/**
	 * 客服在线接口
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domian
	 *            平台地址
	 * @return
	 */
	public static String setAgentVoiceOnline(String domian) {
		return String.format(AGENT_VOICE_ONLINE, domian);
	}
	
	
	/**
	 * 客服忙碌接口
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domian
	 *            平台地址
	 * @return
	 */
	public static String setAgentVoiceBusy(String domian) {
		return String.format(AGENT_VOICE_BUSY, domian);
	}
	
	/**
	 * 客服忙碌接口
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domian
	 *            平台地址
	 * @return
	 */
	public static String setAgentVoiceBreak(String domian) {
		return String.format(AGENT_VOICE_BREAK, domian);
	}
	
	/**
	 * 客服离线接口
	 * </P>
	 * 调用权限：admin or agent
	 * 
	 * @param domian
	 *            平台地址
	 * @return
	 */
	public static String setAgentVoiceOffline(String domian) {
		return String.format(AGENT_VOICE_OFFLINE, domian);
	}
	
	
	

	/**
	 * 操作日志列表
	 * </P>
	 * 调用权限 : admin
	 * 
	 * @param domain
	 * @param queryMap
	 *            Query参数
	 *            </P>
	 *            type:操作日志的动作类型，可选值：login【登录】、edit【编辑】、del【删除】(非必填)
	 *            </P>
	 *            object: 操作日志的对象类型，可选值：user【用户】、ticket【工单】(非必填)
	 *            </P>
	 *            start:按创建时间筛选，开始时间(非必填)
	 *            </P>
	 *            end: 按创建时间筛选，结束时间(非必填)
	 *            </P>
	 *            page:页码，默认为 1(非必填)
	 *            </P>
	 *            per_page: 分页尺寸，默认为 100(非必填)
	 *            </P>
	 *            备注：创建时间进行筛选的参数 start、end支持日期格式（如 2016-01-01
	 *            00:00:00）和时间戳（秒级别的整型）。
	 * @return
	 */
	public static String getSystemLog(String domain, Map<String, String> queryMap) {
		return String.format(SYSTEM_LOG, domain) + getMapString(queryMap);
	}

	
	/**
	 * 拉取客服和客服组信息
	 * @return
	 */
	public static String getIMAgentList(){
		return GET_IM_AGENT_LIST;
	}
	
	
	/**
	 * 上传附件
	 * @return
	 */
	public static String uploadCustomIMAttachment(){
		return CUSTOM_IM_UPLOAD_ATTACHMENT;
	}
	
	private static String getMapString(Map<String, String> map) {
		StringBuffer stringBuffer = new StringBuffer();
		if (map != null && map.size() > 0) {
			stringBuffer.append("?");
			for (Map.Entry<String, String> entry : map.entrySet()) {
				stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue())).append("&");
			}
		}
		return stringBuffer.toString();
	}

}
