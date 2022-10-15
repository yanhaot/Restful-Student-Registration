$(document).ready(function () {
    
    // Add Close button
       $('#addclose').click(function(){
       $('.alert').remove();
               $('#addSname').val('');
               $('#addAge').val('');
               $('#addEmail').val('');
               $('#addMobile').val('');
               $('#addAddress').val('');
       });
       
   	// Add function
    $('#addButton').click(function (event) {
        $.ajax({
           type: 'POST',
           url: 'http://localhost:8989/students',
           data: JSON.stringify({
                sname: $('#addSname').val(),
                age: $('#addAge').val(),
                email: $('#addEmail').val(),
                mobile: $('#addMobile').val(),
                address: $('#addAddress').val()
           }),
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
           },
           'dataType': 'json',
           success: function() {
		       $('.alert').remove();
               $('#addSname').val('');
               $('#addAge').val('');
               $('#addEmail').val('');
               $('#addMobile').val('');
               $('#addAddress').val('');
               $('.addform').append('<div class="alert alert-success"><strong>Student data created!<strong></div>'
               );
           },
 			error: function() {
	       	   $('.alert').remove();
               $('.addform').append('<div class="alert alert-danger"><strong>Please check your inputs again!<strong></div>');
		   }
        })
    });
    
    // Update Close button
    $('#updateclose').click(function(){
       $('.alert').remove();
       $('input#retrieveSname').val('');
       $('input#retrieveAge').val('');
       $('input#retrieveEmail').val('');
       $('input#retrieveMobile').val('');
       $('input#retrieveAddress').val('');
    });
    
    // Get individual student function
    $('#retrieveButton').click(function () {
        $.ajax({
           type: 'GET',
	       url: 'http://localhost:8989/students/' + $('input#retrieveid').val(),
           success: function(student) {
			   console.log(student);
		       $('.alert').remove();
		       $('input#retrieveSname').val('').prop("disabled", false);
               $('input#retrieveAge').val('').prop("disabled", false);
               $('input#retrieveEmail').val('').prop("disabled", false);
               $('input#retrieveMobile').val('').prop("disabled", false);
               $('input#retrieveAddress').val('').prop("disabled", false);
		       $('.retrieveInputGroup').append('<div class="alert alert-success"><strong>Student data retrieved!<strong></div>');
               $('input#retrieveSname').val(student['sname']);
               $('input#retrieveAge').val(student['age']);
               $('input#retrieveEmail').val(student['email']);
               $('input#retrieveMobile').val(student['mobile']);
               $('input#retrieveAddress').val(student['address']);
           },
 			error: function() {
	       	   $('.alert').remove();
	       	   $('input#retrieveSname').val('').prop("disabled", true);
               $('input#retrieveAge').val('').prop("disabled", true);
               $('input#retrieveEmail').val('').prop("disabled", true);
               $('input#retrieveMobile').val('').prop("disabled", true);
               $('input#retrieveAddress').val('').prop("disabled", true);
               $('.retrieveInputGroup').append('<div class="alert alert-danger"><strong>Invalid Student Id entered<strong></div>');
		   }
        })
    });
    
    // Update individual student function
    $('#updateButton').click(function () {
        $.ajax({
           type: 'PUT',
	       url: 'http://localhost:8989/students/' + $('input#retrieveid').val(),
	       headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
           },
	       data: JSON.stringify({
		        id: $('input#retrieveid').val(),
                sname: $('input#retrieveSname').val(),
                age: $('input#retrieveAge').val(),
                email: $('input#retrieveEmail').val(),
                mobile: $('input#retrieveMobile').val(),
                address: $('input#retrieveAddress').val()
           }),
           success: function() {
		       $('.alert').remove();
		       $('.retrieveform').append('<div class="alert alert-success"><strong>Student data updated!<strong></div>');
	       	   $('input#retrieveSname').val('').prop("disabled", true);
               $('input#retrieveAge').val('').prop("disabled", true);
               $('input#retrieveEmail').val('').prop("disabled", true);
               $('input#retrieveMobile').val('').prop("disabled", true);
               $('input#retrieveAddress').val('').prop("disabled", true);
           },
 			error: function() {
	       	   $('.alert').remove();
	       	   $('input#retrieveSname').val('').prop("disabled", true);
               $('input#retrieveAge').val('').prop("disabled", true);
               $('input#retrieveEmail').val('').prop("disabled", true);
               $('input#retrieveMobile').val('').prop("disabled", true);
               $('input#retrieveAddress').val('').prop("disabled", true);
               $('.retrieveform').append('<div class="alert alert-danger"><strong>Please check your inputs again!<strong></div>');
		   }
        })
    });
    
    // Delete Close button
    $('#deleteclose').click(function(){
       $('.alert').remove();
       $('#deleteid').val('');
    });
    
	
	// Delete function
	$('#deleteButton').click(function (event) {
	
	    $.ajax({
	        type: 'DELETE',
	        url: 'http://localhost:8989/students/' + $('#deleteid').val(),
	        success: function() {
		       	 $('.alert').remove();
	             $('.deleteform').append('<div class="alert alert-success"><strong>Student deleted!<strong></div>');
	        },
	        error: function(){
		       	 $('.alert').remove();
		         $('.deleteform').append('<div class="alert alert-danger"><strong>Invalid Id!<strong></div>');
			}
	    });	
	});
	
	    // Get search student function
 /*   $('#searchButton').click(function () {
        $.ajax({
           type: 'GET',
	       url: 'http://localhost:8989/students/name/' + $('input#searchname').val(),
           success: function(student) {
			   console.log(student);
		       $('.alert').remove();
           },
 			error: function() {
	       	   $('.alert').remove();
		   }
        })
    });
    
   */ 
	
}); /* End of document */


	// Get function
/*	function loadStudents(){
		var tableBodyDiv = $('tbody#tableBodyDiv');
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8989/students',
            success: function(studentArray) {
				console.log(JSON.stringify(studentArray));
                $.each(studentArray, function(student) {
					var studentInfo = '<tr>';
					studentInfo += '<td>' + student.sname + '</td>';
					studentInfo += '<td>' + student.age + '</td>';
					studentInfo += '<td>' + student.mobile + '</td>';
					studentInfo += '<td>' + student.email + '</td>';
					studentInfo += '<td>' + student.address + '</td>';
					studentInfo += '<tr>'
                    tableBodyDiv.append(studentInfo);
                })
            },
            error: function() {
                alert('FAILURE!');
            }
        });
	}
*/