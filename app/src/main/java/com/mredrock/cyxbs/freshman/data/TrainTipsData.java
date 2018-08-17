package com.mredrock.cyxbs.freshman.data;

import java.util.List;

public class TrainTipsData {
    private String index = "军训小贴士";

    private List<TipsBean> tips;

    public List<TipsBean> getTips() {
        return tips;
    }

    public void setTips(List<TipsBean> tips) {
        this.tips = tips;
    }

    public String getIndex() {
        return index;
    }

    public static class TipsBean {
        private int id;
        private String name;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}

