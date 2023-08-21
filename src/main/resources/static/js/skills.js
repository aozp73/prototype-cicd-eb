window.addEventListener('scroll', function() {
    let navbar = document.querySelector('.navbar');
    if (window.scrollY > 50) { 
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

function toggleEditMode() {
    const controls = document.querySelectorAll('.edit-controls');
    controls.forEach(control => {
        if (control.style.display === 'none') {
            control.style.display = 'block';
        } else {
            control.style.display = 'none';
        }
    });
}

function getUpdateForm(event){
    var modal = new bootstrap.Modal(document.getElementById("skillsAddForm"));
    modal.show();
    $('#backendSelect').select2({
        dropdownParent: $('#skillsAddForm') 
    }); 
}

function updateSkills(){

}

function addButton(section) {
    const selectBox = document.getElementById(`${section}Select`);
    const buttonsDiv = document.getElementById(`${section}Buttons`);
    
    const value = selectBox.value;
    
    const existingButtons = buttonsDiv.querySelectorAll('.no-hover-container');
    let valueExists = false;
    existingButtons.forEach(button => {
        const label = button.querySelector('span:not(.close-icon)').innerText; 
        if (label === value) {
            valueExists = true;
        }
    });
    
    if (value && !valueExists) {
        const container = document.createElement("div");
        container.className = "no-hover-container";
        
        // 메인 버튼 생성
        const btn = document.createElement("button");
        btn.className = "btn btn-outline-secondary btn-sm m-1 d-flex align-items-center no-hover";
    
        // 레이블 추가
        const btnText = document.createElement("span");
        btnText.innerHTML = value;
        btn.appendChild(btnText);
    
        // x 표시 추가
        const closeIcon = document.createElement("span");
        closeIcon.innerHTML = "&times;";
        closeIcon.className = "close-icon";  // x 표시 스타일 적용
        closeIcon.style.marginLeft = "5px";
        closeIcon.style.cursor = "pointer";
        closeIcon.style.transition = "0.3s"; 
    
        closeIcon.onclick = function(event) {
            event.stopPropagation();
            buttonsDiv.removeChild(container);
        };
        btn.appendChild(closeIcon);
        
        container.appendChild(btn);
    
        // 컨테이너에 버튼 추가
        buttonsDiv.appendChild(container);
    }
}

function updateSkills() {
    const backendData = collectData("backend");
    const frontendData = collectData("frontend");
    const devopsData = collectData("devops");
    const etcData = collectData("etc");

    const postData = {
        backend: backendData,
        frontend: frontendData,
        devops: devopsData,
        etc: etcData
    };

    console.log(postData)
    // Ajax-POST 통신
}

function collectData(section) {
    const buttonsDiv = document.getElementById(`${section}Buttons`);
    const buttons = buttonsDiv.querySelectorAll("button span:first-child");

    const values = [];
    buttons.forEach(button => {
        values.push(button.innerText);
    });

    return values.join(' ');
}
