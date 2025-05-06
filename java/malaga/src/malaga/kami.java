package malaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class kami extends JPanel implements ActionListener, KeyListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 50;
    private static final int BULLET_SIZE = 5;
    private static final int ENEMY_SIZE = 50;
    private static final int PLAYER_SPEED = 10;
    private static final int BULLET_SPEED = 7;
    private static final int BASE_ENEMY_SPEED = 2;  // Velocidad base para los enemigos

    private Timer timer;
    private Rectangle player;
    private List<Rectangle> bullets;
    private List<Rectangle> enemies;
    private List<Rectangle> chasingEnemies;
    private boolean moveLeft, moveRight, shoot;
    private Random random;
    private List<Integer> enemySpeeds;

    public kami() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        random = new Random();  // Inicializa el objeto Random aquí
        initGame();
        timer = new Timer(16, this);
        timer.start();
    }

    private void initGame() {
        player = new Rectangle(WIDTH / 2 - PLAYER_SIZE / 2, HEIGHT - 50, PLAYER_SIZE, PLAYER_SIZE);
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        chasingEnemies = new ArrayList<>();
        enemySpeeds = new ArrayList<>();
        createEnemies();
    }

    private void createEnemies() {
        enemies.clear();
        enemySpeeds.clear();
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                int x = col * (ENEMY_SIZE + 10) + 50;
                int y = row * (ENEMY_SIZE + 10) + 50;
                enemies.add(new Rectangle(x, y, ENEMY_SIZE, ENEMY_SIZE));
                // Añade una velocidad inicial para cada enemigo
                enemySpeeds.add(BASE_ENEMY_SPEED);
            }
        }
        selectChasingEnemies();  // Selecciona aleatoriamente 5 enemigos para que persigan al jugador
    }

    private void selectChasingEnemies() {
        chasingEnemies.clear();
        List<Rectangle> availableEnemies = new ArrayList<>(enemies);
        for (int i = 0; i < 5; i++) {
            if (availableEnemies.isEmpty()) break;
            int index = random.nextInt(availableEnemies.size());
            Rectangle enemy = availableEnemies.remove(index);
            chasingEnemies.add(enemy);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fill(player);
        g2d.setColor(Color.WHITE);
        for (Rectangle bullet : bullets) {
            g2d.fill(bullet);
        }
        g2d.setColor(Color.RED);
        for (Rectangle enemy : enemies) {
            g2d.fill(enemy);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveLeft) {
            player.x -= PLAYER_SPEED;
            if (player.x < 0) player.x = 0;
        }
        if (moveRight) {
            player.x += PLAYER_SPEED;
            if (player.x + PLAYER_SIZE > WIDTH) player.x = WIDTH - PLAYER_SIZE;
        }
        if (shoot) {
            bullets.add(new Rectangle(player.x + PLAYER_SIZE / 2 - BULLET_SIZE / 2, player.y - BULLET_SIZE, BULLET_SIZE, BULLET_SIZE));
            shoot = false;
        }
        moveBullets();
        moveEnemies();
        detectCollisions();
        repaint();
    }

    private void moveBullets() {
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Rectangle bullet = bullets.get(i);
            bullet.y -= BULLET_SPEED;
            if (bullet.y < 0) {
                bullets.remove(i);
            }
        }
    }

    private void moveEnemies() {
        for (int i = 0; i < enemies.size(); i++) {
            Rectangle enemy = enemies.get(i);
            int speed = enemySpeeds.get(i);
            if (chasingEnemies.contains(enemy)) {
                // Moverse hacia el jugador
                if (enemy.x < player.x) {
                    enemy.x += BASE_ENEMY_SPEED;
                } else if (enemy.x > player.x) {
                    enemy.x -= BASE_ENEMY_SPEED;
                }

                if (enemy.y < player.y) {
                    enemy.y += BASE_ENEMY_SPEED;
                }
            } else {
                // Movimiento horizontal
                enemy.x += speed;
                if (enemy.x < 0 || enemy.x + ENEMY_SIZE > WIDTH) {
                    // Cambiar dirección al chocar con los bordes
                    enemySpeeds.set(i, -speed);
                    enemy.y += ENEMY_SIZE / 2;  // Mover hacia abajo cuando rebota
                }
            }
        }
    }

    private void detectCollisions() {
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Rectangle bullet = bullets.get(i);
            for (int j = enemies.size() - 1; j >= 0; j--) {
                Rectangle enemy = enemies.get(j);
                if (bullet.intersects(enemy)) {
                    bullets.remove(i);
                    enemies.remove(j);
                    enemySpeeds.remove(j);  // Elimina la velocidad del enemigo eliminado
                    break;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shoot = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders");
        kami game = new kami();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
