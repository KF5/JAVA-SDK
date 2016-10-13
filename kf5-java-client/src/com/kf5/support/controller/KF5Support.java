package com.kf5.support.controller;

import java.io.File;
import java.util.List;

import org.kf5.support.fastjson.JSONArray;
import org.kf5.support.fastjson.JSONException;
import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.internet.HttpRequest;
import com.kf5.support.internet.KF5Interface;
import com.kf5.support.model.AICategory;
import com.kf5.support.model.AIQuestionCategory;
import com.kf5.support.model.Attachment;
import com.kf5.support.model.Category;
import com.kf5.support.model.Chat;
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

	/**
	 * 获取客服所有的工单列表
	 * 
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderList() {
		return getAgentOrderListWithQuery("");
	}

	/**
	 * 带筛选条件获取客服所有的工单列表
	 * 
	 * @param query
	 *            筛选规则: created_start 按创建时间筛选，开始时间; created_end 按创建时间筛选，结束时间;
	 *            updated_start 按更新时间筛选，开始时间; updated_end 按更新时间筛选，结束时间;
	 *            created_order 按创建时间排序，可选值：asc、desc; updated_order
	 *            按更新时间排序，可选值：asc、desc; status_order 按工单状态排序，可选值：asc、desc;
	 *            field_order 按工单自定义字段排序，参数格式：field_690_asc 或
	 *            field_690_desc，field_690 为字段名，可以通过 工单自定义字段接口 获得; page 页码，默认为
	 *            1; per_page 分页尺寸，默认为 100;
	 *            备注:分页返回所有工单，默认排序为按编号升序排列。按创建和更新时间进行筛选的参数
	 *            created_start、created_end、updated_start、updated_end，支持日期格式（如
	 *            2016-01-01 00:00:00）和时间戳（秒级别的整型）。
	 *            详情请阅读http://developer.kf5.com/restapi/tickets/下工单列表文档
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderListWithQuery(String query) {
		return getAgentOrderListWithURl(KF5Interface.getOrderList(getDomain(), query));

	}

	/**
	 * 分页 获取客服所有的工单列表
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderListWithURl(String url) {
		return buildTicketList(sendGetRequest(url));
	}

	/**
	 * 获取指定客服受理的工单列表
	 * 
	 * @param assignee_id
	 *            受理客服id
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderListWithID(String assignee_id) {
		return getAgentOrderListWithID(assignee_id, "");
	}

	/**
	 * 获取指定客服受理的工单列表
	 * 
	 * @param assignee_id
	 *            受理客服id
	 * @param query
	 *            筛选规则: created_start 按创建时间筛选，开始时间; created_end 按创建时间筛选，结束时间;
	 *            updated_start 按更新时间筛选，开始时间; updated_end 按更新时间筛选，结束时间;
	 *            created_order 按创建时间排序，可选值：asc、desc; updated_order
	 *            按更新时间排序，可选值：asc、desc; status_order 按工单状态排序，可选值：asc、desc;
	 *            field_order 按工单自定义字段排序，参数格式：field_690_asc 或
	 *            field_690_desc，field_690 为字段名，可以通过 工单自定义字段接口 获得; page 页码，默认为
	 *            1; per_page 分页尺寸，默认为 100;
	 *            备注:分页返回所有工单，默认排序为按编号升序排列。按创建和更新时间进行筛选的参数
	 *            created_start、created_end、updated_start、updated_end，支持日期格式（如
	 *            2016-01-01 00:00:00）和时间戳（秒级别的整型）。
	 *            详情请阅读http://developer.kf5.com/restapi/tickets/下工单列表文档
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderListWithID(String assignee_id, String query) {
		checkHasId(assignee_id);
		return getAgentOrderListByURL(KF5Interface.getOrderListWithID(getDomain(), assignee_id, query));
	}

	/**
	 * 获取指定客服受理的工单分页列表
	 * 
	 * @param url
	 *            分页的url
	 * 
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderListByURL(String url) {
		return buildTicketList(sendGetRequest(url));

	}

	/**
	 * 查看工单(客服)详情
	 * 
	 * @param id
	 *            工单id
	 * @return
	 */
	public KF5Entity<Ticket> getAgentTicketDetail(String order_id) {
		checkHasId(order_id);
		return buildTicket(sendGetRequest(KF5Interface.getOrderDetailByAgent(getDomain(), order_id)));
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
		return buildTicketList(sendGetRequest(KF5Interface.getAgentManyOrder(getDomain(), ids)));
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
			buildTicket(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildTicket(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildResultWithString(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());

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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteOrder(getDomain(), id)));
	}

	/**
	 * 批量删除工单 调用权限：admin
	 * 
	 * @param ids
	 *            批量删除的工单id，参数格式为：1,2,3,4
	 */
	public KF5Entity<String> deleteManyAgentOrders(String ids) {
		checkHasId(ids);
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteManyOrders(getDomain()) + ids));
	}

	/**
	 * 获取工单可用的副本用户 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5Entity<List<User>> getAgentOrderCollaborators(String order_id) {
		checkHasId(order_id);
		return buildUserList(sendGetRequest(KF5Interface.getAgentOrderCollaborators(getDomain(), order_id)));
	}

	/**
	 * 获取工单被关联的事物列表 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5Entity<List<Ticket>> getAgentOrderIncidentList(String order_id) {
		checkHasId(order_id);
		return buildTicketList(sendGetRequest(KF5Interface.getAgentOrderIncidentList(getDomain(), order_id)));
	}

	/**
	 * 获取故障类型的工单列表 调用权限：agent
	 * 
	 * @return
	 */
	public KF5Entity<List<Ticket>> getAgentOrderProblemList() {
		return buildTicketList(sendGetRequest(KF5Interface.getProblemOrderList(getDomain())));
	}

	/**
	 * 获取当前用户的工单请求列表，即发起人为当前用户的工单,默认按工单编号升序排列 调用权限：end_user
	 * 
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderList() {
		return getRequesterOrderListWithQuery("");
	}

	/**
	 * 分页获取当前用户的工单请求列表，即发起人为当前用户的工单,默认按工单编号升序排列 调用权限：end_user
	 * 
	 * @param query
	 *            筛选条件 created_order：按创建时间排序规则，可选值：asc,desc (默认为desc)
	 *            updated_order：按更新时间排序规则，可选值：asc,desc
	 *            status_order：按工单状态排序规则，可选值：asc,desc field_order:
	 *            按自定义字段属性排序规则,参数格式：field_690_asc,或field_690_desc。
	 *            其中field_690为该工单的自定义字段name，可以通过 工单自定义字段接口获得 page 页码，默认为 1;
	 *            per_page 分页尺寸，默认为 100;
	 *            详情请浏览http://developer.kf5.com/restapi/requests/ 的工单请求列表
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListWithQuery(String query) {
		return getRequesterOrderListWithURL(KF5Interface.getRequesterOrderList(getDomain(), query));
	}

	/**
	 * 分页获取当前用户的工单请求列表，即发起人为当前用户的工单,默认按工单编号升序排列 调用权限：end_user
	 * 
	 * @param url
	 *            请求下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListWithURL(String url) {
		return buildPaginationRequesterList(sendGetRequest(url));
	}

	/**
	 * 获取状态小于已解决的工单 调用权限：end_user
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusOpen() {
		return getRequesterOrderListStatusOpenWithQuery("");
	}

	/**
	 * 分页获取状态小于已解决的工单，调用权限：end_user
	 * 
	 * @param query
	 *            筛选条件 created_order：按创建时间排序规则，可选值：asc,desc (默认为desc)
	 *            updated_order：按更新时间排序规则，可选值：asc,desc
	 *            status_order：按工单状态排序规则，可选值：asc,desc field_order:
	 *            按自定义字段属性排序规则,参数格式：field_690_asc,或field_690_desc。
	 *            其中field_690为该工单的自定义字段name，可以通过 工单自定义字段接口获得 page 页码，默认为 1;
	 *            per_page 分页尺寸，默认为 100;
	 *            详情请浏览http://developer.kf5.com/restapi/requests/ 的工单请求列表
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusOpenWithQuery(String query) {
		return getRequesterOrderListStatusOpenWithURL(KF5Interface.getRequesterOrderListStatusOpen(getDomain(), query));
	}

	/**
	 * 分页获取状态小于已解决的工单，调用权限：end_user
	 * 
	 * @param url
	 *            分页请求下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusOpenWithURL(String url) {
		return buildPaginationRequesterList(sendGetRequest(url));
	}

	/**
	 * 获取状态为已解决和已关闭的工单 调用权限：end_user
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusSolved() {
		return getRequesterOrderListStatusSolvedWithQuery("");
	}

	/**
	 * 分页获取状态为已解决和已关闭的工单，调用权限：end_user
	 * 
	 * @param query
	 *            筛选条件 created_order：按创建时间排序规则，可选值：asc,desc (默认为desc)
	 *            updated_order：按更新时间排序规则，可选值：asc,desc
	 *            status_order：按工单状态排序规则，可选值：asc,desc field_order:
	 *            按自定义字段属性排序规则,参数格式：field_690_asc,或field_690_desc。
	 *            其中field_690为该工单的自定义字段name，可以通过 工单自定义字段接口获得 page 页码，默认为 1;
	 *            per_page 分页尺寸，默认为 100;
	 *            详情请浏览http://developer.kf5.com/restapi/requests/ 的工单请求列表
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusSolvedWithQuery(String query) {
		return getRequesterOrderListStatusSolvedWithURL(
				KF5Interface.getRequesterOrderListStatusSolved(getDomain(), query));
	}

	/**
	 * 分页获取状态已解决和已关闭的工单，调用权限：end_user
	 * 
	 * @param url
	 *            分页请求下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getRequesterOrderListStatusSolvedWithURL(String url) {
		return buildPaginationRequesterList(sendGetRequest(url));
	}

	/**
	 * 获取用户的工单请求 调用权限：agent
	 * 
	 * @param user_id
	 *            用户id
	 * @return
	 */
	public KF5PaginationEntity<List<Ticket>> getRequesterOrderListByID(String user_id) {
		return getRequesterOrderListByID(user_id, "");
	}

	/**
	 * 分页获取用户的工单请求，调用权限：agent
	 * 
	 * @param user_id
	 *            用户id
	 * @param query
	 *            筛选条件 created_order：按创建时间排序规则，可选值：asc,desc (默认为desc)
	 *            updated_order：按更新时间排序规则，可选值：asc,desc
	 *            status_order：按工单状态排序规则，可选值：asc,desc field_order:
	 *            按自定义字段属性排序规则,参数格式：field_690_asc,或field_690_desc。
	 *            其中field_690为该工单的自定义字段name，可以通过 工单自定义字段接口获得 page 页码，默认为 1;
	 *            per_page 分页尺寸，默认为 100;
	 *            详情请浏览http://developer.kf5.com/restapi/requests/ 的工单请求列表
	 * @return
	 */
	public KF5PaginationEntity<List<Ticket>> getRequesterOrderListByID(String user_id, String query) {
		checkHasId(user_id);
		return getRequesterOrderListByURL(KF5Interface.getRequesterOrderListByID(getDomain(), user_id, query));
	}

	/**
	 * 分页获取用户的工单请求，调用权限：agent
	 * 
	 * @param url
	 *            下一页的请求url
	 * @return
	 */
	public KF5PaginationEntity<List<Ticket>> getRequesterOrderListByURL(String url) {
		return buildPaginationTicketList(sendGetRequest(url));
	}

	/**
	 * 获取指定用户的工单请求 调用权限：agent
	 * 
	 * @param organization_id
	 *            公司组织id
	 * @return
	 */

	public KF5PaginationEntity<List<Requester>> getOrganizationOrderList(String organization_id) {
		return getOrganizationOrderList(organization_id, "");
	}

	/**
	 * 分页获取指定用户的工单请求，调用权限：agent
	 * 
	 * @param organization_id
	 *            公司组织id
	 * @param query
	 *            筛选条件 created_order：按创建时间排序规则，可选值：asc,desc (默认为desc)
	 *            updated_order：按更新时间排序规则，可选值：asc,desc
	 *            status_order：按工单状态排序规则，可选值：asc,desc field_order:
	 *            按自定义字段属性排序规则,参数格式：field_690_asc,或field_690_desc。
	 *            其中field_690为该工单的自定义字段name，可以通过 工单自定义字段接口获得 ；page 页码，默认为 1;
	 *            per_page 分页尺寸，默认为 100;
	 *            详情请浏览http://developer.kf5.com/restapi/requests/ 的工单请求列表
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getOrganizationOrderList(String organization_id, String query) {
		checkHasId(organization_id);
		return getOrganizationOrderListByURL(
				KF5Interface.getOrganizationOrderList(getDomain(), organization_id, query));
	}

	/**
	 * 分页获取指定用户的工单请求，调用权限：agent
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> getOrganizationOrderListByURL(String url) {
		return buildPaginationRequesterList(sendGetRequest(url));
	}

	/**
	 * 搜索工单请求 调用权限：end_user query:查询关键词，模糊查询多个字段 status：状态筛选条件
	 * fieldvalue：自定义字段条件
	 * 
	 * @param keys
	 */
	public KF5PaginationEntity<List<Requester>> searchOrderByEndUser(String keys) {
		return searchOrderByEndUser(keys, 0, 0);
	}

	/**
	 * 分页搜索工单请求，调用权限：end_user ,query：查询关键词，模糊查询多个字段status;状态筛选条件
	 * fieldValue：自定义字段条件
	 * 
	 * @param keys
	 *            搜索关键字
	 * @param page
	 *            第几页
	 * @param per_page
	 *            每页数量
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> searchOrderByEndUser(String keys, int page, int per_page) {
		checkNotNull(keys);
		return searchOrderByEndUserWithURL(KF5Interface.searchOrder(getDomain(), keys, page, per_page));
	}

	/**
	 * 分页搜索工单请求
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Requester>> searchOrderByEndUserWithURL(String url) {
		return buildPaginationRequesterList(sendGetRequest(url));
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
		return buildRequester(sendGetRequest(KF5Interface.getOrderDetailByRequester(getDomain(), order_id)));
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
			buildRequester(kf5Entity, messageStatus);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildRequester(kf5Entity, messageStatus);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return getCommentListByEndUser(order_id, "");
	}

	/**
	 * 分页查看工单回复列表，调用权限：end_user
	 * 
	 * @param order_id
	 *            工单id
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 *            sort_order：排序规则，可选值：asc,desc (默认为asc) 详情请阅读
	 *            http://developer.kf5.com/restapi/requests/ 工单回复列表
	 * @return
	 */
	public KF5PaginationEntity<List<Comment>> getCommentListByEndUser(String order_id, String query) {
		checkHasId(order_id);
		return getCommentListByEndUserWithURL(KF5Interface.getCommentListByEndUser(getDomain(), order_id, query));
	}

	/**
	 * 分页查看工单回复列表，调用权限：end_user
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Comment>> getCommentListByEndUserWithURL(String url) {
		return buildPaginationListComment(sendGetRequest(url));
	}

	/**
	 * 查看指定工单回复 调用权限 ：end_user
	 * 
	 * @param requester_id
	 *            工单id
	 * @param id
	 *            回复id
	 */
	public KF5Entity<Comment> getOrderCommentWithID(String order_id, String id) {
		checkHasId(order_id, id);
		return buildComment(sendGetRequest(KF5Interface.getOrderCommentWithID(getDomain(), order_id, id)));
	}

	/**
	 * 工单回复列表 调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 */
	public KF5PaginationEntity<List<Comment>> getOrderCommentList(String order_id) {
		return getOrderCommentList(order_id, "");
	}

	/**
	 * 分页查看工单回复列表；调用权限：agent
	 * 
	 * @param order_id
	 *            工单id
	 * @param query
	 *            筛选条件 sort_order：排序规则，可选值：asc,desc (默认为asc)
	 *            默认按创建时间先后顺序排列，可添加排序参数： page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Comment>> getOrderCommentList(String order_id, String query) {
		checkHasId(order_id);
		return getOrderCommentListByURL(KF5Interface.getOrderCommentList(getDomain(), order_id, query));
	}

	/**
	 * 分页查看工单回复列表
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Comment>> getOrderCommentListByURL(String url) {
		return buildPaginationListComment(sendGetRequest(url));
	}

	/**
	 * 获取工单自定义字段列表 调用权限：agent
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldList() {
		return getTicketFieldListWithQuery("");
	}

	/**
	 * 分页获取工单自定义字段列表，调用权限：agent
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldListWithQuery(String query) {
		return getTicketFieldListWithURL(KF5Interface.getTicketFieldList(getDomain(), query));
	}

	/**
	 * 分页获取工单自定义字段列表，调用功能权限：agent
	 * 
	 * @param url
	 *            下一个的url
	 * @return
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldListWithURL(String url) {
		return buildPaginationTicketFieldList(sendGetRequest(url));
	}

	/**
	 * 获取状态为启用的自定义字段列表
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldListActive() {
		return getTicketFieldListActiveWithQuery("");
	}

	/**
	 * 分页获取状态为启用的自定义字段列表
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldListActiveWithQuery(String query) {
		return getTicketFieldListActiveWithURL(KF5Interface.getTicketFieldListActive(getDomain(), query));
	}

	/**
	 * 分页获取状态为启用的自定义字段列表
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<TicketField>> getTicketFieldListActiveWithURL(String url) {
		return buildPaginationTicketFieldList(sendGetRequest(url));
	}

	/**
	 * 查看自定义字段 调用权限：agent
	 * 
	 * @param ticket_field_id
	 *            自定义字段id
	 */
	public KF5Entity<TicketField> getTicketFieldByID(String ticket_field_id) {
		checkHasId(ticket_field_id);
		return buildTicketField(sendGetRequest(KF5Interface.getTicketFieldByID(getDomain(), ticket_field_id)));
	}

	/**
	 * 删除自定义字段 调用权限：admin
	 * 
	 * @param ticket_field_id
	 */
	public KF5Entity<String> deleteTicketFieldByID(String ticket_field_id) {

		checkHasId(ticket_field_id);
		return buildResultWithString(
				sendDeleteRequest(KF5Interface.deleteTicketFieldByID(getDomain(), ticket_field_id)));
	}

	/**
	 * 查看分类工单列表 ， 调用权限：agent
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeList() {
		return getOrderTypeListWithQuery("");
	}

	/**
	 * 分页查看分类工单列表，调用权限：agent
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeListWithQuery(String query) {
		return getOrderTypeListWithURL(KF5Interface.getOrderTypeList(getDomain(), query));
	}

	/**
	 * 分页查看分类工单列表 ，调用权限：agent
	 * 
	 * @param url
	 *            下一页url
	 * @return
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeListWithURL(String url) {
		return buildPaginationOrderTypeList(sendGetRequest(url));
	}

	/**
	 * 查看当前客服可用的工单查看分类 调用权限：agent
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeListActive() {
		return getOrderTypeListActiveWithQuery("");
	}

	/**
	 * 分页查看当前客服可用的工单分类，调用权限：agent
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeListActiveWithQuery(String query) {
		return getOrderTypeListActiveWithURL(KF5Interface.getOrderTypeListActive(getDomain(), query));
	}

	/**
	 * 分页查看当前客服可用的工单分类，调用权限：agent
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<View>> getOrderTypeListActiveWithURL(String url) {
		return buildPaginationOrderTypeList(sendGetRequest(url));
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
		return buildOrderType(sendGetRequest(KF5Interface.getOrderTypeListByID(getDomain(), type_id)));
	}

	/**
	 * 获取指定查看分类里的工单 调用权限：agent
	 * 
	 * @param type_id
	 *            分类id
	 */
	public KF5PaginationEntity<List<Ticket>> getTicketListByTypeID(String type_id) {
		return getTicketListByTypeID(type_id, "");
	}

	/**
	 * 分页查看指定分类里的工单，调用权限：agent
	 * 
	 * @param type_id
	 *            分类id
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Ticket>> getTicketListByTypeID(String type_id, String query) {
		checkHasId(type_id);
		return getTicketListByTypeIDWithURL(KF5Interface.getTicketListByTypeID(getDomain(), type_id, query));
	}

	/**
	 * 分页查看指定分类里的工单，调用权限：agent
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Ticket>> getTicketListByTypeIDWithURL(String url) {
		return buildPaginationTicketList(sendGetRequest(url));
	}

	/**
	 * 获取指定查看分类的工单个数 调用权限：agent
	 * 
	 * @param type_id
	 *            分类id
	 */
	public KF5Entity<ViewCount> getTicketCountByTypeID(String type_id) {

		checkHasId(type_id);
		return buildViewCount(sendGetRequest(KF5Interface.getTicketCountByTypeID(getDomain(), type_id)));
	}

	/**
	 * 获取多个查看分类的工单个数
	 * 
	 * @param ids
	 *            多个分类id; 如：1,2,3,4
	 */

	public KF5Entity<List<ViewCount>> getManyTicketCountByTypeIds(String ids) {

		checkHasId(ids);
		return buildListViewCount(sendGetRequest(KF5Interface.getManyTicketCountByTypeIds(getDomain()) + ids));
	}

	/**
	 * 获取用户列表 调用权限: agent
	 */
	public KF5PaginationEntity<List<User>> getUserList() {
		return getUserListWithQuery("");
	}

	/**
	 * 分页获取用户列表，调用权限：agent
	 * 
	 * @param query
	 *            筛选条件 role 用户角色，可选值：admin、agent、end_user，可组合使用如：admin,agent;
	 *            created_start 按创建时间筛选，开始时间; created_end 按创建时间筛选，结束时间;
	 *            updated_start 按更新时间筛选，开始时间; updated_end 按更新时间筛选，结束时间;
	 *            created_order 按创建时间排序，可选值：asc、desc; updated_order
	 *            按更新时间排序，可选值：asc、desc; page 页码，默认为 1; per_page 分页尺寸，默认为 100
	 *            备注：按创建和更新时间进行筛选的参数
	 *            created_start、created_end、updated_start、updated_end，支持日期格式（如
	 *            2016-01-01 00:00:00）和时间戳（秒级别的整型）。
	 *            详情请阅读http://developer.kf5.com/restapi/users/ 获取用户列表
	 * @return
	 */
	public KF5PaginationEntity<List<User>> getUserListWithQuery(String query) {
		return getUserListWithURL(KF5Interface.getUserList(getDomain(), query));
	}

	/**
	 * 分页获取用户列表，调用权限：agent
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<User>> getUserListWithURL(String url) {
		return buildPaginationUserList(sendGetRequest(url));
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
		return buildUser(sendGetRequest(KF5Interface.getUserInfo(getDomain(), user_id)));
	}

	/**
	 * 查看自己的信息 调用权限: all
	 * 
	 * @return
	 */

	public KF5Entity<User> getMyInfo() {
		return buildUser(sendGetRequest(KF5Interface.getMyInfo(getDomain())));
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
		return buildPaginationUserList(sendGetRequest(KF5Interface.getManyUsersInfo(getDomain()) + user_ids));
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
			buildUser(kf5Entity, messageStatus);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildUser(kf5Entity, messageStatus);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildUser(kf5Entity, messageStatus);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteUser(getDomain(), user_id)));
	}

	/**
	 * 搜索用户 调用权限:agent
	 * 
	 * @param key
	 *            搜索关键字
	 * @return
	 */
	public KF5PaginationEntity<List<User>> searchUser(String key) {
		return searchUser(key, 0, 0);
	}

	/**
	 * 分页搜索用户，调用权限：agent
	 * 
	 * @param key
	 *            搜索关键字
	 * @param page
	 *            第几页
	 * @param per_page
	 *            每页数量
	 * @return
	 */
	public KF5PaginationEntity<List<User>> searchUser(String key, int page, int per_page) {
		checkNotNull(key);
		return searchUserByURL(KF5Interface.searchUser(getDomain(), key, page, per_page));
	}

	/**
	 * 分页搜索用户，调用权限：agent
	 * 
	 * @param url
	 *            下一个的url
	 * @return
	 */
	public KF5PaginationEntity<List<User>> searchUserByURL(String url) {
		return buildPaginationUserList(sendGetRequest(url));
	}

	/**
	 * 获取用户自定义字段 调用权限:agent
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<UserField>> getUserFieldList() {
		return getUserFieldListWithQuery("");
	}

	/**
	 * 分页获取自定义字段，调用权限：agent
	 * 
	 * @param query
	 *            筛选条件 page 第几页 per_page 每页数量
	 * @return
	 */
	public KF5PaginationEntity<List<UserField>> getUserFieldListWithQuery(String query) {
		return getUserFieldListWithURL(KF5Interface.getUserFieldList(getDomain(), query));
	}

	/**
	 * 分页获取自定义字段，调用权限：agent
	 * 
	 * @param url
	 *            下一个的url
	 * @return
	 */
	public KF5PaginationEntity<List<UserField>> getUserFieldListWithURL(String url) {
		return buildPaginationUserFieldList(sendGetRequest(url));
	}

	/**
	 * 获取状态为启用的自定义字段列表 调用权限:agent
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<UserField>> getUserFieldActiveList() {
		return getUserFieldActiveListWithQuery("");
	}

	/**
	 * 分页获取状态为启用的自定义字段列表，调用权限：agent
	 * 
	 * @param query
	 *            筛选条件 page 第几页 per_page 每页数量
	 * @return
	 */
	public KF5PaginationEntity<List<UserField>> getUserFieldActiveListWithQuery(String query) {
		return getUserFieldActiveListWithURL(KF5Interface.getUserFieldActiveList(getDomain(), query));
	}

	/**
	 * 分页获取状态为启用的自定义字段列表，调用权限：agent
	 * 
	 * @param url
	 *            下一页的uel
	 * @return
	 */
	public KF5PaginationEntity<List<UserField>> getUserFieldActiveListWithURL(String url) {
		return getUserFieldListWithURL(url);
	}

	/**
	 * 查看用户自定义字段
	 * 
	 * @deprecated use {@link #getUserFieldByID(String)} instead
	 * @param user_field_id
	 *            用户自定义字段id
	 * @return
	 */
	public KF5Entity<UserField> getUserFieldListByID(String user_field_id) {
		return getUserFieldByID(user_field_id);

	}

	public KF5Entity<UserField> getUserFieldByID(String user_field_id) {
		checkHasId(user_field_id);
		return buildUserField(sendGetRequest(KF5Interface.getUserFieldListByID(getDomain(), user_field_id)));

	}

	/**
	 * 删除用户自定义字段 调用权限:admin
	 * 
	 * @param user_field_id
	 *            用户自定义字段id
	 */
	public KF5Entity<String> deleteUserField(String user_field_id) {
		checkHasId(user_field_id);
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteUserField(getDomain(), user_field_id)));
	}

	/**
	 * 客服组列表 调用权限：agent
	 */
	public KF5Entity<List<Group>> getGroupList() {
		return getGroupListWithQuery("");
	}

	/**
	 * 分页获取客服组列表，调用权限：agent
	 * 
	 * @param query
	 *            筛选条件 page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5Entity<List<Group>> getGroupListWithQuery(String query) {
		return getGroupListWithURL(KF5Interface.getGroupList(getDomain(), query));
	}

	/**
	 * 分页获取客服组列表，调用权限：agent
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5Entity<List<Group>> getGroupListWithURL(String url) {
		return buildGroupList(sendGetRequest(url));
	}

	/**
	 * 查看指定客服组 调用权限:agent
	 * 
	 * @deprecated use {@link #getGroupByID(String)} instead
	 * 
	 * @param group_id
	 *            客服组id
	 * @return
	 */

	public KF5Entity<Group> getGroupListByID(String group_id) {
		return getGroupByID(group_id);
	}

	/**
	 * 查看指定客服组，调用权限：agent
	 * 
	 * @param group_id
	 *            客服组id
	 * @return
	 */
	public KF5Entity<Group> getGroupByID(String group_id) {
		checkHasId(group_id);
		return buildGroup(sendGetRequest(KF5Interface.getGroupListByID(getDomain(), group_id)));
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
			buildGroup(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildGroup(sendPutRequest(KF5Interface.updateGroup(getDomain(), group_id),
				JSONObject.parse(jsonString).toString()));
	}

	/**
	 * 删除客服组 调用权限:admin
	 * 
	 * @param group_id
	 *            客服组id
	 */
	public KF5Entity<String> deleteGroup(String group_id) {
		checkHasId(group_id);
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteGroup(getDomain(), group_id)));
	}

	/**
	 * 获取公司组织列表 调用权限:agent
	 */
	public KF5PaginationEntity<List<Organization>> getOrganizationList() {

		return getOrganizationListWithQuery("");
	}

	/**
	 * 分页获取公司组织列表，调用权限：agent
	 * 
	 * @param query
	 *            筛选条件 created_start 按创建时间筛选，开始时间; created_end 按创建时间筛选，结束时间;
	 *            updated_start 按更新时间筛选，开始时间; updated_end 按更新时间筛选，结束时间;
	 *            created_order 按创建时间排序，可选值：asc、desc; updated_order
	 *            按更新时间排序，可选值：asc、desc page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 *            备注：按创建和更新时间进行筛选的参数
	 *            created_start、created_end、updated_start、updated_end，支持日期格式（如
	 *            2016-01-01 00:00:00）和时间戳（秒级别的整型）。
	 *            详情请浏览http://developer.kf5.com/restapi/organizations/ 下获取公司组织列表
	 * @return
	 */
	public KF5PaginationEntity<List<Organization>> getOrganizationListWithQuery(String query) {

		return getOrganizationListWithURL(KF5Interface.getOrganizationList(getDomain(), query));
	}

	/**
	 * 分页获取公司组织列表，调用权限：agent
	 * 
	 * @param url
	 *            下一页url
	 * @return
	 */
	public KF5PaginationEntity<List<Organization>> getOrganizationListWithURL(String url) {
		return buildPaginationOrganizationList(sendGetRequest(url));
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
		return buildOrganization(sendGetRequest(KF5Interface.getOrganizationByID(getDomain(), organization_id)));
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

		return buildOrganization(
				sendPostRequest(KF5Interface.createOrganization(getDomain()), JSONObject.parse(jsonString).toString()));
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
			buildOrganization(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteOrganization(getDomain(), organization_id)));
	}

	/**
	 * 获取社区话题列表 调用权限:all
	 */
	public KF5PaginationEntity<List<Topic>> getTopicList() {
		return getTopicListWithQuery("");
	}

	/**
	 * 分页获取社区话题列表，调用权限：all
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Topic>> getTopicListWithQuery(String query) {
		return getTopicListWithURL(KF5Interface.getTopicList(getDomain(), query));
	}

	/**
	 * 分页获取社区话题列表，调用权限：all
	 * 
	 * @param url
	 *            下一页url
	 * @return
	 */
	public KF5PaginationEntity<List<Topic>> getTopicListWithURL(String url) {
		return buildPaginationTopicList(sendGetRequest(url));
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
		return buildTopic(sendGetRequest(KF5Interface.getTopicByID(getDomain(), topic_id)));
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
			buildTopic(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildTopic(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteTopic(getDomain(), topic_id)));
	}

	/**
	 * 获取社区问题列表 调用权限：all
	 */

	public KF5PaginationEntity<List<Question>> getQuestionList() {
		return getQuestionListWithQuery("");
	}

	/**
	 * 分页获取社区话题列表，调用权限：all
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Question>> getQuestionListWithQuery(String query) {
		return getQuestionListWithURL(KF5Interface.getQuestionList(getDomain(), query));
	}

	/**
	 * 分页获取社区话题列表，调用权限：all
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Question>> getQuestionListWithURL(String url) {
		return buildPaginationQuestionList(sendGetRequest(url));
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
		return buildQuestion(sendGetRequest(KF5Interface.getQuestionByID(getDomain(), question_id)));

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
			buildQuestion(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildQuestion(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteQuestion(getDomain(), question_id)));
	}

	/**
	 * 获得问题回复列表 调用权限:all
	 * 
	 * @param question_id
	 *            社区问题id
	 */
	public KF5PaginationEntity<List<QuestionComment>> getQuestionCommentList(String question_id) {
		return getQuestionCommentList(question_id, "");
	}

	/**
	 * 分页获取问题回复列表，调用权限：all
	 * 
	 * @param question_id
	 *            社区问题id
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<QuestionComment>> getQuestionCommentList(String question_id, String query) {
		checkHasId(question_id);
		return getQuestionCommentListByURL(KF5Interface.getQuestionCommentList(getDomain(), question_id, query));
	}

	/**
	 * 分页获取问题回复列表，调用权限：all
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<QuestionComment>> getQuestionCommentListByURL(String url) {

		return buildPaginationQuestionCommentList(sendGetRequest(url));
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
		MessageStatus messageStatus = sendGetRequest(
				KF5Interface.getQuestionCommentByID(getDomain(), question_id, comment_id));
		return buildQuestionComment(messageStatus);

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
			buildPaginationQuestionCommentList(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
		}
		return kf5Entity;
	}

	/**
	 * 文档分区列表 调用权限：all
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<Category>> getCategoriesList() {
		return getCategoriesListWithQuery("");
	}

	/**
	 * 分页获取文档分区列表
	 * 
	 * @param query
	 *            筛选条件 page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Category>> getCategoriesListWithQuery(String query) {

		return getCategoriesListWithURL(KF5Interface.getCategoriesList(getDomain(), query));

	}

	/**
	 * 分页获取文档分区列表
	 * 
	 * @param url
	 *            下一页url
	 * @return
	 */
	public KF5PaginationEntity<List<Category>> getCategoriesListWithURL(String url) {

		return buildPaginationCategoriesList(sendGetRequest(url));

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
		return buildCategory(sendGetRequest(KF5Interface.getCategoryByID(getDomain(), category_id)));

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
			buildCategory(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildCategory(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteCategory(getDomain(), category_id)));
	}

	/**
	 * 获取文档分类列表 调用权限:all
	 */
	public KF5PaginationEntity<List<Forum>> getForumList() {

		return getForumListWithQuery("");

	}

	/**
	 * 分页获取文档分类列表，调用权限：all
	 * 
	 * @param query
	 *            筛选条件 page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Forum>> getForumListWithQuery(String query) {

		return getForumListWithURL(KF5Interface.getForumList(getDomain(), query));

	}

	/**
	 * 分页获取文档分类列表，调用权限：all
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Forum>> getForumListWithURL(String url) {

		return buildPaginationForumList(sendGetRequest(url));

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
		return buildForum(sendGetRequest(KF5Interface.getForumByID(getDomain(), forum_id)));
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
			buildForum(messageStatus, kf5Entity);
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
			buildForum(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildResultWithString(sendDeleteRequest(KF5Interface.deleteForum(getDomain(), forum_id)));
	}

	/**
	 * 获取正式文档列表 调用权限:all
	 */
	public KF5PaginationEntity<List<Post>> getPostList() {
		return getPostListWithQuery("");
	}

	/**
	 * 分页获取正式文档列表，调用权限：all
	 * 
	 * @param query
	 *            page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<Post>> getPostListWithQuery(String query) {
		return getPostListWithURL(KF5Interface.getPostList(getDomain(), query));
	}

	/**
	 * 分页获取正式文档列表，调用权限：all
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Post>> getPostListWithURL(String url) {
		return buildPaginationPostList(sendGetRequest(url));
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
		return buildPost(sendGetRequest(KF5Interface.getPostDetail(getDomain(), post_id)));
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
		return buildListPost(sendGetRequest(KF5Interface.getManyPosts(getDomain(), posts_ids)));
	}

	/**
	 * 搜索文档 调用权限: all
	 * 
	 * @param key_word
	 *            搜索关键字
	 * @return
	 */

	public KF5PaginationEntity<List<Post>> searchPost(String key_word) {

		return searchPost(key_word, 0, 0);
	}

	/**
	 * 分页搜索文档，调用权限：all
	 * 
	 * @param key_word
	 *            搜索关键字
	 * @param page
	 *            第几页
	 * @param per_page
	 *            每页数量
	 * @return
	 */
	public KF5PaginationEntity<List<Post>> searchPost(String key_word, int page, int per_page) {
		checkNotNull(key_word);
		return searchPostByURL(KF5Interface.searchPost(getDomain(), key_word, page, per_page));
	}

	/**
	 * 分页搜索文档，调用权限：all
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<Post>> searchPostByURL(String url) {

		return buildPaginationPostList(sendGetRequest(url));
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
			buildPost(messageStatus, kf5Entity);
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		return buildPost(
				sendPutRequest(KF5Interface.updatePost(getDomain(), post_id), JSONObject.parse(jsonString).toString()));
	}

	/**
	 * 删除文档 调用权限:admin
	 * 
	 * @param post_id
	 *            文档id
	 */
	public KF5Entity<String> deletePost(String post_id) {

		checkHasId(post_id);
		return buildResultWithString(sendDeleteRequest(KF5Interface.deletePost(getDomain(), post_id)));
	}

	/**
	 * 获取文档回复列表 调用权限:all
	 * 
	 * @param post_id
	 *            文档id
	 */
	public KF5PaginationEntity<List<PostComment>> getPostCommentList(String post_id) {

		return getPostCommentList(post_id, "");
	}

	/**
	 * 分页获取文档回复列表，调用权限：all
	 * 
	 * @param post_id
	 *            文档id
	 * @param query
	 *            筛选条件 page 页码，默认为 1; per_page 分页尺寸，默认为 100;
	 * @return
	 */
	public KF5PaginationEntity<List<PostComment>> getPostCommentList(String post_id, String query) {

		checkHasId(post_id);
		return getPostCommentListByURL(KF5Interface.getPostCommentList(getDomain(), post_id, query));
	}

	/**
	 * 分页获取文档回复列表，调用权限：all
	 * 
	 * @param url
	 *            下一页的url
	 * @return
	 */
	public KF5PaginationEntity<List<PostComment>> getPostCommentListByURL(String url) {

		return buildPaginationPostCommentList(sendGetRequest(url));
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
		return buildPostComment(sendGetRequest(KF5Interface.getPostCommentByID(getDomain(), post_id, id)));
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
		return buildPostComment(
				sendPostRequest(KF5Interface.postReply(getDomain(), post_id), JSONObject.parse(jsonString).toString()));
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
			dealErrorData(kf5Entity, e.getMessage());
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
		MessageStatus messageStatus = sendGetRequest(KF5Interface.viewAttachment(getDomain(), attachment_id));
		return buildAttachment(messageStatus);
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
		return buildResultWithString(messageStatus);
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
			buildTicket(messageStatus, kf5Entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dealErrorData(kf5Entity, e.getMessage());
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
		MessageStatus messageStatus = sendGetRequest(KF5Interface.orderExport(getDomain(), param));
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

	/**
	 * 获取对话列表 GET请求 调用权限：Agent
	 * 
	 * @param domain
	 *            平台地址
	 * @param query
	 *            附加筛选规则； visitor_id 筛选指定访客的对话列表; start
	 *            按创建时间筛选，开始时间，如：2016-01-01 ; end 按结束时间筛选，结束时间，如：2016-01-01;
	 *            user_id 工单系统用户ID（IM访客已关联工单系统用户）; page 页码，默认为 1 ; per_page
	 *            分页尺寸，默认为 100
	 *            详情请浏览http://developer.kf5.com/restapi/chats/下对话列表的Query参数
	 */
	public KF5PaginationEntity<List<Chat>> getChatListWithQueryParams(String query) {
		return buildPaginationChatList(sendGetRequest(KF5Interface.getChatList(getDomain(), query)));
	}

	/**
	 * 获取对话列表 GET请求 调用权限：Agent 该接口用于分页请求对话列表时调用的接口，url为 KF5PaginationEntity的
	 * nextPage属性；具体调用逻辑为先调用{@link #getChatListWithQueryParams(String)}
	 * ,返回值KF5PaginationEntity的nextPage属性如果不为空，以后即可调用当前接口。
	 * 
	 * @param url
	 *            分页请求的url
	 * @return 对应的会话列表
	 */
	public KF5PaginationEntity<List<Chat>> getChatListWithURL(String url) {
		return buildPaginationChatList(sendGetRequest(url));
	}

	/**
	 * 查看某个对话的详情 GET请求 调用权限：Agent
	 * 
	 * @param chat_id
	 *            会话id
	 * @return 返回某个对话的详细内容
	 */
	public KF5Entity<Chat> getChatDetailByChatId(int chat_id) {

		return buildChat(sendGetRequest(KF5Interface.getChatDetailByID(getDomain(), chat_id)));
	}

	/**
	 * 获取机器人问题列表 调用权限：admin
	 * 
	 * @param query
	 *            筛选参数: category_id 所属问题分组ID; page 页码，默认为 1; per_page 分页尺寸，默认为
	 *            100
	 * @return
	 */
	public KF5PaginationEntity<List<AICategory>> getAiQuestionList(String query) {

		return buildPaginationListAICategory(sendGetRequest(KF5Interface.getAIQuestionList(getDomain(), query)));
	}

	/**
	 * 创建机器人题库问题 调用权限：admin
	 * 
	 * @param jsonString
	 * @return
	 */
	public KF5PaginationEntity<List<AICategory>> createAIQuestion(String jsonString) {
		return buildPaginationListAICategory(sendPostRequest(KF5Interface.createAIQuestion(getDomain()), jsonString));
	}

	/**
	 * 修改机器人题库中的问题 调用权限：admin
	 * 
	 * @param id
	 * @param jsonString
	 * @return
	 */
	public KF5Entity<AICategory> updateQuestionByID(int id, String jsonString) {

		return buildAICategory(sendPutRequest(KF5Interface.updateQuestionByID(getDomain(), id), jsonString));
	}

	/**
	 * 删除机器人的某些问题题库，支持批量删除
	 * 
	 * @param params
	 *            需要批量删除的题库的id参数。具体格式为{"ids": [13,14]}
	 */
	public void deleteQuestionById(String params) {
		sendDeleteRequest(KF5Interface.deleteQuestionById(getDomain()), params);
	}

	/**
	 * 获取机器人题库分组列表 调用权限：admin
	 * 
	 * @param query
	 *            筛选参数: page 页码，默认为 1 ;per_page 分页尺寸，默认为 100
	 * 
	 * @return
	 */
	public KF5PaginationEntity<List<AIQuestionCategory>> getQuestionCategoriesList(String query) {
		return buildPaginationAIQuestionCategoryList(sendGetRequest(KF5Interface.getQuestionCategoriesList(getDomain(), query)));
	}

	/**
	 * 创建机器人题库分组 调用权限：admin
	 * 
	 * @param params
	 * @return
	 */
	public KF5PaginationEntity<List<AIQuestionCategory>> createQuestionCategories(String params) {
		return buildPaginationAIQuestionCategoryList(sendPostRequest(KF5Interface.createQuestionCategories(getDomain()), params));
	}

	/**
	 * 修改机器人题库分组 调用权限：admin
	 * 
	 * @param id
	 *            题库id
	 * @param params
	 *            修改的内容
	 * @return
	 */
	public KF5Entity<AIQuestionCategory> updateQuestionCategories(int id, String params) {
		return buildAIQuestionCategory(sendPutRequest(KF5Interface.updateQuestionCategories(getDomain(), id), params));
	}

	/**
	 * 删除机器人题库分组 调用权限：admin
	 * 
	 * @param params
	 *            需要批量删除的题库的id参数。具体格式为{"ids": [13,14]}
	 */
	public void deleteQuestionCategories(String params) {
		sendDeleteRequest(KF5Interface.deleteQuestionCategories(getDomain()), params);
	}

}
