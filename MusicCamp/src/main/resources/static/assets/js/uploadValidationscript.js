function buttonClick()
{
	alert('hi');
 nme= document.getElementById("test").value;
 //if(nme == "xlsx") {
	// alert(nme);
	 var file_extn = nme.split('.').pop();
	 if(file_extn == "xlsx" || file_extn == "xls")
	 {
	 alert('This file can be uploaded');
	 return true;
	 } else if (file_extn == "") {
		 alert('No file selected');
	 } else 	 {
		 location.reload();
		 alert('Only files with .xlsx and .xls extensions are allowed');
		 
	 }
 }
 

function validate_fileupload(filename)
{
	filename = document.getElementById("test").value;
	var extn = filename.split('.').pop();
	
} 

window.onload = function() 
{
document.getElementById("js-upload-submit").onclick = buttonClick;
};
