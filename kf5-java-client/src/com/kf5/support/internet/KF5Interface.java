package com.kf5.support.internet;

public class KF5Interface {

	private final static String SERVER = "https://%1$s";
	
	/**
	 * 工单（客服）相关接口
	 */
	//工单列表
	private final static String AGENT_ORDER_LIST = SERVER+"/apiv2/tickets.json";
	//指定客服受理的工单列表
	private final static String AGENT_ORDER_LIST_WITH_ID = SERVER+"/apiv2/users/%2$s/tickets.json";
	//查看工单
	private final static String AGENT_ORDER_DETAILS = SERVER+"/apiv2/tickets/%2$s.json";
	//查看多个工单，最多返回100条数据
	private final static String AGENT_MANY_ORDER = SERVER +"/apiv2/tickets/show_many.json?ids=";
	//创建工单
	private final static String AGENT_CREATE_ORDER = SERVER +"/apiv2/tickets.json";
	//更新工单
	private final static String AGENT_UPDATE_ORDER = SERVER +"/apiv2/tickets/%2$s.json";
	//更新多个工单
	private final static String AGENT_UPDATE_MANY_ORDERS = SERVER +"/apiv2/tickets/update_many.json?ids=";
	//删除工单
	private final static String AGENT_DELETE_ORDER = SERVER + "/apiv2/tickets/%2$s.json";
	//删除多个工单
	private final static String AGENT_DELETE_MANY_ORDERS = SERVER +"/apiv2/tickets/delete_many.json?ids=";
	//工单被关联的事务列表
	private final static String AGENT_ORDER_INCIDENTS_LIST = SERVER +"/apiv2/tickets/%2$s/incidents.json";
	//故障类型的工单列表
	private final static String AGENT_ORDER_PROBLEM_LIST = SERVER +"/apiv2/tickets/problems.json";
	//工单可用的副本用户
	private final static String AGENT_ORDER_COLLABORATORS = SERVER +"/apiv2/tickets/%2$s/collaborators.json";
	
	/**
	 * 工单（普通用户）相关接口
	 */
	
	//工单请求列表
	private final static String REQUEST_ORDER_LIST = SERVER +"/apiv2/requests.json";
	//状态小于已解决的工单
	private final static String REQUEST_ORDER_STATUS_OPEN = SERVER +"/apiv2/requests/open.json";
	//状态为已解决和已关闭的工单
	private final static String REQUEST_ORDER_STATUS_SOLVED = SERVER + "/apiv2/requests/solved.json";
	//获取指定用户的工单请求
	private final static String REQUEST_ORDER_LIST_WITH_ID = SERVER + "/apiv2/users/%2$s/requests.json";
	//获取指定公司组织的工单请求
	private final static String ORGANZIATION_ORDER_WITH_ID = SERVER + "/apiv2/organizations/%2$s/requests.json";
	//搜索工单请求
	private final static String SERCH_ORDER = SERVER +"/apiv2/requests/search.json?";
	// 查看工单请求
	private final static String REQUEST_VIEW_ORDER = SERVER + "/apiv2/requests/%2$s.json";
	//创建工单请求
	private final static String REQUEST_CREATE_ORDER = SERVER + "/apiv2/requests.json";
	//回复工单
	private final static String REQUESTER_REPLY_ORDER = SERVER +"/apiv2/requests/%2$s.json";
	//工单回复列表
	private final static String REQUESTER_COMMENT_LIST = SERVER + "/apiv2/requests/%2$s/comments.json";
	//查看指定工单回复
	private final static String REQUESTER_COMMENT_WITH_ID = SERVER +"/apiv2/requests/%2$s/comments/%3$s.json";
	
	/**
	 * 工单回复接口
	 */
	//工单回复列表
	private final static String ORDER_COMMENT_LIST = SERVER +"/apiv2/tickets/%2$s/comments.json";
	
	/**
	 * 工单自定义字段接口
	 */
	
	//工单自定义字段列表
	private final static String TICKET_FIELD_LIST = SERVER +"/apiv2/ticket_fields.json";
	//获取状态为启动的自定义字段列表
	private final static String TICKET_FIELD_LIST_ACTIVE = SERVER +"/apiv2/ticket_fields/active.json";
	//查看自定义字段
	private final static String TICKET_FIELD_LIST_BY_ID = SERVER +"/apiv2/ticket_fields/%2$s.json";
	//删除自定义字段
	private final static String DELETE_TICKET_FIELD = SERVER +"/apiv2/ticket_fields/%2$s.json";
	
	/**
	 * 工单查看分类接口
	 */

