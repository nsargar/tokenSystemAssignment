$(document).ready(function(){

    var url='localhost:8089';
/*
    $("#generate").submit(function(event){
        event.preventDefault();
        ajaxPost();

    });*/
    $("input[name='generate']").on("click",function (event) {

        event.preventDefault();
        ajaxPost();

    });

    function ajaxPost(){
        var formData ={
            customerNumber : $("#customerNumber").val()
        }



        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : url + "/generate",
            data : JSON.stringify(formData),
            dataType : 'json',
            crossDomain : true,
            headers : {
                "Access-Control-Allow-Origin" : "*",
                "Access-Control-Allow-Headers" : "CUSTOM-HEADER"

            },
            success : function(result) {

                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData(){
        $("#customerNumber").val("");
    }
});