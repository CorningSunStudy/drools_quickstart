package com.corning.drools.entity;


/**
 * 信用卡申请信息
 */
public class CreditCardApplyInfo {

    public static final String EDUCATION_1 = "专科以下";
    public static final String EDUCATION_2 = "专科";
    public static final String EDUCATION_3 = "本科";
    public static final String EDUCATION_4 = "本科以上";

    private String name;
    private String sex;
    private int age;
    private String education;
    private String telephone;

    //月收入
    private double monthlyIncome = 0;

    private String address;

    //是否有房
    private boolean hasHouse = false;

    //是否有车
    private boolean hasCar = false;

    //现持有信用卡数量
    private int hasCreditCardCount = 0;

    //审核是否通过
    private boolean checkResult = true;

    //额度
    private double quota = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHasHouse() {
        return hasHouse;
    }

    public void setHasHouse(boolean hasHouse) {
        this.hasHouse = hasHouse;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public int getHasCreditCardCount() {
        return hasCreditCardCount;
    }

    public void setHasCreditCardCount(int hasCreditCardCount) {
        this.hasCreditCardCount = hasCreditCardCount;
    }

    public boolean isCheckResult() {
        return checkResult;
    }

    public void setCheckResult(boolean checkResult) {
        this.checkResult = checkResult;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        if (checkResult) {
            return "审核通过，信用卡额度为：" + quota;
        } else {
            return "审核不通过";
        }
    }
}