	//工单查看分类列表
	private final static String VIEWS_ORDER_TYPE_LIST =SERVER+"/apiv2/views.json";
	//获取可用的工单查看分类
	private final static String VIEWS_ORDER_TYPE_ACTIVE = SERVER +"/apiv2/views/active.json";
	//获取指定查看分类
	private final static String VIEW_ORDER_LIST_WITH_ID = SERVER+"/apiv2/views/%2$s.json";
	//获取指定查看分类里的工单
	private final static String VIEW_TICKET_BY_ID = SERVER + "/apiv2/views/%2$s/tickets.json";
	//获取指定查看分类的工单个数
	private final static String VIEW_TICKET_COUNT = SERVER +"/apiv2/views/%2$s/count.json";
	//获取多个查看分类的工单个数
	private final static String VIEW_MANY_TICKET_COUNT = SERVER +"/apiv2/views/count_many.json?ids=";
	
	/**
	 * 用户接口
	 */
	//获取用户列表
	private final static String USER_LIST = SERVER + "/apiv2/users.json";
	//查看指定用户信息
	private final static String USER_INFO = SERVER +"/apiv2/users/%2$s.json";
	//查看自己的信息
	private final static String INFO_OF_MINE = SERVER +"/apiv2/users/me.json";
	//获取多个用户信息
	private final static String INFO_OF_MANY = SERVER +"/apiv2/users/show_many.json?ids=";
	//创建用户信息
	private final static String CREATE_USER_INFO = SERVER + "/apiv2/users.json";
	//合并用户
	private final static String MERGE_USER = SERVER +"/apiv2/users/%2$s/merge.json";
	//修改用户信息
	private final static String UPDATE_USER_INFO = SERVER +"/apiv2/users/%2$s.json";
	//删除用户
	private final static String DELETE_USER = SERVER +"/apiv2/users/%2$s.json";
	//搜索用户
	private final static String SEARCH_USER = SERVER + "/apiv2/users/search.json?query=";

	/**
	 * 用户自定义字段接口
	 */
	
	//用户自定义字段列表
	private final static String USER_FIELDS = SERVER +"/apiv2/user_fields.json";
	//获取状态为启动的自定义的字段列表
	private final static String USER_FIELDS_ACTIVE = SERVER +"/apiv2/user_fields/active.json";
	//查看用户自定义字段
	private final static String USER_FIELDS_BY_ID = SERVER +"/apiv2/user_fields/%2$s.json";
	//删除用户自定义字段
	private final static String DELETE_USER_FIELDS = SERVER + "/apiv2/user_fields/%2$s.json";
	
	/**
	 * 客服组
	 */
	
	//客服组列表
	private final static String GROUP_LIST = SERVER +"/apiv2/groups.json";
	//查看客服组
	private final static String GROUP_LIST_BY_ID = SERVER+"/apiv2/groups/%2$s.json";
	//创建客服组
	private final static String CREATE_GROUP = SERVER +"/apiv2/groups.json";
	//修改客服组
	private final static String UPDATE_GROUP = SERVER +"/apiv2/groups/%2$s.json";
	//删除客服组
	private final static String DELETE_GROUP = SERVER +"/apiv2/groups/%2$s.json";
	
	/**
	 * 公司组织接口
	 */
	//公司组织列表
	private final static String ORGANIZATION_LIST = SERVER +"/apiv2/organizations.json";
	//查看公司组织
	private final static String VIEW_ORGANIZATION = SERVER +"/apiv2/organizations/%2$s.json";
	//创建公司组织
	private final static String CREATE_ORGANIZATION = SERVER +"/apiv2/organizations.json";
	//修改公司组织
	private final static String UPDATE_ORGANIZATION = SERVER + "/apiv2/organizations/%2$s.json";
	//删除公司组织
	private final static String DELETE_ORGANIZATION = SERVER +"/apiv2/organizations/%2$s.json";
	
	
	
	/**
	 * 文档分区接口
	 */
	//文档分区列表
	private final static String CATEGORIES_LIST = SERVER +"/apiv2/categories.json"; 
	//查看文档分区
	private final static String CATEGORIES_LIST_WITH_ID = SERVER +"/apiv2/categories/%2$s.json";
	//创建文档分区
	private final static String CREATE_CATEGORY = SERVER +"/apiv2/categories.json";
	//修改文档分区
	private final static String UPDATE_CATEGORY = SERVER +"/apiv2/categories/%2$s.json";
	//删除文档分区
	private final static String DELETE_CATEGORY = SERVER +"/apiv2/categories/%2$s.json";
	
	/**
	 * 文档分类接口
	 */
	
