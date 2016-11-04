/**
 * 
 */

function addAttribute() {
var card = $('#card').closest("tr").parent('td').find('input[name=name]').val();
$.ajax({
    type:"GET",
    url: contexPath + "/getUpdatableCard",
    data:"card=" + card,
    dataType:'json',
    contentType : "application/json",
    success:function(data) {
        $("#cardUpdate").modal("show");
        alert(data.id);
    },
    error: function(jqXHR, textStatus, errorThrown) {
        alert(textStatus + ': ' + errorThrown);
        }
});
$(document).ready(function () {
	alert("Hello");
	$('.editbtn').click(function () {
        var currentTD = $(this).parents('tr').find('td');
        if ($(this).html() == 'Edit') {
            currentTD = $(this).parents('tr').find('td');
            $.each(currentTD, function () {
                $(this).prop('contenteditable', true)
            });
        } else {
           $.each(currentTD, function () {
                $(this).prop('contenteditable', false)
            });
        }

        $(this).html($(this).html() == 'Edit' ? 'Save' : 'Edit')

    });

});