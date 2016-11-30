select nameContact,phone_work, phone_home, e_mail,reminderDate, meetDate
from contact
inner join phone on phone.idContact=contact.idContact
inner join e_mail on e_mail.idContact=contact.idContact
inner join contact_has_meet on  contact_has_meet.idContact=contact.idContact
inner join meet on  contact_has_meet.idMeet=meet.idMeet
inner join reminder on reminder.idMeet=meet.idMeet
where meetDate= {d '2015-09-20'}
order by nameContact;