	//文档分类列表
	private final static String FORUMS_LIST = SERVER +"/apiv2/forums.json";
	//查看文档分类
	private final static String FORUMS_LIST_BY_ID = SERVER+"/apiv2/forums/%2$s.json";
	//创建文档分类
	private final static String CREATE_FORUM = SERVER +"/apiv2/forums.json";
	//修改文档分类
	private final static String UPDATE_FORUM = SERVER +"/apiv2/forums/%2$s.json";
	//删除文档分类
	private final static String DELETE_FORUM = SERVER +"/apiv2/forums/%2$s.json";
	
	
	/**
	 * 文档接口
	 */
	//文档列表
	private final static String POST_LIST = SERVER+"/apiv2/posts.json";
	//查看文档
	private final static String POST_DETAIL = SERVER +"/apiv2/posts/%2$s.json";
	//查看多个文档
	private final static String POST_MANY = SERVER +"/apiv2/posts/show_many.json?ids=";
	//搜索文档
	private final static String SEARCH_POST = SERVER +"/apiv2/posts/search.json?query=";
	//创建文档
	private final static String CREATE_POST = SERVER +"/apiv2/posts.json";
	//修改文档
	private final static String UPDATE_POST = SERVER+"/apiv2/posts/%2$s.json";
	//删除文档
	private final static String DELETE_POST = SERVER +"/apiv2/posts/%2$s.json";
	//文档回复列表
	private final static String POST_COMMENT_LIST = SERVER + "/apiv2/posts/%2$s/comments.json";
	//查看指定文档回复
	private final static String POST_COMMETN_BY_ID = SERVER +"/apiv2/posts/%2$s/comments/%3$s.json";
	//回复文档
	private final static String POST_REPLY = SERVER +"/apiv2/posts/%2$s/comments.json";
	
	/**
	 * 社区话题接口
	 */
	
	//社区话题列表
	private final static String TOPIC_LIST = SERVER +"/apiv2/topics.json";
	//查看社区话题
	private final static String TOPIC_BY_ID = SERVER +"/apiv2/topics/%2$s.json";
	//创建社区话题
	private final static String TOPIC_CREATE = SERVER +"/apiv2/topics.json";
	//修改社区话题
	private final static String TOPIC_UPDATE = SERVER +"/apiv2/topics/%2$s.json";
	//删除社区话题
	private final static String TOPIC_DELETE = SERVER +"/apiv2/topics/%2$s.json";
	
	/**
	 * 社区问题接口
	 */
	//社区问题列表
	private final static String QUESTION_LIST =SERVER+"/apiv2/questions.json";
	//查看社区问题
	private final static String QUESTION_BY_ID = SERVER +"/apiv2/questions/%2$s.json";
	//创建社区问题
	private final static String QUESTION_CREATE = SERVER +"/apiv2/questions.json";
	//修改社区问题
	private final static String QUESTION_UPDATE = SERVER +"/apiv2/questions/%2$s.json";
	//删除社区问题
	private final static String QUESTION_DELETE = SERVER +"/apiv2/questions/%2$s.json";
	//社区问题回复列表
	private final static String QUESTION_COMMENT_LIST = SERVER +"/apiv2/questions/%2$s/comments.json";
	//查看指定社区问题回复
	private final static String QUESTION_COMMENT_BY_ID = SERVER +"/apiv2/questions/%2$s/comments/%3$s.json";
	//回复社区问题
	private final static String QUESTION_REPLY = SERVER +"/apiv2/questions/%2$s/comments.json";
	
	
	
	/**
	 * 附件接口
	 */
	
	//上传附件
	private final static String ATTACHMENTS_UPLOAD = SERVER +"/apiv2/attachments.json?filename=%2$s";
	//查看附件
	private final static String ATTACHMENT_VIEW = SERVER +"/apiv2/attachments/%2$s.json";
	//删除附件
	private final static String ATTACHMENT_DELETE = SERVER +"/apiv2/attachments/%2$s.json";
	
	
	/**
	 * 导入接口
	 */
	
	//工单导入
	private final static String ORDER_IMPORT = SERVER +"/apiv2/imports/tickets.json";

	/**
	 * 导出接口
	 */
	
	private final static String ORDER_EXPORT = SERVER +"/apiv2/exports/tickets.json";
	
	
	
	/**
	 * 工单可用的副本用户
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param id 工单id
	 * @return
	 */
	public static String getAgentOrderCollaborators(String domain,String id){
		
		return String.format(AGENT_ORDER_COLLABORATORS, domain,id);
	}
	
	
	
	/**
	 * 导出工单
	 * GET请求
	 * 调用权限：admin
	 * 请求参数：start_time:设定请求导出的工单创建时间的开始点(时间戳)
	 * end_time:设定请求导出的工单创建时间的结束点(时间戳)
	 * order：ID排序 'ASC' or 'DESC'
	 * 每页最多返回500条数据
	 * 注意：若不设置start_time，默认导出end_time之前创建的工单；
	 * 若不设置end_time，默认导出从start_time至当前时间内创建的工单;
	 * 若不设置order，默认导出工单按ID正序排列。
	 * url示例： https://{subdomain}.kf5.com/apiv2/exports/tickets.json?start_time=1425698858
	 * @param domain 平台地址
	 * @return
	 */
	public static String orderExport(String domain){
		return String.format(ORDER_EXPORT, domain);
	}
	
