const changedSkills = {
    'BackEnd': [],
    'FrontEnd': [],
    'DevOps': [],
    'ETC': [],
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

            el = `
                <option id="${value}" value="${value}">${value}</option>
            `
            $(`#${section}Select`).append(el)
        };
        btn.appendChild(closeIcon);

        container.appendChild(btn);
    
        // 컨테이너에 버튼 추가
        updateChangedSkills(section, value, 'added');
        // changedSkills[section].push({name: value, status: 'added'});
        skillsDiv.appendChild(container);
        $(`#${value}`).remove()
    }
}

function updateSkills() {
    const jwtToken = localStorage.getItem('jwtToken'); 
    console.log('Changed skills:', changedSkills);

    console.log("About to send: ", JSON.stringify(changedSkills));
    $.ajax({
        url: "/auth/skills",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(changedSkills),
        headers: {
            'Authorization': jwtToken  
        },

        success: function(response) {
            location.reload(true);
        },
        error: function(error) {
            alert(error.responseJSON.data);
        }
    });
}

// 스킬 업데이트 함수
// (add, remove를 반복해서 한다면, 마지막 액션만 기록되어 Server로 보내져야함)
function updateChangedSkills(section, name, status) {
    // changedSkills의 section 키에 연결된 배열에서 name이 같은 객체를 찾음
    // existing에는 배열에서 찾은 객체 저장 / 찾지 못했다면 undefined 저장
    const existing = changedSkills[section].find(skill => skill.name === name);
    
    // 이전에 추가되거나 삭제된 기록이 있다면, 그 기록을 지움
    if (existing) {
      const index = changedSkills[section].indexOf(existing);
      changedSkills[section].splice(index, 1);
    }

    // DB에서 가져온 상태에서 처음 removed 되었다면, 정보를 checkInitialSkill 배열에 추가
    if (status === 'removed' && !existing) {
        checkInitialSkill.push({ section, name });
    }

    // 이전이 added 상태였고, 현재 'removed' 된거라면 -> DB에 없던 상태에서 added된건지 확인
    if (status === 'removed' && existing && existing.status === 'added') {
        const initialRemoved = checkInitialSkill.find(skill => skill.name === name && skill.section === section);
        // 첫 요청 시 DB에 없던 상태에서 추가된 것이 아니라면 removed를 push하지 않고 함수 종료 
        // (DB에 없는 상태이니 removed를 Server로 보내면 안됨)
        if (!initialRemoved) {
            return;
        }
    }
  
    // 새로운 상태를 changedSkills에 추가 
    changedSkills[section].push({ name, status });  
}



// 모달 창이 닫힐 때 
document.addEventListener('DOMContentLoaded', (event) => {
    var myModal = document.getElementById('skillsAddForm')
    myModal.addEventListener('hidden.bs.modal', function (event) {
        // 배열 초기화
        changedSkills['BackEnd'] = [];
        changedSkills['FrontEnd'] = [];
        changedSkills['DevOps'] = [];
        changedSkills['ETC'] = [];

        checkInitialSkill = [];

        // 새로 추가 및 삭제 내역 / 선택한 내역 초기화
        document.getElementById('BackEndSkills').innerHTML = '';
        document.getElementById('FrontEndSkills').innerHTML = '';
        document.getElementById('DevOpsSkills').innerHTML = '';
        document.getElementById('ETCSkills').innerHTML = '';
    
        document.getElementById('BackEndSelect').selectedIndex = -1;
        document.getElementById('FrontEndSelect').selectedIndex = -1;
        document.getElementById('DevOpsSelect').selectedIndex = -1;
        document.getElementById('ETCSelect').selectedIndex = -1;
    });
});

