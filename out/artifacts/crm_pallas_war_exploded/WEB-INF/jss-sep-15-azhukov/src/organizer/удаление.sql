set @deleteID =( select distinct contact.idContact from contact where  nameContact = 'Alex');

delete from callclient where callclient.idContact = @deleteID;
delete from e_mail where e_mail.idContact = @deleteID;
delete from phone where phone.idContact = @deleteID;
delete from contact_has_meet where contact_has_meet.idContact = @deleteID;
/**set @ids = (select idMeet from meet where not exists(select * from contact_has_meet where contact_has_meet.idMeet = meet.idMeet));
removePerson from reminder where idMeet in (@ids);
removePerson from meet where idMeet in (@ids);
*/
delete from reminder where not exists (select * from contact_has_meet where contact_has_meet.idMeet = reminder.idMeet);
delete from meet where not exists (select * from contact_has_meet where contact_has_meet.idMeet = meet.idMeet);
delete from contact where contact.idContact = @deleteID;