	/**
	 * 导入工单
	 * POST请求
	 * 调用权限：admin
	 * 导入接收数据为单个工单数据，批量导入时请循环调用接口。如果在导入时出错，可以方便处理出错数据
	 * 工单在导入时，触发器等系统规则对该条工单不生效
	 * 导入时允许设置工单的created_at,updated_at等时间字段
	 * 允许设置工单回复comments的创建时间created_at, 注意comments数据必须包含author_id,content字段值
	 * 请在导入前确认工单及回复所涉及的用户全部存在于云客服平台里，如果没有请调用 用户接口 Users API 进行创建
	 * @param domain 平台地址
	 * @return
	 */
	public static String importOrder(String domain){
		
		return String.format(ORDER_IMPORT, domain);
	}
	/**
	 * 删除附件
	 * DELETE请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param id 附件id
	 * @return
	 */
	public static String deleteAttachment(String domain,String id){
		return String.format(ATTACHMENT_DELETE, domain,id);
	}
	
	/**
	 * 查看附件
	 * 调用权限：agent
	 * GET请求
	 * @param domain 平台地址
	 * @param id 附件id
	 * @return
	 */
	public static String viewAttachment(String domain,String id){
		
		return String.format(ATTACHMENT_VIEW, domain,id);
	}
	
	/**
	 * 上传附件
	 * POST请求
	 * 注意：需要在url里添加filename参数来设置附件文件名（如：/apiv2/attachments.json?filename=test.jpg）
	 * 同一个附件只能对应一个工单或一个工单回复或一个文档
	 * 请求header里需要设置"Content-Type: application/binary"
	 * @param domain 平台地址
	 * @return
	 */
	public static String uploadAttachment(String domain,String filename){
		
		return String.format(ATTACHMENTS_UPLOAD, domain,filename);
	}
	

	/**
	 * 回复社区问题
	 * PUT请求
	 * 调用权限：end user
	 * @param domain 平台地址
	 * @param question_id 问题id
	 * @return
	 */
	public static String replyQuestion(String domain,String question_id){
		return String.format(QUESTION_REPLY, domain,question_id);
	}
	
	/**
	 * 查看指定社区问题回复
	 * GET请求
	 * 调用权限：end user
	 * @param domain 平台地址
	 * @param question_id 问题id
	 * @param id 回复id
	 * @return
	 */
	public static String getQuestionCommentByID(String domain,String question_id,String id){
		return String.format(QUESTION_COMMENT_BY_ID, domain,question_id,id);
	}
	
	
	
	
	
	
	/**
	 * 社区问题回复列表
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param question_id 问题id
	 * @return
	 */
	public static String getQuestionCommentList(String domain,String question_id){
		
		return String.format(QUESTION_COMMENT_LIST, domain,question_id);
		
	}
	
	
	/**
	 * 删除社区问题
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain
	 * @param question_id
	 * @return
	 */
	public static String deleteQuestion(String domain,String question_id){
		
		return String.format(QUESTION_DELETE, domain,question_id);
	}
	
	
	/**
	 * 修改社区问题
	 * PUT请求
	 * 调用权限：admin
	 * @param domain
	 * @param question_id
	 * @return
	 */
	public static String updateQuestion(String domain,String question_id){
		
		return String.format(QUESTION_UPDATE, domain,question_id);
	}
	
	/**
	 * 创建社区问题
	 * POST请求
	 * 调用权限：all
	 * @param domain
	 * @return
	 */
	public static String createQuestion(String domain){
		
		return String.format(QUESTION_CREATE, domain);
	}
	
	
	/**
	 * 查看社区问题
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param question_id 问题id
	 * @return
	 */
	public static String getQuestionByID(String domain,String question_id){
		return String.format(QUESTION_BY_ID, domain,question_id);
	}
	
	
	/**
	 * 社区问题列表
	 * GET请求
	 * 调用权限：all
	 * @param domain
	 * @return
	 */
	public static String getQuestionList(String domain){
		
		return String.format(QUESTION_LIST, domain);
	}
	
	/**
	 * 删除社区话题
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param topic_id 话题id
	 * @return
	 */
	public static String deleteTopic(String domain,String topic_id){
		return String.format(TOPIC_DELETE, domain,topic_id);
	}
	
	
	/**
	 * 修改社区话题
	 * PUT请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param topic_id 话题id
	 * @return 
	 */
	public static String updateTopic(String domain,String topic_id){
		return String.format(TOPIC_UPDATE, domain,topic_id);
	}
	
	
	/**
	 * 创建社区话题
	 * POST请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @return
	 */
	public static String createTopic(String domain){
		

		return String.format(TOPIC_CREATE, domain);
		
		
	}
	
	
	/**
	 * 查看社区话题
	 * GET请求
	 * 调用权限：all
	 * @param domain
	 * @param topic_id
	 * @return
	 */
	public static String getTopicByID(String domain,String topic_id){
		
		return String.format(TOPIC_BY_ID, domain,topic_id);
	}
	
	/**
	 * 社区话题列表
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @return
	 */
	public static String getTopicList(String domain){
		return String.format(TOPIC_LIST, domain);
	}
	