var badges = {
    "Java": "https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white",
    "Python": "https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=Python&logoColor=white",
    "SpringBoot":"https://img.shields.io/badge/SpringBoot-%236DB33F.svg?style=flat-square&logo=spring&logoColor=white",
    "SpringSecurity":"https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring&logoColor=white",
    "MySQL":"https://img.shields.io/badge/MySQL-%2300f.svg?style=flat-square&logo=MySQL&logoColor=white",
    "Mybatis":"https://img.shields.io/badge/MyBatis-C70D2C.svg?style=flat-square",
    "Jpa":"https://img.shields.io/badge/JPA-A5915F.svg?style=flat-square",
    "JUnit5":"https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white",
    "Postman":"https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=postman&logoColor=white",

    "HTML5":"https://img.shields.io/badge/HTML5-%23E34F26.svg?style=flat-square&logo=html5&logoColor=white",
    "CSS3":"https://img.shields.io/badge/CSS3-%231572B6.svg?style=flat-square&logo=css3&logoColor=white",
    "JavaScript":"https://img.shields.io/badge/JavaScript-%23323330.svg?style=flat-square&logo=javascript&logoColor=%23F7DF1E",
    "JQuery":"https://img.shields.io/badge/jQuery-%230769AD.svg?style=flat-square&logo=jquery&logoColor=white",
    
    "Docker":"https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white",
    "Kubernetes":"https://img.shields.io/badge/Kubernetes-2496ED?style=flat-square&logo=Kubernetes&logoColor=white",

    "GitHub":"https://img.shields.io/badge/GitHub-%23121011.svg?style=flat-square&logo=github&logoColor=white",
    "Notion":"https://img.shields.io/badge/Notion-000000?style=flat-square&logo=Notion&logoColor=white",
    "Jira":"https://img.shields.io/badge/Jira-0052CC?style=flat-square&logo=Jira&logoColor=white",
    "VisualStudioCode":"https://img.shields.io/badge/VisualStudioCode-007ACC?style=flat-square&logo=VisualStudioCode&logoColor=white",
    "Eclipse":"https://img.shields.io/badge/Eclipse-2C2255?style=flat-square&logo=Eclipse&logoColor=white",
    "AWS":"https://img.shields.io/badge/AWS-%23FF9900.svg?style=flat-square&logo=amazon-aws&logoColor=white",
    "Firebase":"https://img.shields.io/badge/Firebase-FF6A00?style=flat-square&logo=firebase&logoColor=white",
    "AmazonEC2":"https://img.shields.io/badge/AmazonEC2-FF9900?style=flat-square&logo=amazonec2&logoColor=white",
    "AmazonS3":"https://img.shields.io/badge/AmazonS3-569A31?style=flat-square&logo=amazons3&logoColor=white"
};


var allSkills = $('#allSkills').data('skills');  

// 페이지 로드시 기술 스택 랜더링
window.addEventListener("load", function() {
        var containers = {
            "BackEnd": document.querySelector("#main-container .container:nth-child(2)"),
            "FrontEnd": document.querySelector("#main-container .container:nth-child(3)"),
            "DevOps": document.querySelector("#main-container .container:nth-child(4)"),
            "ETC": document.querySelector("#main-container .container:nth-child(5)")
        };
    
        for(var category in allSkills) {
            var skills = allSkills[category];
            var container = containers[category];
            let imageCount = 0;

            skills.forEach(function(skill) {
                var imgTag = document.createElement("img");
                imgTag.src = badges[skill]; 
                imgTag.className = "me-1";
                
                container.appendChild(imgTag);
                imageCount++;

                // 5개씩 이미지가 추가될 때마다 <br> 태그 추가
                if (imageCount > 0 && imageCount % 5 === 0) {
                    var breakTag = document.createElement("br");
                    container.appendChild(breakTag);
                }
            });
        }
});

// 수정 모달창 활성화 시 최초 페이지 요청 때 받은 DB 값으로 랜더링
document.getElementById('skillsAddForm').addEventListener('show.bs.modal', loadSkillsOnModal);

function loadSkillsOnModal() {
    for(var category in allSkills) {
        var skills = allSkills[category];

        skills.forEach(function(skill) {
            modalSetting(category, skill)
        });
    }
}

function modalSetting(section, value) {
    const skillsDiv = document.getElementById(`${section}Skills`);
    
    if (value) {
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
            updateChangedSkills(section, value, 'removed');
            skillsDiv.removeChild(container);
            el = `
                <option id="${value}" value="${value}">${value}</option>
            `
            $(`#${section}Select`).append(el)
        };

        btn.appendChild(closeIcon);

        container.appendChild(btn);

        // 컨테이너에 버튼 추가
        skillsDiv.appendChild(container);
        $(`#${value}`).remove()
    }
}

