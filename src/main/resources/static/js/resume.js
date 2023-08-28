let addCnt = 0
let isEditMode = false;
let sortables = [];

window.addEventListener('scroll', function() {
    let navbar = document.querySelector('.navbar');
    if (window.scrollY > 50) { 
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

// hedaer.jsp에서 편집모드 버튼 클릭 시, 호출되는 콜백 합수
function toggleEditMode() {
    isEditMode = !isEditMode;
    // toggleMode 클래스 태그 : +버튼 & 입력 Form
    let elements = document.querySelectorAll('.toggleMode');

    for (let element of elements) {
        if (!isEditMode) { 
            element.style.display = 'none';  
        } else { 
            element.style.display = '';  
        }
    }
    // 편집 모드 버튼 토클에서, layout을 확인하는 상황에서는 row이동을 하지 못하게 진행
    // 기존 Sortable를 파괴하고 if문을 타지 않음
    initEditMode();
}


function initEditMode() {
    // 기존 Sortable 인스턴스들 파괴
    for (let sortable of sortables) {
        sortable.destroy();
    }
    sortables = [];

    // 편집 모드에서 기능을 명시하여 Sortable 생성 
    if (isEditMode) {
        document.querySelectorAll('.sortableTable tbody').forEach(function(tbody) {
            let sortable = new Sortable(tbody, {
                handle: '.drag-handle',  
                animation: 500,
                filter: '.no-drag', 
                
                onMove: function (evt, originalEvent) {
                    var nextItem = evt.related; 
                    if ($(nextItem).hasClass('no-border') || $(nextItem).hasClass('table-secondary') || $(nextItem).hasClass('add-row') || $(nextItem).hasClass('add-form')) {
                        return false;  // 드래그 이동 취소
                    }
                },
                
                // 드래그 이벤트가 끝난 후에 실행되는 코드
                onEnd: function(evt) {
                    const tbody = evt.from;
                    const tbodyID = tbody.getAttribute('id');
                    const rows = tbody.querySelectorAll('tr:not(:nth-child(1)):not(:nth-child(2)):not(:last-child):not(.add-form)');
                    
                    let rowPKs = [];
                    rows.forEach(row => {
                        const rowID = row.getAttribute('id');
                        rowPK = rowID.split('-')[1]
                        if (rowID) {
                            rowPKs.push(rowPK);
                        }
                    });

                    console.log(`Tbody ID: ${tbodyID}`);
                    console.log('Row IDs:', rowPKs);

                    // ☆★☆★ PK의 순서를 리스트에 담고, Ajax-UPDATE 통신
                    // - 순서 필드를 만들어서, 해당 필드 update
                    // - 화면에 뿌릴 때는 순서 필드로 정렬
                    // - 화면에 reload할 필요 없음
                }
                    });
        
                sortables.push(sortable);
        });
    }
}

function createDateInput() {
    return '<input type="date" class="form-control" style="width: 135px; display: inline-block;">';
}

// 단순히 onclick 속성은 onclick 속성은 HTML 요소가 브라우저에 로드될 때에 해당 요소에 바인딩되며,
// HTML 페이지가 처음 로딩될 때 HTML 소스 코드에 정의된 onclick 속성을 가진 요소만 해당 자바스크립트 함수에 바인딩 됨
// -> 따라서, 추가한 Row에도 여러 이벤트를 적용하기 위해 이벤트 위임 개념과 ready와 .on() 활용 (해당 과정 추가 블로깅)
$(document).ready(function() {

    // + 버튼 클릭 시, 입력 Form 출력
    $(".add-btn, .edu-add-btn").on('click', function() {
        addCnt += 1
        if (addCnt >= 2) {
            return;
        }

        let tableBody = $(this).closest('tbody');
        let isSchoolEdu = $(this).hasClass('edu-add-btn');
        let dateInputs = isSchoolEdu ? createDateInput() + '&nbsp ~ &nbsp' + createDateInput() : createDateInput();

        let newRow = `
            <tr class="add-form toggleMode">
                <td>
                    ${dateInputs}
                </td>
                <td><input type="text" class="form-control"></td>
                <td><input type="text" class="form-control"></td>
                <td><input type="text" class="form-control"></td>
                <td><input type="text" class="form-control"></td>
                <td class="no-border">
                    
                </td>
            </tr>
        `;
        let newBtn = `
        <button class="btn btn-outline-primary submit-btn" onclick="enroll(event)">등록</button>
        <button class="btn btn-outline-danger submit-btn" onclick="add_cancle(event)">취소</button>
        `                
        $(newRow).insertBefore(tableBody.find('.add-row'));
        $(newBtn).appendTo(tableBody.find('.add-cell'));
    });

    // 각 Row 마우스 올리면 css 효과 & 삭제 버튼 show
    $(".sortableTable tbody").on('mouseenter', 'tr:not(.table-secondary, .no-border, .add-row, .add-form)', function() {
        if (isEditMode){
            $(this).addClass('highlighted-row');
            $(this).find('.delete-btn').show();
        }
    }).on('mouseleave', 'tr:not(.table-secondary, .no-border, .add-row)', function() {
        if (isEditMode){
            $(this).removeClass('highlighted-row');
            $(this).find('.delete-btn').hide();
        }
    });

    // x 버튼 클릭 시 삭제 진행
    $(".sortableTable").on('click', 'tbody tr .delete-btn', function() {
        let tr = $(this).closest('tr');
        let trID = tr.attr('id');  // 예: "edu-1"
    
        if(trID) {
            let parts = trID.split('-');  // ["edu", "1"]
            let path = parts[0];          // "edu"
            let pkValue = parts[1];       // "1"
            
            // ☆★☆★ path, pkValue로 Ajax-DELETE 통신코드 추가
    
            tr.remove();
        }
    });
    
});

// 값 입력 후 등록 버튼 클릭 시, 입력 Form & 등록 버튼 & 취소 버튼 없애기
function add_cancle(event) {
    let clickedButton = event.target;
    let tableBody = $(clickedButton).closest('tbody');

    // 마지막에 추가한 행(입력 양식) 제거
    tableBody.find("tr").eq(-2).remove();

    // add-cell 클래스를 가진 셀의 내용(등록/취소 버튼) 비우기
    tableBody.find('.add-cell').empty();
    addCnt = 0;
}

// 등록 버튼 클릭 시, AJAX 통신 후, 등록 값 랜더링
function enroll(event) {
    const jwtToken = localStorage.getItem('jwtToken'); 

    let clickedButton = event.target;
    let tableBody = $(clickedButton).closest('tbody');
    let currentRow = $(clickedButton).closest('tr').prev();
    let values = [];
    currentRow.find("input[type='date']").each(function() {
        values.push($(this).val());
    });
    currentRow.find("input[type='text']").each(function() {
        values.push($(this).val());
    });
    let tableID = currentRow.closest('tbody').attr('id'); // 예: "edu-table"

    let payload = {
        values: values 
    };

    $.ajax({
        type: "POST",
        url: `/auth/resume/${tableID}`,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        headers: {
            'Authorization': jwtToken 
        },
        data: JSON.stringify(payload),
        
        success: function(response) {
            console.log(response)
            
            const enrollContent = renderRow(tableID, response.data);
            currentRow.before(enrollContent); 
            currentRow.remove();
            tableBody.find('.add-cell').empty();
            addCnt = 0;
        },
        error: function(error) {
            console.log(error)
            
        }
    });

    function renderRow(tableID, data) {
        if (tableID === 'schooledu') {
          return `
            <tr id="${tableID}-${data.id}"> 
                <td class="drag-handle ">${data.schoolAdmissionDate} ~ ${data.schoolGraduateDate}</td>
                <td>${data.schoolGraduateStatus}</td>
                <td>${data.schoolName}</td>
                <td>${data.schoolMajor}</td>
                <td>${data.schoolCredit}</td>
                <td class="no-border"><span class="delete-btn">&#10006;</span></td>
            </tr>
          `;
        } else if (tableID === 'academyedu') {
          return `
            

          `;
        } else if (tableID === 'certificate') {
          return `
            

          `;
        } else if (tableID === 'selfstudy') {
          return `
            

          `;
        }
   
      }
}

$(document).ready(function() {
    initEditMode();
});
