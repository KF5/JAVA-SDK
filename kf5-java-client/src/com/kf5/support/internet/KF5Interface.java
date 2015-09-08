package com.kf5.support.internet;

public class KF5Interface {

	private final static String SERVER = "https://%1$s";
	
	/**
	 * �������ͷ�����ؽӿ�
	 */
	//�����б�
	private final static String AGENT_ORDER_LIST = SERVER+"/apiv2/tickets.json";
	//ָ���ͷ�����Ĺ����б�
	private final static String AGENT_ORDER_LIST_WITH_ID = SERVER+"/apiv2/users/%2$s/tickets.json";
	//�鿴����
	private final static String AGENT_ORDER_DETAILS = SERVER+"/apiv2/tickets/%2$s.json";
	//�鿴�����������෵��100������
	private final static String AGENT_MANY_ORDER = SERVER +"/apiv2/tickets/show_many.json?ids=";
	//��������
	private final static String AGENT_CREATE_ORDER = SERVER +"/apiv2/tickets.json";
	//���¹���
	private final static String AGENT_UPDATE_ORDER = SERVER +"/apiv2/tickets/%2$s.json";
	//���¶������
	private final static String AGENT_UPDATE_MANY_ORDERS = SERVER +"/apiv2/tickets/update_many.json?ids=";
	//ɾ������
	private final static String AGENT_DELETE_ORDER = SERVER + "/apiv2/tickets/%2$s.json";
	//ɾ���������
	private final static String AGENT_DELETE_MANY_ORDERS = SERVER +"/apiv2/tickets/delete_many.json?ids=";
	//�����������������б�
	private final static String AGENT_ORDER_INCIDENTS_LIST = SERVER +"/apiv2/tickets/%2$s/incidents.json";
	//�������͵Ĺ����б�
	private final static String AGENT_ORDER_PROBLEM_LIST = SERVER +"/apiv2/tickets/problems.json";
	//�������õĸ����û�
	private final static String AGENT_ORDER_COLLABORATORS = SERVER +"/apiv2/tickets/%2$s/collaborators.json";
	
	/**
	 * ��������ͨ�û�����ؽӿ�
	 */
	
	//���������б�
	private final static String REQUEST_ORDER_LIST = SERVER +"/apiv2/requests.json";
	//״̬С���ѽ���Ĺ���
	private final static String REQUEST_ORDER_STATUS_OPEN = SERVER +"/apiv2/requests/open.json";
	//״̬Ϊ�ѽ�����ѹرյĹ���
	private final static String REQUEST_ORDER_STATUS_SOLVED = SERVER + "/apiv2/requests/solved.json";
	//��ȡָ���û��Ĺ�������
	private final static String REQUEST_ORDER_LIST_WITH_ID = SERVER + "/apiv2/users/%2$s/requests.json";
	//��ȡָ����˾��֯�Ĺ�������
	private final static String ORGANZIATION_ORDER_WITH_ID = SERVER + "/apiv2/organizations/%2$s/requests.json";
	//������������
	private final static String SERCH_ORDER = SERVER +"/apiv2/requests/search.json?";
	// �鿴��������
	private final static String REQUEST_VIEW_ORDER = SERVER + "/apiv2/requests/%2$s.json";
	//������������
	private final static String REQUEST_CREATE_ORDER = SERVER + "/apiv2/requests.json";
	//�ظ�����
	private final static String REQUESTER_REPLY_ORDER = SERVER +"/apiv2/requests/%2$s.json";
	//�����ظ��б�
	private final static String REQUESTER_COMMENT_LIST = SERVER + "/apiv2/requests/%2$s/comments.json";
	//�鿴ָ�������ظ�
	private final static String REQUESTER_COMMENT_WITH_ID = SERVER +"/apiv2/requests/%2$s/comments/%3$s.json";
	
	/**
	 * �����ظ��ӿ�
	 */
	//�����ظ��б�
	private final static String ORDER_COMMENT_LIST = SERVER +"/apiv2/tickets/%2$s/comments.json";
	
	/**
	 * �����Զ����ֶνӿ�
	 */
	
	//�����Զ����ֶ��б�
	private final static String TICKET_FIELD_LIST = SERVER +"/apiv2/ticket_fields.json";
	//��ȡ״̬Ϊ�������Զ����ֶ��б�
	private final static String TICKET_FIELD_LIST_ACTIVE = SERVER +"/apiv2/ticket_fields/active.json";
	//�鿴�Զ����ֶ�
	private final static String TICKET_FIELD_LIST_BY_ID = SERVER +"/apiv2/ticket_fields/%2$s.json";
	//ɾ���Զ����ֶ�
	private final static String DELETE_TICKET_FIELD = SERVER +"/apiv2/ticket_fields/%2$s.json";
	
	/**
	 * �����鿴����ӿ�
	 */

