
//투두 폼 태그 가져오기
const toDoForm = document.querySelector("form#todo-form");
//투두 폼에서 인풋 태그 가져오기
const toDoInput = toDoForm.querySelector("input");
//ul태그 이면서 id가 todo-list 인 태그 가져오기
const toDoList = document.querySelector("ul#todo-list");

let toDos = [];

const TODOS_STRING= "todos";


function saveToDo(){
    localStorage.setItem(TODOS_STRING,JSON.stringify(toDos));

}

//todo리스트 에서 삭제버튼을 클릭할 경우 호출 되어 그에 해당하는 내용 삭제하기
function deleteToDo(event) {
    const li = event.target.parentElement;
    li.remove();
    toDos = toDos.filter( (todo) => todo.id !== parseInt(li.id));
    saveToDo();


}


//ul 폼에 li 태그 추가 (todoList에 데이터 추가하기)
function paintToDo(toDo){
    //li 엘리먼트 생성
    const li = document.createElement("li");
    //li.id == string
    li.id= toDo.id;
    //li 엘리먼트 밑에 child로 만들 span 엘리먼트 생성
    const span = document.createElement("span");
    //li 엘리먼트 밑에 child로 만들 button 엘리먼트 생성
    const button = document.createElement("button");

    //버튼에 표시될 텍스트 작성
    button.className = "btn";
    button.innerText = "X";


    //li 엘리먼트에 span과 button을 자식으로 추가
    li.appendChild(span);
    li.appendChild(button);

    //span 엘리먼트의 내용을 파라미터로 받은 toDo로 변경
    span.innerText=toDo.text;
    //toDoList에  li 추가. li는 span과 button을 child로 가지고 있다.
    toDoList.appendChild(li);

    //버튼에서 클릭이벤트가 발생하면 delteToDo가 실행.
    button.addEventListener("click", deleteToDo);
}


//toDoForm의 Submit이 발생했을시 호출되는 함수
function toDoFormSubmit(event){
    //브라우저의 디폴트 새로고침 막고
    event.preventDefault();

    //인풋태그에 입력된 값을 newTodo에 저장
    const newTodo = toDoInput.value;

    const toDoObj = {
        id : Date.now(),
        text : newTodo
    }

    //toDoInput 폼을 비우고
    toDoInput.value="";
    //리스트에 todo 데이터 저장하고
    toDos.push(toDoObj);

    //localstorage에 todo데이터 저장
    saveToDo();

    //makeTodo를 실행
    paintToDo(toDoObj);
}

//todoform에서 submit이 일어났을 때 toDoFormSubmit 함수 실행
toDoForm.addEventListener("submit",toDoFormSubmit)

const savedToDos = localStorage.getItem(TODOS_STRING);


if(savedToDos !==null){
    const parsedToDos = JSON.parse(savedToDos);
    toDos = parsedToDos;
    parsedToDos.forEach(element => {
        paintToDo(element);
    });
}