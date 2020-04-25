const ON_STARTING = 0;
const ON_PLAYING = 1;
const ON_OVER = 2;
const ON_PAUSE = 3;

class Tetromino {
    constructor(row, col, angle = 0) {
        this.row = row;
        this.col = col;
        this.angle = angle;
        this.fall = function () {
            this.row += 1;
        };
        this.rotate = function () {
            if (this.angle === 3) {
                this.angle = 0;
            } else {
                this.angle += 1
            }
        }
    }

    get shape() {
        return this.shapes[this.angle];
    }

    get height() {
        return this.shape.length;
    }

    get width() {
        return this.shape[0].length;
    }
}

class LShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);
        this.shapes =
            [[[1, 0],
                [1, 0],
                [1, 1]],

                [[1, 1, 1],
                    [1, 0, 0]],

                [[1, 1],
                    [0, 1],
                    [0, 1]],

                [[0, 0, 1],
                    [1, 1, 1]]];
        this.color = 'rgb(255, 87, 34)';
    }
}

class JShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);
        this.shapes =
            [[[0, 2],
                [0, 2],
                [2, 2]],

                [[2, 0, 0],
                    [2, 2, 2]],

                [[2, 2],
                    [2, 0],
                    [2, 0]],

                [[2, 2, 2],
                    [0, 0, 2]]];

        this.color = 'rgb(63, 81, 181)';
    }
}

class OShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);
        this.shapes =
            [[[3, 3],
                [3, 3]],

                [[3, 3],
                    [3, 3]],

                [[3, 3],
                    [3, 3]],

                [[3, 3],
                    [3, 3]]];

        this.color = 'rgb(255, 235, 59)';
    }
}

class TShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);
        this.shapes =
            [[[0, 4, 0],
                [4, 4, 4]],

                [[4, 0],
                    [4, 4],
                    [4, 0]],

                [[4, 4, 4],
                    [0, 4, 0]],

                [[0, 4],
                    [4, 4],
                    [0, 4]]];
        this.color = 'rgb(156, 39, 176)';
    }
}

class SShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);


        this.shapes =
            [[[0, 5, 5],
                [5, 5, 0]],

                [[5, 0],
                    [5, 5],
                    [0, 5]],

                [[0, 5, 5],
                    [5, 5, 0]],

                [[5, 0],
                    [5, 5],
                    [0, 5]]];

        this.color = 'rgb(76, 175, 80)';
    }
}

class ZShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);
        this.shapes =
            [[[6, 6, 0],
                [0, 6, 6]],

                [[0, 6],
                    [6, 6],
                    [6, 0]],

                [[6, 6, 0],
                    [0, 6, 6]],

                [[0, 6],
                    [6, 6],
                    [6, 0]]];

        this.color = 'rgb(183, 28, 28)';
    }
}

class IShape extends Tetromino {
    constructor(row, col, angle = 0) {
        super(row, col, angle);

        this.shapes =
            [[[7],
                [7],
                [7],
                [7]],

                [[7, 7, 7, 7]],

                [[7],
                    [7],
                    [7],
                    [7]],

                [[7, 7, 7, 7]]];

        this.color = 'rgb(0, 188, 212)';
    }
}

class Game {
    constructor() {
        this.canvas = document.getElementById("tetrisGame");
        this.context = this.canvas.getContext("2d");
        this.score = 0;
        this.status = ON_STARTING;
        this.gameBoardWidth = 10;
        this.gameBoardHeight = 23;
        this.currentBoard = new Array(this.gameBoardHeight).fill(0).map(() => new Array(this.gameBoardWidth).fill(0));
        this.landedBoard = new Array(this.gameBoardHeight).fill(0).map(() => new Array(this.gameBoardWidth).fill(0));
        this.randomTetromino = function () {
            const tetroNum = Math.floor(Math.random() * 7);
            switch (tetroNum) {
                case 0:
                    return new LShape(1, 4);
                case 1:
                    return new JShape(1, 4);
                case 2:
                    return new OShape(2, 4);
                case 3:
                    return new TShape(2, 4);
                case 4:
                    return new SShape(2, 4);
                case 5:
                    return new ZShape(2, 4);
                case 6:
                    return new IShape(0, 4);
            }
        };
        this.afterTetromino = this.randomTetromino();
        this.currentTetromino = this.randomTetromino();
    }

