/**
 * Created by lenar on 05.11.16.
 */
$('#search').submit(function () {
    var name = document.getElementById('searchTF').value;
    if (name.length >= 3) {
        return true;
    } else {
        sweetAlert("Oops...", "Для поиска необходимо минимум 3 символа", "error");
        return false;
    }
});
function clicked(filePath) {
    sweetAlert({
            title: "Are you sure?",
            text: "You will not be able to recover this imaginary file!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Yes, delete it!",
            cancelButtonText: "No, cancel plx!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
        function(isConfirm){
            if (isConfirm) {
                sweetAlert("Deleted!", "Your imaginary file has been deleted.", "success");
                window.location.replace("/header?delete="+filePath);
            } else {
                sweetAlert("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
}