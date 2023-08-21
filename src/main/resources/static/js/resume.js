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


function toggleEditMode() {
    isEditMode = !isEditMode;
    let elements = document.querySelectorAll('.toggleMode');

    for (let element of elements) {
        if (!isEditMode) { 
            element.style.display = 'none';  
        } else { 
            element.style.display = '';  
        }
    }
    initEditMode();
}


function initEditMode() {
    // 기존 Sortable 인스턴스들 파괴
    for (let sortable of sortables) {
        sortable.destroy();
    }
    sortables = [];

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


$(document).ready(function() {
    $(".add-btn").on('click', function() {
        addCnt += 1
        if (addCnt >= 2) {
            return;
        }

        let tableBody = $(this).closest('tbody');
        let newRow = `
            <tr class="add-form">
                <td><input type="text" class="form-control"></td>
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

function add_cancle(event) {
    let clickedButton = event.target;
    let tableBody = $(clickedButton).closest('tbody');

    // 마지막에 추가한 행(입력 양식) 제거
    tableBody.find("tr").eq(-2).remove();

    // add-cell 클래스를 가진 셀의 내용(등록/취소 버튼) 비우기
    tableBody.find('.add-cell').empty();
    addCnt = 0;
}

function enroll(event) {
    let clickedButton = event.target;
    let tableBody = $(clickedButton).closest('tbody');
    let currentRow = $(clickedButton).closest('tr').prev();

    let values = [];
    currentRow.find("input[type='text']").each(function() {
        values.push($(this).val());
    });

    let tableID = currentRow.closest('tbody').attr('id'); // 예: "edu-table"

    console.log("Input values:", values);
    console.log("Table ID:", tableID);

    // ☆★☆★ tableID파싱한 값과 입력 값들로 Ajax-POST 통신코드 추가

    // 통신에서 받은 값으로 대체 
    testPK1 = 3
    testContent0 = values[0]
    testContent1 = values[1]
    testContent2 = values[2]
    testContent3 = values[3]
    testContent4 = values[4]
    let enrollContent = `
        <tr id="etcedu-${testPK1}"> 
            <td class="drag-handle ">${testContent0}</td>
            <td>${testContent1}</td>
            <td>${testContent2}</td>
            <td>${testContent3}</td>
            <td>${testContent4}</td>
            <td class="no-border"><span class="delete-btn">&#10006;</span></td>
        </tr>
    `            
    currentRow.before(enrollContent); 
    currentRow.remove();
    tableBody.find('.add-cell').empty();
    addCnt = 0;
}

$(document).ready(function() {
    initEditMode();
});
