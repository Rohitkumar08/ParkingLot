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
package com.parking.api;

import com.parking.Exceptions.SlotsNotAvailableException;
import com.parking.modal.Car;
import com.parking.modal.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created 9/16/2019 11:58 AM
 *
 * @author Rohit Rawani
 */
public class ParkingAPIs {

  ParkingLot parkingLot = ParkingLot.getInstance();
  List<Integer> slots;
  List<Car> cars;

  public int parkACar(Car car, Map<Integer, Car> hmap) throws SlotsNotAvailableException{
    if(checkAvailability(hmap)){
      int slotNo = getSlotNumber(hmap);
      if(slotNo ==-1){
        throw new SlotsNotAvailableException("No slots Available");
      }
      cars = parkingLot.getListOfCars();
      cars.add(car);
      return slotNo;
    }
    return -1;
  }

  public boolean checkAvailability(Map<Integer, Car> hmap){
      if(hmap.size()<parkingLot.MAX_SIZE){
        return true;
      }else{
        for(Map.Entry entry: hmap.entrySet()){
          if(entry.getValue()==null){
            return true;
          }
        }
      }
    return false;
  }

  public int getSlotNumber(Map<Integer, Car> hmap){
    if(hmap.size()>0){
      for(Map.Entry entry: hmap.entrySet()){
        if(entry.getValue()==null){
          return (Integer)entry.getKey();
        }
      }
    }else{
      return 1;
    }
    return -1;
  }
  public int removeACar(int slotNo){
    if (slots != null && slots.size() == 0) {
      System.out.println("No cars available to remove");
      return -1;
    }
    parkingLot.getListOfCars().remove(slotNo - 1);
    System.out.println("Slot got free");
    return slotNo;
  }

  public List<Car> searchCars(String color){
    List<Car> carList= new ArrayList<Car>();
    if(color!=null && parkingLot.getListOfCars().size()>0){
        for(Car c: parkingLot.getListOfCars()){
          if(c==null){
            continue;
          }
          if(c.getColor().equalsIgnoreCase(color)){
            carList.add(c);
          }
        }
       /* carList = parkingLot.getListOfCars().stream().filter(c->c.getColor().equalsIgnoreCase(color)).collect(
            Collectors.toList());*/
    }
    return carList;
  }

}
