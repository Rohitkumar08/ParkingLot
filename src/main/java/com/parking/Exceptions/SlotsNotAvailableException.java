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
package com.parking.Exceptions;

/**
 * Created 9/16/2019 12:08 PM
 *
 * @author Rohit Rawani
 */
public class SlotsNotAvailableException  extends Exception{

  String message;

  public SlotsNotAvailableException() {

  }

  public SlotsNotAvailableException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