	//�����鿴�����б�
	private final static String VIEWS_ORDER_TYPE_LIST =SERVER+"/apiv2/views.json";
	//��ȡ���õĹ����鿴����
	private final static String VIEWS_ORDER_TYPE_ACTIVE = SERVER +"/apiv2/views/active.json";
	//��ȡָ���鿴����
	private final static String VIEW_ORDER_LIST_WITH_ID = SERVER+"/apiv2/views/%2$s.json";
	//��ȡָ���鿴������Ĺ���
	private final static String VIEW_TICKET_BY_ID = SERVER + "/apiv2/views/%2$s/tickets.json";
	//��ȡָ���鿴����Ĺ�������
	private final static String VIEW_TICKET_COUNT = SERVER +"/apiv2/views/%2$s/count.json";
	//��ȡ����鿴����Ĺ�������
	private final static String VIEW_MANY_TICKET_COUNT = SERVER +"/apiv2/views/count_many.json?ids=";
	
	/**
	 * �û��ӿ�
	 */
	//��ȡ�û��б�
	private final static String USER_LIST = SERVER + "/apiv2/users.json";
	//�鿴ָ���û���Ϣ
	private final static String USER_INFO = SERVER +"/apiv2/users/%2$s.json";
	//�鿴�Լ�����Ϣ
	private final static String INFO_OF_MINE = SERVER +"/apiv2/users/me.json";
	//��ȡ����û���Ϣ
	private final static String INFO_OF_MANY = SERVER +"/apiv2/users/show_many.json?ids=";
	//�����û���Ϣ
	private final static String CREATE_USER_INFO = SERVER + "/apiv2/users.json";
	//�ϲ��û�
	private final static String MERGE_USER = SERVER +"/apiv2/users/%2$s/merge.json";
	//�޸��û���Ϣ
	private final static String UPDATE_USER_INFO = SERVER +"/apiv2/users/%2$s.json";
	//ɾ���û�
	private final static String DELETE_USER = SERVER +"/apiv2/users/%2$s.json";
	//�����û�
	private final static String SEARCH_USER = SERVER + "/apiv2/users/search.json?query=";

	/**
	 * �û��Զ����ֶνӿ�
	 */
	
	//�û��Զ����ֶ��б�
	private final static String USER_FIELDS = SERVER +"/apiv2/user_fields.json";
	//��ȡ״̬Ϊ�������Զ�����ֶ��б�
	private final static String USER_FIELDS_ACTIVE = SERVER +"/apiv2/user_fields/active.json";
	//�鿴�û��Զ����ֶ�
	private final static String USER_FIELDS_BY_ID = SERVER +"/apiv2/user_fields/%2$s.json";
	//ɾ���û��Զ����ֶ�
	private final static String DELETE_USER_FIELDS = SERVER + "/apiv2/user_fields/%2$s.json";
	
	/**
	 * �ͷ���
	 */
	
	//�ͷ����б�
	private final static String GROUP_LIST = SERVER +"/apiv2/groups.json";
	//�鿴�ͷ���
	private final static String GROUP_LIST_BY_ID = SERVER+"/apiv2/groups/%2$s.json";
	//�����ͷ���
	private final static String CREATE_GROUP = SERVER +"/apiv2/groups.json";
	//�޸Ŀͷ���
	private final static String UPDATE_GROUP = SERVER +"/apiv2/groups/%2$s.json";
	//ɾ���ͷ���
	private final static String DELETE_GROUP = SERVER +"/apiv2/groups/%2$s.json";
	
	/**
	 * ��˾��֯�ӿ�
	 */
	//��˾��֯�б�
	private final static String ORGANIZATION_LIST = SERVER +"/apiv2/organizations.json";
	//�鿴��˾��֯
	private final static String VIEW_ORGANIZATION = SERVER +"/apiv2/organizations/%2$s.json";
	//������˾��֯
	private final static String CREATE_ORGANIZATION = SERVER +"/apiv2/organizations.json";
	//�޸Ĺ�˾��֯
	private final static String UPDATE_ORGANIZATION = SERVER + "/apiv2/organizations/%2$s.json";
	//ɾ����˾��֯
	private final static String DELETE_ORGANIZATION = SERVER +"/apiv2/organizations/%2$s.json";
	
	
	
	/**
	 * �ĵ������ӿ�
	 */
	//�ĵ������б�
	private final static String CATEGORIES_LIST = SERVER +"/apiv2/categories.json"; 
	//�鿴�ĵ�����
	private final static String CATEGORIES_LIST_WITH_ID = SERVER +"/apiv2/categories/%2$s.json";
	//�����ĵ�����
	private final static String CREATE_CATEGORY = SERVER +"/apiv2/categories.json";
	//�޸��ĵ�����
	private final static String UPDATE_CATEGORY = SERVER +"/apiv2/categories/%2$s.json";
	//ɾ���ĵ�����
	private final static String DELETE_CATEGORY = SERVER +"/apiv2/categories/%2$s.json";
	
	/**
	 * �ĵ�����ӿ�
	 */
	
