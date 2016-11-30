select nameContact,phone_work, phone_home, e_mail, meetDate
from contact
inner join phone on phone.idContact=contact.idContact
inner join e_mail on e_mail.idContact=contact.idContact
inner join contact_has_meet on  contact_has_meet.idContact=contact.idContact
inner join meet on  contact_has_meet.idMeet=meet.idMeet
where nameContact='L.Volkova';