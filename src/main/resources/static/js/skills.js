const changedSkills = {
    'BackEnd': [],
    'FrontEnd': [],
    'DevOps': [],
    'ETC': []
};

let checkInitialSkill = []

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

function addSkills(section) {
    const selectBox = document.getElementById(`${section}Select`);
    const value = selectBox.value;  // 선택된 Skill 값

    const skillsDiv = document.getElementById(`${section}Skills`);

    // 동일한 스킬 2번 선택하지 못하게 확인
    const existingButtons = skillsDiv.querySelectorAll('.no-hover-container');
    let valueExists = false;
    existingButtons.forEach(button => {
        const label = button.querySelector('span:not(.close-icon)').innerText; 
        if (label === value) {
            valueExists = true;
        }
    });
    
    // 동일하지 않다면 SKill 버튼을 화면에 추가하는 코드
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
            // changedSkills[section].push({name: value, status: 'removed'});
            updateChangedSkills(section, value, 'removed');
            skillsDiv.removeChild(container);
        };
        btn.appendChild(closeIcon);
        
        container.appendChild(btn);
    
        // 컨테이너에 버튼 추가
        updateChangedSkills(section, value, 'added');
        // changedSkills[section].push({name: value, status: 'added'});
        skillsDiv.appendChild(container);
    }
}

function updateSkills() {
    console.log('Changed skills:', changedSkills);


    $.ajax({
        url: "/auth/skills",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(changedSkills),
        success: function(response) {
            console.log(response);
        },
        error: function(error) {
            alert(error.responseJSON.data);
        }
    });
}

// 스킬 업데이트 함수
// add하고 remove를 반복해서 한다면, 마지막 액션만 기록되어야 함
function updateChangedSkills(section, name, status) {
    // changedSkills의 section 키에 연결된 배열에서 name이 같은 객체를 찾음
    // existing에는 배열에서 찾은 객체를 저장하거나, 찾지 못했다면 undefined 저장
    const existing = changedSkills[section].find(skill => skill.name === name);
    
    // 이전에 추가되거나 삭제된 기록이 있다면, 그 기록을 지움
    if (existing) {
      const index = changedSkills[section].indexOf(existing);
      changedSkills[section].splice(index, 1);
    }

    // 만약 초기 상태(즉, DB에서 가져온 상태)에서 처음으로 removed 상태가 되면,
    // 그 정보를 checkInitialSkill 배열에 추가
    if (status === 'removed' && !existing) {
        checkInitialSkill.push({ section, name });
    }

    // 이전에 added 상태였는데 현재 'removed' 상태로 바뀌면,
    // 그게 초기 상태에서 바뀐 것인지 확인
    if (status === 'removed' && existing && existing.status === 'added') {
        const initialRemoved = checkInitialSkill.find(skill => skill.name === name && skill.section === section);
        // 초기 상태에서 추가된 것이 아니라면 함수를 종료 (초기 상태가 아니라면 변한게 없음)
        if (!initialRemoved) {
            return;
        }
    }
  
    // 새로운 상태를 changedSkills에 추가 (초기 상태에 있던걸 remove한 것도 기록하여 저장)
    changedSkills[section].push({ name, status });
}



// 모달 창이 닫힐 때 두 배열 초기화
document.addEventListener('DOMContentLoaded', (event) => {
    var myModal = document.getElementById('skillsAddForm')
    myModal.addEventListener('hidden.bs.modal', function (event) {
        changedSkills['BackEnd'] = [];
        changedSkills['FrontEnd'] = [];
        changedSkills['DevOps'] = [];
        changedSkills['ETC'] = [];

        checkInitialSkill = [];
    });
});