package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Game;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Vasya", 17);
    private Player player2 = new Player(2, "Kolya", 7);
    private Player player3 = new Player(3, "Pasha", 25);
    private Player player4 = new Player(4, "Svyatogor", 25);

    @BeforeEach
    void shouldRegisterAllPlayers() {
        game.registerAll(List.of(player1, player2, player3, player4));
    }

    @Test
    void shouldFindAllRegisteredPlayers() {
        assertEquals(List.of(player1, player2, player3, player4), game.findAll());
    }

    @Test
    void shouldFindByNameWhenRegister() {
        assertEquals(player3, game.findByName("Pasha"));
    }

    @Test
    void shouldReturnNullWhenNotRegister() {
        assertNull(game.findByName("Kostya"));
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