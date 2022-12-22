
$(".editButton").click(function (){
    window.location.replace(`/${$(this).attr("data-id")}/edit`)
});

$(".deleteButton").click(function (){
    window.location.replace(`/${$(this).attr("data-id")}/delete`)
});




