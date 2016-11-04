/**
 * 
 */

function addAttribute() {
var card = $('.electivecall').closest("tr").parent('td').find('input[name=name]').val();
$.ajax({
    type:"GET",
    url: "http://localhost:8080/MusicCamp/editschedule",
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