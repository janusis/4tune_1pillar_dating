
const API_KEY = "3c8786f1e91b8471b09bf9ad68dca10c";

function onGeoSuccess(location){
    const latitude = location.coords.latitude;
    const longitude = location.coords.longitude;
    const url =`https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${API_KEY}&units=metric`;
    fetch(url).then(response => response.json()).then(data=>{
        const cityTag = document.querySelector("div#weather span:first-child");
        const weatherTag = document.querySelector("div#weather span:last-child");
        const city = data.name;
        const weather = data.weather[0].main;
        cityTag.innerText = city;
        weatherTag.innerText = weather;
    });
}

function onGeoFailed(){
    alert("위치를 찾을 수 없습니다.");
}




navigator.geolocation.getCurrentPosition(onGeoSuccess,onGeoFailed);