	/**
	 * 回复文档
	 * POST请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param post_id 文档id
	 * @return
	 */
	public static String postReply(String domain,String post_id){
		
		return String.format(POST_REPLY, domain,post_id);
	}
	
	
	/**
	 * 查看指定文档回复
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param post_id 文档id
	 * @param id 回复id
	 * @return
	 */
	public static String getPostCommentByID(String domain,String post_id,String id){
		
		return String.format(POST_COMMETN_BY_ID, domain,post_id,id);
	}
	
	
	
	/**
	 * 文档回复列表
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param post_id 文档id
	 * @return
	 */
	public static String getPostCommentList(String domain,String post_id){
		return String.format(POST_COMMENT_LIST, domain,post_id);
	}
	
	/**
	 * 删除文档
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param post_id 文档id
	 * @return
	 */
	public static String deletePost(String domain,String post_id){
		return String.format(DELETE_POST, domain,post_id);
	}
	
	/**
	 * 修改文档
	 * PUT请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param post_id 文档id
	 * @return
	 */
	public static String updatePost(String domain,String post_id){
		
		return String.format(UPDATE_POST, domain,post_id);
	}
	
	
	/**
	 * 创建文档
	 * POST请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @return
	 */
	public static String createPost(String domain){
		return String.format(CREATE_POST, domain);
	}
	
	
	/**
	 * 搜索文档
	 * GET请求
	 * 调用权限：all
	 * @param domain平台地址
	 * @param key_word 搜索关键字
	 * @return
	 */
	public static String searchPost(String domain,String key_word){
		return String.format(SEARCH_POST, domain)+key_word;
	}
	
	/**
	 * 查看多个文档
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param posts_id 多个文档id;格式为：1,2,3
	 * @return
	 */
	public static String getManyPosts(String domain,String posts_id){
		
		return String.format(POST_MANY, domain)+posts_id;
	}
	
	/**
	 * 查看文档
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param post_id 文档id
	 * @return 
	 */
	public static String getPostDetail(String domain,String post_id){
		return String.format(POST_DETAIL, domain,post_id);
	}
	
	/**
	 * 获取文档列表
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @return
	 */
	public static String getPostList(String domain){
		
		return String.format(POST_LIST, domain);
	}
	
	
	/**
	 * 删除文档分类
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain
	 * @param forum_id
	 * @return
	 */
	public static String deleteForum(String domain,String forum_id){
		return String.format(DELETE_FORUM, domain,forum_id);
	}
	
	
	/**
	 * 修改文档分类
	 * PUT请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param forum_id 文档分类id
	 * @return
	 */
	public static String updateForum(String domain,String forum_id){
		
		return String.format(UPDATE_FORUM, domain,forum_id);
	}
	
	
	/**
	 * 创建文档分类
	 * POST请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @return
	 */
	public static String createForum(String domain){
		
		return String.format(CREATE_FORUM, domain);
	}
	
	/**
	 * 查看文档分类
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param forum_id 文档分类id
	 * @return
	 */
	public static String getForumByID(String domain,String forum_id){
		return String.format(FORUMS_LIST_BY_ID, domain,forum_id);
	}
	
	/**
	 * 获取文档分区列表
	 * GET请求
	 * 调用权限：all
	 * @param domain
	 * @return
	 */
	public static String getForumList(String domain){
		return String.format(FORUMS_LIST, domain);
	}
	
	/**
	 * 删除文档分区
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param category_id 文档分区id
	 * @return
	 */
	public static String deleteCategory(String domain,String category_id){
		return String.format(DELETE_CATEGORY, domain,category_id);
	}
	
	
	/**
	 * 修改文档分区
	 * PUT请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param category_id 文档分区id
 	 * @return
	 */
	public static String updateCategory(String domain,String category_id){
		
		return String.format(UPDATE_CATEGORY, domain,category_id);
	}
	
	
	/**
	 * 创建文档分区
	 * POST请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @return
	 */
	public static String createCategory(String domain){
		return String.format(CREATE_CATEGORY, domain);
	}
	
	/**
	 * 查看文档分区
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @param category_id 分区id
	 * @return
	 */
	public static String getCategoryByID(String domain,String category_id){
		return String.format(CATEGORIES_LIST_WITH_ID, domain,category_id);
	}
	
	/**
	 * 获取文档分区列表
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @return
	 */
	public static String getCategoriesList(String domain){
		
		return String.format(CATEGORIES_LIST, domain);
	}
	
	
	
	
	/**
	 * 删除公司组织
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param organization_id 公司组织id
	 * @return
	 */
	public static String deleteOrganization(String domain,String organization_id){
		
		return String.format(DELETE_ORGANIZATION, domain,organization_id);
		
	}
	
	
	/**
	 * 修改公司组织
	 * PUT请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param organization_id 公司组织id
	 * @return
	 */
	public static String updateOrganization(String domain,String organization_id){
		
		return String.format(UPDATE_ORGANIZATION, domain,organization_id);
	}
	
	
	/**
	 * 创建公司组织
	 * POST请求方式
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @return
	 */
	public static String createOrganization(String domain){
		
		return String.format(CREATE_ORGANIZATION, domain);
		
	}
	
