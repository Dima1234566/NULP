// $(document).ready(function () {
//
//     var navListItems = $('div.setup-panel div a'),
//             allWells = $('.setup-content'),
//             allNextBtn = $('.nextBtn');
//
//     allWells.hide();
//
//     navListItems.click(function (e) {
//         e.preventDefault();
//         var $target = $($(this).attr('href')),
//                 $item = $(this);
//
//         if (!$item.hasClass('disabled')) {
//             navListItems.removeClass('btn-primary').addClass('btn-default');
//             $item.addClass('btn-primary');
//             allWells.hide();
//             $target.show();
//             $target.find('input:eq(0)').focus();
//         }
//     });
//
//     allNextBtn.click(function(){
//         var curStep = $(this).closest(".setup-content"),
//             curStepBtn = curStep.attr("id"),
//             nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
//             curInputs = curStep.find("input[type='text'],input[type='url']"),
//             isValid = true;
//
//         $(".form-group").removeClass("has-error");
//         for(var i=0; i<curInputs.length; i++){
//             if (!curInputs[i].validity.valid){
//                 isValid = false;
//                 $(curInputs[i]).closest(".form-group").addClass("has-error");
//             }
//         }
//
//         if (isValid)
//             nextStepWizard.removeAttr('disabled').trigger('click');
//
//     });
//
//     $('div.setup-panel div a.btn-primary').trigger('click');
// });






// $(document).ready(function() {
//
//   $('#reg_form').bootstrapValidator({
//
//
//       feedbackIcons: {
//         valid: 'glyphicon glyphicon-ok',
//
//         validating: 'glyphicon glyphicon-refresh'
//       },
//       fields: {
//         first_name: {
//           validators: {
//             stringLength: {
//               min: 2
//             },
//             notEmpty: {
//               message: 'Будь ласка введіть своє ім\'я'
//             }
//           }
//         },
//
//         comment: {
//           validators: {
//             stringLength: {
//               min: 10,
//               max: 260,
//               message: 'Please enter at least 10 characters and no more than 200'
//             },
//             notEmpty: {
//               message: 'Будь ласка запонвіть це поле!'
//             }
//           }
//         },
//       }
//     })
//
//
//     .on('success.form.bv', function(j) {
//       $('#success_message').slideDown({
//         opacity: "show"
//       }, "slow")
//        Do something ...
//               $("li").append(li);
//          var popUpDiv = $("#content");
//          var li = document.createElement('li');
//          var rowDiv = document.createElement('div');
//          rowDiv.className = "row";
//          li.appendChild(rowDiv);
//
//          var colDiv = document.createElement('div');
//          colDiv.className = "col-sm";
//          rowDiv.appendChild(colDiv);
//
//
//          var nextDiv = document.createElement('div');
//          nextDiv.className ='testimonial testimonial-default-filled';
//          nextDiv.id='tb-testimonial';
//          nextDiv.appendChild(colDiv);
//
//          var commentDiv = document.createElement('div');
//          commentDiv.className ='testimonial-section';
//         //  commentDiv.appendChild('commentDiv');
//          commentDiv.appendChild(popUpDiv);
//
//
//
//
//       $('#reg_form').data('bootstrapValidator').resetForm();
//
//
//       e.preventDefault();
//
//
//       var $form = $(e.target);
//
//
//       var bv = $form.data('bootstrapValidator');
//
//
//       $.post($form.attr('action'), $form.serialize(), function(result) {
//         console.log(result);
//       }, 'json');
//     });
// });
//


function send() {
    if ($('#header').val() === "" || $('#content').val() === "") {
        alert('Заповніть всі поля');
        return false;
    } else {
        var date = new Date;
        var author = document.getElementById('header').value;
        var text = document.getElementById('content').value;
        var parentElem = document.getElementById('list');
        var out = document.createElement('div');
        out.id = 'list';
        out.innerHTML =

            "<div class='row'>"+
              "<div class='col-sm'>"+
                "<div id='tb-testimonial' class='testimonial testimonial-default-filled'>"+
                  "<div class='testimonial-section'>"+text+
                  "</div><div class='testimonial-desc'>"+
                    "<img src='https://placeholdit.imgix.net/~text?txtsize=9&txt=100%C3%97100&w=100&h=100'  />"+
                    "<div class='testimonial-writer'>"+
                      "<div class='testimonial-writer-name'>"+ author +"</div>"+"<p>Date/Time:"+ "<span id='date'>"+date+"</span>"+"</p>"+
                    "</div>"+
                  "</div>"+
                "</div>"+
              "</div>";


        parentElem.appendChild(out);
        document.getElementById('form').reset();
    }
}
