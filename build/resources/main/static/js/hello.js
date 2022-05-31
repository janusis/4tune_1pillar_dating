//login 폼 변수
const loginForm = document.querySelector("#login-form");
const logingFormInput = loginForm.querySelector("#login-form input");
const greeting = document.querySelector("#greeting");

//스트링 변수
const HIDDEN_STRING = "hidden";
const USERNAME_STRING = "username";

function loginSubmit(event){
    event.preventDefault();
    const username = logingFormInput.value;
    loginForm.classList.add(HIDDEN_STRING);
    localStorage.setItem(USERNAME_STRING, username);
    makeGreeting(username);
}

function makeGreeting(name){
    greeting.innerText =`환영합니다. ${name}님`;
    greeting.classList.remove(HIDDEN_STRING);
}



const savedUsername = localStorage.getItem(USERNAME_STRING);


if(savedUsername ===null){
    loginForm.classList.remove(HIDDEN_STRING);
    loginForm.addEventListener("submit" , loginSubmit);
    
}else{

    makeGreeting(savedUsername);
}























// -------------------------------------------------------------------------------------------------------------------------------------
// const player= {
//     name : "cino",
//     points : 10,
//     fat : true
// };

// const list = ["mon", "sat"];
// console.log(list);
// list.push("sun");
// console.log(list);
// console.log(player);
// console.log(player.name);
// player.name;


// -------------------------------------------------------------------------------


// function sayHello(name){
//     console.log("Hello my name is " + name);

// }

// sayHello("James");
// sayHello("Andy");
// sayHello("Maria");
// sayHello("Jim");
// sayHello("John");


// const player = {
//     name : "chino",
//     sayHello : function(name){
//         console.log("hello " + name);
//     }
// }


// player.sayHello("john");



// const five =5;
// let isNicoFat =true;                                                                            
// console.log(five); 


// const calculator = {
//     add: function(a,b){
//         return a+b;
//     },
//     minus : function(a,b){
//         return a-b;
//     },
//     divide : function(a,b){
//         return a/b;
//     },
//     powerOf : function(a,b){
//         return a**b;
//     }

// }

// const result = calculator.add(10,2);
// console.log(result);


// const age = parseInt(prompt('How old are u?'));

// if(isNaN(age) || age < 0){
//     console.log("Please write a positive number");
// }else if (age<18){
//     console.log("18down");
// }else if(age>=18 && age<=50){
//     console.log("18up 50down");
// }else if(age >50 && age<=80){
//     console.log("50up 80down");
// }else if(age === 100){
//     console.log("100up");
// }else  if(age > 80 ){
//     console.log("80up");
// }

// const h1 = document.getElementById("h1");
// h1.innerText = "Got you!";
// console.dir(h1.id);
// console.dir(h1.className);


// const h1 = document.querySelector(".hello h1");


// function clickHandler(){
//     h1.style.color="red";
// }

// function mouseEnterHandler(){
//     h1.innerText = "Mouse on!";
// }

// function mouseLeaveHandler(){
//     h1.innerText = "Mouse off!";
// }

// function windowResizeHandler(){
//     document.body.style.backgroundColor = "green";
// }

// function windowCopyHandler(){
//     alert("copy");
// }

// function windowOfflineHandler(){
//     alert("offline");
// }
// function windowOnlineHandler(){
//     alert("online");
// }

// h1.addEventListener("click", clickHandler);
// h1.addEventListener("mouseenter", mouseEnterHandler);
// h1.addEventListener("mouseleave", mouseLeaveHandler );

// window.addEventListener("resize", windowResizeHandler);
// window.addEventListener("copy", windowCopyHandler);
// window.addEventListener("offline", windowOfflineHandler);
// window.addEventListener("online", windowOnlineHandler);


// const h1 = document.querySelector(".hello h1");

// function clickHandler(){
//     const currentColor = h1.style.color;
//     let newColor;
//     if (currentColor === "blue"){
//         newColor = "tomato";
//     }else {
//         newColor = "blue";
//     }
//     h1.style.color = newColor;
// }

// function mouseEnterHandler(){
//     h1.innerText = "Mouse on!";
// }

// h1.addEventListener("click", clickHandler);


// const h1 = document.querySelector(".hello h1");

// function titleClickHandler(){
//     h1.classList.toggle("clicked");
// }

// h1.addEventListener("click", titleClickHandler);