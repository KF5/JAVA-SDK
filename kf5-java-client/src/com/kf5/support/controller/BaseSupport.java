package com.kf5.support.controller;

import java.util.ArrayList;
import java.util.List;

import com.kf5.support.model.*;
import org.kf5.support.fastjson.JSONArray;
import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.internet.HttpRequest;
import com.kf5.support.model.builder.EntityBuilder;
import com.kf5.support.model.builder.KF5EntityBuilder;
import com.kf5.support.util.Base64Utils;

class BaseSupport extends DataSupport {

    protected static final int RESULT_OK = StatusCode.OK;

    protected static final int RESULT_ERROR = StatusCode.ERROR;

    private String domain;

    private String username;

    private String password;

    private String token;

    protected String baseToken;

    /**
     * 使用邮箱和密码进行验证
     *
     * @param domain   平台地址
     * @param username 登录邮箱
     * @param password 密码
     */
    public void initWithPassword(String domain, String username, String password) {
        this.domain = domain;
        this.username = username;
        this.password = password;
        String code = this.username + ":" + this.password;
        this.baseToken = Base64Utils.encode(code);
    }

    /**
     * 使用邮箱和平台开放api的通信秘钥进行验证
     *
     * @param domain   平台地址
     * @param username 登录邮箱
     * @param apiToken 通信秘钥，具体位置在：系统设置——>api接口——>通信秘钥
     */
    public void initWithApiToken(String domain, String username, String apiToken) {

        this.domain = domain;
        this.username = username;
        this.token = apiToken;
        String code = this.username + "/token:" + this.token;
        this.baseToken = Base64Utils.encode(code);
    }

    protected void checkHasId(String... ids) {

        if (ids != null) {
            int size = ids.length;
            for (int i = 0; i < size; i++) {
                if (ids[i] == null || ids[i].trim().equals("")) {
                    throw new IllegalArgumentException("id can not be null");
                }
            }
        } else {
            throw new IllegalArgumentException("id can not be null");
        }
    }

    protected void checkNotNull(String key) {

        if (key == null || key.trim().equals("")) {
            throw new IllegalArgumentException("key can not be null");
        }
    }

//	protected <T> void setPagesAndCount(KF5PaginationEntity<T> kf5Entity, JSONObject jsonObject) {
//		if (kf5Entity == null || jsonObject == null)
//			return;
//		kf5Entity.setCount(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT));
//		kf5Entity.setNextPage(KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE));
//		kf5Entity.setPreviousPage(KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE));
//	}

    /**
     * Get请求
     *
     * @param url
     * @return
     */
    protected MessageStatus sendGetRequest(String url) {
        checkBaseToken();
        return HttpRequest.sendGetRequest(url, baseToken);
    }

    /**
     * POST请求
     *
     * @param url
     * @param params
     * @return
     */
    protected MessageStatus sendPostRequest(String url, String params) {
        checkBaseToken();
        return HttpRequest.sendPostRequest(url, baseToken, params);
    }

    /**
     * PUT请求
     *
     * @param url
     * @param params
     * @return
     */
    protected MessageStatus sendPutRequest(String url, String params) {
        checkBaseToken();
        return HttpRequest.sendPutRequest(url, baseToken, params);
    }

    /**
     * DELETE请求
     *
     * @param url
     * @return
     */
    protected MessageStatus sendDeleteRequest(String url) {
        checkBaseToken();
        return HttpRequest.sendDeleteRequest(url, baseToken);
    }

    /**
     * DELETE请求
     *
     * @param url
     * @param params body参数
     * @return
     */
    protected MessageStatus sendDeleteRequest(String url, String params) {
        checkBaseToken();
        return HttpRequest.sendDeleteRequest(url, baseToken, params);
    }

    /**
     * 返回二级域名
     *
     * @return
     */
    protected String getDomain() {
        return domain;
    }

    private void checkBaseToken() {
        if (baseToken == null) {
            throw new IllegalArgumentException(
                    "you must call the function named initWithPassword or initWithApiToken to init baseToken");
        }
    }