	/**
	 * 查看公司组织
	 * GET请求
	 * 调用权限：agents
	 * @param domain 平台地址
	 * @param organization_id 公司组织id
	 * @return
	 */
	public static String getOrganizationByID(String domain,String organization_id){
		
		return String.format(VIEW_ORGANIZATION, domain,organization_id);
		
	}
	
	/**
	 * 公司组织列表
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getOrganizationList(String domain){
		
		return String.format(ORGANIZATION_LIST, domain);
	}
	
	/**
	 * 删除客服组
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain 平台地址
 	 * @param group_id 客服组id
	 * @return
	 */
	public static String deleteGroup(String domain,String group_id){
		
		return String.format(DELETE_GROUP, domain,group_id);
		
	}
	
	
	/**
	 * 修改客服组
	 * PUT请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param group_id 客服组id
	 * @return
	 */
	public static String updateGroup(String domain,String group_id){
		
		return String.format(UPDATE_GROUP, domain,group_id);
		
	}
	
	
	
	/**
	 * 创建客服组
	 * POST请求
	 * 调用权限：admin
	 * @param domain
	 * @return
	 */
	public static String createGroup(String domain){
		return String.format(CREATE_GROUP, domain);
	}
	
	/**
	 * 查看客服组
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param group_id 客服组id
	 * @return
	 */
	public static String getGroupListByID(String domain,String group_id){
		
		return String.format(GROUP_LIST_BY_ID, domain,group_id);
		
	}
	
	
	/**
	 * 客服组列表
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getGroupList(String domain){
		
		return String.format(GROUP_LIST, domain);
	}
	
	
	/**
	 * 删除用户自定义字段
	 * DELETE字段
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param id 字段id
	 * @return
	 */
	public static String deleteUserField(String domain,String id){
		
		return String.format(DELETE_USER_FIELDS, domain,id);
	}
	
	
	/**
	 * 查看用户自定义字段
	 * GET请求
	 * 调用权限：agents
	 * @param domain 平台地址
	 * @param id 字段id
	 * @return
	 */
	public static String getUserFieldListByID(String domain,String id){
		
		return String.format(USER_FIELDS_BY_ID, domain,id);
	}
	
	
	/**
	 * 获取状态为启用的自定义字段列表
	 * GET请求
	 * 调用权限：agents
	 * @param domain
	 * @return
	 */
	public static String getUserFieldActiveList(String domain){
		return String.format(USER_FIELDS_ACTIVE, domain);
	}
	
	
	/**
	 * 获取自定义字段列表
	 * GET请求
	 * 调用权限：agents
	 * @param domain 平台地址
	 * @return
	 */
	public static String getUserFieldList(String domain){
		return String.format(USER_FIELDS, domain);
	}
	
	/**
	 * 搜索用户
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String searchUser(String domain){
		return String.format(SEARCH_USER, domain);
	}
	
	/**
	 * 删除用户
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param user_id 用户id
	 * @return
	 */
	public static String deleteUser(String domain,String user_id){
		return String.format(DELETE_USER, domain,user_id);
	}
	
	/**
	 * 修改用户信息
	 * PUT请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param user_id 用户id
	 * @return
	 */
	public static String updateUserInfo(String domain,String user_id){
		return String.format(UPDATE_USER_INFO, domain,user_id);
	}
	
	/**
	 * 合并用户
	 * PUT请求
	 * 调用权限：admin
	 * 注：URL里指定id的用户，将会被合并到传递参数中id所代表的用户。 前者的数据也会合并为后者的数据，之后前者将会被删除。 被合并的用户，只能是普通用户角色。
	 * @param domain
	 * @param user_id
	 * @return
	 */
	public static String mergeUser(String domain,String user_id){
		
		return String.format(MERGE_USER, domain,user_id);
	}
	
	
	/**
	 * 创建用户信息
	 * POST请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String createUserInfo(String domain){
		return String.format(CREATE_USER_INFO, domain);
	}
	
	
	/**
	 *获取多个用户信息
	 *GET请求
	 *调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getManyUsersInfo(String domain){
		return String.format(INFO_OF_MANY, domain);
	}
	
	/**
	 * 查看自己的信息
	 * GET请求
	 * 调用权限：all
	 * @param domain 平台地址
	 * @return
	 */
	public static String getMyInfo(String domain){
		
		return String.format(INFO_OF_MINE, domain);
	}
	
	
	/**
	 * 查看指定用户信息
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param user_id 用户id
	 * @return
	 */
	public static String getUserInfo(String domain,String user_id){
		return String.format(USER_INFO, domain,user_id);
	}
	
