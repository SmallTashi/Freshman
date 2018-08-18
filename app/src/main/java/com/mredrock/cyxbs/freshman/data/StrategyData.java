package com.mredrock.cyxbs.freshman.data;

import java.util.List;

public class StrategyData {

    /**
     * array : [{"content":"老校门出门右转，绝味鸭脖旁边","id":1,"name":"中国邮政储蓄银行(黄桷垭支行)","picture":["/picture/42db35024a694c34a00202ab2a458746.jpg"],"property":""},{"content":"新校门出门右转，新世纪超市旁边","id":2,"name":"农业银行","picture":["/picture/434e51d2ff8840a38b13ec0f03c229db.jpg"],"property":""},{"content":"老校门出门，过马路，右转。","id":3,"name":"重庆农村商业银行","picture":["/picture/39dbb66648844e148046c9285b65dd9a.jpg"],"property":""},{"content":"新校门出门，左转直走，老校门出门，右转直走。","id":4,"name":"中国工商银行自助服务点","picture":["/picture/1e61faa0fc544a0f9597edca5554820f.jpg"],"property":""}]
     * index : 附近银行
     */

    private String index;
    private List<ArrayBean> array;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<ArrayBean> getArray() {
        return array;
    }

    public void setArray(List<ArrayBean> array) {
        this.array = array;
    }

    public static class ArrayBean {
        /**
         * content : 老校门出门右转，绝味鸭脖旁边
         * id : 1
         * name : 中国邮政储蓄银行(黄桷垭支行)
         * picture : ["/picture/42db35024a694c34a00202ab2a458746.jpg"]
         * property :
         */

        private String content;
        private int id;
        private String name;
        private String property;
        private List<String> picture;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

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

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public List<String> getPicture() {
            return picture;
        }

        public void setPicture(List<String> picture) {
            this.picture = picture;
        }
    }
}