	//�ĵ������б�
	private final static String FORUMS_LIST = SERVER +"/apiv2/forums.json";
	//�鿴�ĵ�����
	private final static String FORUMS_LIST_BY_ID = SERVER+"/apiv2/forums/%2$s.json";
	//�����ĵ�����
	private final static String CREATE_FORUM = SERVER +"/apiv2/forums.json";
	//�޸��ĵ�����
	private final static String UPDATE_FORUM = SERVER +"/apiv2/forums/%2$s.json";
	//ɾ���ĵ�����
	private final static String DELETE_FORUM = SERVER +"/apiv2/forums/%2$s.json";
	
	
	/**
	 * �ĵ��ӿ�
	 */
	//�ĵ��б�
	private final static String POST_LIST = SERVER+"/apiv2/posts.json";
	//�鿴�ĵ�
	private final static String POST_DETAIL = SERVER +"/apiv2/posts/%2$s.json";
	//�鿴����ĵ�
	private final static String POST_MANY = SERVER +"/apiv2/posts/show_many.json?ids=";
	//�����ĵ�
	private final static String SEARCH_POST = SERVER +"/apiv2/posts/search.json?query=";
	//�����ĵ�
	private final static String CREATE_POST = SERVER +"/apiv2/posts.json";
	//�޸��ĵ�
	private final static String UPDATE_POST = SERVER+"/apiv2/posts/%2$s.json";
	//ɾ���ĵ�
	private final static String DELETE_POST = SERVER +"/apiv2/posts/%2$s.json";
	//�ĵ��ظ��б�
	private final static String POST_COMMENT_LIST = SERVER + "/apiv2/posts/%2$s/comments.json";
	//�鿴ָ���ĵ��ظ�
	private final static String POST_COMMETN_BY_ID = SERVER +"/apiv2/posts/%2$s/comments/%3$s.json";
	//�ظ��ĵ�
	private final static String POST_REPLY = SERVER +"/apiv2/posts/%2$s/comments.json";
	
	/**
	 * ��������ӿ�
	 */
	
	//���������б�
	private final static String TOPIC_LIST = SERVER +"/apiv2/topics.json";
	//�鿴��������
	private final static String TOPIC_BY_ID = SERVER +"/apiv2/topics/%2$s.json";
	//������������
	private final static String TOPIC_CREATE = SERVER +"/apiv2/topics.json";
	//�޸���������
	private final static String TOPIC_UPDATE = SERVER +"/apiv2/topics/%2$s.json";
	//ɾ����������
	private final static String TOPIC_DELETE = SERVER +"/apiv2/topics/%2$s.json";
	
	/**
	 * ��������ӿ�
	 */
	//���������б�
	private final static String QUESTION_LIST =SERVER+"/apiv2/questions.json";
	//�鿴��������
	private final static String QUESTION_BY_ID = SERVER +"/apiv2/questions/%2$s.json";
	//������������
	private final static String QUESTION_CREATE = SERVER +"/apiv2/questions.json";
	//�޸���������
	private final static String QUESTION_UPDATE = SERVER +"/apiv2/questions/%2$s.json";
	//ɾ����������
	private final static String QUESTION_DELETE = SERVER +"/apiv2/questions/%2$s.json";
	//��������ظ��б�
	private final static String QUESTION_COMMENT_LIST = SERVER +"/apiv2/questions/%2$s/comments.json";
	//�鿴ָ����������ظ�
	private final static String QUESTION_COMMENT_BY_ID = SERVER +"/apiv2/questions/%2$s/comments/%3$s.json";
	//�ظ���������
	private final static String QUESTION_REPLY = SERVER +"/apiv2/questions/%2$s/comments.json";
	
	
	
	/**
	 * �����ӿ�
	 */
	
	//�ϴ�����
	private final static String ATTACHMENTS_UPLOAD = SERVER +"/apiv2/attachments.json?filename=%2$s";
	//�鿴����
	private final static String ATTACHMENT_VIEW = SERVER +"/apiv2/attachments/%2$s.json";
	//ɾ������
	private final static String ATTACHMENT_DELETE = SERVER +"/apiv2/attachments/%2$s.json";
	
	
	/**
	 * ����ӿ�
	 */
	
	//��������
	private final static String ORDER_IMPORT = SERVER +"/apiv2/imports/tickets.json";

	/**
	 * �����ӿ�
	 */
	
	private final static String ORDER_EXPORT = SERVER +"/apiv2/exports/tickets.json";
	
	
	
