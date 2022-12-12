(function(){
    $("#tableagendamento").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalagendamento").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/agendamento/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/agendamento";
            }
        });
    });
})();