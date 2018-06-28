package com.kf5.support.example;

import com.kf5.support.controller.KF5Support;
import org.kf5.support.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        final KF5Support kf5Support = new KF5Support();
        // kf5Support.initWithApiToken("tianxiang.kf5.com", "lvgui@kf5.com",
        // "71662da0ac6b3557a4e4b4d5f0137a");
        kf5Support.initWithApiToken("tianxiang.kf5.com", "384069799@qq.com", "71662da0ac6b3557a4e4b4d5f0137a");
//        kf5Support.initWithApiToken("tianxiang.kf5.com", "maxtdfx@ydcj.net", "71662da0ac6b3557a4e4b4d5f0137a");
//
//		kf5Support.getAgentOrderList();

//		kf5Support.initWithApiToken("chosen.kf5.com", "812219713@qq.com", "b357705fbeca368a3e8dea9de4f051");
//		kf5Support.initWithApiToken("ximalaya.kf5.com", "maggie.yang@ximalaya.com", "01b6dee7c3946e1f4b6cc1bf1642bd");
//		kf5Support.getAgentOrderList();
//		Map<String, String> queryMap =new HashMap<>();
//		queryMap.put("query", "1247693");
//		kf5Support.searchTickets(queryMap);
//		kf5Support.initWithPassword("tianxiang.kf5.com", "384069799@qq.com", "111111");
        // kf5Support.initWithApiToken("keep.kf5.com", "mkt@gotokeep.com",
        // "0446209095839261781ffdf45e9bbc");

        // kf5Support.initWithApiToken("wuruo.kf5.com", "695731986@qq.com",
        // "719f39f3dce33df8f241dc8d8d1392");
        // kf5Support.initWithApiToken("chosen.kf5.com", "812219713@qq.com",
        // "b357705fbeca368a3e8dea9de4f051");

        // kf5Support.searchPost("如何");
        // kf5Support.searchTickets("query=1234");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("query", "来自");
        paramMap.put("status", "open");
        // System.out.println(kf5Support.searchTickets(paramMap).getData().size()
        // + "这里是长度");
        // System.out.println(kf5Support.getTraggerList().getData().size() +
        // "这里是长度");
        // System.out.println(kf5Support.getTriggerById(452761).getData().getId()
        // + "这里是id");
        // System.out.println(kf5Support.getActiveTriggerList().getData().size()
        // + "这里是启用的列表长度");
        // System.out.println(kf5Support.getAutomationList().getData().size() +
        // "这里是长度");
        // System.out.println(kf5Support.getAutomationById(452766).getData().getId()+"这里是id");
        // System.out.println(kf5Support.getActiveAutomationList().getData().size()+"这里是启用的自动化任务长度");
        // System.out.println(kf5Support.getHistoryChatList(null).getNextPage()+"这里是解析历史对话的的长度");
        // System.out.println(kf5Support.getHistoryChatByUrl("https://chosen.kf5.com/apiv2/kchat/history.json?page=2").getNextPage()+"这里是根据url请求对话列表");
        // kf5Support.getHistoryChatById(96248);
        Map<String, String> params = new HashMap<>();
        params.put("start", "2017-08-01");
        params.put("end", "2017-08-22");
        // System.out.println(kf5Support.getAgentLoginLogList(params).getData().size()+"这里是客服登录状态长度");
        // System.out.println(kf5Support.getAITagList(null).getData().size()+"这里是标签长度");
        // JSONObject jsonObject = new JSONObject();
        // JSONArray jsonArray = new JSONArray();
        // JSONObject itemObj = new JSONObject();
        // itemObj.put("name", "标签5");
        // itemObj.put("type", "question");
        // jsonArray.add(itemObj);
        // jsonObject.put("data", jsonArray);
        // kf5Support.createAITag(jsonObject.toJSONString());

        // JSONObject jsonObject = new JSONObject();
        // JSONObject itemObj = new JSONObject();
        // itemObj.put("name", "新改标签");
        // jsonObject.put("data", itemObj);
        // kf5Support.updateAITag(22509574, jsonObject.toJSONString());
        // kf5Support.deleteAITag(22509574);
        // System.out.println(kf5Support.getMonitorAgentList(params).getData().getAgentStatus().size()+"这里是坐席长度");
        // kf5Support.getMonitorChatList();
        // System.out.println(kf5Support.getMonitorVisitorQueueList().getData().size()+"排队的长度");;
        // System.out.println(kf5Support.getAgentWorkStatusStatistics(params).getData().getAgentWorkStatus().size()+"这里是长度");
        // System.out.println(
        // kf5Support.getAgentConverstationStatistics(params).getData().getAgentConversations().size()
        // + "这里是长度");
        // System.out.println(kf5Support.getAgentStatusTimeStatistics(params).getData().getAgentStatusTimes().size()+"这里是新的长度");;
        // System.out.println(kf5Support.getChatSourceStatistics(params).getData().getChatSources().size()
        // + "这里是长度");
        Map<String, String> agentMap = new HashMap<>();
        agentMap.put("agent_id", "2943528");
        agentMap.put("status", "online");
        // System.out.println(kf5Support.updateAgentStatus(agentMap).getData().getDisplay_name());;
        // kf5Support.getGroupList();
        Map<String, String> map = new HashMap<>();
        map.put("per_page", "1");
        // kf5Support.getVoiceCallList(map);
        // kf5Support.getVoiceCallById(9194169);
        // System.out.println(kf5Support.getVoiceAccountList(map).getNextPage());
        // kf5Support.getVoiceAccountById("10");
        JSONObject jsonObject = new JSONObject();
        JSONObject agentObj = new JSONObject();
        agentObj.put("type", "phone");
        jsonObject.put("agent", agentObj);
        // kf5Support.updateVoiceAccount("10", jsonObject.toJSONString());
        // System.out.println(kf5Support.getVoiceCallUnAnsweredList(map).getData().size()+"这里是长度");;
        // System.out.println(kf5Support.getVoiceCallUnAnsweredListByUrl("https://tianxiang.kf5.com/apiv2/voice/unanswereds.json?per_page=1&page=2").getData().
        // get(0).getFrom());
        // kf5Support.getVoiceAgentLoginStateList(map);
        Map<String, String> map2 = new HashMap<>();
        map2.put("created_start", "2017-08-01");
        map2.put("created_end", "2017-08-22");
        // kf5Support.getAgentVoiceCallOutboundList(map2);
        // System.out.println(kf5Support.getAgentVoiceCallInboundList(map2).getData().size()+"长度");;
        // System.out.println(kf5Support.getAgentVoicePerformanceList(map2).getData().size()
        // + "长度");
        // System.out.println(kf5Support.getAgentVoiceStateTimeList(map2).getData().size());
        // System.out.println(kf5Support.getAgentVoiceCallSubsectionInboundList(map2).getData().size());
        // kf5Support.getAgentVoiceCallSubsectionOutboundList(map2);
        // kf5Support.getVoiceQueueCallList();
        // System.out.println(kf5Support.getAgentVoiceStatusList().getData().size()+"长度");
        // kf5Support.getAgentVoiceStatusById("5976779");
        JSONObject jsonObject2 = new JSONObject();
        Map<String, String> map3 = new HashMap<>();
        map3.put("query", "哈哈");
