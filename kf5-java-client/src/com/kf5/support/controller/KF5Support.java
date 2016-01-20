package com.kf5.support.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.kf5.support.internet.HttpRequest;
import com.kf5.support.internet.KF5Interface;
import com.kf5.support.model.Attachment;
import com.kf5.support.model.Category;
import com.kf5.support.model.Comment;
import com.kf5.support.model.Forum;
import com.kf5.support.model.Group;
import com.kf5.support.model.KF5Fields;
import com.kf5.support.model.MessageStatus;
import com.kf5.support.model.Organization;
import com.kf5.support.model.Post;
import com.kf5.support.model.PostComment;
import com.kf5.support.model.Question;
import com.kf5.support.model.QuestionComment;
import com.kf5.support.model.Requester;
import com.kf5.support.model.StatusCode;
import com.kf5.support.model.Ticket;
import com.kf5.support.model.TicketField;
import com.kf5.support.model.Topic;
import com.kf5.support.model.User;
import com.kf5.support.model.UserField;
import com.kf5.support.model.View;
import com.kf5.support.model.ViewCount;
import com.kf5.support.model.builder.EntityBuilder;
import com.kf5.support.model.builder.KF5EntityBuilder;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
/**
 * 
 * @author chosen
 *
 * @version 创建时间：2015年8月31日  上午11:43:59
 */
public class KF5Support{

	private String domain;

	private String username;

	private  String password;

	private  String token;

	private String baseToken;

	/**
	 * 使用邮箱和密码进行验证
	 * @param domain 平台地址
	 * @param username 登录邮箱
	 * @param password 密码
	 */
	public void initWithPassword(String domain,String username,String password){
		this.domain = domain;
		this.username = username;
		this.password = password;
		String code = this.username+":"+this.password;
		this.baseToken =new String(Base64.getEncoder().encode(code.getBytes()));
	}
	/**
	 * 使用邮箱和平台开放api的通信秘钥进行验证
	 * @param domain 平台地址
	 * @param username 登录邮箱
	 * @param apiToken 通信秘钥，具体位置在：系统设置——>api接口——>通信秘钥
	 */
	public void initWithApiToken(String domain,String username,String apiToken){

		this.domain = domain ;
		this.username = username;
		this.token = apiToken;
		String code = this.username+"/token:"+this.token;
		this.baseToken = new String(Base64.getEncoder().encode(code.getBytes()));
	}



