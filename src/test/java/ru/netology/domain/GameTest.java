package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Vasya", 17);
    private Player player2 = new Player(2, "Kolya", 7);
    private Player player3 = new Player(3, "Pasha", 25);
    private Player player4 = new Player(4, "Svyatogor", 25);

    @BeforeEach
    void shouldRegisterAllPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

    }

    @Test
    void shouldShowResultIfPlayer1Wins() {
        assertEquals(1, game.round("Vasya", "Kolya"));
    }

    @Test
    void shouldShowResultIfPlayer2Wins() {
        assertEquals(2, game.round("Kolya", "Pasha"));
    }

    @Test
    void shouldShowResultWhenDraw() {
        assertEquals(0, game.round("Pasha", "Svyatogor"));
    }

    @Test
    void shouldThrowExceptionWhenPlayer1Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Dima", "Svyatogor"));
    }

    @Test
    void shouldThrowExceptionWhenPlayer2Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Svyatogor", "Roma"));
    }

    @Test
    void shouldThrowExceptionWhenPlayersBothUnregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Petya", "Artem"));
    }
}