	/**
	 * �������õĸ����û�
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String getAgentOrderCollaborators(String domain,String id){
		
		return String.format(AGENT_ORDER_COLLABORATORS, domain,id);
	}
	
	
	
	/**
	 * ��������
	 * GET����
	 * ����Ȩ�ޣ�admin
	 * ���������start_time:�趨���󵼳��Ĺ�������ʱ��Ŀ�ʼ��(ʱ���)
	 * end_time:�趨���󵼳��Ĺ�������ʱ��Ľ�����(ʱ���)
	 * order��ID���� 'ASC' or 'DESC'
	 * ÿҳ��෵��500������
	 * ע�⣺��������start_time��Ĭ�ϵ���end_time֮ǰ�����Ĺ�����
	 * ��������end_time��Ĭ�ϵ�����start_time����ǰʱ���ڴ����Ĺ���;
	 * ��������order��Ĭ�ϵ���������ID�������С�
	 * urlʾ���� https://{subdomain}.kf5.com/apiv2/exports/tickets.json?start_time=1425698858
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String orderExport(String domain){
		return String.format(ORDER_EXPORT, domain);
	}
	
	/**
	 * ���빤��
	 * POST����
	 * ����Ȩ�ޣ�admin
	 * �����������Ϊ�����������ݣ���������ʱ��ѭ�����ýӿڡ�����ڵ���ʱ�������Է��㴦���������
	 * �����ڵ���ʱ����������ϵͳ����Ը�����������Ч
	 * ����ʱ�������ù�����created_at,updated_at��ʱ���ֶ�
	 * �������ù����ظ�comments�Ĵ���ʱ��created_at, ע��comments���ݱ������author_id,content�ֶ�ֵ
	 * ���ڵ���ǰȷ�Ϲ������ظ����漰���û�ȫ���������ƿͷ�ƽ̨����û������� �û��ӿ� Users API ���д���
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String importOrder(String domain){
		
		return String.format(ORDER_IMPORT, domain);
	}
	/**
	 * ɾ������
	 * DELETE����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String deleteAttachment(String domain,String id){
		return String.format(ATTACHMENT_DELETE, domain,id);
	}
	
	/**
	 * �鿴����
	 * ����Ȩ�ޣ�agent
	 * GET����
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String viewAttachment(String domain,String id){
		
		return String.format(ATTACHMENT_VIEW, domain,id);
	}
	
	/**
	 * �ϴ�����
	 * POST����
	 * ע�⣺��Ҫ��url�����filename���������ø����ļ������磺/apiv2/attachments.json?filename=test.jpg��
	 * ͬһ������ֻ�ܶ�Ӧһ��������һ�������ظ���һ���ĵ�
	 * ����header����Ҫ����"Content-Type: application/binary"
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String uploadAttachment(String domain,String filename){
		
		return String.format(ATTACHMENTS_UPLOAD, domain,filename);
	}
	

	/**
	 * �ظ���������
	 * PUT����
	 * ����Ȩ�ޣ�end user
	 * @param domain ƽ̨��ַ
	 * @param question_id ����id
	 * @return
	 */
	public static String replyQuestion(String domain,String question_id){
		return String.format(QUESTION_REPLY, domain,question_id);
	}
	
	/**
	 * �鿴ָ����������ظ�
	 * GET����
	 * ����Ȩ�ޣ�end user
	 * @param domain ƽ̨��ַ
	 * @param question_id ����id
	 * @param id �ظ�id
	 * @return
	 */
	public static String getQuestionCommentByID(String domain,String question_id,String id){
		return String.format(QUESTION_COMMENT_BY_ID, domain,question_id,id);
	}
	
	
	
	
	
	
	/**
	 * ��������ظ��б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param question_id ����id
	 * @return
	 */
	public static String getQuestionCommentList(String domain,String question_id){
		
		return String.format(QUESTION_COMMENT_LIST, domain,question_id);
		
	}
	
	
	/**
	 * ɾ����������
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain
	 * @param question_id
	 * @return
	 */
	public static String deleteQuestion(String domain,String question_id){
		
		return String.format(QUESTION_DELETE, domain,question_id);
	}
	
	
	/**
	 * �޸���������
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain
	 * @param question_id
	 * @return
	 */
	public static String updateQuestion(String domain,String question_id){
		
		return String.format(QUESTION_UPDATE, domain,question_id);
	}
	
	/**
	 * ������������
	 * POST����
	 * ����Ȩ�ޣ�all
	 * @param domain
	 * @return
	 */
	public static String createQuestion(String domain){
		
		return String.format(QUESTION_CREATE, domain);
	}
	
	
	/**
	 * �鿴��������
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param question_id ����id
	 * @return
	 */
	public static String getQuestionByID(String domain,String question_id){
		return String.format(QUESTION_BY_ID, domain,question_id);
	}
	
	
	/**
	 * ���������б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain
	 * @return
	 */
	public static String getQuestionList(String domain){
		
		return String.format(QUESTION_LIST, domain);
	}
	
	/**
	 * ɾ����������
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param topic_id ����id
	 * @return
	 */
	public static String deleteTopic(String domain,String topic_id){
		return String.format(TOPIC_DELETE, domain,topic_id);
	}
	
	
	/**
	 * �޸���������
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param topic_id ����id
	 * @return 
	 */
	public static String updateTopic(String domain,String topic_id){
		return String.format(TOPIC_UPDATE, domain,topic_id);
	}
	
	
	/**
	 * ������������
	 * POST����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createTopic(String domain){
		

		return String.format(TOPIC_CREATE, domain);
		
		
	}
	
	
	/**
	 * �鿴��������
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain
	 * @param topic_id
	 * @return
	 */
	public static String getTopicByID(String domain,String topic_id){
		
		return String.format(TOPIC_BY_ID, domain,topic_id);
	}
	
