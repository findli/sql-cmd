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




