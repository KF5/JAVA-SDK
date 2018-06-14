package com.kf5.support.model;

public class PostVote {

    private int post_id;
    private String user_id;
    private String user_name;
    private String created_time;
    private int id;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "post_id=" + post_id +
                " & user_id=" + user_id +
                " & user_name=" + user_name +
                " & created_time=" + created_time +
                " & id=" + id;
    }
}