	/**
	 * ���������б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getTopicList(String domain){
		return String.format(TOPIC_LIST, domain);
	}
	
	/**
	 * �ظ��ĵ�
	 * POST����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param post_id �ĵ�id
	 * @return
	 */
	public static String postReply(String domain,String post_id){
		
		return String.format(POST_REPLY, domain,post_id);
	}
	
	
	/**
	 * �鿴ָ���ĵ��ظ�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param post_id �ĵ�id
	 * @param id �ظ�id
	 * @return
	 */
	public static String getPostCommentByID(String domain,String post_id,String id){
		
		return String.format(POST_COMMETN_BY_ID, domain,post_id,id);
	}
	
	
	
	/**
	 * �ĵ��ظ��б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param post_id �ĵ�id
	 * @return
	 */
	public static String getPostCommentList(String domain,String post_id){
		return String.format(POST_COMMENT_LIST, domain,post_id);
	}
	
	/**
	 * ɾ���ĵ�
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param post_id �ĵ�id
	 * @return
	 */
	public static String deletePost(String domain,String post_id){
		return String.format(DELETE_POST, domain,post_id);
	}
	
	/**
	 * �޸��ĵ�
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param post_id �ĵ�id
	 * @return
	 */
	public static String updatePost(String domain,String post_id){
		
		return String.format(UPDATE_POST, domain,post_id);
	}
	
	
	/**
	 * �����ĵ�
	 * POST����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createPost(String domain){
		return String.format(CREATE_POST, domain);
	}
	
	
	/**
	 * �����ĵ�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domainƽ̨��ַ
	 * @param key_word �����ؼ���
	 * @return
	 */
	public static String searchPost(String domain,String key_word){
		return String.format(SEARCH_POST, domain)+key_word;
	}
	
	/**
	 * �鿴����ĵ�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param posts_id ����ĵ�id;��ʽΪ��1,2,3
	 * @return
	 */
	public static String getManyPosts(String domain,String posts_id){
		
		return String.format(POST_MANY, domain)+posts_id;
	}
	
	/**
	 * �鿴�ĵ�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param post_id �ĵ�id
	 * @return 
	 */
	public static String getPostDetail(String domain,String post_id){
		return String.format(POST_DETAIL, domain,post_id);
	}
	
	/**
	 * ��ȡ�ĵ��б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getPostList(String domain){
		
		return String.format(POST_LIST, domain);
	}
	
	
	/**
	 * ɾ���ĵ�����
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain
	 * @param forum_id
	 * @return
	 */
	public static String deleteForum(String domain,String forum_id){
		return String.format(DELETE_FORUM, domain,forum_id);
	}
	
	
	/**
	 * �޸��ĵ�����
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param forum_id �ĵ�����id
	 * @return
	 */
	public static String updateForum(String domain,String forum_id){
		
		return String.format(UPDATE_FORUM, domain,forum_id);
	}
	
	
	/**
	 * �����ĵ�����
	 * POST����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createForum(String domain){
		
		return String.format(CREATE_FORUM, domain);
	}
	
	/**
	 * �鿴�ĵ�����
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param forum_id �ĵ�����id
	 * @return
	 */
	public static String getForumByID(String domain,String forum_id){
		return String.format(FORUMS_LIST_BY_ID, domain,forum_id);
	}
	
	/**
	 * ��ȡ�ĵ������б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain
	 * @return
	 */
	public static String getForumList(String domain){
		return String.format(FORUMS_LIST, domain);
	}
	
	/**
	 * ɾ���ĵ�����
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param category_id �ĵ�����id
	 * @return
	 */
	public static String deleteCategory(String domain,String category_id){
		return String.format(DELETE_CATEGORY, domain,category_id);
	}
	
	
	/**
	 * �޸��ĵ�����
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param category_id �ĵ�����id
 	 * @return
	 */
	public static String updateCategory(String domain,String category_id){
		
		return String.format(UPDATE_CATEGORY, domain,category_id);
	}
	
	
	/**
	 * �����ĵ�����
	 * POST����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createCategory(String domain){
		return String.format(CREATE_CATEGORY, domain);
	}
	
	/**
	 * �鿴�ĵ�����
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @param category_id ����id
	 * @return
	 */
	public static String getCategoryByID(String domain,String category_id){
		return String.format(CATEGORIES_LIST_WITH_ID, domain,category_id);
	}
	
	/**
	 * ��ȡ�ĵ������б�
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getCategoriesList(String domain){
		
		return String.format(CATEGORIES_LIST, domain);
	}
	
	
	
	
	/**
	 * ɾ����˾��֯
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param organization_id ��˾��֯id
	 * @return
	 */
	public static String deleteOrganization(String domain,String organization_id){
		
		return String.format(DELETE_ORGANIZATION, domain,organization_id);
		
	}
	
	
	/**
	 * �޸Ĺ�˾��֯
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param organization_id ��˾��֯id
	 * @return
	 */
	public static String updateOrganization(String domain,String organization_id){
		
		return String.format(UPDATE_ORGANIZATION, domain,organization_id);
	}
	
	
	/**
	 * ������˾��֯
	 * POST����ʽ
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createOrganization(String domain){
		
		return String.format(CREATE_ORGANIZATION, domain);
		
	}
	
	/**
	 * �鿴��˾��֯
	 * GET����
	 * ����Ȩ�ޣ�agents
	 * @param domain ƽ̨��ַ
	 * @param organization_id ��˾��֯id
	 * @return
	 */
	public static String getOrganizationByID(String domain,String organization_id){
		
		return String.format(VIEW_ORGANIZATION, domain,organization_id);
		
	}
	