    draw() {
        const blockSize = 24;
        const padding = 4;
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
        this.context.lineWidth = 2;
        this.context.fillStyle = "rgb(0, 0, 0)";
        this.context.rect(padding, padding, blockSize * this.gameBoardWidth + padding * (this.gameBoardWidth + 1), blockSize * (this.gameBoardHeight - 3) + padding * (this.gameBoardHeight - 3 + 1));
        this.context.stroke();
        for (let i = 3; i < this.gameBoardHeight; i++) {
            for (let j = 0; j < this.gameBoardWidth; j++) {
                if (this.currentBoard[i][j] !== 0) {
                    this.context.fillStyle = "rgb(0, 0, 0)";
                    for (let k = 0; k < this.currentTetromino.height; k++) {
                        for (let f = 0; f < this.currentTetromino.width; f++) {
                            if (this.currentTetromino.shape[k][f] !== 0) {
                                if ((k + this.currentTetromino.row == i) && (this.currentTetromino.col + f == j)) {
                                    this.context.fillStyle = this.currentTetromino.color;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    this.context.fillStyle = 'rgb(248, 248, 248)'
                }
                this.context.fillRect(padding * 2 + j * (blockSize + padding), padding * 2 + (i - 3) * (blockSize + padding), blockSize, blockSize);
            }
        }
        for (let k = 0; k < this.afterTetromino.height; k++) {
            for (let f = 0; f < this.afterTetromino.width; f++) {
                this.context.fillStyle = 'rgb(248, 248, 248)';
                if (this.afterTetromino.shape[k][f] !== 0) {
                    this.context.fillStyle = this.afterTetromino.color;
                }
                this.context.fillRect(padding * 2 + f * (blockSize + padding) + 300, padding * 2 + k * (blockSize + padding) + 40, blockSize, blockSize);
            }
        }
        this.context.fillStyle = "black";
        this.context.font = "20px Arial";
        this.context.fillText("NEXT :", 300, 28);
        this.context.fillText("SCORE:", 300, 200);
        this.context.fillText(this.score.toString(), 300, 230);
        if (this.status == ON_STARTING) {
            this.context.fillText("Press any key to start!", 50, 200);
        } else if (this.status == ON_PAUSE) {
            this.context.fillText("Press SPACE to start!", 50, 200);
            this.context.font = "30px Arial";
            this.context.fillText("PAUSED", 80, 250);
        } else if (this.status == ON_OVER) {
            this.context.fillText("Press ENTER to start!", 50, 200);
            this.context.font = "30px Arial";
            this.context.fillText("GAME OVER", 50, 250);
        }
    };

    progres() {

        let nextTetromino = new this.currentTetromino.constructor(this.currentTetromino.row + 1, this.currentTetromino.col, this.currentTetromino.angle);

        if ((!this.bottomOverlapped(nextTetromino)) && (!this.landedOverlapped(nextTetromino))) {
            this.currentTetromino.fall();
        } else {
            this.mergeCurrentTetromino();
            this.currentTetromino = new this.afterTetromino.constructor(this.afterTetromino.row, this.afterTetromino.col, this.afterTetromino.angle);
            this.afterTetromino = this.randomTetromino();
        }
    };

    bottomOverlapped(tetromino) {
        if (tetromino.row + tetromino.height > this.gameBoardHeight) {
            return true;
        } else return false;
    }

    landedOverlapped(tetromino) {
        for (let i = 0; i < tetromino.height; i++) {
            for (let j = 0; j < tetromino.width; j++) {
                if ((tetromino.shape[i][j] > 0) && (this.landedBoard[tetromino.row + i][tetromino.col + j] > 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    leftOverlapped(tetromino) {
        if (tetromino.col < 0) {
            return true;
        } else return false;
    }

    rightOverlapped(tetromino) {
        if (tetromino.col + tetromino.width > this.gameBoardWidth) {
            return true;
        } else return false;
    }

    updateCurrentBoard() {
        for (let i = 0; i < this.gameBoardHeight; i++) {
            for (let j = 0; j < this.gameBoardWidth; j++) {
                this.currentBoard[i][j] = this.landedBoard[i][j];
            }
        }
        for (let i = 0; i < this.currentTetromino.height; i++) {
            for (let j = 0; j < this.currentTetromino.width; j++) {
                if (this.currentTetromino.shape[i][j] > 0) {
                    this.currentBoard[this.currentTetromino.row + i][this.currentTetromino.col + j] = this.currentTetromino.shape[i][j];
                }
            }
        }
    };

    checkEarnPoint() {
        this.rowGetPoint = [];
        for (let i = this.currentTetromino.row + this.currentTetromino.height - 1; i >= this.currentTetromino.row; i--) {
            let status = true;
            for (let j = 0; j < this.gameBoardWidth; j++) {
                if (this.landedBoard[i][j] == 0) {
                    status = false;
                    break;
                }
            }
            if (status == true) {
                this.rowGetPoint.push(i);

            }
        }
        if (this.rowGetPoint.length > 0) {
            return true;
        } else
            return false;
    }

    mergeCurrentTetromino() {
        for (let i = 0; i < this.currentTetromino.height; i++) {
            for (let j = 0; j < this.currentTetromino.width; j++) {
                if (this.currentTetromino.shape[i][j] > 0) {
                    this.landedBoard[this.currentTetromino.row + i][this.currentTetromino.col + j] = this.currentTetromino.shape[i][j];
                }
            }
        }
        while (this.checkEarnPoint()) {

            this.updateLandedBoardAfterGetPoint();
            this.score++;
        }
        if ((this.landedBoard[3][4]) || (this.landedBoard[3][5]) || (this.landedBoard[3][6])) {
            clearInterval(this.playing);
            this.status = ON_OVER;
            this.draw();
        }
    }

    showRowGetPoint() {

    }

    updateLandedBoardAfterGetPoint() {
        for (let i = this.rowGetPoint[0]; i > 0; i--) {
            for (let j = 0; j < this.gameBoardWidth; j++) {

                this.landedBoard[i][j] = this.landedBoard[i - 1][j]

            }
        }
    }

    tryRotating() {
        let nextTetromino = new this.currentTetromino.constructor(this.currentTetromino.row, this.currentTetromino.col, this.currentTetromino.angle);
        nextTetromino.rotate();
        if (!this.rightOverlapped(nextTetromino) && (!this.landedOverlapped(nextTetromino)) && (!this.bottomOverlapped(nextTetromino))) {
            this.currentTetromino.rotate();
            this.updateCurrentBoard();
            this.draw();
        }
    }

    tryMoveLeft() {
        let nextTetromino = new this.currentTetromino.constructor(this.currentTetromino.row, this.currentTetromino.col - 1, this.currentTetromino.angle);
        if (!this.leftOverlapped(nextTetromino) && (!this.landedOverlapped(nextTetromino))) {
            this.currentTetromino.col -= 1;
            this.updateCurrentBoard();
            this.draw()
        }
    }

    tryMoveRight() {
        let nextTetromino = new this.currentTetromino.constructor(this.currentTetromino.row, this.currentTetromino.col + 1, this.currentTetromino.angle);
        if (!this.rightOverlapped(nextTetromino) && (!this.landedOverlapped(nextTetromino))) {
            this.currentTetromino.col += 1;
            this.updateCurrentBoard();
            this.draw()
        }
    }

    tryMoveDown() {
        this.progres();
        this.updateCurrentBoard();
        this.draw()
    }

    pause() {
        if (this.status == ON_PLAYING) {
            clearInterval(this.playing);
            this.status = ON_PAUSE;
            this.draw();
        } else if (this.status == ON_PAUSE) {
            this.playing = setInterval(() => {
                this.play();
            }, 800);
            this.status = ON_PLAYING;
        }
    }

    play() {
        this.progres();
        this.updateCurrentBoard();
        this.draw();
    }

    onkeyEvent() {
        window.addEventListener("keydown", (event) => {
            if (this.status == ON_STARTING) {
                this.status = ON_PLAYING;
                this.playing = setInterval(() => {
                    this.play();
                }, 800);
            } else if (this.status == ON_PLAYING) {
                this.keyonGame(event.keyCode);
            } else if (this.status == ON_PAUSE) {
                if (event.keyCode == 32) {
                    this.keyonGame(event.keyCode);
                }

            } else if (this.status == ON_OVER) {
                if (event.keyCode == 13) {
                    location.reload();
                }
            }
        });
    }

    keyonGame(key) {
        switch (key) {

            case 37: // Left
                this.tryMoveLeft();
                break;
            case 38: // Up
                this.tryRotating();
                break;
            case 39: // Right
                this.tryMoveRight();
                break;
            case 40: // Down
                this.tryMoveDown();
                break;
            case 32://Pause
                this.pause();
                break;
        }
    }
}

function loadGame() {
    let game = new Game();
    game.draw();
    game.onkeyEvent();
}

