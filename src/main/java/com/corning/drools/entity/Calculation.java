package com.corning.drools.entity;


public class Calculation {

    /**
     * 税前工资
     */
    private double wage;

    /**
     * 应纳税所得额
     */
    private double wagemore;

    /**
     * 税率
     */
    private double cess;

    /**
     * 速算扣除数
     */
    private double preminus;

    /**
     * 扣税额
     */
    private double wageminus;

    /**
     * 税后工资
     */
    private double actualwage;


    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getActualwage() {
        return actualwage;
    }

    public void setActualwage(double actualwage) {
        this.actualwage = actualwage;
    }

    public double getWagemore() {
        return wagemore;
    }

    public void setWagemore(double wagemore) {
        this.wagemore = wagemore;
    }

    public double getCess() {
        return cess;
    }

    public void setCess(double cess) {
        this.cess = cess;
    }

    public double getPreminus() {
        return preminus;
    }

    public void setPreminus(double preminus) {
        this.preminus = preminus;
    }

    public double getWageminus() {
        return wageminus;
    }

    public void setWageminus(double wageminus) {
        this.wageminus = wageminus;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "wage=" + wage +
                ", actualwage=" + actualwage +
                ", wagemore=" + wagemore +
                ", cess=" + cess +
                ", preminus=" + preminus +
                ", wageminus=" + wageminus +
                '}';
    }
}
