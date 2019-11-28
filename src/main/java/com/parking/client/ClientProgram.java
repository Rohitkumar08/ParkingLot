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
package com.parking.client;

import com.parking.Exceptions.SlotsNotAvailableException;
import com.parking.api.ParkingAPIs;
import com.parking.modal.Car;
import com.parking.modal.ParkingLot;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created 9/16/2019 11:55 AM
 *
 * @author Rohit Rawani
 */
public class ClientProgram {
  static Map<Integer, Car> mapOfSlotAndCar;
  static{
    mapOfSlotAndCar = new LinkedHashMap<Integer, Car>();
    for(int i=1; i<=10; i++){
      mapOfSlotAndCar.put(i, null);
    }
  }

  public static void main(String[] args) {
    ParkingLot parkingLot = ParkingLot.getInstance();
    Scanner sc = new Scanner(System.in);
    System.out.println("Choose any option");
    ParkingAPIs apis = new ParkingAPIs();
    do{
      System.out.println("");
      System.out.println("1. Park a car");
      System.out.println("2. check availability");
      System.out.println("3. Remove a car");
      System.out.println("4. search a car");
      int choice = sc.nextInt();
      switch (choice){
      case 1:{
        System.out.println("Checking availability");
        if(!apis.checkAvailability(mapOfSlotAndCar)){
          System.out.println("No slots Available");
          break;
        }
        System.out.println("Enter car color");
        String color = sc.next();
        System.out.println("Enter registration number");
        String regNo = sc.next();
        Car car = new Car(color, regNo);
        int slotNo;
        try{
          slotNo =apis.parkACar(car, mapOfSlotAndCar);
        }catch(SlotsNotAvailableException ex){
          System.out.println("Sorry...!!Slots not available.");
          break;
        }
        mapOfSlotAndCar.put(slotNo, car);
        System.out.println("Cars parked successfully..");
        System.out.println("Slot no is :"+slotNo);
        break;
      }
      case 2:{
        if(!apis.checkAvailability(mapOfSlotAndCar)){
          System.out.println("No slot available");
        }else{
          System.out.println("Slots available");
        }
        break;
      }
      case 3:{
        System.out.println("Enter slot no");
        int slotno = sc.nextInt();
        apis.removeACar(slotno);
        mapOfSlotAndCar.put(slotno, null);
        break;
      }
      case 4: {
        System.out.println("Enter color of car");
        String color = sc.next();
        List<Car> cars = apis.searchCars(color);
        if(cars.size()>0){
          for(Car c: cars)
            System.out.println(c.toString());
        }else{
          System.out.println("No macthing cars found");
        }
        break;
      }
      }
    }while(true);

  }

}
