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
// $(function () {
//     $('#datetimepicker1').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
//     $('#datetimepicker2').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
//
// });
$(function () {
    //Инициализация datetimepicker8 и datetimepicker9
    $("#datetimepicker8").datetimepicker();
    $("#datetimepicker9").datetimepicker();
    //При изменении даты в 8 datetimepicker, она устанавливается как минимальная для 9 datetimepicker
    $("#datetimepicker8").on("dp.change",function (e) {
        $("#datetimepicker9").data("DateTimePicker").setMinDate(e.date);
    });
    //При изменении даты в 9 datetimepicker, она устанавливается как максимальная для 8 datetimepicker
    $("#datetimepicker9").on("dp.change",function (e) {
        $("#datetimepicker8").data("DateTimePicker").setMaxDate(e.date);
    });
    $('#datetimepicker').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
});
// $(function () {
//     $('#datetimepicker').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
// });


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
