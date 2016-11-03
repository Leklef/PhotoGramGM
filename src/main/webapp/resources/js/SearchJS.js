/**
 * Created by lenar on 03.11.16.
 */
function checkForm() {
    if ($("#search").val()<=3)
    {
        alert ('Напишите как минимум 3 символа');
        return false;
    }
}
