 $('#grade').on('keyup', function () {
    if ($('#grade').val() != '') {
    $("#submit").attr("disabled",false);
    $('#gradeValid').show();
    $('#gradeInvalid').hide();
    $('#grade').html('Valid').css('color', 'green');
    $('.pwds').removeClass('is-invalid')
    } else {
    $("#submit").attr("disabled",true);
    $('#gradeValid').hide();
    $('#gradeInvalid').show();
    $('#gradeInvalid').html('Not Matching').css('color', 'red');
    $('.pwds').addClass('is-invalid')
    }
    });

     let currForm1 = document.getElementById('myForm1');
        // Validate on submit:
        currForm1.addEventListener('submit', function(event) {
          if (currForm1.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          currForm1.classList.add('was-validated');
        }, false);
        // Validate on input:
        currForm1.querySelectorAll('.form-control').forEach(input => {
          input.addEventListener(('input'), () => {
            if (input.checkValidity()) {
              input.classList.remove('is-invalid')
              input.classList.add('is-valid');
            } else {
              input.classList.remove('is-valid')
              input.classList.add('is-invalid');
            }
            var is_valid = $('.form-control').length === $('.form-control.is-valid').length;
            $("#submit").attr("disabled", !is_valid);
          });
        });
      });