package com.mredrock.cyxbs.freshman.data;

import java.util.List;

public class StrategyData {

    public static class Main {
        /**
         * amount : 6
         * name : ["第二教学楼","春华秋实广场","情人坡","数字图书馆","第八教学楼","雨红莲"]
         * index : 校园环境
         */

        private int amount;
        private String index;
        private List<String> name;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public List<String> getName() {
            return name;
        }

        public void setName(List<String> name) {
            this.name = name;
        }
    }


    public static class Data {
        /**
         * content : 软件工程学院和计算机科学与技术学院所在楼栋。作为上课频率最高的几所楼栋之一的二教，凭着静谧的学习环境和方便的地理位置成为了同学们日常自习的好去处。内含阶梯教室的二教，通常还是各类企业招聘会和宣讲会的不二选址，大部分的学院也会选择这里进行年级集中。
         * id : 1
         * name : 第二教学楼
         * picture : ["/picture/6d49fcb5e3cd40079b87c4898ff674c2.png"]
         */

        private String content;
        private int id;
        private String name;
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

        public List<String> getPicture() {
            return picture;
        }

        public void setPicture(List<String> picture) {
            this.picture = picture;
        }
    }

}
