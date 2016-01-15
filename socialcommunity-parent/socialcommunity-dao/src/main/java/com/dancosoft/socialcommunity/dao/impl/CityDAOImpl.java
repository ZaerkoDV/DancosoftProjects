/**
 * @package com.dancosoft.socialcommunity.dao.impl
 * 
 * Package com.dancosoft.socialcommunity.dao.impl contain set of class which description
 * layer of data access object of SocialCommunity project. This project is based on MVC
 * architecture.This class is part of dao layer(DAL pattern) in MVC architecture. This
 * layer offer abstract interface for work with any type data base. This pattern give a
 * right work with DAO (data-access-object) without matter what kind of storage engine
 * is used and without need for a special way to match this storage engine. All classes
 * which contain word �DAO� provide to work DAL for Reducer links application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.dancosoft.socialcommunity.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.CityDAO;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;

/**
 * <p>
 * The class CityDAOImpl use DAO pattern which describes layer of data access to
 * object. DAO layer perform link between relational and object model.Model for
 * this dao layer describied in class City. This class contain methods which
 * intended to access to special operation with City entity. Class extend
 * CommonEntityDAOImpl, which contain base set of operation(CRUD).The
 * Class implements interface CityDAO located in package which have name
 * com.dancosoft.socialcommunity.dao. All methods are public in class. For
 * logging use logger fasade slf4j and framework log4j. Class contain also
 * private, static variable logger, which use to call log message. This class
 * use Spring framework to work whith ORM. In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work
 * with data base use hibernate criteria. This technology provide as
 * object-oriented select query in relation to a particular entity, and allows
 * you to query the database without writing SQL code. Use Criteria is the most
 * successful approach to search interface with a variable number of conditions.
 * To create copies of the Criteria used class Session, which acts as a factory.
 * 
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j fasade
 * @see log4j framework
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
@Repository(value = "cityDAO")
public class CityDAOImpl extends CommonEntityDAOImpl implements CityDAO {

	private static final Logger logger = LoggerFactory.getLogger(CityDAOImpl.class);

	public CityDAOImpl(){
		super(City.class);
	}
	
	/**
	 * Method return list city by id country. This country contain list of city
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return List<City>
	 */
	@SuppressWarnings("unchecked")
	public List<City> getListCityByIdCountry(Long idCountry) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("country.idCountry", idCountry));
		logger.info("CityDAO: List city load by id country.");

		return criteria.list();
	}

	/**
	 * Method return country by id city. If Country not contain city return null;
	 * 
	 * @type Long
	 * @param idCity
	 * 
	 * @return Country
	 */
	public Country getCountryByIdCity(Long idCity) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(City.class);
		criteria.setProjection(Projections.property("country"));
		criteria.add(Restrictions.eq("idCity", idCity));
		logger.info("CityDAO: Country load by id city");
	
		return (Country) criteria.uniqueResult();
	}

	/**
	 * Method return city by city name.If city with name not exist return null.
	 * 
	 * @type String
	 * @param cityName
	 * 
	 * @return List<City>
	 */
	@SuppressWarnings("unchecked")
	public List<City> searchCityByCityName(String cityName) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("cityName", cityName));
		logger.info("CityDAO: City load by city name.");

		return (List<City>)criteria.list();
	}
}
