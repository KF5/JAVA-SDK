package com.kf5.support.model.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kf5.support.model.*;
import org.kf5.support.fastjson.JSONArray;
import org.kf5.support.fastjson.JSONObject;

public class EntityBuilder extends KF5EntityBuilder {

    public static Ticket buildTicket(JSONObject jsonObject) {

        Ticket ticket = new Ticket();
        ticket.setId(safeInt(jsonObject, KF5Fields.ID));
        ticket.setUrl(safeGet(jsonObject, KF5Fields.URL));
        ticket.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        ticket.setDescription(safeGet(jsonObject, KF5Fields.DESCRIPTION));
        ticket.setType(safeGet(jsonObject, KF5Fields.TYPE));
        ticket.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
        ticket.setPriority(safeGet(jsonObject, KF5Fields.PRIORITY));
        ticket.setRecipient(safeGet(jsonObject, KF5Fields.RECIPIENT));
        ticket.setRequesterId(safeInt(jsonObject, KF5Fields.REQUESTER_ID));
        ticket.setAssigneeId(safeInt(jsonObject, KF5Fields.ASSIGNEE_ID));
        ticket.setOrganizationId(safeInt(jsonObject, KF5Fields.ORGANIZATION_ID));
        ticket.setGroupId(safeInt(jsonObject, KF5Fields.GROUP_ID));
        ticket.setProblemId(safeInt(jsonObject, KF5Fields.PROBLEM_ID));
        ticket.setDueDate(safeInt(jsonObject, KF5Fields.DUE_DATE));
        ticket.setCreatedAt(safeGet(jsonObject, KF5Fields.CREATED_AT));
        ticket.setUpdatedAt(safeGet(jsonObject, KF5Fields.UPDATED_AT));
        ticket.setAssigneedAt(safeGet(jsonObject, KF5Fields.ASSIGNEED_AT));
        ticket.setResolvedAt(safeGet(jsonObject, KF5Fields.RESOLVED_AT));
        ticket.setClosedAt(safeGet(jsonObject, KF5Fields.CLOSED_AT));
        ticket.setSource(safeGet(jsonObject, KF5Fields.SOURCE));
        ticket.setSatisfactionRating(safeGet(jsonObject, KF5Fields.SATISFACTION_RATING));
        JSONArray array = safeArray(jsonObject, KF5Fields.CUSTOM_FIELDS);
        if (array != null) {
            int size = array.size();
            List<CustomField> customList = new ArrayList<CustomField>();
            for (int i = 0; i < size; i++) {
                JSONObject customObject = array.getJSONObject(i);
                customList.add(buildCustomField(customObject));
            }
            ticket.setListCustomFields(customList);
        }
        return ticket;
    }

    public static CustomField buildCustomField(JSONObject jsonObject) {
        CustomField customField = new CustomField();
        customField.setKey(safeGet(jsonObject, KF5Fields.NAME));
        customField.setValue(safeGet(jsonObject, KF5Fields.VALUE));
        return customField;
    }