	/**
	 * ��˾��֯�б�
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getOrganizationList(String domain){
		
		return String.format(ORGANIZATION_LIST, domain);
	}
	
	/**
	 * ɾ���ͷ���
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
 	 * @param group_id �ͷ���id
	 * @return
	 */
	public static String deleteGroup(String domain,String group_id){
		
		return String.format(DELETE_GROUP, domain,group_id);
		
	}
	
	
	/**
	 * �޸Ŀͷ���
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param group_id �ͷ���id
	 * @return
	 */
	public static String updateGroup(String domain,String group_id){
		
		return String.format(UPDATE_GROUP, domain,group_id);
		
	}
	
	
	
	/**
	 * �����ͷ���
	 * POST����
	 * ����Ȩ�ޣ�admin
	 * @param domain
	 * @return
	 */
	public static String createGroup(String domain){
		return String.format(CREATE_GROUP, domain);
	}
	
	/**
	 * �鿴�ͷ���
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param group_id �ͷ���id
	 * @return
	 */
	public static String getGroupListByID(String domain,String group_id){
		
		return String.format(GROUP_LIST_BY_ID, domain,group_id);
		
	}
	
	
	/**
	 * �ͷ����б�
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getGroupList(String domain){
		
		return String.format(GROUP_LIST, domain);
	}
	
	
	/**
	 * ɾ���û��Զ����ֶ�
	 * DELETE�ֶ�
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param id �ֶ�id
	 * @return
	 */
	public static String deleteUserField(String domain,String id){
		
		return String.format(DELETE_USER_FIELDS, domain,id);
	}
	
	
	/**
	 * �鿴�û��Զ����ֶ�
	 * GET����
	 * ����Ȩ�ޣ�agents
	 * @param domain ƽ̨��ַ
	 * @param id �ֶ�id
	 * @return
	 */
	public static String getUserFieldListByID(String domain,String id){
		
		return String.format(USER_FIELDS_BY_ID, domain,id);
	}
	
	
	/**
	 * ��ȡ״̬Ϊ���õ��Զ����ֶ��б�
	 * GET����
	 * ����Ȩ�ޣ�agents
	 * @param domain
	 * @return
	 */
	public static String getUserFieldActiveList(String domain){
		return String.format(USER_FIELDS_ACTIVE, domain);
	}
	
	
	/**
	 * ��ȡ�Զ����ֶ��б�
	 * GET����
	 * ����Ȩ�ޣ�agents
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getUserFieldList(String domain){
		return String.format(USER_FIELDS, domain);
	}
	
	/**
	 * �����û�
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String searchUser(String domain){
		return String.format(SEARCH_USER, domain);
	}
	
	/**
	 * ɾ���û�
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param user_id �û�id
	 * @return
	 */
	public static String deleteUser(String domain,String user_id){
		return String.format(DELETE_USER, domain,user_id);
	}
	
	/**
	 * �޸��û���Ϣ
	 * PUT����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param user_id �û�id
	 * @return
	 */
	public static String updateUserInfo(String domain,String user_id){
		return String.format(UPDATE_USER_INFO, domain,user_id);
	}
	
	/**
	 * �ϲ��û�
	 * PUT����
	 * ����Ȩ�ޣ�admin
	 * ע��URL��ָ��id���û������ᱻ�ϲ������ݲ�����id��������û��� ǰ�ߵ�����Ҳ��ϲ�Ϊ���ߵ����ݣ�֮��ǰ�߽��ᱻɾ���� ���ϲ����û���ֻ������ͨ�û���ɫ��
	 * @param domain
	 * @param user_id
	 * @return
	 */
	public static String mergeUser(String domain,String user_id){
		
		return String.format(MERGE_USER, domain,user_id);
	}
	
	
	/**
	 * �����û���Ϣ
	 * POST����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createUserInfo(String domain){
		return String.format(CREATE_USER_INFO, domain);
	}
	
	
	/**
	 *��ȡ����û���Ϣ
	 *GET����
	 *����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getManyUsersInfo(String domain){
		return String.format(INFO_OF_MANY, domain);
	}
	
	/**
	 * �鿴�Լ�����Ϣ
	 * GET����
	 * ����Ȩ�ޣ�all
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getMyInfo(String domain){
		
		return String.format(INFO_OF_MINE, domain);
	}
	
	
	/**
	 * �鿴ָ���û���Ϣ
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param user_id �û�id
	 * @return
	 */
	public static String getUserInfo(String domain,String user_id){
		return String.format(USER_INFO, domain,user_id);
	}
	
