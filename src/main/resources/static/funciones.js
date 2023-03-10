function eliminar(id) {
    swal({
        title: "¿Estás seguro de que desea eliminar?",
        text: "Una vez eliminado, no podrá recuperar este registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((OK) => {
        if (OK) {
            $.ajax({
                url: "/eliminar/" + id,
                success: function (result) {
                    console.log(result);
                }
            });
            swal("El registro ha sido eliminado!", {
                icon: "success",
            }).then((ok) => {
                if (ok) {
                    location.href = "/listar";
                }
            });
        } else {
            swal("El registro no ha sido eliminado!");
        }
    });
}