    public static List<Ticket> buildTicketList(JSONArray jsonArray) {

        List<Ticket> ticketList = new ArrayList<Ticket>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Ticket ticket = buildTicket(jsonObject);
                ticketList.add(ticket);
            }
        }

        return ticketList;
    }

    public static User buildUser(JSONObject jsonObject) {

        User user = new User();
        user.setId(safeInt(jsonObject, KF5Fields.ID));
        user.setUrl(safeGet(jsonObject, KF5Fields.URL));
        user.setEmail(safeGet(jsonObject, KF5Fields.EMAIL));
        user.setName(safeGet(jsonObject, KF5Fields.NAME));
        user.setAgentDisplayName(safeGet(jsonObject, KF5Fields.AGENT_DISPLAY_NAME));
        user.setRole(safeGet(jsonObject, KF5Fields.ROLE));
        user.setPhone(safeGet(jsonObject, KF5Fields.PHONE));
        user.setPhoneBind(safeBoolean(jsonObject, KF5Fields.PHONE_BIND));
        user.setSignature(safeGet(jsonObject, KF5Fields.SIGNATURE));
        user.setDetails(safeGet(jsonObject, KF5Fields.DETAILS));
        user.setNotes(safeGet(jsonObject, KF5Fields.NOTES));
        user.setOrganizationId(safeInt(jsonObject, KF5Fields.ORGANIZATION_ID));
        user.setLanguage(safeGet(jsonObject, KF5Fields.LANGUAGE));
        user.setCreatedAt(safeGet(jsonObject, KF5Fields.CREATED_AT));
        user.setUpdatedAt(safeGet(jsonObject, KF5Fields.UPDATED_AT));
        user.setLastLoginAt(safeGet(jsonObject, KF5Fields.LAST_LOGIN_AT));
        user.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
        user.setPhoto(safeGet(jsonObject, KF5Fields.PHOTO));
        user.setModetator(safeBoolean(jsonObject, KF5Fields.MODERATOR));
        user.setPublicComments(safeBoolean(jsonObject, KF5Fields.PUBLIC_COMMENTS));
        user.setManagePeople(safeBoolean(jsonObject, KF5Fields.MANAGE_PEOPLE));
        user.setTicketRestriction(safeGet(jsonObject, KF5Fields.TICKET_RESTRICTION));
        user.setCustomRoleId(safeInt(jsonObject, KF5Fields.CUSTOM_ROLE_ID));

        JSONArray fieldArray = safeArray(jsonObject, KF5Fields.USER_FIELDS);
        if (fieldArray != null) {
            int size = fieldArray.size();
            List<UserFiled> userFileds = new ArrayList<UserFiled>();
            for (int i = 0; i < size; i++) {
                JSONObject fieldObject = fieldArray.getJSONObject(i);
                UserFiled userFiled = buildUserFiled(fieldObject);
                userFileds.add(userFiled);
            }
            user.setUserFileds(userFileds);
        }

        JSONArray groupInfosArray = safeArray(jsonObject, KF5Fields.GROUPS_INFO);
        if (groupInfosArray != null) {
            List<GroupInfo> groupInfos = new ArrayList<GroupInfo>();
            int size = groupInfosArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObj = groupInfosArray.getJSONObject(i);
                groupInfos.add(buildGroupInfo(itemObj));
            }
            user.setGroupInfos(groupInfos);
        }
        return user;
    }

    public static UserFiled buildUserFiled(JSONObject jsonObject) {
        UserFiled userFiled = new UserFiled();
        userFiled.setKey(safeGet(jsonObject, KF5Fields.NAME));
        userFiled.setValue(safeGet(jsonObject, KF5Fields.VALUE));
        return userFiled;
    }

    private static GroupInfo buildGroupInfo(JSONObject jsonObject) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setName(safeGet(jsonObject, KF5Fields.NAME));
        groupInfo.setId(safeGet(jsonObject, KF5Fields.ID));
        groupInfo.setDisplayName(safeGet(jsonObject, KF5Fields.DISPLAY_NAME));
        return groupInfo;
    }

    public static List<User> buildUsers(JSONArray jsonArray) {

        List<User> users = new ArrayList<User>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                users.add(buildUser(itemObject));
            }
        }
        return users;

    }

    public static Requester buildRequester(JSONObject jsonObject) {
        Requester requester = new Requester();
        requester.setId(safeInt(jsonObject, KF5Fields.ID));
        requester.setUrl(safeGet(jsonObject, KF5Fields.URL));
        requester.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        requester.setDescription(safeGet(jsonObject, KF5Fields.DESCRIPTION));
        requester.setType(safeGet(jsonObject, KF5Fields.TYPE));
        requester.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
        requester.setPriority(safeGet(jsonObject, KF5Fields.PRIORITY));
        requester.setRequester_id(safeInt(jsonObject, KF5Fields.REQUESTER_ID));
        requester.setAssignee_id(safeInt(jsonObject, KF5Fields.ASSIGNEE_ID));
        requester.setOrganization_id(safeInt(jsonObject, KF5Fields.ORGANIZATION_ID));
        requester.setGroup_id(safeInt(jsonObject, KF5Fields.GROUP_ID));
        requester.setDue_date(safeGet(jsonObject, KF5Fields.DUE_DATE));
        requester.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        requester.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));
        JSONArray jsonArray = safeArray(jsonObject, KF5Fields.CUSTOM_FIELDS);
        if (jsonArray != null) {
            List<CustomField> list = new ArrayList<CustomField>();
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject customObject = jsonArray.getJSONObject(i);
                list.add(buildCustomField(customObject));
            }
            requester.setCustomFields(list);
        }
        return requester;
    }

    public static List<Requester> buildRequesters(JSONArray jsonArray) {

        List<Requester> list = new ArrayList<Requester>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildRequester(itemObject));
            }
        }
        return list;
    }

    public static Comment buildComment(JSONObject jsonObject) {

        Comment comment = new Comment();
        comment.setId(safeInt(jsonObject, KF5Fields.ID));
        comment.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        comment.setHtml_content(safeGet(jsonObject, KF5Fields.HTML_CONTENT));
        comment.setPublic(safeBoolean(jsonObject, KF5Fields.PUBLIC));
        comment.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        comment.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
        comment.setAuthor_name(safeGet(jsonObject, KF5Fields.AUTHOR_NAME));

        JSONArray attachmentArray = safeArray(jsonObject, KF5Fields.ATTACHMENTS);
        if (attachmentArray != null) {
            int size = attachmentArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject attachmentObj = attachmentArray.getJSONObject(i);
                comment.getListAttachments().add(buildAttachment(attachmentObj));
            }
        }

        return comment;

    }

    public static List<Comment> buildComments(JSONArray jsonArray) {

        List<Comment> comments = new ArrayList<Comment>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemJsonObject = jsonArray.getJSONObject(i);
                comments.add(buildComment(itemJsonObject));
            }
        }
        return comments;
    }

    public static TicketField buildTicketField(JSONObject jsonObject) {

        TicketField ticketField = new TicketField();
        ticketField.setId(safeInt(jsonObject, KF5Fields.ID));
        ticketField.setUrl(safeGet(jsonObject, KF5Fields.URL));
        ticketField.setName(safeGet(jsonObject, KF5Fields.NAME));
        ticketField.setType(safeGet(jsonObject, KF5Fields.TYPE));
        ticketField.setAgent_title(safeGet(jsonObject, KF5Fields.AGENT_TITLE));
        ticketField.setAgent_required(safeBoolean(jsonObject, KF5Fields.AGENT_REQUIRED));
        ticketField.setEnduser_visible(safeBoolean(jsonObject, KF5Fields.ENDUSER_VISIBLE));
        ticketField.setEnduser_title(safeGet(jsonObject, KF5Fields.ENDUSER_TITLE));
        ticketField.setEnduser_editable(safeBoolean(jsonObject, KF5Fields.ENDUSER_EDITABLE));
        ticketField.setEnduser_description(safeGet(jsonObject, KF5Fields.ENDUSER_DESCRIPTION));
        ticketField.setEnduser_required(safeBoolean(jsonObject, KF5Fields.ENDUSER_REQUIRED));
        ticketField.setActive(safeBoolean(jsonObject, KF5Fields.ACTIVE));
        ticketField.setRegexp_for_validation(safeGet(jsonObject, KF5Fields.REGEXP_FOR_VALIDATION));
        JSONArray optionArray = safeArray(jsonObject, KF5Fields.CUSTOM_FIELD_OPTIONS);
        if (optionArray != null) {
            int size = optionArray.size();
            List<CustomFieldOption> list = new ArrayList<CustomFieldOption>();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = optionArray.getJSONObject(i);
                list.add(buildCustomFieldOption(itemObject));
            }
            ticketField.setCustomFieldOptions(list);
        }
        return ticketField;
    }

    public static CustomFieldOption buildCustomFieldOption(JSONObject jsonObject) {

        CustomFieldOption customFieldOption = new CustomFieldOption();
        customFieldOption.setKey(safeGet(jsonObject, KF5Fields.KEY));
        customFieldOption.setValue(safeGet(jsonObject, KF5Fields.VALUE));
        return customFieldOption;
    }

    public static List<TicketField> buildTicketFields(JSONArray jsonArray) {

        List<TicketField> list = new ArrayList<TicketField>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildTicketField(itemObject));
            }
        }
        return list;
    }

    public static View buildView(JSONObject jsonObject) {

        View view = new View();
        view.setId(safeInt(jsonObject, KF5Fields.ID));
        view.setUrl(safeGet(jsonObject, KF5Fields.URL));
        view.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        view.setActive(safeBoolean(jsonObject, KF5Fields.ACTIVE));
        view.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        view.setSlas_id(safeInt(jsonObject, KF5Fields.SLAS_ID));

        return view;
    }

    public static List<View> buildViews(JSONArray jsonArray) {
        List<View> views = new ArrayList<View>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                views.add(buildView(itemObject));
            }
        }
        return views;
    }

    public static ViewCount buildViewCount(JSONObject jsonObject) {

        ViewCount viewCount = new ViewCount();
        viewCount.setCount(safeInt(jsonObject, KF5Fields.COUNT));
        viewCount.setUrl(safeGet(jsonObject, KF5Fields.URL));
        viewCount.setView_id(safeInt(jsonObject, KF5Fields.VIEW_ID));
        return viewCount;
    }

    public static List<ViewCount> buildViewCounts(JSONArray jsonArray) {

        List<ViewCount> viewCounts = new ArrayList<ViewCount>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                viewCounts.add(buildViewCount(jsonObject));
            }
        }
        return viewCounts;
    }

    public static UserField buildUserField(JSONObject jsonObject) {

        UserField userFiled = new UserField();
        userFiled.setId(safeInt(jsonObject, KF5Fields.ID));
        userFiled.setUrl(safeGet(jsonObject, KF5Fields.URL));
        userFiled.setName(safeGet(jsonObject, KF5Fields.NAME));
        userFiled.setType(safeGet(jsonObject, KF5Fields.TYPE));
        userFiled.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        userFiled.setDescription(safeGet(jsonObject, KF5Fields.DESCRIPTION));
        JSONArray jsonArray = safeArray(jsonObject, KF5Fields.CUSTOM_FIELD_OPTIONS);
        if (jsonArray != null) {
            int size = jsonArray.size();
            List<CustomFieldOption> list = new ArrayList<CustomFieldOption>();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildCustomFieldOption(itemObject));
            }
            userFiled.setCustomFieldOptions(list);
        }
        return userFiled;
    }

    public static List<UserField> buildUserFields(JSONArray jsonArray) {

        List<UserField> list = new ArrayList<UserField>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildUserField(itemObject));
            }
        }
        return list;
    }

    public static Agent buildAgent(JSONObject jsonObject) {
        Agent agent = new Agent();
        agent.setId(safeInt(jsonObject, KF5Fields.ID));
        agent.setUrl(safeGet(jsonObject, KF5Fields.URL));
        agent.setName(safeGet(jsonObject, KF5Fields.NAME));
        agent.setUsername(safeGet(jsonObject, KF5Fields.USERNAME));
        return agent;
    }

    public static List<Agent> buildAgents(JSONArray jsonArray) {

        List<Agent> list = new ArrayList<Agent>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildAgent(itemObject));
            }
        }
        return list;
    }

    public static Group buildGroup(JSONObject jsonObject) {

        Group group = new Group();
        group.setId(safeInt(jsonObject, KF5Fields.ID));
        group.setUrl(safeGet(jsonObject, KF5Fields.URL));
        group.setName(safeGet(jsonObject, KF5Fields.NAME));
        group.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        JSONArray jsonArray = safeArray(jsonObject, KF5Fields.AGENTS);
        group.setListAgents(buildAgents(jsonArray));
        return group;
    }

    public static List<Group> buildGroups(JSONArray jsonArray) {

        List<Group> list = new ArrayList<Group>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildGroup(itemObject));
            }
        }
        return list;
    }

    public static Category buildCategory(JSONObject jsonObject) {
        Category category = new Category();
        category.setId(safeInt(jsonObject, KF5Fields.ID));
        category.setUrl(safeGet(jsonObject, KF5Fields.URL));
        category.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        category.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        category.setDisplay_limit(safeInt(jsonObject, KF5Fields.DISPLAY_LIMIT));
        category.setSort(safeInt(jsonObject, KF5Fields.SORT));
        return category;
    }

    public static List<Category> buildCategories(JSONArray jsonArray) {

        List<Category> list = new ArrayList<Category>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(buildCategory(jsonObject));
            }
        }
        return list;
    }

    public static Forum buildForum(JSONObject jsonObject) {

        Forum forum = new Forum();
        forum.setId(safeInt(jsonObject, KF5Fields.ID));
        forum.setUrl(safeGet(jsonObject, KF5Fields.URL));
        forum.setCategory_id(safeInt(jsonObject, KF5Fields.CATEGORY_ID));
        forum.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        forum.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        forum.setRole_view(safeGet(jsonObject, KF5Fields.ROLE_VIEW));
        forum.setSort(safeInt(jsonObject, KF5Fields.SORT));

        return forum;

    }

    public static List<Forum> buildForums(JSONArray jsonArray) {

        List<Forum> list = new ArrayList<Forum>();

        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(buildForum(object));
            }
        }
        return list;
    }

    public static Attachment buildAttachment(JSONObject jsonObject) {
        Attachment attachment = new Attachment();
        attachment.setId(safeInt(jsonObject, KF5Fields.ID));
        attachment.setUrl(safeGet(jsonObject, KF5Fields.URL));
        attachment.setName(safeGet(jsonObject, KF5Fields.NAME));
        attachment.setSize(safeInt(jsonObject, KF5Fields.SIZE));
        attachment.setContent_url(safeGet(jsonObject, KF5Fields.CONTENT_URL));
        attachment.setToken(safeGet(jsonObject, KF5Fields.TOKEN));
        return attachment;
    }

    public static List<Attachment> buildAttachments(JSONArray jsonArray) {

        List<Attachment> list = new ArrayList<Attachment>();

        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(buildAttachment(object));
            }
        }
        return list;
    }

    public static Post buildPost(JSONObject jsonObject) {

        Post post = new Post();
        post.setId(safeInt(jsonObject, KF5Fields.ID));
        post.setUrl(safeGet(jsonObject, KF5Fields.URL));
        post.setForum_id(safeInt(jsonObject, KF5Fields.FORUM_ID));
        post.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        post.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        post.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
        post.setDisable_comments(safeBoolean(jsonObject, KF5Fields.DISABLE_COMMENTS));
        post.setIs_home(safeBoolean(jsonObject, KF5Fields.IS_HOME));
        post.setIs_highlight(safeBoolean(jsonObject, KF5Fields.IS_HIGHLIGHT));
        post.setIs_top(safeBoolean(jsonObject, KF5Fields.IS_TOP));
        post.setIs_draft(safeBoolean(jsonObject, KF5Fields.IS_DRAFT));
        post.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        post.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));

        JSONArray attachmentArray = safeArray(jsonObject, KF5Fields.ATTACHMENTS);
        if (attachmentArray != null) {
            int size = attachmentArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject attachmentObj = attachmentArray.getJSONObject(i);
                post.getAttachments().add(buildAttachment(attachmentObj));
            }
        }

        return post;

    }

    public static List<Post> buildPosts(JSONArray jsonArray) {

        List<Post> list = new ArrayList<Post>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(buildPost(object));
            }
        }
        return list;

    }

    public static PostComment buildPostComment(JSONObject jsonObject) {

        PostComment comment = new PostComment();
        comment.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
        comment.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        comment.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        comment.setId(safeInt(jsonObject, KF5Fields.ID));
        comment.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));
        return comment;

    }

    public static List<PostComment> buildPostComments(JSONArray jsonArray) {

        List<PostComment> list = new ArrayList<PostComment>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(buildPostComment(object));
            }
        }

        return list;
    }

    public static Organization buildOrganization(JSONObject jsonObject) {

        Organization organization = new Organization();
        organization.setId(safeInt(jsonObject, KF5Fields.ID));
        organization.setUrl(safeGet(jsonObject, KF5Fields.URL));
        organization.setName(safeGet(jsonObject, KF5Fields.NAME));
        organization.setDomain(safeGet(jsonObject, KF5Fields.DOMAIN));
        organization.setDesription(safeGet(jsonObject, KF5Fields.DESCRIPTION));
        organization.setGroup_id(safeInt(jsonObject, KF5Fields.GROUP_ID));
        organization.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        JSONArray jsonArray = safeArray(jsonObject, KF5Fields.ORGANIZATION_FIELDS);
        if (jsonArray != null) {
            List<OrganizationField> organizationFields = new ArrayList<OrganizationField>();
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject fildObject = jsonArray.getJSONObject(i);
                organizationFields.add(buildOrganizationField(fildObject));
            }
            organization.setOrganizationFields(organizationFields);
        }

        return organization;
    }

    public static List<Organization> buildOrganizations(JSONArray jsonArray) {

        List<Organization> list = new ArrayList<Organization>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildOrganization(itemObject));
            }
        }
        return list;
    }

    public static OrganizationField buildOrganizationField(JSONObject jsonObject) {

        OrganizationField field = new OrganizationField();
        field.setKey(safeGet(jsonObject, KF5Fields.NAME));
        field.setValue(safeGet(jsonObject, KF5Fields.VALUE));

        return field;
    }

    public static Topic buildTopic(JSONObject jsonObject) {
        Topic topic = new Topic();
        topic.setId(safeInt(jsonObject, KF5Fields.ID));
        topic.setUrl(safeGet(jsonObject, KF5Fields.URL));
        topic.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        topic.setDecription(safeGet(jsonObject, KF5Fields.DESCRIPTION));
        topic.setSort(safeInt(jsonObject, KF5Fields.SORT));
        topic.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));

        return topic;
    }

    public static List<Topic> buildTopics(JSONArray jsonArray) {

        List<Topic> list = new ArrayList<Topic>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);
                list.add(buildTopic(itemObject));
            }
        }
        return list;
    }

    public static Question buildQuestion(JSONObject jsonObject) {

        Question question = new Question();

        question.setId(safeInt(jsonObject, KF5Fields.ID));
        question.setUrl(safeGet(jsonObject, KF5Fields.URL));
        question.setTopic_id(safeInt(jsonObject, KF5Fields.TOPIC_ID));
        question.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        question.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        question.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
        question.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        question.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));

        return question;

    }

    public static List<Question> buildQuestions(JSONArray jsonArray) {
        List<Question> list = new ArrayList<Question>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(buildQuestion(object));
            }
        }
        return list;
    }

    public static QuestionComment buildQuestionComment(JSONObject jsonObject) {

        QuestionComment questionComment = new QuestionComment();
        questionComment.setId(safeInt(jsonObject, KF5Fields.ID));
        questionComment.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
        questionComment.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
        questionComment.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        questionComment.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));
        return questionComment;
    }

    public static List<QuestionComment> buildQuestionComments(JSONArray jsonArray) {

        List<QuestionComment> list = new ArrayList<QuestionComment>();

        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(buildQuestionComment(jsonObject));
            }
        }
        return list;
    }

    public static List<Chat> buildChatList(JSONArray jsonArray) {

        List<Chat> list = new ArrayList<>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(buildChat(jsonObject));
            }
        }
        return list;
    }

    public static Chat buildChat(JSONObject jsonObject) {

        Chat chat = new Chat();
        if (jsonObject != null) {
            chat.setEnd_at(safeGet(jsonObject, KF5Fields.END_AT));
            chat.setAgent_id(safeInt(jsonObject, KF5Fields.AGENT_ID));
            chat.setAssigned_at(safeGet(jsonObject, KF5Fields.ASSIGNED_AT));
            chat.setVisitor_id(safeInt(jsonObject, KF5Fields.VISITOR_ID));
            chat.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
            chat.setId(safeInt(jsonObject, KF5Fields.ID));
            chat.setType(safeGet(jsonObject, KF5Fields.TYPE));
            chat.setStarted_by(safeGet(jsonObject, KF5Fields.STARTED_BY));
            chat.setStatus(safeGet(jsonObject, KF5Fields.STATUS));

            // 8.22新增属性
            chat.setQualified(safeBoolean(jsonObject, KF5Fields.QUALIFIED));
            chat.setMessage_count(safeInt(jsonObject, KF5Fields.MESSAGE_COUNT));
            chat.setDuration(safeInt(jsonObject, KF5Fields.DURATION));
            chat.setIs_temp(safeInt(jsonObject, KF5Fields.IS_TEMP));
            chat.setAssigned(safeLong(jsonObject, KF5Fields.ASSIGNED));
            chat.setCochat(safeInt(jsonObject, KF5Fields.COCHAT));

            JSONArray messageArray = safeArray(jsonObject, KF5Fields.MESSAGES);
            if (messageArray != null) {
                List<Message> list = new ArrayList<>();
                int size = messageArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject itemObj = messageArray.getJSONObject(i);
                    list.add(buildMessage(itemObj));
                }
                chat.setList(list);
            }
        }
        return chat;
    }

    public static Message buildMessage(JSONObject jsonObject) {

        Message message = new Message();
        if (jsonObject != null) {
            message.setMsg(safeGet(jsonObject, KF5Fields.MSG));
            message.setIs_read(safeBoolean(jsonObject, KF5Fields.IS_READ));
            message.setUser_id(safeInt(jsonObject, KF5Fields.USER_ID));
            message.setName(safeGet(jsonObject, KF5Fields.NAME));
            message.setCreate_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
            message.setId(safeInt(jsonObject, KF5Fields.ID));
            message.setType(safeGet(jsonObject, KF5Fields.TYPE));
            message.setReply_timeout(safeBoolean(jsonObject, KF5Fields.REPLY_TIMEOUT));
            message.setChat_id(safeInt(jsonObject, KF5Fields.CHAT_ID));
            message.setUpload_id(safeInt(jsonObject, KF5Fields.UPLOAD_ID));
            JSONObject uploadObj = safeObject(jsonObject, KF5Fields.UPLOAD);
            if (uploadObj != null) {
                message.setUpload(buildUpload(uploadObj));
            }
        }
        return message;

    }

    public static Upload buildUpload(JSONObject jsonObject) {
        Upload upload = new Upload();
        upload.setSize(safeInt(jsonObject, KF5Fields.SIZE));
        upload.setCreate(safeInt(jsonObject, KF5Fields.CREATED));
        upload.setName(safeGet(jsonObject, KF5Fields.NAME));
        upload.setId(safeInt(jsonObject, KF5Fields.ID));
        upload.setType(safeGet(jsonObject, KF5Fields.TYPE));
        upload.setUrl(safeGet(jsonObject, KF5Fields.URL));

        // 8.22新增属性
        upload.setWidth(safeInt(jsonObject, KF5Fields.WIDTH));
        upload.setOss_token(safeGet(jsonObject, KF5Fields.OSS_TOKEN));
        upload.setHeight(safeInt(jsonObject, KF5Fields.HEIGHT));
        upload.setToken(safeGet(jsonObject, KF5Fields.TOKEN));
        return upload;

    }

    public static AICategory buildAiCategory(JSONObject jsonObject) {
        AICategory aiCategory = new AICategory();
        aiCategory.setActive(safeBoolean(jsonObject, KF5Fields.ACTIVE));
        aiCategory.setCategory_id(safeInt(jsonObject, KF5Fields.CATEGORY_ID));
        aiCategory.setAnswer(safeGet(jsonObject, KF5Fields.ANSWER));
        aiCategory.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
        aiCategory.setId(safeInt(jsonObject, KF5Fields.ID));
        aiCategory.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        JSONArray otherTitlesArray = safeArray(jsonObject, KF5Fields.OTHER_TITLES);
        if (otherTitlesArray != null)
            aiCategory.setOther_titles(otherTitlesArray.toString());
        JSONObject aiQuestionCategoryObj = safeObject(jsonObject, KF5Fields.QUESTION_CATEGORY);
        if (aiQuestionCategoryObj != null) {
            aiCategory.setAiQuestionCategory(buildAIQuestionCategory(aiQuestionCategoryObj));
        }
        return aiCategory;
    }

    public static AIQuestionCategory buildAIQuestionCategory(JSONObject jsonObject) {
        AIQuestionCategory aiQuestionCategory = new AIQuestionCategory();
        aiQuestionCategory.setId(safeInt(jsonObject, KF5Fields.ID));
        aiQuestionCategory.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
        return aiQuestionCategory;
    }

    public static List<AIQuestionCategory> buildAIQuestionCategoryList(JSONArray jsonArray) {
        List<AIQuestionCategory> list = new ArrayList<>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(buildAIQuestionCategory(jsonObject));
            }
        }
        return list;
    }

    public static List<AICategory> buildAICategoryList(JSONArray jsonArray) {
        List<AICategory> list = new ArrayList<>();
        if (jsonArray != null) {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(buildAiCategory(jsonObject));
            }
        }
        return list;
    }

    /*
     * ###########################################2017-8-21新增API################
     * ###########################
     */

    private static Condition buildCondition(JSONObject jsonObject) {
        Condition condition = new Condition();
        if (jsonObject != null) {
            condition.setCompany_id(safeGet(jsonObject, KF5Fields.COMPANY_ID));
            condition.setDelete_at(safeGet(jsonObject, KF5Fields.DELETED_AT));
            condition.setOperator(safeGet(jsonObject, KF5Fields.OPERATOR));
            condition.setSource(safeGet(jsonObject, KF5Fields.SOURCE));
            condition.setValue(safeGet(jsonObject, KF5Fields.VALUE));
        }
        return condition;
    }

    private static List<Condition> buildListCondition(JSONArray jsonArray) {
        List<Condition> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildCondition(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static Action buildAction(JSONObject jsonObject) {
        Action action = new Action();
        if (jsonObject != null) {
            action.setCompany_id(safeGet(jsonObject, KF5Fields.COMPANY_ID));
            action.setGroup_id(safeGet(jsonObject, KF5Fields.GROUP_ID));
            action.setSubject(safeGet(jsonObject, KF5Fields.SUBJECT));
            action.setSource(safeGet(jsonObject, KF5Fields.SOURCE));
            action.setBody(safeGet(jsonObject, KF5Fields.BODY));
            action.setValue(safeGet(jsonObject, KF5Fields.VALUE));
            action.setDeleted_at(safeGet(jsonObject, KF5Fields.DELETED_AT));
            action.setOverflowable(safeGet(jsonObject, KF5Fields.OVERFLOWABLE));
            action.setOverflow_type(safeGet(jsonObject, KF5Fields.OVERFLOW_TYPE));
        }
        return action;
    }

    private static List<Action> buildListAction(JSONArray jsonArray) {
        List<Action> actions = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                actions.add(buildAction(jsonArray.getJSONObject(i)));
            }
        }
        return actions;
    }

    private static Trigger buildTrigger(JSONObject jsonObject, Trigger trigger) {
        if (jsonObject != null) {
            trigger.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
            trigger.setId(safeInt(jsonObject, KF5Fields.ID));
            trigger.setSort(safeInt(jsonObject, KF5Fields.SORT));
            trigger.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
            JSONObject conditionObj = safeObject(jsonObject, KF5Fields.CONDITIONS);
            if (conditionObj != null) {
                JSONArray allArray = safeArray(conditionObj, KF5Fields.ALL);
                if (allArray != null) {
                    trigger.setAllConditions(buildListCondition(allArray));
                }
                JSONArray anyArray = safeArray(conditionObj, KF5Fields.ANY);
                if (anyArray != null) {
                    trigger.setAnyConditions(buildListCondition(anyArray));
                }
            }
            JSONArray actionArray = safeArray(jsonObject, KF5Fields.ACTIONS);
            if (actionArray != null) {
                trigger.setActions(buildListAction(actionArray));
            }
            trigger.setUrl(safeGet(jsonObject, KF5Fields.URL));
            trigger.setStatus(safeBoolean(jsonObject, KF5Fields.STATUS));
        }
        return trigger;
    }

    public static Trigger buildTrigger(JSONObject jsonObject) {
        return buildTrigger(jsonObject, new Trigger());
    }

    public static List<Trigger> buildTriggerList(JSONArray jsonArray) {
        List<Trigger> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildTrigger(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static Automation buildAutomation(JSONObject jsonObject) {
        Automation automation = new Automation();
        if (jsonObject != null) {
            buildTrigger(jsonObject, automation);
        }
        return automation;
    }

    public static List<Automation> buildAutomationList(JSONArray jsonArray) {
        List<Automation> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAutomation(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentLog buildAgentLog(JSONObject jsonObject) {
        AgentLog agentLog = new AgentLog();
        if (jsonObject != null) {
            agentLog.setLog_id(safeLong(jsonObject, KF5Fields.LOG_ID));
            agentLog.setOperate(safeGet(jsonObject, KF5Fields.OPERATE));
            agentLog.setUser_id(safeInt(jsonObject, KF5Fields.USER_ID));
            agentLog.setMax_serve(safeInt(jsonObject, KF5Fields.MAX_SERVE));
            agentLog.setCreated(safeLong(jsonObject, KF5Fields.CREATED));
            agentLog.setUser_name(safeGet(jsonObject, KF5Fields.USER_NAME));
            agentLog.setPlatform(safeGet(jsonObject, KF5Fields.PLATFORM));
        }

        return agentLog;
    }

    public static List<AgentLog> buildAgentLogList(JSONArray jsonArray) {
        List<AgentLog> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentLog(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static AITag buildAITag(JSONObject jsonObject) {
        AITag aiTag = new AITag();
        if (jsonObject != null) {
            aiTag.setId(safeInt(jsonObject, KF5Fields.ID));
            aiTag.setName(safeGet(jsonObject, KF5Fields.NAME));
            aiTag.setType(safeGet(jsonObject, KF5Fields.TYPE));
        }
        return aiTag;
    }

    public static List<AITag> buildAITagList(JSONArray jsonArray) {
        List<AITag> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAITag(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentStatus buildAgentStatus(JSONObject jsonObject) {
        AgentStatus agentStatus = new AgentStatus();
        if (jsonObject != null) {
            agentStatus.setServeCount(safeInt(jsonObject, KF5Fields.SERVECOUNT));
            agentStatus.setAgentId(safeInt(jsonObject, KF5Fields.AGENT_ID));
            agentStatus.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            agentStatus.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            agentStatus.setMaxServe(safeInt(jsonObject, KF5Fields.MAX_SERVE));
            agentStatus.setAgentName(safeGet(jsonObject, KF5Fields.AGENTNAME));
            agentStatus.setAgentStatus(safeGet(jsonObject, KF5Fields.AGENTSTATUS));
            agentStatus.setEnabled(safeInt(jsonObject, KF5Fields.ENABLED));
            agentStatus.setAverageResponseTime(safeInt(jsonObject, KF5Fields.AVERAGERESPONSETIME));
            agentStatus.setAverageServeTime(safeFloat(jsonObject, KF5Fields.AVERAGESERVETIME));
        }
        return agentStatus;
    }

    private static List<AgentStatus> buildAgentStatusList(JSONArray jsonArray) {
        List<AgentStatus> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentStatus(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentOverview buildAgentOverview(JSONObject jsonObject) {

        AgentOverview agentOverview = new AgentOverview();
        if (jsonObject != null) {
            agentOverview.setServeCount(safeInt(jsonObject, KF5Fields.SERVECOUNT));
            agentOverview.setAverageResponseTime(safeInt(jsonObject, KF5Fields.AVERAGERESPONSETIME));
            agentOverview.setAverageServeTime(safeFloat(jsonObject, KF5Fields.AVERAGESERVETIME));
            agentOverview.setSumResponseTime(safeInt(jsonObject, KF5Fields.SUMRESPONSETIME));
            agentOverview.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            agentOverview.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            agentOverview.setSumServeTime(safeInt(jsonObject, KF5Fields.SUMSERVETIME));
        }

        return agentOverview;
    }

    public static MonitorAgent buildMonitorAgent(JSONObject jsonObject) {
        MonitorAgent monitorAgent = new MonitorAgent();
        JSONObject overviewObj = safeObject(jsonObject, KF5Fields.MONITOR_OVERVIEW);
        monitorAgent.setAgentOverview(buildAgentOverview(overviewObj));
        monitorAgent.setAgentStatus(buildAgentStatusList(safeArray(jsonObject, KF5Fields.MONITOR_TABLE)));
        return monitorAgent;
    }

    private static ChatInfo buildChatInfo(JSONObject jsonObject) {
        ChatInfo chatInfo = new ChatInfo();
        if (chatInfo != null) {
            chatInfo.setAgent_name(safeGet(jsonObject, KF5Fields.AGENT_NAME));
            chatInfo.setCreated(safeLong(jsonObject, KF5Fields.CREATED));
            chatInfo.setVisitor_id(safeInt(jsonObject, KF5Fields.VISITOR_ID));
            chatInfo.setType(safeGet(jsonObject, KF5Fields.TYPE));
            chatInfo.setMessage_count(safeInt(jsonObject, KF5Fields.MESSAGE_COUNT));
            chatInfo.setVisitor_name(safeGet(jsonObject, KF5Fields.VISITOR_NAME));
            chatInfo.setChat_id(safeInt(jsonObject, KF5Fields.CHAT_ID));
            chatInfo.setAssigned(safeLong(jsonObject, KF5Fields.ASSIGNED));
            chatInfo.setClosed(safeInt(jsonObject, KF5Fields.CLOSED));
            chatInfo.setChat_from(safeGet(jsonObject, KF5Fields.CHAT_FROM));
            chatInfo.setAgent_ids(safeInt(jsonObject, KF5Fields.AGENT_IDS));
            chatInfo.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
        }

        return chatInfo;
    }

    public static List<ChatInfo> buildChatInfoList(JSONArray jsonArray) {
        List<ChatInfo> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildChatInfo(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static QueueVisitorInfo buildQueueVisitorInfo(JSONObject jsonObject) {
        QueueVisitorInfo queueVisitorInfo = new QueueVisitorInfo();
        if (jsonObject != null) {
            queueVisitorInfo.setSelectedAgentIds(safeGet(jsonObject, KF5Fields.SELECTEDAGENTIDS));
            queueVisitorInfo.setKf5_user_id(safeGet(jsonObject, KF5Fields.KF5_USER_ID));
            queueVisitorInfo.setStartedBy(safeGet(jsonObject, KF5Fields.STARTED_BY));
            queueVisitorInfo.setSession_id(safeGet(jsonObject, KF5Fields.SESSION_ID));
            queueVisitorInfo.setAssignType(safeGet(jsonObject, KF5Fields.ASSIGNTYPE));
            queueVisitorInfo.setSource(safeGet(jsonObject, KF5Fields.SOURCE));
            queueVisitorInfo.setPlatform(safeGet(jsonObject, KF5Fields.PLATFORM));
            queueVisitorInfo.setEnqueueTime(safeGet(jsonObject, KF5Fields.ENQUEUETIME));
            queueVisitorInfo.setDuration(safeInt(jsonObject, KF5Fields.DURATION));
            queueVisitorInfo.setCompanyId(safeGet(jsonObject, KF5Fields.COMPANY_ID));
            queueVisitorInfo.setName(safeGet(jsonObject, KF5Fields.NAME));
            queueVisitorInfo.setId(safeGet(jsonObject, KF5Fields.ID));
            queueVisitorInfo.setLang(safeGet(jsonObject, KF5Fields.LANG));
            queueVisitorInfo.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
        }
        return queueVisitorInfo;
    }

    public static List<QueueVisitorInfo> buildQueueVisitorInfoList(JSONArray jsonArray) {
        List<QueueVisitorInfo> list = new ArrayList<>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildQueueVisitorInfo(jsonArray.getJSONObject(i)));
            }
        }

        return list;
    }

    private static AgentWorkStatusOverview buildAgentWorkStatusOverview(JSONObject jsonObject) {
        AgentWorkStatusOverview overview = new AgentWorkStatusOverview();
        if (jsonObject != null) {
            overview.setServeCount(safeInt(jsonObject, KF5Fields.SERVECOUNT));
            overview.setRatingNum(safeInt(jsonObject, KF5Fields.RATINGNUM));
            overview.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            overview.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            overview.setSatisfaction(safeInt(jsonObject, KF5Fields.SATISFACTION));
            overview.setRatingRate(safeFloat(jsonObject, KF5Fields.RATINGRATE));
        }
        return overview;
    }

    private static AgentWorkStatus buildAgentWorkStatus(JSONObject jsonObject) {
        AgentWorkStatus agentWorkStatus = new AgentWorkStatus();
        if (jsonObject != null) {
            agentWorkStatus.setAverageResponseTime(safeInt(jsonObject, KF5Fields.AVERAGERESPONSETIME));
            agentWorkStatus.setServeCount(safeInt(jsonObject, KF5Fields.SERVECOUNT));
            agentWorkStatus.setRatingNum(safeInt(jsonObject, KF5Fields.RATINGNUM));
            agentWorkStatus.setAverageServeTime(safeFloat(jsonObject, KF5Fields.AVERAGESERVETIME));
            agentWorkStatus.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            agentWorkStatus.setAgent_id(safeGet(jsonObject, KF5Fields.AGENT_ID));
            agentWorkStatus.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            agentWorkStatus.setSatisfaction(safeInt(jsonObject, KF5Fields.SATISFACTION));
            agentWorkStatus.setRatingRate(safeInt(jsonObject, KF5Fields.RATINGRATE));
        }

        return agentWorkStatus;
    }

    private static List<AgentWorkStatus> buildAgentWorkStatusList(JSONArray jsonArray) {
        List<AgentWorkStatus> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentWorkStatus(jsonArray.getJSONObject(i)));
            }
        }

        return list;
    }

    public static AgentWorkStatusStatistics buildAgentWorkStatusStatistics(JSONObject jsonObject) {
        AgentWorkStatusStatistics agentWorkStatusStatistics = new AgentWorkStatusStatistics();
        agentWorkStatusStatistics.setAgentWorkStatusOverview(
                buildAgentWorkStatusOverview(safeObject(jsonObject, KF5Fields.AGENT_OVERVIEW)));
        agentWorkStatusStatistics
                .setAgentWorkStatus(buildAgentWorkStatusList(safeArray(jsonObject, KF5Fields.AGENT_TABLE)));
        return agentWorkStatusStatistics;
    }

    private static AgentConversationOverview buildAgentConversationOverview(JSONObject jsonObject) {
        AgentConversationOverview conversationOverview = new AgentConversationOverview();

        if (jsonObject != null) {
            conversationOverview.setServeCount(safeInt(jsonObject, KF5Fields.SERVECOUNT));
            conversationOverview.setAverageResponseTime(safeInt(jsonObject, KF5Fields.AVERAGERESPONSETIME));
            conversationOverview.setAverageServeTime(safeInt(jsonObject, KF5Fields.AVERAGESERVETIME));
            conversationOverview.setSumResponseTime(safeInt(jsonObject, KF5Fields.SUMRESPONSETIME));
            conversationOverview.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            conversationOverview.setSumServeTime(safeInt(jsonObject, KF5Fields.SUMSERVETIME));
        }

        return conversationOverview;
    }

    private static AgentConversation buildAgentConversation(JSONObject jsonObject) {
        AgentConversation agentConversation = new AgentConversation();
        if (jsonObject != null) {
            agentConversation.setServeCount(safeInt(jsonObject, KF5Fields.SERVECOUNT));
            agentConversation.setSumResponseTime(safeInt(jsonObject, KF5Fields.SUMRESPONSETIME));
            agentConversation.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            agentConversation.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            agentConversation.setSumServeTime(safeInt(jsonObject, KF5Fields.SUMSERVETIME));
            agentConversation.setTimestamp(safeLong(jsonObject, KF5Fields.TIMESTAMP));
        }
        return agentConversation;
    }

    private static List<AgentConversation> buildAgentConversationList(JSONArray jsonArray) {
        List<AgentConversation> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentConversation(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static AgentConversationStatistics buildAgentConversationStatistics(JSONObject jsonObject) {
        AgentConversationStatistics agentConversationStatistics = new AgentConversationStatistics();
        agentConversationStatistics.setAgentConversationOverview(
                buildAgentConversationOverview(safeObject(jsonObject, KF5Fields.TIME_OVERVIEW)));
        agentConversationStatistics
                .setAgentConversations(buildAgentConversationList(safeArray(jsonObject, KF5Fields.TIME_TABLE)));
        return agentConversationStatistics;
    }

    private static AgentStatusSummary buildAgentStatusSummary(JSONObject jsonObject) {
        AgentStatusSummary agentStatusSummary = new AgentStatusSummary();
        if (jsonObject != null) {
            agentStatusSummary.setOnlineAverage(safeFloat(jsonObject, KF5Fields.ONLINEAVERAGE));
            agentStatusSummary.setBusyAverage(safeFloat(jsonObject, KF5Fields.BUSYAVERAGE));
            agentStatusSummary.setOnlineTotal(safeFloat(jsonObject, KF5Fields.ONLINETOTAL));
            agentStatusSummary.setBusyTotal(safeFloat(jsonObject, KF5Fields.BUSYTOTAL));
        }
        return agentStatusSummary;
    }

    private static AgentStatusTime buildAgentStatusTime(JSONObject jsonObject) {
        AgentStatusTime agentStatusTime = new AgentStatusTime();
        if (jsonObject != null) {
            agentStatusTime.setAgent_id(safeInt(jsonObject, KF5Fields.AGENT_ID));
            agentStatusTime.setOnlineAverage(safeFloat(jsonObject, KF5Fields.ONLINEAVERAGE));
            agentStatusTime.setBusyAverage(safeFloat(jsonObject, KF5Fields.BUSYAVERAGE));
            agentStatusTime.setOnlineTotal(safeFloat(jsonObject, KF5Fields.ONLINETOTAL));
            agentStatusTime.setBusyTotal(safeFloat(jsonObject, KF5Fields.BUSYTOTAL));
        }
        return agentStatusTime;
    }

    private static List<AgentStatusTime> buildAgentStatusTimeList(JSONArray jsonArray) {
        List<AgentStatusTime> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentStatusTime(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static AgentStatusTimeStatistics buildAgentStatusTimeStatistics(JSONObject jsonObject) {
        AgentStatusTimeStatistics statistics = new AgentStatusTimeStatistics();
        statistics.setAgentStatusSummary(buildAgentStatusSummary(safeObject(jsonObject, KF5Fields.SUMMARY)));
        statistics.setAgentStatusTimes(buildAgentStatusTimeList(safeArray(jsonObject, KF5Fields.AGENTS)));
        return statistics;
    }

    private static ChatSource buildChatSource(JSONObject jsonObject) {
        ChatSource chatSource = new ChatSource();
        if (jsonObject != null) {
            chatSource.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
            chatSource.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            chatSource.setType(safeGet(jsonObject, KF5Fields.TYPE));
        }
        return chatSource;
    }

    private static List<ChatSource> buildChatSourceList(JSONArray jsonArray) {
        List<ChatSource> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildChatSource(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static ChatSourceOverview buildChatSourceOverview(JSONObject jsonObject) {
        ChatSourceOverview chatSourceOverview = new ChatSourceOverview();
        if (jsonObject != null) {
            chatSourceOverview.setMessageNum(safeInt(jsonObject, KF5Fields.MESSAGENUM));
            chatSourceOverview.setChatNum(safeInt(jsonObject, KF5Fields.CHATNUM));
        }
        return chatSourceOverview;
    }

    public static ChatSourceStatistics buildChatSourceStatistics(JSONObject jsonObject) {
        ChatSourceStatistics statistics = new ChatSourceStatistics();
        statistics.setChatSourceOverview(buildChatSourceOverview(safeObject(jsonObject, KF5Fields.SOURCE_OVERVIEW)));
        statistics.setChatSources(buildChatSourceList(safeArray(jsonObject, KF5Fields.SOURCE_TABLE)));
        return statistics;
    }

    public static AgentStatistics buildAgentStatistics(JSONObject jsonObject) {
        AgentStatistics statistics = new AgentStatistics();
        if (jsonObject != null) {
            statistics.setRole(safeGet(jsonObject, KF5Fields.ROLE));
            statistics.setAgent_id(safeInt(jsonObject, KF5Fields.AGENT_ID));
            statistics.setMax_serve(safeInt(jsonObject, KF5Fields.MAX_SERVE));
            statistics.setCreated(safeLong(jsonObject, KF5Fields.CREATED));
            statistics.setName(safeGet(jsonObject, KF5Fields.NAME));
            statistics.setPhoto(safeGet(jsonObject, KF5Fields.PHOTO));
            statistics.setDisplay_name(safeGet(jsonObject, KF5Fields.DISPLAY_NAME));
            statistics.setAppStatus(safeGet(jsonObject, KF5Fields.APPSTATUS));
            statistics.setWebStatus(safeGet(jsonObject, KF5Fields.WEBSTATUS));
            statistics.setEmail(safeGet(jsonObject, KF5Fields.EMAIL));
            statistics.setEnabled(safeInt(jsonObject, KF5Fields.ENABLED));
        }
        return statistics;
    }

    public static VoiceCall buildVoiceCall(JSONObject jsonObject) {
        VoiceCall voiceCall = new VoiceCall();
        if (jsonObject != null) {
            voiceCall.setCallsid(safeGet(jsonObject, KF5Fields.CALLSID));
            voiceCall.setRecordurl(safeGet(jsonObject, KF5Fields.RECORDURL));
            voiceCall.setUser_name(safeGet(jsonObject, KF5Fields.USER_NAME));
            voiceCall.setAlerting_seconds(safeInt(jsonObject, KF5Fields.ALERTING_SECONDS));
            voiceCall.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
            voiceCall.setCallduration(safeInt(jsonObject, KF5Fields.CALLDURATION));
            voiceCall.setType(safeGet(jsonObject, KF5Fields.TYPE));
            voiceCall.setDuration(safeInt(jsonObject, KF5Fields.DURATION));
            voiceCall.setUser_id(safeInt(jsonObject, KF5Fields.USER_ID));
            voiceCall.setFrom(safeGet(jsonObject, KF5Fields.FROM));
            voiceCall.setId(safeInt(jsonObject, KF5Fields.ID));
            voiceCall.setTo(safeGet(jsonObject, KF5Fields.TO));
            voiceCall.setIs_answered(safeInt(jsonObject, KF5Fields.IS_ANSWERED));
        }
        return voiceCall;
    }

    public static List<VoiceCall> buildVoiceCallList(JSONArray jsonArray) {
        List<VoiceCall> list = new ArrayList<>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildVoiceCall(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static VoiceAccount buildVoiceAccount(JSONObject jsonObject) {
        VoiceAccount account = new VoiceAccount();
        if (jsonObject != null) {
            account.setVoip_account(safeGet(jsonObject, KF5Fields.VOIP_ACCOUNT));
            account.setUser_id(safeGet(jsonObject, KF5Fields.USER_ID));
            account.setCreated(safeGet(jsonObject, KF5Fields.CREATED));
            account.setStatus_updated(safeGet(jsonObject, KF5Fields.STATUS_UPDATED));
            account.setId(safeGet(jsonObject, KF5Fields.ID));
            account.setVoip_pwd(safeGet(jsonObject, KF5Fields.VOIP_PWD));
            account.setType(safeGet(jsonObject, KF5Fields.TYPE));
            account.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
        }
        return account;
    }

    public static List<VoiceAccount> buildVoiceAccountList(JSONArray jsonArray) {
        List<VoiceAccount> list = new ArrayList<>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildVoiceAccount(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static VoiceAgentLoginState buildVoiceAgentLoginState(JSONObject jsonObject) {
        VoiceAgentLoginState state = new VoiceAgentLoginState();
        if (jsonObject != null) {
            state.setAgent_id(safeGet(jsonObject, KF5Fields.AGENT_ID));
            state.setCreated(safeGet(jsonObject, KF5Fields.CREATED));
            state.setType(safeInt(jsonObject, KF5Fields.TYPE));
        }
        return state;
    }

    public static List<VoiceAgentLoginState> buildVoiceAgentLoginStateList(JSONArray jsonArray) {
        List<VoiceAgentLoginState> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildVoiceAgentLoginState(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static VoiceCallUnAnswered buildVoiceCallUnAnswered(JSONObject jsonObject) {
        VoiceCallUnAnswered unAnswered = new VoiceCallUnAnswered();
        if (jsonObject != null) {
            unAnswered.setReason(safeGet(jsonObject, KF5Fields.REASON));
            unAnswered.setUser_id(safeGet(jsonObject, KF5Fields.USER_ID));
            unAnswered.setCreated(safeGet(jsonObject, KF5Fields.CREATED));
            unAnswered.setAlerting_seconds(safeGet(jsonObject, KF5Fields.ALERTING_SECONDS));
            unAnswered.setFrom(safeGet(jsonObject, KF5Fields.FROM));
            unAnswered.setId(safeGet(jsonObject, KF5Fields.ID));
            unAnswered.setCallduration(safeGet(jsonObject, KF5Fields.CALLDURATION));
        }

        return unAnswered;
    }

    public static List<VoiceCallUnAnswered> buildVoiceCallUnAnsweredList(JSONArray jsonArray) {
        List<VoiceCallUnAnswered> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildVoiceCallUnAnswered(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentVoiceCallOutbound buildAgentVoiceCallOutbound(JSONObject jsonObject) {
        AgentVoiceCallOutbound outbound = new AgentVoiceCallOutbound();
        if (jsonObject != null) {
            outbound.setAgentid(safeInt(jsonObject, KF5Fields.AGENTID));
            outbound.setTotal(safeInt(jsonObject, KF5Fields.TOTAL));
            outbound.setAvg_callduration(safeInt(jsonObject, KF5Fields.AVG_CALLDURATION));
            outbound.setAgent_name(safeGet(jsonObject, KF5Fields.AGENT_NAME));
            outbound.setCallduration(safeInt(jsonObject, KF5Fields.CALLDURATION));
            outbound.setAnswer_rate(safeGet(jsonObject, KF5Fields.ANSWER_RATE));
            outbound.setAnswer(safeInt(jsonObject, KF5Fields.ANSWER));
        }
        return outbound;
    }

    public static List<AgentVoiceCallOutbound> buildAgentVoiceCallOutboundList(JSONArray jsonArray) {
        List<AgentVoiceCallOutbound> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoiceCallOutbound(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentVoiceCallInbound buildAgentVoiceCallInbound(JSONObject jsonObject) {
        AgentVoiceCallInbound inbound = new AgentVoiceCallInbound();
        if (jsonObject != null) {
            inbound.setAvg_callduration(safeInt(jsonObject, KF5Fields.AVG_CALLDURATION));
            inbound.setTicket_num(safeInt(jsonObject, KF5Fields.TICKET_NUM));
            inbound.setAgent_id(safeGet(jsonObject, KF5Fields.AGENT_ID));
            inbound.setAgent_name(safeGet(jsonObject, KF5Fields.AGENT_NAME));
            inbound.setScore_rate(safeGet(jsonObject, KF5Fields.SCORE_RATE));
            inbound.setCallduration(safeInt(jsonObject, KF5Fields.CALLDURATION));
            inbound.setAnswer_rate(safeGet(jsonObject, KF5Fields.ANSWER_RATE));
            inbound.setTotal(safeInt(jsonObject, KF5Fields.TOTAL));
            inbound.setScore_num(safeInt(jsonObject, KF5Fields.SCORE_NUM));
            inbound.setAnswer(safeInt(jsonObject, KF5Fields.ANSWER));
            inbound.setCancel_rate(safeGet(jsonObject, KF5Fields.CANCEL_RATE));
            inbound.setUser_cancel(safeInt(jsonObject, KF5Fields.USER_CANCEL));
            inbound.setAvg_score(safeGet(jsonObject, KF5Fields.AVG_SCORE));
        }

        return inbound;
    }

    public static List<AgentVoiceCallInbound> buildAgentVoiceCallInboundList(JSONArray jsonArray) {
        List<AgentVoiceCallInbound> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoiceCallInbound(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentVoicePerformance buildAgentVoicePerformance(JSONObject jsonObject) {
        AgentVoicePerformance performance = new AgentVoicePerformance();
        if (jsonObject != null) {
            performance.setAgentid(safeInt(jsonObject, KF5Fields.AGENTID));
            performance.setAgent_name(safeGet(jsonObject, KF5Fields.AGENT_NAME));
            performance.setAlerting_times(safeInt(jsonObject, KF5Fields.ALERTING_TIMES));
            performance.setTransfered_times(safeInt(jsonObject, KF5Fields.TRANSFERED_TIMES));
            performance.setTotal_holding_duration(safeInt(jsonObject, KF5Fields.TOTAL_HOLDING_DURATION));
            performance.setAvg_transfer_duration(safeInt(jsonObject, KF5Fields.AVG_TRANSFER_DURATION));
            performance.setAvg_holding_duration(safeInt(jsonObject, KF5Fields.AVG_HOLDING_DURATION));
            performance.setTransfer_times(safeInt(jsonObject, KF5Fields.TRANSFER_TIMES));
            performance.setAvg_alerting_duration(safeInt(jsonObject, KF5Fields.AVG_ALERTING_DURATION));
            performance.setAvg_transfered_duration(safeInt(jsonObject, KF5Fields.AVG_TRANSFERED_DURATION));
            performance.setHolding_times(safeInt(jsonObject, KF5Fields.HOLDING_TIMES));
            performance.setTotal_transfer_duration(safeInt(jsonObject, KF5Fields.TOTAL_TRANSFER_DURATION));
            performance.setTotal_alerting_duration(safeInt(jsonObject, KF5Fields.TOTAL_ALERTING_DURATION));
            performance.setTotal_transfered_duration(safeInt(jsonObject, KF5Fields.TOTAL_TRANSFERED_DURATION));
        }
        return performance;
    }

    public static List<AgentVoicePerformance> buildAgentVoicePerformanceList(JSONArray jsonArray) {
        List<AgentVoicePerformance> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoicePerformance(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentVoiceStateTime buildAgentVoiceStateTime(JSONObject jsonObject) {
        AgentVoiceStateTime time = new AgentVoiceStateTime();
        if (jsonObject != null) {
            time.setAvg_online_duration(safeInt(jsonObject, KF5Fields.AVG_ONLINE_DURATION));
            time.setAgentid(safeInt(jsonObject, KF5Fields.AGENTID));
            time.setAgent_name(safeGet(jsonObject, KF5Fields.AGENT_NAME));
            time.setAvg_break_duration(safeInt(jsonObject, KF5Fields.AVG_BREAK_DURATION));
            time.setAvg_busy_duration(safeInt(jsonObject, KF5Fields.AVG_BUSY_DURATION));
            time.setOnline_duration(safeInt(jsonObject, KF5Fields.ONLINE_DURATION));
            time.setBreak_duration(safeInt(jsonObject, KF5Fields.BREAK_DURATION));
            time.setBusy_duration(safeInt(jsonObject, KF5Fields.BUSY_DURATION));
        }

        return time;
    }

    public static List<AgentVoiceStateTime> buildAgentVoiceStateTimeList(JSONArray jsonArray) {

        List<AgentVoiceStateTime> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoiceStateTime(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentVoiceCallSubsectionInbound buildAgentVoiceCallSubsectionInbound(JSONObject jsonObject) {
        AgentVoiceCallSubsectionInbound inbound = new AgentVoiceCallSubsectionInbound();
        if (jsonObject != null) {
            inbound.setAvg_callduration(safeInt(jsonObject, KF5Fields.AVG_CALLDURATION));
            inbound.setTicket_num(safeInt(jsonObject, KF5Fields.TICKET_NUM));
            inbound.setAnswer(safeInt(jsonObject, KF5Fields.ANSWER));
            inbound.setAvg_response_duration(safeInt(jsonObject, KF5Fields.AVG_RESPONSE_DURATION));
            inbound.setTime(safeGet(jsonObject, KF5Fields.TIME));
            inbound.setAnswer_rate(safeGet(jsonObject, KF5Fields.ANSWER_RATE));
            inbound.setAcd_cancel(safeInt(jsonObject, KF5Fields.ACD_CANCEL));
            inbound.setAgent_num(safeInt(jsonObject, KF5Fields.AGENT_NUM));
            inbound.setIvr_cancel(safeInt(jsonObject, KF5Fields.IVR_CANCEL));
            inbound.setAgent_reject(safeInt(jsonObject, KF5Fields.AGENT_REJECT));
            inbound.setAvg_score(safeGet(jsonObject, KF5Fields.AVG_SCORE));
        }
        return inbound;
    }

    public static List<AgentVoiceCallSubsectionInbound> buildAgentVoiceCallSubsectionInboundList(JSONArray jsonArray) {

        List<AgentVoiceCallSubsectionInbound> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoiceCallSubsectionInbound(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static AgentVoiceCallSubsectionOutbound buildAgentVoiceCallSubsectionOutbound(JSONObject jsonObject) {
        AgentVoiceCallSubsectionOutbound outbound = new AgentVoiceCallSubsectionOutbound();
        if (jsonObject != null) {
            outbound.setAvg_callduration(safeInt(jsonObject, KF5Fields.AVG_CALLDURATION));
            outbound.setTicket_num(safeInt(jsonObject, KF5Fields.TICKET_NUM));
            outbound.setAnswer(safeInt(jsonObject, KF5Fields.ANSWER));
            outbound.setUnanswer(safeInt(jsonObject, KF5Fields.UNANSWER));
            outbound.setTime(safeGet(jsonObject, KF5Fields.TIME));
            outbound.setAnswer_rate(safeGet(jsonObject, KF5Fields.ANSWER_RATE));
            outbound.setAgent_num(safeInt(jsonObject, KF5Fields.AGENT_NUM));
        }

        return outbound;
    }

    public static List<AgentVoiceCallSubsectionOutbound> buildAgentVoiceCallSubsectionOutboundList(
            JSONArray jsonArray) {
        List<AgentVoiceCallSubsectionOutbound> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoiceCallSubsectionOutbound(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static VoiceQueueCall buildVoiceQueueCall(JSONObject jsonObject) {
        VoiceQueueCall call = new VoiceQueueCall();
        if (jsonObject != null) {
            call.setCallsid(safeGet(jsonObject, KF5Fields.CALLSID));
            call.setNumber(safeGet(jsonObject, KF5Fields.NUMBER));
            call.setSource(safeGet(jsonObject, KF5Fields.SOURCE));
            call.setCreated(safeGet(jsonObject, KF5Fields.CREATED));
            call.setQueuetype(safeGet(jsonObject, KF5Fields.QUEUETYPE));
            call.setFromattr(safeGet(jsonObject, KF5Fields.FROMATTR));
            call.setUser_id(safeGet(jsonObject, KF5Fields.USER_ID));
            call.setOrganization_name(safeGet(jsonObject, KF5Fields.ORGANIZATION_NAME));
            call.setName(safeGet(jsonObject, KF5Fields.NAME));
            call.setElaspe(safeInt(jsonObject, KF5Fields.ELASPE));
        }
        return call;
    }

    public static List<VoiceQueueCall> buildVoiceQueueCallList(JSONArray jsonArray) {
        List<VoiceQueueCall> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildVoiceQueueCall(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static AgentVoiceStatus buildAgentVoiceStatus(JSONObject jsonObject) {
        AgentVoiceStatus status = new AgentVoiceStatus();
        if (jsonObject != null) {
            status.setAgent_id(safeGet(jsonObject, KF5Fields.AGENT_ID));
            status.setAgent_name(safeGet(jsonObject, KF5Fields.AGENT_NAME));
            status.setUser_id(safeGet(jsonObject, KF5Fields.USER_ID));
            status.setStatus_updated(safeGet(jsonObject, KF5Fields.STATUS_UPDATED));
            status.setType(safeGet(jsonObject, KF5Fields.TYPE));
            status.setStatus(safeGet(jsonObject, KF5Fields.STATUS));
            status.setNumber(safeGet(jsonObject, KF5Fields.NUMBER));
            status.setCall_status(safeGet(jsonObject, KF5Fields.CALL_STATUS));
        }
        return status;
    }

    public static List<AgentVoiceStatus> buildAgentVoiceStatusList(JSONArray jsonArray) {
        List<AgentVoiceStatus> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildAgentVoiceStatus(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static SystemLog buildSystemLog(JSONObject jsonObject) {
        SystemLog log = new SystemLog();
        if (jsonObject != null) {
            log.setUser_id(safeInt(jsonObject, KF5Fields.USER_ID));
            log.setObject_type(safeGet(jsonObject, KF5Fields.OBJECT_TYPE));
            log.setUser_name(safeGet(jsonObject, KF5Fields.USER_NAME));
            log.setIp(safeGet(jsonObject, KF5Fields.IP));
            log.setAction(safeGet(jsonObject, KF5Fields.ACTION));
            log.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
            log.setId(safeInt(jsonObject, KF5Fields.ID));
            log.setObject(safeGet(jsonObject, KF5Fields.OBJECT));
        }
        return log;
    }

    public static List<SystemLog> buildSystemLogList(JSONArray jsonArray) {
        List<SystemLog> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildSystemLog(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static IMAgent buildIMAgent(JSONObject jsonObject) {
        IMAgent imAgent = new IMAgent();
        if (jsonObject != null) {
            imAgent.setMax_serve(safeInt(jsonObject, KF5Fields.MAX_SERVE));
            imAgent.setApp_status(safeGet(jsonObject, KF5Fields.APP_STATUS));
            imAgent.setName(safeGet(jsonObject, KF5Fields.NAME));
            imAgent.setPhoto(safeGet(jsonObject, KF5Fields.PHOTO));
            imAgent.setWeb_status(safeGet(jsonObject, KF5Fields.WEB_STATUS));
            imAgent.setId(safeInt(jsonObject, KF5Fields.ID));
            imAgent.setDiplay_name(safeGet(jsonObject, KF5Fields.DISPLAY_NAME));
        }
        return imAgent;
    }

    private static List<IMAgent> buildIMAgentList(JSONArray jsonArray) {
        List<IMAgent> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildIMAgent(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    private static IMGroup buildIMGroup(JSONObject jsonObject) {
        IMGroup group = new IMGroup();
        if (jsonObject != null) {
            group.setId(safeGet(jsonObject, KF5Fields.ID));
            group.setName(safeGet(jsonObject, KF5Fields.NAME));
            group.setAgents(safeArray(jsonObject, KF5Fields.AGENTS));
        }
        return group;
    }

    private static List<IMGroup> buildIMGroupList(JSONArray jsonArray) {
        List<IMGroup> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(buildIMGroup(jsonArray.getJSONObject(i)));
            }
        }
        return list;
    }

    public static IMAgentInfo buildIMAgentInfo(JSONObject jsonObject) {
        IMAgentInfo imAgentInfo = new IMAgentInfo();
        if (jsonObject != null) {
            imAgentInfo.setImAgents(buildIMAgentList(safeArray(jsonObject, KF5Fields.AGENTS)));
            imAgentInfo.setImGroups(buildIMGroupList(safeArray(jsonObject, KF5Fields.GROUPS)));
        }
        return imAgentInfo;
    }

    public static DocumentStats buildDocumentStats(JSONObject jsonObject) {
        DocumentStats stat = new DocumentStats();
        if (jsonObject != null) {
            DocumentStats.StatsValue statsValue = stat.new StatsValue();
            stat.setId(safeGet(jsonObject, KF5Fields.ID));
            stat.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
            JSONObject valueObj = safeObject(jsonObject, KF5Fields.VALUES);
            if (valueObj != null) {
                statsValue.setUpdatedTime(safeGet(valueObj, KF5Fields.UPDATEDTIME));
                statsValue.setCount_comment(safeGet(valueObj, KF5Fields.COUNT_COMMENT));
                statsValue.setCount_vote(safeInt(valueObj, KF5Fields.COUNT_VOTE));
                statsValue.setAuthor(safeGet(valueObj, KF5Fields.AUTHOR));
                statsValue.setForumTitle(safeGet(valueObj, KF5Fields.FORUMTITLE));
                statsValue.setCount_view(safeInt(valueObj, KF5Fields.COUNT_VIEW));
                statsValue.setCreatedTime(safeGet(valueObj, KF5Fields.CREATEDTIME));
            }
            stat.setStatsValue(statsValue);
        }
        return stat;
    }


    public static List<DocumentStats> buildDocumentStatsList(JSONArray jsonArray) {

        if (jsonArray == null || jsonArray.isEmpty()) {
            return Collections.emptyList();
        }
        List<DocumentStats> list = new ArrayList<>();
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            list.add(buildDocumentStats(jsonArray.getJSONObject(i)));
        }
        return list;
    }

    public static PostVote buildPostVote(JSONObject jsonObject) {
        PostVote postVote = new PostVote();
        if (jsonObject != null) {
            postVote.setPost_id(safeInt(jsonObject, KF5Fields.POST_ID));
            postVote.setUser_id(safeGet(jsonObject, KF5Fields.USER_ID));
            postVote.setUser_name(safeGet(jsonObject, KF5Fields.USER_NAME));
            postVote.setCreated_time(safeGet(jsonObject, KF5Fields.CREATED_AT));
            postVote.setId(safeInt(jsonObject, KF5Fields.ID));
        }
        return postVote;
    }

    public static List<PostVote> buildPostVoteList(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.isEmpty()) {
            return Collections.emptyList();
        }

        List<PostVote> list = new ArrayList<>();
        int size = jsonArray.size();

        for (int i = 0; i < size; i++) {
            list.add(buildPostVote(jsonArray.getJSONObject(i)));
        }

        return list;
    }
}