	/**
	 * ��ȡ�û��б�
	 * GET����
	 * ����Ȩ�ޣ� agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getUserList(String domain){
		
		return String.format(USER_LIST, domain);
	}
	
	/**
	 * ��ȡ����鿴����Ĺ�������
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getManyTicketCountByTypeIds(String domain){
		return String.format(VIEW_MANY_TICKET_COUNT, domain);
	}
	
	/**
	 * ��ȡָ���鿴����Ĺ�������
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param type_id ����id
	 * @return
	 */
	public static String getTicketCountByTypeID(String domain,String type_id){
		
		return String.format(VIEW_TICKET_COUNT, domain,type_id);
	}
	
	
	/**
	 * ��ȡָ���鿴������Ĺ���
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param type_id ����id
	 * @return
	 */
	public static String getTicketListByTypeID(String domain,String type_id){
		
		return String.format(VIEW_TICKET_BY_ID, domain,type_id);
	}
	
	
	/**
	 * ��ȡָ���鿴����
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param id 
	 * @return
	 */
	public static String getOrderTypeListByID(String domain,String id){
		return String.format(VIEW_ORDER_LIST_WITH_ID, domain,id);
	}
	
	/**
	 * ��ȡ��ǰ�ͻ����õĹ����鿴����
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getOrderTypeListActive(String domain){
		
		return String.format(VIEWS_ORDER_TYPE_ACTIVE, domain);
	}
	
	/**
	 * ��ȡ��ǰ�ͻ��Ĺ����鿴����
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getOrderTypeList(String domain){
		return String.format(VIEWS_ORDER_TYPE_LIST, domain);
	}
	
	
	/**
	 * ɾ���Զ����ֶ�
	 * DELETE����
	 * ����Ȩ�ޣ�admin
	 * @param domain
	 * @param ticket_field_id
	 * @return
	 */
	public static String deleteTicketFieldByID(String domain,String ticket_field_id){
		
		return String.format(DELETE_TICKET_FIELD, domain,ticket_field_id);
	}
	
	/**
	 * �鿴�Զ����ֶ�
	 * GET����
	 * ����Ȩ�ޣ�agents
	 * @param domain ƽ̨��ַ
	 * @param ticket_field_id �Զ����ֶ�id
	 * @return
	 */
	public static String getTicketFieldByID(String domain,String ticket_field_id){
		
		return String.format(TICKET_FIELD_LIST_BY_ID, domain,ticket_field_id);
	}
	
	
	/**
	 * ��ȡ״̬Ϊ�������Զ����ֶ��б�
	 * GET����ʽ
	 * ����Ȩ�ޣ�agents
	 * @param domain
	 * @return
	 */
	public static String getTicketFieldListActive(String domain){
		
		return String.format(TICKET_FIELD_LIST_ACTIVE, domain);
	}
	
	/**
	 * ��ȡ�����Զ����ֶ��б�
	 * GET����
	 * ����Ȩ�ޣ�agents
	 * @param domain
	 * @return
	 */
	public static String getTicketFieldList(String domain){
		
		return String.format(TICKET_FIELD_LIST, domain);
		
	}
	
	
	/**
	 * ��ȡ�����ظ��б�
	 * GET����
	 * ����Ȩ�ޣ��ͷ�
	 * @param domain ƽ̨��ַ
	 * @param ticket_id ����id
	 * @return
	 */
	public static String getOrderCommentList(String domain,String ticket_id){
		
		return String.format(ORDER_COMMENT_LIST, domain,ticket_id);
	}
	
	
	
	/**
	 * �鿴ָ���Ĺ����ظ�
	 * ����Ȩ�ޣ���ͨ�û�
	 * GET����
	 * @param domain ƽ̨��ַ
	 * @param requester_id ����������id
	 * @param id �ظ�id
	 * @return
	 */
	public static String getOrderCommentWithID(String domain,String requester_id,String id){
		return String.format(REQUESTER_COMMENT_WITH_ID, domain,requester_id,id);
	}
	
	
	/**
	 * ��ȡ�����ظ��б�
	 * GET����
	 * ����Ȩ�ޣ���ͨ�û�
	 * ������ʱ�����򣬿���������������sort_order:������򣬿�ѡֵ��asc��desc��Ĭ��Ϊasc����
	 * @param domain ƽ̨��ַ
	 * @param order_id ����id
	 * @return
	 */
	public static String getCommentListByEndUser(String domain,String order_id){
		return String.format(REQUESTER_COMMENT_LIST, domain,order_id);
	}
	
	
	/**
	 * �ظ�����
	 * ����Ȩ�ޣ� ��ͨ�û�
	 * PUT����
	 * @param domain ƽ̨��ַ
	 * @param order_id ����id
	 * @return
	 */
	public static String replyOrderByEndUser(String domain,String order_id){

		return String.format(REQUESTER_REPLY_ORDER, domain,order_id);
	}
	
	
	/**
	 * ������������
	 * POST����
	 * ����Ȩ�ޣ���ͨ�û�
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createOrderByRequester(String domain){
		
		return String.format(REQUEST_CREATE_ORDER, domain);
	
	}
	
	
	
	/**
	 * �鿴��������
	 * ����Ȩ�ޣ���ͨ�û�
	 * GET����
	 * @param domain
	 * @param id
	 * @return
	 */
	public static String getOrderDetailByRequester(String domain,String id){
		
		return String.format(REQUEST_VIEW_ORDER, domain,id);
	}
	
