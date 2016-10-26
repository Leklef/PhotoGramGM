/**
 * Created by lenar on 07.10.16.
 */
 $(document).ready(function () {
    $("#loginform").validate({
        rules:{
            name:"required",
            nickname:"required",
            email:{
                required:true,
                email:true
            },
            password:{
                required:true,
                minlength:6
            }
        },

        messages:{
            name:"",
            nickname:"",
            email:{
                required:"",
                email:""
            },
            password:{
                required:"",
                minlength:""
            }
        },

        highlight:function (element) {
            $(element).css('border-color','red')
        },
        unhighlight:function (element) {
            $(element).css('border-color','rgb(210,210,210)')
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});