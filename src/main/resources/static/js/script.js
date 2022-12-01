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

    $("#tablepet").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalpet").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/pet/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/pet";
            }
        });
    });

    $("#tableservicos").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalservico").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/servicos/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/servicos";
            }
        });
    });

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
    
    $("#tableatendente").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalatendente").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/atendente/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/atendente";
            }
        });
    });

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