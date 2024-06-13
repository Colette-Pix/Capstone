import data from "./data/aliensData3.js";

/**
 * This event listener waits for the DOM to be fully loaded,
 * then it adds a click event listener to the submit button.
 * When the submit button is clicked, it prevents the form from submitting and calls the displaySearchResults function.
 */
document.addEventListener("DOMContentLoaded", () => {
  const submitButton = document.getElementById("searchButton");
  submitButton.addEventListener("click", (event) => {
    event.preventDefault(); // Prevent form from submitting
    displaySearchResults(data);
  });
});

/**
 * This function displays the search results in a table.
 * It first clears any previous search results, then it creates a new table and adds it to the search results container.
 * It creates a table row for each item in the data array that matches the search criteria.
 *
 * @param {Array} data - The data to search through
 */
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