	/**
	 * 获取用户列表
	 * GET请求
	 * 调用权限： agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getUserList(String domain){
		
		return String.format(USER_LIST, domain);
	}
	
	/**
	 * 获取多个查看分类的工单个数
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getManyTicketCountByTypeIds(String domain){
		return String.format(VIEW_MANY_TICKET_COUNT, domain);
	}
	
	/**
	 * 获取指定查看分类的工单个数
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param type_id 分类id
	 * @return
	 */
	public static String getTicketCountByTypeID(String domain,String type_id){
		
		return String.format(VIEW_TICKET_COUNT, domain,type_id);
	}
	
	
	/**
	 * 获取指定查看分类里的工单
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param type_id 分类id
	 * @return
	 */
	public static String getTicketListByTypeID(String domain,String type_id){
		
		return String.format(VIEW_TICKET_BY_ID, domain,type_id);
	}
	
	
	/**
	 * 获取指定查看分类
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param id 
	 * @return
	 */
	public static String getOrderTypeListByID(String domain,String id){
		return String.format(VIEW_ORDER_LIST_WITH_ID, domain,id);
	}
	
	/**
	 * 获取当前客户可用的工单查看分类
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getOrderTypeListActive(String domain){
		
		return String.format(VIEWS_ORDER_TYPE_ACTIVE, domain);
	}
	
	/**
	 * 获取当前客户的工单查看分类
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String getOrderTypeList(String domain){
		return String.format(VIEWS_ORDER_TYPE_LIST, domain);
	}
	
	
	/**
	 * 删除自定义字段
	 * DELETE请求
	 * 调用权限：admin
	 * @param domain
	 * @param ticket_field_id
	 * @return
	 */
	public static String deleteTicketFieldByID(String domain,String ticket_field_id){
		
		return String.format(DELETE_TICKET_FIELD, domain,ticket_field_id);
	}
	
	/**
	 * 查看自定义字段
	 * GET请求
	 * 调用权限：agents
	 * @param domain 平台地址
	 * @param ticket_field_id 自定义字段id
	 * @return
	 */
	public static String getTicketFieldByID(String domain,String ticket_field_id){
		
		return String.format(TICKET_FIELD_LIST_BY_ID, domain,ticket_field_id);
	}
	
	
	/**
	 * 获取状态为启动的自定义字段列表
	 * GET请求方式
	 * 调用权限：agents
	 * @param domain
	 * @return
	 */
	public static String getTicketFieldListActive(String domain){
		
		return String.format(TICKET_FIELD_LIST_ACTIVE, domain);
	}
	
	/**
	 * 获取工单自定义字段列表
	 * GET请求
	 * 调用权限：agents
	 * @param domain
	 * @return
	 */
	public static String getTicketFieldList(String domain){
		
		return String.format(TICKET_FIELD_LIST, domain);
		
	}
	
	
	/**
	 * 获取工单回复列表
	 * GET请求
	 * 调用权限：客服
	 * @param domain 平台地址
	 * @param ticket_id 工单id
	 * @return
	 */
	public static String getOrderCommentList(String domain,String ticket_id){
		
		return String.format(ORDER_COMMENT_LIST, domain,ticket_id);
	}
	
	
	
	/**
	 * 查看指定的工单回复
	 * 调用权限：普通用户
	 * GET请求
	 * @param domain 平台地址
	 * @param requester_id 工单发起人id
	 * @param id 回复id
	 * @return
	 */
	public static String getOrderCommentWithID(String domain,String requester_id,String id){
		return String.format(REQUESTER_COMMENT_WITH_ID, domain,requester_id,id);
	}
	
	
	/**
	 * 获取工单回复列表
	 * GET请求
	 * 调用权限：普通用户
	 * 按创建时间排序，可以添加排序参数，sort_order:排序规则，可选值：asc，desc（默认为asc）；
	 * @param domain 平台地址
	 * @param order_id 工单id
	 * @return
	 */
	public static String getCommentListByEndUser(String domain,String order_id){
		return String.format(REQUESTER_COMMENT_LIST, domain,order_id);
	}
	
	
	/**
	 * 回复工单
	 * 调用权限： 普通用户
	 * PUT请求
	 * @param domain 平台地址
	 * @param order_id 工单id
	 * @return
	 */
	public static String replyOrderByEndUser(String domain,String order_id){

		return String.format(REQUESTER_REPLY_ORDER, domain,order_id);
	}
	
	
	/**
	 * 创建工单请求
	 * POST请求
	 * 调用权限：普通用户
	 * @param domain 平台地址
	 * @return
	 */
	public static String createOrderByRequester(String domain){
		
		return String.format(REQUEST_CREATE_ORDER, domain);
	
	}
	
	
	
	/**
	 * 查看工单请求
	 * 调用权限：普通用户
	 * GET请求
	 * @param domain
	 * @param id
	 * @return
	 */
	public static String getOrderDetailByRequester(String domain,String id){
		
		return String.format(REQUEST_VIEW_ORDER, domain,id);
	}
	
	/**
	 * 搜索工单请求
	 * 调用权限：普通用户
	 * GET请求
	 * 请求参数：query：查询关键词，模糊查询多个字段；status：状态筛选条件；fieldvalue:自定义字段条件；
	 * @param domain
	 * @return
	 */
	public static String searchOrder(String domain){
		return String.format(SERCH_ORDER, domain);
	}
	

