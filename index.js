console.log("JS 연결");

// 반복으로 돌아갈 아이템 목록
let itemList = ["🍒","🍋","💎","🥇","7️⃣"];

// html 태그를 변수에 저장
const item1 = document.getElementById("item1");
const item2 = document.getElementById("item2");
const item3 = document.getElementById("item3");

const result = document.getElementById("result");

// 게임이 실행중인지 확인(중복 실행 방지)
let isPlaying = false;

function game_start(){
  console.log("game_start 함수 실행");

  console.log("isPlaying"+isPlaying)

  // 게임이 이미 실행중인 경우 함수 종료
  if(isPlaying){
    alert("현재 실행중인 게임이 있습니다!")
    return;
  }

  isPlaying = true;


  // 랜덤 아이템 출력 함수, 종료 시간 차이를 두고 실행
  const item1Interval = setInterval(() => game_set(item1,itemList),200);
  const item2Interval = setInterval(() => game_set(item2,itemList),200);
  const item3Interval = setInterval(() => game_set(item3,itemList),200);

  setTimeout(() => clearInterval(item1Interval),1000);
  setTimeout(() => clearInterval(item2Interval),1400);
  setTimeout(() => clearInterval(item3Interval),1800);

  // 결과를 출력하는 함수
  setTimeout(() => {
    console.log("결과 함수 실행");
    const item1Value = item1.innerText;
    const item2Value = item2.innerText;
    const item3Value = item3.innerText;

    const uniqueItems = new Set([item1Value,item2Value,item3Value]).size;

    if(uniqueItems === 1){
      result.innerText = "✨잭팟!";
    }else if(uniqueItems === 2){
      result.innerText = "🙄아깝다!";
    }else{
      result.innerText = "💥꽝";
    }

    isPlaying = false;
  },1801);


}


// setInterval로 반복할 함수 (데이터 값 바꾸기)
function game_set(item, itemList){

  // 0~4 사이의 랜덤한 정수값을 반환, 이를 itemList의 배열과 매칭하여 텍스트를 변경
  item.innerText = itemList[Math.floor(Math.random() * (5-0)+0)];

}