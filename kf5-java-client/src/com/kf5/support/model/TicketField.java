package com.kf5.support.model;

/**
 * 如果自定义字段的{@link #type}是multi_options，则{@link KF5Fields#CUSTOM_FIELD_OPTIONS}字段对应的数据模型是json对象,范型的对象是{@link MultiCustomFieldOption};
 * 否则就是json数组,则范型的对象为{@link java.util.List<CustomFieldOption>}。
 *
 * @param <T>
 */
public class TicketField<T> {

    private T customFieldOptions;

    public void setCustomFieldOptions(T customFieldOptions) {
        this.customFieldOptions = customFieldOptions;
    }

    public T getCustomFieldOptions() {
        return customFieldOptions;
    }

    private int id; //工单字段id，由系统自动分配

    private String url; //当前资源url

    private String name; //工单字段的名称，格式为"field_{id}"

    private String type; //字段类型

    private String agent_title; //字段对客服的显示名称

    private boolean agent_required; //客服在处理工单时是否必填

    private boolean enduser_visible; //普通用户提交工单时能否看到字段

    private String enduser_title; //字段对普通用户的显示名称

    private boolean enduser_editable;  //普通用户是否能编辑此字段

    private String enduser_description; //对普通用户显示的字段说明

    private boolean enduser_required; //客服在提交工单时是否必填

    private boolean active; //字段是否启用

    private String regexp_for_validation; //正则匹配字段的表达式

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgent_title() {
        return agent_title;
    }

    public void setAgent_title(String agent_title) {
        this.agent_title = agent_title;
    }

    public boolean isAgent_required() {
        return agent_required;
    }

    public void setAgent_required(boolean agent_required) {
        this.agent_required = agent_required;
    }

    public boolean isEnduser_visible() {
        return enduser_visible;
    }

    public void setEnduser_visible(boolean enduser_visible) {
        this.enduser_visible = enduser_visible;
    }

    public String getEnduser_title() {
        return enduser_title;
    }

    public void setEnduser_title(String enduser_title) {
        this.enduser_title = enduser_title;
    }

    public boolean isEnduser_editable() {
        return enduser_editable;
    }

    public void setEnduser_editable(boolean enduser_editable) {
        this.enduser_editable = enduser_editable;
    }

    public String getEnduser_description() {
        return enduser_description;
    }

    public void setEnduser_description(String enduser_description) {
        this.enduser_description = enduser_description;
    }

    public boolean isEnduser_required() {
        return enduser_required;
    }

    public void setEnduser_required(boolean enduser_required) {
        this.enduser_required = enduser_required;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRegexp_for_validation() {
        return regexp_for_validation;
    }

    public void setRegexp_for_validation(String regexp_for_validation) {
        this.regexp_for_validation = regexp_for_validation;
    }

}