	/**
	 * 获取客服所有的工单列表
	 * @return
	 */
	public List<Ticket> getAgentOrderList(){

		List<Ticket> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			list = EntityBuilder.buildTicketList(jsonArray);
		}
		return list;
	}

	/**
	 * 获取指定客服受理的工单列表
	 * @param assignee_id 受理客服id
	 * @return
	 */
	public List<Ticket> getAgentOrderListWithID(String assignee_id){
		checkHasId(assignee_id);
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderListWithID(domain, assignee_id), baseToken);
		List<Ticket> tickets = null;
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			tickets = EntityBuilder.buildTicketList(jsonArray);
		}
		return tickets;
	}


	/**
	 * 查看工单(客服)详情
	 * @param id 工单id
	 * @return
	 */
	public Ticket getAgentTicketDetail(String order_id){
		checkHasId(order_id);
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderDetailByAgent(domain, order_id), baseToken);
		Ticket ticket = null;
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			ticket = EntityBuilder.buildTicket(EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET));
		}
		return ticket;
	}

	/**
	 * 查看(客服)多个工单，最多返回100条数据
	 * @param ids 参数格式为： 32，1，3
	 * 
	 * @return
	 */
	public List<Ticket> getAgentManyTickets(String ids){
		checkHasId(ids);
		List<Ticket> tickets = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getAgentManyOrder(domain)+ids, baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			tickets = EntityBuilder.buildTicketList(jsonArray);
		}
		return tickets;
	}

	/**
	 * 创建工单
	 * 调用权限：客服
	 * @param jsonString 参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/tickets/中创建工单参数示例
	 * 
	 */
	public Ticket createAgentOrder(String jsonString){
		Ticket ticket = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createOrder(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				ticket = EntityBuilder.buildTicket(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			throw new JSONException(jsonString+"cannot be converted to jsonobject");
		}
		return ticket;
	}


	/**
	 * 更新工单
	 * 调用权限：agent
	 * @param order_id 工单id
	 * @param jsonString 更新内容 参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/tickets/中更新工单参数示例
	 * @return
	 */
	public Ticket updateAgentOrder(String order_id,String jsonString){
		checkHasId(order_id);
		Ticket ticket = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateOrder(domain, order_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				ticket = EntityBuilder.buildTicket(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			throw new JSONException(jsonString+"cannot be converted to jsonobject");
		}
		return ticket;
	}


	/**
	 * 更新多个工单（批量更新）
	 * 调用权限：agent
	 * @param ids 工单所对应的id，参数格式为1，2，3
	 * @param jsonString 更新内容，参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/tickets/中更新多个工单参数示例
	 */
	public void updateManyAgentOrder(String ids,String jsonString){
		checkHasId(ids);
		try {
			HttpRequest.sendPutRequest(KF5Interface.updateManyOrders(domain)+ids, baseToken, JSONObject.fromObject(jsonString).toString());
		} catch (JSONException e) {
			// TODO: handle exception
			throw new JSONException(jsonString+"cannot be converted to jsonobject");
		}
	}


	/**
	 * 删除某个工单
	 * 调用权限：admin
	 * @param id 工单id
	 */
	public void deleteAgentOrder(String id){
		checkHasId(id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteOrder(domain, id), baseToken);
	}

	/**
	 * 批量删除工单
	 * 调用权限：admin
	 * @param ids 批量删除的工单id，参数格式为：1,2,3,4
	 */
	public void deleteManyAgentOrders(String ids){
		checkHasId(ids);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteManyOrders(domain)+ids, baseToken);
	}

	/**
	 * 获取工单可用的副本用户
	 * 调用权限：agent
	 * @param order_id 工单id
	 */
	public List<User> getAgentOrderCollaborators(String order_id){
		checkHasId(order_id);
		List<User> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getAgentOrderCollaborators(domain, order_id),baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject,KF5Fields.USERS);
			list = EntityBuilder.buildUsers(jsonArray);
		}
		return list;
	}



	/**
	 * 获取工单被关联的事物列表
	 * 调用权限：agent
	 * @param order_id 工单id
	 */
	public List<Ticket> getAgentOrderIncidentList(String order_id){
		checkHasId(order_id);
		List<Ticket> tickets = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getAgentOrderIncidentList(domain, order_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			tickets = EntityBuilder.buildTicketList(jsonArray);
		}
		return tickets;
	}

	/**
	 * 获取故障类型的工单列表
	 * 调用权限：agent
	 * @return
	 */
	public List<Ticket> getAgentOrderProblemList(){

		List<Ticket> tickets = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getProblemOrderList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			tickets = EntityBuilder.buildTicketList(jsonArray);
		}
		return tickets;
	}



	/**
	 * 获取当前用户的工单请求列表，即发起人为当前用户的工单,默认按工单编号升序排列
	 * 调用权限：end_user
	 * @return
	 */
	public List<Requester> getRequesterOrderList(){

		List<Requester> requesters = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getRequesterOrderList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			requesters = EntityBuilder.buildRequesters(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return requesters;
	}


	/**
	 * 获取状态小于已解决的工单
	 * 调用权限：end_user
	 * @return
	 */
	public List<Requester> getRequesterOrderListStatusOpen(){

		List<Requester> requesters = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getRequesterOrderListStatusOpen(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			requesters = EntityBuilder.buildRequesters(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return requesters;
	}


	/**
	 * 获取状态为已解决和已关闭的工单
	 * 调用权限：end_user
	 * @return
	 */
	public List<Requester> getRequesterOrderListStatusSolved(){

		List<Requester> requesters = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getRequesterOrderListStatusOpen(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			requesters = EntityBuilder.buildRequesters(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return requesters;
	}

	/**
	 * 获取用户的工单请求
	 * 调用权限：agent
	 * @param user_id 用户id
	 * @return
	 */
	public List<Ticket> getRequesterOrderListByID(String user_id){

		checkHasId(user_id);
		List<Ticket> tickets = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getRequesterOrderListByID(domain,user_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			tickets = EntityBuilder.buildTicketList(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return tickets;
	}

	/**
	 * 获取指定用户的工单请求
	 * 调用权限：agent
	 * @param organization_id 公司组织id
	 * @return
	 */
	public List<Requester> getOrganizationOrderList(String organization_id){

		checkHasId(organization_id);
		List<Requester> requesters = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrganizationOrderList(domain,organization_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			requesters = EntityBuilder.buildRequesters(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return requesters;
	}



	/**
	 * 搜索工单请求
	 * 调用权限：end_user
	 * query:查询关键词，模糊查询多个字段
	 * status：状态筛选条件
	 * fieldvalue：自定义字段条件
	 * @param keys
	 */
	public List<Requester> searchOrderByEndUser(String keys){

		List<Requester> requesters = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.searchOrder(domain)+keys, baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			requesters = EntityBuilder.buildRequesters(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return requesters;

	}


	/**
	 * 查看工单详情
	 * 调用权限：end_user
	 * @param order_id 工单id
	 * @return
	 */
	public Requester getOrderDetailByEndUser(String order_id){

		checkHasId(order_id);
		Requester requester = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderDetailByRequester(domain, order_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			requester = EntityBuilder.buildRequester(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.REQUEST));
		}
		return requester;
	}


	/**
	 * 创建工单请求
	 * 调用权限：end_user
	 * @param jsonString 参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/requests/中创建工单参数示例
	 * @return
	 */
	public Requester createOrderByEndUser(String jsonString){

		Requester requester = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createOrderByRequester(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				requester = EntityBuilder.buildRequester(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.REQUEST));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return requester;

	}


	/**
	 * 回复工单
	 * 调用权限：end_user
	 * @param order_id 工单id
	 * @param jsonString 参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/requests/中回复工单参数示例
	 * @return
	 */
	public Requester replyOrderByEndUser(String order_id,String jsonString){
		checkHasId(order_id);
		Requester requester = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.replyOrderByEndUser(domain,order_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				requester = EntityBuilder.buildRequester(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.REQUEST));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return requester;

	}

	/**
	 * 查看工单回复列表
	 * 调用权限：end_user
	 * @param order_id 工单id
	 */
	public List<Comment> getCommentListByEndUser(String order_id){

		checkHasId(order_id);
		List<Comment> comments = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getCommentListByEndUser(domain, order_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.COMMENTS);
			comments = EntityBuilder.buildComments(jsonArray);
//			for (int i = 0; i < comments.size(); i++) {
//				Comment comment = comments.get(i);
//				List<Attachment> attachments = comment.getListAttachments();
//				for (int j = 0; j < attachments.size(); j++) {
//					System.out.println(attachments.get(j).getContent_url());
//				}
//			}
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return comments;
	}


	/**
	 * 查看指定工单回复
	 * 调用权限 ：end_user
	 * @param requester_id 工单发起人id
	 * @param id 回复id
	 */
	public Comment getOrderCommentWithID(String requester_id,String id){

		checkHasId(requester_id,id);
		Comment	comment = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderCommentWithID(domain, requester_id, id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			comment = EntityBuilder.buildComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.COMMENT));
		}
		return comment;
	}

	/**
	 * 工单回复列表
	 * 调用权限：agent
	 * @param order_id 工单id
	 */
	public List<Comment> getOrderCommentList(String order_id){

		checkHasId(order_id);
		List<Comment> comments = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderCommentList(domain,order_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.COMMENTS);
			comments = EntityBuilder.buildComments(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return comments;
	}

	/**
	 * 获取工单自定义字段列表
	 * 调用权限：agent
	 */
	public List<TicketField> getTicketFieldList(){

		List<TicketField> ticketFields = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTicketFieldList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKET_FIELDS);
			ticketFields = EntityBuilder.buildTicketFields(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return ticketFields;
	}


	/**
	 * 获取状态为启用的自定义字段列表
	 * @return
	 */
	public List<TicketField> getTicketFieldListActive(){

		List<TicketField> ticketFields = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTicketFieldListActive(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKET_FIELDS);
			ticketFields = EntityBuilder.buildTicketFields(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return  ticketFields;

	}


	/**
	 * 查看自定义字段
	 * 调用权限：agent
	 * @param ticket_field_id 自定义字段id
	 */
	public TicketField getTicketFieldByID(String ticket_field_id){

		checkHasId(ticket_field_id);
		TicketField ticketField = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTicketFieldByID(domain,ticket_field_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			ticketField = EntityBuilder.buildTicketField(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET_FIELD));
		}
		return ticketField;

	}

	/**
	 * 删除自定义字段
	 * 调用权限：admin
	 * @param ticket_field_id
	 */
	public void deleteTicketFieldByID(String ticket_field_id){

		checkHasId(ticket_field_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteTicketFieldByID(domain, ticket_field_id), baseToken);
	}



	/**
	 * 工单查看分类列表
	 * 调用权限：agent
	 */
	public List<View> getOrderTypeList(){

		List<View> views = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderTypeList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.VIEWS);
			views = EntityBuilder.buildViews(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return views;
	}

	/**
	 * 查看当前客服可用的工单查看分类
	 * 调用权限：agent
	 * @return
	 */
	public List<View> getOrderTypeListActive(){

		List<View> views = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderTypeListActive(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.VIEWS);
			views = EntityBuilder.buildViews(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return views;
	}


	/**
	 * 获取指定查看分类
	 * 调用权限：agent
	 * @param type_id 分类id
	 * @return
	 */
	public View getOrderTypeByID(String type_id){
		
		checkHasId(type_id);
		View view = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrderTypeListByID(domain,type_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			view = EntityBuilder.buildView(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.VIEW));
		}
		return view;
	}

	/**
	 * 获取指定查看分类里的工单
	 * 调用权限：agent
	 * @param type_id 分类id
	 */
	public List<Ticket> getTicketListByTypeID(String type_id){

		checkHasId(type_id);
		List<Ticket> tickets = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTicketListByTypeID(domain,type_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			tickets = EntityBuilder.buildTicketList(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			int next_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE);
			int previous_page = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return tickets;
	}

	/**
	 * 获取指定查看分类的工单个数
	 * 调用权限：agent
	 * @param type_id 分类id
	 */
	public ViewCount getTicketCountByTypeID(String type_id){

		checkHasId(type_id);
		ViewCount viewCount = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTicketCountByTypeID(domain,type_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			viewCount = EntityBuilder.buildViewCount(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.VIEW_COUNT));
		}
		return viewCount;
	}
	/**
	 * 获取多个查看分类的工单个数
	 * @param ids 多个分类id; 如：1,2,3,4
	 */
	public List<ViewCount> getManyTicketCountByTypeIds(String ids){

		checkHasId(ids);
		List<ViewCount> viewCounts = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getManyTicketCountByTypeIds(domain)+ids, baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.VIEW_COUNTS);
			viewCounts = EntityBuilder.buildViewCounts(jsonArray);
		}
		return viewCounts;
	}


	/**
	 * 获取用户列表
	 * 调用权限: agent
	 */
	public List<User> getUserList(){

		List<User> users = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getUserList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			users = EntityBuilder.buildUsers(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return users;
	}


	/**
	 * 查看指定用户信息
	 * @param user_id 用户id
	 * @return
	 */
	public User getUserInfo(String user_id){

		checkHasId(user_id);
		User user = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getUserInfo(domain,user_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			user = EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER));
		}
		return user;
	}

	/**
	 * 查看自己的信息
	 * 调用权限: all
	 * @return
	 */
	public User getMyInfo(){

		User user = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getMyInfo(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			user = EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER));
		}
		return user;
	}

	/**
	 * 获取多个用户信息
	 * 调用权限:agent
	 * @param user_ids 多个用户id；格式示例为：1,2,36,6
	 * @return
	 */
	public List<User> getManyUsersInfo(String user_ids){
		
		checkHasId(user_ids);
		List<User> users = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getManyUsersInfo(domain)+user_ids, baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			users = EntityBuilder.buildUsers(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return users;
	}


	/**
	 * 创建用户信息
	 * 调用权限:agent
	 * @param jsonString 参数格式为json字符串，具体示例请参考http://developer.kf5.com/restapi/users/中的创建用户信息
	 */
	public User createUserInfo(String jsonString){

		User user = null ;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createUserInfo(domain),baseToken,JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				user = EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}


	/**
	 * 合并用户
	 * 调用权限:admin
	 * @param user_id 被合并的用户id;
	 * @param jsonString 需要与之合并的用户内容，格式为json字符串格式。
	 * URL里指定id的用户，将会被合并到传递参数中id所代表的用户。 前者的数据也会合并为后者的数据，之后前者将会被删除。 被合并的用户，只能是普通用户角色。
	 */
	public User mergeUser(String user_id,String jsonString){

		checkHasId(user_id);
		User user = null; 
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.mergeUser(domain, user_id), baseToken,JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				user = EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}


	/**
	 * 修改用户信息
	 * 调用权限:agent
	 * @param user_id 用户id
	 * @param jsonString 修改内容 参数格式为json字符串，具体示例详见：http://developer.kf5.com/restapi/users/ 修改用户信息
	 */
	public User updateUserInfo(String user_id,String jsonString){

		checkHasId(user_id);
		User user = null; 
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateUserInfo(domain, user_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				user = EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 删除用户
	 * 调用权限:admin
	 * @param user_id 用户id
	 */
	public void deleteUser(String user_id){

		checkHasId(user_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteUser(domain, user_id), baseToken);
	}

	/**
	 * 搜索用户
	 * 调用权限:agent
	 * @param key 搜索关键字
	 * @return
	 */
	public List<User> searchUser(String key){

		List<User> users = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.searchUser(domain)+key, baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			users = EntityBuilder.buildUsers(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return users;
	}


	/**
	 * 获取用户自定义字段
	 * 调用权限:agent
	 * @return
	 */
	public List<UserField> getUserFieldList(){

		List<UserField> lists = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getUserFieldList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USER_FIELDS);
			lists = EntityBuilder.buildUserFields(jsonArray);
		}
		return lists;
	}


	/**
	 * 获取状态为启用的自定义字段列表
	 * 调用权限:agent
	 * @return
	 */
	public List<UserField> getUserFieldActiveList(){

		List<UserField> lists = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getUserFieldActiveList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USER_FIELDS);
			lists = EntityBuilder.buildUserFields(jsonArray);
		}
		return lists;
	}


	/**
	 * 查看用户自定义字段
	 * @param user_field_id 用户自定义字段id
	 * @return
	 */
	public UserField getUserFieldListByID(String user_field_id){

		checkHasId(user_field_id);
		UserField userField = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getUserFieldListByID(domain, user_field_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			userField = EntityBuilder.buildUserField(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER_FIELD));
		}
		return userField;

	}


	/**
	 * 删除用户自定义字段
	 * 调用权限:admin
	 * @param user_field_id 用户自定义字段id
	 */
	public void deleteUserField(String user_field_id){

		checkHasId(user_field_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteUserField(domain, user_field_id), baseToken);
	}


	/**
	 * 客服组列表
	 * 调用权限：agent
	 */
	public List<Group> getGroupList(){

		List<Group> grouList = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getGroupList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.GROUPS);
			grouList = EntityBuilder.buildGroups(jsonArray);
		}
		return grouList;
	}

	/**
	 * 查看客服组
	 * 调用权限:agent
	 * @param group_id 客服组id
	 * @return
	 */
	public Group getGroupListByID(String group_id){

		checkHasId(group_id);
		Group group = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getGroupListByID(domain, group_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			group = EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.GROUP));
		}
		return group;

	}


	/**
	 * 创建客服组
	 * 调用权限：admin
	 * @param jsonString
	 * @return
	 */
	public Group createGroup(String jsonString){

		Group group = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createGroup(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				group = EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.GROUP));
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return group;
	}

	/**
	 * 修改客服组
	 * 调用权限:admin
	 * @param group_id 客服组id
	 * @param jsonString 修改内容,参数格式为json，详情请见http://developer.kf5.com/restapi/groups/中修改客服组
	 * @return
	 */
	public Group updateGroup(String group_id,String jsonString){

		checkHasId(group_id);
		Group group = null;
		MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateGroup(domain, group_id), baseToken, JSONObject.fromObject(jsonString).toString());
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			group = EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.GROUP));
		}
		return group;
	}



	/**
	 * 删除客服组
	 * 调用权限:admin
	 * @param group_id 客服组id
	 */
	public void deleteGroup(String group_id){
		checkHasId(group_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteGroup(domain, group_id), baseToken);
	}


	/**
	 * 获取公司组织列表
	 * 调用权限:agent
	 */
	public List<Organization> getOrganizationList(){

		List<Organization> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrganizationList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.ORGANIZATIONS);
			list = EntityBuilder.buildOrganizations(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	} 

	/**
	 * 查看公司组织
	 * 调用权限:agent
	 * @param organization_id 公司组织id
	 * @return
	 */
	public Organization getOrganizationByID(String organization_id){

		checkHasId(organization_id);
		Organization organization = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getOrganizationByID(domain, organization_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			organization = EntityBuilder.buildOrganization(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.ORGANIZATION));
		}
		return organization;
	}

	/**
	 * 创建公司组织
	 * 调用权限:admin
	 * @param jsonString 提交内容，参数格式为json格式，详情请见http://developer.kf5.com/restapi/organizations/中创建公司组织
	 * @return
	 */
	public Organization createOrganization(String jsonString){
		Organization organization = null;
		MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createOrganization(domain), baseToken, JSONObject.fromObject(jsonString).toString());
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			organization = EntityBuilder.buildOrganization(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.ORGANIZATION));
		}
		return organization;
	}

	/**
	 * 修改公司组织
	 * 调用权限:admin
	 * @param organization_id 公司组织id
	 * @param jsonString 修改的内容，参数格式为json。详情请见http://developer.kf5.com/restapi/organizations/中修改公司组织
	 * @return
	 */
	public Organization updateOrganization(String organization_id,String jsonString){

		checkHasId(organization_id);
		Organization organization = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateOrganization(domain, organization_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				organization = EntityBuilder.buildOrganization(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.ORGANIZATION));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return organization;
	}



	/**
	 * 删除公司组织
	 * 调用权限:admin
	 * @param organization_id 公司组织id
	 */
	public void deleteOrganization(String organization_id){

		checkHasId(organization_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteOrganization(domain, organization_id), baseToken);
	}



	/**
	 * 获取社区话题列表
	 * 调用权限:all
	 */
	public List<Topic> getTopicList(){

		List<Topic> topics = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTopicList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TOPICS);
			topics = EntityBuilder.buildTopics(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return topics;
	}


	/**
	 * 查看社区话题
	 * 调用权限:all
	 * @param topic_id 话题id
	 * @return
	 */
	public Topic getTopicByID(String topic_id){
		
		checkHasId(topic_id);
		Topic topic = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getTopicByID(domain, topic_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			topic = EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TOPIC));
		}
		return topic;
	}


	/**
	 * 创建社区话题
	 * 调用权限：admin
	 * @param jsonString 社区话题内容，参数格式为json格式，详情请见：http://developer.kf5.com/restapi/topics/中创建社区话题
	 * @return
	 */
	public Topic createTopic(String jsonString){

		Topic topic = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createTopic(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				topic = EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TOPIC));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return topic;
	}


	/**
	 * 修改社区话题
	 * 调用权限:admin
	 * @param topic_id 话题id
	 * @param jsonString 修改内容，内容格式为json格式，详情请见http://developer.kf5.com/restapi/topics/中修改社区话题
	 * @return
	 */
	public Topic updateTopic(String topic_id,String jsonString){
		
		checkHasId(topic_id);
		Topic topic = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateTopic(domain, topic_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				topic = EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TOPIC));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return topic;
	}

	/**
	 * 删除社区话题
	 * 调用权限:admin
	 * 注意：调用该API资源会同时删除该社区话题下的所有社区问题
	 * @param topic_id 社区话题id
	 */
	public void deleteTopic(String topic_id){
		
		checkHasId(topic_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteTopic(domain, topic_id), baseToken);
	}


	/**
	 * 获取社区问题列表
	 * 调用权限：all
	 */
	public List<Question> getQuestionList(){

		List<Question> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getQuestionList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.QUESTIONS);
			list = EntityBuilder.buildQuestions(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}


	/**
	 * 查看社区问题
	 * 调用权限:all
	 * @param question_id 社区问题id
	 * @return
	 */
	public Question getQuestionByID(String question_id){

		checkHasId(question_id);
		Question question = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getQuestionByID(domain, question_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			question = EntityBuilder.buildQuestion(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION));
		}
		return question;

	}


	/**
	 * 创建社区问题
	 * 调用权限:all
	 * 注意：话题id不能为空
	 * @param jsonString 创建问题内容，格式为json格式，详情请见http://developer.kf5.com/restapi/questions/中创建社区问题
	 * @return
	 */
	public Question createQuestion(String jsonString){

		Question question = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createQuestion(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				question = EntityBuilder.buildQuestion(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return question;
	}


	/**
	 * 修改社区问题
	 * 调用权限:admin
	 * @param question_id 社区问题id
	 * @param jsonString 修改内容，格式为json格式，详情请见http://developer.kf5.com/restapi/questions/中修改社区问题
	 * @return
	 */
	public Question updateQuestion(String question_id,String jsonString){

		checkHasId(question_id);
		Question question = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateQuestion(domain, question_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				question = EntityBuilder.buildQuestion(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return question;
	}

	/**
	 * 删除社区问题
	 * 调用权限:admin
	 * @param question_id 社区问题id
	 */
	public void deleteQuestion(String question_id){

		checkHasId(question_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteQuestion(domain, question_id), baseToken);
	}


	/**
	 * 获得问题回复列表
	 * 调用权限:all
	 * @param question_id 社区问题id
	 */
	public List<QuestionComment> getQuestionCommentList(String question_id){

		checkHasId(question_id);
		List<QuestionComment> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getQuestionCommentList(domain, question_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.QUESTION_COMMENTS);
			list = EntityBuilder.buildQuestionComments(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}

	/**
	 * 查看指定社区问题回复
	 * 调用权限:end_user
	 * @param question_id 问题id
	 * @param comment_id 问题回复id
	 * @return
	 */
	public QuestionComment getQuestionCommentByID(String question_id,String comment_id){

		checkHasId(question_id,comment_id);
		QuestionComment questionComment = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getQuestionCommentByID(domain, question_id, comment_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			questionComment = EntityBuilder.buildQuestionComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION_COMMENT));
		}
		return questionComment;

	}


	/**
	 * 回复社区问题
	 * 调用权限:end_user
	 * @param question_id 社区问题id
	 * @param jsonString 回复内容，参数格式为json格式，详情请见http://developer.kf5.com/restapi/questions/中回复社区问题
	 * @return
	 */
	public List<QuestionComment> replyQuestion(String question_id,String jsonString){

		checkHasId(question_id);
		List<QuestionComment> list = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.replyQuestion(domain, question_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.QUESTION_COMMENTS);
				list = EntityBuilder.buildQuestionComments(jsonArray);
				int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
				String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
				String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 文档分区列表
	 * 调用权限：all
	 * @return
	 */
	public List<Category> getCategoriesList(){

		List<Category> categories = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getCategoriesList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.CATEGORIES);
			categories = EntityBuilder.buildCategories(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return categories;
	}


	/**
	 * 查看文档分区
	 * 调用权限：all
	 * @param category_id 文档分区id
	 * @return
	 */
	public Category getCategoryByID(String category_id){

		checkHasId(category_id);
		Category category = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getCategoryByID(domain, category_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			category = EntityBuilder.buildCategory(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.CATEGORY));
		}
		return category;

	}




	/**
	 * 创建文档分区
	 * 调用权限：admin
	 * @param jsonString 提交的内容;格式为json字符串格式,详情请见http://developer.kf5.com/restapi/categories/中创建文档分区
	 * @return
	 */
	public Category createCategory(String jsonString){

		Category category = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createCategory(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				category = EntityBuilder.buildCategory(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.CATEGORY));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return category;

	}

	/**
	 * 修改文档分区
	 * 调用权限:admin
	 * @param category_id 文档分区id
	 * @param jsonString 修改内容;参数格式为json格式;详情请见：http://developer.kf5.com/restapi/categories/修改文档分区
	 * @return
	 */
	public Category updateCategory(String category_id,String jsonString){
		
		checkHasId(category_id);
		Category category = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateCategory(domain,category_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				category = EntityBuilder.buildCategory(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.CATEGORY));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			throw new JSONException(jsonString+"cannot be converted to jsonobject");
		}
		return category;
	}

	/**
	 * 删除文档分区
	 * 调用权限: admin
	 * @param category_id
	 */
	public void deleteCategory(String category_id){

		checkHasId(category_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteCategory(domain, category_id), baseToken);
	}


	/**
	 * 获取文档分类列表
	 * 调用权限:all
	 */
	public List<Forum> getForumList(){

		List<Forum> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getForumList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.FORUMS);
			list = EntityBuilder.buildForums(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}

	/**
	 * 查看文档分类
	 * 调用权限:all
	 * @param forum_id 文档分类id
	 * @return
	 */
	public Forum getForumByID(String forum_id){

		checkHasId(forum_id);
		Forum forum = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getForumByID(domain, forum_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			forum = EntityBuilder.buildForum(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.FORUM)); 
		}
		return forum;
	}


	/**
	 * 创建文档分类
	 * 调用权限：admin
	 * @param jsonString 参数格式为json格式，详情请见http://developer.kf5.com/restapi/forums/中创建文档分类
	 */
	public Forum createForum(String jsonString){

		Forum forum = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createForum(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				forum = EntityBuilder.buildForum(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.FORUM));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return forum;

	}

	/**
	 * 修改文档分类
	 * 调用权限 : admin
	 * @param forum_id  文档分类id
	 * @param jsonString 参数格式为json格式，详情请见http://developer.kf5.com/restapi/forums/中修改文档分类
	 * @return
	 */
	public Forum updateForum(String forum_id,String jsonString){

		checkHasId(forum_id);
		Forum forum = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updateForum(domain,forum_id), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				forum = EntityBuilder.buildForum(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.FORUM));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return forum;
	}

	/**
	 * 删除文档分类
	 * 调用权限:admin
	 * @param forum_id 文档分类id
	 */
	public void deleteForum(String forum_id){

		checkHasId(forum_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteForum(domain, forum_id), baseToken);
	}

	/**
	 * 获取正式文档列表
	 * 调用权限:all
	 */
	public List<Post> getPostList(){

		List<Post> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getPostList(domain), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POSTS);
			list = EntityBuilder.buildPosts(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}


	/**
	 * 查看文档
	 * 调用权限:all
	 * @param post_id 文档id 
	 * @return
	 */
	public Post getPostByID(String post_id){

		checkHasId(post_id);
		Post post = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getPostDetail(domain, post_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			post = EntityBuilder.buildPost(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.POST));
		}
		return post;
	}


	/**
	 * 查看多个文档
	 * 调用权限:all
	 * @param posts_ids 多个文档id;格式为:1,2,3
	 * @return
	 */
	public List<Post> getManyPosts(String posts_ids){
		
		checkHasId(posts_ids);
		List<Post> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getManyPosts(domain,posts_ids), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POSTS);
			list = EntityBuilder.buildPosts(jsonArray);
		}
		return list;
	}


	/**
	 * 搜索文档
	 * 调用权限: all
	 * @param key_word 搜索关键字
	 * @return
	 */
	public List<Post> searchPost(String key_word){
		
		List<Post> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.searchPost(domain,key_word), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POSTS);
			list = EntityBuilder.buildPosts(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}


	/**
	 * 创建文档
	 * 调用权限:admin
	 * @param jsonString 创建文档的内容；格式为json，参数格式详情请见http://developer.kf5.com/restapi/posts/中创建文档
	 */
	public Post createPost(String jsonString){
		
		Post post = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.createPost(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				post = EntityBuilder.buildPost(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return post;
	}


	/**
	 * 修改文档
	 * 调用权限：admin
	 * @param post_id 文档id
	 * @param jsonString 修改文档的内容;格式为json，参数格式详情请见：http://developer.kf5.com/restapi/posts/中修改文档
	 * @return
	 */
	public Post updatePost(String post_id,String jsonString){

		checkHasId(post_id);
		Post post = null;
		MessageStatus messageStatus = HttpRequest.sendPutRequest(KF5Interface.updatePost(domain,post_id), baseToken, JSONObject.fromObject(jsonString).toString());
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			post = EntityBuilder.buildPost(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST));
		}
		return post;
	}

	/**
	 * 删除文档
	 * 调用权限:admin
	 * @param post_id 文档id
	 */
	public void deletePost(String post_id){
		
		checkHasId(post_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deletePost(domain, post_id), baseToken);
	}


	/**
	 * 获取文档回复列表
	 * 调用权限:all
	 * @param post_id 文档id
	 */
	public List<PostComment> getPostCommentList(String post_id){

		checkHasId(post_id);
		List<PostComment> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getPostCommentList(domain, post_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POST_COMMENTS);
			list = EntityBuilder.buildPostComments(jsonArray);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String next_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previous_page = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}

	/**
	 * 查看指定文档回复
	 * 调用权限:all
	 * @param post_id 文档id
	 * @param id 回复id
	 */
	public PostComment getPostCommentByID(String post_id,String id){

		checkHasId(post_id,id);
		PostComment postComment = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getPostCommentByID(domain, post_id, id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			postComment = EntityBuilder.buildPostComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST_COMMENT));
		}
		return postComment;
	}


	/**
	 * 回复文档
	 * 调用权限:all
	 * @param post_id 文档id
	 * @param jsonString 回复内容;参数格式为json格式，详情请见：http://developer.kf5.com/restapi/posts/中回复文档
	 * @return
	 */
	public PostComment postReply(String post_id,String jsonString){

		checkHasId(post_id);
		PostComment postComment = null;
		MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.postReply(domain, post_id), baseToken, JSONObject.fromObject(jsonString).toString());
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			postComment = EntityBuilder.buildPostComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST_COMMENT));
		}
		return postComment;
	}


	/**
	 * 上传附件
	 * 调用权限:all
	 * @param path 附件路径
	 * @return
	 */
	public Attachment uploadAttachment(String path){

		
		Attachment attachment = null;
		try {
			File file = new File(path);
			String result = HttpRequest.uploadAttachment(KF5Interface.uploadAttachment(domain,file.getName()),file,baseToken);
			JSONObject jsonObject = KF5EntityBuilder.safeObject(result);
			JSONObject object = KF5EntityBuilder.safeObject(jsonObject, KF5Fields.ATTACHMENT);
			attachment = EntityBuilder.buildAttachment(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attachment;
	}


	/**
	 * 查看附件
	 * 调用权限: all
	 * @param attachment_id 附件id
	 * @return
	 */
	public Attachment viewAttachment(String attachment_id){

		checkHasId(attachment_id);
		Attachment attachment = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.viewAttachment(domain, attachment_id), baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			attachment = EntityBuilder.buildAttachment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.ATTACHMENT));
		}
		return attachment;
	}


	/**
	 * 删除附件
	 * 调用权限:agent
	 * @param attachment_id 附件id
	 */
	public void deleteAttachment(String attachment_id){
		checkHasId(attachment_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteAttachment(domain, attachment_id), baseToken);
	}


	/**
	 * 工单导入
	 * 调用权限:admin
	 * 注意:导入接收数据为单个工单数据，批量导入时请循环调用接口。如果在导入时出错，可以方便处理出错数据
	 * 工单在导入时，触发器等系统规则对该条工单不生效
	 * 导入时允许设置工单的created_at,updated_at等时间字段
	 * 允许设置工单回复comments的创建时间created_at, 注意comments数据必须包含author_id,content字段值
	 * 请在导入前确认工单及回复所涉及的用户全部存在于云客服平台里，如果没有请调用 用户接口 Users API 进行创建
	 * 了解更多关于工单的操作请看 工单(客服) 接口 Tickets API
	 * @param jsonString 提交的工单内容，参数格式为json，详情请见http://developer.kf5.com/restapi/imports/中工单导入
	 */
	public Ticket importOrder(String jsonString){

		Ticket ticket = null;
		try {
			MessageStatus messageStatus = HttpRequest.sendPostRequest(KF5Interface.importOrder(domain), baseToken, JSONObject.fromObject(jsonString).toString());
			if (messageStatus.getStatus() == StatusCode.OK) {
				JSONObject jsonObject = messageStatus.getJsonObject();
				ticket = EntityBuilder.buildTicket(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ticket;
	}


	/**
	 * 工单导出
	 * 调用权限:admin
	 * 请求参数:start_time:设定请求导出的工单创建时间的开始点(时间戳)
	 * end_time:设定请求导出的工单创建时间的结束点(时间戳)
	 * order：ID排序 'ASC' or 'DESC'
	 * 每页最多返回500条数据
	 * 注意:若不设置start_time，默认导出end_time之前创建的工单；
	 * 若不设置end_time，默认导出从start_time至当前时间内创建的工单;
	 * 若不设置order，默认导出工单按ID正序排列。
	 * @param param 请求参数，如：start_time=1425698858&end_time=1455698858&order=ASC
	 */
	public List<Ticket> orderExport(String param){
		
		List<Ticket> list = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.orderExport(domain)+param, baseToken);
		if (messageStatus.getStatus() == StatusCode.OK) {
			JSONObject jsonObject = messageStatus.getJsonObject();
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			list = EntityBuilder.buildTicketList(jsonArray);
			long startTime = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.START_TIME);
			long endTime = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.END_TIME);
			int count = KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT);
			String nextPage = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE);
			String previousPage = KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE);
		}
		return list;
	}

	private static void checkHasId(String... ids){
		
		if (ids != null) {
			int size = ids.length;
			for (int i = 0; i < size; i++) {
				if (ids[i] == null) {
					throw new IllegalArgumentException("id can not be null");
				}
			}
		}else {
			throw new IllegalArgumentException("id can not be null");
		}
		
	}
	
}
