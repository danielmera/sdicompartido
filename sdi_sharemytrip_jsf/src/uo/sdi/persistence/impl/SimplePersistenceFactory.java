package uo.sdi.persistence.impl;

import uo.sdi.persistence.ApplicationDao;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.RatingDao;
import uo.sdi.persistence.SeatDao;
import uo.sdi.persistence.Transaction;
import uo.sdi.persistence.TripDao;
import uo.sdi.persistence.UserDao;

public class SimplePersistenceFactory implements PersistenceFactory{

	@Override
	public Transaction newTransaction() {
		return new TransactionJdbcImpl();
	}
	
	@Override
	public RatingDao newRatingDao() {
		return new RatingDaoJdbcImpl();
	}

	@Override
	public UserDao newUserDao() {
		return new UserDaoJdbcImpl();
	}

	@Override
	public TripDao newTripDao() {
		return new TripDaoJdbcImpl();
	}

	@Override
	public SeatDao newSeatDao() {
		return new SeatDaoJdbcImpl();
	}

	@Override
	public ApplicationDao newApplicationDao() {
		return new ApplicationDaoJdbcImpl();
	}
}
