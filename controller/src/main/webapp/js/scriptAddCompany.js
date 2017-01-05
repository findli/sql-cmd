$(function () {
$('.formAddBut').click(function () {
    var title = $("#formCompanyTabpanel").val();
    var phone = $("#formPhoneTabpanel").val();
    var email = $("#formEmailTabpanel").val();
    var web = $("#formWebTabpanel").val();

    var idAddress = $("#idModalAddress").val();
    var zip = $("#formZipcode").val();
    var country = $("#formCountry").val();
    var city = $("#formCity").val();
    var street = $("#formStreet").val();
    var build = $("#formBuildNum").val();
    var office = $("#formOfficeRoom").val();
    $.ajax({
        type: 'POST',
        dataType: "html",
        contentType: 'application/json; charset=utf-8',
        mimeType: 'application/json',

        data: JSON.stringify({
            title: title,
            phoneNumber: phone,
            email: email,
            website: web,
            address: {
                id: idAddress,
                zipcode: zip,
                country: country,
                city: city,
                street: street,
                buildNum: build,
                officeRoom: office
            }
        }),
        url: '/createUpdateCompany'
    });
});

$('.modalBut').click(function () {
    var zip = $("#modalZipcode").val();
    var country = $("#modalCountry").val();
    var city = $("#modalCity").val();
    var street = $("#modalStreet").val();
    var build = $("#modalBuildNum").val();
    var office = $("#modalOfficeRoom").val();
    $('#formAddress').text(zip + ', ' + country + ', ' + city + ', ' + street + ', ' + build + ', ' + office);
    $("#formZipcode").val(zip);
    $("#formCountry").val(country);
    $("#formCity").val(city);
    $("#formStreet").val(street);
    $("#formBuildNum").val(build);
    $("#formOfficeRoom").val(office);
    $.ajax({
        type: 'POST',
        dataType: "html",
        contentType: 'application/json; charset=utf-8',
        mimeType: 'application/json',

        data: JSON.stringify({
            zipcode: zip,
            country: country,
            city: city,
            street: street,
            buildNum: build,
            officeRoom: office
        }),
        url: '/createUpdateAddress'
    });
});
});