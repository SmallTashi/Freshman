package com.mredrock.cyxbs.freshman.data;

public class EssentialDataBean {
    public static final int PARENT_ITEM = 0;//父布局
    public static final int CHILD_ITEM = 1;//子布局
    private String name;
    private String content;
    private boolean isCustom = false;
    private boolean isGet = false;
    private boolean isSelect = false;
    private boolean isProprity = true;
    private int type;// 显示类型
    private boolean isExpand;// 是否展开

    public EssentialDataBean() {
    }

    public EssentialDataBean(String s, boolean f, boolean e) {
        setName(s);
        setCustom(f);
        setGet(e);
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

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
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

    public boolean isProprity() {
        return isProprity;
    }

    public void setProprity(boolean proprity) {
        isProprity = proprity;
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
}
