package com.zust.itee.form;

import java.util.List;

/**
 * 登记表单
 *
 * @author fuenhui
 * @date 2019/7/18
 */
public class RegForm {

    /**
     * 小区名称
     */
    private String address;

    /**
     * 门牌号码
     */
    private String doorNum;

    /**
     * 房屋面积
     */
    private Float area;

    /**
     * 价格
     * 若为售卖，则以万为单位
     * 若为出租，则以元/月为单位
     */
    private Float price;

    /**
     * 户型：几室
     */
    private Integer allRoom;

    /**
     * 户型：几厅
     */
    private Integer drawingRoom;

    /**
     * 户型：几卫
     */
    private Integer toilet;

    /**
     * 所在楼层
     */
    private Integer floors;

    /**
     * 总楼层
     */
    private Integer allFloors;

    /**
     * 装修类型
     * 1：精装
     * 2：简装
     * 3：毛坯
     */
    private Short decType;

    /**
     * 房源图片哈希
     */
    private List<String> imageHashs;

    /**
     * 联系人名字
     */
    private String linkman;

    /**
     * 联系人手机号码
     */
    private String phone;

    /**
     * 备注
     */
    private String remark;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAllRoom() {
        return allRoom;
    }

    public void setAllRoom(Integer allRoom) {
        this.allRoom = allRoom;
    }

    public Integer getDrawingRoom() {
        return drawingRoom;
    }

    public void setDrawingRoom(Integer drawingRoom) {
        this.drawingRoom = drawingRoom;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getAllFloors() {
        return allFloors;
    }

    public void setAllFloors(Integer allFloors) {
        this.allFloors = allFloors;
    }

    public Short getDecType() {
        return decType;
    }

    public void setDecType(Short decType) {
        this.decType = decType;
    }

    public List<String> getImageHashs() {
        return imageHashs;
    }

    public void setImageHashs(List<String> imageHashs) {
        this.imageHashs = imageHashs;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
