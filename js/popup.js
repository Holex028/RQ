let openPopUp = document.querySelectorAll('.open_pop_up');
let closePopUp = document.querySelector('.pop_up_close');
let popUp = document.querySelector('.pop_up');
let popUpTell = document.querySelector('.pop_up_body_tell');
let pop_up_body_limit = document.querySelector('.pop_up_body_limit')
let popUpForm = document.querySelector('.pop_up_body_form')
let popUpBtn = document.querySelector('.pop_up_body_btn')
let popUpText = document.querySelector('.pop_up_body_text')



openPopUp[0].addEventListener('click', function(e) {
    e.preventDefault();
    popUp.classList.add('active');
})

openPopUp[1].addEventListener('click', function(e) {
    e.preventDefault();
    popUp.classList.add('active');
})

closePopUp.addEventListener('click', () => {
    popUp.classList.remove('active');
})
pop_up_body_limit.textContent = 0
popUpTell.oninput = function() {
    pop_up_body_limit.textContent = popUpTell.value.length
    if (popUpTell.value.length > 12) {
        popUpText.classList.add('warning');
        popUpTell.classList.add('warning');
        popUpBtn.classList.add('warning_btn');
        popUpBtn.disabled = true;

    } else {
        popUpText.classList.remove('warning');
        popUpTell.classList.remove('warning');
        popUpBtn.classList.remove('warning_btn');
        popUpBtn.disabled = false;
    }
};