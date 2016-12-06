/**
 * Created by lenar on 06.12.16.
 */
var input = document.querySelector("input[type='file']");
input.onchange = function () {
    this.form.submit();
}