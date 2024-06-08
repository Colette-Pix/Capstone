import data from "./data/aliensData3.js";
//needs AI plugin so aliens can talk to you
function createAlienCards(data) {
  const productGrid = document.getElementById("alienGrid");

  data.forEach((item) => {
    var bubble = document.createElement("div");
    bubble.className = "card";
    bubble.innerHTML = `
            <div class="image-container">
                <img src="${item.img}" alt="${item.name}">
            </div>
            <div class="details">
                <h3><u>${item.name}</u> [${item.job}]- <i>${item.status}</i></h3>
            </div>
        `;
    bubble.addEventListener("click", rainbow);
    bubble.addEventListener("click", randomColorChange);
    productGrid.appendChild(bubble);
  });
}

document.addEventListener("DOMContentLoaded", () => {
  createAlienCards(data);
});


function rainbow() {
  const colors = new Array("225, 0, 0, 0.5", "0,255,0,0.5", "0,0,255,0.5");
  let i = 0;

  const intervalId = setInterval(() => {
    this.style.boxShadow = "0 0 50px 30px rgba(" + colors[i] + ")";
    i = (i + 1) % colors.length;
  }, 1000); 

 
  setTimeout(() => {
    clearInterval(intervalId);
  }, 10000);
}

function randomColorChange() {
  this.style.backgroundColor = "rgba(" + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + ",.3)";
}