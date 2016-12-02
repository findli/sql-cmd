$(function(){
    $('#bttEditDeal').click(function(){

        var idDeal = $('#idDeal').val();
        var newDeal = $('#dealNewName').val();
        var newUser = $('#responsibleUser').val();
        var newBudget = $('#dealBudget').val();
        var newStage = $('#stageDeal').val();

        $.ajax({
            type: 'POST',
            data: {
                idDeal : idDeal,
                newDeal : newDeal,
                newUser : newUser,
                newBudget : newBudget,
                newStage : newStage,
                action : 'editDealDeal'
            },
            url: '/dealEdit',
            success: function(result) {
                // alert(result);
                $('#result1').html(result);
            }
        })
    });
    $('#bttEditCompany').click(function(){

        var idDeal = $('#idDeal').val();
        var newCompany = $('#companyNewName').val();
        var newPhone = $('#companyNewPhone').val();
        var newEmail = $('#companyNewEmail').val();
        var newWeb = $('#companyNewWeb').val();
        var country = $('#AddressCountry').val();
        var city = $('#AddressCity').val();
        var street = $('#AddressStreet').val();
        var zipcode = $('#AddressZipcode').val();
        var building = $('#AddressBuilding').val();
        var room = $('#AddressRoom').val();
        $.ajax({
            type:'POST',
            data: {
                idDeal : idDeal,
                newCompany : newCompany,
                newPhone : newPhone,
                newEmail : newEmail,
                newWeb : newWeb,
                country : country,
                city : city,
                street : street,
                zipcode : zipcode,
                building : building,
                room : room,
                action: 'editDealCompany'
            },
            url: '/dealEdit',
            success: function(result) {
                $('#result2').html(result);
            }
        });
    });
});
/*
function add_contact() {
    var msg = $('#add_contact_form').serialize();
    alert(msg);
    $.ajax({
        type: 'POST',
//      dataType: "json",
        url: '/addContact',
        data: msg,
        success: funcSuccess,
        error:  funcError
    });

}
*/

function funcError(xhr, str) {
    alert('Возникла ошибка: ' + xhr.responseCode);
}

function funcSuccess(data) {
    $('.forms--nDeal--Contact').html(data);
}

//
//$(function () {
//    $('#datetimepicker').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
//});
//
//$(function () {
//    $('#datetimepicker1').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
//    $('#datetimepicker2').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
//
//});

jQuery( function($) {
    $('tbody tr[data-href]').addClass('clickable').click( function() {
        //alert('alert');
        window.location = $(this).attr('data-href');
    });
});

$(function(){
    $('#t_deals').on('click', '.rowlink', function(){
        //alert($(this).find('.item').html());
        //alert('idDeal');
    });
});

//Accordion
$(document).ready(function () {
    var previousId = null;
    $('.users__panel--body').hide();
    /*    $('.users__panel--input').click(function () {
     console.log('#'+this.id);
     /!*$('#'+this.id).is(':checked');*!/
     $('#'+this.id).checked=true;
     $('#'+this.id).attr("checked","checked");
     return false;
     });*/
    $('.users__panel--input').change(function () {
        console.log('#' + this.id);
        /* $('#'+this.id).prop("checked", this.checked);*/
        return false;
    });

    $('.users__panel').click(function () {
        if ($(previousId).hasClass('opened') && previousId != this) {
            $(previousId).toggleClass('opened').toggleClass('closed').next().slideToggle();
            $closeSlide(previousId.id)
        }
        $(this).toggleClass('opened').toggleClass('closed').next().slideToggle();
        previousId = this;
        if ($(this).hasClass('opened')) {
            document.getElementById(this.id).style.background = '#0e6cff';
        }
        else {
            $closeSlide(this.id)
        }
    });
});

$closeSlide = function (elementId) {
    document.getElementById(elementId).style.background = '#74aafb';

};


// $(function() {
//     $(".checkboxDeal").on( "click", function() {
//         if($(this).is(":checked")) {
//            $('.modalDeal .modalInput').prop("disabled", false);
//             $('select').prop("disabled", false);
//             $(".modalDeal .modalBut").css("display","inline-block");
//         }
//         else {
//             $('.modalDeal .modalInput').prop("disabled", true);
//             $('select').prop("disabled", true);
//             $(".modalDeal .modalBut").css("display","none");
//             $(".modalDeal .cancel").css("display","inline-block");
//         }
//     })
// });




