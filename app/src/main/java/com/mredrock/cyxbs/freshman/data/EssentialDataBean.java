package com.mredrock.cyxbs.freshman.data;

import java.util.List;

public class EssentialDataBean {
    /**
     * index : 入学必备
     * describe : [{"content":"学校通过EMS邮递","id":1,"name":"录取通知书","property":"必需"},{"content":"学生自行准备","id":2,"name":"高考准考证","property":"必需"},{"content":"学生自行准备","id":3,"name":"身份证","property":"必需"},{"content":"《新生适应性资料》在学校发的U盘中","id":4,"name":"《新生适应性资料》学习心得","property":"必需"},{"content":"光面相纸洗印，白底一寸，半身，正面，免冠大头照","id":5,"name":"同版近期证件照15张","property":"必需"},{"content":"入学指南中附带，请家长和学生认真阅读，并按要求签名，在入学报道时候交回给各学院","id":6,"name":"《学生管理与学生自律协议书》","property":"必需"},{"content":"入学指南中附带，请学生积极参加社会实践活动，并在入学报到时将社会实践报告交至各学院（如有图片，视频等资料请一并上交）","id":7,"name":"《致2018级新生的一封信》","property":"必需"},{"content":"《实践表》电子版由学院发至新生群，需打印成纸质表。\n暑假进行志愿服务、实习等社会实践活动，填好后需盖有实践单位的公章方能有效。\n","id":8,"name":"《重庆邮电大学社会实践表》","property":"必需"},{"content":"学生自行准备，内含团员证、入团申请书等专团组织关系资料","id":9,"name":"团档案","property":"必需"},{"content":"党员组织介绍信需由县级及县级以上的党委组织部门开具，使用新版的三联单介绍信\n重庆市外转入的，介绍信抬头写\u201c中共重庆市委教育工委组织干部处\u201d，去的单位写\u201c重庆邮电大学xx学院\u201d","id":10,"name":"转党组织关系资料","property":"非必需"},{"content":"凡明确了档案由学生自带的省市，该省新生必须自带档案入学报到（学生不得私自拆封档案），报到时至学生所在学院。\n需邮寄档案的请寄至所在学院办公室，具体地址如下:\n\u201c重庆市南岸区南山街道崇文路2号重庆邮电大学XXX学院学生工作办公室\u201d","id":11,"name":"学籍档案","property":"非必需"},{"content":"需办理户口迁移的重庆籍新生请携带该项到报道现场保卫处办理点办理\n户口迁入地址：重庆市南岸区南山街道崇文路2号附2号","id":12,"name":"本人户口本内页","property":"非必需"},{"content":"需办理户口迁移的重庆籍新生请携带该项到报道现场保卫处办理点办理（需在原户籍所在地派出所办理）\n户口迁入地址：重庆市南岸区南山街道崇文路2号附2号","id":13,"name":"《常住人口登记表》","property":"非必需"},{"content":"需办理户口迁移的非重庆籍新生，需要该项及近期免冠一寸照片一张贴在迁移证左上角到报道现场保卫处办理点办理\n户口迁入地址：重庆市南岸区南山街道崇文路2号附2号","id":14,"name":"本人户口迁移证","property":"非必需"},{"content":"","id":15,"name":"党员档案","property":"非必需"},{"content":"新生入学即可参加城乡低保，农村五保，享受国家助学金大学生以及重度（一，二级）残疾大学生等困难学生参保需提供其困难证明的原件及复印件。","id":16,"name":"困难证明的原件和复印件","property":"非必需"}]
     */

    private String index;
    private List<DescribeBean> describe;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<DescribeBean> getDescribe() {
        return describe;
    }

    public void setDescribe(List<DescribeBean> describe) {
        this.describe = describe;
    }

    public static class DescribeBean {
        /**
         * content : 学校通过EMS邮递
         * id : 1
         * name : 录取通知书
         * property : 必需
         */
        public static final int PARENT_ITEM = 0;//父布局
        public static final int CHILD_ITEM = 1;//子布局
        private String name;
        private String content;
        private int id;
        private String property = "非必需";
        private boolean isCustom = false;
        private boolean isGet = false;
        private boolean isSelect = false;
        private int type;// 显示类型
        private boolean isExpand;// 是否展开


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

        public boolean isProperty() {
            return this.property.equals("必需");
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isExpand() {
            return isExpand;
        }

        public void setExpand(boolean expand) {
            isExpand = expand;
        }

        public boolean isCustom() {
            return isCustom;
        }

        public void setCustom(boolean b) {
            this.isCustom = b;
        }

        public boolean isGet() {
            return isGet;
        }

        public void setGet(boolean get) {
            isGet = get;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }


}
