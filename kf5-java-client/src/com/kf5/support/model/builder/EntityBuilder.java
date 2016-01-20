package com.kf5.support.model.builder;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kf5.support.model.Agent;
import com.kf5.support.model.Attachment;
import com.kf5.support.model.Category;
import com.kf5.support.model.Comment;
import com.kf5.support.model.CustomField;
import com.kf5.support.model.CustomFieldOption;
import com.kf5.support.model.Forum;
import com.kf5.support.model.Group;
import com.kf5.support.model.KF5Fields;
import com.kf5.support.model.Organization;
import com.kf5.support.model.OrganizationField;
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
import com.kf5.support.model.UserFiled;
import com.kf5.support.model.View;
import com.kf5.support.model.ViewCount;


public class EntityBuilder extends KF5EntityBuilder{


	public static Ticket buildTicket(JSONObject jsonObject){

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

	public static CustomField buildCustomField(JSONObject jsonObject){
		CustomField customField = new CustomField();
		customField.setKey(safeGet(jsonObject, KF5Fields.NAME));
		customField.setValue(safeGet(jsonObject, KF5Fields.VALUE));
		return customField;
	}


	public static List<Ticket> buildTicketList(JSONArray jsonArray){

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


	public static User buildUser(JSONObject jsonObject){

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
		return user;
	}


	public static UserFiled buildUserFiled(JSONObject jsonObject){
		UserFiled userFiled = new UserFiled();
		userFiled.setKey(safeGet(jsonObject, KF5Fields.NAME));
		userFiled.setValue(safeGet(jsonObject, KF5Fields.VALUE));
		return userFiled;
	}


	public static List<User> buildUsers(JSONArray jsonArray){

		List<User> users = new ArrayList<>();
		if (jsonArray != null ) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				users.add(buildUser(itemObject));
			}
		}
		return users;

	}


