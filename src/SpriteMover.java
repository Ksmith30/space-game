public class SpriteMover implements Runnable {
    private Model model;
    private View view;

    public SpriteMover(Model m, View v) {
        model = m;
        view = v;
    }

    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            model.updateScene(view.getWidth(), view.getHeight(), 0);
            view.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

}
