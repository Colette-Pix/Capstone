import data from "./data/aliensData3.js";

/**
 * This function creates alien cards using the provided data.
 * It creates a new card for each item in the data array and adds it to the product grid.
 *
 * @param {Array} data - The data to create the alien cards from
 */
function createAlienCards(data) {
  const productGrid = document.getElementById("alienGrid");

  data.forEach((item) => {
    var bubble = document.createElement("div");
    bubble.className = "card";
    bubble.innerHTML = `
            <div class="image-container">
                <img src="${item.image}" alt="${item.name}">
            </div>
            <div class="details">
                <h3><u>${item.name}</u> [${item.job}]- <i>${item.status}</i></h3>
            </div>
        `;
    bubble.addEventListener("click", rainbow);
    bubble.addEventListener("click", randomColorChange);
    // Add event listener for navigation
    bubble.addEventListener("click", function() {
      // Store the name of the clicked alien in the session storage
      sessionStorage.setItem('alienName', item.name);
      window.location.href = `/ProfileView?name=${encodeURIComponent(item.name)}`;
    });
    productGrid.appendChild(bubble);
  });
}

/**
 * This event listener fetches the homecards data from the server when the DOM is fully loaded,
 * and then calls the createAlienCards function with the fetched data.
 */
document.addEventListener("DOMContentLoaded", () => {
  fetch('/api/homecards')
    .then(response => response.json())
    .then(data => createAlienCards(data));
});

/**
 * This function changes the box shadow color of the clicked element in a rainbow pattern.
 * The color changes every second for 10 seconds.
 */
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

/**
 * This function changes the background color of the clicked element to a random color.
 */
function randomColorChange() {
  this.style.backgroundColor = "rgba(" + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + ",.3)";
}