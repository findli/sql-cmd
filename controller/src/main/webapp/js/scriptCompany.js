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



/*reset forms*/

/*$(".cancel").click(function () {
    $('.modalInput').val("");
    $('.modalTextArea').val("");
});*/

jQuery( function($) {
    $('tbody tr[data-href]').addClass('clickable').click( function() {
        window.location = $(this).attr('data-href');
    });
});

$(function(){
    $('#t_company').on('click', '.rowlink', function(){
    });
});

$(function () {
    $("#actionButDeal").on("click", function () {
        if ($(this).is(":checked")) {
            $('.taskBlock').css('display', 'block');
        }
        else {
            $('.taskBlock').css('display', 'none');
        }
    });
    $("#actionButNote").on("click", function () {
        if ($(this).is(":checked")) {
            $('.noteBlock').css('display', 'block');
        }
        else {
            $('.noteBlock').css('display', 'none');
        }
    });
    $("#formTaskDone").on("click", function () {
        if ($(this).is(":checked")) {
            $('.taskBlock').css('display', 'block');
        }
        else {
            $('.taskBlock').css('display', 'none');
        }
    });
    $('.actionBut').click(function () {
        $.ajax({
            type:'POST',
            data: {
                action: this.id
            },
            url: '/companyDetail'
        });
        $(this.parentNode.parentNode.parentNode).css('display', 'none');
    });
});



/*for (var i = 0 ; i<$('.taskDate').length; i++){
    var dateWrapper = $('.taskDate')[i];
    var dateFromHtml = dateWrapper.innerText.split('-');
    var date = new Date(dateFromHtml[0],dateFromHtml[1]-1,dateFromHtml[2]);
    var today = new Date();
    if (today > date){
        $(dateWrapper.parentNode).css('border', 'red solid 3px');
    }
}*/



    /*
    var wrapper = $('.cd-date');

    for (var i = 0 ; i<$('.cd-date').length; i++){
        var dateWrapper = $('.cd-date')[i];
        var dateFromHtml = dateWrapper.innerText.split('-');
        var date = new Date(dateFromHtml[0],dateFromHtml[1]-1,dateFromHtml[2]);
    var inp = $('.cd-date').prev().prev().attr('class');
    }
    */

/*console.log($('.dateInMs')[0].innerText);

var ms= ($('.dateInMs'));
console.log($('.dateInMs').innerText);*/
/*for (var j = 0, len = ms.length - 1; j < len; j++) {
    var swapped = false;
    var k = 0;
    while (k < len - j) {
        console.log($('.dateInMs').innerText[k]);
        if (ms[k].innerText > ms[k + 1].innerText) {
            var c = ms[k].innerText;
            console.log("ccc " +c + " m " + ms[k].innerText);
            ms[k].innerText = ms[k + 1].innerText;
            ms[k + 1].innerText = c;
            swapped = true;
        }
        k++;
    }

    if(!swapped)
        break;
}*/

/*for (var t = 0 ; t<$('.cd-date').length; t++){
    console.log($('.dateInMs')[t].innerText);
}*/

