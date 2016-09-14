package com.neuwill.jiatianxia.entity;

import java.io.Serializable;

/**
 * 快捷图标实体类
 * 
 * @author zhangqiang
 *
 */
public class QuickViewEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quick_control_id;
	private String quick_control_name;
	private String quick_control_type;
	private int icon_size;
	private String icon_name;
	private String room_name;
	private String dev_name;
	private String dev_state;
	private Object other;
	/***/
	private int riu_id;

	public int getQuick_control_id() {
		return quick_control_id;
	}

	public void setQuick_control_id(int quick_control_id) {
		this.quick_control_id = quick_control_id;
	}

	public String getQuick_control_name() {
		return quick_control_name;
	}

	public void setQuick_control_name(String quick_control_name) {
		this.quick_control_name = quick_control_name;
	}

	public String getQuick_control_type() {
		return quick_control_type;
	}

	public void setQuick_control_type(String quick_control_type) {
		this.quick_control_type = quick_control_type;
	}

	public int getIcon_size() {
		return icon_size;
	}

	public void setIcon_size(int icon_size) {
		this.icon_size = icon_size;
	}

	public String getIcon_name() {
		return icon_name;
	}

	public void setIcon_name(String icon_name) {
		this.icon_name = icon_name;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getDev_name() {
		return dev_name;
	}

	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}

	public String getDev_state() {
		return dev_state;
	}

	public void setDev_state(String dev_state) {
		this.dev_state = dev_state;
	}

	/**
	 * 添加快捷图标
	 * 
	 * @param quick_control_name
	 * @param quick_control_id
	 * @param quick_control_type
	 * @param dev_name
	 * @param icon_name
	 * @param icon_size
	 * @param room_name
	 * @param dev_state
	 * @return
	 */
	public static QuickViewEntity inputQuickView(String quick_control_name, int quick_control_id,
			String quick_control_type, String dev_name, String icon_name, int icon_size, String room_name,
			String dev_state,int riu_id) {
		QuickViewEntity bean = new QuickViewEntity();
		bean = new QuickViewEntity();
		bean.setQuick_control_id(quick_control_id);
		bean.setQuick_control_name(quick_control_name);
		bean.setQuick_control_type(quick_control_type);
		bean.setDev_name(dev_name);
		bean.setIcon_name(icon_name);
		bean.setIcon_size(icon_size);
		bean.setRoom_name(room_name);
		bean.setDev_state(dev_state);
		return bean;
	}

	public static QuickViewEntity inputQuickView(String quick_control_name, int quick_control_id,
			String quick_control_type, String dev_name, String icon_name, int icon_size, String room_name,
			String dev_state, Object other) {
		QuickViewEntity bean = new QuickViewEntity();
		bean = new QuickViewEntity();
		bean.setQuick_control_id(quick_control_id);
		bean.setQuick_control_name(quick_control_name);
		bean.setQuick_control_type(quick_control_type);
		bean.setDev_name(dev_name);
		bean.setIcon_name(icon_name);
		bean.setIcon_size(icon_size);
		bean.setRoom_name(room_name);
		bean.setDev_state(dev_state);
		bean.setDev_state(dev_state);
		return bean;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

	public int getRiu_id() {
		return riu_id;
	}

	public void setRiu_id(int riu_id) {
		this.riu_id = riu_id;
	}

}