	/**
	 * ������������
	 * ����Ȩ�ޣ���ͨ�û�
	 * GET����
	 * ���������query����ѯ�ؼ��ʣ�ģ����ѯ����ֶΣ�status��״̬ɸѡ������fieldvalue:�Զ����ֶ�������
	 * @param domain
	 * @return
	 */
	public static String searchOrder(String domain){
		return String.format(SERCH_ORDER, domain);
	}
	

	/**
	 * ��ȡָ����˾��֯�Ĺ�������
	 * ����Ȩ�ޣ��ͷ�
	 * GET����
	 * @param domain ƽ̨��ַ
	 * @param organization_id ��˾��֯id
	 * @return
	 */
	public static String getOrganizationOrderList(String domain,String organization_id){
		
		return String.format(ORGANZIATION_ORDER_WITH_ID, domain,organization_id);
	}
	
	/**
	 * ��ȡָ���û��Ĺ�������
	 * ����Ȩ�ޣ��ͷ�
	 * GET����
	 * @param domain ƽ̨��ַ
	 * @param endUserId �û�id
	 * @return
	 */
	public static String getRequesterOrderListByID(String domain,String endUserId){
		
		return String.format(REQUEST_ORDER_LIST_WITH_ID, domain,endUserId);
	}
	
	
	/**
	 * ��ȡ״̬Ϊ�ѽ�����ѹرյĹ���
	 * GET����
	 * ����Ȩ�ޣ���ͨ�û�
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getRequesterOrderListStatusSolved(String domain){
		return String.format(REQUEST_ORDER_STATUS_SOLVED, domain);
	}
	
	
	/**
	 * ��ȡ״̬С���ѽ���Ĺ���
	 * GET����
	 * ����Ȩ�ޣ���ͨ�û�
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getRequesterOrderListStatusOpen(String domain){
		
		return String.format(REQUEST_ORDER_STATUS_OPEN, domain);
	}
	
	
	/**
	 * ���������б�
	 * GET����
	 * ����Ȩ�ޣ���ͨ�û�
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getRequesterOrderList(String domain){
		return String.format(REQUEST_ORDER_LIST, domain);
	}
	
	
	/**
	 * �������͵Ĺ����б�
	 * GET����
	 * ����Ȩ�ޣ��ͷ�
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String getProblemOrderList(String domain){
		return String.format(AGENT_ORDER_PROBLEM_LIST, domain);
	}
	
	
	/**
	 * �����������������б�
	 * ����Ȩ�ޣ��ͷ�
	 * GET����
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String getAgentOrderIncidentList(String domain,String id){
		return String.format(AGENT_ORDER_INCIDENTS_LIST, domain,id);
	}
	
	
	/**
	 * ɾ���������
	 * ����Ȩ�ޣ�����Ա
	 * DELETE����
	 * @param domain
	 * @return
	 */
	public static String deleteManyOrders(String domain){
		
		return String.format(AGENT_DELETE_MANY_ORDERS, domain);
	}
	
	
	/**
	 * ɾ������
	 * DELETE����
	 * ����Ȩ�ޣ�����Ա
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String deleteOrder(String domain,String id){
		
		return  String.format(AGENT_DELETE_ORDER, domain,id);
	}
	
	/**
	 * ���¶��������һ�β���������100������
	 * PUT����
	 * ����Ȩ�ޣ��ͷ�
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String updateManyOrders(String domain){
		
		return  String.format(AGENT_UPDATE_MANY_ORDERS, domain);
	}
	
	
	
	/**
	 * ��ȡ��ǰ�û����еĹ����б�
	 * GET����
	 * ����Ȩ�ޣ�admin
	 * @param domain �ƿͷ�ƽ̨��ַ
	 * @return
	 */
	public static String getOrderList(String domain){
	
		return String.format(AGENT_ORDER_LIST, domain);
	}
	/**
	 * �鿴ָ���ͷ����������б�
	 * ����Ȩ�ޣ�admin
	 * @param domain ƽ̨��ַ
	 * @param assignee_id ����ͷ�id
	 * @return
	 */
	public static String getOrderListWithID(String domain,String assignee_id){
		
		return String.format(AGENT_ORDER_LIST_WITH_ID, domain,assignee_id);
	}
	/**
	 * �鿴����
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String getOrderDetailByAgent(String domain,String id){
		
		return String.format(AGENT_ORDER_DETAILS, domain,id);
	}
	
	/**
	 * �鿴�����������෵��100������
	 * GET����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param num ��������
	 * @return
	 */
	public static String getAgentManyOrder(String domain){
		
		return String.format(AGENT_MANY_ORDER, domain);
	}
	
	/**
	 * ��������
	 * POST����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @return
	 */
	public static String createOrder(String domain){
		return String.format(AGENT_CREATE_ORDER, domain);
	}
	
	/**
	 * ���¹���
	 * PUT����
	 * ����Ȩ�ޣ�agent
	 * @param domain ƽ̨��ַ
	 * @param id ����id
	 * @return
	 */
	public static String updateOrder(String domain,String id){
		return String.format(AGENT_UPDATE_ORDER, domain,id);
	}

}
