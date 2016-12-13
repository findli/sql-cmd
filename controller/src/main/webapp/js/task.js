
jQuery( function($) {
    $('tbody td[data-href]').addClass('clickable').click( function() {
        //alert('alert');
        window.location = $(this).attr('data-href');
    });
});

$(function(){
    $('#t_task').on('click', '.rowlink', function(){
    });
});





