package com.kf5.support.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

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
/**
 * 
 * @author chosen
 *
 * @version ����ʱ�䣺2015��8��31��  ����11:43:59
 */
public class KF5Support{

	private String domain;

	private String username;

	private  String password;

	private  String token;

	private String baseToken;

	/**
	 * ʹ����������������֤
	 * @param domain ƽ̨��ַ
	 * @param username ��¼����
	 * @param password ����
	 */
	public void initWithPassword(String domain,String username,String password){
		this.domain = domain;
		this.username = username;
		this.password = password;
		String code = this.username+":"+this.password;
		this.baseToken =new String(Base64.getEncoder().encode(code.getBytes()));
	}
	/**
	 * ʹ�������ƽ̨����api��ͨ����Կ������֤
	 * @param domain ƽ̨��ַ
	 * @param username ��¼����
	 * @param apiToken ͨ����Կ������λ���ڣ�ϵͳ���á���>api�ӿڡ���>ͨ����Կ
	 */
	public void initWithApiToken(String domain,String username,String apiToken){

		this.domain = domain ;
		this.username = username;
		this.token = apiToken;
		String code = this.username+"/token:"+this.token;
		this.baseToken = new String(Base64.getEncoder().encode(code.getBytes()));
	}



	/**
	 * ��ȡ�ͷ����еĹ����б�
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
	 * ��ȡָ���ͷ�����Ĺ����б�
	 * @param assignee_id ����ͷ�id
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
	 * �鿴����(�ͷ�)����
	 * @param id ����id
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
	 * �鿴(�ͷ�)�����������෵��100������
	 * @param ids ������ʽΪ�� 32��1��3
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
	 * ��������
	 * ����Ȩ�ޣ��ͷ�
	 * @param jsonString ������ʽΪjson�ַ�����ʽ��������ʽ���������http://developer.kf5.com/restapi/tickets/�д�����������ʾ��
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
	 * ���¹���
	 * ����Ȩ�ޣ�agent
	 * @param order_id ����id
	 * @param jsonString �������� ������ʽΪjson�ַ�����ʽ��������ʽ���������http://developer.kf5.com/restapi/tickets/�и��¹�������ʾ��
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
	 * ���¶���������������£�
	 * ����Ȩ�ޣ�agent
	 * @param ids ��������Ӧ��id��������ʽΪ1��2��3
	 * @param jsonString �������ݣ�������ʽΪjson�ַ�����ʽ��������ʽ���������http://developer.kf5.com/restapi/tickets/�и��¶����������ʾ��
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
	 * ɾ��ĳ������
	 * ����Ȩ�ޣ�admin
	 * @param id ����id
	 */
	public void deleteAgentOrder(String id){
		checkHasId(id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteOrder(domain, id), baseToken);
	}

