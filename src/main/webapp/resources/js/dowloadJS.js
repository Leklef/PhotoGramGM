/**
 * Created by lenar on 05.11.16.
 */
$('#file').change(function () {
    var name = document.getElementById('file').value.replace(/C:\\fakepath\\/i, '');
    document.getElementById('file-path').value=name;
});

$('#newPost').submit(function () {
    var name = document.getElementById('file-path').value;
    if (name != "") {
        sweetAlert({
            title: "Good job!",
            text: "Загрузка прошла успешно!",
            timer: 4000,
            showConfirmButton: false,
            type:"success"
        });
    } else {
        sweetAlert("Oops...", "Вы не выбрали файл!", "error");
        return false;
    }
    setTimeout(function confirm() {
        return true;
    },4000)
});