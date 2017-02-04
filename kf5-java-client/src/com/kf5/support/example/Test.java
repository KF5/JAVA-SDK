package com.kf5.support.example;


import com.kf5.support.controller.KF5Support;

public class Test {

	public static void main(String[] args) {

		final KF5Support kf5Support = new KF5Support();
		 kf5Support.initWithApiToken("xxxxx.kf5.com", "6xxxx@qq.com",
		 "719f39xxxxf3dce33xx8d8d1xxxx392");
		// kf5Support.initWithPassword("xxxxx.kf5.com", "1xxxx@qq.com",
		// "1xxxx");
		// kf5Support.getAgentOrderList("https://tianxiang.kf5.com/apiv2/tickets.json?per_page=1&page=2");
		// kf5Support.getAgentOrderListWithID("586");
		// kf5Support.getAgentOrderListWithID("586",1,1);
//		 kf5Support.getAgentOrderListWithPaginationUrlAndID("https://tianxiang.kf5.com/apiv2/users/586/tickets.json?per_page=1&id=586&page=2");
//		 kf5Support.getAgentTicketDetail("75");
		// kf5Support.getAgentManyTickets("73,74,75,86,68,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16"
		// +
		// ",15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60");
		// KF5Entity<Ticket> kf5Entity=
		// kf5Support.createAgentOrder("{ticket:{title: \"Let's create
		// ticket\",\"comment\": {\"content\": \"what are you waiting
		// for?\"}}}");
		// System.out.println("====="+kf5Entity.getData().getTitle());
		// KF5Entity<Ticket> kf5Entity=
		// kf5Support.updateAgentOrder("73","{ticket:{title:
		// \"你在哪里\",\"comment\": {\"content\": \"what are you waiting
		// for?\"}}}");
		// System.out.println("===="+kf5Entity.getResultCode()+"======"+kf5Entity.getData().getTitle());
		// KF5Entity<String> kf5Entity= kf5Support.updateManyAgentOrder("73",
		// "{\"ticket\": {\"title\":\"我是你大爷\"}}");
		// System.out.println("======"+
		// kf5Entity.getData()+"===="+kf5Entity.getResultCode());
		// kf5Support.deleteAgentOrder("86");
		// kf5Support.deleteManyAgentOrders("2282,2280");
		// KF5Entity<List<User>> kf5Entity=
		// kf5Support.getAgentOrderCollaborators("23");
		// kf5Support.getAgentOrderIncidentList("25");
		// kf5Support.getAgentOrderProblemList();
//		KF5PaginationEntity<List<Requester>> aEntity = kf5Support.getRequesterOrderList();
//		System.out.println("=====" + aEntity.getCount() + "===" + aEntity.getNextPage() + "===="
//				+ aEntity.getData().get(0).getTitle());
				// kf5Support.getRequesterOrderList(1,1);
				// kf5Support.getRequesterOrderList("https://wuruo.kf5.com/apiv2/requests.json?per_page=1&page=2");
				// kf5Support.getRequesterOrderListStatusOpen();
				// kf5Support.getRequesterOrderListStatusOpen(1, 1);
				// System.out.println(kf5Support.getRequesterOrderListStatusOpen("https://wuruo.kf5.com/apiv2/requests/open.json?per_page=1&page=2").getNextPage());
				// kf5Support.getRequesterOrderListStatusSolved();
				// kf5Support.getRequesterOrderListStatusSolved(1,1);
				// kf5Support.getRequesterOrderListStatusSolved("https://wuruo.kf5.com/apiv2/requests/open.json?per_page=1&page=2");
				// kf5Support.getRequesterOrderListByID("445347");
				// kf5Support.getRequesterOrderListByID("445347", 0, 1);
				// kf5Support.getRequesterOrderListByURL("https://wuruo.kf5.com/apiv2/users/445347/requests.json?per_page=1&id=445347&page=2");
				// kf5Support.getOrganizationOrderList("18139");
				// kf5Support.getOrganizationOrderList("18139",1,1);
				// kf5Support.getOrganizationOrderListByURL("https://wuruo.kf5.com/apiv2/organizations/18139/requests.json?per_page=1&id=18139&page=2");
				// kf5Support.searchOrderByEndUser("status=open");
				// kf5Support.searchOrderByEndUser("status=open", 1, 1);
		// kf5Support.searchOrderByEndUserWithURL("https://wuruo.kf5.com/apiv2/requests/search.json?status=open&per_page=1&page=2");
				// kf5Support.getOrderDetailByEndUser("32");
				// kf5Support.initWithApiToken("joymay.kf5.com",
				// "384069799@qq.com",
				// "c0b3d0ea4e95d754fe5d0f128934e8");
//				JSONObject requestObj = new  JSONObject();
//				requestObj.put("title", "被雷焦的新工单标题132asd132as321d");
//				JSONObject commentObj = new JSONObject();
//				commentObj.put("content", "大家好，我是一条新工单?");
//				requestObj.put("comment", commentObj);
//				JSONArray fieldArray = new JSONArray();
//				JSONObject itemObj = new JSONObject();
//				itemObj.put("name", "field_7515");
//				itemObj.put("value", "1871234567");
//				fieldArray.add(itemObj);
//				
//				JSONObject itemObj1 = new JSONObject();
//				itemObj1.put("name", "field_7868");
//				itemObj1.put("value", "售前问题");
//				fieldArray.add(itemObj1);
//				requestObj.put("custom_fields", fieldArray);
//				JSONObject dataObj = new JSONObject();
//				dataObj.put("request", requestObj);
//				 kf5Support.createOrderByEndUser("{\"request\":{\"title\":\"被雷焦的新工单标题132asd132as321d\",\"comment\":{\"content\": \"大家好，我是一条新工单?\","
//				 		+ "\"custom_fields\":[{\"name\": \"field_7515\",\"value\": \"1871234567\"}]}}}");
//				kf5Support.createOrderByEndUser(dataObj.toJSONString());
				// kf5Support.replyOrderByEndUser("94",
				// "{\"request\":{\"title\":\"你大爷12345879\",\"comment\":
				// {\"content\": \"what are you waiting for123654?\"}}}");
				// kf5Support.replyOrderByEndUser("520",
				// "{\"request\":{\"title\":
				// \"你大爷\",\"comment\": {\"content\":
				// \"反正很奇怪\",\"custom_fields\":[],\"description\":\"真的很奇怪\",\"title\":\"不吃药萌萌哒\",\"requester_id\":0,\"id\":0,\"group_id\":0}}}");
				// kf5Support.replyOrderByEndUser("520",
				// "{\"request\":{\"custom_fields\":[],\"description\":\"图图寂寞哦\",\"title\":\"不吃药萌萌哒\",\"requester_id\":0,\"id\":0,\"group_id\":0}}");
				// kf5Support.getCommentListByEndUser("94");
				// kf5Support.getCommentListByEndUser("94",1,1);
				// kf5Support.getCommentListByEndUserWithURL("https://wuruo.kf5.com/apiv2/requests/94/comments.json?per_page=1&id=94&page=2");
				// kf5Support.getOrderCommentWithID("94", "9891489");
				// kf5Support.getOrderCommentList("94");
				// kf5Support.getOrderCommentList("94",1,1);
				// kf5Support.getOrderCommentListByURL("https://wuruo.kf5.com/apiv2/tickets/94/comments.json?per_page=1&id=94&page=2");
				// KF5PaginationEntity<List<TicketField>> kf5Entity =
//				 kf5Support.getTicketFieldList();
				// kf5Support.getTicketFieldList(1,1);
				// kf5Support.getTicketFieldList("https://wuruo.kf5.com/apiv2/ticket_fields.json?per_page=1&page=2");
				// kf5Support.getTicketFieldListActive();
				// kf5Support.getTicketFieldListActive(1,1);
				// kf5Support.getTicketFieldListActive("https://wuruo.kf5.com/apiv2/ticket_fields/active.json?per_page=1&page=2");
				// kf5Support.getTicketFieldByID("8654");
				// kf5Support.deleteTicketFieldByID("8654");
				// kf5Support.getOrderTypeList();
				// kf5Support.getOrderTypeList(1,1);
				// kf5Support.getOrderTypeList("https://wuruo.kf5.com/apiv2/views.json?per_page=1&page=2");
				// kf5Support.getOrderTypeListActive();
				// kf5Support.getOrderTypeListActive(1,1);
				// kf5Support.getOrderTypeListActive("https://wuruo.kf5.com/apiv2/views/active.json?per_page=1&page=2");
				// kf5Support.getOrderTypeByID("243492");
				// kf5Support.getTicketListByTypeID("243492");
				// kf5Support.getTicketListByTypeID("243492",1,1);
				// kf5Support.getTicketListByTypeIDWithURL("https://wuruo.kf5.com/apiv2/views/243492/tickets.json?per_page=1&id=243492&page=2");
				// kf5Support.getTicketCountByTypeID("243492");
				// kf5Support.getManyTicketCountByTypeIds("243492,243491");
				// kf5Support.getUserList();
				// kf5Support.getUserList(1,1);
				// kf5Support.getUserList("https://wuruo.kf5.com/apiv2/users.json?per_page=1&page=2");
				// kf5Support.getUserInfo("445347");
				// kf5Support.getMyInfo();
				// kf5Support.getManyUsersInfo("123,122");

		// kf5Support.mergeUser("589280", "{\"user\": {\"id\": 123}}");
		// kf5Support.updateUserInfo("10556", "{\"user\": {\"name\":
		// \"你大爷\"}}");
		// kf5Support.deleteUser("10961");
		// kf5Support.searchUser("123");
		// kf5Support.searchUser("123",1,1);
		// kf5Support.searchUserByURL("https://wuruo.kf5.com/apiv2/users/search.json?query=123&per_page=1&page=2");
//		 kf5Support.getUserFieldList();
		// kf5Support.getUserFieldList(1,1);
		// kf5Support.getUserFieldActiveList();
		// kf5Support.getUserFieldListByID("1057");
		// kf5Support.deleteUserField("1");
		// kf5Support.getGroupList();
		// kf5Support.getGroupList(1,1);
		// kf5Support.getGroupList("https://wuruo.kf5.com/apiv2/groups.json?per_page=1&page=2");
		// kf5Support.getGroupListByID("12077");
		// kf5Support.createGroup("{\"group\": {\"name\": \"My Group\"}}");
		// kf5Support.updateGroup("30091", "{\"group\": {\"name\":\"Interesting
		// Group\"}}");
		// kf5Support.deleteGroup("13434");
		// kf5Support.getOrganizationList();
		// kf5Support.getOrganizationList(1,1);
		// kf5Support.getOrganizationList("https://wuruo.kf5.com/apiv2/organizations.json?per_page=1&page=2");
		// kf5Support.getOrganizationByID("18139");
		// kf5Support.createOrganization("{\"organization\": {\"name\": \"My
		// Organization\"}}");
		// kf5Support.updateOrganization("50875","{\"organization\":
		// {\"description\": \"呵呵，来修改一下\"}}");
		// kf5Support.deleteOrganization("19845");
		// kf5Support.getTopicList();
		// kf5Support.getTopicList(1,1);
		// kf5Support.getTopicByID("9506");
		// kf5Support.createTopic("{\"topic\": {\"title\": \"this is topic
		// title\",\"description\": \"description123465\"}}");
		// kf5Support.updateTopic("24959", "{\"topic\": {\"title\": \"新标题\"}}");
		// kf5Support.deleteTopic("11784");
		// kf5Support.getQuestionList();
		// kf5Support.getQuestionList(1,1);
		// kf5Support.getQuestionByID("2617");
		// kf5Support.createQuestion("{\"question\":
		// {\"title\":\"我是你大爷\",\"topic_id\": 8881,\"content\": \"this is
		// content\"}}");
		// kf5Support.updateQuestion("306952", "{\"question\":
		// {\"title\":\"修改标题\"}}");
		// kf5Support.deleteQuestion("3292");
		// kf5Support.getQuestionCommentList("3010");
		// kf5Support.getQuestionCommentByID("3010", "2434");
		// kf5Support.replyQuestion("3207", "{\"request\": {\"comment\":
		// {\"content\": \"我是你大爷\"}}}");
		// kf5Support.getCategoriesList();
		// kf5Support.getCategoriesList(1,1);
		// kf5Support.getCategoriesList("https://tianxiang.kf5.com/apiv2/categories.json?per_page=1&page=2");
		// kf5Support.getCategoryByID("26506");
		// kf5Support.createCategory("{\"category\": {\"title\": \"post
		// category\",\"content\": \"this is content\"}}");
		// kf5Support.updateCategory("28597", "{\"category\":
		// {\"title\":\"商户合作1\"}}");
		// kf5Support.deleteCategory("13546");
		// kf5Support.getForumList();
		// kf5Support.getForumList(1,1);
		// kf5Support.getForumList("https://tianxiang.kf5.com/apiv2/forums.json?per_page=1&page=2");
		// kf5Support.getForumByID("104104");
		// kf5Support.createForum("{\"forum\": {\"title\": \"this is forums
		// title\",\"category_id\": \"10232\",\"content\": \"this is
		// content\",\"role_view\": \"all\"}}");
		// kf5Support.updateForum("53112", "{\"forum\": {\"title\": \"呵呵\"}}");
		// kf5Support.deleteForum("53112");
		// kf5Support.getPostList();
		// kf5Support.getPostList(1,1);
		// kf5Support.getPostList("https://tianxiang.kf5.com/apiv2/posts.json?per_page=1&page=2");
		// kf5Support.getPostByID("212083");
		// kf5Support.getManyPosts("212083");
		// kf5Support.searchPost("1");
		// kf5Support.searchPost("1",1,1);
		// kf5Support.createPost("{\"post\": {\"title\": \"this is post
		// title\",\"forum_id\":47630,\"content\": \"this is content\"}}");
		// kf5Support.updatePost("76180", "{\"post\": {\"title\": \"修改文档\"}}");
		// kf5Support.deletePost("75584");
		// kf5Support.getPostCommentList("197487");
		// kf5Support.getPostCommentList("197487",1,1);
		// kf5Support.getPostCommentByID("70873", "3896");
		// kf5Support.postReply("70873", "{\"post_comment\": {\"content\":
		// \"this is api test content\"}}");
		// kf5Support.uploadAttachment("D://test.txt");
		// kf5Support.uploadAttachment("D://bug.jpg");
		// kf5Support.viewAttachment("225709");
		// kf5Support.deleteAttachment("223997");
		// kf5Support.importOrder("{\"ticket\": {\"requester_id\":586,\"title\":
		// \"Help\", \"comments\": [{ \"author_id\": 563265, \"content\": \"This
		// is a comment\"}]}}");
		// kf5Support.orderExport("");
		 kf5Support.getChatListWithQueryParams("start=2017-01-21");
		// KF5Entity<Chat> kf5Entity = kf5Support.getChatDetailByChatId(276);
		// KF5PaginationEntity<List<AICategory>> liEntity=
		// kf5Support.getAiQuestionList(0, 1, 1);
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("category_id", 0);
		// jsonObject.put("title", "测试数据");
		// jsonObject.put("answer", "你确定要这样测试么");
		// jsonObject.put("other_titles", "[\"我要换货\",\"我要退订\"]");
		// JSONArray jsonArray = new JSONArray();
		// jsonArray.add(jsonObject);
		// JSONObject dataObj = new JSONObject();
		// dataObj.put("data", jsonArray);
		// KF5PaginationEntity<List<AICategory>> lEntity=
		// kf5Support.createAIQuestion(dataObj.toString());
		// System.out.println("====="+lEntity.getNextPage()+"===="+lEntity.getData().get(0).getAnswer());
		// List<AIQuestion> list = kf5Entity.getData();
		// System.out.println("长度" + list.size() + "=====" +
		// list.get(0).getOther_titles().toString() + "====="
		// + list.get(0).getTitle());

		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("answer", "再次修改一下");
		// JSONObject dataObj = new JSONObject();
		// dataObj.put("data", jsonObject);
		// KF5Entity<AICategory> kf5Entity= kf5Support.updateQuestionByID(10359,
		// dataObj.toString());
		// System.out.println(kf5Entity.getData().getAnswer()+"========");
		// JSONArray jsonArray = new JSONArray();
		// jsonArray.add("10359");
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("ids", jsonArray);
		// kf5Support.deleteQuestionById(jsonObject.toJSONString());
//		 kf5Support.getQuestionCategoriesList("呵呵");
		// JSONArray jsonArray = new JSONArray();
		// jsonArray.add("技术");
		// jsonArray.add("售后");
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("data", jsonArray);
		// kf5Support.createQuestionCategories(jsonObject.toString());
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("title", "修改技术好的");
		// JSONObject dataObj = new JSONObject();
		// dataObj.put("data", jsonObject);
		// kf5Support.updateQuestionCategories(446, dataObj.toString());
		// JSONArray jsonArray = new JSONArray();
		// jsonArray.add(446);
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("ids", jsonArray);
		// kf5Support.deleteQuestionCategories(jsonObject.toString());
	}

}
