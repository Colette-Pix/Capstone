const canvas = document.getElementById('tetris');
const context = canvas.getContext('2d');

context.scale(40, 40);
// The snake object
// The snake object

const arena = createMatrix(12, 20);

const player = {
    pos: {x: 0, y: 0},
    matrix: null,
    score: 0,
};
// The initial state of the snake
const initialSnake = {
    pos: {x: arena[0].length / 2 | 0, y: arena.length / 2 | 0},
    dir: {x: 0, y: 1},
    body: [{x: arena[0].length / 2 | 0, y: arena.length / 2 | 0}],
};

// The snake object
let snake = {...initialSnake};

// Reset the snake to its initial state
// Reset the snake to its initial state
function resetSnake() {
    snake = JSON.parse(JSON.stringify(initialSnake));
}

let snakeSpeed= 200;
let snakeCounter= 0;
// Update the snake's position
// Update the snake's position
function updateSnake() {
    // Add the current position to the body
    snake.body.push({ ...snake.pos });

    // Update the position based on the direction
    snake.pos.x += snake.dir.x;
    snake.pos.y += snake.dir.y;

    // Wrap the position if it's outside the bounds of the arena
    if (snake.pos.x < 0) {
        snake.pos.x = arena[0].length - 1;
    } else if (snake.pos.x >= arena[0].length) {
        snake.pos.x = 0;
    }
    if (snake.pos.y < 0) {
        snake.pos.y = arena.length - 1;
    } else if (snake.pos.y >= arena.length) {
        snake.pos.y = 0;
    }

    // Check if the snake has collided with a Tetris piece
    if (collide(arena, { pos: snake.pos, matrix: [[1]] })) {
        // Remove the Tetris piece and add a new segment to the snake's body
        arena[snake.pos.y][snake.pos.x] = 0;
    } else {
        // If the snake hasn't eaten a Tetris piece, remove the oldest segment from the snake's body
        snake.body.shift();
    }

}

function checkForSnakeEating() {
    // Check if the snake has collided with a Tetris piece
    if (collide(arena, { pos: snake.pos, matrix: [[1]] })) {
        // Remove the Tetris piece and add a new segment to the snake's body
        arena[snake.pos.y][snake.pos.x] = 0;
    }


}

// Draw the snake
function drawSnake() {
    context.fillStyle = '#fAf8ff';
    snake.body.forEach(segment => {
        context.fillRect(segment.x, segment.y, 1, 1);
    });
}


function arenaSweep() {
    outer: for (let y = arena.length - 1; y > 0; --y) {
        for (let x = 0; x < arena[y].length; ++x) {
            if (arena[y][x] === 0) {
                continue outer;
            }
        }

        const row = arena.splice(y, 1)[0].fill(0);
        arena.unshift(row);
        ++y;

        player.score += 10;
        updateScore();
    }
}

function collide(arena, player) {
    const [m, o] = [player.matrix, player.pos];
    for (let y = 0; y < m.length; ++y) {
        for (let x = 0; x < m[y].length; ++x) {
            if (m[y][x] !== 0 &&
               (arena[y + o.y] &&
                arena[y + o.y][x + o.x]) !== 0) {
                return true;
            }
        }
    }
    return false;
}

function createMatrix(w, h) {
    const matrix = [];
    while (h--) {
        matrix.push(new Array(w).fill(0));
    }
    return matrix;
}

function createPiece(type)
{
    if (type === 'T') {
        return [
            [0, 0, 0],
            [1, 1, 1],
            [0, 1, 0],
        ];
    } else if (type === 'O') {
        return [
            [2, 2],
            [2, 2],
        ];
    } else if (type === 'L') {
        return [
            [0, 3, 0],
            [0, 3, 0],
            [0, 3, 3],
        ];
    } else if (type === 'J') {
        return [
            [0, 4, 0],
            [0, 4, 0],
            [4, 4, 0],
        ];
    } else if (type === 'I') {
        return [
            [0, 5, 0, 0],
            [0, 5, 0, 0],
            [0, 5, 0, 0],
            [0, 5, 0, 0],
        ];
    } else if (type === 'S') {
        return [
            [0, 6, 6],
            [6, 6, 0],
            [0, 0, 0],
        ];
    } else if (type === 'Z') {
        return [
            [7, 7, 0],
            [0, 7, 7],
            [0, 0, 0],
        ];
    }
      else if (type === 'C') {
      return [
             [8, 8, 8],
             [8, 0, 0],
             [8, 8, 8],
            ];
        }
}

function draw() {
    context.fillStyle = '#000';
    context.fillRect(0, 0, canvas.width, canvas.height);

    drawMatrix(arena, {x: 0, y: 0});
    drawMatrix(player.matrix, player.pos);

    drawSnake();
}

