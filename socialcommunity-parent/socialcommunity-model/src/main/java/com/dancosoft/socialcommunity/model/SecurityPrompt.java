/**
 * @package com.dancosoft.socialcommunity.model
 * 
 * The package com.dancosoft.socialcommunity.model contain set of class which description
 * basic essence in SocialCommunity  project.The project is based on MVC architecture.
 * This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.dancosoft.socialcommunity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * SecurityPrompt entity describe special characteristics and behavior of
 * UserSecurity enity.This class contain information about user security login
 * and password such as user prompt and answer. User mast have prompt and
 * answer. Class UserPrompt have relations (or forigen key which refer on this
 * class): one-to-one with UserSecurity. Allcommunication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * SecurityPrompt entity. Class implements interface Serializable. For creating
 * UserPrompt model use Hibernate technology (anatations). Class contains
 * exclusively no-static public methods that return fields of entity. Methods
 * intended to access object fields.Class also contain overload methodstoString(),
 * hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "SecurityPrompt")
@Table(name = "security_prompt")
public class SecurityPrompt implements Serializable {

	private static final long serialVersionUID = 9086407555584795231L;

	/**
	 * Unique identification number of SecurityPrompt for entity SecurityPrompt.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_security_prompt")
	private Long idSecurityPrompt;

	/**
	 * SecurityPrompt which use for autorization user in system
	 * if user forget password. Prompt may have role question which
	 * have same unique answer.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "security_prompt")
	private String securityPrompt;

	/**
	 * SecurityPrompt which use for autorization user in system
	 * if user forget password. Answer on security prompt.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "user_answer")
	private String userAnswer;

	/**
	 * UserSecurity which have security prompt and answer.
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_security_id")
	private UserSecurity userSecurity;

	/**
	 * Empty constructor(default) of SecurityPrompt class.
	 */
	public SecurityPrompt() {
	}

	/**
	 * Overloaded constructor of SecurityPrompt class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idSecurityPrompt
	 * @param securityPrompt
	 * @param userAnswer
	 * @param userSecurity
	 */
	public SecurityPrompt(Long idSecurityPrompt, String securityPrompt,
			String userAnswer, UserSecurity userSecurity) {
		this.idSecurityPrompt = idSecurityPrompt;
		this.securityPrompt = securityPrompt;
		this.userAnswer = userAnswer;
		this.userSecurity = userSecurity;
	}

	/**
	 * @return the idSecurityPrompt
	 */
	public Long getIdSecurityPrompt() {
		return idSecurityPrompt;
	}

	/**
	 * @param idSecurityPrompt
	 *            the idSecurityPrompt to set
	 */
	public void setIdSecurityPrompt(Long idSecurityPrompt) {
		this.idSecurityPrompt = idSecurityPrompt;
	}

	/**
	 * @return the securityPrompt
	 */
	public String getSecurityPrompt() {
		return securityPrompt;
	}

	/**
	 * @param securityPrompt
	 *            the securityPrompt to set
	 */
	public void setSecurityPrompt(String securityPrompt) {
		this.securityPrompt = securityPrompt;
	}

	/**
	 * @return the userAnswer
	 */
	public String getUserAnswer() {
		return userAnswer;
	}

	/**
	 * @param userAnswer
	 *            the userAnswer to set
	 */
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	/**
	 * @return the userSecurity
	 */
	public UserSecurity getUserSecurity() {
		return userSecurity;
	}

	/**
	 * @param userSecurity
	 *            the userSecurity to set
	 */
	public void setUserSecurity(UserSecurity userSecurity) {
		this.userSecurity = userSecurity;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return SecurityPrompt entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idSecurityPrompt.equals(null)) {
			return this.idSecurityPrompt.toString() + " "
					+ this.securityPrompt.toString() + " "
					+ this.userAnswer.toString() + " "
					+ this.userSecurity.toString();
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
		result = prime
				* result
				+ ((idSecurityPrompt == null) ? 0 : idSecurityPrompt.hashCode());
		result = prime * result
				+ ((securityPrompt == null) ? 0 : securityPrompt.hashCode());
		result = prime * result
				+ ((userAnswer == null) ? 0 : userAnswer.hashCode());
		result = prime * result
				+ ((userSecurity == null) ? 0 : userSecurity.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to SecurityPrompt or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SecurityPrompt))
			return false;
		SecurityPrompt other = (SecurityPrompt) obj;
		if (idSecurityPrompt == null) {
			if (other.idSecurityPrompt != null)
				return false;
		} else if (!idSecurityPrompt.equals(other.idSecurityPrompt))
			return false;
		if (securityPrompt == null) {
			if (other.securityPrompt != null)
				return false;
		} else if (!securityPrompt.equals(other.securityPrompt))
			return false;
		if (userAnswer == null) {
			if (other.userAnswer != null)
				return false;
		} else if (!userAnswer.equals(other.userAnswer))
			return false;
		if (userSecurity == null) {
			if (other.userSecurity != null)
				return false;
		} else if (!userSecurity.equals(other.userSecurity))
			return false;
		return true;
	}

}