	/**
	 * 获取指定公司组织的工单请求
	 * 调用权限：客服
	 * GET请求
	 * @param domain 平台地址
	 * @param organization_id 公司组织id
	 * @return
	 */
	public static String getOrganizationOrderList(String domain,String organization_id){
		
		return String.format(ORGANZIATION_ORDER_WITH_ID, domain,organization_id);
	}
	
	/**
	 * 获取指定用户的工单请求
	 * 调用权限：客服
	 * GET请求
	 * @param domain 平台地址
	 * @param endUserId 用户id
	 * @return
	 */
	public static String getRequesterOrderListByID(String domain,String endUserId){
		
		return String.format(REQUEST_ORDER_LIST_WITH_ID, domain,endUserId);
	}
	
	
	/**
	 * 获取状态为已解决和已关闭的工单
	 * GET请求
	 * 调用权限：普通用户
	 * @param domain 平台地址
	 * @return
	 */
	public static String getRequesterOrderListStatusSolved(String domain){
		return String.format(REQUEST_ORDER_STATUS_SOLVED, domain);
	}
	
	
	/**
	 * 获取状态小于已解决的工单
	 * GET请求
	 * 调用权限：普通用户
	 * @param domain 平台地址
	 * @return
	 */
	public static String getRequesterOrderListStatusOpen(String domain){
		
		return String.format(REQUEST_ORDER_STATUS_OPEN, domain);
	}
	
	
	/**
	 * 工单请求列表
	 * GET请求
	 * 调用权限：普通用户
	 * @param domain 平台地址
	 * @return
	 */
	public static String getRequesterOrderList(String domain){
		return String.format(REQUEST_ORDER_LIST, domain);
	}
	
	
	/**
	 * 故障类型的工单列表
	 * GET请求
	 * 调用权限：客服
	 * @param domain 平台地址
	 * @return
	 */
	public static String getProblemOrderList(String domain){
		return String.format(AGENT_ORDER_PROBLEM_LIST, domain);
	}
	
	
	/**
	 * 工单被关联的事务列表
	 * 调用权限：客服
	 * GET请求
	 * @param domain 平台地址
	 * @param id 工单id
	 * @return
	 */
	public static String getAgentOrderIncidentList(String domain,String id){
		return String.format(AGENT_ORDER_INCIDENTS_LIST, domain,id);
	}
	
	
	/**
	 * 删除多个工单
	 * 调用权限：管理员
	 * DELETE请求
	 * @param domain
	 * @return
	 */
	public static String deleteManyOrders(String domain){
		
		return String.format(AGENT_DELETE_MANY_ORDERS, domain);
	}
	
	
	/**
	 * 删除工单
	 * DELETE请求
	 * 调用权限：管理员
	 * @param domain 平台地址
	 * @param id 工单id
	 * @return
	 */
	public static String deleteOrder(String domain,String id){
		
		return  String.format(AGENT_DELETE_ORDER, domain,id);
	}
	
	/**
	 * 更新多个工单，一次操作最多更新100个工单
	 * PUT请求
	 * 调用权限：客服
	 * @param domain 平台地址
	 * @return
	 */
	public static String updateManyOrders(String domain){
		
		return  String.format(AGENT_UPDATE_MANY_ORDERS, domain);
	}
	
	
	
	/**
	 * 获取当前用户所有的工单列表
	 * GET请求
	 * 调用权限：admin
	 * @param domain 云客服平台地址
	 * @return
	 */
	public static String getOrderList(String domain){
	
		return String.format(AGENT_ORDER_LIST, domain);
	}
	/**
	 * 查看指定客服的受理工单列表
	 * 调用权限：admin
	 * @param domain 平台地址
	 * @param assignee_id 受理客服id
	 * @return
	 */
	public static String getOrderListWithID(String domain,String assignee_id){
		
		return String.format(AGENT_ORDER_LIST_WITH_ID, domain,assignee_id);
	}
	/**
	 * 查看工单
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param id 工单id
	 * @return
	 */
	public static String getOrderDetailByAgent(String domain,String id){
		
		return String.format(AGENT_ORDER_DETAILS, domain,id);
	}
	
	/**
	 * 查看多个工单，最多返回100条数据
	 * GET请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param num 工单数量
	 * @return
	 */
	public static String getAgentManyOrder(String domain){
		
		return String.format(AGENT_MANY_ORDER, domain);
	}
	
	/**
	 * 创建工单
	 * POST请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @return
	 */
	public static String createOrder(String domain){
		return String.format(AGENT_CREATE_ORDER, domain);
	}
	
	/**
	 * 更新工单
	 * PUT请求
	 * 调用权限：agent
	 * @param domain 平台地址
	 * @param id 工单id
	 * @return
	 */
	public static String updateOrder(String domain,String id){
		return String.format(AGENT_UPDATE_ORDER, domain,id);
	}

}
