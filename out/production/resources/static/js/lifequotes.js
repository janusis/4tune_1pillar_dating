const quotes = [{
    quote : "신은 죽었다.",
    author : "-니체-"
},
{
    quote : "제일 늦었다고 생각할 때가 늦었다. 그러니 당장 시작해라.",
    author : "-박명수-"
},
{
    quote : "티끌 모아 티끌",
    author : "-박명수-"
},
{
    quote : "어려운 길은 길이 아니다.",
    author : "-박명수-"
},
{
    quote : "즐길수 없으면 피해라.",
    author : "-박명수-"
},
{
    quote : "성공은 1%의 재능과 99%의 빽",
    author : "-박명수-"
},
{
    quote : "내일도 할 수 있는 일을 굳이 오늘 할 필요는 없다.",
    author : "-박명수-"
},
{
    quote : "가는 말이 고우면 얕본다",
    author : "-박명수-"
},
{
    quote : "고생 끝에 골병 난다",
    author : "-박명수-"
},
{
    quote : "결혼은 좋은 짝을 만나는 것이 아니라 좋은 짝이 되어 주는 것이다.",
    author : "-박명수-"
}
];

const randomQuote = quotes[Math.floor(Math.random()*quotes.length)];


const quote = document.querySelector("#quote span:first-child");
const author = document.querySelector("#quote span:last-child");

quote.innerText = randomQuote.quote;
author.innerText = randomQuote.author;


