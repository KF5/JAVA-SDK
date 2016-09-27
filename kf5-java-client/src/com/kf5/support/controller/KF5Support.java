package com.kf5.support.controller;

import java.io.File;
import java.util.List;

import org.kf5.support.fastjson.JSONArray;
import org.kf5.support.fastjson.JSONException;
import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.internet.HttpRequest;
import com.kf5.support.internet.KF5Interface;
import com.kf5.support.model.Attachment;
import com.kf5.support.model.Category;
import com.kf5.support.model.Comment;
import com.kf5.support.model.Forum;
import com.kf5.support.model.Group;
import com.kf5.support.model.KF5Entity;
import com.kf5.support.model.KF5ExportTicketEntity;
import com.kf5.support.model.KF5Fields;
import com.kf5.support.model.KF5PaginationEntity;
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
 * @version 创建时间：2015年8月31日 上午11:43:59
 */
public class KF5Support extends BaseSupport {

	private static final int RESULT_OK = StatusCode.OK;
	
	private static final int RESULT_ERROR = StatusCode.ERROR;

	/**
	 * 获取客服所有的工单列表
	 * 
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderList() {

		KF5Entity<List<Ticket>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderList(getDomain()));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取指定客服受理的工单列表
	 * 
	 * @param assignee_id
	 *            受理客服id
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderListWithID(String assignee_id) {
		checkHasId(assignee_id);
		KF5Entity<List<Ticket>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderListWithID(getDomain(), assignee_id));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看工单(客服)详情
	 * 
	 * @param id
	 *            工单id
	 * @return
	 */
	public KF5Entity<Ticket> getAgentTicketDetail(String order_id) {
		KF5Entity<Ticket> kf5Entity = new KF5Entity<>();
		checkHasId(order_id);
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderDetailByAgent(getDomain(), order_id));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK)
			kf5Entity.setData(EntityBuilder.buildTicket(EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET)));
		else
			kf5Entity.setMessage(jsonObject.toString());
		return kf5Entity;

	}

	/**
	 * 查看(客服)多个工单，最多返回100条数据
	 * 
	 * @param ids
	 *            参数格式为： 32，1，3
	 * 
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentManyTickets(String ids) {
		checkHasId(ids);
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getAgentManyOrder(getDomain()) + ids);
		KF5Entity<List<Ticket>> kf5Entity = new KF5Entity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}

		return kf5Entity;
	}

	/**
	 * 创建工单 调用权限：客服
	 * 
	 * @param jsonString
	 *            参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/
	 *            tickets/中创建工单参数示例
	 * 
	 */
	public KF5Entity<Ticket> createAgentOrder(String jsonString) {

		KF5Entity<Ticket> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createOrder(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildTicket(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 更新工单 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 * @param jsonString
	 *            更新内容 参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/
	 *            tickets/中更新工单参数示例
	 * @return
	 */
	public KF5Entity<Ticket> updateAgentOrder(String order_id, String jsonString) {
		checkHasId(order_id);
		KF5Entity<Ticket> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateOrder(getDomain(), order_id),
					JSONObject.parse(jsonString).toString());
			kf5Entity.setResultCode(messageStatus.getStatus());
			JSONObject jsonObject = messageStatus.getJsonObject();
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildTicket(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 更新多个工单（批量更新） 调用权限：agent
	 * 
	 * @param ids
	 *            工单所对应的id，参数格式为1，2，3
	 * @param jsonString
	 *            更新内容，参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/
	 *            tickets/中更新多个工单参数示例
	 */
	public KF5Entity<String> updateManyAgentOrder(String ids, String jsonString) {
		checkHasId(ids);
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateManyOrders(getDomain()) + ids,
					JSONObject.parse(jsonString).toString());
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(messageStatus.getJsonObject().toString());
			} else {
				kf5Entity.setMessage(messageStatus.getJsonObject().toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
			
		}
		return kf5Entity;
	}

	/**
	 * 删除某个工单 调用权限：admin
	 * 
	 * @param id
	 *            工单id
	 */
	public KF5Entity<String> deleteAgentOrder(String id) {
		checkHasId(id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteOrder(getDomain(), id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 批量删除工单 调用权限：admin
	 * 
	 * @param ids
	 *            批量删除的工单id，参数格式为：1,2,3,4
	 */
	public KF5Entity<String> deleteManyAgentOrders(String ids) {
		checkHasId(ids);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteManyOrders(getDomain()) + ids);
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取工单可用的副本用户 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5Entity<List<User>> getAgentOrderCollaborators(String order_id) {
		checkHasId(order_id);
		KF5Entity<List<User>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getAgentOrderCollaborators(getDomain(), order_id));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			kf5Entity.setData(EntityBuilder.buildUsers(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取工单被关联的事物列表 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5Entity<List<Ticket>> getAgentOrderIncidentList(String order_id) {
		checkHasId(order_id);
		KF5Entity<List<Ticket>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getAgentOrderIncidentList(getDomain(), order_id));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取故障类型的工单列表 调用权限：agent
	 * 
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderProblemList() {

		KF5Entity<List<Ticket>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getProblemOrderList(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取当前用户的工单请求列表，即发起人为当前用户的工单,默认按工单编号升序排列 调用权限：end_user
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderList() {
		KF5PaginationEntity<List<Requester>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getRequesterOrderList(getDomain()));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			kf5Entity.setData(EntityBuilder.buildRequesters(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取状态小于已解决的工单 调用权限：end_user
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusOpen() {
		KF5PaginationEntity<List<Requester>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getRequesterOrderListStatusOpen(getDomain()));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			kf5Entity.setData(EntityBuilder.buildRequesters(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取状态为已解决和已关闭的工单 调用权限：end_user
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusSolved() {
		KF5PaginationEntity<List<Requester>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getRequesterOrderListStatusSolved(getDomain()));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			kf5Entity.setData(EntityBuilder.buildRequesters(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取用户的工单请求 调用权限：agent
	 * 
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public KF5PaginationEntity<List<Ticket>> getRequesterOrderListByID(String user_id) {

		checkHasId(user_id);
		KF5PaginationEntity<List<Ticket>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getRequesterOrderListByID(getDomain(), user_id));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取指定用户的工单请求 调用权限：agent
	 * 
	 * @param organization_id
	 *            公司组织id
	 * @return
	 */

	public KF5PaginationEntity<List<Requester>> getOrganizationOrderList(String organization_id) {
		checkHasId(organization_id);

		MessageStatus messageStatus = sendGetRequest(
				KF5Interface.getOrganizationOrderList(getDomain(), organization_id));
		KF5PaginationEntity<List<Requester>> kf5Entity = new KF5PaginationEntity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			kf5Entity.setData(EntityBuilder.buildRequesters(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 搜索工单请求 调用权限：end_user query:查询关键词，模糊查询多个字段 status：状态筛选条件
	 * fieldvalue：自定义字段条件
	 * 
	 * @param keys
	 */
	public KF5PaginationEntity<List<Requester>> searchOrderByEndUser(String keys) {
		MessageStatus messageStatus = sendGetRequest(KF5Interface.searchOrder(getDomain()) + keys);
		KF5PaginationEntity<List<Requester>> kf5Entity = new KF5PaginationEntity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.REQUESTS);
			kf5Entity.setData(EntityBuilder.buildRequesters(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看工单详情 调用权限：end_user
	 * 
	 * @param order_id
	 *            工单id
	 * @return
	 */
	public KF5Entity<Requester> getOrderDetailByEndUser(String order_id) {
		checkHasId(order_id);
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderDetailByRequester(getDomain(), order_id));
		KF5Entity<Requester> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildRequester(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.REQUEST)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建工单请求 调用权限：end_user
	 * 
	 * @param jsonString
	 *            参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/
	 *            requests/中创建工单参数示例
	 * @return
	 */
	public KF5Entity<Requester> createOrderByEndUser(String jsonString) {
		KF5Entity<Requester> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createOrderByRequester(getDomain()),
					JSONObject.parse(jsonString).toString());
			kf5Entity.setResultCode(messageStatus.getStatus());
			JSONObject jsonObject = messageStatus.getJsonObject();
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(
						EntityBuilder.buildRequester(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.REQUEST)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 回复工单 调用权限：end_user
	 * 
	 * @param order_id
	 *            工单id
	 * @param jsonString
	 *            参数格式为json字符串格式，参数格式详情请见：http://developer.kf5.com/restapi/
	 *            requests/中回复工单参数示例
	 * @return
	 */
	public KF5Entity<Requester> replyOrderByEndUser(String order_id, String jsonString) {
		checkHasId(order_id);
		KF5Entity<Requester> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.replyOrderByEndUser(getDomain(), order_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(
						EntityBuilder.buildRequester(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.REQUEST)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看工单回复列表 调用权限：end_user
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5PaginationEntity<List<Comment>> getCommentListByEndUser(String order_id) {
		checkHasId(order_id);
		KF5PaginationEntity<List<Comment>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getCommentListByEndUser(getDomain(), order_id));
		kf5Entity.setResultCode(messageStatus.getStatus());
		JSONObject jsonObject = messageStatus.getJsonObject();
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.COMMENTS);
			kf5Entity.setData(EntityBuilder.buildComments(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看指定工单回复 调用权限 ：end_user
	 * 
	 * @param requester_id
	 *            工单发起人id
	 * @param id
	 *            回复id
	 */
	public KF5Entity<Comment> getOrderCommentWithID(String requester_id, String id) {

		checkHasId(requester_id, id);
		KF5Entity<Comment> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderCommentWithID(getDomain(), requester_id, id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.COMMENT)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 工单回复列表 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5PaginationEntity<List<Comment>> getOrderCommentList(String order_id) {
		checkHasId(order_id);
		KF5PaginationEntity<List<Comment>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderCommentList(getDomain(), order_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.COMMENTS);
			kf5Entity.setData(EntityBuilder.buildComments(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取工单自定义字段列表 调用权限：agent
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldList() {

		KF5PaginationEntity<List<TicketField>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTicketFieldList(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKET_FIELDS);
			kf5Entity.setData(EntityBuilder.buildTicketFields(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取状态为启用的自定义字段列表
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldListActive() {

		KF5PaginationEntity<List<TicketField>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTicketFieldListActive(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKET_FIELDS);
			kf5Entity.setData(EntityBuilder.buildTicketFields(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看自定义字段 调用权限：agent
	 * 
	 * @param ticket_field_id
	 *            自定义字段id
	 */
	public KF5Entity<TicketField> getTicketFieldByID(String ticket_field_id) {
		checkHasId(ticket_field_id);
		KF5Entity<TicketField> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTicketFieldByID(getDomain(), ticket_field_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(
					EntityBuilder.buildTicketField(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET_FIELD)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除自定义字段 调用权限：admin
	 * 
	 * @param ticket_field_id
	 */
	public KF5Entity<String> deleteTicketFieldByID(String ticket_field_id) {

		checkHasId(ticket_field_id);
		MessageStatus messageStatus = sendDeleteRequest(
				KF5Interface.deleteTicketFieldByID(getDomain(), ticket_field_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 工单查看分类列表 调用权限：agent
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeList() {
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderTypeList(getDomain()));
		KF5PaginationEntity<List<View>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.VIEWS);
			kf5Entity.setData(EntityBuilder.buildViews(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看当前客服可用的工单查看分类 调用权限：agent
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeListActive() {

		KF5PaginationEntity<List<View>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderTypeListActive(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.VIEWS);
			kf5Entity.setData(EntityBuilder.buildViews(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取指定查看分类 调用权限：agent
	 * 
	 * @param type_id
	 *            分类id
	 * @return
	 */
	public KF5Entity<View> getOrderTypeByID(String type_id) {

		checkHasId(type_id);
		KF5Entity<View> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrderTypeListByID(getDomain(), type_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildView(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.VIEW)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取指定查看分类里的工单 调用权限：agent
	 * 
	 * @param type_id
	 *            分类id
	 */
	public KF5PaginationEntity<List<Ticket>> getTicketListByTypeID(String type_id) {
		checkHasId(type_id);
		KF5PaginationEntity<List<Ticket>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTicketListByTypeID(getDomain(), type_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取指定查看分类的工单个数 调用权限：agent
	 * 
	 * @param type_id
	 *            分类id
	 */
	public KF5Entity<ViewCount> getTicketCountByTypeID(String type_id) {

		checkHasId(type_id);
		KF5Entity<ViewCount> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTicketCountByTypeID(getDomain(), type_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(
					EntityBuilder.buildViewCount(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.VIEW_COUNT)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取多个查看分类的工单个数
	 * 
	 * @param ids
	 *            多个分类id; 如：1,2,3,4
	 */

	public KF5Entity<List<ViewCount>> getManyTicketCountByTypeIds(String ids) {

		checkHasId(ids);
		KF5Entity<List<ViewCount>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getManyTicketCountByTypeIds(getDomain()) + ids);
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.VIEW_COUNTS);
			kf5Entity.setData(EntityBuilder.buildViewCounts(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取用户列表 调用权限: agent
	 */
	public KF5PaginationEntity<List<User>> getUserList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getUserList(getDomain()));
		KF5PaginationEntity<List<User>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			kf5Entity.setData(EntityBuilder.buildUsers(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看指定用户信息
	 * 
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public KF5Entity<User> getUserInfo(String user_id) {

		checkHasId(user_id);
		KF5Entity<User> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getUserInfo(getDomain(), user_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看自己的信息 调用权限: all
	 * 
	 * @return
	 */

	public KF5Entity<User> getMyInfo() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getMyInfo(getDomain()));
		KF5Entity<User> kf5Entity = new KF5Entity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取多个用户信息 调用权限:agent
	 * 
	 * @param user_ids
	 *            多个用户id；格式示例为：1,2,36,6
	 * @return
	 */
	public KF5PaginationEntity<List<User>> getManyUsersInfo(String user_ids) {
		checkHasId(user_ids);
		KF5PaginationEntity<List<User>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getManyUsersInfo(getDomain()) + user_ids);
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			kf5Entity.setData(EntityBuilder.buildUsers(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建用户信息 调用权限:agent
	 * 
	 * @param jsonString
	 *            参数格式为json字符串，具体示例请参考http://developer.kf5.com/restapi/users/
	 *            中的创建用户信息
	 */
	public KF5Entity<User> createUserInfo(String jsonString) {
		KF5Entity<User> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createUserInfo(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 合并用户 调用权限:admin
	 * 
	 * @param user_id
	 *            被合并的用户id;
	 * @param jsonString
	 *            需要与之合并的用户内容，格式为json字符串格式。 URL里指定id的用户，将会被合并到传递参数中id所代表的用户。
	 *            前者的数据也会合并为后者的数据，之后前者将会被删除。 被合并的用户，只能是普通用户角色。
	 */
	public KF5Entity<User> mergeUser(String user_id, String jsonString) {
		checkHasId(user_id);
		KF5Entity<User> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.mergeUser(getDomain(), user_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 修改用户信息 调用权限:agent
	 * 
	 * @param user_id
	 *            用户id
	 * @param jsonString
	 *            修改内容
	 *            参数格式为json字符串，具体示例详见：http://developer.kf5.com/restapi/users/
	 *            修改用户信息
	 */
	public KF5Entity<User> updateUserInfo(String user_id, String jsonString) {
		checkHasId(user_id);
		KF5Entity<User> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateUserInfo(getDomain(), user_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildUser(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除用户 调用权限:admin
	 * 
	 * @param user_id
	 *            用户id
	 */
	public KF5Entity<String> deleteUser(String user_id) {
		checkHasId(user_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteUser(getDomain(), user_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 搜索用户 调用权限:agent
	 * 
	 * @param key
	 *            搜索关键字
	 * @return
	 */
	public KF5PaginationEntity<List<User>> searchUser(String key) {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.searchUser(getDomain()) + key);
		KF5PaginationEntity<List<User>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USERS);
			kf5Entity.setData(EntityBuilder.buildUsers(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取用户自定义字段 调用权限:agent
	 * 
	 * @return
	 */
	public KF5Entity<List<UserField>> getUserFieldList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getUserFieldList(getDomain()));
		KF5Entity<List<UserField>> kf5Entity = new KF5Entity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USER_FIELDS);
			kf5Entity.setData(EntityBuilder.buildUserFields(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取状态为启用的自定义字段列表 调用权限:agent
	 * 
	 * @return
	 */
	public KF5Entity<List<UserField>> getUserFieldActiveList() {
		KF5Entity<List<UserField>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getUserFieldActiveList(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.USER_FIELDS);
			kf5Entity.setData(EntityBuilder.buildUserFields(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看用户自定义字段
	 * 
	 * @param user_field_id
	 *            用户自定义字段id
	 * @return
	 */
	public KF5Entity<UserField> getUserFieldListByID(String user_field_id) {
		checkHasId(user_field_id);
		KF5Entity<UserField> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getUserFieldListByID(getDomain(), user_field_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(
					EntityBuilder.buildUserField(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.USER_FIELD)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 删除用户自定义字段 调用权限:admin
	 * 
	 * @param user_field_id
	 *            用户自定义字段id
	 */
	public KF5Entity<String> deleteUserField(String user_field_id) {

		checkHasId(user_field_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteUserField(getDomain(), user_field_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 客服组列表 调用权限：agent
	 */
	public KF5Entity<List<Group>> getGroupList() {

		KF5Entity<List<Group>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getGroupList(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.GROUPS);
			kf5Entity.setData(EntityBuilder.buildGroups(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看客服组 调用权限:agent
	 * 
	 * @param group_id
	 *            客服组id
	 * @return
	 */

	public KF5Entity<Group> getGroupListByID(String group_id) {

		checkHasId(group_id);
		KF5Entity<Group> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getGroupListByID(getDomain(), group_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.GROUP)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建客服组 调用权限：admin
	 * 
	 * @param jsonString
	 * @return
	 */

	public KF5Entity<Group> createGroup(String jsonString) {

		KF5Entity<Group> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createGroup(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.GROUP)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 修改客服组 调用权限:admin
	 * 
	 * @param group_id
	 *            客服组id
	 * @param jsonString
	 *            修改内容,参数格式为json，详情请见http://developer.kf5.com/restapi/groups/
	 *            中修改客服组
	 * @return
	 */
	public KF5Entity<Group> updateGroup(String group_id, String jsonString) {

		checkHasId(group_id);
		KF5Entity<Group> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendPutRequest(KF5Interface.updateGroup(getDomain(), group_id),
				JSONObject.parse(jsonString).toString());
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.GROUP)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除客服组 调用权限:admin
	 * 
	 * @param group_id
	 *            客服组id
	 */
	public KF5Entity<String> deleteGroup(String group_id) {
		checkHasId(group_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteGroup(getDomain(), group_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取公司组织列表 调用权限:agent
	 */
	public KF5PaginationEntity<List<Organization>> getOrganizationList() {

		KF5PaginationEntity<List<Organization>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrganizationList(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.ORGANIZATIONS);
			kf5Entity.setData(EntityBuilder.buildOrganizations(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看公司组织 调用权限:agent
	 * 
	 * @param organization_id
	 *            公司组织id
	 * @return
	 */
	public KF5Entity<Organization> getOrganizationByID(String organization_id) {

		checkHasId(organization_id);
		KF5Entity<Organization> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getOrganizationByID(getDomain(), organization_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder
					.buildOrganization(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.ORGANIZATION)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建公司组织 调用权限:admin
	 * 
	 * @param jsonString
	 *            提交内容，参数格式为json格式，详情请见http://developer.kf5.com/restapi/
	 *            organizations/中创建公司组织
	 * @return
	 */
	public KF5Entity<Organization> createOrganization(String jsonString) {

		KF5Entity<Organization> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendPostRequest(KF5Interface.createOrganization(getDomain()),
				JSONObject.parse(jsonString).toString());
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder
					.buildOrganization(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.ORGANIZATION)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 修改公司组织 调用权限:admin
	 * 
	 * @param organization_id
	 *            公司组织id
	 * @param jsonString
	 *            修改的内容，参数格式为json。详情请见http://developer.kf5.com/restapi/
	 *            organizations/中修改公司组织
	 * @return
	 */
	public KF5Entity<Organization> updateOrganization(String organization_id, String jsonString) {

		checkHasId(organization_id);
		KF5Entity<Organization> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateOrganization(getDomain(), organization_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder
						.buildOrganization(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.ORGANIZATION)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除公司组织 调用权限:admin
	 * 
	 * @param organization_id
	 *            公司组织id
	 */
	public KF5Entity<String> deleteOrganization(String organization_id) {

		checkHasId(organization_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteOrganization(getDomain(), organization_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取社区话题列表 调用权限:all
	 */
	public KF5PaginationEntity<List<Topic>> getTopicList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTopicList(getDomain()));
		KF5PaginationEntity<List<Topic>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TOPICS);
			kf5Entity.setData(EntityBuilder.buildTopics(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 查看社区话题 调用权限:all
	 * 
	 * @param topic_id
	 *            话题id
	 * @return
	 */

	public KF5Entity<Topic> getTopicByID(String topic_id) {

		checkHasId(topic_id);
		KF5Entity<Topic> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getTopicByID(getDomain(), topic_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TOPIC)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建社区话题 调用权限：admin
	 * 
	 * @param jsonString
	 *            社区话题内容，参数格式为json格式，详情请见：http://developer.kf5.com/restapi/
	 *            topics/中创建社区话题
	 * @return
	 */
	public KF5Entity<Topic> createTopic(String jsonString) {
		KF5Entity<Topic> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createTopic(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TOPIC)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 修改社区话题 调用权限:admin
	 * 
	 * @param topic_id
	 *            话题id
	 * @param jsonString
	 *            修改内容，内容格式为json格式，详情请见http://developer.kf5.com/restapi/topics/
	 *            中修改社区话题
	 * @return
	 */
	public KF5Entity<Topic> updateTopic(String topic_id, String jsonString) {
		checkHasId(topic_id);
		KF5Entity<Topic> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateTopic(getDomain(), topic_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TOPIC)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除社区话题 调用权限:admin 注意：调用该API资源会同时删除该社区话题下的所有社区问题
	 * 
	 * @param topic_id
	 *            社区话题id
	 */
	public KF5Entity<String> deleteTopic(String topic_id) {

		checkHasId(topic_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteTopic(getDomain(), topic_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取社区问题列表 调用权限：all
	 */

	public KF5PaginationEntity<List<Question>> getQuestionList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getQuestionList(getDomain()));
		KF5PaginationEntity<List<Question>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.QUESTIONS);
			kf5Entity.setData(EntityBuilder.buildQuestions(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 查看社区问题 调用权限:all
	 * 
	 * @param question_id
	 *            社区问题id
	 * @return
	 */
	public KF5Entity<Question> getQuestionByID(String question_id) {

		checkHasId(question_id);
		KF5Entity<Question> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getQuestionByID(getDomain(), question_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildQuestion(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 创建社区问题 调用权限:all 注意：话题id不能为空
	 * 
	 * @param jsonString
	 *            创建问题内容，格式为json格式，详情请见http://developer.kf5.com/restapi/
	 *            questions/中创建社区问题
	 * @return
	 */
	public KF5Entity<Question> createQuestion(String jsonString) {

		KF5Entity<Question> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createQuestion(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(
						EntityBuilder.buildQuestion(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}

		return kf5Entity;
	}

	/**
	 * 修改社区问题 调用权限:admin
	 * 
	 * @param question_id
	 *            社区问题id
	 * @param jsonString
	 *            修改内容，格式为json格式，详情请见http://developer.kf5.com/restapi/questions/
	 *            中修改社区问题
	 * @return
	 */
	public KF5Entity<Question> updateQuestion(String question_id, String jsonString) {

		checkHasId(question_id);
		KF5Entity<Question> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateQuestion(getDomain(), question_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(
						EntityBuilder.buildQuestion(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除社区问题 调用权限:admin
	 * 
	 * @param question_id
	 *            社区问题id
	 */
	public KF5Entity<String> deleteQuestion(String question_id) {

		checkHasId(question_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteQuestion(getDomain(), question_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获得问题回复列表 调用权限:all
	 * 
	 * @param question_id
	 *            社区问题id
	 */
	public KF5PaginationEntity<List<QuestionComment>> getQuestionCommentList(String question_id) {

		checkHasId(question_id);
		KF5PaginationEntity<List<QuestionComment>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getQuestionCommentList(getDomain(), question_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.QUESTION_COMMENTS);
			kf5Entity.setData(EntityBuilder.buildQuestionComments(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看指定社区问题回复 调用权限:end_user
	 * 
	 * @param question_id
	 *            问题id
	 * @param comment_id
	 *            问题回复id
	 * @return
	 */
	public KF5Entity<QuestionComment> getQuestionCommentByID(String question_id, String comment_id) {

		checkHasId(question_id, comment_id);
		KF5Entity<QuestionComment> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(
				KF5Interface.getQuestionCommentByID(getDomain(), question_id, comment_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder
					.buildQuestionComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.QUESTION_COMMENT)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 回复社区问题 调用权限:end_user
	 * 
	 * @param question_id
	 *            社区问题id
	 * @param jsonString
	 *            回复内容，参数格式为json格式，详情请见http://developer.kf5.com/restapi/
	 *            questions/中回复社区问题
	 * @return
	 */
	public KF5PaginationEntity<List<QuestionComment>> replyQuestion(String question_id, String jsonString) {

		checkHasId(question_id);
		KF5PaginationEntity<List<QuestionComment>> kf5Entity = new KF5PaginationEntity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.replyQuestion(getDomain(), question_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.QUESTION_COMMENTS);
				kf5Entity.setData(EntityBuilder.buildQuestionComments(jsonArray));
				setPagesAndCount(kf5Entity, jsonObject);
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 文档分区列表 调用权限：all
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Category>> getCategoriesList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getCategoriesList(getDomain()));
		KF5PaginationEntity<List<Category>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.CATEGORIES);
			kf5Entity.setData(EntityBuilder.buildCategories(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 查看文档分区 调用权限：all
	 * 
	 * @param category_id
	 *            文档分区id
	 * @return
	 */
	public KF5Entity<Category> getCategoryByID(String category_id) {

		checkHasId(category_id);
		KF5Entity<Category> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getCategoryByID(getDomain(), category_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildCategory(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.CATEGORY)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 创建文档分区 调用权限：admin
	 * 
	 * @param jsonString
	 *            提交的内容;格式为json字符串格式,详情请见http://developer.kf5.com/restapi/
	 *            categories/中创建文档分区
	 * @return
	 */
	public KF5Entity<Category> createCategory(String jsonString) {

		KF5Entity<Category> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createCategory(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(
						EntityBuilder.buildCategory(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.CATEGORY)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", RESULT_ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 修改文档分区 调用权限:admin
	 * 
	 * @param category_id
	 *            文档分区id
	 * @param jsonString
	 *            修改内容;参数格式为json格式;详情请见：http://developer.kf5.com/restapi/
	 *            categories/修改文档分区
	 * @return
	 */
	public KF5Entity<Category> updateCategory(String category_id, String jsonString) {

		checkHasId(category_id);
		KF5Entity<Category> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateCategory(getDomain(), category_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(
						EntityBuilder.buildCategory(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.CATEGORY)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", StatusCode.ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除文档分区 调用权限: admin
	 * 
	 * @param category_id
	 */
	public KF5Entity<String> deleteCategory(String category_id) {

		checkHasId(category_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteCategory(getDomain(), category_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取文档分类列表 调用权限:all
	 */
	public KF5PaginationEntity<List<Forum>> getForumList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getForumList(getDomain()));
		KF5PaginationEntity<List<Forum>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.FORUMS);
			kf5Entity.setData(EntityBuilder.buildForums(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 查看文档分类 调用权限:all
	 * 
	 * @param forum_id
	 *            文档分类id
	 * @return
	 */
	public KF5Entity<Forum> getForumByID(String forum_id) {

		checkHasId(forum_id);
		KF5Entity<Forum> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getForumByID(getDomain(), forum_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildForum(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.FORUM)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建文档分类 调用权限：admin
	 * 
	 * @param jsonString
	 *            参数格式为json格式，详情请见http://developer.kf5.com/restapi/forums/
	 *            中创建文档分类
	 */
	public KF5Entity<Forum> createForum(String jsonString) {

		KF5Entity<Forum> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createForum(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildForum(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.FORUM)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", StatusCode.ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;

	}

	/**
	 * 修改文档分类 调用权限 : admin
	 * 
	 * @param forum_id
	 *            文档分类id
	 * @param jsonString
	 *            参数格式为json格式，详情请见http://developer.kf5.com/restapi/forums/
	 *            中修改文档分类
	 * @return
	 */

	public KF5Entity<Forum> updateForum(String forum_id, String jsonString) {

		checkHasId(forum_id);
		KF5Entity<Forum> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPutRequest(KF5Interface.updateForum(getDomain(), forum_id),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildForum(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.FORUM)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", StatusCode.ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除文档分类 调用权限:admin
	 * 
	 * @param forum_id
	 *            文档分类id
	 */
	public KF5Entity<String> deleteForum(String forum_id) {

		checkHasId(forum_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteForum(getDomain(), forum_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取正式文档列表 调用权限:all
	 */
	public KF5PaginationEntity<List<Post>> getPostList() {

		MessageStatus messageStatus = sendGetRequest(KF5Interface.getPostList(getDomain()));
		JSONObject jsonObject = messageStatus.getJsonObject();
		KF5PaginationEntity<List<Post>> kf5Entity = new KF5PaginationEntity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POSTS);
			kf5Entity.setData(EntityBuilder.buildPosts(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看文档 调用权限:all
	 * 
	 * @param post_id
	 *            文档id
	 * @return
	 */
	public KF5Entity<Post> getPostByID(String post_id) {

		checkHasId(post_id);
		KF5Entity<Post> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getPostDetail(getDomain(), post_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildPost(KF5EntityBuilder.getJsonObject(jsonObject, KF5Fields.POST)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看多个文档 调用权限:all
	 * 
	 * @param posts_ids
	 *            多个文档id;格式为:1,2,3
	 * @return
	 */

	public KF5Entity<List<Post>> getManyPosts(String posts_ids) {
		checkHasId(posts_ids);
		KF5Entity<List<Post>> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getManyPosts(getDomain(), posts_ids));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POSTS);
			kf5Entity.setData(EntityBuilder.buildPosts(jsonArray));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 搜索文档 调用权限: all
	 * 
	 * @param key_word
	 *            搜索关键字
	 * @return
	 */

	public KF5PaginationEntity<List<Post>> searchPost(String key_word) {

		MessageStatus messageStatus = HttpRequest.sendGetRequest(KF5Interface.searchPost(getDomain(), key_word),
				baseToken);
		KF5PaginationEntity<List<Post>> kf5Entity = new KF5PaginationEntity<>();
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POSTS);
			kf5Entity.setData(EntityBuilder.buildPosts(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 创建文档 调用权限:admin
	 * 
	 * @param jsonString
	 *            创建文档的内容；格式为json，参数格式详情请见http://developer.kf5.com/restapi/posts
	 *            /中创建文档
	 */

	public KF5Entity<Post> createPost(String jsonString) {

		KF5Entity<Post> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.createPost(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildPost(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", StatusCode.ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 修改文档 调用权限：admin
	 * 
	 * @param post_id
	 *            文档id
	 * @param jsonString
	 *            修改文档的内容;格式为json，参数格式详情请见：http://developer.kf5.com/restapi/
	 *            posts/中修改文档
	 * @return
	 */

	public KF5Entity<Post> updatePost(String post_id, String jsonString) {

		checkHasId(post_id);
		KF5Entity<Post> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendPutRequest(KF5Interface.updatePost(getDomain(), post_id),
				JSONObject.parse(jsonString).toString());
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(EntityBuilder.buildPost(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除文档 调用权限:admin
	 * 
	 * @param post_id
	 *            文档id
	 */
	public KF5Entity<String> deletePost(String post_id) {

		checkHasId(post_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deletePost(getDomain(), post_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 获取文档回复列表 调用权限:all
	 * 
	 * @param post_id
	 *            文档id
	 */
	public KF5PaginationEntity<List<PostComment>> getPostCommentList(String post_id) {

		checkHasId(post_id);
		KF5PaginationEntity<List<PostComment>> kf5Entity = new KF5PaginationEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getPostCommentList(getDomain(), post_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.POST_COMMENTS);
			kf5Entity.setData(EntityBuilder.buildPostComments(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看指定文档回复 调用权限:all
	 * 
	 * @param post_id
	 *            文档id
	 * @param id
	 *            回复id
	 */
	public KF5Entity<PostComment> getPostCommentByID(String post_id, String id) {

		checkHasId(post_id, id);
		KF5Entity<PostComment> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.getPostCommentByID(getDomain(), post_id, id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(
					EntityBuilder.buildPostComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST_COMMENT)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 回复文档 调用权限:all
	 * 
	 * @param post_id
	 *            文档id
	 * @param jsonString
	 *            回复内容;参数格式为json格式，详情请见：http://developer.kf5.com/restapi/posts/
	 *            中回复文档
	 * @return
	 */

	public KF5Entity<PostComment> postReply(String post_id, String jsonString) {

		checkHasId(post_id);
		KF5Entity<PostComment> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendPostRequest(KF5Interface.postReply(getDomain(), post_id),
				JSONObject.parse(jsonString).toString());
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(
					EntityBuilder.buildPostComment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.POST_COMMENT)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 上传附件 调用权限:all
	 * 
	 * @param path
	 *            附件路径
	 * @return
	 */
	public KF5Entity<Attachment> uploadAttachment(String path) {

		KF5Entity<Attachment> kf5Entity = new KF5Entity<>();
		try {
			File file = new File(path);
			String result = HttpRequest.uploadAttachment(KF5Interface.uploadAttachment(getDomain(), file.getName()),
					file, baseToken);
			JSONObject jsonObject = KF5EntityBuilder.safeObject(result);
			JSONObject object = KF5EntityBuilder.safeObject(jsonObject, KF5Fields.ATTACHMENT);
			kf5Entity.setResultCode(RESULT_OK);
			kf5Entity.setData(EntityBuilder.buildAttachment(object));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", StatusCode.ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 查看附件 调用权限: all
	 * 
	 * @param attachment_id
	 *            附件id
	 * @return
	 */
	public KF5Entity<Attachment> viewAttachment(String attachment_id) {

		checkHasId(attachment_id);
		KF5Entity<Attachment> kf5Entity = new KF5Entity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.viewAttachment(getDomain(), attachment_id));
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(
					EntityBuilder.buildAttachment(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.ATTACHMENT)));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 删除附件 调用权限:agent
	 * 
	 * @param attachment_id
	 *            附件id
	 */
	public KF5Entity<String> deleteAttachment(String attachment_id) {
		checkHasId(attachment_id);
		MessageStatus messageStatus = sendDeleteRequest(KF5Interface.deleteAttachment(getDomain(), attachment_id));
		KF5Entity<String> kf5Entity = new KF5Entity<>();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			kf5Entity.setData(messageStatus.getJsonObject().toString());
		} else {
			kf5Entity.setMessage(messageStatus.getJsonObject().toString());
		}
		return kf5Entity;
	}

	/**
	 * 工单导入 调用权限:admin 注意:导入接收数据为单个工单数据，批量导入时请循环调用接口。如果在导入时出错，可以方便处理出错数据
	 * 工单在导入时，触发器等系统规则对该条工单不生效 导入时允许设置工单的created_at,updated_at等时间字段
	 * 允许设置工单回复comments的创建时间created_at, 注意comments数据必须包含author_id,content字段值
	 * 请在导入前确认工单及回复所涉及的用户全部存在于云客服平台里，如果没有请调用 用户接口 Users API 进行创建 了解更多关于工单的操作请看
	 * 工单(客服) 接口 Tickets API
	 * 
	 * @param jsonString
	 *            提交的工单内容，参数格式为json，详情请见http://developer.kf5.com/restapi/imports
	 *            /中工单导入
	 */
	public KF5Entity<Ticket> importOrder(String jsonString) {

		KF5Entity<Ticket> kf5Entity = new KF5Entity<>();
		try {
			MessageStatus messageStatus = sendPostRequest(KF5Interface.importOrder(getDomain()),
					JSONObject.parse(jsonString).toString());
			JSONObject jsonObject = messageStatus.getJsonObject();
			kf5Entity.setResultCode(messageStatus.getStatus());
			if (messageStatus.getStatus() == RESULT_OK) {
				kf5Entity.setData(EntityBuilder.buildTicket(KF5EntityBuilder.safeObject(jsonObject, KF5Fields.TICKET)));
			} else {
				kf5Entity.setMessage(jsonObject.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kf5Entity.setResultCode(RESULT_ERROR);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", StatusCode.ERROR);
			jsonObject.put("message", e.getMessage());
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	/**
	 * 工单导出 调用权限:admin 请求参数:start_time:设定请求导出的工单创建时间的开始点(时间戳)
	 * end_time:设定请求导出的工单创建时间的结束点(时间戳) order：ID排序 'ASC' or 'DESC' 每页最多返回500条数据
	 * 注意:若不设置start_time，默认导出end_time之前创建的工单；
	 * 若不设置end_time，默认导出从start_time至当前时间内创建的工单; 若不设置order，默认导出工单按ID正序排列。
	 * 
	 * @param param
	 *            请求参数，如：start_time=1425698858&end_time=1455698858&order=ASC
	 */

	public KF5ExportTicketEntity<List<Ticket>> orderExport(String param) {

		KF5ExportTicketEntity<List<Ticket>> kf5Entity = new KF5ExportTicketEntity<>();
		MessageStatus messageStatus = sendGetRequest(KF5Interface.orderExport(getDomain()) + param);
		JSONObject jsonObject = messageStatus.getJsonObject();
		kf5Entity.setResultCode(messageStatus.getStatus());
		if (messageStatus.getStatus() == RESULT_OK) {
			JSONArray jsonArray = KF5EntityBuilder.safeArray(jsonObject, KF5Fields.TICKETS);
			kf5Entity.setData(EntityBuilder.buildTicketList(jsonArray));
			setPagesAndCount(kf5Entity, jsonObject);
			kf5Entity.setStartTime(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.START_TIME));
			kf5Entity.setEndTime(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.END_TIME));
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

}