    protected KF5PaginationEntity<List<Chat>> buildPaginationChatList(MessageStatus messageStatus) {

        List<Chat> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.CHATS);
            list.addAll(EntityBuilder.buildChatList(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Chat>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<Ticket>> buildTicketList(MessageStatus messageStatus) {

        List<Ticket> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.TICKETS);
            list.addAll(EntityBuilder.buildTicketList(jsonArray));
        }
        return dealData(new KF5Entity<List<Ticket>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<Ticket> buildTicket(MessageStatus messageStatus) {

        KF5Entity<Ticket> kf5Entity = new KF5Entity<>();
        buildTicket(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildTicket(MessageStatus messageStatus, KF5Entity<Ticket> kf5Entity) {

        Ticket ticket = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            ticket = EntityBuilder.buildTicket(EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.TICKET));
        dealData(kf5Entity, ticket, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<List<User>> buildUserList(MessageStatus messageStatus) {

        List<User> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.USERS);
            list.addAll(EntityBuilder.buildUsers(jsonArray));
        }
        return dealData(new KF5Entity<List<User>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<Requester>> buildPaginationRequesterList(MessageStatus messageStatus) {
        List<Requester> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.REQUESTS);
            list.addAll(EntityBuilder.buildRequesters(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Requester>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Requester> buildRequester(MessageStatus messageStatus) {
        KF5Entity<Requester> kf5Entity = new KF5Entity<>();
        buildRequester(kf5Entity, messageStatus);
        return kf5Entity;
    }

    protected void buildRequester(KF5Entity<Requester> kf5Entity, MessageStatus messageStatus) {

        Requester requester = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            requester = EntityBuilder
                    .buildRequester(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.REQUEST));
        dealData(kf5Entity, requester, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected <T> void dealErrorData(KF5Entity<T> kf5Entity, String message) {

        kf5Entity.setResultCode(RESULT_ERROR);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", RESULT_ERROR);
        jsonObject.put("message", message);
        kf5Entity.setMessage(jsonObject.toString());

    }

    protected KF5PaginationEntity<List<Comment>> buildPaginationListComment(MessageStatus messageStatus) {

        List<Comment> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.COMMENTS);
            list.addAll(EntityBuilder.buildComments(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Comment>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Comment> buildComment(MessageStatus messageStatus) {

        Comment comment = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            comment = EntityBuilder
                    .buildComment(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.COMMENT));
        return dealData(new KF5Entity<Comment>(), comment, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<TicketField>> buildPaginationTicketFieldList(MessageStatus messageStatus) {

        List<TicketField> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.TICKET_FIELDS);
            list.addAll(EntityBuilder.buildTicketFields(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<TicketField>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<TicketField> buildTicketField(MessageStatus messageStatus) {

        TicketField ticketField = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            ticketField = EntityBuilder
                    .buildTicketField(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.TICKET_FIELD));
        return dealData(new KF5Entity<TicketField>(), ticketField, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<View>> buildPaginationOrderTypeList(MessageStatus messageStatus) {

        List<View> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.VIEWS);
            list.addAll(EntityBuilder.buildViews(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<View>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<View> buildOrderType(MessageStatus messageStatus) {

        View view = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            view = EntityBuilder.buildView(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.VIEW));
        return dealData(new KF5Entity<View>(), view, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<Ticket>> buildPaginationTicketList(MessageStatus messageStatus) {

        List<Ticket> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.TICKETS);
            list.addAll(EntityBuilder.buildTicketList(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Ticket>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));

    }

    protected KF5Entity<ViewCount> buildViewCount(MessageStatus messageStatus) {

        ViewCount viewCount = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            viewCount = EntityBuilder
                    .buildViewCount(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.VIEW_COUNT));
        return dealData(new KF5Entity<ViewCount>(), viewCount, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<ViewCount>> buildListViewCount(MessageStatus messageStatus) {

        List<ViewCount> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.VIEW_COUNTS);
            list.addAll(EntityBuilder.buildViewCounts(jsonArray));
        }
        return dealData(new KF5Entity<List<ViewCount>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<User>> buildPaginationUserList(MessageStatus messageStatus) {

        List<User> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.USERS);
            list.addAll(EntityBuilder.buildUsers(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<User>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<User> buildUser(MessageStatus messageStatus) {
        KF5Entity<User> kf5Entity = new KF5Entity<>();
        buildUser(kf5Entity, messageStatus);
        return kf5Entity;
    }

    protected void buildUser(KF5Entity<User> kf5Entity, MessageStatus messageStatus) {

        User user = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            user = EntityBuilder.buildUser(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.USER));
        dealData(kf5Entity, user, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<UserField>> buildPaginationUserFieldList(MessageStatus messageStatus) {

        List<UserField> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.USER_FIELDS);
            list.addAll(EntityBuilder.buildUserFields(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<UserField>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<UserField> buildUserField(MessageStatus messageStatus) {

        UserField userField = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            userField = EntityBuilder
                    .buildUserField(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.USER_FIELD));
        return dealData(new KF5Entity<UserField>(), userField, getResultObj(messageStatus),
                getResultCode(messageStatus));

    }

    protected KF5Entity<List<Group>> buildGroupList(MessageStatus messageStatus) {

        List<Group> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.GROUPS);
            list.addAll(EntityBuilder.buildGroups(jsonArray));
        }
        return dealData(new KF5Entity<List<Group>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<Group> buildGroup(MessageStatus messageStatus) {
        KF5Entity<Group> kf5Entity = new KF5Entity<>();
        buildGroup(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildGroup(MessageStatus messageStatus, KF5Entity<Group> kf5Entity) {

        Group group = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            group = EntityBuilder.buildGroup(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.GROUP));
        dealData(kf5Entity, group, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<Organization>> buildPaginationOrganizationList(MessageStatus messageStatus) {

        List<Organization> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.ORGANIZATIONS);
            list.addAll(EntityBuilder.buildOrganizations(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Organization>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Organization> buildOrganization(MessageStatus messageStatus) {

        KF5Entity<Organization> kf5Entity = new KF5Entity<>();
        buildOrganization(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildOrganization(MessageStatus messageStatus, KF5Entity<Organization> kf5Entity) {

        Organization organization = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            organization = EntityBuilder.buildOrganization(
                    KF5EntityBuilder.getJsonObject(getResultObj(messageStatus), KF5Fields.ORGANIZATION));
        dealData(kf5Entity, organization, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<Topic>> buildPaginationTopicList(MessageStatus messageStatus) {

        List<Topic> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.TOPICS);
            list.addAll(EntityBuilder.buildTopics(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Topic>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Topic> buildTopic(MessageStatus messageStatus) {

        KF5Entity<Topic> kf5Entity = new KF5Entity<>();
        buildTopic(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildTopic(MessageStatus messageStatus, KF5Entity<Topic> kf5Entity) {

        Topic topic = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            topic = EntityBuilder.buildTopic(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.TOPIC));
        dealData(kf5Entity, topic, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<Question>> buildPaginationQuestionList(MessageStatus messageStatus) {

        List<Question> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.QUESTIONS);
            list.addAll(EntityBuilder.buildQuestions(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Question>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));

    }

    protected KF5Entity<Question> buildQuestion(MessageStatus messageStatus) {

        KF5Entity<Question> kf5Entity = new KF5Entity<>();
        buildQuestion(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildQuestion(MessageStatus messageStatus, KF5Entity<Question> kf5Entity) {

        Question question = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            question = EntityBuilder
                    .buildQuestion(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.QUESTION));
        dealData(kf5Entity, question, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<QuestionComment>> buildPaginationQuestionCommentList(
            MessageStatus messageStatus) {
        KF5PaginationEntity<List<QuestionComment>> kf5Entity = new KF5PaginationEntity<>();
        buildPaginationQuestionCommentList(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildPaginationQuestionCommentList(MessageStatus messageStatus,
                                                      KF5PaginationEntity<List<QuestionComment>> kf5Entity) {

        List<QuestionComment> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.QUESTION_COMMENTS);
            list.addAll(EntityBuilder.buildQuestionComments(jsonArray));
        }
        dealPaginationListData(kf5Entity, list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<QuestionComment> buildQuestionComment(MessageStatus messageStatus) {
        QuestionComment questionComment = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            questionComment = EntityBuilder.buildQuestionComment(
                    KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.QUESTION_COMMENT));
        }
        return dealData(new KF5Entity<QuestionComment>(), questionComment, getResultObj(messageStatus),
                getResultCode(messageStatus));

    }

    protected KF5PaginationEntity<List<Category>> buildPaginationCategoriesList(MessageStatus messageStatus) {

        List<Category> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.CATEGORIES);
            list.addAll(EntityBuilder.buildCategories(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Category>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));

    }

    protected KF5Entity<Category> buildCategory(MessageStatus messageStatus) {

        KF5Entity<Category> kf5Entity = new KF5Entity<>();
        buildCategory(messageStatus, kf5Entity);
        return kf5Entity;

    }

    protected void buildCategory(MessageStatus messageStatus, KF5Entity<Category> kf5Entity) {

        Category category = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            category = EntityBuilder
                    .buildCategory(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.CATEGORY));
        dealData(kf5Entity, category, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<Forum>> buildPaginationForumList(MessageStatus messageStatus) {

        List<Forum> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.FORUMS);
            list.addAll(EntityBuilder.buildForums(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Forum>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));

    }

    protected KF5Entity<Forum> buildForum(MessageStatus messageStatus) {

        KF5Entity<Forum> kf5Entity = new KF5Entity<>();
        buildForum(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildForum(MessageStatus messageStatus, KF5Entity<Forum> kf5Entity) {

        Forum forum = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            forum = EntityBuilder.buildForum(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.FORUM));
        dealData(kf5Entity, forum, getResultObj(messageStatus), getResultCode(messageStatus));

    }

    protected KF5PaginationEntity<List<Post>> buildPaginationPostList(MessageStatus messageStatus) {

        List<Post> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.POSTS);
            list.addAll(EntityBuilder.buildPosts(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<Post>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Post> buildPost(MessageStatus messageStatus) {

        KF5Entity<Post> kf5Entity = new KF5Entity<>();
        buildPost(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildPost(MessageStatus messageStatus, KF5Entity<Post> kf5Entity) {

        Post post = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            post = EntityBuilder.buildPost(KF5EntityBuilder.getJsonObject(getResultObj(messageStatus), KF5Fields.POST));
        dealData(kf5Entity, post, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<List<Post>> buildListPost(MessageStatus messageStatus) {

        List<Post> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.POSTS);
            list.addAll(EntityBuilder.buildPosts(jsonArray));
        }
        return dealData(new KF5Entity<List<Post>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<PostComment>> buildPaginationPostCommentList(MessageStatus messageStatus) {

        List<PostComment> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.POST_COMMENTS);
            list.addAll(EntityBuilder.buildPostComments(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<PostComment>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<PostComment> buildPostComment(MessageStatus messageStatus) {

        PostComment postComment = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            postComment = EntityBuilder
                    .buildPostComment(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.POST_COMMENT));
        return dealData(new KF5Entity<PostComment>(), postComment, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Attachment> buildAttachment(MessageStatus messageStatus) {

        Attachment attachment = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            attachment = EntityBuilder
                    .buildAttachment(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.ATTACHMENT));
        return dealData(new KF5Entity<Attachment>(), attachment, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<String> buildResultWithString(MessageStatus messageStatus) {
        KF5Entity<String> kf5Entity = new KF5Entity<>();
        buildResultWithString(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildResultWithString(MessageStatus messageStatus, KF5Entity<String> kf5Entity) {
        kf5Entity.setResultCode(messageStatus.getStatus());
        JSONObject jsonObject = messageStatus.getJsonObject();
        if (jsonObject != null) {
            if (messageStatus.getStatus() == RESULT_OK) {
                kf5Entity.setData(jsonObject.toString());
            } else {
                kf5Entity.setMessage(jsonObject.toString());
            }
        }

    }

    protected KF5Entity<Chat> buildChat(MessageStatus messageStatus) {

        Chat chat = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            chat = EntityBuilder.buildChat(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.CHAT));
        return dealData(new KF5Entity<Chat>(), chat, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<AICategory>> buildPaginationListAICategory(MessageStatus messageStatus) {
        KF5PaginationEntity<List<AICategory>> kf5Entity = new KF5PaginationEntity<>();
        buildPaginationListAICategory(messageStatus, kf5Entity);
        return kf5Entity;
    }

    protected void buildPaginationListAICategory(MessageStatus messageStatus,
                                                 KF5PaginationEntity<List<AICategory>> kf5Entity) {

        List<AICategory> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.ROWS);
            list.addAll(EntityBuilder.buildAICategoryList(jsonArray));
        }
        dealPaginationListData(kf5Entity, list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<AICategory> buildAICategory(MessageStatus messageStatus) {
        AICategory aiCategory = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            aiCategory = EntityBuilder
                    .buildAiCategory(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.DATA));
        return dealData(new KF5Entity<AICategory>(), aiCategory, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<AIQuestionCategory>> buildPaginationAIQuestionCategoryList(
            MessageStatus messageStatus) {
        List<AIQuestionCategory> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.ROWS);
            list.addAll(EntityBuilder.buildAIQuestionCategoryList(jsonArray));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<AIQuestionCategory>>(), list,
                getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<AIQuestionCategory> buildAIQuestionCategory(MessageStatus messageStatus) {

        AIQuestionCategory aiQuestionCategory = null;
        if (getResultCode(messageStatus) == RESULT_OK)
            aiQuestionCategory = EntityBuilder
                    .buildAIQuestionCategory(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.DATA));
        return dealData(new KF5Entity<AIQuestionCategory>(), aiQuestionCategory, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

//	private <T> KF5PaginationEntity<T> dealPaginationListData(KF5PaginationEntity<T> kf5Entity, T list,
//			JSONObject jsonObject, int resultCode) {
//
//		kf5Entity.setResultCode(resultCode);
//		if (resultCode == RESULT_OK) {
//			kf5Entity.setData(list);
//			setPagesAndCount(kf5Entity, jsonObject);
//		} else {
//			kf5Entity.setMessage(jsonObject.toString());
//		}
//		return kf5Entity;
//	}
//
//	private <T> KF5Entity<T> dealData(KF5Entity<T> kf5Entity, T t, JSONObject jsonObject, int resultCode) {
//
//		kf5Entity.setResultCode(resultCode);
//		if (resultCode == RESULT_OK) {
//			kf5Entity.setData(t);
//		} else {
//			kf5Entity.setMessage(jsonObject.toString());
//		}
//		return kf5Entity;
//	}
//
//	private int getResultCode(MessageStatus messageStatus) {
//		return messageStatus.getStatus();
//	}
//
//	private JSONObject getResultObj(MessageStatus messageStatus) {
//		return messageStatus.getJsonObject();
//	}

    /*
     * ###########################################2017-8-21新增API################
     * ###########################
     */

    protected KF5Entity<Trigger> buildTrigger(MessageStatus messageStatus) {
        Trigger trigger = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            trigger = EntityBuilder
                    .buildTrigger(KF5EntityBuilder.getJsonObject(getResultObj(messageStatus), KF5Fields.TRIGGER));
        }
        return dealData(new KF5Entity<Trigger>(), trigger, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<List<Trigger>> buildTriggerList(MessageStatus messageStatus) {

        List<Trigger> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.TRIGGERS);
            list.addAll(EntityBuilder.buildTriggerList(jsonArray));
        }
        return dealData(new KF5Entity<List<Trigger>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<Automation> buildAutomation(MessageStatus messageStatus) {
        Automation automation = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            automation = EntityBuilder
                    .buildAutomation(KF5EntityBuilder.getJsonObject(getResultObj(messageStatus), KF5Fields.AUTOMATION));
        }
        return dealData(new KF5Entity<Automation>(), automation, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<Automation>> buildAutomationList(MessageStatus messageStatus) {
        List<Automation> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AUTOMATIONS);
            list.addAll(EntityBuilder.buildAutomationList(jsonArray));
        }
        return dealData(new KF5Entity<List<Automation>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentLog>> buildAgentLogList(MessageStatus messageStatus) {
        List<AgentLog> agentLogs = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            agentLogs.addAll(EntityBuilder
                    .buildAgentLogList(KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.LOGS)));
        }
        return dealData(new KF5Entity<List<AgentLog>>(), agentLogs, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AITag>> buildAITagList(MessageStatus messageStatus) {
        List<AITag> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder
                    .buildAITagList(KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.ROWS)));
        }
        return dealData(new KF5Entity<List<AITag>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<MonitorAgent> buildMonitorAgent(MessageStatus messageStatus) {
        MonitorAgent monitorAgent = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            monitorAgent = EntityBuilder
                    .buildMonitorAgent(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.STATS));
        }
        return dealData(new KF5Entity<MonitorAgent>(), monitorAgent, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<ChatInfo>> buildChatInfoList(MessageStatus messageStatus) {
        List<ChatInfo> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder
                    .buildChatInfoList(KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.CHATS)));
        }
        return dealData(new KF5Entity<List<ChatInfo>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<QueueVisitorInfo>> buildQueueVisitorInfoList(MessageStatus messageStatus) {
        List<QueueVisitorInfo> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildQueueVisitorInfoList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.VISITORS)));
        }
        return dealData(new KF5Entity<List<QueueVisitorInfo>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<AgentWorkStatusStatistics> buildAgentWorkStatusStatistics(MessageStatus messageStatus) {
        AgentWorkStatusStatistics statistics = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            statistics = EntityBuilder.buildAgentWorkStatusStatistics(
                    KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.STATS));
        }
        return dealData(new KF5Entity<AgentWorkStatusStatistics>(), statistics, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<AgentConversationStatistics> buildAgentConversationStatistics(MessageStatus messageStatus) {
        AgentConversationStatistics statistics = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            statistics = EntityBuilder.buildAgentConversationStatistics(
                    KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.STATS));
        }
        return dealData(new KF5Entity<AgentConversationStatistics>(), statistics, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<AgentStatusTimeStatistics> buildAgentStatusTimeStatistics(MessageStatus messageStatus) {
        AgentStatusTimeStatistics statistics = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            statistics = EntityBuilder.buildAgentStatusTimeStatistics(getResultObj(messageStatus));
        }
        return dealData(new KF5Entity<AgentStatusTimeStatistics>(), statistics, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<ChatSourceStatistics> buildChatSourceStatistics(MessageStatus messageStatus) {
        ChatSourceStatistics statistics = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            statistics = EntityBuilder.buildChatSourceStatistics(
                    KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.STATS));
        }
        return dealData(new KF5Entity<ChatSourceStatistics>(), statistics, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<AgentStatistics> buildAgentStatistics(MessageStatus messageStatus) {
        AgentStatistics statistics = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            statistics = EntityBuilder
                    .buildAgentStatistics(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.AGENT));
        }
        return dealData(new KF5Entity<AgentStatistics>(), statistics, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<VoiceCall>> buildVoiceCallList(MessageStatus messageStatus) {
        List<VoiceCall> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder
                    .buildVoiceCallList(KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.HISTORIES)));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<VoiceCall>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<VoiceCall> buildVoiceCall(MessageStatus messageStatus) {
        VoiceCall voiceCall = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            voiceCall = EntityBuilder
                    .buildVoiceCall(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.HISTORY));
        }
        return dealData(new KF5Entity<VoiceCall>(), voiceCall, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<VoiceAccount>> buildVoiceAccountList(MessageStatus messageStatus) {
        List<VoiceAccount> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder
                    .buildVoiceAccountList(KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AGENTS)));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<VoiceAccount>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<VoiceAccount> buildVoiceAccount(MessageStatus messageStatus) {
        VoiceAccount voiceAccount = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            voiceAccount = EntityBuilder
                    .buildVoiceAccount(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.AGENT));
        }
        return dealData(new KF5Entity<VoiceAccount>(), voiceAccount, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<VoiceAgentLoginState>> buildVoiceAgentLoginStateList(
            MessageStatus messageStatus) {
        List<VoiceAgentLoginState> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildVoiceAgentLoginStateList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AGENT_STATE_LOGS)));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<VoiceAgentLoginState>>(), list,
                getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<VoiceCallUnAnswered>> buildVoiceCallUnAnsweredList(MessageStatus messageStatus) {
        List<VoiceCallUnAnswered> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildVoiceCallUnAnsweredList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.UNANSWERED)));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<VoiceCallUnAnswered>>(), list,
                getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoiceCallOutbound>> buildAgentVoiceCallOutboundList(MessageStatus messageStatus) {
        List<AgentVoiceCallOutbound> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoiceCallOutboundList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AGENT_OUTBOUND_STATS)));
        }
        return dealData(new KF5Entity<List<AgentVoiceCallOutbound>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoiceCallInbound>> buildAgentVoiceCallInboundList(MessageStatus messageStatus) {
        List<AgentVoiceCallInbound> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoiceCallInboundList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AGENT_INBOUND_STATS)));
        }
        return dealData(new KF5Entity<List<AgentVoiceCallInbound>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoicePerformance>> buildAgentVoicePerformanceList(MessageStatus messageStatus) {
        List<AgentVoicePerformance> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoicePerformanceList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AGENT_PERFORMANCE_STATS)));
        }
        return dealData(new KF5Entity<List<AgentVoicePerformance>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoiceStateTime>> buildAgentVoiceStateTimeList(MessageStatus messageStatus) {
        List<AgentVoiceStateTime> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoiceStateTimeList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AGENT_STATE_STATS)));
        }
        return dealData(new KF5Entity<List<AgentVoiceStateTime>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoiceCallSubsectionInbound>> buildAgentVoiceCallSubsectionInboundList(
            MessageStatus messageStatus) {
        List<AgentVoiceCallSubsectionInbound> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoiceCallSubsectionInboundList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.INBOUND_STATS)));
        }
        return dealData(new KF5Entity<List<AgentVoiceCallSubsectionInbound>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoiceCallSubsectionOutbound>> buildAgentVoiceCallSubsectionOutboundList(
            MessageStatus messageStatus) {
        List<AgentVoiceCallSubsectionOutbound> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoiceCallSubsectionOutboundList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.OUTBOUND_STATS)));
        }
        return dealData(new KF5Entity<List<AgentVoiceCallSubsectionOutbound>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<VoiceQueueCall>> buildVoiceQueueCallList(MessageStatus messageStatus) {
        List<VoiceQueueCall> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildVoiceQueueCallList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.QUEUE_CALLS)));
        }
        return dealData(new KF5Entity<List<VoiceQueueCall>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<List<AgentVoiceStatus>> buildAgentVoiceStatusList(MessageStatus messageStatus) {
        List<AgentVoiceStatus> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder.buildAgentVoiceStatusList(
                    KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.AVAILABILITIES)));
        }
        return dealData(new KF5Entity<List<AgentVoiceStatus>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5Entity<AgentVoiceStatus> buildAgentVoiceStatus(MessageStatus messageStatus) {
        AgentVoiceStatus status = null;
        if (getResultCode(messageStatus) == RESULT_OK) {
            status = EntityBuilder.buildAgentVoiceStatus(
                    KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.AVAILABILITY));
        }
        return dealData(new KF5Entity<AgentVoiceStatus>(), status, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    protected KF5PaginationEntity<List<SystemLog>> buildSystemLogList(MessageStatus messageStatus) {
        List<SystemLog> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            list.addAll(EntityBuilder
                    .buildSystemLogList(KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.SYSTEM_LOG)));
        }
        return dealPaginationListData(new KF5PaginationEntity<List<SystemLog>>(), list, getResultObj(messageStatus),
                getResultCode(messageStatus));
    }

    /*================================= 2018-6-14 新增API =================================*/

    protected <T> KF5Entity<T> dealBaseMessage(KF5Entity<T> entity, MessageStatus messageStatus) {
        entity.setResultCode(messageStatus.getStatus());
        entity.setMessage(KF5EntityBuilder.safeGet(messageStatus.getJsonObject(), KF5Fields.MESSAGE));
        return entity;
    }

    protected KF5Entity<List<DocumentStats>> buildDocumentStatsList(MessageStatus messageStatus) {

        List<DocumentStats> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.POSTS_LIST);
            list.addAll(EntityBuilder.buildDocumentStatsList(jsonArray));
        }
        return dealData(new KF5Entity<List<DocumentStats>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }

    protected KF5Entity<List<PostVote>> buildPostVoteList(MessageStatus messageStatus) {
        List<PostVote> list = new ArrayList<>();
        if (getResultCode(messageStatus) == RESULT_OK) {
            JSONArray jsonArray = KF5EntityBuilder.safeArray(getResultObj(messageStatus), KF5Fields.POST_VOTE_USERS);
            list.addAll(EntityBuilder.buildPostVoteList(jsonArray));
        }
        return dealData(new KF5Entity<List<PostVote>>(), list, getResultObj(messageStatus), getResultCode(messageStatus));
    }
}
