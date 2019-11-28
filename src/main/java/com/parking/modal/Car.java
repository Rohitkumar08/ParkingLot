/*
 * Copyright 2006-2019 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package com.parking.modal;

/**
 * Created 9/16/2019 11:50 AM
 *
 * @author Rohit Rawani
 */
public class Car {
  private String color;

  public Car(String color, String regNo) {
    this.color = color;
    this.regNo = regNo;
  }

  private String regNo;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegNo() {
    return regNo;
  }

  public void setRegNo(String regNo) {
    this.regNo = regNo;
  }

  @Override
  public String toString(){
    return "Color is :"+this.color+ " Reg no is :"+this.regNo;
  }


}
