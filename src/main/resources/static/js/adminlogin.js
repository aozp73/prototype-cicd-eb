window.addEventListener('scroll', function() {
    let navbar = document.querySelector('.navbar');
    if (window.scrollY > 50) { 
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    var loginDTO = {
        email: email,
        password: password
    };
    console.log(loginDTO)
    $.ajax({
        url: '/login',
        type: 'POST',
        dataType: 'json', // 서버에서 응답으로 오는 데이터 타입
        contentType: 'application/json',
        data: JSON.stringify(loginDTO),

        success: function(data, textStatus, jqXHR) {
            const jwtToken = jqXHR.getResponseHeader('Authorization'); 
            if (jwtToken) {
                localStorage.setItem('jwtToken', jwtToken);
                window.location.href = '/main'; 
            } else {
                alert("내부 서버에러 발생 (code 1)")
            }
        },
        error: function(error) {
            alert(error.responseJSON.data)
        }
    });
}