//		System.out.println(kf5Support.searchPost(map3).getData().size()+"长度");;
//		System.out.println(kf5Support.getUserList().getData().size()+"这里是长度");
        // jsonObject.put("number", "384069799@qq.com");
        // kf5Support.sendVoiceCallOutbound(jsonObject2.toJSONString());
//		System.out.println(kf5Support.getSystemLogList(map).getNextPage() + "长度");
//		kf5Support.setAgentVoiceOnline();
//		kf5Support.setAgentVoiceBusy();
//		kf5Support.setAgentVoiceBreak();
//		kf5Support.setAgentVoiceOffline();
//		kf5Support.getIMAgentList();
        // kf5Support.initWithApiToken("lipinjj.kf5.com",
        // "kevin.wang@jjcargo.com", "8fc17954445f9e5b49566e5b4db271");
        // kf5Support.initWithApiToken("itojoy.kf5.com", "sujinde@itojoy.com",
        // "7513f8c7201731fa760b21047ea8a3");
        // kf5Support.initWithApiToken("yitb.kf5.com", "tanqinghua@kjy.com",
        // "1da3457430ab722a7ff9fbc3d379d3");

        // kf5Support.initWithPassword("tianxiang.kf5.com", "123456789@qq.com",
        // "111111");
        // kf5Support.getAgentOrderList("https://tianxiang.kf5.com/apiv2/tickets.json?per_page=1&page=2");
        // kf5Support.getAgentOrderListWithID("586");
        // kf5Support.getAgentOrderListWithID("586",1,1);
        // kf5Support.getAgentOrderListWithPaginationUrlAndID("https://tianxiang.kf5.com/apiv2/users/586/tickets.json?per_page=1&id=586&page=2");
        // kf5Support.getAgentTicketDetail("75");
        // kf5Support.getAgentManyTickets("73,74,75,86,68,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16"
        // +
        // ",15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60");
        // KF5Entity<Ticket> kf5Entity=

        // for (int i = 0; i < 5; i++) {
        // kf5Support.createAgentOrder(
        // "{ticket:{title: \"Let's create ticket\",\"comment\": {\"content\":
        // \"what are you waiting for?\"}}}");
        // }
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
        // KF5PaginationEntity<List<Requester>> aEntity =