function drawMatrix(matrix, offset) {
    matrix.forEach((row, y) => {
        row.forEach((value, x) => {
            if (value !== 0) {
                context.fillStyle = colors[value];
                context.fillRect(x + offset.x,
                                 y + offset.y,
                                 1, 1);
            }
        });
    });
}

function merge(arena, player) {
    player.matrix.forEach((row, y) => {
        row.forEach((value, x) => {
            if (value !== 0) {
                arena[y + player.pos.y][x + player.pos.x] = value;
            }
        });
    });
}

function collideWithSnake(player) {
    const [m, o] = [player.matrix, player.pos];
    for (let y = 0; y < m.length; ++y) {
        for (let x = 0; x < m[y].length; ++x) {
            if (m[y][x] !== 0 &&
               (snake.body.some(segment => segment.x === x + o.x && segment.y === y + o.y))) {
                return true;
            }
        }
    }
    return false;
}

function playerDrop() {
    player.pos.y++;
    if (collide(arena, player) || collideWithSnake(player)) {
        player.pos.y--;
        merge(arena, player);
        playerReset();
        arenaSweep();
        updateScore();
    }
    dropCounter = 0;
}
function playerMove(dir) {
    player.pos.x += dir;
    if (collide(arena, player)) {
        player.pos.x -= dir;
    }
}

// Reset the player and the snake
function playerReset() {
    const pieces = 'TJLOSZIC';
    player.matrix = createPiece(pieces[pieces.length * Math.random() | 0]);
    player.pos.y = 0;
    player.pos.x = (arena[0].length / 2 | 0) -
                   (player.matrix[0].length / 2 | 0);
    if (collide(arena, player)) {
        arena.forEach(row => row.fill(0));
        player.score = 0;
        updateScore();
        resetSnake(); // Reset the snake
    }

}

function playerRotate(dir) {
    const pos = player.pos.x;
    let offset = 1;
    rotate(player.matrix, dir);
    while (collide(arena, player)) {
        player.pos.x += offset;
        offset = -(offset + (offset > 0 ? 1 : -1));
        if (offset > player.matrix[0].length) {
            rotate(player.matrix, -dir);
            player.pos.x = pos;
            return;
        }
    }
}

function rotate(matrix, dir) {
    for (let y = 0; y < matrix.length; ++y) {
        for (let x = 0; x < y; ++x) {
            [
                matrix[x][y],
                matrix[y][x],
            ] = [
                matrix[y][x],
                matrix[x][y],
            ];
        }
    }

    if (dir > 0) {
        matrix.forEach(row => row.reverse());
    } else {
        matrix.reverse();
    }
}

let dropCounter = 0;
let dropInterval = 1000;

let lastTime = 0;
function update(time = 0) {
    const deltaTime = time - lastTime;
    snakeCounter += deltaTime;
       if (snakeCounter > snakeSpeed) {
            updateSnake();

            snakeCounter = 0;
       }
    checkForSnakeEating();
    drawSnake();


    dropCounter += deltaTime;
    if (dropCounter > dropInterval) {
        playerDrop();
    }

    lastTime = time;

    draw();

    requestAnimationFrame(update);
}

function updateScore() {
    document.getElementById('score').innerText = player.score;

    // Check if the score has reached 30
    if (player.score >= 30) {
        // Display a message with the password
        alert('YOU HAVE REACHED THE REQUIRED POINT THRESHOLD.' +
         'ACCESS HAS BEEN GRANTED. THE PASSWORD IS: "PASSWORD"');
    }
}

const colors = [
    null,
    '#FF0D72',
    '#0DC2FF',
    '#0DFF72',
    '#F538FF',
    '#FF8E0D',
    '#FFE138',
    '#3877FF',
    '8b31ff'
];


document.addEventListener('keydown', event => {
    // Control the snake with the arrow keys
    if (event.key === 'ArrowUp') {
        snake.dir = {x: 0, y: -1};
    } else if (event.key === 'ArrowLeft') {
        snake.dir = {x: -1, y: 0};
    } else if (event.key === 'ArrowDown') {
        snake.dir = {x: 0, y: 1};
    } else if (event.key === 'ArrowRight') {
        snake.dir = {x: 1, y: 0};
    }

    // Control the Tetris pieces with 'W', 'A', 'S', and 'D'
    if (event.key === 'w'|| event.key === 'W') {
        playerRotate(-1);
    } else if (event.key === 'a' || event.key === 'A'){
        playerMove(-1);
    } else if (event.key === 's'|| event.key === 'S') {
        playerDrop();
    } else if (event.key === 'd'||  event.key === 'D') {
        playerMove(1);
    }
});




playerReset();
updateScore();
update();