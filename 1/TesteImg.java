import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TesteImg extends JPanel {
  private BufferedImage imagem;

  public TesteImg() {
    try {
      imagem = ImageIO.read(new File("img/4001.jpg"));
    } catch (IOException e) {
      System.out.println("Erro ao carregar a imagem. \nContate nosso suporte tecnico para que consigamos resolver!");
      e.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (imagem != null) {
      g.drawImage(imagem, 0, 0, this);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exibir Imagem");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    TesteImg painelImagem = new TesteImg();

    frame.setSize(400, 400);

    frame.add(painelImagem);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
