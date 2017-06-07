package com.cms.mapper;

import java.sql.Date;

import com.cms.model.UserTicket;

public interface UserTicketMapper {
	public UserTicket getUserTicket(UserTicket ut);
	
	public void saveUserTicket(UserTicket ut);
	
	public void deleteUserTicket(UserTicket ut);
}