//		 kf5Support.getRequesterOrderList();
        // System.out.println("=====" + aEntity.getCount() + "===" +
        // aEntity.getNextPage() + "===="
        // + aEntity.getData().get(0).getTitle());
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
        // JSONObject requestObj = new JSONObject();
        // requestObj.put("title", "被雷焦的新工单标题132asd132as321d");
        // JSONObject commentObj = new JSONObject();
        // commentObj.put("content", "大家好，我是一条新工单?");
        // requestObj.put("comment", commentObj);
        // JSONArray fieldArray = new JSONArray();
        // JSONObject itemObj = new JSONObject();
        // itemObj.put("name", "field_7515");
        // itemObj.put("value", "1871234567");
        // fieldArray.add(itemObj);
        //
        // JSONObject itemObj1 = new JSONObject();
        // itemObj1.put("name", "field_7868");
        // itemObj1.put("value", "售前问题");
        // fieldArray.add(itemObj1);
        // requestObj.put("custom_fields", fieldArray);
        // JSONObject dataObj = new JSONObject();
        // dataObj.put("request", requestObj);
        // kf5Support.createOrderByEndUser("{\"request\":{\"title\":\"被雷焦的新工单标题132asd132as321d\",\"comment\":{\"content\":
        // \"大家好，我是一条新工单?\","
        // + "\"custom_fields\":[{\"name\": \"field_7515\",\"value\":
        // \"1871234567\"}]}}}");
        // kf5Support.createOrderByEndUser(dataObj.toJSONString());
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
        // kf5Support.getTicketFieldList();
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
//		 kf5Support.deleteUser("49055402");
        // kf5Support.searchUser("123");
        // kf5Support.searchUser("123",1,1);
        // kf5Support.searchUserByURL("https://wuruo.kf5.com/apiv2/users/search.json?query=123&per_page=1&page=2");
        // kf5Support.getUserFieldList();
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
        // kf5Support.searchPost("你大爷");
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
        // kf5Support.getChatListWithQueryParams("start=2017-01-21");
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
        // kf5Support.getQuestionCategoriesList("呵呵");
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

