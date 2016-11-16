//Accordion
$(document).ready(function () {
    var previousId = null;
    $('.users__panel--body').hide();
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


$(function () {
    $(".checkboxDeal").on("click", function () {
        if ($(this).is(":checked")) {
            $('.modalDeal .modalInput').prop("disabled", false);
            $('select').prop("disabled", false);
            $(".modalDeal .modalBut").css("display", "inline-block");
        }
        else {
            $('.modalDeal .modalInput').prop("disabled", true);
            $('select').prop("disabled", true);
            $(".modalDeal .modalBut").css("display", "none");
            $(".modalDeal .cancel").css("display", "inline-block");
        }
    })
});

$(function () {
    $("#myCalendar-1").ionCalendar({
        sundayFirst: false,
        years: "2000-2099",
        format: "DD.MM.YYYY",
        onClick: function (date) {
            console.log(date);
        }
    });
});


$('.container').clockpicker().find('input').change(function () {
    console.log(this.value);
});

$('.clockpicker').clockpicker({
    autoclose: true,
    donetext: 'Done'
});

/*console.log($('.action__task note').closest('.cd-timeline-block'));*/


/*reset forms*/

$(".cancel").click(function () {
    $('.modalInput').val("");
    $('.modalTextArea').val("");
})



/* $($('.action--task').closest('.cd-timeline-block').attr('class', "cd-timeline-block task"));
 $($('.action--note').closest('.cd-timeline-block').attr('class', "cd-timeline-block note"));*/











