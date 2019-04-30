/*
 *
 */
package com.rrm.api.beans;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The Class AdminDBO.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "externalID", "messageCode", "message", "blogTitle", "blogContent", "showComment",
		"tagList", "status", "siteID", "siteId", "author", "categoryList", "notificationTypeID", "publishDate",
"processtype" })
public class AdminDBO {

	/** The blog title. */
	private String blogTitle;

	/** The blog content. */
	private String blogContent;

	/** The show comment. */
	private Integer showComment;

	/** The tag list. */
	private ArrayList<String> tagList = new ArrayList<String>();

	/** The status. */
	private Integer status;

	/** The site ID. */
	private Integer siteID;

	/** The site id. */
	private String siteId;

	/** The author. */
	private String author;

	/** The category list. */
	private ArrayList<String> categoryList = new ArrayList<String>();

	/** The notification type ID. */
	private Integer notificationTypeID;

	/** The message. */
	private String message;

	/** The message code. */
	private Integer messageCode;

	/** The external ID. */
	private String externalID = "";

	/** The publish date. */
	private String publishDate;

	/** The processtype. */
	private String processtype = "normal";

	/** The enable. */
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	private String enable;

	/**
	 * Gets the processtype.
	 *
	 * @return the processtype
	 */
	public String getProcesstype() {
		return processtype;
	}

	/**
	 * Sets the processtype.
	 *
	 * @param processtype
	 *            the new processtype
	 */
	public void setProcesstype(String processtype) {
		this.processtype = processtype;
	}

	/**
	 * Gets the publish date.
	 *
	 * @return the publish date
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * Sets the publish date.
	 *
	 * @param publishDate
	 *            the new publish date
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * Gets the external ID.
	 *
	 * @return the external ID
	 */
	public String getExternalID() {
		return externalID;
	}

	/**
	 * Sets the external ID.
	 *
	 * @param externalID
	 *            the new external ID
	 */
	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	/**
	 * Gets the blog title.
	 *
	 * @return the blog title
	 */
	public String getBlogTitle() {
		return blogTitle;
	}

	/**
	 * Sets the blog title.
	 *
	 * @param blogTitle
	 *            the new blog title
	 */
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	/**
	 * Gets the blog content.
	 *
	 * @return the blog content
	 */
	public String getBlogContent() {
		return blogContent;
	}

	/**
	 * Sets the blog content.
	 *
	 * @param blogContent
	 *            the new blog content
	 */
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	/**
	 * Gets the show comment.
	 *
	 * @return the show comment
	 */
	public Integer getShowComment() {
		return showComment;
	}

	/**
	 * Sets the show comment.
	 *
	 * @param showComment
	 *            the new show comment
	 */
	public void setShowComment(Integer showComment) {
		this.showComment = showComment;
	}

	/**
	 * Gets the tag list.
	 *
	 * @return the tag list
	 */
	public ArrayList<String> getTagList() {
		return tagList;
	}

	/**
	 * Sets the tag list.
	 *
	 * @param tagList
	 *            the new tag list
	 */
	public void setTagList(ArrayList<String> tagList) {
		this.tagList = tagList;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the site ID.
	 *
	 * @return the site ID
	 */
	public Integer getSiteID() {
		return siteID;
	}

	/**
	 * Sets the site ID.
	 *
	 * @param siteID
	 *            the new site ID
	 */
	public void setSiteID(Integer siteID) {
		this.siteID = siteID;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the category list.
	 *
	 * @return the category list
	 */
	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	/**
	 * Sets the category list.
	 *
	 * @param categoryList
	 *            the new category list
	 */
	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	/**
	 * Gets the notification type ID.
	 *
	 * @return the notification type ID
	 */
	public Integer getNotificationTypeID() {
		return notificationTypeID;
	}

	/**
	 * Sets the notification type ID.
	 *
	 * @param notificationTypeID
	 *            the new notification type ID
	 */
	public void setNotificationTypeID(Integer notificationTypeID) {
		this.notificationTypeID = notificationTypeID;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the message code.
	 *
	 * @return the message code
	 */
	public Integer getMessageCode() {
		return messageCode;
	}

	/**
	 * Sets the message code.
	 *
	 * @param messageCode
	 *            the new message code
	 */
	public void setMessageCode(Integer messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * Gets the enable.
	 *
	 * @return the enable
	 */
	public String getEnable() {
		return enable;
	}

	/**
	 * Sets the enable.
	 *
	 * @param enable
	 *            the new enable
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}

	/**
	 * Gets the site id.
	 *
	 * @return the site id
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * Sets the site id.
	 *
	 * @param siteId
	 *            the new site id
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

}
