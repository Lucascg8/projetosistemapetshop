(function(){
    $("#tablecliente").on("click",".js-delete", function(){
        let botaoClique  = $(this);
        $("#btnsim").attr("data-id",botaoClique.attr("data-id"));
        $("#modalcliente").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/cliente/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/cliente";
            }
        });
    });
})();