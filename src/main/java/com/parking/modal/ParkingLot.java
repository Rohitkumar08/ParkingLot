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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created 9/16/2019 11:49 AM
 *
 * @author Rohit Rawani
 */
public class ParkingLot {
  public static final int MAX_SIZE=10;
   static volatile ParkingLot instance;

  private ParkingLot(){
    listOfCars = new ArrayList<Car>();
    slots = new ArrayList<Integer>();
  }
  public static ParkingLot getInstance(){
    if(instance == null){
      synchronized (ParkingLot.class){
        if(instance == null){
          instance = new ParkingLot();
        }
      }
    }
    return instance;
  }
  public List<Car> getListOfCars() {
    return listOfCars;
  }

  public void setListOfCars(List<Car> listOfCars) {
    this.listOfCars = listOfCars;
  }

  public List<Integer> getSlots() {
    return slots;
  }

  public void setSlots(List<Integer> slots) {
    this.slots = slots;
  }

  private List<Car> listOfCars;
  private List<Integer> slots;


}
