package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class MultiCustomFieldOption {

    private String jsonArrayTitles;

    private List<MultiItem> list = new ArrayList<>();

    public String getJsonArrayTitles() {
        return jsonArrayTitles;
    }

    public void setJsonArrayTitles(String jsonArrayTitles) {
        this.jsonArrayTitles = jsonArrayTitles;
    }

    public List<MultiItem> getList() {
        return list;
    }

    public void setList(List<MultiItem> list) {
        this.list = list;
    }

    public static class MultiItem {

        private int parent;
        private int level;
        private int id;
        private String key;


        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
