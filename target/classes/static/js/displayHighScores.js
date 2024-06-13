window.addEventListener('load', function() {
    fetch('/api/gameData')
    .then(response => response.json())
    .then(gameData => {
        const highScoresList = document.createElement('ul');
        gameData.forEach(data => {
            const listItem = document.createElement('li');
            listItem.textContent = `${data.name}: ${data.highScore}`;
            highScoresList.appendChild(listItem);
        });
        // Select the div with the displayHighScores class
        const displayHighScoresDiv = document.querySelector('.displayHighScores');
        // Append the high scores list to the div
        displayHighScoresDiv.appendChild(highScoresList);
    });
}); 