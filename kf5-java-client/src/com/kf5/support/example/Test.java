package com.kf5.support.example;

import com.kf5.support.controller.KF5Support;

public class Test {

	public static void main(String[] args) {

		KF5Support kf5Support = new KF5Support();

		kf5Support.initWithApiToken("xxx.kf5.com", "xxxxxxx@qq.com", "71662da0axxxxxxf0137a");
		//		kf5Support.initWithPassword("xxxxxx.kf5.com", "1xxxxxxx9@qq.com", "11xxxx1");
		//				kf5Support.getAgentOrderList();
		//				kf5Support.getAgentOrderListWithID("258");
		//		kf5Support.getAgentTicketDetail("32");
		//		kf5Support.getAgentManyTickets("32,1");
		//				kf5Support.createAgentOrder("{ticket:{title: \"Let's create ticket\",\"comment\": {\"content\": \"what are you waiting for?\"}}}");
		//		kf5Support.updateAgentOrder("2279","{ticket:{title: \"你在哪里\",\"comment\": {\"content\": \"what are you waiting for?\"}}}");
		//		kf5Support.updateManyAgentOrder("1", "{\"ticket\": {\"title\": \"我是你大爷\"}}");
		//				kf5Support.deleteAgentOrder("3889");
		//		kf5Support.deleteManyAgentOrders("2282,2280");
		//		kf5Support.getAgentOrderCollaborators("1");
		//		kf5Support.getAgentOrderIncidentList("32");
		//		kf5Support.getAgentOrderProblemList();
		//				kf5Support.getRequesterOrderList();	
		//		kf5Support.getRequesterOrderListStatusOpen();
		//		kf5Support.getRequesterOrderListStatusSolved();
		//		kf5Support.getRequesterOrderListByID("586");
		//		kf5Support.getOrganizationOrderList("17783");
		//		kf5Support.searchOrderByEndUser("status=open");
		//		kf5Support.getOrderDetailByEndUser("288");
		kf5Support.createOrderByEndUser("{\"request\":{\"title\": \"create ticket\",\"comment\": {\"content\": \"what are you waiting for?\"}}}");
		//		kf5Support.createOrderByEndUser("{\"request\":{\"title\": \"被雷焦的新工单标题\",\"comment\": {\"content\": \"大家好，我是一条新工单?\"}}}");
		//				kf5Support.replyOrderByEndUser("520", "{\"request\":{\"title\": \"你大爷\",\"comment\": {\"content\": \"what are you waiting for?\"}}}");
		//				kf5Support.replyOrderByEndUser("520", "{\"request\":{\"title\": \"你大爷\",\"comment\": {\"content\": \"反正很奇怪\",\"custom_fields\":[],\"description\":\"真的很奇怪\",\"title\":\"不吃药萌萌哒\",\"requester_id\":0,\"id\":0,\"group_id\":0}}}");
		//				kf5Support.replyOrderByEndUser("520", "{\"request\":{\"custom_fields\":[],\"description\":\"图图寂寞哦\",\"title\":\"不吃药萌萌哒\",\"requester_id\":0,\"id\":0,\"group_id\":0}}");
		//		kf5Support.getCommentListByEndUser("14406");
		//		kf5Support.getOrderCommentWithID(null, "205586");
		//		kf5Support.getOrderCommentList("32");	
		//		kf5Support.getTicketFieldList();
		//		kf5Support.getTicketFieldListActive();
		//		kf5Support.getTicketFieldByID("103");
		//		kf5Support.deleteTicketFieldByID("4183");
		//		kf5Support.getOrderTypeList();
		//		kf5Support.getOrderTypeListActive();
		//		kf5Support.getOrderTypeByID("241284");
		//		kf5Support.getTicketListByTypeID("284859");
		//		kf5Support.getTicketCountByTypeID("284859");
		//		kf5Support.getManyTicketCountByTypeIds("284859,241284");
		//		kf5Support.getUserList();
		//		kf5Support.getUserInfo("123");
		//				kf5Support.getMyInfo();
		//		kf5Support.getManyUsersInfo("123,122");
		//		kf5Support.createUserInfo("{\"user\": {\"name\": \"liuming\", \"email\": \"liuming135@qq.com\"}}");//测试创建已存在用户的bug
		//		kf5Support.mergeUser("589280", "{\"user\": {\"id\": 123}}");
		//				kf5Support.updateUserInfo("10556", "{\"user\": {\"name\": \"你大爷\"}}");
		//		kf5Support.deleteUser("10961");
		//		kf5Support.searchUser("123");
		//		kf5Support.getUserFieldList();
		//		kf5Support.getUserFieldActiveList();
		//		kf5Support.getUserFieldListByID("35");
		//		kf5Support.deleteUserField("1");
		//		kf5Support.getGroupList();
		//		kf5Support.getGroupListByID("13436");
		//		kf5Support.createGroup("{\"group\": {\"name\": \"My Group\"}}");
		//		kf5Support.updateGroup("13436", "{\"group\": {\"name\": \"Interesting123 Group\"}}");
		//		kf5Support.deleteGroup("13434");
		//		kf5Support.getOrganizationList();
		//		kf5Support.getOrganizationByID("55");
		//		kf5Support.createOrganization("{\"organization\": {\"name\": \"My Organization\"}}");
		//		kf5Support.updateOrganization("16004","{\"organization\": {\"description\": \"呵呵，来修改一下\"}}");
		//		kf5Support.deleteOrganization("19845");
		//		kf5Support.getTopicList();
		//		kf5Support.getTopicByID("11593");
		//		kf5Support.createTopic("{\"topic\": {\"title\": \"this is topic title\",\"description\": \"description123465\"}}");
		//		kf5Support.updateTopic("11784", "{\"topic\": {\"title\": \"新标题\"}}");
		//		kf5Support.deleteTopic("11784");
		//		kf5Support.getQuestionList();
		//		kf5Support.getQuestionByID("2617");
		//		kf5Support.createQuestion("{\"question\": {\"title\": \"我是你大爷\",\"topic_id\": 8881,\"content\": \"this is content\"}}");
		//		kf5Support.updateQuestion("3301", "{\"question\": {\"title\": \"修改标题\"}}");
		//		kf5Support.deleteQuestion("3292");
		//		kf5Support.getQuestionCommentList("3207");
		//		kf5Support.getQuestionCommentByID("3207", "2715");
		//		kf5Support.replyQuestion("3207", "{\"request\": {\"comment\": {\"content\": \"我是你大爷\"}}}");
		//		kf5Support.getCategoriesList();
		//		kf5Support.getCategoryByID("12268");
		//		kf5Support.createCategory("{\"category\": {\"title\": \"post category\",\"content\": \"this is content\"}}");
		//		kf5Support.updateCategory("12268", "{\"category\": {\"title\": \"商户合作1\"}}");
		//		kf5Support.deleteCategory("13546");
		//		kf5Support.getForumList();
		//		kf5Support.getForumByID("40537");
		//		kf5Support.createForum("{\"forum\": {\"title\": \"this is forums title\",\"category_id\": \"10232\",\"content\": \"this is content\",\"role_view\": \"all\"}}");
		//		kf5Support.updateForum("53112", "{\"forum\": {\"title\": \"呵呵\"}}");
		//		kf5Support.deleteForum("53112");
		//		kf5Support.getPostList();
		//		kf5Support.getPostByID("75491");
		//		kf5Support.getManyPosts("75491,70879,70873");
		//		kf5Support.searchPost("7");
		//		kf5Support.createPost("{\"post\": {\"title\": \"this is post title\",\"forum_id\":47630,\"content\": \"this is content\"}}");
		//		kf5Support.updatePost("76180", "{\"post\": {\"title\": \"修改文档\"}}");
		//		kf5Support.deletePost("75584");
		//		kf5Support.getPostCommentList("70873");
		//		kf5Support.getPostCommentByID("70873", "3896");
		//		kf5Support.postReply("70873", "{\"post_comment\": {\"content\": \"this is api test content\"}}");
		//		kf5Support.uploadAttachment("D://123456789012.jpg");
		//		kf5Support.viewAttachment("225709");
		//		kf5Support.deleteAttachment("223997");
		//		kf5Support.importOrder("{\"ticket\": {\"requester_id\":586,\"title\": \"Help\", \"comments\": [{ \"author_id\": 563265, \"content\": \"This is a comment\"}]}}");
		//		kf5Support.orderExport("");
	}

}
