package com.verobapps.myscheduler;

import java.util.Calendar;

import android.content.Context;

/**
 * Class to hold individual shift data
 */
public class ShiftCard {

	public ShiftCard(Context context) {
		addToCal = false;
		dateMillis = 0;
	}

	private String myLocation;
	private String myTime;
	private String myStringDate;
	private Calendar myDate;

	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;

	private String shiftLength;

	private String eventTitle;
	private String uniqueId;

	boolean addToCal;
	long dateMillis;

	public String getShiftLength() {
		return shiftLength;
	}

	public void setShiftLength(String shiftLength) {
		this.shiftLength = shiftLength;
	}

	public long getDateMillis() {
		return dateMillis;
	}

	public void setDateMillis(long dateMillis) {
		this.dateMillis = dateMillis;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public boolean isAddToCal() {
		return addToCal;
	}

	public void setAddToCal(boolean addToCal) {
		this.addToCal = addToCal;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}

	public Calendar getMyDate() {
		return myDate;
	}

	public void setMyDate(Calendar myDate) {
		this.myDate = myDate;
	}

	public String getMyLocation() {
		return myLocation;
	}

	public void setMyLocation(String myLocation) {
		this.myLocation = myLocation;
	}

	public String getMyTime() {
		return myTime;
	}

	public void setMyTime(String myTime) {
		this.myTime = myTime;
	}

	public String getMyStringDate() {
		return myStringDate;
	}

	public void setMyStringDate(String myStringDate) {
		this.myStringDate = myStringDate;
	}

}