	/**
	 * ����ɾ������
	 * ����Ȩ�ޣ�admin
	 * @param ids ����ɾ���Ĺ���id��������ʽΪ��1,2,3,4
	 */
	public void deleteManyAgentOrders(String ids){
		checkHasId(ids);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteManyOrders(domain)+ids, baseToken);
	}

	/**
	 * ��ȡ�������õĸ����û�
	 * ����Ȩ�ޣ�agent
	 * @param order_id ����id
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
	 * ��ȡ�����������������б�
	 * ����Ȩ�ޣ�agent
	 * @param order_id ����id
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
	 * ��ȡ�������͵Ĺ����б�
	 * ����Ȩ�ޣ�agent
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
	 * ��ȡ��ǰ�û��Ĺ��������б���������Ϊ��ǰ�û��Ĺ���,Ĭ�ϰ����������������
	 * ����Ȩ�ޣ�end_user
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
	 * ��ȡ״̬С���ѽ���Ĺ���
	 * ����Ȩ�ޣ�end_user
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
	 * ��ȡ״̬Ϊ�ѽ�����ѹرյĹ���
	 * ����Ȩ�ޣ�end_user
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
	 * ��ȡ�û��Ĺ�������
	 * ����Ȩ�ޣ�agent
	 * @param user_id �û�id
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
	 * ��ȡָ���û��Ĺ�������
	 * ����Ȩ�ޣ�agent
	 * @param organization_id ��˾��֯id
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
	 * ������������
	 * ����Ȩ�ޣ�end_user
	 * query:��ѯ�ؼ��ʣ�ģ����ѯ����ֶ�
	 * status��״̬ɸѡ����
	 * fieldvalue���Զ����ֶ�����
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
	 * �鿴��������
	 * ����Ȩ�ޣ�end_user
	 * @param order_id ����id
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
	 * ������������
	 * ����Ȩ�ޣ�end_user
	 * @param jsonString ������ʽΪjson�ַ�����ʽ��������ʽ���������http://developer.kf5.com/restapi/requests/�д�����������ʾ��
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
	 * �ظ�����
	 * ����Ȩ�ޣ�end_user
	 * @param order_id ����id
	 * @param jsonString ������ʽΪjson�ַ�����ʽ��������ʽ���������http://developer.kf5.com/restapi/requests/�лظ���������ʾ��
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
	 * �鿴�����ظ��б�
	 * ����Ȩ�ޣ�end_user
	 * @param order_id ����id
	 */
	public List<Comment> getCommentListByEndUser(String order_id){

		checkHasId(order_id);
		List<Comment> comments = null;
		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.getCommentListByEndUser(domain, order_id), baseToken);
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
	 * �鿴ָ�������ظ�
	 * ����Ȩ�� ��end_user
	 * @param requester_id ����������id
	 * @param id �ظ�id
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
	 * �����ظ��б�
	 * ����Ȩ�ޣ�agent
	 * @param order_id ����id
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
	 * ��ȡ�����Զ����ֶ��б�
	 * ����Ȩ�ޣ�agent
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
	 * ��ȡ״̬Ϊ���õ��Զ����ֶ��б�
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
	 * �鿴�Զ����ֶ�
	 * ����Ȩ�ޣ�agent
	 * @param ticket_field_id �Զ����ֶ�id
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
	 * ɾ���Զ����ֶ�
	 * ����Ȩ�ޣ�admin
	 * @param ticket_field_id
	 */
	public void deleteTicketFieldByID(String ticket_field_id){

		checkHasId(ticket_field_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteTicketFieldByID(domain, ticket_field_id), baseToken);
	}



	/**
	 * �����鿴�����б�
	 * ����Ȩ�ޣ�agent
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
	 * �鿴��ǰ�ͷ����õĹ����鿴����
	 * ����Ȩ�ޣ�agent
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
	 * ��ȡָ���鿴����
	 * ����Ȩ�ޣ�agent
	 * @param type_id ����id
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
	 * ��ȡָ���鿴������Ĺ���
	 * ����Ȩ�ޣ�agent
	 * @param type_id ����id
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
	 * ��ȡָ���鿴����Ĺ�������
	 * ����Ȩ�ޣ�agent
	 * @param type_id ����id
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
	 * ��ȡ����鿴����Ĺ�������
	 * @param ids �������id; �磺1,2,3,4
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
	 * ��ȡ�û��б�
	 * ����Ȩ��: agent
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
	 * �鿴ָ���û���Ϣ
	 * @param user_id �û�id
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
	 * �鿴�Լ�����Ϣ
	 * ����Ȩ��: all
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
	 * ��ȡ����û���Ϣ
	 * ����Ȩ��:agent
	 * @param user_ids ����û�id����ʽʾ��Ϊ��1,2,36,6
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
	 * �����û���Ϣ
	 * ����Ȩ��:agent
	 * @param jsonString ������ʽΪjson�ַ���������ʾ����ο�http://developer.kf5.com/restapi/users/�еĴ����û���Ϣ
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
	 * �ϲ��û�
	 * ����Ȩ��:admin
	 * @param user_id ���ϲ����û�id;
	 * @param jsonString ��Ҫ��֮�ϲ����û����ݣ���ʽΪjson�ַ�����ʽ��
	 * URL��ָ��id���û������ᱻ�ϲ������ݲ�����id��������û��� ǰ�ߵ�����Ҳ��ϲ�Ϊ���ߵ����ݣ�֮��ǰ�߽��ᱻɾ���� ���ϲ����û���ֻ������ͨ�û���ɫ��
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
	 * �޸��û���Ϣ
	 * ����Ȩ��:agent
	 * @param user_id �û�id
	 * @param jsonString �޸����� ������ʽΪjson�ַ���������ʾ�������http://developer.kf5.com/restapi/users/ �޸��û���Ϣ
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
	 * ɾ���û�
	 * ����Ȩ��:admin
	 * @param user_id �û�id
	 */
	public void deleteUser(String user_id){

		checkHasId(user_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteUser(domain, user_id), baseToken);
	}

	/**
	 * �����û�
	 * ����Ȩ��:agent
	 * @param key �����ؼ���
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
	 * ��ȡ�û��Զ����ֶ�
	 * ����Ȩ��:agent
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
	 * ��ȡ״̬Ϊ���õ��Զ����ֶ��б�
	 * ����Ȩ��:agent
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
	 * �鿴�û��Զ����ֶ�
	 * @param user_field_id �û��Զ����ֶ�id
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
	 * ɾ���û��Զ����ֶ�
	 * ����Ȩ��:admin
	 * @param user_field_id �û��Զ����ֶ�id
	 */
	public void deleteUserField(String user_field_id){

		checkHasId(user_field_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteUserField(domain, user_field_id), baseToken);
	}


	/**
	 * �ͷ����б�
	 * ����Ȩ�ޣ�agent
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
	 * �鿴�ͷ���
	 * ����Ȩ��:agent
	 * @param group_id �ͷ���id
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
	 * �����ͷ���
	 * ����Ȩ�ޣ�admin
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
	 * �޸Ŀͷ���
	 * ����Ȩ��:admin
	 * @param group_id �ͷ���id
	 * @param jsonString �޸�����,������ʽΪjson���������http://developer.kf5.com/restapi/groups/���޸Ŀͷ���
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
	 * ɾ���ͷ���
	 * ����Ȩ��:admin
	 * @param group_id �ͷ���id
	 */
	public void deleteGroup(String group_id){
		checkHasId(group_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteGroup(domain, group_id), baseToken);
	}


	/**
	 * ��ȡ��˾��֯�б�
	 * ����Ȩ��:agent
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
	 * �鿴��˾��֯
	 * ����Ȩ��:agent
	 * @param organization_id ��˾��֯id
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
	 * ������˾��֯
	 * ����Ȩ��:admin
	 * @param jsonString �ύ���ݣ�������ʽΪjson��ʽ���������http://developer.kf5.com/restapi/organizations/�д�����˾��֯
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
	 * �޸Ĺ�˾��֯
	 * ����Ȩ��:admin
	 * @param organization_id ��˾��֯id
	 * @param jsonString �޸ĵ����ݣ�������ʽΪjson���������http://developer.kf5.com/restapi/organizations/���޸Ĺ�˾��֯
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
	 * ɾ����˾��֯
	 * ����Ȩ��:admin
	 * @param organization_id ��˾��֯id
	 */
	public void deleteOrganization(String organization_id){

		checkHasId(organization_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteOrganization(domain, organization_id), baseToken);
	}



	/**
	 * ��ȡ���������б�
	 * ����Ȩ��:all
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
	 * �鿴��������
	 * ����Ȩ��:all
	 * @param topic_id ����id
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
	 * ������������
	 * ����Ȩ�ޣ�admin
	 * @param jsonString �����������ݣ�������ʽΪjson��ʽ�����������http://developer.kf5.com/restapi/topics/�д�����������
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
	 * �޸���������
	 * ����Ȩ��:admin
	 * @param topic_id ����id
	 * @param jsonString �޸����ݣ����ݸ�ʽΪjson��ʽ���������http://developer.kf5.com/restapi/topics/���޸���������
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
	 * ɾ����������
	 * ����Ȩ��:admin
	 * ע�⣺���ø�API��Դ��ͬʱɾ�������������µ�������������
	 * @param topic_id ��������id
	 */
	public void deleteTopic(String topic_id){
		
		checkHasId(topic_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteTopic(domain, topic_id), baseToken);
	}


	/**
	 * ��ȡ���������б�
	 * ����Ȩ�ޣ�all
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
	 * �鿴��������
	 * ����Ȩ��:all
	 * @param question_id ��������id
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
	 * ������������
	 * ����Ȩ��:all
	 * ע�⣺����id����Ϊ��
	 * @param jsonString �����������ݣ���ʽΪjson��ʽ���������http://developer.kf5.com/restapi/questions/�д�����������
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
	 * �޸���������
	 * ����Ȩ��:admin
	 * @param question_id ��������id
	 * @param jsonString �޸����ݣ���ʽΪjson��ʽ���������http://developer.kf5.com/restapi/questions/���޸���������
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
	 * ɾ����������
	 * ����Ȩ��:admin
	 * @param question_id ��������id
	 */
	public void deleteQuestion(String question_id){

		checkHasId(question_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteQuestion(domain, question_id), baseToken);
	}


	/**
	 * �������ظ��б�
	 * ����Ȩ��:all
	 * @param question_id ��������id
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
	 * �鿴ָ����������ظ�
	 * ����Ȩ��:end_user
	 * @param question_id ����id
	 * @param comment_id ����ظ�id
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
	 * �ظ���������
	 * ����Ȩ��:end_user
	 * @param question_id ��������id
	 * @param jsonString �ظ����ݣ�������ʽΪjson��ʽ���������http://developer.kf5.com/restapi/questions/�лظ���������
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
	 * �ĵ������б�
	 * ����Ȩ�ޣ�all
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
	 * �鿴�ĵ�����
	 * ����Ȩ�ޣ�all
	 * @param category_id �ĵ�����id
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
	 * �����ĵ�����
	 * ����Ȩ�ޣ�admin
	 * @param jsonString �ύ������;��ʽΪjson�ַ�����ʽ,�������http://developer.kf5.com/restapi/categories/�д����ĵ�����
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
	 * �޸��ĵ�����
	 * ����Ȩ��:admin
	 * @param category_id �ĵ�����id
	 * @param jsonString �޸�����;������ʽΪjson��ʽ;���������http://developer.kf5.com/restapi/categories/�޸��ĵ�����
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
	 * ɾ���ĵ�����
	 * ����Ȩ��: admin
	 * @param category_id
	 */
	public void deleteCategory(String category_id){

		checkHasId(category_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteCategory(domain, category_id), baseToken);
	}


	/**
	 * ��ȡ�ĵ������б�
	 * ����Ȩ��:all
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
	 * �鿴�ĵ�����
	 * ����Ȩ��:all
	 * @param forum_id �ĵ�����id
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
	 * �����ĵ�����
	 * ����Ȩ�ޣ�admin
	 * @param jsonString ������ʽΪjson��ʽ���������http://developer.kf5.com/restapi/forums/�д����ĵ�����
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
	 * �޸��ĵ�����
	 * ����Ȩ�� : admin
	 * @param forum_id  �ĵ�����id
	 * @param jsonString ������ʽΪjson��ʽ���������http://developer.kf5.com/restapi/forums/���޸��ĵ�����
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
	 * ɾ���ĵ�����
	 * ����Ȩ��:admin
	 * @param forum_id �ĵ�����id
	 */
	public void deleteForum(String forum_id){

		checkHasId(forum_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteForum(domain, forum_id), baseToken);
	}

	/**
	 * ��ȡ��ʽ�ĵ��б�
	 * ����Ȩ��:all
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
	 * �鿴�ĵ�
	 * ����Ȩ��:all
	 * @param post_id �ĵ�id 
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
	 * �鿴����ĵ�
	 * ����Ȩ��:all
	 * @param posts_ids ����ĵ�id;��ʽΪ:1,2,3
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
	 * �����ĵ�
	 * ����Ȩ��: all
	 * @param key_word �����ؼ���
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
	 * �����ĵ�
	 * ����Ȩ��:admin
	 * @param jsonString �����ĵ������ݣ���ʽΪjson��������ʽ�������http://developer.kf5.com/restapi/posts/�д����ĵ�
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
	 * �޸��ĵ�
	 * ����Ȩ�ޣ�admin
	 * @param post_id �ĵ�id
	 * @param jsonString �޸��ĵ�������;��ʽΪjson��������ʽ���������http://developer.kf5.com/restapi/posts/���޸��ĵ�
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
	 * ɾ���ĵ�
	 * ����Ȩ��:admin
	 * @param post_id �ĵ�id
	 */
	public void deletePost(String post_id){
		
		checkHasId(post_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deletePost(domain, post_id), baseToken);
	}


	/**
	 * ��ȡ�ĵ��ظ��б�
	 * ����Ȩ��:all
	 * @param post_id �ĵ�id
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
	 * �鿴ָ���ĵ��ظ�
	 * ����Ȩ��:all
	 * @param post_id �ĵ�id
	 * @param id �ظ�id
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
	 * �ظ��ĵ�
	 * ����Ȩ��:all
	 * @param post_id �ĵ�id
	 * @param jsonString �ظ�����;������ʽΪjson��ʽ�����������http://developer.kf5.com/restapi/posts/�лظ��ĵ�
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
	 * �ϴ�����
	 * ����Ȩ��:all
	 * @param path ����·��
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
	 * �鿴����
	 * ����Ȩ��: all
	 * @param attachment_id ����id
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
	 * ɾ������
	 * ����Ȩ��:agent
	 * @param attachment_id ����id
	 */
	public void deleteAttachment(String attachment_id){
		checkHasId(attachment_id);
		HttpRequest.sendDeleteRequest(KF5Interface.deleteAttachment(domain, attachment_id), baseToken);
	}


	/**
	 * ��������
	 * ����Ȩ��:admin
	 * ע��:�����������Ϊ�����������ݣ���������ʱ��ѭ�����ýӿڡ�����ڵ���ʱ�������Է��㴦���������
	 * �����ڵ���ʱ����������ϵͳ����Ը�����������Ч
	 * ����ʱ�������ù�����created_at,updated_at��ʱ���ֶ�
	 * �������ù����ظ�comments�Ĵ���ʱ��created_at, ע��comments���ݱ������author_id,content�ֶ�ֵ
	 * ���ڵ���ǰȷ�Ϲ������ظ����漰���û�ȫ���������ƿͷ�ƽ̨����û������� �û��ӿ� Users API ���д���
	 * �˽������ڹ����Ĳ����뿴 ����(�ͷ�) �ӿ� Tickets API
	 * @param jsonString �ύ�Ĺ������ݣ�������ʽΪjson���������http://developer.kf5.com/restapi/imports/�й�������
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
	 * ��������
	 * ����Ȩ��:admin
	 * �������:start_time:�趨���󵼳��Ĺ�������ʱ��Ŀ�ʼ��(ʱ���)
	 * end_time:�趨���󵼳��Ĺ�������ʱ��Ľ�����(ʱ���)
	 * order��ID���� 'ASC' or 'DESC'
	 * ÿҳ��෵��500������
	 * ע��:��������start_time��Ĭ�ϵ���end_time֮ǰ�����Ĺ�����
	 * ��������end_time��Ĭ�ϵ�����start_time����ǰʱ���ڴ����Ĺ���;
	 * ��������order��Ĭ�ϵ���������ID�������С�
	 * @param param ����������磺start_time=1425698858&end_time=1455698858&order=ASC
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