	public static Requester buildRequester(JSONObject jsonObject){
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
		if (jsonArray != null ) {
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

	public static List<Requester> buildRequesters(JSONArray jsonArray){

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


	public static Comment buildComment(JSONObject jsonObject){

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

	public static List<Comment> buildComments(JSONArray jsonArray){

		List<Comment> comments = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemJsonObject = jsonArray.getJSONObject(i);
				comments.add(buildComment(itemJsonObject));
			}
		}
		return comments;
	}


	public static TicketField buildTicketField(JSONObject jsonObject){

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
		if (optionArray != null ) {
			int size = optionArray.size();
			List<CustomFieldOption> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = optionArray.getJSONObject(i);
				list.add(buildCustomFieldOption(itemObject));
			}
			ticketField.setCustomFieldOptions(list);
		}
		return ticketField;
	}


	public static CustomFieldOption buildCustomFieldOption(JSONObject jsonObject){

		CustomFieldOption customFieldOption = new CustomFieldOption();
		customFieldOption.setKey(safeGet(jsonObject, KF5Fields.KEY));
		customFieldOption.setValue(safeGet(jsonObject, KF5Fields.VALUE));
		return customFieldOption;
	}


	public static List<TicketField> buildTicketFields(JSONArray jsonArray){

		List<TicketField> list = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				list.add(buildTicketField(itemObject));
			}
		}
		return list;
	}

	public static View buildView(JSONObject jsonObject){

		View view = new View();
		view.setId(safeInt(jsonObject, KF5Fields.ID));
		view.setUrl(safeGet(jsonObject, KF5Fields.URL));
		view.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
		view.setActive(safeBoolean(jsonObject, KF5Fields.ACTIVE));
		view.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
		view.setSlas_id(safeInt(jsonObject, KF5Fields.SLAS_ID));

		return view;
	}

	public static List<View> buildViews(JSONArray jsonArray){
		List<View> views = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				views.add(buildView(itemObject));
			}
		}
		return views;
	}


	public static ViewCount buildViewCount(JSONObject jsonObject){

		ViewCount viewCount = new ViewCount();
		viewCount.setCount(safeInt(jsonObject, KF5Fields.COUNT));
		viewCount.setUrl(safeGet(jsonObject, KF5Fields.URL));
		viewCount.setView_id(safeInt(jsonObject, KF5Fields.VIEW_ID));
		return viewCount;
	}

	public static List<ViewCount> buildViewCounts(JSONArray jsonArray){

		List<ViewCount> viewCounts = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				viewCounts.add(buildViewCount(jsonObject));
			}
		}
		return viewCounts;
	}

	public static UserField buildUserField(JSONObject jsonObject){

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

	public static List<UserField> buildUserFields(JSONArray jsonArray){

		List<UserField> list = new ArrayList<UserField>();
		if (jsonArray != null ) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				list.add(buildUserField(itemObject));
			}
		}
		return list;
	}


	public static Agent buildAgent(JSONObject jsonObject){
		Agent agent = new Agent();
		agent.setId(safeInt(jsonObject, KF5Fields.ID));
		agent.setUrl(safeGet(jsonObject, KF5Fields.URL));
		agent.setName(safeGet(jsonObject, KF5Fields.NAME));
		agent.setUsername(safeGet(jsonObject, KF5Fields.USERNAME));
		return agent;
	}

	public static List<Agent> buildAgents(JSONArray jsonArray){

		List<Agent> list = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				list.add(buildAgent(itemObject));
			}
		}
		return list;
	}

	public static Group buildGroup(JSONObject jsonObject){

		Group group = new Group();
		group.setId(safeInt(jsonObject, KF5Fields.ID));
		group.setUrl(safeGet(jsonObject, KF5Fields.URL));
		group.setName(safeGet(jsonObject, KF5Fields.NAME));
		group.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
		JSONArray jsonArray = safeArray(jsonObject, KF5Fields.AGENTS);
		group.setListAgents(buildAgents(jsonArray));
		return group;
	}

	public static List<Group> buildGroups(JSONArray jsonArray){

		List<Group> list = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				list.add(buildGroup(itemObject));
			}
		}
		return list;
	}

	public static Category buildCategory(JSONObject jsonObject){
		Category category = new Category();
		category.setId(safeInt(jsonObject, KF5Fields.ID));
		category.setUrl(safeGet(jsonObject, KF5Fields.URL));
		category.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
		category.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
		category.setDisplay_limit(safeInt(jsonObject, KF5Fields.DISPLAY_LIMIT));
		category.setSort(safeInt(jsonObject, KF5Fields.SORT));
		return category;
	}

	public static List<Category> buildCategories(JSONArray jsonArray){

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


	public static Forum buildForum(JSONObject jsonObject){

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

	public static List<Forum> buildForums(JSONArray jsonArray){

		List<Forum> list = new ArrayList<>();

		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				list.add(buildForum(object));
			}
		}
		return list;
	}


	public static Attachment buildAttachment(JSONObject jsonObject){
		Attachment attachment = new Attachment();
		attachment.setId(safeInt(jsonObject, KF5Fields.ID));
		attachment.setUrl(safeGet(jsonObject, KF5Fields.URL));
		attachment.setName(safeGet(jsonObject, KF5Fields.NAME));
		attachment.setSize(safeInt(jsonObject, KF5Fields.SIZE));
		attachment.setContent_url(safeGet(jsonObject, KF5Fields.CONTENT_URL));
		attachment.setToken(safeGet(jsonObject, KF5Fields.TOKEN));
		return attachment;
	}

	public static List<Attachment> buildAttachments(JSONArray jsonArray){

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


	public static Post buildPost(JSONObject jsonObject){

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

	public static List<Post> buildPosts(JSONArray jsonArray){

		List<Post> list = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				list.add(buildPost(object));
			}
		}
		return list;

	}

	public static PostComment buildPostComment(JSONObject jsonObject){

		PostComment comment = new PostComment();
		comment.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
		comment.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
		comment.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
		comment.setId(safeInt(jsonObject, KF5Fields.ID));
		comment.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));
		return comment;

	}

	public static List<PostComment> buildPostComments(JSONArray jsonArray){

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


	public static Organization buildOrganization(JSONObject jsonObject){

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

		return organization ;
	}


	public static List<Organization> buildOrganizations(JSONArray jsonArray){

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



	public static OrganizationField buildOrganizationField(JSONObject jsonObject){

		OrganizationField field = new OrganizationField();
		field.setKey(safeGet(jsonObject, KF5Fields.NAME));
		field.setValue(safeGet(jsonObject, KF5Fields.VALUE));

		return field;
	}


	public static Topic buildTopic(JSONObject jsonObject){
		Topic topic = new Topic();
		topic.setId(safeInt(jsonObject, KF5Fields.ID));
		topic.setUrl(safeGet(jsonObject, KF5Fields.URL));
		topic.setTitle(safeGet(jsonObject, KF5Fields.TITLE));
		topic.setDecription(safeGet(jsonObject, KF5Fields.DESCRIPTION));
		topic.setSort(safeInt(jsonObject, KF5Fields.SORT));
		topic.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));

		return topic;
	}


	public static List<Topic> buildTopics(JSONArray jsonArray){

		List<Topic> list = new ArrayList<>();
		if (jsonArray != null) {
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject itemObject = jsonArray.getJSONObject(i);
				list.add(buildTopic(itemObject));
			}
		}
		return  list;
	}


	public static Question buildQuestion(JSONObject jsonObject){

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


	public static List<Question> buildQuestions(JSONArray jsonArray){
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

	public static QuestionComment buildQuestionComment(JSONObject jsonObject){

		QuestionComment questionComment = new QuestionComment();
		questionComment.setId(safeInt(jsonObject, KF5Fields.ID));
		questionComment.setContent(safeGet(jsonObject, KF5Fields.CONTENT));
		questionComment.setAuthor_id(safeInt(jsonObject, KF5Fields.AUTHOR_ID));
		questionComment.setCreated_at(safeGet(jsonObject, KF5Fields.CREATED_AT));
		questionComment.setUpdated_at(safeGet(jsonObject, KF5Fields.UPDATED_AT));
		return questionComment;
	}

	public static List<QuestionComment> buildQuestionComments(JSONArray jsonArray){

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


}
