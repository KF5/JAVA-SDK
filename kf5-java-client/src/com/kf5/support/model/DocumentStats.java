package com.kf5.support.model;

/**
 * 帮助中心统计实体
 */
public class DocumentStats {

    String id;
    String title;
    StatsValue statsValue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StatsValue getStatsValue() {
        return statsValue;
    }

    public void setStatsValue(StatsValue statsValue) {
        this.statsValue = statsValue;
    }

    @Override
    public String toString() {
        return "id=" + id
                + " & title=" + title
                + " & StatsValue=" + (statsValue != null ? statsValue.toString() : null);
    }

    public class StatsValue {

        String updatedTime;
        String count_comment;
        int count_vote;
        String author;
        String forumTitle;
        int count_view;
        String createdTime;

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }

        public String getCount_comment() {
            return count_comment;
        }

        public void setCount_comment(String count_comment) {
            this.count_comment = count_comment;
        }

        public int getCount_vote() {
            return count_vote;
        }

        public void setCount_vote(int count_vote) {
            this.count_vote = count_vote;
        }

        public String getForumTitle() {
            return forumTitle;
        }

        public void setForumTitle(String forumTitle) {
            this.forumTitle = forumTitle;
        }

        public int getCount_view() {
            return count_view;
        }

        public void setCount_view(int count_view) {
            this.count_view = count_view;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "updatedTime" + "=" + updatedTime +
                    " & count_comment" + "=" + count_comment +
                    " & count_vote" + "=" + count_vote +
                    " & author" + "=" + author +
                    " & forumTitle" + "=" + forumTitle +
                    " & count_view" + "=" + count_view +
                    " & createdTime" + "=" + createdTime;
        }
    }
}
