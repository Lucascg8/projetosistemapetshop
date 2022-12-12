(function(){
    $("#tableveterinario").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalveterinario").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/veterinario/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/veterinario";
            }
        });
    });
})();