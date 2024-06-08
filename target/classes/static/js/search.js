import data from "./data/aliensData3.js";

document.addEventListener("DOMContentLoaded", () => {
  const submitButton = document.getElementById("searchButton");
  submitButton.addEventListener("click", (event) => {
    event.preventDefault(); // Prevent form from submitting
    displaySearchResults(data);
  });
});

function displaySearchResults(data) {
  console.log("displaySearchResults");
  var searchResultsContainer = document.getElementById("searchResultsContainer");
  
  // Clear previous search results
  searchResultsContainer.innerHTML = ""; 


  var searchResults = document.createElement("table");
  searchResults.className = "result-table";

  console.log("1");

  // Create table header
  const tableHeader = document.createElement("thead");
  const headerRow = document.createElement("tr");
  headerRow.innerHTML = `
    <th>Name</th>
    <th>Job</th>
    <th>Status</th>
    <th>Resonance</th>
  `;
  tableHeader.appendChild(headerRow);
  searchResults.appendChild(tableHeader);
  console.log("2");

  var nameOfAlien = document.getElementById("nameOfAlien").value.toLowerCase();
  console.log("nameOfAlien:" + nameOfAlien);


  const tableBody = document.createElement("tbody");
  data.forEach((item) => {
    console.log(item.name);
    if (item.name.toLowerCase().includes(nameOfAlien)) {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${item.name}</td>
        <td>${item.job}</td>
        <td>${item.status}</td>
        <td>${item.resonance}</td>
      `;
      tableBody.appendChild(row);
    }
  });
  
  searchResults.appendChild(tableBody);

  searchResultsContainer.appendChild(searchResults);
}
