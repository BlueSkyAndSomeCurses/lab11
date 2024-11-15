package ua.edu.ucu.apps.task3;

public class ProxyImage implements MyImage {
  private RealImage realImage;
  private String filename;

  public ProxyImage(String filename) {
    this.filename = filename;
    this.realImage = null;
  }

  @Override
  public void display() {
    if (realImage == null) {
      realImage = new RealImage(filename);
    }
    realImage.display();
  }
}
