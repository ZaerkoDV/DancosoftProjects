/**
 * @package com.dancosoft.socialcommunity.model
 * 
 * The package com.dancosoft.socialcommunity.model contain set of class which description
 * basic essence in SocialCommunity project.The project is based on MVC architecture.
 * This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.dancosoft.socialcommunity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

/**
 * Forum entity describe forum entity. This class contain information about
 * forum such as forum name name, date create forum. Class Forum have relations
 * (or forigen key which refer on this class): one-to-meny with AccountForum
 * (system class), one-to-meny with ForumToppic All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description Forum
 * entity. Class implements interface Serializable. For creating Forum model use
 * Hibernate technology (anatations). Class contains exclusively no-static
 * public methods that return fields of entity. Methods intended to access
 * object fields.Class also contain overload methods toString(), hashCode(),
 * equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "Forum")
@Table(name = "forum")
public class Forum implements Serializable {

	private static final long serialVersionUID = -7802222603320157998L;

	/**
	 * Unique identification number of connection between account and forum
	 * entity.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forum")
	private Long idForum;

	/**
	 * Date when forum create.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_create_forum")
	private Date dateCreateForum;

	/**
	 * Name of forum
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "forum_name")
	private String forumName;
	
	@NotNull
	@Column(name = "view_status")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(45)
	@ColumnDefault("public")					 //default 'public'"
	private String viewStatus;

	/**
	 * Empty constructor(default) of Forum class.
	 */
	public Forum() {
	}
	
	/**
	 * Overloaded constructor of account class.
	 * 
	 * @type Long
	 * @type Date
	 * @type String
	 * 
	 * @param idForum
	 * @param dateCreateForum
	 * @param forumName
	 */
	public Forum(Long idForum, Date dateCreateForum, String forumName, String viewStatus) {
		this.idForum = idForum;
		this.dateCreateForum = dateCreateForum;
		this.forumName = forumName;
		this.viewStatus=viewStatus;
	}

	/**
	 * @return the idForum
	 */
	public Long getIdForum() {
		return idForum;
	}

	/**
	 * @param idForum
	 *            the idForum to set
	 */
	public void setIdForum(Long idForum) {
		this.idForum = idForum;
	}

	/**
	 * @return the dateCreateForum
	 */
	public Date getDateCreateForum() {
		return dateCreateForum;
	}

	/**
	 * @param dateCreateForum
	 *            the dateCreateForum to set
	 */
	public void setDateCreateForum(Date dateCreateForum) {
		this.dateCreateForum = dateCreateForum;
	}

//	public LocalDateTime getDateCreateForum() {
//		Instant instant = Instant.ofEpochMilli(dateCreateForum.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setDateCreateForum(LocalDateTime dateCreateForum) {
//		Instant instant = dateCreateForum.toInstant(ZoneOffset.UTC);		
//		this.dateCreateForum = Date.from(instant);
//	}
	
	/**
	 * @return the forumName
	 */
	public String getForumName() {
		return forumName;
	}

	/**
	 * @param forumName
	 *            the forumName to set
	 */
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	/**
	 * @return the viewStatus
	 */
	public String getViewStatus() {
		return viewStatus;
	}

	/**
	 * @param viewStatus the viewStatus to set
	 */
	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Forum entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idForum.equals(null)) {
			return this.idForum.toString() + " "
					+ this.dateCreateForum.toString() + " "
					+ this.forumName.toString()+" "
					+ this.viewStatus.toString();
		}
		return super.toString();
	}
	
	/**
	 * Overload basic method hashCode()
	 * 
	 * @type Integer
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateCreateForum == null) ? 0 : dateCreateForum.hashCode());
		result = prime * result
				+ ((forumName == null) ? 0 : forumName.hashCode());
		result = prime * result + ((idForum == null) ? 0 : idForum.hashCode());
		result = prime * result
				+ ((viewStatus == null) ? 0 : viewStatus.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to Forum or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Forum))
			return false;
		Forum other = (Forum) obj;
		if (dateCreateForum == null) {
			if (other.dateCreateForum != null)
				return false;
		} else if (!dateCreateForum.equals(other.dateCreateForum))
			return false;
		if (forumName == null) {
			if (other.forumName != null)
				return false;
		} else if (!forumName.equals(other.forumName))
			return false;
		if (idForum == null) {
			if (other.idForum != null)
				return false;
		} else if (!idForum.equals(other.idForum))
			return false;
		if (viewStatus == null) {
			if (other.viewStatus != null)
				return false;
		} else if (!viewStatus.equals(other.viewStatus))
			return false;
		return true;
	}

}
