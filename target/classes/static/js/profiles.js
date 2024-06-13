/**
 * This function creates alien profile cards using the provided data.
 * It creates a new card for each item in the data array and adds it to the product grid.
 *
 * @param {Array} data - The data to create the alien cards from
 */
function createAlienCards(data) {
  const productGrid = document.getElementById("alienGrid");

  var title= document.getElementById("title");
  data.forEach((item) => {
    title.innerHTML = item.name;
    var bubble = document.createElement("div");
    bubble.className = "card";
    bubble.innerHTML = `
            <div class="image-container">
                <img src="${item.image}" alt="${item.name}">
            </div>
            <div class="details">
                <h3> <u>${item.headline}</u> <i>${item.message}</i></h3>
            </div>
        `;
    bubble.addEventListener("click", rainbow);
    bubble.addEventListener("click", randomColorChange);
    productGrid.appendChild(bubble);
  });
}

/**
 * This event listener fetches the profile data from the server when the DOM is fully loaded,
 * and then calls the createAlienCards function with the fetched data.
 */
document.addEventListener("DOMContentLoaded", () => {
  const alienName = sessionStorage.getItem("alienName");
fetch(`/getProfilesData?name=${encodeURIComponent(alienName)}`)
  .then(response => {
    if (!response.ok) {
      // If the response is not ok, print out the response body as text
      console.log("Error: not a json response");
      response.text().then(text => console.log(text));
    } else {
      // If the response is ok, parse it as JSON
            console.log(" a json response");
      response.json().then(data => {
        console.log("json response:" + data); // Print out the returned data
        createAlienCards(data);
      });
    }
  });
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