//		KF5CustomIMSupport support = new KF5CustomIMSupport("tianxiang.kf5.com","1000005","547fe99363ce8751b1c8ae3cd728c31d","POST");
//		KF5Entity<IMAgentInfo> kf5Entity = support.getIMAgentInfo();
//		System.out.println(kf5Entity.getResultCode()+"====="+kf5Entity.getMessage()+"===="+
//		kf5Entity.getData().getImAgents().size()+"====="+kf5Entity.getData().getImGroups().size());
//		JSONObject chatObj = new JSONObject();
//		support.createIMChat("{\n" +
//            "\t\"action\": \"create_chat\",\n" +
//            "\t\"chat\": {\n" +
//            "\t\t\"agent_ids\": [122,586],\n" +
//            "\t\t\"group_id\": \"\",\n" +
//            "\t\t\"force\": 0\n" +
//            "\t},\n" +
//            "\t\"user\": {\n" +
//            "\t\t\"name\": \"小刘\",\n" +
//            "\t\t\"openid\": \"e4d8c2abfc783e0b8f0d7b4eb93812e5\",\n" +
//            "\t\t\"metadata\": [{\n" +
//            "\t\t\t\"name\": \"联系地址\",\n" +
//            "\t\t\t\"value\": \"四川省成都市锦江区东大街时代1号\"\n" +
//            "\t\t},\n" +
//            "\t\t{\n" +
//            "\t\t\t\"name\": \"正在查看商品\",\n" +
//            "\t\t\t\"value\": \"智能手机 http://www.yourdomain.com/goods/123.html\"\n" +
//            "\t\t}]\n" +
//            "\t}\n" +
//            "}");
//		support.sendTextMessage("{\n" +
//            "\t\"action\": \"chat\",\n" +
//            "\t\"message\": {\n" +
//            "\t\t\"id\": \"1\",\n" +
//            "\t\t\"type\": \"text\",\n" +
//            "\t\t\"to_user\": 6452832,\n" +
//            "\t\t\"from_user\": \"e4d8c2abfc783e0b8f0d7b4eb93812e5\",\n" +
//            "\t\t\"content\": \"你好，有个问题需要咨询一下\",\n" +
//            "\t\t\"create_time\": 1480433249\n" +
//            "\t}\n" +
//            "}");
//		 support.uploadAttachment(new File("D://bug.jpg"));
//		kf5Support.getUserInfo(19621613+"");
//        KF5PaginationEntity<List<User>> paginationEntity = kf5Support.getUserList();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("score", 1);
        jsonObject1.put("content", "这里是测试评价");
        JSONObject parentObj = new JSONObject();
        parentObj.put("satisfaction", jsonObject1);
//        kf5Support.scoreTicketByTicketId(1011835, jsonObject1.toJSONString());
//        kf5Support.endUserTicketPushById(1011835);

        Map<String, String> endUserSearchMap = new HashMap<>();
        endUserSearchMap.put("query", "123");
        endUserSearchMap.put("query_fields", "name,email");
//        KF5PaginationEntity<List<User>> kf5PaginationEntity = kf5Support.endUserSearchUser(endUserSearchMap);

//        Map<String, String> helperCenterMap = new HashMap<>();
//        helperCenterMap.put("type", "post");
//        helperCenterMap.put("start", "2017-4-1");
//        helperCenterMap.put("end", "2018-1-1");
//        KF5Entity<List<DocumentStats>> listKF5Entity = kf5Support.endUserGetHelpCenterStats(helperCenterMap);
//        System.out.println(listKF5Entity.getResultCode() + "======" + listKF5Entity.getMessage() + "====" + listKF5Entity.getData().size());
//        System.out.println(kf5Support.adminGetPostVoteListByPostId("1092257").getData().get(0).toString());

//        Map<String, String> orderListQueryMap = new HashMap<>();
//        orderListQueryMap.put("123", "332156654");
//        KF5Entity<List<Ticket>> listKF5Entity = kf5Support.adminGetAgentOrderListByAgentId("58653806", orderListQueryMap);
//        System.out.println(listKF5Entity.getData().size());
//        Map<String, String> queryMap = new HashMap<>();
//        queryMap.put("query", "384069799@qq.com");
//        KF5Entity<List<Ticket>> listKF5Entity = kf5Support.agentGetUserTicketListByIndication(queryMap);
//        System.out.println("长度" + listKF5Entity.getResultCode() + "=====" + listKF5Entity.getMessage() + "=====" + listKF5Entity.getData().size());
        kf5Support.getVoiceCallList(null);
    }


    private static boolean isMatch(String regex, String original) {
        if (original == null || original.trim().equals("")) {
            return false;
        }
        if (original.startsWith(".")) {
            original = "0" + original;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(original);
        return isNum.matches();
    }

    public static boolean isPositiveDecimal(String original) {
        return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", original);
    }
}
