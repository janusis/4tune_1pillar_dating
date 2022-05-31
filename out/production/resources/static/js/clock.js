//id를 이용해 element 검색
const clock = document.querySelector("h2#clock");


//interval
function getTime(){
    const date = new Date();
    const hours = String(date.getHours()).padStart(2,"0");
    const minutes = String(date.getMinutes()).padStart(2,"0");
    const seconds = String(date.getSeconds()).padStart(2,"0");

    clock.innerText = `${hours}:${minutes}:${seconds}`;
}

getTime();
setInterval(getTime,1000);